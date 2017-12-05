package com.sap.banking.loan.beans;

import java.util.Collection;

public class LoanApplication {

	private String applicationId;
	private LoanTypes loanType;
	private LoanRequirement loanRequirement;
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
