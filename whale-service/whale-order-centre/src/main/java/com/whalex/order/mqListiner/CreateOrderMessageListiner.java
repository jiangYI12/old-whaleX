package com.whalex.order.mqListiner;

import com.whalex.message.centre.api.channel.createOrderChannel.ICreateOrderInPutDlqChannel;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.api.orderEnum.OrderStatusEnum;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;


/**
 * Description: 监听死信队列的消息
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/10 22:08
 */
@Component
@EnableBinding({ICreateOrderInPutDlqChannel.class})
@AllArgsConstructor
public class CreateOrderMessageListiner {

    private final IPayGoodsOrderService iPayGoodsOrderService;

    /**
     * 监听dlq队列的消息
     * @param message
     */
    @SneakyThrows
    @StreamListener(ICreateOrderInPutDlqChannel.INPUT_CHANNEL)
    public void IPayInPutDlqChannel(Message message) {
        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        String orderId = (String)message.getPayload();
        PayGoodsOrder payGoodsOrder = new PayGoodsOrder();
        payGoodsOrder.setId(Long.valueOf(orderId));
        payGoodsOrder.setOrderStatus(OrderStatusEnum.CANCELLED.name());
        Boolean isSuccess = iPayGoodsOrderService.updateGoodOrderById(payGoodsOrder);
        if(isSuccess) {
            channel.basicAck(deliveryTag, false);
        }else{
            channel.basicNack(deliveryTag,false,false);
        }
    }

}
