package com.whalex.pay.order.controller;

import com.alipay.easysdk.factory.Factory;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.security.annotation.Inner;
import com.whalex.pay.order.service.IPayOrderService;
import com.whalex.pay.order.util.AliPayUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.List;

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
    public R<String> createPay(){
        return R.data(iPayOrderService.payPreCreate());
    }

    @Inner
    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response){
        // 解析回调信息
        Map<String, String> params = Factory.Util.(request);
    }
}
