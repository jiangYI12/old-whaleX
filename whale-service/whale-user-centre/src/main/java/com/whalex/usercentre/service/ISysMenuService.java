package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.userCentre.api.entity.SysMenu;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu>  getMenuByRoleId(List<Long> RoleId);

}
