package com.whalex.userCentre.api.vo;

import com.whalex.userCentre.api.entity.SysRole;
import lombok.Data;
import com.whalex.userCentre.api.entity.SysMenu;

import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:36
 */
@Data
public class SysRoleVO extends SysRole {
    private List<SysMenu> sysMenus;
}
