package com.wz.cwolf.vo;

import com.wz.cwolf.vo.base.PagePropertyVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictConditionVo
 * @description
 * @date 2022/11/29 10:19
 */
@ApiModel("字典查询条件入参")
@Data
public class DictConditionVo extends PagePropertyVo {

    @ApiModelProperty(value = "字典编码",required = false)
    private String dictCode;

    @ApiModelProperty(value = "字典名称",required = false)
    private String dictName;

    @ApiModelProperty(value = "状态1启用，0停用")
    private String status;
}
