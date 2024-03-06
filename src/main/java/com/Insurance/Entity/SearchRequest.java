package com.Insurance.Entity;

import jakarta.persistence.Entity;

@Entity
public class SearchRequest {

	private String planName;
	
	private String planStatus;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	
}
