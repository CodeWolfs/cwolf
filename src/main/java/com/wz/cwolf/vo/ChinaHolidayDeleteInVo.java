package com.wz.cwolf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className ChinaHolidayDeleteInVo
 * @description
 * @date 2022/12/1 10:53
 */

@ApiModel("中国节假日删除入参")
@Data
public class ChinaHolidayDeleteInVo {
    @ApiModelProperty(value = "中国节假日id列表", required = true)
    @NotEmpty(message = "中国节假日id列表不能为空")
    private List<String> ids;
}
