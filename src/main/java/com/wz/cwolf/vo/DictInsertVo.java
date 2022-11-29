package com.wz.cwolf.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictInsertVo
 * @description
 * @date 2022/11/29 15:23
 */
@ApiModel("字典插入入参")
@Data
public class DictInsertVo {

    @ApiModelProperty("字典名称")
    @NotBlank(message = "字典名称不能为空")
    private String dictName;

    @ApiModelProperty("字典编码")
    @NotBlank(message = "字典编码不能为空")
    private String dictCode;

    @ApiModelProperty("描述")
    @NotBlank(message = "描述不能为空")
    private String description;
}
