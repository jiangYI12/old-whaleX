package com.whalex.search.api.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whalex.common.mybatisPlus.entity.TenantEntity;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @description: 商品订单表
 * @author: 🐋鲸鱼
 * @date: 2020/8/8
 */
@Data
@Document(indexName = "pay_goods_order")
public class PayGoodsOrderSearch extends TenantEntity {
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

    private String orderStatus;

    private List<PayGoodsOrderSuggest> suggest;

    private static final long serialVersionUID = 1L;
}