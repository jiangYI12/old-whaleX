package com.whalex.system.config;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.whalex.system.service.ISysRouteConfService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.Async;
import whale.common.gateway.redisKeys.GatewaysKeys;
import whale.common.gateway.support.DynamicRouteInitEvent;
import whale.common.gateway.vo.RouteDefinitionVo;

import java.net.URI;

/**
 * @description: 路由初始化配置
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 **/

@Slf4j
@Configuration
@AllArgsConstructor
public class RouteInitConfig {

    private final RedisTemplate redisTemplate;

    private final ISysRouteConfService iSysRouteConfService;

    //容器初始化时会调用
    @Async
    @Order
    @EventListener({WebServerInitializedEvent.class, DynamicRouteInitEvent.class})
    public void initRoute(){
        //初始化前删除缓存
        Boolean result = redisTemplate.delete(GatewaysKeys.GATEWAY_ROUTE_KEYS);
        log.info("初始化网关路由 {} ", result);
        iSysRouteConfService.list().forEach(sysRouteConf -> {
            RouteDefinitionVo vo = new RouteDefinitionVo();
            vo.setRouteName(sysRouteConf.getRouteName());
            vo.setId(sysRouteConf.getRouteId());
            vo.setUri(URI.create(sysRouteConf.getUri()));
            vo.setOrder(sysRouteConf.getOrderNum());
            //加载过滤器
            JSONArray filterObj = JSONUtil.parseArray(sysRouteConf.getFilters());
            vo.setFilters(filterObj.toList(FilterDefinition.class));
            //加载断言
            JSONArray predicateObj = JSONUtil.parseArray(sysRouteConf.getPredicates());
            vo.setPredicates(predicateObj.toList(PredicateDefinition.class));

            log.info("加载路由ID：{},{}", sysRouteConf.getRouteId(), vo);
            //改变redis序列化
            redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(RouteDefinitionVo.class));
            redisTemplate.opsForHash().put(GatewaysKeys.GATEWAY_ROUTE_KEYS, sysRouteConf.getRouteId(), vo);
        });
    }

    /**
     * redis 监听配置,监听 gateway_redis_route_reload_topic,重新加载Redis
     *
     * @param redisConnectionFactory redis 配置
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory) {
        //创建redis消息订阅
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        //匿名内部类创建消息消费者
        container.addMessageListener((message, bytes) -> {
            log.warn("接收到重新Redis 重新加载路由事件");
            initRoute();
        }, new ChannelTopic(GatewaysKeys.ROUTE_REDIS_RELOAD_TOPIC));
        return container;
    }
}
