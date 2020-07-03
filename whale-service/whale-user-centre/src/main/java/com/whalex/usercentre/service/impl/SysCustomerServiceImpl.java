package com.whalex.usercentre.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysCustomerMapper;
import com.whalex.usercentre.service.ISysCustomerService;
import com.whalex.usercentre.service.ISysRoleService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import whale.common.mvc.customException.ServiceException;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.entity.SysCustomer;
import whale.userCentre.api.entity.SysMenu;
import whale.userCentre.api.vo.SysCustomerVO;
import whale.userCentre.api.vo.SysRoleVO;

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

    @Override
    @SneakyThrows
    public WhaleUsers selectUserAndRoleByAccount(String account,String tenantCode) {
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
            BeanUtils.copyProperties(sysCustomerVO,whaleUsers);

            List<String> roles = new LinkedList<>();
            List<String> permissions = new LinkedList<>();
        //获取权限
            for (SysRoleVO s:sysRoleVOs) {
                roles.add(s.getRoleName());
                for (SysMenu sysMenu:s.getSysMenus()) {
                    permissions.add(sysMenu.getPermissionName());
                }
            }
            whaleUsers.setRoles(roles);
            whaleUsers.setPermissions(permissions);

        return whaleUsers;
    }
}
