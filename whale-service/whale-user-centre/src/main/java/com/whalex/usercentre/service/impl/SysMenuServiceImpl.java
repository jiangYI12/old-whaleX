package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysMenuMapper;
import com.whalex.usercentre.service.ISysMenuService;
import com.whalex.userCentre.api.entity.SysMenu;

import java.util.List;


public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getMenuByRoleId(List<Long> roleId) {
        return this.baseMapper.getMenuByRoleIds(roleId);
    }
}
