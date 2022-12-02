package com.wz.cwolf.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wz.cwolf.service.ChinaHolidayService;
import com.wz.cwolf.vo.base.PagePropertyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className ChinaHolidayConditionVo
 * @description
 * @date 2022/11/30 16:57
 */

@ApiModel("中国节假日查询入参")
@Data
public class ChinaHolidayConditionInVo extends PagePropertyVo {


    @ApiModelProperty("节假日期")
    private String holidayDate;

    @ApiModelProperty("日期类型")
    private String holidayType;

    @ApiModelProperty("有效")
    private String status;

    @ApiModelProperty("创建员")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新员")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("备注")
    private String remark;


}
