package whale.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import whale.common.mybatisPlus.baseEntity.TenantEntity;

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