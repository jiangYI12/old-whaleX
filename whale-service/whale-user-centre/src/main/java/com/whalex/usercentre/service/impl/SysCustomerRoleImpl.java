package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysCustomerRoleMapper;
import com.whalex.usercentre.service.ISysCustomerRoleService;
import org.springframework.stereotype.Service;
import whale.userCentre.api.entity.SysCustomerRole;

@Service
public class SysCustomerRoleImpl extends ServiceImpl<SysCustomerRoleMapper, SysCustomerRole> implements ISysCustomerRoleService {
}
