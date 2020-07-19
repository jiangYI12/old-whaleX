package com.whalex.usercentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.whalex.userCentre.api.entity.SysCustomer;
import com.whalex.userCentre.api.vo.SysCustomerVO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysCustomerMapper extends BaseMapper<SysCustomer> {
   SysCustomerVO selectUserByCondition(@Param("cusVo") SysCustomerVO sysCustomerVO);

   SysCustomerVO getUserById(@Param("id") Long id);

}