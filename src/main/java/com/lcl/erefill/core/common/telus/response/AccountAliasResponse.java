package com.lcl.erefill.core.common.telus.response;

/**
 * @author vsha51
 */
public class AccountAliasResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560226L;

	private String userName;

	private String status;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
