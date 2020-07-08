package com.whalex.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import whale.common.core.annotation.ScanCommon;
import whale.common.fegin.annotation.EnableWhalexFeign;


//标识资源服务器
@EnableResourceServer
//激活方法上的Preauthorize 注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWhalexFeign
@SpringCloudApplication
@ScanCommon
public class WhaleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleSystemApplication.class, args);
    }

}
