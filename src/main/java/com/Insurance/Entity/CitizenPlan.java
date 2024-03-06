package com.Insurance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="citizen")
public class CitizenPlan {

	private long id;
	
	private String planeName;
	
	private String planeStatus;
	
	private String cname;
	
	private String email;
	
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getPlaneStatus() {
		return planeStatus;
	}

	public void setPlaneStatus(String planeStatus) {
		this.planeStatus = planeStatus;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
