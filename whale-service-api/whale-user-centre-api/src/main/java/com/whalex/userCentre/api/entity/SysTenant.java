package com.whalex.userCentre.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_tenant
 * @author 
 */
@Data
public class SysTenant implements Serializable {
    private Long id;

    /**
     * 公司名
     */
    private String componeyName;

    /**
     * 租户号
     */
    private String tenantCode;

    private Date createTime;

    private Date updateTime;

    /**
     * 0 关闭 1开启
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}