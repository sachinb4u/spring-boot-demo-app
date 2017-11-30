package com.sap.banking.loan.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanRest {
	
	
	@GetMapping("/loan")
	public String sayHello() {
		return "Hello to Rest service from sachin";
	}
	
	
	@GetMapping("/")
	public String sayHi() {
		return "This is a loan demo app ";
	}

}
