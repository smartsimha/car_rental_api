package com.ty.carrentalapi.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.carrentalapi.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handNoIdFoundException(NoIdFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NOT FOUND");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidEmailException(InvalidEmailException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NOT FOUND");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialException(
			InvalidCredentialException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NOT FOUND");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> info = new LinkedHashMap<String, String>();
		List<FieldError> errors = ex.getFieldErrors();
		for (FieldError error : errors) {
			String fieldName = error.getField();
			String message = error.getDefaultMessage();
			info.put(fieldName, message);
		}
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("BAD REQUEST");
		responseStructure.setData(info);
		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DLNotFoundException.class)
	private ResponseEntity<ResponseStructure<String>> handleDLNotFoundExcetion(DLNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NOT FOUND");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
