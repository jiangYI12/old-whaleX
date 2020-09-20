package com.whalex.common.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/6/30 22:32
 */
@Data
public class TenantEntity extends BaseEntity {
    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantCode;

    /**
     * 创建人
     */
    @TableField("create_user")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 更新人
     */
    @TableField("update_user")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "更新人")
    private Long updateUser;
}
