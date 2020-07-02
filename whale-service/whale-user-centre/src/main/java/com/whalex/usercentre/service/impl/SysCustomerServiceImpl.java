package com.whalex.usercentre.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysCustomerMapper;
import com.whalex.usercentre.service.ISysCustomerService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import whale.common.mvc.customException.ServiceException;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.entity.SysCustomer;
import whale.userCentre.api.vo.SysCustomerVO;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:53
 */
@Service
@AllArgsConstructor
public class SysCustomerServiceImpl extends ServiceImpl<SysCustomerMapper, SysCustomer> implements ISysCustomerService {

    @Override
    @SneakyThrows
    public SysCustomerVO selectUserAndRoleByAccount(String account,String tenantCode) {
        SysCustomerVO sysCustomerVO = new SysCustomerVO();
        sysCustomerVO.setAccount(account);
        sysCustomerVO.setTenantCode(tenantCode);
        sysCustomerVO = this.baseMapper.selectUserByCondition(sysCustomerVO);
        if(ObjectUtil.isEmpty(sysCustomerVO)){
            throw new ServiceException("用户不存在");
        }
        //查询用户角色
        return sysCustomerVO;
    }
}
