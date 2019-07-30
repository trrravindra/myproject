package com.lcl.erefill.core.exception;

public class InvalidUserPasswordException extends ERefillApplicationException {

	private static final long serialVersionUID = -969694228843324687L;

	private String status;

	private String token;

	public InvalidUserPasswordException() {
		super();
	}

	public InvalidUserPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserPasswordException(String message) {
		super(message);
	}

	public InvalidUserPasswordException(Throwable cause) {
		super(cause);
	}

	public InvalidUserPasswordException(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public String getToken() {
		return token;
	}

}
