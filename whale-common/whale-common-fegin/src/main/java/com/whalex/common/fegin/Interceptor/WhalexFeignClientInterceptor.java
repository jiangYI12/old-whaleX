package com.whalex.common.fegin.Interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/5 13:23
 */
public class WhalexFeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpHeaders headers = WhalexHttpHeadersContextHolder.toHeaders();
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, values) -> {
                values.forEach(value -> requestTemplate.header(key, value));
            });
        }
    }

}
