package whale.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_role
 * @author 
 */
@Data
public class SysRole implements Serializable {
    private Long id;

    private String tenantCode;

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

    /**
     * 是否删除 0未删除 1删除
     */
    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}