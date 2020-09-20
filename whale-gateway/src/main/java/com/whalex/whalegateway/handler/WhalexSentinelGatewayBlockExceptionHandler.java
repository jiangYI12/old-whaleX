package com.whalex.whalegateway.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Supplier;

/**
 * 自定义网关限流返回
 */
@Slf4j
public class WhalexSentinelGatewayBlockExceptionHandler extends SentinelGatewayBlockExceptionHandler {

    private List<ViewResolver> viewResolvers;

    private List<HttpMessageWriter<?>> messageWriters;

    public WhalexSentinelGatewayBlockExceptionHandler(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
        super(viewResolvers, serverCodecConfigurer);
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        if(exchange.getResponse().isCommitted()){
            return Mono.error(ex);
        }
        if(!BlockException.isBlockException(ex)){
            return Mono.error(ex);
        }
        FlowException flowException = (FlowException)ex;
        log.error("{} 发生流控:流控触发 数量-{}",flowException.getRule().getResource(),flowException.getRule().getCount());
        return handleBlockedRequest(exchange, ex)
                .flatMap(response -> writeResponse(response, exchange));
    }

    private final Supplier<ServerResponse.Context> contextSupplier = () -> new ServerResponse.Context() {
        @Override
        public List<HttpMessageWriter<?>> messageWriters() {
            return WhalexSentinelGatewayBlockExceptionHandler.this.messageWriters;
        }

        @Override
        public List<ViewResolver> viewResolvers() {
            return WhalexSentinelGatewayBlockExceptionHandler.this.viewResolvers;
        }
    };

    private Mono<ServerResponse> handleBlockedRequest(ServerWebExchange exchange, Throwable throwable) {
        return GatewayCallbackManager.getBlockHandler().handleRequest(exchange, throwable);
    }

    private Mono<Void> writeResponse(ServerResponse response, ServerWebExchange exchange) {
        ServerHttpResponse resp = exchange.getResponse();
        resp.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        String json = "{\"code\": 429, \"data\": null, \"msg\": \"系统繁忙,请稍后再试\"}";
        DataBuffer buffer = resp.bufferFactory().wrap(json.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Mono.just(buffer));
    }
}
