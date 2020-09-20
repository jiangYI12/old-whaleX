package com.whalex.order.feginClient;

import com.whalex.order.api.entity.PayGoodsOrder;
import com.whalex.order.api.fegin.IPayGoodsOrderFegin;
import com.whalex.order.service.IPayGoodsOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/5 12:28
 */
@RestController
@AllArgsConstructor
public class PayGoodsOrderClient implements IPayGoodsOrderFegin {

    private IPayGoodsOrderService iPayGoodsOrderService;

    @PostMapping(UPDATE_GOOD_ORDER_BY_ID)
    @Override
    public Boolean updateGoodOrderById(@RequestBody PayGoodsOrder payGoodsOrder) {
        return iPayGoodsOrderService.updateGoodOrderById(payGoodsOrder);
    }
}
