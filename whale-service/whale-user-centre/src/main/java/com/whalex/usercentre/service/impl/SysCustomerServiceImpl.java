package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.usercentre.mapper.SysCustomerMapper;
import com.whalex.usercentre.service.ISysCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.entity.SysCustomer;

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
    public WhaleUsers selectUserAndRoleByAccount(String account) {
        return null;
    }
}
