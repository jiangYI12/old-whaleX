package com.whalex.userCentre.api.vo;

import com.whalex.userCentre.api.entity.SysCustomer;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:35
 */
@Data
public class SysCustomerVO extends SysCustomer {
    private List<SysRoleVO> roles;
}
