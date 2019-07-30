package com.lcl.erefill.core.exception;

import com.lcl.erefill.core.common.entity.UserToken;

public class ERefillBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5224454944026655679L;

	private UserToken userToken;
	
	public ERefillBusinessException() {
		super();
	}

	public ERefillBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ERefillBusinessException(String message) {
		super(message);
	}

	public ERefillBusinessException(Throwable cause) {
		super(cause);
	}

	public ERefillBusinessException(String message, String status, String token) {
		super(message);
		if (userToken == null){
			userToken = new UserToken();
		}
		userToken.setStatus(status);
		userToken.setToken(token);
	}
	
	public UserToken getUserToken(){
		return userToken;
	}
}
