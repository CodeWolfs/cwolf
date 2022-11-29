package com.wz.cwolf.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 中国法定节假日表
 * </p>
 *
 * @author wz
 * @since 2022-18-29
 */
@Getter
@Setter
@TableName("CHINA_HOLIDAY")
@ApiModel(value = "ChinaHoliday对象", description = "中国法定节假日表")
public class ChinaHoliday implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("日期yyyy-MM-dd")
    @TableField("HOLIDAY_DATE")
    private String holidayDate;

    @ApiModelProperty("日期类型：0休息1工作")
    @TableField("HOLIDAY_TYPE")
    private String holidayType;

    @ApiModelProperty("有效，0无效，1有效")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty("创建员")
    @TableField("CREATE_BY")
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新员")
    @TableField("UPDATE_BY")
    private String updateBy;

    @ApiModelProperty("更新时间")
    @TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("备注")
    @TableField("REMARK")
    private String remark;
}
