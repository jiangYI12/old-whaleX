package com.whalex.pay.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.whalex.common.tool.timeUtil.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description: 测试支付类
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/1 22:03
 */
@Data
public class PayTest {

    private String orderNo;

    private BigDecimal totalAmount;

    private String productName;

    private String billType;

    private String startTime;
}
