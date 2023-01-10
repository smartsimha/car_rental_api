package com.ty.carrentalapi.exception;

public class DLNotFoundException extends RuntimeException{
 
	private String message = "Given DL Not Found";

	public DLNotFoundException(String message) {
		super();
		this.message = message;
	}
	public DLNotFoundException() {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	
}
