package com.whalex.usercentre.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whalex.common.core.returnResult.R;
import com.whalex.userCentre.api.entity.SysRole;
import com.whalex.userCentre.api.vo.SysRoleVO;
import com.whalex.usercentre.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Description: 角色controller
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/23 20:42
 */
@AllArgsConstructor
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    private final ISysRoleService iSysRoleService;

    @PostMapping("getRolesPage")
    public R<IPage<SysRoleVO>> getRolesPage(@RequestBody SysRoleVO sysRoleVO){
        return R.data(iSysRoleService.getRolesPage(sysRoleVO));
    }

    @GetMapping("getRolesList")
    public R<List<SysRole>> getRolesPage(){
        return R.data(iSysRoleService.getRolesBytenantCode());
    }


    @PostMapping("saveOrUpdate")
    public R<Boolean> saveOrUpdate(@RequestBody SysRole sysRole){
        return R.data(iSysRoleService.saveOrUpdateSysRole(sysRole));
    }

    @GetMapping("deleteById")
    public R<Boolean> deleteById(@RequestParam("id")Long id){
        return R.data(iSysRoleService.deleteSysRole(id));
    }

}
