package whale.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_permission
 * @author 
 */
@Data
public class SysPermission implements Serializable {
    private Long id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限编号
     */
    private Integer code;

    private String tenantCode;

    private Date createTime;

    private Date updateTime;

    /**
     * 是否删除 0未删除 1删除
     */
    private Integer isDelete;

    /**
     * 0开启 1关闭
     */
    private String status;

    private static final long serialVersionUID = 1L;
}