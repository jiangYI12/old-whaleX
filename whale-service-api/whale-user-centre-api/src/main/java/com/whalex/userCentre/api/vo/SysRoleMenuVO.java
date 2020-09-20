package com.whalex.userCentre.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whalex.userCentre.api.entity.SysRoleMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/25 23:07
 */
@Data
public class SysRoleMenuVO {

    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    private List<Long> menuIds;
}
