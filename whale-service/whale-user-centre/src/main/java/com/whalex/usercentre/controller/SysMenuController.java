package com.whalex.usercentre.controller;

import com.whalex.common.core.returnResult.R;
import com.whalex.userCentre.api.entity.SysMenu;
import com.whalex.userCentre.api.vo.SysMenuVo;
import com.whalex.usercentre.service.ISysMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * Description: 获取用户角色菜单列表
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/16 21:48
 */
@RestController
@AllArgsConstructor
@RequestMapping("/menus")
public class SysMenuController {

    private ISysMenuService iSysMenuService;

    @RequestMapping("/getSysMenuByRoleIds")
    public R<List<SysMenu>> getSysMenuByRoleIds(@RequestBody List<Long> ids){
        return R.data(iSysMenuService.getMenuByRoleId(ids));
    }

    @RequestMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody SysMenuVo sysMenuVo){
        return R.status(iSysMenuService.saveOrUpdateMenu(sysMenuVo));
    }
}
