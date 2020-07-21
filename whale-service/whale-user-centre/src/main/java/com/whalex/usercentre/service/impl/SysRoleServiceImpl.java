package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysRoleMapper;
import com.whalex.usercentre.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.whalex.userCentre.api.entity.SysRole;
import com.whalex.userCentre.api.vo.SysRoleVO;

import java.util.List;

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
    public List<SysRoleVO> getCustomerRoleById(Long customerId) {
        return this.baseMapper.getCustomerRoleById(customerId);
    }

    @Override
    public List<SysRole> getRolesBytenantCode() {
        return this.baseMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public Boolean saveOrUpdateSysRole(SysRole sysRole) {
        return this.saveOrUpdate(sysRole);
    }

    @Override
    public Boolean deleteSysRole(Long id) {
        return this.removeById(id);
    }


}
