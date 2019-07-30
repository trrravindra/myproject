package com.lcl.erefill.core.common.entity;

import java.io.Serializable;



public class UserToken implements Serializable {
	
	private static final long serialVersionUID = -7455077063176164923L;
	
	private String status;
	
	private String token;
	
	public UserToken(){
		
	}
	
	public UserToken(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserToken [status=" + status + ", token=" + token + "]";
	}
	
	
	
}
