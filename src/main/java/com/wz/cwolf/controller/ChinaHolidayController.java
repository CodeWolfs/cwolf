package com.wz.cwolf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.dto.ChinaHolidayQueryOutDto;
import com.wz.cwolf.entity.ChinaHoliday;
import com.wz.cwolf.service.ChinaHolidayService;
import com.wz.cwolf.vo.ChinaHolidayConditionInVo;
import com.wz.cwolf.vo.ChinaHolidayDeleteInVo;
import com.wz.cwolf.vo.ChinaHolidayInsertInVo;
import com.wz.cwolf.vo.ChinaHolidayUpdateInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 中国法定节假日表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-18-29
 */
@RestController
@Api(tags = "中国法定节假日管理")
public class ChinaHolidayController {
    @Resource
    private ChinaHolidayService chinaHolidayService;

    @GetMapping("/chinaHolidays")
    @ApiOperation("节假日查询(分页)")
    public Result<?> query(@Validated ChinaHolidayConditionInVo chinaHolidayConditionInVo) {
        Page<ChinaHolidayQueryOutDto> chinaHolidayQueryOutDtoPage =  chinaHolidayService.queryChinaHolidays(chinaHolidayConditionInVo);
        return Result.ok(chinaHolidayQueryOutDtoPage);
    }

    @PostMapping("/chinaHoliday")
    @ApiOperation("节假日插入")
    public Result<?> insert(@Validated @RequestBody ChinaHolidayInsertInVo chinaHolidayInsertInVo) {
        chinaHolidayService.insertChinaHoliday(chinaHolidayInsertInVo);
        return Result.ok();
    }

    @ApiOperation("节假日Excel批量导入")
    @PostMapping("/chinaHoliday/excelImport")
    public Result<?> importByExcel() {
        // todo 批量导入节假日
        return Result.ok();
    }

    @PutMapping("/chinaHoliday")
    @ApiOperation("节假日更新")
    public Result<?> update(@Validated @RequestBody ChinaHolidayUpdateInVo chinaHolidayUpdateInVo) {
        chinaHolidayService.updateChinaHoliday(chinaHolidayUpdateInVo);
        return Result.ok();
    }

    @DeleteMapping("/chinaHolidays")
    @ApiOperation("节假日删除")
    public Result<?> delete(@Validated ChinaHolidayDeleteInVo chinaHolidayDeleteInVo) {
        chinaHolidayService.deleteChinaHolidays(chinaHolidayDeleteInVo);
        return Result.ok();
    }



}
