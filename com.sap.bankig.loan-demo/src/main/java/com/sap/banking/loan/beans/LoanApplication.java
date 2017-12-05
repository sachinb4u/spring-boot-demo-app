package com.sap.banking.loan.beans;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.sap.banking.loan.validations.groups.AddLoanApplication;
import com.sap.banking.loan.validations.groups.DeleteLoanApplication;
import com.sap.banking.loan.validations.groups.UpdateLoanApplication;

public class LoanApplication {

	@NotNull(groups = {DeleteLoanApplication.class, UpdateLoanApplication.class})
	private String applicationId;
	
	@NotNull(message = "Loan type is required", groups = {Default.class, AddLoanApplication.class})
	private LoanTypes loanType;
	
	@NotNull
	@Valid
	private LoanRequirement loanRequirement;
	
	@NotNull
	@Valid
	private CustomerDetails customerDetails;
	
	private Collection<LoanOffer> offers;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public LoanTypes getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanTypes loanType) {
		this.loanType = loanType;
	}

	public LoanRequirement getLoanRequirement() {
		return loanRequirement;
	}

	public void setLoanRequirement(LoanRequirement loanRequirement) {
		this.loanRequirement = loanRequirement;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Collection<LoanOffer> getOffers() {
		return offers;
	}

	public void setOffers(Collection<LoanOffer> offers) {
		this.offers = offers;
	}

}
