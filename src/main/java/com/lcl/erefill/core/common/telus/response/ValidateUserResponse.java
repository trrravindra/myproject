package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.vo.PasswordReminder;


public class ValidateUserResponse extends UserToken{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5477182852264474816L;
	/**
	 * 
	 */
	
	
	private PasswordReminder passwordReminder;

	

	/**
	 * @return the passwordReminder
	 */
	public PasswordReminder getPasswordReminder() {
		return passwordReminder;
	}

	/**
	 * @param passwordReminder the passwordReminder to set
	 */
	public void setPasswordReminder(PasswordReminder passwordReminder) {
		this.passwordReminder = passwordReminder;
	}

	
	
	

}
