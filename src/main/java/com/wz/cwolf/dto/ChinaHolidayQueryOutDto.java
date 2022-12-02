package com.wz.cwolf.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className ChinaHolidayQeryOutDto
 * @description
 * @date 2022/12/1 9:41
 */

@Data
public class ChinaHolidayQueryOutDto {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("日期yyyy-MM-dd")
    private String holidayDate;

    @ApiModelProperty("日期类型")
    private String holidayType;

    @ApiModelProperty("有效，0无效，1有效")
    private String status;

    @ApiModelProperty("创建员")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新员")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("日期类型-文本")
    private String holidayTypeText;

    @ApiModelProperty("有效文本")
    private String statusText;
}
