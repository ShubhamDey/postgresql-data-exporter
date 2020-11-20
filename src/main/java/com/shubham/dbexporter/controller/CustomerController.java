package com.shubham.dbexporter.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lowagie.text.DocumentException;
import com.shubham.dbexporter.model.Customer;
import com.shubham.dbexporter.service.CustomerService;
import com.shubham.dbexporter.utility.ExcelGenerator;
import com.shubham.dbexporter.utility.PDFGenerator;

@RestController
@RequestMapping(path = "/customers/export")
public class CustomerController {
		
	@Autowired
	private CustomerService service;
	
	@GetMapping(path = "/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        	String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Customers_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		List<Customer> customers = service.listAll();
		ExcelGenerator excelGenerator = new ExcelGenerator(customers);
		excelGenerator.export(response);
	}
	
	@GetMapping(path = "/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        	response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        	String currentDateTime = dateFormatter.format(new Date());
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Customers_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        List<Customer> customers = service.listAll();
	        PDFGenerator pdfGenerator = new PDFGenerator(customers);
	        pdfGenerator.export(response);
    	}
	
}
