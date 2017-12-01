package com.sap.banking.loan.beans;

import java.util.Collection;

public class LoanApplication {

	private String applicationId;
	private LoanTypes loanType;
	private LoanRequirement loanRequirement;
	private CustomerDetails customerDetails;
	private Collection<LoanOffer> offers;

	protected String getApplicationId() {
		return applicationId;
	}

	protected void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	protected LoanTypes getLoanType() {
		return loanType;
	}

	protected void setLoanType(LoanTypes loanType) {
		this.loanType = loanType;
	}

	protected LoanRequirement getLoanRequirement() {
		return loanRequirement;
	}

	protected void setLoanRequirement(LoanRequirement loanRequirement) {
		this.loanRequirement = loanRequirement;
	}

	protected CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	protected void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	protected Collection<LoanOffer> getOffers() {
		return offers;
	}

	protected void setOffers(Collection<LoanOffer> offers) {
		this.offers = offers;
	}

}
