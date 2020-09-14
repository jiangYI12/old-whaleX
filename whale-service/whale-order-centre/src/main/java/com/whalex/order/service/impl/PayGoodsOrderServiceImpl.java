package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.redission.redissionUtil.RedissLockUtil;
import com.whalex.message.centre.api.fegin.ICreateOrderMessageFegin;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.mapper.PayGoodsOrderMapper;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@Slf4j
public class PayGoodsOrderServiceImpl  extends ServiceImpl<PayGoodsOrderMapper,PayGoodsOrder> implements IPayGoodsOrderService {

    private ICreateOrderMessageFegin iCreateOrderMessageFegin;

    private RedissLockUtil redissLockUtil;

    @Override
    public PayGoodsOrder createGoodsOrder(PayGoodsOrder payGoodsOrder) {
        Boolean isSuccess = false;
        log.info("获取锁");
        redissLockUtil.lock(payGoodsOrder.getOrderNo());
        try {
            Thread.sleep(3000);
            isSuccess = this.saveOrUpdate(payGoodsOrder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            redissLockUtil.unlock(payGoodsOrder.getOrderNo());
            log.info("释放锁");
        }
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