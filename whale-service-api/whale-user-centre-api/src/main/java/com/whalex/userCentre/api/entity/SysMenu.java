package com.whalex.userCentre.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import com.whalex.common.mybatisPlus.entity.TenantEntity;

/**
 * sys_menu
 * @author 
 */
@Data
public class SysMenu extends TenantEntity {
    /**
     * 菜单名
     */
    private String name;

    /**
     * -1 顶级父类
     */
    private Long parentId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 标签
     */
    private String icon;

    private String path;

    private Integer sort;

    @TableField(exist = false)
    private String keepAlive;

    private static final long serialVersionUID = 1L;
}