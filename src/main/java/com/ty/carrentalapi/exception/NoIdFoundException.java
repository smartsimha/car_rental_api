package com.ty.carrentalapi.exception;

public class NoIdFoundException extends RuntimeException {

	private String message = "Given Id Not Found";

	public NoIdFoundException(String message) {
		this.message = message;
	}

	public NoIdFoundException() {
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
