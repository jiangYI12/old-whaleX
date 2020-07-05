package com.whalex.usercentre.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.whalex.userCentre.api.entity.SysMenu;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> getMenuByRoleId(@Param("roleIds")List<Long> roleIds);
}