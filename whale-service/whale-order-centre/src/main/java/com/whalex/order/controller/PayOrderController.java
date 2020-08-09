package com.whalex.order.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.order.api.entity.PayTradeOrder;
import com.whalex.order.service.IPayTradeOrderService;
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
@RequestMapping("/payOrder")
@AllArgsConstructor
public class PayOrderController {

    private IPayTradeOrderService iPayTradeOrderService;


    @RequestMapping("/createOrder")
    public R<PayTradeOrder> createOrder(@RequestBody PayTradeOrder payTradeOrder){
        return R.data(iPayTradeOrderService.createOrder(payTradeOrder));
    }
}
