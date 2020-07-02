package com.whalex.usercentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import whale.userCentre.api.entity.SysCustomer;
import whale.userCentre.api.vo.SysCustomerVO;

@Mapper
public interface SysCustomerMapper extends BaseMapper<SysCustomer> {
   SysCustomerVO selectUserByCondition(@Param("cusVO") SysCustomerVO sysCustomerVO);
}