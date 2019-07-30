package com.lcl.erefill.core.common.telus.response;


public class UpdatePreferencesResponse extends ERefillResponse {

	private static final long serialVersionUID = -7685996351758860369L;
	
	private String responseStatus;

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

}
