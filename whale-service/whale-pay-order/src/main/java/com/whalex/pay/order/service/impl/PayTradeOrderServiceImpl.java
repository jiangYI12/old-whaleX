package com.whalex.pay.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.api.fegin.IPayGoodsOrderFegin;
import com.whalex.order.api.orderEnum.OrderStatusEnum;
import com.whalex.pay.api.entity.PayTradeOrder;
import com.whalex.pay.order.mapper.PayTradeOrderMapper;
import com.whalex.pay.order.service.IPayTradeOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PayTradeOrderServiceImpl extends ServiceImpl<PayTradeOrderMapper, PayTradeOrder> implements IPayTradeOrderService {


    private final IPayGoodsOrderFegin iPayGoodsOrderFegin;

    @Override
    public Boolean createOrder(PayTradeOrder payTradeOrder) {
     return this.save(payTradeOrder);
    }


    @Override
    @Transactional
    @GlobalTransactional
    public Boolean updatePayTradeOrderById(PayTradeOrder payTradeOrder) {
        Boolean isSuccess = this.updateById(payTradeOrder);
        if (isSuccess){
            PayGoodsOrder payGoodsOrder = new PayGoodsOrder();
            payGoodsOrder.setOrderStatus(OrderStatusEnum.PAID.name());
            payGoodsOrder.setId(payTradeOrder.getOrderId());
            isSuccess = iPayGoodsOrderFegin.updateGoodOrderById(payGoodsOrder);
        }
        return isSuccess;
    }


}