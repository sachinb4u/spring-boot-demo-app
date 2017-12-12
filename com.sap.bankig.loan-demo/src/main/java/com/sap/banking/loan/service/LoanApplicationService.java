package com.sap.banking.loan.service;

import java.util.List;

import com.sap.banking.loan.beans.LoanApplication;

public interface LoanApplicationService {

	LoanApplication saveLoanApplication(LoanApplication application);

	LoanApplication getLoanApplicationByapplicationId(String applicationId);

	void deleteLoanApplication(String applicationId);

	List<LoanApplication> getAllLoanApplications();

}
