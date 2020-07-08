package whale.common.core.annotation;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/8 22:35
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan("whale.common.**")
public @interface ScanCommon {
}
