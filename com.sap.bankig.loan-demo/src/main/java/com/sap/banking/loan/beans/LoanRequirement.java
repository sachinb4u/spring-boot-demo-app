package com.sap.banking.loan.beans;

public class LoanRequirement {

	protected long loanAmount;
	protected int tenure;

	protected long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

}
