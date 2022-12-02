package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictItemDeleteInVo
 * @description
 * @date 2022/11/30 10:21
 */
@ApiModel("字典项删除入参")
@Data
public class DictItemDeleteInVo {

    @ApiModelProperty(value = "字典项id列表", required = true)
    @NotEmpty(message = "字典项id列表不能为空")
    private List<String> ids;
}
