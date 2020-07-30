package com.whalex.pay.order.service.impl;

import com.whalex.pay.order.service.IPayOrderService;
import com.whalex.pay.order.util.AliPayUtil;
import org.springframework.stereotype.Service;

/**
 * Description: 支付订单
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 21:23
 */
@Service
public class PayOrderServiceImpl implements IPayOrderService {

    @Override
    public String payPreCreate() {
        return AliPayUtil.createOrder();
    }

}
