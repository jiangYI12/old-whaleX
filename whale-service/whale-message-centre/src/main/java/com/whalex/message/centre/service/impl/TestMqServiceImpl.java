package com.whalex.message.centre.service.impl;

import com.whalex.message.centre.api.payOutPutChannel.IPayOutPutChannel;
import com.whalex.message.centre.service.ITestMqService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/9 21:02
 */
@Service
@AllArgsConstructor
@EnableBinding(value = {IPayOutPutChannel.class})
public class TestMqServiceImpl implements ITestMqService {

    private IPayOutPutChannel iPayOutPutChannel;

    @Override
    public void sendMsg() {
        try{
            Map map = new HashMap();
            map.put("x-message-ttl",1000);
            map.put("x-dead-letter-routing-key","pay_channel.pay-queue");
            map.put("x-dead-letter-exchange","DLX");
            MessageHeaders mhs = new MessageHeaders(map);
            String value = String.valueOf(Math.random());
            Message msg = MessageBuilder.createMessage(value, mhs);
            boolean sendStatus = iPayOutPutChannel.payOutPutChannel().send(msg);
            System.err.println("--------------sending -------------------");
            System.out.println("发送数据：" + value + ",sendStatus: " + sendStatus);
        }catch (Exception e){
            System.err.println("-------------error-------------");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
