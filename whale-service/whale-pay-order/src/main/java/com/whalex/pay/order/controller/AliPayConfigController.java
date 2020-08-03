package com.whalex.pay.order.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.security.annotation.Inner;
import com.whalex.pay.api.entity.PayTest;
import com.whalex.pay.order.service.IPayOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description: 支付配置
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 20:47
 */
@AllArgsConstructor
@RestController
@RequestMapping("/payOrder")
public class AliPayConfigController {

    private IPayOrderService iPayOrderService;

    @Inner
    @RequestMapping("/createPay")
    public R<String> createPay(@RequestBody PayTest payTest){
        return R.data(iPayOrderService.payPreCreate(payTest));
    }

    @Inner
    @RequestMapping("/createPage")
    public R<String> createPage(@RequestBody PayTest payTest){
        return R.data(iPayOrderService.payCreatePage(payTest));
    }

    @Inner
    @RequestMapping("/refund")
    public R<AlipayTradeRefundResponse> refund(@RequestBody PayTest payTest){
        return R.data(iPayOrderService.refund(payTest));
    }

    @Inner
    @RequestMapping("/downLoadBillURL")
    public R<String> downLoadBillURL(@RequestBody PayTest payTest){
        return R.data(iPayOrderService.downLoadBillURL(payTest));
    }

    @Inner
    @RequestMapping("/callBack")
    public String callBack(HttpServletRequest request, HttpServletResponse response){
        // 解析回调信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        String payrs = JSON.toJSONString(requestParams);
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            params.put(name, valueStr);
        }
        try {
            Factory.Payment.Common().verifyNotify(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(payrs);
        //返回success代表回调成功
        return "success";
    }
}
