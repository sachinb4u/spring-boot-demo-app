package com.sap.banking.loan.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Range;

import com.sap.banking.loan.validations.groups.AddLoanApplication;

@Embeddable
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (loanAmount ^ (loanAmount >>> 32));
		result = prime * result + tenureInYears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanRequirement other = (LoanRequirement) obj;
		if (loanAmount != other.loanAmount)
			return false;
		if (tenureInYears != other.tenureInYears)
			return false;
		return true;
	}

}
