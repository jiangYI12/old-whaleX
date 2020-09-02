package com.whalex.usercentre.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.mvc.customException.ServiceException;
import com.whalex.userCentre.api.entity.SysCustomerRole;
import com.whalex.usercentre.mapper.SysCustomerMapper;
import com.whalex.usercentre.service.ISysCustomerRoleService;
import com.whalex.usercentre.service.ISysCustomerService;
import com.whalex.usercentre.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.whalex.userCentre.api.entity.SysCustomer;
import com.whalex.userCentre.api.vo.SysCustomerVO;
import com.whalex.userCentre.api.vo.SysRoleVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:53
 */
@Service
@AllArgsConstructor
public class SysCustomerServiceImpl extends ServiceImpl<SysCustomerMapper, SysCustomer> implements ISysCustomerService {


    private ISysRoleService iSysRoleService;

    private ISysCustomerRoleService iSysCustomerRoleService;

    private PasswordEncoder passwordEncoder;

    @Override
    public WhaleUsers selectUserAndRoleByAccount(String account, String tenantCode) {
        SysCustomerVO sysCustomerVO = new SysCustomerVO();
        sysCustomerVO.setAccount(account);
        sysCustomerVO.setTenantCode(tenantCode);
        sysCustomerVO = this.baseMapper.selectUserByCondition(sysCustomerVO);
        if(ObjectUtil.isEmpty(sysCustomerVO)){
            throw new ServiceException("用户不存在");
        }
        WhaleUsers whaleUsers = new WhaleUsers();
        BeanUtils.copyProperties(sysCustomerVO,whaleUsers);
        //查找用户角色
        List<SysRoleVO> sysRoleVOs = iSysRoleService.getCustomerRoleById(sysCustomerVO.getId());
        sysCustomerVO.setRoles(sysRoleVOs);

            List<String> roles = new LinkedList<>();
            List<String> roleIds = new LinkedList<>();
            //获取权限
            for (SysRoleVO s:sysRoleVOs) {
                roles.add(s.getRoleCode());
                roleIds.add(s.getId()+"");
                if(CollUtil.isEmpty(s.getSysMenus())){
                    continue;
                }
            }
            whaleUsers.setRoles(roles);
            whaleUsers.setRoleIds(roleIds);
        return whaleUsers;
    }

    @Override
    public WhaleUsers getUserById(Long id) {
        SysCustomerVO sysCustomerVO = this.baseMapper.getUserById(id);
        if(ObjectUtil.isEmpty(sysCustomerVO)){
            throw new ServiceException("用户不存在");
        }
        WhaleUsers whaleUsers = new WhaleUsers();
        BeanUtils.copyProperties(sysCustomerVO,whaleUsers);
        //查找用户角色
        List<SysRoleVO> sysRoleVOs = iSysRoleService.getCustomerRoleById(sysCustomerVO.getId());
        sysCustomerVO.setRoles(sysRoleVOs);

        List<String> roles = new LinkedList<>();
        List<String> roleIds = new LinkedList<>();
        //获取权限
        for (SysRoleVO s:sysRoleVOs) {
            roles.add(s.getRoleCode());
            roleIds.add(s.getId()+"");
            if(CollUtil.isEmpty(s.getSysMenus())){
                continue;
            }
        }
        whaleUsers.setRoles(roles);
        whaleUsers.setRoleIds(roleIds);
        return whaleUsers;
    }

    @Override
    public IPage<SysCustomerVO> getUserPage(SysCustomerVO sysCustomerVO) {
        IPage iPage = new Page(sysCustomerVO.getPageNo(),sysCustomerVO.getPageSize());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  this.baseMapper.getUserDetailPage(iPage);
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateCustomer(SysCustomerVO sysCustomerVO) {
        //设置密码加密
        sysCustomerVO.setPassword(passwordEncoder.encode(sysCustomerVO.getPassword()));
        boolean isSuccess = this.saveOrUpdate(sysCustomerVO);
        if(isSuccess){
            List<SysCustomerRole> sysCustomerRoles = new LinkedList<>();
            for (SysRoleVO s:sysCustomerVO.getRoles()) {
                SysCustomerRole sysCustomerRole = new SysCustomerRole();
                sysCustomerRole.setRoleId(s.getId());
                sysCustomerRole.setCustomerId(sysCustomerVO.getId());
                sysCustomerRoles.add(sysCustomerRole);
            }
         return  iSysCustomerRoleService.saveBatch(sysCustomerRoles);
        }
        return false;
    }

    @Override
    public Boolean deleteSysCustomer(Long id) {
        return this.removeById(id);
    }


}
