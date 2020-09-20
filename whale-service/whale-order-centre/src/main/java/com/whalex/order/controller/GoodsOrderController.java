package com.whalex.order.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 创建订单
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/8 22:30
 */
@RestController
@RequestMapping("/goodsOrder")
@AllArgsConstructor
public class GoodsOrderController {

    private IPayGoodsOrderService iPayGoodsOrderService;

    @RequestMapping("/createOrder")
    public R<PayGoodsOrder> createOrder(@RequestBody PayGoodsOrder payGoodsOrder){
        return R.data(iPayGoodsOrderService.createGoodsOrder(payGoodsOrder));
    }
}
