package com.whalex.usercentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import whale.userCentre.api.entity.SysRole;
import whale.userCentre.api.vo.SysRoleVO;

import java.util.List;

@Mapper
public interface SysRoleMapper  extends BaseMapper<SysRole> {
    List<SysRoleVO> getCustomerRoleById(@Param("customerId")Long customerId);
}