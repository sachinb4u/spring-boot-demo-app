package com.sap.banking.loan.rest;

import static java.util.concurrent.TimeUnit.DAYS;
import static org.springframework.http.HttpStatus.NOT_MODIFIED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.CacheControl;
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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

	/**
	 * Get resource uses ETag to save network bandwidth by returning Not_Modified(304) if resource is not changed
	 * 
	 * @param applicationId
	 * @param request
	 * @return
	 */
	@GetMapping("/{applicationId}")
	@ResponseBody
	public ResponseEntity<LoanApplication> getLoanApplication(@PathVariable String applicationId, WebRequest request) {

		if (!loanAppsMap.containsKey(applicationId)) {
			throw new LoanApplicationNotFoundException(applicationId);
		}
		LoanApplication loanApp = loanAppsMap.get(applicationId);

		// if not found
		if (loanApp == null) {
			throw new LoanApplicationNotFoundException(applicationId);
		}

		// consider hashCode as ETag value
		String etagValue = String.valueOf(loanApp.hashCode());

		// Check ETag with If-None-Match header sent by client and send NOT_MODIFIED(304) status code without content
		if (request.checkNotModified(etagValue)) {
			return new ResponseEntity<LoanApplication>(NOT_MODIFIED);
		}

		return ResponseEntity.ok().eTag(etagValue).body(loanApp);
	}

	/**
	 * Post returns URL of newly created resource in Location header and entity in body.
	 * 
	 * @param application
	 * @param uriBuilder
	 * @return
	 */
	@PostMapping(consumes = { APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> addLoanApplication(@RequestBody @Validated(AddLoanApplication.class) LoanApplication application,
			UriComponentsBuilder uriBuilder) {

		String appId = UUID.randomUUID().toString();
		application.setApplicationId(appId);
		loanAppsMap.put(appId, application);

		// Create LoanApplication and return the location URL to retrieve application with id.
		UriComponents uriComponents = uriBuilder.path("/loanapplications/{applicationId}").buildAndExpand(appId);

		// response should contain location URL to retrieve created resource
		return ResponseEntity.created(uriComponents.toUri()).body(application);
	}

	/**
	 * Delete returns No_Content(204) on successful delete and 404 if resource not found
	 * 
	 * @param applicationId
	 */
	@DeleteMapping("/{applicationId}")
	@ResponseStatus(NO_CONTENT)
	public void deleteLoanApplication(@PathVariable String applicationId) {
		if (!loanAppsMap.containsKey(applicationId)) {
			throw new LoanApplicationNotFoundException(applicationId);
		}

		loanAppsMap.remove(applicationId);
	}

	/**
	 * Enable client side caching with CacheControl headers for static data
	 * 
	 * @return
	 */
	@GetMapping("/loantypes")
	public ResponseEntity<LoanTypes[]> getLoanTypes() {
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, DAYS)).body(LoanTypes.values());
	}

	/**
	 * Enable client side caching with CacheControl headers for static data
	 * 
	 * @return
	 */
	@GetMapping("/professions")
	@ResponseBody
	public ResponseEntity<Professions[]> getProfessions() {
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, DAYS)).body(Professions.values());
	}
}
