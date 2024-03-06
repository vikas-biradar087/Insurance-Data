package com.Insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Insurance.Entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Long> {

}
