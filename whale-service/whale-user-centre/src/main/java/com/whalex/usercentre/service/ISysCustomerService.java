package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.extension.service.IService;
import whale.common.security.entity.WhaleUsers;
import whale.userCentre.api.entity.SysCustomer;
import whale.userCentre.api.vo.SysCustomerVO;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:48
 */
public interface ISysCustomerService extends IService<SysCustomer> {
    SysCustomerVO selectUserAndRoleByAccount(String account, String tenantCode);
}
