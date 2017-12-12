package com.sap.banking.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.banking.loan.beans.LoanApplication;
import com.sap.banking.loan.persistence.LoanApplicationRepository;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	private LoanApplicationRepository repository;

	@Override
	public LoanApplication saveLoanApplication(LoanApplication application) {
		return repository.save(application);
	}

	@Override
	public LoanApplication getLoanApplicationByapplicationId(String applicationId) {
		return repository.findOne(applicationId);
	}

	@Override
	public void deleteLoanApplication(String applicationId) {
		repository.delete(applicationId);
	}

	@Override
	public List<LoanApplication> getAllLoanApplications() {
		return repository.findAll();
	}

}
