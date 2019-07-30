package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class UserToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4193301884433669957L;
	
	private String status;
	
	private String token;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
