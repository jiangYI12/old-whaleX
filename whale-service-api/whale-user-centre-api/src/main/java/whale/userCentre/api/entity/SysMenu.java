package whale.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import whale.common.mybatisPlus.baseEntity.TenantEntity;

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

    /**
     * 权限编号
     */
    private Integer code;


    private static final long serialVersionUID = 1L;
}