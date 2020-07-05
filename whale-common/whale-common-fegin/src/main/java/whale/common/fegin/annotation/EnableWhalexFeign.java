package whale.common.fegin.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * Description: 配置扫描fegin位置
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/5 21:55
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableFeignClients({"com.whalex"})
public @interface EnableWhalexFeign {
}
