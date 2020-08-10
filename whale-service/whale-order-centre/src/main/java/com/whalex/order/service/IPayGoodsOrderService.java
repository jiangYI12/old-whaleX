package com.whalex.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.order.api.entity.PayGoodsOrder;

public interface IPayGoodsOrderService extends IService<PayGoodsOrder> {
    PayGoodsOrder createGoodsOrder(PayGoodsOrder payGoodsOrder);

    Boolean updateGoodOrderById(PayGoodsOrder payGoodsOrder);
}