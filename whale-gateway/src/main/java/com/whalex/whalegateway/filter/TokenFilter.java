package com.whalex.whalegateway.filter;

import cn.hutool.core.collection.CollectionUtil;
import com.whalex.common.core.constant.SecurityConstants;
import com.whalex.common.core.util.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Description: 获取刷新token时过滤器
 * @author 🐋鲸鱼
 * date: 2020/6/28 22:07
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter,Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String jwt = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION);
        if(StringUtils.isEmpty(jwt)){
            return chain.filter(exchange);
        }
        try {
            Claims claims = JWTUtil.parseJWT(jwt);
        }catch (Exception e){
            throw new RuntimeException("令牌解析失败");
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 9999;
    }

}
