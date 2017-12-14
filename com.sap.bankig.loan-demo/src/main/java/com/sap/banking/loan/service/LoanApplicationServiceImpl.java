package com.sap.banking.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sap.banking.loan.beans.LoanApplication;
import com.sap.banking.loan.exceptions.LoanApplicationNotFoundException;
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
	public LoanApplication getLoanApplicationByapplicationId(Long applicationId) {
		LoanApplication application = repository.findOne(applicationId);
		if (application == null) {
			throw new LoanApplicationNotFoundException(String.valueOf(applicationId));
		}
		return application;
	}


	@Override
	public void deleteLoanApplication(Long applicationId) {
		try {
			repository.delete(applicationId);
		} catch (EmptyResultDataAccessException dataAccessException) {
			throw new LoanApplicationNotFoundException(String.valueOf(applicationId), dataAccessException);
		}
	}


	@Override
	public List<LoanApplication> getAllLoanApplications() {
		return repository.findAll();
	}

}
