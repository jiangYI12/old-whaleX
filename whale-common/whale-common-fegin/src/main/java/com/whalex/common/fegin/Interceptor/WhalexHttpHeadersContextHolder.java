package com.whalex.common.fegin.Interceptor;

import com.whalex.common.tool.webUtil.WebUtils;
import feign.RequestTemplate;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * Description: restTemplate fegin 传递请求头
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/6 11:32
 */
public class WhalexHttpHeadersContextHolder {

    private static final ThreadLocal<HttpHeaders> HTTP_HEADERS_HOLDER = new NamedThreadLocal<>("whalex HttpHeaders");

    private static final String pattern = "WHALEX*";

    /**
     * 请求和转发的ip
     */
    private static final String[] ALLOW_HEADS = new String[]{
            "X-Real-IP", "x-forwarded-for", "authorization", "Authorization"
    };

    static void set(HttpHeaders httpHeaders) {
        HTTP_HEADERS_HOLDER.set(httpHeaders);
    }

    @Nullable
    public static HttpHeaders get() {
        return HTTP_HEADERS_HOLDER.get();
    }

    static void remove() {
        HTTP_HEADERS_HOLDER.remove();
    }

    @Nullable
    public static HttpHeaders toHeaders() {
        HttpServletRequest request = WebUtils.getRequest();
        if (request == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        List<String> allowHeadsList = new ArrayList<>(Arrays.asList(ALLOW_HEADS));
        // 传递请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            List<String> allowed = CollectionUtils.arrayToList(ALLOW_HEADS);
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                // 只支持配置的 header
                if (allowHeadsList.contains(key) || allowed.contains(key) || PatternMatchUtils.simpleMatch(pattern, key)) {
                    String values = request.getHeader(key);
                    // header value 不为空的 传递
                    if (!StringUtils.isEmpty(values)) {
                        headers.add(key, values);
                    }
                }

            }
        }
        return headers.isEmpty() ? null : headers;
    }
}
