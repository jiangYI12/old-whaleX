package com.whalex.common.mybatisPlus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: nybatisPlus配置类
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/21 20:02
 */
@Configuration
public class MybatisPlusConfiguration {

    //开启mybatis 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
