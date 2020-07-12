package com.whalex.whaleauth.service;

import cn.hutool.core.util.ObjectUtil;
import com.google.protobuf.ServiceException;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.constant.ResultStatus;
import com.whalex.common.core.constant.SysConstant;
import com.whalex.common.core.returnResult.R;
import com.whalex.common.tool.webUtil.WebUtils;
import com.whalex.whaleauth.entity.WhaleXUserDetails;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.whalex.userCentre.api.fegin.ISysCustomerFegin;

import java.util.Collection;

/**
 * @description: 用户密码登录校验
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 */
@Service
@AllArgsConstructor
public class WhaleXCustomerDetailService implements UserDetailsService {

    private ISysCustomerFegin iSysCustomerFegin;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
       R<WhaleUsers> r = iSysCustomerFegin.getSysCustomerByAccount(account, WebUtils.getRequest().getHeader(SysConstant.TENANT_CODE));

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
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(
                        whaleUsers.getRoles().toArray(new String[whaleUsers.getRoles().size()])
                );

        return new WhaleXUserDetails(whaleUsers.getAccount(),whaleUsers.getAvatar(),whaleUsers.getId(),
               whaleUsers.getPhone(),whaleUsers.getUsername(),whaleUsers.getPassword(),whaleUsers.getRoles(),whaleUsers.getPermissions(),authorities);
    }
}
