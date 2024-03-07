package com.Insurance.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Insurance.Entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Serializable> {
	
	@Query("select distinct(planName) from CitizenPlan" )
	List<String> findByPlanName();
	
	
	@Query("select distinct(planStatus) from CitizenPlan")
	List<String> findByPlanStatus();
	
	
	

	

}
