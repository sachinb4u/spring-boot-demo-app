package com.sap.banking.loan.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Email;

import com.sap.banking.loan.validations.constraints.PhoneNumber;
import com.sap.banking.loan.validations.groups.AddLoanApplication;

public class CustomerDetails {

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Size(min = 5, max = 30, groups = { Default.class, AddLoanApplication.class })
	private String firstName;

	@Size(min = 1, max = 30, groups = { Default.class, AddLoanApplication.class })
	private String middleName;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Size(min = 5, max = 30, groups = { Default.class, AddLoanApplication.class })
	private String lastName;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private Genders gender;

	@NotNull
	@Valid
	private Address address;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	private Professions profession;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@PhoneNumber(size = 8, groups = { Default.class, AddLoanApplication.class })
	private String phone;

	@NotNull(groups = { Default.class, AddLoanApplication.class })
	@Email(groups = { Default.class, AddLoanApplication.class })
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Professions getProfession() {
		return profession;
	}

	public void setProfession(Professions profession) {
		this.profession = profession;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
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
		CustomerDetails other = (CustomerDetails) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (profession != other.profession)
			return false;
		return true;
	}

}
