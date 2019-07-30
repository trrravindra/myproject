package com.lcl.erefill.core.common.telus.response;


public class AddAccountAliasResponse extends ERefillResponse {
	
	private static final long serialVersionUID = 1L;
	private String addStatus;
	private String regUserStatus;
    
	public String getAddStatus() {
		return addStatus;
	}

	public void setAddStatus(String addStatus) {
		this.addStatus = addStatus;
	}
	
	public String getRegUserStatus() {
		return regUserStatus;
	}

	public void setRegUserStatus(String regUserStatus) {
		this.regUserStatus = regUserStatus;
	}
}
