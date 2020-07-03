package com.whalex.whaleauth.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import whale.common.core.constant.SysConstant;
import whale.common.mvc.constant.ResultStatus;
import whale.common.mvc.customException.ServiceException;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.fegin.ISysCustomerFegin;
import whale.userCentre.api.vo.SysCustomerVO;
import whale.common.mvc.returnResult.R;
import whale.userCentre.api.vo.SysRoleVO;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerDetailService implements UserDetailsService {

    private ISysCustomerFegin iSysCustomerFegin;

    private HttpServletRequest request;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
       R<SysCustomerVO> r = iSysCustomerFegin.getSysCustomerByAccount(account,request.getHeader(SysConstant.TENANT_CODE));
        WhaleUsers whaleUsers = new WhaleUsers();
        if (r.getCode().equals(ResultStatus.SUCCESS)) {
            SysCustomerVO sysCustomerVO =  r.getData();
            List<SysRoleVO> sysRoleVOs = sysCustomerVO.getRoles();
            BeanUtils.copyProperties(sysCustomerVO,whaleUsers);

            List<String> roles = new LinkedList<>();
            List<Long> roleIds = new LinkedList<>();

            for (SysRoleVO s:sysRoleVOs) {
                roles.add(s.getRoleName());
                roleIds.add(s.getId());
            }

            whaleUsers.setRoles(roles);
            whaleUsers.setRoleIds(roleIds);
        }else {
            throw new ServiceException("认证失败");
        }

       return whaleUsers;
    }
}
