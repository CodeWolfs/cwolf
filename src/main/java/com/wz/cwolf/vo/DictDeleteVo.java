package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictDeleteVo
 * @description
 * @date 2022/11/29 15:52
 */

@ApiModel("字典删除入参")
@Data
public class DictDeleteVo {

    @ApiModelProperty(value = "字典id列表", required = true)
    @NotEmpty(message = "字典id列表不能为空")
    private List<String> ids;
}
