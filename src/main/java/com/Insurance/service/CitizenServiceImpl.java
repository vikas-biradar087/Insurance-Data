package com.Insurance.service;

import java.awt.Color;

import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Insurance.Entity.CitizenPlan;
import com.Insurance.Entity.SearchRequest;
import com.Insurance.repository.CitizenPlanRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class CitizenServiceImpl implements CitizenPlanService{

	@Autowired
	private CitizenPlanRepository citiRepo;
	public CitizenServiceImpl(CitizenPlanRepository citiRepo) {
		super();
		this.citiRepo = citiRepo;
	}

	@Override
	public List<String> getcitizenPlane() {
		// TODO Auto-generated method stub
		
		return citiRepo.findByPlanName();
		
		
	}

	@Override
	public List<String> getPlanStatus() {
		
		return citiRepo.findByPlanStatus();
	}
	
	
	@Override
	public List<CitizenPlan> getcitigenPlans(SearchRequest searchRequest) {
		
		CitizenPlan citi=new CitizenPlan();
		
		if(searchRequest.getPlanName()!=null && !searchRequest.getPlanStatus().equals("")) {
			citi.setPlanName(searchRequest.getPlanName());
		}
		
		if(searchRequest.getPlanStatus()!=null && ! searchRequest.getPlanStatus().equals("")) {
			citi.setPlanStatus(searchRequest.getPlanStatus());
		}
		
		if(searchRequest.getGender()!=null && ! searchRequest.getGender().equals("")) {
			citi.setGender(searchRequest.getGender());
		}
		
		Example<CitizenPlan> ex=Example.of(citi);
		List<CitizenPlan> listAll = citiRepo.findAll(ex);
		
		return listAll;
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws Exception{
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Citizen Info");
		
		XSSFRow headerrow = sheet.createRow(0);
		
		headerrow.createCell(0).setCellValue("Id");
		
		headerrow.createCell(1).setCellValue("planName");
		
		headerrow.createCell(2).setCellValue("planStatus");
		
		headerrow.createCell(3).setCellValue("gender");
		
		headerrow.createCell(4).setCellValue("ssn");
		
		headerrow.createCell(5).setCellValue("number");
		
		headerrow.createCell(6).setCellValue("email");
		
		headerrow.createCell(7).setCellValue("cname");
		
		
		
		
		List<CitizenPlan> records = citiRepo.findAll();
		
		int dataRowIndex=1;
		
		for(CitizenPlan record:records) {
			
			XSSFRow dataRow = sheet.createRow(dataRowIndex);
			
			dataRow.createCell(0).setCellValue(record.getId());
			dataRow.createCell(1).setCellValue(record.getCname());
			dataRow.createCell(2).setCellValue(record.getEmail());
			dataRow.createCell(3).setCellValue(record.getGender());
			dataRow.createCell(4).setCellValue(record.getPlanName());
			dataRow.createCell(5).setCellValue(record.getPlanStatus());
			dataRow.createCell(6).setCellValue(record.getNumber());
			dataRow.createCell(7).setCellValue(record.getSsn());
		
			dataRowIndex++;
		
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception{
		
		
		
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Citizen Plane Info !!", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.0f, 3.5f, 3.0f, 3.0f, 3.5f,3.0f,3.0f,2.5f});
        table.setSpacingBefore(12);
        
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(8);
         
        Font f = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("ID", f));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("CitizenName", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Gender", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan Status", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("SSN", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Number", font));
        table.addCell(cell); 
        
         //set table data
        List<CitizenPlan> records = citiRepo.findAll();
        
        for(CitizenPlan record:records) {
        	
        	table.addCell(String.valueOf(record.getId()));
        	table.addCell(record.getCname());
        	table.addCell(String.valueOf(record.getSsn()));
        	table.addCell(record.getGender());
        	table.addCell(record.getPlanName());
        	table.addCell(record.getPlanStatus());
        	
        	
        }
        document.add(table);
         
        document.close();
       
         
		
	}

	

}
