package com.whalex.common.core.annotation;

import java.lang.annotation.*;

/**
 * Description: 注解获取用户信息
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/19 22:16
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GetUserInfo {
}
