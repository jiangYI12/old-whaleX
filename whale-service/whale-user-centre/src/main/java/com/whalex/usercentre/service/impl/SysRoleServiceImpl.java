package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysRoleMapper;
import com.whalex.usercentre.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import whale.userCentre.api.entity.SysRole;
import whale.userCentre.api.vo.SysRoleVO;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 21:58
 */

@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public SysRoleVO getCustomerRoleById(Long customerId) {
        return this.baseMapper.getCustomerRoleById(customerId);
    }
}
