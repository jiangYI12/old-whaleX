package com.whalex.usercentre.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.userCentre.api.dto.MenuTree;
import com.whalex.userCentre.api.vo.SysMenuVo;
import com.whalex.userCentre.api.vo.TreeUtil;
import com.whalex.usercentre.mapper.SysMenuMapper;
import com.whalex.usercentre.service.ISysMenuService;
import com.whalex.userCentre.api.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getMenuByRoleId(List<Long> roleId) {
        return this.baseMapper.getMenuByRoleIds(roleId);
    }

    @Override
    public Boolean saveOrUpdateMenu(SysMenuVo sysMenuVo) {
        return this.saveOrUpdate(sysMenuVo);
    }

    @Override
    public Boolean deleteSysMenu(Long id) {
        return this.removeById(id);
    }

    @Override
    public IPage<MenuTree> getSysMenusPage(SysMenuVo sysMenuVo) {
        IPage iPage = new Page(sysMenuVo.getPageNo(),sysMenuVo.getPageSize());
        iPage = this.baseMapper.selectPage(iPage, Wrappers.lambdaQuery());
        //默认父节点 parentId 为 -1
        List<MenuTree> sysMenuVos = TreeUtil.buildTree(iPage.getRecords(),-1L);
        iPage.setRecords(sysMenuVos);
        return iPage;
    }

    @Override
    public List<MenuTree> getSysMenuList() {
        //默认父节点 parentId 为 -1
        return TreeUtil
                .buildTree(this.baseMapper.selectList(Wrappers
                        .lambdaQuery()),-1L);
    }


}
