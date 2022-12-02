package com.wz.cwolf.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictItemInsertInDto
 * @description 字典项 插入 入参dto
 * @date 2022/11/30 10:06
 */
@Data
public class DictItemInsertInDto {
    @ApiModelProperty(value = "字典id", required = true)
    private String dictId;

    @ApiModelProperty(value = "字典项文本", required = true)
    private String itemText;

    @ApiModelProperty(value = "字典项值", required = true)
    private String itemValue;

    @ApiModelProperty(value = "描述", required = true)
    private String description;

    @ApiModelProperty(value = "排序", required = true)
    private Short sortOrder;

    @ApiModelProperty(value = "状态")
    private String status;
}
