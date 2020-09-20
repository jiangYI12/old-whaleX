package com.whalex.pay.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.whalex.common.mybatisPlus.entity.TenantEntity;
import lombok.Data;

/**
 * @description: 通知记录日志表
 * @author: 🐋鲸鱼
 * @date: 2020/8/8
 */
@Data
@TableName("pay_notify_record")
public class PayNotifyRecord extends TenantEntity {

    private String notifyId;

    private String request;

    private String response;

    private String orderNo;

    private String httpStatus;


    private static final long serialVersionUID = 1L;
}