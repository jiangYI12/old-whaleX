package com.whalex.message.centre.api.channel.createOrderChannel;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Description: 发送消息通道
 * @author: 🐋鲸鱼
 * date: 2020/8/2 19:20
 */

@Component
public interface ICreateOrderOutPutChannel {

    String OUTPUT_CHANNEL = "create_order_output_channel";


    /**
     * 创建订单过期时间
     */
    Integer CREATE_ORDER_X_MESSAGE_TTL_VALUE = 60000;

    String CREATE_ORDER_X_DEAD_LETTER_ROUTING_KEY_VALUE = "pay_channel.pay-queue";

    String CREATE_ORDER_X_DEAD_LETTER_EXCHANGE_VALUE  = "DLX";

    @Output(ICreateOrderOutPutChannel.OUTPUT_CHANNEL)
    MessageChannel createOrderOutPutChannel();

}
