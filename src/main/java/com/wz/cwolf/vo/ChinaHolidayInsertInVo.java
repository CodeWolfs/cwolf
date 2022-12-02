package com.wz.cwolf.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className ChinaHolidayInsertInVo
 * @description
 * @date 2022/12/1 10:24
 */

@ApiModel("节假日插入入参")
@Data
public class ChinaHolidayInsertInVo {

    @ApiModelProperty("日期yyyy-MM-dd")
    //todo 日期校验注解 yyyy-MM-dd
    @NotBlank(message = "日期不能为空")
    private String holidayDate;

    @ApiModelProperty("日期类型：0休息1工作")
    @NotBlank(message = "日期类型不能为空")
    private String holidayType;

    @ApiModelProperty("有效，0无效，1有效")
    @NotBlank(message = "有效标志不能为空")
    private String status;

    @ApiModelProperty("备注")
    private String remark;
}
