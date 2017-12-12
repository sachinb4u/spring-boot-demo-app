package com.sap.banking.loan.exceptions;

import static java.lang.String.format;

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
public class LoanApplicationNotFoundException extends BusinessException {

	private static final long serialVersionUID = -5675182492818174290L;
	private static final String messagegFormat = "LoanApplication with id %s not found";

	public LoanApplicationNotFoundException(String applicationId) {
		super(format(messagegFormat, applicationId));
	}

	public LoanApplicationNotFoundException(String applicationId, Throwable cause) {
		super(format(messagegFormat, applicationId), cause);
	}

	public LoanApplicationNotFoundException(Throwable cause) {
		super(cause);
	}

}
