package com.whalex.order.api.fegin;

import com.whalex.common.core.constant.SysServiceConstant;
import com.whalex.common.fegin.constant.FeginClientURL;
import com.whalex.order.api.entity.PayGoodsOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/5 12:24
 */
@FeignClient(value = SysServiceConstant.WHALE_ORDER_CENTRE)
public interface IPayGoodsOrderFegin {

    String PREFIX =  FeginClientURL.PREFIX + "/payGoodsOrder";
    String UPDATE_GOOD_ORDER_BY_ID = PREFIX + "/updateGoodOrderById";

    @PostMapping(UPDATE_GOOD_ORDER_BY_ID)
    Boolean updateGoodOrderById(@RequestBody PayGoodsOrder payGoodsOrder);

}
