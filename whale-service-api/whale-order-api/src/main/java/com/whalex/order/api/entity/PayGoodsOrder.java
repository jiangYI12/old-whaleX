package com.whalex.order.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whalex.common.mybatisPlus.entity.TenantEntity;
import com.whalex.order.api.orderEnum.OrderStatusEnum;
import lombok.Data;

/**
 * @description: 商品订单表
 * @author: 🐋鲸鱼
 * @date: 2020/8/8
 */
@Data
@TableName("pay_goods_order")
public class PayGoodsOrder extends TenantEntity {
    /**
     * 商品订单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsOrderId;

    private String goodsId;

    private String goodsName;

    private String amount;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long payOrderId;

    private OrderStatusEnum orderStatus;

    private static final long serialVersionUID = 1L;
}