package com.lcl.erefill.core.common.entity;

import java.io.Serializable;

public class AccountCreatorVO implements Serializable {
	
	private static final long serialVersionUID = 8812212427641610478L;
	
	private String accountCreatorFirstName;
	private String accountCreatorLastName;
	
	/**
	 * @return the accountCreatorFirstName
	 */
	public String getAccountCreatorFirstName() {
		return accountCreatorFirstName;
	}
	/**
	 * @param accountCreatorFirstName the accountCreatorFirstName to set
	 */
	public void setAccountCreatorFirstName(String accountCreatorFirstName) {
		this.accountCreatorFirstName = accountCreatorFirstName;
	}
	/**
	 * @return the accountCreatorLastName
	 */
	public String getAccountCreatorLastName() {
		return accountCreatorLastName;
	}
	/**
	 * @param accountCreatorLastName the accountCreatorLastName to set
	 */
	public void setAccountCreatorLastName(String accountCreatorLastName) {
		this.accountCreatorLastName = accountCreatorLastName;
	}
}