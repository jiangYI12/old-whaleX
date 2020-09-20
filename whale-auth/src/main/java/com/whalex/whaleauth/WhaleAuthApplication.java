package com.whalex.whaleauth;

import com.whalex.common.swagger.annotation.EnableWhalexSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import com.whalex.common.fegin.annotation.EnableWhalexFeign;

@EnableWhalexFeign
@SpringCloudApplication
@EnableWhalexSwagger2
public class WhaleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleAuthApplication.class, args);
    }

}
