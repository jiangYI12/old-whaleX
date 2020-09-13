package com.whalex.admin_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@EnableAdminServer
public class WhaleAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleAdminServerApplication.class, args);
    }

}
