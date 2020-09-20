package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.userCentre.api.entity.SysRoleMenu;
import com.whalex.userCentre.api.vo.SysRoleMenuVO;
import com.whalex.usercentre.mapper.SysRoleMenuMapper;
import com.whalex.usercentre.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/25 22:08
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    @Override
    public Boolean addRoleMenu(SysRoleMenuVO sysRoleMenuVO) {
        List <SysRoleMenu> sysRoleMenus = new LinkedList<>();
        for(Long menuId:sysRoleMenuVO.getMenuIds()){
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(sysRoleMenuVO.getRoleId());
            sysRoleMenus.add(sysRoleMenu);
        }
        return this.saveBatch(sysRoleMenus);
    }
}
