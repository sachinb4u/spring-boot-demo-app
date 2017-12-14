package com.sap.banking.loan.service;

import java.util.List;

import com.sap.banking.loan.beans.LoanApplication;

public interface LoanApplicationService {

	LoanApplication saveLoanApplication(LoanApplication application);

	LoanApplication getLoanApplicationByapplicationId(Long applicationId);

	void deleteLoanApplication(Long applicationId);

	List<LoanApplication> getAllLoanApplications();

}
