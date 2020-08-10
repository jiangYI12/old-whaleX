package com.whalex.message.centre.listiner;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/5 21:52
 */
@Slf4j
@Deprecated
//@Component
//@EnableBinding(value = {IPayInPutChannel.class,IPayInPutDlqChannel.class})
public class PayTestListiner {

    /**
     * 通过 MyProcessor.MESSAGE_INPUT 接收消息
     * 然后通过 SendTo 将处理后的消息发送到 MyProcessor.LOG_FORMAT_OUTPUT
     * @param message
     * @return
     */
//    @StreamListener(MyProcessor.MESSAGE_INPUT)
//    @SendTo(MyProcessor.LOG_FORMAT_OUTPUT)
//    public String processLogMessage(String message) {
//        log.info("接收到原始消息：" + message);
//        return "「" + message +"」";
//    }

    /**
     * 监听dlq队列的消息
     * @param message
     */
//    @SneakyThrows
//    @StreamListener(IPayInPutDlqChannel.INPUT_CHANNEL)
//    public void IPayInPutDlqChannel(Message message) {
//        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
//        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        System.out.println("Input Stream 1 接受数据：" + deliveryTag);
//        System.out.println("消费完毕DLQ------------");
//        channel.basicNack(deliveryTag, false,false);
//    }

    /**
     * 监听正常队列
     * @param message
     */
//    @SneakyThrows
//    @StreamListener(IPayInPutChannel.INPUT_CHANNEL)
//    public void IPayInPutChannel(Message message) {
//        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
//        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        System.out.println("Input Stream 2 接受数据：" + deliveryTag);
//        System.out.println("消费完毕------------");
//        channel.basicNack(deliveryTag, false,false);
//    }
}
