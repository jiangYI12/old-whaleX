package com.whalex.whaleauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringCloudApplication
@EnableFeignClients
@EnableAuthorizationServer
public class WhaleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleAuthApplication.class, args);
    }

}
