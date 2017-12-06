package com.sap.banking.loan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * {@link ResponseStatus} annotation is handled by
 * {@link ResponseEntityExceptionHandler} to set the status code if this
 * exception is thrown
 * 
 * @author I313873
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanApplicationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6421372506198842581L;

	public LoanApplicationNotFoundException(String appId) {
		super("Loan Application Not Found with id " + appId);
	}

}
