package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysMenuMapper;
import com.whalex.usercentre.service.ISysMenuService;
import com.whalex.userCentre.api.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getMenuByRoleId(List<Long> roleId) {
        return this.baseMapper.getMenuByRoleIds(roleId);
    }
}
