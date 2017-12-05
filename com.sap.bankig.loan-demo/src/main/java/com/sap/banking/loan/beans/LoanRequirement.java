package com.sap.banking.loan.beans;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Range;

import com.sap.banking.loan.validations.groups.AddLoanApplication;

public class LoanRequirement {

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Range(min = 25000, max = 10000000, groups = { Default.class, AddLoanApplication.class })
	protected long loanAmount;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Range(min = 2, max = 5, groups = { Default.class, AddLoanApplication.class })
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
