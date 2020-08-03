package com.whalex.message.centre.api.payChannel;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Description:
 * 这里的PayChannel接口是定义来作为后面类的参数，这一接口定义来通道类型和通道名称。
 * 通道名称是作为配置用，通道类型则决定了app会使用这一通道进行发送消息还是从中接收消息。
 * @author: 🐋鲸鱼
 * date: 2020/8/2 19:20
 */

public interface PayChannel {

    String OUTPUT_CHANNEL = "pay_output_channel";

    String INPUT_CHANNEL = "pay_input_channel";

    @Output(PayChannel.OUTPUT_CHANNEL)
    MessageChannel payOutPutChannel();

    /**
     * 输入通道定义
     *
     * @return SubscribableChannel
     */
    @Input(PayChannel.INPUT_CHANNEL)
    SubscribableChannel payInputChnnel();

}
