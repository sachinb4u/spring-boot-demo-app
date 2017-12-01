package com.sap.banking.loan.beans;

public class CustomerDetails {

	private String firstName;
	private String middleName;
	private String lastName;
	private Genders gender;
	private Address address;
	private Professions profession;
	private String phone;
	private String email;

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getMiddleName() {
		return middleName;
	}

	protected void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected Genders getGender() {
		return gender;
	}

	protected void setGender(Genders gender) {
		this.gender = gender;
	}

	protected Address getAddress() {
		return address;
	}

	protected void setAddress(Address address) {
		this.address = address;
	}

	protected Professions getProfession() {
		return profession;
	}

	protected void setProfession(Professions profession) {
		this.profession = profession;
	}

	protected String getPhone() {
		return phone;
	}

	protected void setPhone(String phone) {
		this.phone = phone;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

}
