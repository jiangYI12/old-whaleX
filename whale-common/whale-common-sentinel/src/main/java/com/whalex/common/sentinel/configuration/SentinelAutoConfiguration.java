package com.whalex.common.sentinel.configuration;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.sentinel.handler.WhalexUrlBlockHandler;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 自动装配
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/30 10:22
 */
@Configuration
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class SentinelAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WhalexUrlBlockHandler whalexUrlBlockHandler(){
        return new WhalexUrlBlockHandler();
    }
}
