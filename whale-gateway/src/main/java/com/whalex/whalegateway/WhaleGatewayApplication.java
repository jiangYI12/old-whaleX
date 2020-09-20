package com.whalex.whalegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;


@SpringCloudApplication
public class WhaleGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleGatewayApplication.class, args);
    }

}
