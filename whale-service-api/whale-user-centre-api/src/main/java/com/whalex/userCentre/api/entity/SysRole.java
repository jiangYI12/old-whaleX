package com.whalex.userCentre.api.entity;

import lombok.Data;
import com.whalex.common.mybatisPlus.entity.TenantEntity;

/**
 * sys_role
 * @author 
 */
@Data
public class SysRole extends TenantEntity {

    /**
     * 角色名中文
     */
    private String roleName;

    /**
     * 角色英文名
     */
    private String roleCode;

    /**
     * 描述
     */
    private String roleDesc;


    private static final long serialVersionUID = 1L;
}