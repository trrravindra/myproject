package com.lcl.erefill.core.exception;

public class NoCounsellingSheetException extends ERefillApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2746628465060181158L;

	private String status;

	private String token;

	public NoCounsellingSheetException() {
		super();
	}

	public NoCounsellingSheetException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoCounsellingSheetException(String message) {
		super(message);
	}

	public NoCounsellingSheetException(Throwable cause) {
		super(cause);
	}

	public NoCounsellingSheetException(String status, String token) {
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
