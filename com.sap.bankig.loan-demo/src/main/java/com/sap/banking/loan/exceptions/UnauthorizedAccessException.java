package com.sap.banking.loan.exceptions;

public class UnauthorizedAccessException extends BusinessException {

	private static final long serialVersionUID = -9060884606123616015L;
	
	public UnauthorizedAccessException() {
		super("Unauthorized access");
	}

}
