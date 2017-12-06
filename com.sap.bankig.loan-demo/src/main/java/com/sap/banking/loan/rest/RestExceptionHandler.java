package com.sap.banking.loan.rest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sap.banking.loan.exceptions.BusinessException;
import com.sap.banking.loan.exceptions.UnauthorizedAccessException;

/**
 * Controller advice for RestController with {@link RestController} annotation.
 * This advice will be applied for all such RestControllers
 * 
 * @author I313873
 *
 */
@RestControllerAdvice(annotations = { RestController.class })
public class RestExceptionHandler  {

	/**
	 * Handle exceptions thrown from all RequestMappings
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ UnauthorizedAccessException.class })
	public ResponseEntity<Object> handleRestServiceExceptions(BusinessException ex, WebRequest request) {

		if (ex instanceof UnauthorizedAccessException) {
			return new ResponseEntity<Object>(null, UNAUTHORIZED);
		}

		// if no mapping found, return as internal server error
		return new ResponseEntity<Object>(ex, INTERNAL_SERVER_ERROR);
	}
}
