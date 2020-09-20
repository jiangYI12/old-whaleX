package com.whalex.pay.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.pay.api.entity.PayTradeOrder;

public interface IPayTradeOrderService extends IService<PayTradeOrder> {
    Boolean createOrder(PayTradeOrder payTradeOrder);
    Boolean updatePayTradeOrderById(PayTradeOrder payTradeOrder);
}