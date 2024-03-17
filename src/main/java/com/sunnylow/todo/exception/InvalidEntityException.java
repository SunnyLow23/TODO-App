package com.sunnylow.todo.exception;

import java.util.List;

public class InvalidEntityException extends RuntimeException {

	private static final long serialVersionUID = 2;

	private ErrorCodes errorCodes;

	private List<String> errors;

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEntityException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes;
	}

	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes) {
		super(message, cause);
		this.errorCodes = errorCodes;
	}

	public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
		super(message);
		this.errorCodes = errorCodes;
		this.errors = errors;
	}

	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes, List<String> errors) {
		super(message, cause);
		this.errorCodes = errorCodes;
		this.errors = errors;
	}

	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

	public List<String> getErrors() {
		return errors;
	}
}
