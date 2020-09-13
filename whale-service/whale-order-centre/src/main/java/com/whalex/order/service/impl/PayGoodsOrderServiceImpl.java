package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.redis.redissionUtil.RedissLockUtil;
import com.whalex.message.centre.api.fegin.ICreateOrderMessageFegin;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.mapper.PayGoodsOrderMapper;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class PayGoodsOrderServiceImpl  extends ServiceImpl<PayGoodsOrderMapper,PayGoodsOrder> implements IPayGoodsOrderService {

    private ICreateOrderMessageFegin iCreateOrderMessageFegin;

    private RedissLockUtil redissLockUtil;

    @Override
    public PayGoodsOrder createGoodsOrder(PayGoodsOrder payGoodsOrder) {

        redissLockUtil.lock(payGoodsOrder.getOrderNo());

        Boolean isSuccess = this.saveOrUpdate(payGoodsOrder);

        if(isSuccess){
             //发送死信队列
             iCreateOrderMessageFegin.createOrderSendMsg(String.valueOf(payGoodsOrder.getId()));
        }
        return payGoodsOrder;
    }


    @Override
    @Transactional
    public Boolean updateGoodOrderById(PayGoodsOrder payGoodsOrder) {
        return this.updateById(payGoodsOrder);
    }
}