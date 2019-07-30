package com.lcl.erefill.core.vo;

import java.io.Serializable;

/**
 * @author vsha51
 */
public class ValidateUserRequest implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7736607206365984470L;

	private String username;
	
	private String user_token;
	
	private String recaptcha_response_field;
	
	private String recaptcha_challenge_field;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return user_token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.user_token = token;
	}

	/**
	 * @return the recaptcha_response_field
	 */
	public String getRecaptcha_response_field() {
		return recaptcha_response_field;
	}

	/**
	 * @param recaptcha_response_field the recaptcha_response_field to set
	 */
	public void setRecaptcha_response_field(String recaptcha_response_field) {
		this.recaptcha_response_field = recaptcha_response_field;
	}

	/**
	 * @return the recaptcha_challenge_field
	 */
	public String getRecaptcha_challenge_field() {
		return recaptcha_challenge_field;
	}

	/**
	 * @param recaptcha_challenge_field the recaptcha_challenge_field to set
	 */
	public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
		this.recaptcha_challenge_field = recaptcha_challenge_field;
	}

	
		
}
