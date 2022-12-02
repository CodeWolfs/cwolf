package com.wz.cwolf.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictItemInsertVo
 * @description
 * @date 2022/11/30 10:01
 */

@ApiModel("字典项插入入参")
@Data
public class DictItemInsertInVo {
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

}
