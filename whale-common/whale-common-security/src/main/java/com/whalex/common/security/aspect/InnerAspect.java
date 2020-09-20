package com.whalex.common.security.aspect;

import cn.hutool.core.util.StrUtil;
import com.whalex.common.security.constant.TokenConstant;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import com.whalex.common.security.annotation.Inner;

import javax.servlet.http.HttpServletRequest;


/**
 * 拦截所有inner注解,判断是否又带特定的标识,没有则不是程序信任的请求
 */
@Slf4j
@Aspect
@AllArgsConstructor
public class InnerAspect {

    private final HttpServletRequest request;

    @SneakyThrows
    @Around("@annotation(inner)")
    public Object around(ProceedingJoinPoint point, Inner inner) {
        String header = request.getHeader(TokenConstant.INNER);
        if (inner.value() && !StrUtil.equals(TokenConstant.INNER_VALUE, header)) {
            log.warn("访问接口 {} 没有权限", point.getSignature().getName());
            throw new AccessDeniedException("Access is denied");
        }
        return point.proceed();
    }
}
