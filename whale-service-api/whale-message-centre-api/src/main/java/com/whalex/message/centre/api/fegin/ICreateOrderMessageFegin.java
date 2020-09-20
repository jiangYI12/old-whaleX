package com.whalex.message.centre.api.fegin;

import com.whalex.common.core.constant.SysServiceConstant;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.fegin.constant.FeginClientURL;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/10 20:52
 */
@FeignClient(value = SysServiceConstant.WHALE_MESSAGE_CENTRE)
public interface ICreateOrderMessageFegin {

    String PREFIX =  FeginClientURL.PREFIX + "/createOrderMessage";

    String CREATE_ORDER_SEND_MSG = PREFIX + "/createOrderSendMsg";

    @GetMapping(CREATE_ORDER_SEND_MSG)
    R<Boolean> createOrderSendMsg(@RequestParam("orderId") String id);
}
