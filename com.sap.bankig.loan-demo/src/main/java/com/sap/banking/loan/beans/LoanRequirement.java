package com.sap.banking.loan.beans;

public class LoanRequirement {

	protected long loanAmount;
	protected int tenureInYears;

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenureInYears() {
		return tenureInYears;
	}

	public void setTenureInYears(int tenureInYears) {
		this.tenureInYears = tenureInYears;
	}

}
