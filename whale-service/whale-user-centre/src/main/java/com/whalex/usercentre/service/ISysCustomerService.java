package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.userCentre.api.entity.SysCustomer;
import com.whalex.userCentre.api.vo.SysCustomerVO;

import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:48
 */
public interface ISysCustomerService extends IService<SysCustomer> {
    WhaleUsers selectUserAndRoleByAccount(String account, String tenantCode);

    WhaleUsers getUserById(Long id);

    IPage<SysCustomerVO> getUserPage(SysCustomerVO sysCustomerVO);

    Boolean saveOrUpdateCustomer(SysCustomerVO sysCustomerVO);

    Boolean deleteSysCustomer(Long id);
}
