package com.whalex.common.sentinel.configuration;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.whalex.common.sentinel.fegin.WhalexSentinelFeign;
import com.whalex.common.sentinel.handler.WhalexUrlBlockHandler;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

/**
 * Description: 自动装配
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/30 10:22
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class SentinelAutoConfiguration {


    @Bean
    @Scope("prototype")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    public Feign.Builder feignSentinelBuilder() {
        return WhalexSentinelFeign.builder();
    }

    @Bean
    @ConditionalOnMissingBean
    public WhalexUrlBlockHandler whalexUrlBlockHandler(){
        return new WhalexUrlBlockHandler();
    }
}
