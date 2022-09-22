package com.example.balcamgym.Utils;

import com.example.balcamgym.DTO.BillDTO;
import com.example.balcamgym.DTO.BillSubscriptionDTO;
import com.example.balcamgym.Models.BillSubscription;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.Subscription;
import com.example.balcamgym.Services.BillSubscriptionServices;
import com.example.balcamgym.Services.ProductServices;
import com.example.balcamgym.Services.SubscriptionServices;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PdfSubGenerator {
    public static void createBillSusbcription (BillSubscription billSubscription){
        Font titleFont = new Font(Font.FontFamily.HELVETICA,18);
        Font subFont = new Font(Font.FontFamily.HELVETICA,12);
        Font headersFont = new Font(Font.FontFamily.HELVETICA,14);

        try {
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, new FileOutputStream("c:/temp/billSusbcription.pdf"));
            //PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));

            document.open();
            document.setMargins(1,1,1,1);





            Paragraph titleClient = new Paragraph( billSubscription.getClient().getFirstName()+" "+ billSubscription.getClient().getLastName(),titleFont);
            titleClient.setSpacingAfter(3);
            titleClient.setAlignment(Element.ALIGN_CENTER);
            titleClient.setSpacingBefore(-2);

            Paragraph subTitle = new Paragraph("Invoice number: " + billSubscription.getSubscription().getId(),subFont);
            subTitle.setAlignment(Element.ALIGN_CENTER);
            subTitle.setSpacingAfter(1);

            Paragraph date = new Paragraph("Current date: " + LocalDate.now(), subFont);
            date.setSpacingAfter(6);
            date.setAlignment(Element.ALIGN_CENTER);




            Image img = Image.getInstance("src/main/resources/static/web/assets/images/logofinal.png");
            img.scaleAbsoluteWidth(200);
            img.scaleAbsoluteHeight(70);
            img.setAlignment(Element.ALIGN_CENTER);

            PdfPTable pdfPTable = new PdfPTable(4);
            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Type", headersFont));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Price", headersFont));
            PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("From Date", headersFont));
            PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("To Date",headersFont));
            pdfPCell1.setBorder(0);
            pdfPCell3.setBorder(0);
            pdfPCell4.setBorder(0);
            pdfPCell5.setBorder(0);
            pdfPCell1.setPadding(1);
            pdfPCell3.setPadding(2);
            pdfPCell4.setPadding(2);
            pdfPCell5.setPadding(2);
            pdfPCell1.setBackgroundColor(new BaseColor(255, 192, 0));
            pdfPCell3.setBackgroundColor(new BaseColor(255, 192, 0));
            pdfPCell4.setBackgroundColor(new BaseColor(255, 192, 0));
            pdfPCell5.setBackgroundColor(new BaseColor(255, 192, 0));
            pdfPTable.addCell(pdfPCell1);
            pdfPTable.addCell(pdfPCell3);
            pdfPTable.addCell(pdfPCell4);
            pdfPTable.addCell(pdfPCell5);



                PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(String.valueOf(billSubscription.getSubscription().getSubscriptionTypes()),subFont));
                PdfPCell pdfPCell8 = new PdfPCell(new Paragraph("$" + billSubscription.getSubscription().getAmount(), subFont));
                PdfPCell pdfPCell9 = new PdfPCell(new Paragraph(String.valueOf(billSubscription.getSubscription().getFromDate()), subFont));
                PdfPCell pdfPCell10 = new PdfPCell(new Paragraph(String.valueOf(billSubscription.getSubscription().getToDate())));
                pdfPCell6.setBorder(1);
                pdfPCell8.setBorder(1);
                pdfPCell9.setBorder(1);
                pdfPCell10.setBorder(1);

                pdfPTable.addCell(pdfPCell6);
                pdfPTable.addCell(pdfPCell8);
                pdfPTable.addCell(pdfPCell9);
                pdfPTable.addCell(pdfPCell10);


            document.add(img);

            document.add(titleClient);
            document.add(subTitle);
            document.add(date);
            document.add(pdfPTable);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

