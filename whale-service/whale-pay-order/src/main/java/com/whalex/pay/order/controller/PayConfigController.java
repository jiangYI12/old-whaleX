package com.whalex.pay.order.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.common.security.annotation.Inner;
import com.whalex.pay.order.service.IPayOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 支付配置
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 20:47
 */
@AllArgsConstructor
@RestController
@RequestMapping("/payOrder")
public class PayConfigController {

    private IPayOrderService iPayOrderService;

    @Inner
    @RequestMapping("/createPay")
    public R<Boolean> createPay(){
        return R.status(iPayOrderService.payPreCreate());
    }

}
