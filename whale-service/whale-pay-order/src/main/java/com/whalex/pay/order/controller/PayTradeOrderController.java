package com.whalex.pay.order.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.pay.api.entity.PayTradeOrder;
import com.whalex.pay.order.service.IPayTradeOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 支付订单
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/5 11:55
 */
@AllArgsConstructor
@RestController
@RequestMapping("/payTradeOrder")
public class PayTradeOrderController {

    private IPayTradeOrderService iPayTradeOrderService;

    @RequestMapping("/updatePayTradeOrderById")
    public R<Boolean> updatePayTradeOrderById(@RequestBody PayTradeOrder payTradeOrder){
        return R.status(iPayTradeOrderService.updatePayTradeOrderById(payTradeOrder));
    }
}
