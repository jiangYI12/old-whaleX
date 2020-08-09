package com.whalex.order.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.whalex.common.mybatisPlus.entity.TenantEntity;
import lombok.Data;

/**
 * @description: 支付订单表
 * @author: 🐋鲸鱼
 * @date: 2020/8/8
 */
@Data
@TableName("pay_trade_order")
public class PayTradeOrder extends TenantEntity {
    private String orderId;

    private String channelId;

    private String amount;

    private String currency;

    /**
     * 支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
     */
    private Boolean status;

    private String clientIp;

    private String device;

    private String subject;

    private String body;

    private String extra;

    private String channelMchId;

    private String channelOrderNo;

    private String errCode;

    private String errMsg;

    private String param1;

    private String param2;

    private String notifyUrl;

    /**
     * 通知次数
     */
    private Byte notifyCount;

    /**
     * 最后一次通知时间
     */
    private Long lastNotifyTime;

    /**
     * 订单失效时间
     */
    private Long expireTime;

    /**
     * 订单支付成功时间
     */
    private Long paySuccTime;


    private static final long serialVersionUID = 1L;
}