package com.wz.cwolf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictDto
 * @description
 * @date 2022/11/29 10:58
 */

@ApiModel("字典返参")
@Data
public class DictDto {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典编码")
    private String dictCode;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("有效状态")
    private String status;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("有效状态-字典值")
    private String status_text;
}
