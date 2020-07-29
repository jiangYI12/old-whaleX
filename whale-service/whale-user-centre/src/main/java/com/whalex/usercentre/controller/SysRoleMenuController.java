package com.whalex.usercentre.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.userCentre.api.entity.SysRoleMenu;
import com.whalex.userCentre.api.vo.SysRoleMenuVO;
import com.whalex.usercentre.service.ISysRoleMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/25 22:06
 */
@AllArgsConstructor
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {

    private ISysRoleMenuService iSysRoleMenuService;

    @RequestMapping("/addRoleMenu")
    public R<Boolean> addRoleMenu(@RequestBody SysRoleMenuVO sysRoleMenuVO){
        return R.data(iSysRoleMenuService.addRoleMenu(sysRoleMenuVO));
    }
}
