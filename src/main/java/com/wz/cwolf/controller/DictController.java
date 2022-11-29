package com.wz.cwolf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.dto.DictDto;
import com.wz.cwolf.dto.DictInsertInDto;
import com.wz.cwolf.service.DictService;
import com.wz.cwolf.vo.DictConditionVo;
import com.wz.cwolf.vo.DictDeleteVo;
import com.wz.cwolf.vo.DictInsertVo;
import com.wz.cwolf.vo.DictUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@RestController
@Api(tags = "字典管理")
public class DictController {
    @Autowired
    private DictService dictService;

    @GetMapping("/dicts")
    @ApiOperation("字典查询")
    public Result<?> query(@Validated DictConditionVo dictConditionVo) {
        Page<DictDto> dictDtoPage = dictService.queryDict(dictConditionVo);
        return Result.ok(dictDtoPage);
    }

    @PostMapping("/dict")
    @ApiOperation("字典插入")
    public Result<?> insert(@Validated @RequestBody DictInsertVo dictInsertVo) {
        DictInsertInDto dictInsertInDto = new DictInsertInDto();
        BeanUtils.copyProperties(dictInsertVo,dictInsertInDto);
        dictInsertInDto.setStatus("1");
        dictInsertInDto.setDictCode(dictInsertInDto.getDictCode().toUpperCase(Locale.ROOT));
        dictService.insertDict(dictInsertInDto);
        return Result.ok();
    }

    @PutMapping("/dict")
    @ApiOperation("字典更新")
    public Result<?> update(@Validated @RequestBody DictUpdateVo dictUpdateVo) {
        dictUpdateVo.setDictCode(dictUpdateVo.getDictCode().toUpperCase(Locale.ROOT));
        dictService.updateDict(dictUpdateVo);
        return Result.ok();
    }

    @DeleteMapping("/dict")
    @ApiOperation("字典删除")
    public Result<?> delete(@Validated DictDeleteVo dictDeleteVo) {
        dictService.deleteDict(dictDeleteVo);
        return Result.ok();
    }

}
