package com.whalex.usercentre.feginClient;

import com.baomidou.mybatisplus.extension.api.R;
import com.whalex.usercentre.service.ISysCustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import whale.userCentre.api.fegin.ISysCustomerFegin;
import whale.userCentre.api.vo.SysCustomerVO;

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
    public R<SysCustomerVO> getSysCustomerByAccount(String account) {
        return R.ok(iSysCustomerService.selectUserAndRoleByAccount(account));
    }

}
