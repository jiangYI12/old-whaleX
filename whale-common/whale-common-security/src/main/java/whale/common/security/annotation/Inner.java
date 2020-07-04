package whale.common.security.annotation;

import java.lang.annotation.*;

/**
 * 内部使用注解不需要token即可访问接口
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {
    /**
     * 是否AOP统一处理
     * @return false, true
     */
    boolean value() default true;

    /**
     * 需要特殊判空的字段(预留)
     * @return {}
     */
    String[] field() default {};
}
