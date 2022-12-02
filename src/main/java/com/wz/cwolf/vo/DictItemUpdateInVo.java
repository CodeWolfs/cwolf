package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictItemUpdateInVo
 * @description
 * @date 2022/11/30 10:14
 */
@ApiModel("字典项更新入参")
@Data
public class DictItemUpdateInVo {

    @ApiModelProperty(value = "主键", required = true)
    @NotBlank(message = "字典项主键不能为空")
    private String id;

    @ApiModelProperty(value = "字典id", required = true)
    @NotBlank(message = "字典id不可为空")
    private String dictId;

    @ApiModelProperty(value = "字典项文本", required = true)
    @NotBlank(message = "字典项文本不能为空")
    private String itemText;

    @ApiModelProperty(value = "字典项值", required = true)
    @NotBlank(message = "字典项值不能为空")
    private String itemValue;

    @ApiModelProperty(value = "描述", required = true)
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty(value = "排序", required = true)
    @NotNull(message = "排序不能为空")
    private Short sortOrder;

    @ApiModelProperty(value = "有效位", required = true)
    @NotBlank(message = "有效位不能为空")
    private String status;


}
