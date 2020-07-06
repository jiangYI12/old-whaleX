package com.whalex.usercentre.feginClient;

import com.whalex.usercentre.service.ISysCustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whale.common.core.baseEntity.WhaleUsers;
import whale.common.core.returnResult.R;
import com.whalex.userCentre.api.fegin.ISysCustomerFegin;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 21:27
 */
@RestController
@AllArgsConstructor
public class SysCustomerClient implements ISysCustomerFegin {

    private ISysCustomerService iSysCustomerService;

    @Override
    @GetMapping(GET_SYSCUSTOMER_BY_ACCOUNT)
    @ApiOperation(value = "查询用户", notes = "根据account查询用户")
    public R<WhaleUsers> getSysCustomerByAccount(@RequestParam("account")String account, @RequestParam("tenantCode") String tenantCode) {
        return R.success(iSysCustomerService.selectUserAndRoleByAccount(account,tenantCode));
    }

}
