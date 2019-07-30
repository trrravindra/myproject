package com.lcl.erefill.core.utils;

public class JSONRedirectResponse {
	final String status = "success";
	private String redirectLocation;

	public String getRedirectLocation() {
		return redirectLocation;
	}

	public void setRedirectLocation(String redirectLocation) {
		this.redirectLocation = redirectLocation;
	}

	public String getStatus() {
		return status;
	}

}
