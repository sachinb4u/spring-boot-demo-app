package com.sap.banking.loan.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.sap.banking.loan.validations.constraints.Zipcode;
import com.sap.banking.loan.validations.groups.AddLoanApplication;

@Embeddable
public class Address {

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Size(min = 5, max = 40, groups = { Default.class, AddLoanApplication.class })
	private String line1;

	@Size(min = 5, max = 40, groups = { Default.class, AddLoanApplication.class })
	private String line2;

	@Size(min = 5, max = 40, groups = { Default.class, AddLoanApplication.class })
	private String landmark;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private String city;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private String state;

	@NotNull
	@Zipcode(groups = { Default.class, AddLoanApplication.class })
	private String zipcode;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
