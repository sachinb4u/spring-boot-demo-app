package com.sap.banking.loan.beans;

public class Address {

	private String line1;
	private String line2;
	private String landmark;
	private String city;
	private String state;
	private String pincode;

	protected String getLine1() {
		return line1;
	}

	protected void setLine1(String line1) {
		this.line1 = line1;
	}

	protected String getLine2() {
		return line2;
	}

	protected void setLine2(String line2) {
		this.line2 = line2;
	}

	protected String getLandmark() {
		return landmark;
	}

	protected void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getState() {
		return state;
	}

	protected void setState(String state) {
		this.state = state;
	}

	protected String getPincode() {
		return pincode;
	}

	protected void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
