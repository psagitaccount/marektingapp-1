package com.marketing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.Leadrepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private Leadrepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);		
	}

}
