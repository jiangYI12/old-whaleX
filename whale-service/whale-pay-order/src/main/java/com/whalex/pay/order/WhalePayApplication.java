package com.whalex.pay.order;

import com.whalex.common.fegin.annotation.EnableWhalexFeign;
import com.whalex.common.mybatisPlus.annotation.EnableDynamicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


//标识资源服务器
@EnableResourceServer
//激活方法上的Preauthorize 注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringCloudApplication
@EnableWhalexFeign
@EnableDynamicDataSource
public class WhalePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhalePayApplication.class, args);
    }

}
