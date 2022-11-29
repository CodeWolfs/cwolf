package com.wz.cwolf.controller;

import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.service.MybatisPlusGeneratorService;
import com.wz.cwolf.vo.MybatisGenerateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisPlusGeneratorController
 * @description
 * @date 2022/11/28 16:59
 */
@RestController
@Api(tags = "mybatis 代码生成")
@RequestMapping("/generator")
public class MybatisPlusGeneratorController {

    @Autowired
    private MybatisPlusGeneratorService mybatisPlusGeneratorService;

    @PostMapping("/generate")
    @ApiOperation("mybatis代码生成")
    public Result<?> generate(@RequestBody @Validated MybatisGenerateVo mybatisGenerateVo) {
        mybatisPlusGeneratorService.generate(mybatisGenerateVo);
        return Result.ok();
    }

}
