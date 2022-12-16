package com.wz.cwolf.util;

import cn.hutool.core.collection.CollUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WangZhe
 * @version 1.0
 * @className PdfUtil
 * @description
 * @date 2022/12/15 14:33
 */

@Data
public class PdfUtil {

    private Document document;
    private PdfWriter pdfWriter;

    public PdfUtil() {
    }

    public PdfUtil(Document document, PdfWriter pdfWriter) {
        this.document = document;
        this.pdfWriter = pdfWriter;
    }

    public void open() {
        document.open();
    }

    public void close() {
        document.close();
        pdfWriter.close();
    }

    public void setAttr(String title, String author, String subject, String keywords, String creator) {
        document.addTitle(title);
        document.addAuthor(author);
        document.addSubject(subject);
        document.addKeywords(keywords);
        document.addCreationDate();
        document.addCreator(creator);
        document.addProducer();
        document.addHeader("test","测试123");
        document.addHeader("test2","测试1234");
    }

    public void addImages(ArrayList<Image> images) {
        if(CollUtil.isNotEmpty(images)) {
            for (Image image :
                    images) {
                try {
                    document.add(image);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addOrderedList(List orderedList) {
        try {
            document.add(orderedList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
