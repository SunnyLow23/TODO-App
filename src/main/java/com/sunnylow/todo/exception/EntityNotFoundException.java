package com.sunnylow.todo.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1;

	private ErrorCodes errorCodes;

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes;
	}

	public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes) {
		super(message, cause);
		this.errorCodes = errorCodes;
	}

	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}
}
