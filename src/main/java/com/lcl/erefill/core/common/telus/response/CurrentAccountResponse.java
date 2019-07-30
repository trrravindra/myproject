package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.vo.Account;


/**
 * @author vsha51
 */
public class CurrentAccountResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560226L;

	Account account;
	
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}
