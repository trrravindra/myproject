package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class ManagedAccountJSONResponse implements Serializable{

	private static final long serialVersionUID = -6398192739166578946L;
	
	private String agreementEnglish;
	private String error;
	private String errorType;//Value 0=Display on same page/pop-up, Value 1=Display on a different page/pop-up
	
	/**
	 * @return the agreementEnglish
	 */
	public String getAgreementEnglish() {
		return agreementEnglish;
	}
	/**
	 * @param agreementEnglish the agreementEnglish to set
	 */
	public void setAgreementEnglish(String agreementEnglish) {
		this.agreementEnglish = agreementEnglish;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}
	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
}
