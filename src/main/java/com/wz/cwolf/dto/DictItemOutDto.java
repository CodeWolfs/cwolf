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
 * @className DictItemDto
 * @description
 * @date 2022/11/30 9:45
 */
@Data
public class DictItemOutDto {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("字典id")
    private String dictId;

    @ApiModelProperty("字典项文本")
    private String itemText;

    @ApiModelProperty("字典项值")
    private String itemValue;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private Short sortOrder;

    @ApiModelProperty("有效位")
    private String status;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("有效位文本")
    private String statusText;
}
