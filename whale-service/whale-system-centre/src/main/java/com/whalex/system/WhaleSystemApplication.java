package com.whalex.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import whale.common.fegin.annotation.EnableWhalexFeign;


//标识资源服务器
@EnableResourceServer
//激活方法上的Preauthorize 注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWhalexFeign
@SpringBootApplication
public class WhaleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleSystemApplication.class, args);
    }

}
