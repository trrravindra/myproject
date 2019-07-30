package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class Account implements Serializable{
	
	private static final long serialVersionUID = 7766731520402629865L;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private PasswordReminder passwordReminder;
	private com.lcl.erefill.core.common.entity.UserToken usertoken;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public PasswordReminder getPasswordReminder() {
		return passwordReminder;
	}
	public void setPasswordReminder(PasswordReminder passwordReminder) {
		this.passwordReminder = passwordReminder;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public com.lcl.erefill.core.common.entity.UserToken getUsertoken() {
		return usertoken;
	}
	public void setUsertoken(com.lcl.erefill.core.common.entity.UserToken usertoken) {
		this.usertoken = usertoken;
	}

	
	
}
