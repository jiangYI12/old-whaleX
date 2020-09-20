package com.whalex.common.core.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description: 拦截GetUserInfo aop
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/19 22:32
 */
@Aspect
public class GetUserInfoAspect {

    @SneakyThrows
    @Around("@annotation(com.whalex.common.core.annotation.GetUserInfo)")
    public Object GetUserInfoAspect(ProceedingJoinPoint joinPoint){
        return joinPoint.proceed();
    }
}
