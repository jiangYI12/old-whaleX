package com.whalex.whaleauth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import com.whalex.common.fegin.annotation.EnableWhalexFeign;

@EnableWhalexFeign
@SpringCloudApplication
@EnableAuthorizationServer
public class WhaleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleAuthApplication.class, args);
    }

}
