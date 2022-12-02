package com.wz.cwolf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.dto.DictItemInsertInDto;
import com.wz.cwolf.dto.DictItemOutDto;
import com.wz.cwolf.service.DictItemService;
import com.wz.cwolf.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典项表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */

@RestController
@Api(tags = "字典项管理")
public class DictItemController {
    @Autowired
    private DictItemService dictItemService;

    @GetMapping("/dictItems")
    @ApiOperation("字典项查询")
    public Result<?> query(@Validated DictItemConditionVo dictItemConditionVo) {
        Page<DictItemOutDto> dictItemDtoPage = dictItemService.queryDictItems(dictItemConditionVo);
        return Result.ok(dictItemDtoPage);
    }

    @PostMapping("/dictItem")
    @ApiOperation("字典项插入")
    public Result<?> insert(@Validated @RequestBody DictItemInsertInVo dictItemInsertInVo) {
        DictItemInsertInDto dictItemInsertInDto = new DictItemInsertInDto();
        BeanUtils.copyProperties(dictItemInsertInVo,dictItemInsertInDto);
        dictItemInsertInDto.setStatus("1");
        dictItemService.insertDictItem(dictItemInsertInDto);
        return Result.ok();
    }

    @PutMapping("/dictItem")
    @ApiOperation("字典更新")
    public Result<?> update(@Validated @RequestBody DictItemUpdateInVo dictItemUpdateInVo) {
        dictItemService.updateDictItem(dictItemUpdateInVo);
        return Result.ok();
    }

    @DeleteMapping("/dictItem")
    @ApiOperation("字典删除")
    public Result<?> delete(@Validated DictItemDeleteInVo dictItemDeleteInVo) {
        dictItemService.deleteDictItem(dictItemDeleteInVo);
        return Result.ok();
    }

}