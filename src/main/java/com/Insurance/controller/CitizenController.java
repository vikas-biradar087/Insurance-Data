package com.Insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.Entity.CitizenPlan;
import com.Insurance.Entity.SearchRequest;

import com.Insurance.service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/reportApi")
public class CitizenController {
	
	@Autowired
	private CitizenPlanService citizenPlanService;
	public CitizenController(CitizenPlanService citizenPlanService) {
		super();
		this.citizenPlanService = citizenPlanService;
	}
	//http://localhost:8080/reportApi/planName
	@GetMapping("/planName")
	public ResponseEntity<List<String>> getPlanName(){
		
		List<String> Plan= citizenPlanService.getcitizenPlane();
		
		return new ResponseEntity<>(Plan,HttpStatus.OK);
		
	}
	//http://localhost:8080/reportApi/planStatus
	@GetMapping("/planStatus")
	public ResponseEntity<List<String>> getPlanStatus(){
		
		List<String> Planestatus = citizenPlanService.getPlanStatus();
		
		return new ResponseEntity<>(Planestatus,HttpStatus.OK);
		
	}
	//http://localhost:8080/reportApi/requestSearch
	@PostMapping("/requestSearch")
	public ResponseEntity<List<CitizenPlan>> searchRequest(@RequestBody SearchRequest request){
		List<CitizenPlan> requestSearch = citizenPlanService.getcitigenPlans(request);
		
		return new ResponseEntity<>(requestSearch,HttpStatus.OK);
	}
	
	//http://localhost:8080/reportApi/excel
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
	
		response.setContentType("application/octet-stream");
		
		String key= "Content-Disposition";
		
		String value= "attachment;filename=citizen.xlsx";
		
		response.setHeader(key, value);
		
		citizenPlanService.exportExcel(response);
		
		response.flushBuffer();
		
	}
	
	//http://localhost:8080/reportApi/Pdf
	@GetMapping("/Pdf")
	public void exportPdf(HttpServletResponse response) throws Exception{
		
		response.setContentType("applicatin /pdf");
		
		String key= "Content-Disposition";
		
		String value= "attachment;name=citizen.xls";
		
		response.setHeader(key, value);
		
		citizenPlanService.exportPdf(response);
		
		
	}

}
