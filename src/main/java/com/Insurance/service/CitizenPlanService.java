package com.Insurance.service;

import java.util.List;

import com.Insurance.Entity.CitizenPlan;
import com.Insurance.Entity.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {
	
	List<String> getcitizenPlane();
	
	List<String> getPlanStatus();
	
	List<CitizenPlan> getcitigenPlans(SearchRequest searchRequest);
	
	public void exportExcel(HttpServletResponse response) throws Exception;
	
	public void exportPdf(HttpServletResponse response) throws Exception;

}
