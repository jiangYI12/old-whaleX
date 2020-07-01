package whale.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_resources
 * @author 
 */
@Data
public class SysResources implements Serializable {
    private Long id;

    /**
     * 资源名
     */
    private String name;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 资源编号
     */
    private String code;

    /**
     * 标志路径
     */
    private String icon;

    /**
     * 父菜单id
     */
    private Long parentId;

    /**
     * 0不是父菜单 1是父菜单
     */
    private Integer isParent;

    /**
     * 排序
     */
    private Integer sort;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String tenantCode;

    private static final long serialVersionUID = 1L;
}