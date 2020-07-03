package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.extension.service.IService;
import whale.userCentre.api.entity.SysMenu;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    SysMenu getMenuByRoleId(Long RoleId);

}
