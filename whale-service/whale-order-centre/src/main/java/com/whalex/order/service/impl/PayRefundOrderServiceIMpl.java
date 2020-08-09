package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.order.api.entity.PayRefundOrder;
import com.whalex.order.mapper.PayRefundOrderMapper;
import com.whalex.order.service.IPayRefundOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayRefundOrderServiceIMpl extends ServiceImpl<PayRefundOrderMapper,PayRefundOrder> implements IPayRefundOrderService {

}