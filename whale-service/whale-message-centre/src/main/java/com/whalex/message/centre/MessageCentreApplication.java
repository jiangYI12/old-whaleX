package com.whalex.message.centre;

import com.whalex.common.fegin.annotation.EnableWhalexFeign;
import com.whalex.message.centre.api.payInPutChannel.PayInPutChannel;
import com.whalex.message.centre.api.payOutPutChannel.PayOutPutChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


//标识资源服务器
@EnableResourceServer
//激活方法上的Preauthorize 注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringCloudApplication
@EnableWhalexFeign
public class MessageCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageCentreApplication.class, args);
    }

}
