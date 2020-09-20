package com.whalex.message.centre.feginClient;

import com.whalex.common.core.returnResult.R;
import com.whalex.message.centre.api.fegin.ICreateOrderMessageFegin;
import com.whalex.message.centre.service.ICreateOrderMessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 创建订单fegin
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/10 21:00
 */

@RestController
@AllArgsConstructor
public class CreateOrderMessageClient implements ICreateOrderMessageFegin {

    private ICreateOrderMessageService iCreateOrderMessageService;

    @Override
    @GetMapping(CREATE_ORDER_SEND_MSG)
    public R<Boolean> createOrderSendMsg(@RequestParam("orderId") String orderId) {
        return R.data(iCreateOrderMessageService.createOrderSendMsg(orderId));
    }
}
