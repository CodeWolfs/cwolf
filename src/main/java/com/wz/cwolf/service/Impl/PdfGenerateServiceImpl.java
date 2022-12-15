package com.wz.cwolf.service.Impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wz.cwolf.service.PdfGenerateService;
import com.wz.cwolf.vo.GeneratePdfInVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @author WangZhe
 * @version 1.0
 * @className PdfGenerateServiceImpl
 * @description
 * @date 2022/12/15 15:05
 */

@Service
public class PdfGenerateServiceImpl implements PdfGenerateService {
    @Override
    public ResponseEntity<byte[]> codeGeneratePdf(GeneratePdfInVo generatePdfInVo) {
        Document document = new Document();
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D://pdf/pdfTest1.pdf"));
            document.open();
            //创建段落
            Paragraph firstParagraph = new Paragraph("俄罗斯历史始于东斯拉夫人，亦是后来的俄罗斯人、乌克兰人和白俄罗斯人。基辅罗斯是东斯拉夫人建立的第一个国家。988年开始，东正教从拜占庭帝国传入基辅罗斯，由此拉开了拜占庭和斯拉夫文化的融合，并最终形成了占据未来700年时间的俄罗斯文化。12世纪中叶，基辅罗斯完全分裂成独立的小公国");
            //创建表格
            PdfPTable basicInfoTable = new PdfPTable(4);
            //设置表格样式
            basicInfoTable.setWidthPercentage(100);
            basicInfoTable.setSpacingBefore(10f);
            basicInfoTable.setSpacingAfter(10f);
            basicInfoTable.setWidths(new float[]{1f, 2f, 1f, 2f});


            //设置表格内容
            ArrayList<PdfPRow> basicInfoTableRows = basicInfoTable.getRows();
            PdfPCell[] cell = new PdfPCell[4];
            PdfPRow pdfPRow = new PdfPRow(cell);
            cell[0] = new PdfPCell(new Paragraph("测试"));
            cell[1] = new PdfPCell(new Paragraph("单元格1"));
            cell[2] = new PdfPCell(new Paragraph("单元格2"));
            cell[3] = new PdfPCell(new Paragraph("单元格3"));

            //表格添加列
            basicInfoTableRows.add(pdfPRow);
            basicInfoTableRows.add(pdfPRow);
            //文档添加内容
            document.add(firstParagraph);
            document.add(basicInfoTable);
            document.add(firstParagraph);
            document.close();
            pdfWriter.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResponseEntity<byte[]> templateGeneratePdf(GeneratePdfInVo generatePdfInVo) {
        return null;

    }

    @Override
    public ResponseEntity<byte[]> html2PdfGenerate(GeneratePdfInVo generatePdfInVo) {
        return null;

    }
}
