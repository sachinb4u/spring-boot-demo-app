package com.sap.banking.loan.rest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.banking.loan.beans.LoanApplication;

@RestController
@RequestMapping("/loan")
public class LoanRest {

	private Map<String, LoanApplication> loanAppsMap = new ConcurrentHashMap<>();
	
	@GetMapping("/{applicationId}")
	public LoanApplication getLoanApplication(@PathVariable String applicationId) {
		return loanAppsMap.get(applicationId);
		
	}
	
	
	
	

}
