package com.sap.banking.loan.rest;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sap.banking.loan.beans.CustomerDetails;
import com.sap.banking.loan.beans.Genders;
import com.sap.banking.loan.beans.LoanApplication;
import com.sap.banking.loan.beans.LoanRequirement;
import com.sap.banking.loan.beans.LoanTypes;
import com.sap.banking.loan.beans.Professions;
import com.sap.banking.loan.exceptions.LoanApplicationNotFoundException;
import com.sap.banking.loan.validations.groups.AddLoanApplication;

@RestController
@RequestMapping("/loanapplications")
public class LoanApplicationController {

	private Map<String, LoanApplication> loanAppsMap = new ConcurrentHashMap<>();

	{
		LoanApplication application = new LoanApplication();
		application.setApplicationId("123");
		application.setLoanType(LoanTypes.PersonalLoan);

		LoanRequirement loanRequirement = new LoanRequirement();
		loanRequirement.setLoanAmount(10000);
		loanRequirement.setTenureInYears(5);

		application.setLoanRequirement(loanRequirement);
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setFirstName("Sachin");
		customerDetails.setLastName("Bhosale");
		customerDetails.setEmail("sachinb4u@gmail.com");
		customerDetails.setGender(Genders.Male);
		application.setCustomerDetails(customerDetails);

		loanAppsMap.put(application.getApplicationId(), application);
	}

	@GetMapping
	@ResponseBody
	public Collection<LoanApplication> listApplications() {

		return loanAppsMap.values();
	}

	@GetMapping("/{applicationId}")
	@ResponseBody
	public ResponseEntity<LoanApplication> getLoanApplication(@PathVariable String applicationId) {

		if (!loanAppsMap.containsKey(applicationId)) {
			throw new LoanApplicationNotFoundException(applicationId);
		}
		return new ResponseEntity<LoanApplication>(loanAppsMap.get(applicationId), OK);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public void addLoanApplication(@RequestBody @Validated(AddLoanApplication.class) LoanApplication application) {
		String appId = UUID.randomUUID().toString();
		application.setApplicationId(appId);
		loanAppsMap.put(appId, application);
	}

	@DeleteMapping("/{applicationId}")
	@ResponseStatus(NO_CONTENT)
	public void deleteLoanApplication(@PathVariable String applicationId) {
		if (!loanAppsMap.containsKey(applicationId)) {
			throw new LoanApplicationNotFoundException(applicationId);
		}

		loanAppsMap.remove(applicationId);
	}

	@GetMapping("/loantypes")
	public ResponseEntity<LoanTypes[]> getLoanTypes() {
		return new ResponseEntity<LoanTypes[]>(LoanTypes.values(), OK);
	}

	@GetMapping("/professions")
	@ResponseBody
	public ResponseEntity<Professions[]> getProfessions() {
		return new ResponseEntity<Professions[]>(Professions.values(), OK);
	}
}
