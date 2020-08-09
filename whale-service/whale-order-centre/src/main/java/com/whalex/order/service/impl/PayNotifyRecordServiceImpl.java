package com.whalex.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.order.api.entity.PayNotifyRecord;
import com.whalex.order.mapper.PayNotifyRecordMapper;
import com.whalex.order.service.IPayNotifyRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PayNotifyRecordServiceImpl extends ServiceImpl<PayNotifyRecordMapper,PayNotifyRecord> implements IPayNotifyRecordService {

}