package com.whalex.usercentre;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import com.whalex.common.fegin.annotation.EnableWhalexFeign;

@EnableWhalexFeign
//标识资源服务器
@EnableResourceServer
//激活方法上的Preauthorize 注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringCloudApplication
public class WhaleUserCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleUserCentreApplication.class, args);
    }

}
