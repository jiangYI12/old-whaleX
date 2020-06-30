package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_customer
 * @author 
 */
@Data
public class SysResources implements Serializable {
    private Long id;

    private String account;

    /**
     * 用户名
     */
    private String customerName;

    /**
     * 密码
     */
    private String password;

    /**
     * 租户号
     */
    private String tenantCode;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    private Date createTime;

    private Date updateTime;

    /**
     * 0停用 1启用
     */
    private Integer status;

    /**
     * 0未删除 1删除
     */
    private String isDelete;

    private static final long serialVersionUID = 1L;
}