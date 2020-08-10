package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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



    @Override
    public PayTradeOrder createOrder(PayTradeOrder payTradeOrder) {
     return null;
    }


}