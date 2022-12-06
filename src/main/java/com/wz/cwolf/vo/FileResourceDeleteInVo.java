package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className FileResourceDeleteInVo
 * @description
 * @date 2022/12/5 16:50
 */

@ApiModel("文件删除入参")
@Data
public class FileResourceDeleteInVo {

    @ApiModelProperty(value = "文件id列表", required = true)
    @NotEmpty(message = "文件id列表不可为空")
    private List<String> ids;

    @ApiModelProperty(value = "物理删除标志位")
    private String deleteFlag = "false";

}
