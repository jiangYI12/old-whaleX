package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.message.centre.api.payOutPutChannel.IPayOutPutChannel;
import com.whalex.order.api.entity.PayTradeOrder;
import com.whalex.order.mapper.PayTradeOrderMapper;
import com.whalex.order.service.IPayTradeOrderService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PayTradeOrderServiceImpl extends ServiceImpl<PayTradeOrderMapper,PayTradeOrder> implements IPayTradeOrderService {

    private final IPayOutPutChannel iPayOutPutChannel;

    @Override
    public PayTradeOrder createOrder(PayTradeOrder payTradeOrder) {
       Boolean isSuccess = this.saveOrUpdate(payTradeOrder);
       if(isSuccess){
           Map map = new HashMap();
           MessageHeaders mhs = new MessageHeaders(map);
           Message msg = MessageBuilder.createMessage(String.valueOf(payTradeOrder.getId()), mhs);
           Boolean b = iPayOutPutChannel.payOutPutChannel().send(msg);
           //TODO 发送失败需要入库,等待定时任务重新发送
       }
        return payTradeOrder;
    }
}