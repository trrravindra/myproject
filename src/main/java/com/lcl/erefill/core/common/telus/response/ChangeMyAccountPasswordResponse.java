package com.lcl.erefill.core.common.telus.response;

public class ChangeMyAccountPasswordResponse extends ERefillResponse {

	private static final long serialVersionUID = -3798487631714343656L;

	private String changePasswordStatus;

	public String getChangePasswordStatus() {
		return changePasswordStatus;
	}

	public void setChangePasswordStatus(String changePasswordStatus) {
		this.changePasswordStatus = changePasswordStatus;
	}

}
