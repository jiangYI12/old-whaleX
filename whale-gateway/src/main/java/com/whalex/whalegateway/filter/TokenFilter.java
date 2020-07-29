package com.whalex.whalegateway.filter;

import cn.hutool.json.JSONUtil;
import com.whalex.common.core.constant.SecurityConstants;
import com.whalex.common.core.util.AuthUtil;
import com.whalex.common.core.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


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
        //如果不是获取token 并且 请求头中没有 Authorization 就不解析JWT
        if(!request.getPath().toString().equals("/oauth/token")&&request.getHeaders().containsKey(SecurityConstants.AUTHORIZATION)) {
            String jwt = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION).replace(SecurityConstants.TOKEN_PREFIX,"").trim();
            if (StringUtils.isEmpty(jwt)) {
                return chain.filter(exchange);
            }
            try {
                Claims claims = JwtUtil.parseJWT(jwt);
                request.mutate().header(AuthUtil.JWT_PARSE_KEY, JSONUtil.toJsonStr(claims)).build();
                return chain.filter(exchange.mutate().request(request).build());
            } catch (Exception e) {
                throw new RuntimeException("令牌解析失败");
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
