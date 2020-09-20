package com.whalex.pay.order.service.impl;

import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.whalex.pay.api.entity.PayTest;
import com.whalex.pay.order.service.IPayOrderService;
import com.whalex.pay.order.util.AliPayUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * Description: 支付订单
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 21:23
 */
@Service
public class PayOrderServiceImpl implements IPayOrderService {

    @Override
    public String payPreCreate(PayTest payTest) {
        return AliPayUtil.createOrder(payTest);
    }

    @SneakyThrows
    @Override
    public String payCreatePage(PayTest payTest) {
        return AliPayUtil.createPage(payTest);
    }

    @SneakyThrows
    @Override
    public AlipayTradeRefundResponse refund(PayTest payTest) {
        return AliPayUtil.refund(payTest);
    }

    //下载对账单地址
    @Override
    public String downLoadBillURL(PayTest payTest) {
        return AliPayUtil.downloadBill(payTest);
    }

}
