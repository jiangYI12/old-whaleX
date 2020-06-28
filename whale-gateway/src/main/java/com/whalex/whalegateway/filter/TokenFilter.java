package com.whalex.whalegateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * Description: 获取刷新token时过滤器
 * @author 🐋鲸鱼
 * date: 2020/6/28 22:07
 */
@Slf4j
@Component
public class TokenFilter extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return chain.filter(exchange);
        };
    }
}
