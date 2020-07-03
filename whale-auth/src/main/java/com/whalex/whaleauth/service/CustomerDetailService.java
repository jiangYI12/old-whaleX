package com.whalex.whaleauth.service;

import cn.hutool.core.util.ObjectUtil;
import com.whalex.whaleauth.entity.WhaleXUserDetails;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import whale.common.core.constant.ResultStatus;
import whale.common.core.constant.SysConstant;
import whale.common.core.returnResult.R;
import whale.common.mvc.customException.ServiceException;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.fegin.ISysCustomerFegin;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service
@AllArgsConstructor
public class CustomerDetailService implements UserDetailsService {

    private ISysCustomerFegin iSysCustomerFegin;

    private HttpServletRequest request;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
       R<WhaleUsers> r = iSysCustomerFegin.getSysCustomerByAccount(account,request.getHeader(SysConstant.TENANT_CODE));

       WhaleUsers whaleUsers = null;

       if(r.getCode() == ResultStatus.SUCCESS){
            whaleUsers =  r.getData();
       }else {
           throw new ServiceException("登录失败");
       }

       if (ObjectUtil.isEmpty(whaleUsers)){
           throw new ServiceException("账户不存在");
       }
       //设置角色
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList((String[]) whaleUsers.getRoles().toArray());

        return new WhaleXUserDetails(whaleUsers.getAccount(),whaleUsers.getAvatar(),whaleUsers.getId(),
               whaleUsers.getPhone(),whaleUsers.getUsername(),whaleUsers.getPassword(),whaleUsers.getRoles(),whaleUsers.getPermissions(),authorities);
    }
}
