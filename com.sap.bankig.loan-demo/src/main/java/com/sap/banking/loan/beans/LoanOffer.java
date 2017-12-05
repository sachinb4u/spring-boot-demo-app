package com.sap.banking.loan.beans;

import java.math.BigDecimal;

public class LoanOffer extends LoanRequirement {

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

}
