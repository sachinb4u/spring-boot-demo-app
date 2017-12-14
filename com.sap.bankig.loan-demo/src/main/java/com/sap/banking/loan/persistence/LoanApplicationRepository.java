package com.sap.banking.loan.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.banking.loan.beans.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}
