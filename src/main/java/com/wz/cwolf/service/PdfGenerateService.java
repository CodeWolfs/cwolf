package com.wz.cwolf.service;

import com.wz.cwolf.vo.GeneratePdfInVo;
import org.springframework.http.ResponseEntity;

/**
 * @author WangZhe
 * @version 1.0
 * @className PdfGenerateService
 * @description
 * @date 2022/12/15 15:05
 */


public interface PdfGenerateService {
    ResponseEntity<byte[]> codeGeneratePdf(GeneratePdfInVo generatePdfInVo);
    ResponseEntity<byte[]> templateGeneratePdf(GeneratePdfInVo generatePdfInVo);
    ResponseEntity<byte[]> html2PdfGenerate(GeneratePdfInVo generatePdfInVo);
}
