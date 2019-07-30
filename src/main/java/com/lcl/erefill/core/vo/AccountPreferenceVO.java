package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class AccountPreferenceVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6648624970668151785L;
	private String mailId;
	private String mobilePhoneNo;
	private String securityQuestion1;
	private String securityQuestion2;
	private String securityQuestion3;
	private String securityQuestion_Answer1;
	private String securityQuestion_Answer2;
	private String securityQuestion_Answer3;
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getSecurityQuestion1() {
		return securityQuestion1;
	}
	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}
	public String getSecurityQuestion2() {
		return securityQuestion2;
	}
	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}
	public String getSecurityQuestion3() {
		return securityQuestion3;
	}
	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}
	public String getSecurityQuestion_Answer1() {
		return securityQuestion_Answer1;
	}
	public void setSecurityQuestion_Answer1(String securityQuestion_Answer1) {
		this.securityQuestion_Answer1 = securityQuestion_Answer1;
	}
	public String getSecurityQuestion_Answer2() {
		return securityQuestion_Answer2;
	}
	public void setSecurityQuestion_Answer2(String securityQuestion_Answer2) {
		this.securityQuestion_Answer2 = securityQuestion_Answer2;
	}
	public String getSecurityQuestion_Answer3() {
		return securityQuestion_Answer3;
	}
	public void setSecurityQuestion_Answer3(String securityQuestion_Answer3) {
		this.securityQuestion_Answer3 = securityQuestion_Answer3;
	}
	/**
	 * @return the mobilePhoneNo
	 */
	public String getMobilePhoneNo() {
		return mobilePhoneNo;
	}
	/**
	 * @param mobilePhoneNo the mobilePhoneNo to set
	 */
	public void setMobilePhoneNo(String mobilePhoneNo) {
		this.mobilePhoneNo = mobilePhoneNo;
	}	
}
