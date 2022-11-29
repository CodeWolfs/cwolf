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
 * 字典表
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Getter
@Setter
@TableName("DICT")
@ApiModel(value = "Dict对象", description = "字典表")
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键uuid")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("字典名称")
    @TableField("DICT_NAME")
    private String dictName;

    @ApiModelProperty("字典编码")
    @TableField("DICT_CODE")
    private String dictCode;

    @ApiModelProperty("描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty("有效状态")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty("创建人")
    @TableField("CREATE_BY")
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    @TableField("UPDATE_BY")
    private String updateBy;

    @ApiModelProperty("更新时间")
    @TableField(value = "UPDATE_TIME", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
