package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.common.entity.UserToken;


public class Consent extends UserToken {

	private static final long serialVersionUID = -6160642600880366409L;

	private int id;
	private String agreementEnglish;
	private String agreementFrench;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgreementEnglish() {
		return agreementEnglish;
	}

	public void setAgreementEnglish(String agreementEnglish) {
		this.agreementEnglish = agreementEnglish;
	}

	public String getAgreementFrench() {
		return agreementFrench;
	}

	public void setAgreementFrench(String agreementFrench) {
		this.agreementFrench = agreementFrench;
	}

}
