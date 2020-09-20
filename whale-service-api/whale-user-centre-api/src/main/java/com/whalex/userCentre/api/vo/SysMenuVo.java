package com.whalex.userCentre.api.vo;

import com.whalex.userCentre.api.entity.SysMenu;
import lombok.Data;
import java.util.List;

@Data
public class SysMenuVo extends SysMenu {
    private List<SysMenuVo> children;

    private Integer pageSize;

    private Integer pageNo;
}
