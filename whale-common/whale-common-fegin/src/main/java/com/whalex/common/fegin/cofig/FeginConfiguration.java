package com.whalex.common.fegin.cofig;

import com.whalex.common.fegin.Interceptor.WhalexFeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/6 11:59
 */
@Configuration
@AutoConfigureAfter(EnableFeignClients.class)
public class FeginConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new WhalexFeignClientInterceptor();
    }
}
