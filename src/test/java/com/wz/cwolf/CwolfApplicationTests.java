package com.wz.cwolf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;

@SpringBootTest
class CwolfApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    void pdfTest() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            // creation of the different writers
            PdfWriter.getInstance(document , new FileOutputStream("text.pdf"));
            // we add some meta information to the document
            document.addAuthor("Bruno Lowagie");
            document.addSubject("This is the result of a Test.");
            // we open the document for writing
            document.open();
            document.add(new Paragraph("Hello world"));
        } catch(Exception de) {
            System.err.println(de.getMessage());
        }
        document.close();
    }

}
