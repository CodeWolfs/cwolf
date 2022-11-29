package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisGenerateVo
 * @description
 * @date 2022/11/29 9:42
 */

@ApiModel("mybatis 代码生成入参")
@Data
public class MybatisGenerateVo {

    @ApiModelProperty(value = "表名列表", required = true)
    @NotEmpty(message = "至少选中一张表")
    private List<String> tableNameList;

}
