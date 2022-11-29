package com.wz.cwolf.vo;

import com.wz.cwolf.vo.base.PagePropertyVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictItemConditionVo
 * @description
 * @date 2022/11/29 10:27
 */

@ApiModel("字典项查询条件入参")
@Data
public class DictItemConditionVo extends PagePropertyVo {
    @ApiModelProperty(value = "字典ID",required = true)
    @NotBlank(message = "字典ID不能为空")
    private String dictId;

    @ApiModelProperty(value = "字典项文本")
    private String itemText;

    @ApiModelProperty(value = "字典项编码")
    private String itemValue;

    @ApiModelProperty(value = "状态1启用，0停用")
    private String status;
}
