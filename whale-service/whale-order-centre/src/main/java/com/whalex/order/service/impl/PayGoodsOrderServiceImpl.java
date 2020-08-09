package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.mapper.PayGoodsOrderMapper;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayGoodsOrderServiceImpl  extends ServiceImpl<PayGoodsOrderMapper,PayGoodsOrder> implements IPayGoodsOrderService {

}