package com.whalex.common.security.config;

import cn.hutool.core.util.ReUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.whalex.common.security.annotation.Inner;

import java.util.*;
import java.util.regex.Pattern;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WhaleXIgnorPermissionsUrls implements InitializingBean {

    private final WebApplicationContext applicationContext;
    //替换掉 路径{}的占位符
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    @Getter
    @Setter
    private Set<String> ignoreUrls = new LinkedHashSet<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取所有requestmapping
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.forEach((info,method)->{
            //获取controller的url
            Inner controllerInner = method.getBeanType().getAnnotation(Inner.class);
            if(!Objects.isNull(controllerInner)){
                RequestMapping requestMapping = method.getBeanType().getAnnotation(RequestMapping.class);
                for(String url:requestMapping.value()){
                    int last = url.lastIndexOf("/");
                    if(Integer.valueOf(url.length()).equals(last)){
                        String newUrl = url.substring(0,last-1) + "/**";
                        if(ignoreUrls.contains(newUrl)){
                            break;
                        };
                        ignoreUrls.add(newUrl);
                    }
                }
            }

            //获取所有inner的方法url
            Inner methodInner = method.getMethod().getAnnotation(Inner.class);
            Optional.ofNullable(methodInner).ifPresent(inner-> {
                  info.getPatternsCondition().getPatterns().forEach(url->ignoreUrls.add(ReUtil.replaceAll(url, PATTERN, "*")));
               }
            );
        });

    }
}
