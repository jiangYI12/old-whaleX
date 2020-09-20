package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.userCentre.api.entity.SysRoleMenu;
import com.whalex.userCentre.api.vo.SysRoleMenuVO;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/25 22:07
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
    Boolean addRoleMenu(SysRoleMenuVO sysRoleMenuVO);
}
