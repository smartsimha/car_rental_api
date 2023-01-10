package com.ty.carrentalapi.exception;

public class InvalidCredentialException extends RuntimeException {

	private String message = "Given password is invalid";

	public InvalidCredentialException(String message) {
		this.message = message;
	}

	public InvalidCredentialException() {
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
