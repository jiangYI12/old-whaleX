package com.whalex.order.api.orderEnum;

/**
 * Description: 订单状态枚举
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/8 17:47
 */
public enum  OrderStatusEnum {

    UNPAID(0,"未支付"),
    PAID(1,"已支付"),
    CANCELLED(2,"取消订单");

    Integer value;

    String message;

    OrderStatusEnum(Integer value,String message){
        this.value = value;
        this.message = message;
    }

}
