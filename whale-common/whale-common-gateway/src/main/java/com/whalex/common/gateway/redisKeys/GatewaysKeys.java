package com.whalex.common.gateway.redisKeys;

public interface GatewaysKeys {
    String GATEWAY_ROUTE_KEYS = "gateway_route_keys";
    /**
     * redis reload 事件
     */
    String ROUTE_REDIS_RELOAD_TOPIC = "gateway_redis_route_reload_topic";

    /**
     * 内存reload 时间
     */
    String ROUTE_JVM_RELOAD_TOPIC = "gateway_jvm_route_reload_topic";
}
