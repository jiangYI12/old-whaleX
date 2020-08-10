package com.whalex.message.centre.service.impl;

import com.whalex.message.centre.api.channel.createOrderChannel.ICreateOrderOutPutChannel;
import com.whalex.message.centre.api.constant.MqConstant;
import com.whalex.message.centre.service.ICreateOrderMessageService;
import com.whalex.order.api.entity.PayTradeOrder;
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
 * date: 2020/8/10 20:28
 */
@Service
@AllArgsConstructor
@EnableBinding({ICreateOrderOutPutChannel.class})
public class CreateOrderMessageServiceImpl implements ICreateOrderMessageService {

    private ICreateOrderOutPutChannel iCreateOrderOutPutChannel;

    @Override
    public Boolean createOrderSendMsg(String id) {
        Map map = new HashMap();
        map.put(MqConstant.X_MESSAGE_TTL,ICreateOrderOutPutChannel.CREATE_ORDER_X_MESSAGE_TTL_VALUE);
        map.put(MqConstant.X_DEAD_LETTER_ROUTING_KEY,ICreateOrderOutPutChannel.CREATE_ORDER_X_DEAD_LETTER_ROUTING_KEY_VALUE);
        map.put(MqConstant.X_DEAD_LETTER_EXCHANGE,ICreateOrderOutPutChannel.CREATE_ORDER_X_DEAD_LETTER_EXCHANGE_VALUE);
        MessageHeaders mhs = new MessageHeaders(map);
        String value = String.valueOf(id);
        Message msg = MessageBuilder.createMessage(value, mhs);
        Boolean sendStatus = iCreateOrderOutPutChannel.createOrderOutPutChannel().send(msg);

        return sendStatus;
    }

}
