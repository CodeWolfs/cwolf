package com.wz.cwolf.controller;

import com.wz.cwolf.common.result.Result;
import com.wz.cwolf.service.PdfGenerateService;
import com.wz.cwolf.vo.GeneratePdfInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangZhe
 * @version 1.0
 * @className PdfGeneratorController
 * @description pdf 生成测试
 * @date 2022/12/15 14:34
 */
@Api(tags = "pdf 生成")
@RestController
public class PdfGeneratorController {
    @Autowired
    private PdfGenerateService pdfGenerateService;
    //todo 代码生成pdf
    //todo 模板生成pdf
    //todo html 转pdf
    @ApiOperation("代码生成pdf")
    @GetMapping("/pdf/generate/code")
    public ResponseEntity<byte[]> codeGeneratePdf(GeneratePdfInVo generatePdfInVo) {
        return pdfGenerateService.codeGeneratePdf(generatePdfInVo);
    }
}
