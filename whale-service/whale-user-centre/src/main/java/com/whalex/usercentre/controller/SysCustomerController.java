package com.whalex.usercentre.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.core.util.AuthUtil;
import com.whalex.userCentre.api.entity.SysCustomer;
import com.whalex.userCentre.api.vo.SysCustomerVO;
import com.whalex.usercentre.service.ISysCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/getUserPage")
    public R<IPage<SysCustomer>> getUserPage(@RequestBody SysCustomerVO sysCustomerVO){
        return R.data(iSysCustomerService.getUserPage(sysCustomerVO));
    }


    @PostMapping("/saveOrUpdate")
    public R<Boolean> saveOrUpdate(@RequestBody SysCustomerVO sysCustomerVO){
        return R.status(iSysCustomerService.saveOrUpdateCustomer(sysCustomerVO));
    }

    @GetMapping("/deleteUser")
    public R deleteUser(@RequestParam("userId")Long id){
        return R.data(iSysCustomerService.deleteSysCustomer(id));
    }


}
