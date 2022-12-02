package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictUpdateVo
 * @description
 * @date 2022/11/29 15:26
 */


@ApiModel("字典更新入参")
@Data
public class DictUpdateVo {

    @ApiModelProperty("主键")
    @NotBlank(message = "主键不能为空")
    private String id;

    @ApiModelProperty("字典名称")
    @NotBlank(message = "字典名称不能为空")
    private String dictName;

    @ApiModelProperty("字典编码")
    @NotBlank(message = "字典编码不能为空")
    private String dictCode;

    @ApiModelProperty("描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty("有效状态")
    @NotBlank(message = "描述不能为空")
    private String status;
}