package com.sap.banking.loan.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.sap.banking.loan.validations.groups.AddLoanApplication;
import com.sap.banking.loan.validations.groups.DeleteLoanApplication;
import com.sap.banking.loan.validations.groups.UpdateLoanApplication;

@Entity
public class LoanApplication {

	@Id
	@GeneratedValue
	@NotNull(groups = {DeleteLoanApplication.class, UpdateLoanApplication.class })
	private Long applicationId;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private LoanTypes loanType;

	@Valid
	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private LoanRequirement loanRequirement;

	@Valid
	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private CustomerDetails customerDetails;

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + ((customerDetails == null) ? 0 : customerDetails.hashCode());
		result = prime * result + ((loanRequirement == null) ? 0 : loanRequirement.hashCode());
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
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
		LoanApplication other = (LoanApplication) obj;
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (customerDetails == null) {
			if (other.customerDetails != null)
				return false;
		} else if (!customerDetails.equals(other.customerDetails))
			return false;
		if (loanRequirement == null) {
			if (other.loanRequirement != null)
				return false;
		} else if (!loanRequirement.equals(other.loanRequirement))
			return false;
		if (loanType != other.loanType)
			return false;
		return true;
	}

	
	
}
