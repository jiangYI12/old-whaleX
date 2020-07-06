package com.whalex.system.config;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

/**
 * 初始化路由
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RouteInitConfig {

    private final RedisTemplate redisTemplate;

    @Async
    @Order
    public void initRoute(){

    }
}
