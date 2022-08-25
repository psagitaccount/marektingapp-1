package com.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping(value = "/viewCreateLeadPage", method = RequestMethod.GET)
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@ModelAttribute("lead") Lead lead) {
//		leadService.saveLead(lead);
//		return "create_lead";
//	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile) {
//		Lead l = new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		
//		leadService.saveLead(l);
//		return "create_lead";
//	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(LeadData data, Model model) {
		Lead l = new Lead();
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		model.addAttribute("msg", "Lead is saved!!");
		leadService.saveLead(l);
		return "create_lead";
	}

}
