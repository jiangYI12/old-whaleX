package com.whalex.userCentre.api.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import whale.common.core.constant.SysServiceConstant;
import whale.common.core.returnResult.R;
import whale.common.fegin.constant.FeginClientURL;
import whale.common.security.entity.WhaleUsers;

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
