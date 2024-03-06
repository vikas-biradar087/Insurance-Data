package com.Insurance.service;

import java.util.List;

import com.Insurance.Entity.SearchRequest;

public interface CitizenPlan {
	
	List<String> getcitizenPlane();
	
	List<String> getPlanStatus();
	
	List<CitizenPlan> getcitigenPlans(SearchRequest searchRequest);

}
