package com.Insurance.Runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Insurance.Entity.CitizenPlan;
import com.Insurance.repository.CitizenPlanRepository;

@Component
public class DataInserter implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository citiRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CitizenPlan c=new CitizenPlan();
		
		c.setCname("vicky");
		c.setEmail("vikas@gmail.com");
		c.setGender("Male");
		c.setNumber(87470814);
		c.setPlanName("SSNP");
		c.setPlanStatus("Approved");
		c.setSsn(784691614l);
		
		CitizenPlan c1=new CitizenPlan();
		c1.setCname("sa");
		c1.setEmail("sa@gmail.com");
		c1.setGender("F");
		c1.setNumber(48440814);
		c1.setPlanName("CCNP");
		c1.setPlanStatus("Denied");
		c1.setSsn(784611224l);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCname("akki");
		c2.setEmail("akki@gmail.com");
		c2.setGender("Male");
		c2.setNumber(87440814);
		c2.setPlanName("SSNP");
		c2.setPlanStatus("Approved");
		c2.setSsn(784691614l);
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCname("sony");
		c3.setEmail("sony@gmail.com");
		c3.setGender("F");
		c3.setNumber(45440814);
		c3.setPlanName("CCNP");
		c3.setPlanStatus("Denied");
		c3.setSsn(784691224l);
		
		List<CitizenPlan> asList = Arrays.asList(c,c1,c2,c3);
		citiRepo.saveAll(asList);
	}

}
