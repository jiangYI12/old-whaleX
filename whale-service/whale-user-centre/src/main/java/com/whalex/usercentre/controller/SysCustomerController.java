package com.whalex.usercentre.controller;

import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.core.util.AuthUtil;
import com.whalex.usercentre.service.ISysCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:40
 */
@RestController
@RequestMapping("/sysCustomer")
@AllArgsConstructor
public class SysCustomerController {
    private ISysCustomerService iSysCustomerService;

    @GetMapping("/getUserById")
    public R<WhaleUsers> getUserById(){
        return R.data(iSysCustomerService.getUserById(AuthUtil.getUserId()));
    }
}
