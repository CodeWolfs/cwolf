package com.wz.cwolf.service.Impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.wz.cwolf.service.PdfGenerateService;
import com.wz.cwolf.util.PdfUtil;
import com.wz.cwolf.vo.GeneratePdfInVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        PdfUtil pdfUtil = null;
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D://pdf/pdfTest1.pdf"));
            pdfUtil = new PdfUtil(document,pdfWriter);
            pdfUtil.open();

            //创建段落
            BaseFont baseChineseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            Font font = new Font(baseChineseFont, 12, Font.NORMAL,BaseColor.BLACK);

            Paragraph firstParagraph = new Paragraph("俄罗斯历史始于东斯拉夫人，亦是后来的俄罗斯人、乌克兰人和白俄罗斯人。基辅罗斯是东斯拉夫人建立的第一个国家。988年开始，东正教从拜占庭帝国传入基辅罗斯，由此拉开了拜占庭和斯拉夫文化的融合，并最终形成了占据未来700年时间的俄罗斯文化。12世纪中叶，基辅罗斯完全分裂成独立的小公国",font);
            firstParagraph.setAlignment(0); //设置文本对齐方式居中 0靠左 1，居中 2，靠右
            firstParagraph.setFirstLineIndent(24); //设置首行缩进
            firstParagraph.setLeading(20f); //行间距
            firstParagraph.setSpacingBefore(200f); //设置段落上空白
            firstParagraph.setSpacingAfter(100f); //设置段落下空白

            // 直线
            Paragraph p1 = new Paragraph();
            p1.add(new Chunk(new LineSeparator()));

// 点线
            Paragraph p2 = new Paragraph();
            p2.add(new Chunk(new DottedLineSeparator()));

// 超链接
            Anchor anchor = new Anchor("baidu");
            anchor.setReference("www.baidu.com");

// 定位
            Anchor gotoP = new Anchor("goto");
            gotoP.setReference("#top");


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
            cell[0] = new PdfPCell(new Paragraph("测试",font));
            cell[1] = new PdfPCell(new Paragraph("单元格1",font));
            cell[2] = new PdfPCell(new Paragraph("单元格2",font));
            cell[3] = new PdfPCell(new Paragraph("单元格3",font));

            //表格添加列
            basicInfoTableRows.add(pdfPRow);
            basicInfoTableRows.add(pdfPRow);
            //文档添加内容
            document.add(firstParagraph);
            document.add(basicInfoTable);
            document.add(firstParagraph);
            document.add(p1);
            document.add(p2);
            document.add(anchor);
            document.add(gotoP);


            //设置pdf基本属性
            pdfUtil.setAttr("测试pdf基本属性","王哲","测试", "测试;pdf", "wolfApplication");
            //添加图片，坐标是以左下角为基点
            ArrayList<Image> images = new ArrayList<>();
            Image image1 = Image.getInstance("C:\\Users\\THINKPAD\\Pictures\\Camera Roll\\blog\\006bkCTrly1h16xjvpsyzj30wi1yce35.jpg");
            image1.scaleAbsolute(300,200);
            Image image2 = Image.getInstance("https://t7.baidu.com/it/u=737555197,308540855&fm=193&f=GIF");
            image2.scaleAbsolute(100,100);
            images.add(image1);
            images.add(image2);
            pdfUtil.addImages(images);

            //添加有序列表
            List orderedList = new List(List.ORDERED);
            orderedList.add(new ListItem("Item one", font));
            orderedList.add(new ListItem("Item two", font));
            orderedList.add(new ListItem("Item 散四五", font));
            pdfUtil.addOrderedList(orderedList);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            assert pdfUtil != null;
            pdfUtil.close();
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

    /**
     * 生成社会保险参保证明
     */
    private void generateSocialPdf() {
        //根据链接生成 二维码

        Document document = null;
        BaseFont baseChineseFont = null;
        Font titleFont = null;
        Font tableKeyFont = null;
        Font tableValueFont = null;
        try {
            document = new Document();
            baseChineseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            titleFont = new Font(baseChineseFont, 25, Font.BOLD, BaseColor.BLACK);
            tableKeyFont = new Font(baseChineseFont, 18, Font.BOLD, BaseColor.BLACK);
            tableValueFont = new Font(baseChineseFont, 18, Font.NORMAL, BaseColor.BLACK);


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
