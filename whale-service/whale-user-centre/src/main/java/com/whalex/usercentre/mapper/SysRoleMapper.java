package com.whalex.usercentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import whale.userCentre.api.entity.SysRole;
import whale.userCentre.api.vo.SysRoleVO;

@Mapper
public interface SysRoleMapper  extends BaseMapper<SysRole> {
    SysRoleVO getCustomerRoleById(@Param("customerId")Long customerId);
}