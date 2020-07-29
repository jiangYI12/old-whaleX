package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.userCentre.api.dto.MenuTree;
import com.whalex.userCentre.api.entity.SysMenu;
import com.whalex.userCentre.api.vo.SysMenuVo;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu>  getMenuByRoleId(List<Long> RoleId);

    Boolean saveOrUpdateMenu(SysMenuVo sysMenuVo);

    Boolean deleteSysMenu(Long id);

    IPage<MenuTree> getSysMenusPage(SysMenuVo sysMenuVo);

    List<MenuTree> getSysMenuList();
}
