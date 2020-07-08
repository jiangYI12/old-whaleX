package com.whalex.system.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sys_route_conf
 * @author 
 */
@Data
@TableName("sys_route_conf")
public class SysRouteConf implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    private String routeName;

    private String routeId;

    /**
     * 断言
     */
    private Object predicates;

    /**
     * 过滤器
     */
    private Object filters;

    private String uri;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private String delFlag;

    private static final long serialVersionUID = 1L;
}