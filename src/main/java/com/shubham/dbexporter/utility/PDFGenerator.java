package com.shubham.dbexporter.utility;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.shubham.dbexporter.model.Customer;

public class PDFGenerator {
	
	private List<Customer> customerList;
    
    public PDFGenerator(List<Customer> customerList) {
        this.customerList = customerList;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(3);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);     
    }
     
    private void writeTableData(PdfPTable table) {
        for (Customer customer : customerList) {
            table.addCell(String.valueOf(customer.getId()));
            table.addCell(customer.getName());
            table.addCell(customer.getAddress());
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.5f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
         
    }
}
