package com.lcl.erefill.core.common.telus.response;

public class SubmitRefillResponse {
	
	/**
	 * 
	 */
	private String update_status;
	private String message;
	private String token_value;
	private String token_status;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the update_status
	 */
	public String getUpdate_status() {
		return update_status;
	}
	/**
	 * @param update_status the update_status to set
	 */
	public void setUpdate_status(String update_status) {
		this.update_status = update_status;
	}
	/**
	 * @return the token_value
	 */
	public String getToken_value() {
		return token_value;
	}
	/**
	 * @param token_value the token_value to set
	 */
	public void setToken_value(String token_value) {
		this.token_value = token_value;
	}
	/**
	 * @return the token_status
	 */
	public String getToken_status() {
		return token_status;
	}
	/**
	 * @param token_status the token_status to set
	 */
	public void setToken_status(String token_status) {
		this.token_status = token_status;
	}
}
