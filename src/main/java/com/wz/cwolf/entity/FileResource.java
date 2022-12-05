package com.wz.cwolf.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 上传文件信息
 * </p>
 *
 * @author wz
 * @since 2022-41-05
 */
@Getter
@Setter
@TableName("FILE_RESOURCE")
@ApiModel(value = "FileResource对象", description = "上传文件信息")
public class FileResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "ID",type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("关联业务id")
    @TableField("RELATION_ID")
    private String relationId;

    @ApiModelProperty("接入系统编码")
    @TableField("RELATION_CODE")
    private String relationCode;

    @ApiModelProperty("存储桶名称")
    @TableField("BUCKET_NAME")
    private String bucketName;

    @ApiModelProperty("文件名称")
    @TableField("FILE_NAME")
    private String fileName;

    @ApiModelProperty("有效位")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty("创建人")
    @TableField("CREATE_BY")
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    @TableField("UPDATE_BY")
    private String updateBy;

    @ApiModelProperty("更新时间")
    @TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("备注")
    @TableField("REMARK")
    private String remark;
}
