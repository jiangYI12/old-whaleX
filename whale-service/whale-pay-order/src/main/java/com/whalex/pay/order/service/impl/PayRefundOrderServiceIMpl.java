package com.whalex.pay.order.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.pay.api.entity.PayRefundOrder;
import com.whalex.pay.order.mapper.PayRefundOrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayRefundOrderServiceIMpl extends ServiceImpl<PayRefundOrderMapper, PayRefundOrder> implements IService<PayRefundOrder> {

}