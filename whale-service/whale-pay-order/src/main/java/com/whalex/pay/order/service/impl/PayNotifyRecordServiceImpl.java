package com.whalex.pay.order.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.pay.api.entity.PayNotifyRecord;
import com.whalex.pay.order.mapper.PayNotifyRecordMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PayNotifyRecordServiceImpl extends ServiceImpl<PayNotifyRecordMapper, PayNotifyRecord> implements IService<PayNotifyRecord> {

}