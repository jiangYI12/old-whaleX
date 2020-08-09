package com.whalex.message.centre.controller;

import com.whalex.common.security.annotation.Inner;
import com.whalex.message.centre.service.ITestMqService;
import lombok.AllArgsConstructor;
import org.apache.http.client.utils.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/9 20:59
 */
@Inner
@AllArgsConstructor
@RestController
@RequestMapping("/testMqController")
public class TestMqController {

    private ITestMqService iTestMqService;

    @Inner
    @RequestMapping("/sendMsg")
    public void SendMsg(){
        for(int i = 0; i < 20; i ++){
            try {
                iTestMqService.sendMsg();
            } catch (Exception e) {
                System.out.println("--------error-------");
                e.printStackTrace();
            }
        }
    }
}
