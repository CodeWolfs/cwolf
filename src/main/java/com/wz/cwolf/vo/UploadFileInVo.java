package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author WangZhe
 * @version 1.0
 * @className UploadFileInVo
 * @description
 * @date 2022/12/5 10:51
 */

@ApiModel("上传文件入参")
@Data
public class UploadFileInVo {

    @ApiModelProperty(value = "存储桶",required = true)
    @NotBlank(message = "存储桶不可为空")
    private String bucketName;

    @ApiModelProperty(value = "关联业务id",required = false)
    private String relationId;

    @ApiModelProperty(value = "接入系统编码",required = false)
    private String relationCode;
}
