package com.sap.banking.loan.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoanOffer extends LoanRequirement {

	@Id
	@GeneratedValue
	private String offerId;
	private int emi;
	private BigDecimal interestRate;
	private int processingFee;
	private BigDecimal totalCost;
	private String conditions;


	public int getEmi() {
		return emi;
	}


	public void setEmi(int emi) {
		this.emi = emi;
	}


	public BigDecimal getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}


	public int getProcessingFee() {
		return processingFee;
	}


	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}


	public BigDecimal getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}


	public String getConditions() {
		return conditions;
	}


	public void setConditions(String conditions) {
		this.conditions = conditions;
	}


	public String getOfferId() {
		return offerId;
	}


	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

}
