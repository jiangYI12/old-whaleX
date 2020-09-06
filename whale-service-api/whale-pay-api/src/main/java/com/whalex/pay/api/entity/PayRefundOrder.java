package com.whalex.pay.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whalex.common.mybatisPlus.entity.TenantEntity;
import lombok.Data;

import java.util.Date;

/**
 * @description: 退款订单表
 * @author: 🐋鲸鱼
 * @date: 2020/8/8
 */
@Data
@TableName("pay_refund_order")
public class PayRefundOrder extends TenantEntity {

    private String refundOrderId;

    private String payOrderId;

    private String channelPayOrderNo;

    private String mchId;

    private String mchRefundNo;

    private String channelId;

    private String payAmount;

    /**
     * 退款金额,单位元
     */
    private Long refundAmount;

    private String currency;

    /**
     * 退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
     */
    private Byte result;

    private String clientIp;

    private String device;

    private String remark;

    private String channelUser;

    private String username;

    private String channelMchId;

    private String channelOrderNo;

    private String channelErrCode;

    private String channelErrMsg;

    private String extra;

    private String notifyurl;

    private String param1;

    private String param2;

    /**
     * 订单失效时间
     */
    private Date expireTime;

    /**
     * 订单退款成功时间
     */
    private Date refundSuccTime;

    private static final long serialVersionUID = 1L;
}