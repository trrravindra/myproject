package com.lcl.erefill.core.common.telus.response;

import java.util.Map;


/**
 * @author vsha51
 */
public class EmailStatusResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560326L;

	Map<String, String> emailStatus;

	/**
	 * @return the emailStatus
	 */
	public Map<String, String> getEmailStatus() {
		return emailStatus;
	}

	/**
	 * @param emailStatus
	 *            the emailStatus to set
	 */
	public void setEmailStatus(Map<String, String> emailStatus) {
		this.emailStatus = emailStatus;
	}

}
