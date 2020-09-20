package com.whalex.common.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.whalex.common.tool.timeUtil.DateUtil;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/6/30 22:01
 */
@Data
public class BaseEntity {
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;


    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 状态[1:正常]
     */
    @ApiModelProperty(value = "业务状态")
    private Integer status;

    /**
     * 状态[0:未删除,1:删除]
     */
    @TableField("is_delete")
    @TableLogic(value = "0",delval = "1")
    @ApiModelProperty(value = "是否已删除")
    private Integer isDelete;
}
