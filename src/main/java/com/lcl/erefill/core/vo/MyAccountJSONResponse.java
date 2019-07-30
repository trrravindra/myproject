package com.lcl.erefill.core.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



/**
 * @author vsha51
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class MyAccountJSONResponse implements Serializable {

	private static final long serialVersionUID = 4784415622086913349L;

	private String update_status;

	private String engagement;

	private String token_value;

	private String token_status;

	private String agreementEnglish;
	
	private String unsubscribed;
	
	private String emailstatus;
	
	private String phonestatus;
	
	public String getPhonestatus() {
		return phonestatus;
	}

	public void setPhonestatus(String phonestatus) {
		this.phonestatus = phonestatus;
	}
	
	public String getEmailstatus() {
		return emailstatus;
	}

	public void setEmailstatus(String emailstatus) {
		this.emailstatus = emailstatus;
	}

	/**
	 * @return the unsubscribed
	 */
	public String getUnsubscribed() {
		return unsubscribed;
	}

	/**
	 * @param unsubscribed the unsubscribed to set
	 */
	public void setUnsubscribed(String unsubscribed) {
		this.unsubscribed = unsubscribed;
	}

	/**
	 * @return the update_status
	 */
	public String getUpdate_status() {
		return update_status;
	}

	/**
	 * @param update_status
	 *            the update_status to set
	 */
	public void setUpdate_status(String update_status) {
		this.update_status = update_status;
	}

	/**
	 * @return the engagement
	 */
	public String getEngagement() {
		return engagement;
	}

	/**
	 * @param engagement
	 *            the engagement to set
	 */
	public void setEngagement(String engagement) {
		this.engagement = engagement;
	}

	/**
	 * @return the token_value
	 */
	public String getToken_value() {
		return token_value;
	}

	/**
	 * @param token_value
	 *            the token_value to set
	 */
	public void setToken_value(String token_value) {
		this.token_value = token_value;
	}

	/**
	 * @return the token_status
	 */
	public String getToken_status() {
		return token_status;
	}

	/**
	 * @param token_status
	 *            the token_status to set
	 */
	public void setToken_status(String token_status) {
		this.token_status = token_status;
	}

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

}
