package com.sap.banking.loan.beans;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class LoanRequirement {

	@NotNull
	@Range(min= 25000, max = 10000000)
	protected long loanAmount;

	@NotNull
	@Range(min= 2, max = 5)
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
