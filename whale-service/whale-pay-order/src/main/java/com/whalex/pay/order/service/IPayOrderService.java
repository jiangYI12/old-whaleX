package com.whalex.pay.order.service;

import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.whalex.pay.api.entity.PayTest;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 21:23
 */
public interface IPayOrderService {

    String payPreCreate(PayTest payTest);

    String payCreatePage(PayTest payTest);

    AlipayTradeRefundResponse refund(PayTest payTest);

    String downLoadBillURL(PayTest payTest);
}
