package com.whalex.userCentre.api.fegin;

import com.whalex.common.core.baseEntity.WhaleUsers;
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
 * date: 2020/7/2 19:27
 */
@FeignClient(value = SysServiceConstant.USER_CENTRE_SERVICE)
public interface ISysCustomerFegin {

    String PREFIX =  FeginClientURL.PREFIX + "/SysCustomerFegin";

    String GET_SYSCUSTOMER_BY_ACCOUNT = PREFIX + "/getSysCustomerByAccount";

    @GetMapping(value =  GET_SYSCUSTOMER_BY_ACCOUNT)
    R<WhaleUsers> getSysCustomerByAccount(@RequestParam("account") String account, @RequestParam("tenantCode") String tenantCode);

}
