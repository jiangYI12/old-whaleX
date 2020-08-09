package com.whalex.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.order.api.entity.PayTradeOrder;

public interface IPayTradeOrderService extends IService<PayTradeOrder> {
    PayTradeOrder createOrder(PayTradeOrder payTradeOrder);
}