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
 * 字典项表
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Getter
@Setter
@TableName("DICT_ITEM")
@ApiModel(value = "DictItem对象", description = "字典项表")
public class DictItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("uuid主键")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("字典id")
    @TableField("DICT_ID")
    private String dictId;

    @ApiModelProperty("字典项文本")
    @TableField("ITEM_TEXT")
    private String itemText;

    @ApiModelProperty("字典项值")
    @TableField("ITEM_VALUE")
    private String itemValue;

    @ApiModelProperty("描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty("排序")
    @TableField("SORT_ORDER")
    private Short sortOrder;

    @ApiModelProperty("有效位")
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
