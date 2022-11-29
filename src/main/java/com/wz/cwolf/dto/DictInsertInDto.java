package com.wz.cwolf.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WangZhe
 * @version 1.0
 * @className DictInsertInDto
 * @description
 * @date 2022/11/29 16:18
 */

@Data
public class DictInsertInDto {

    private String dictName;

    private String dictCode;

    private String description;

    private String status;
}
