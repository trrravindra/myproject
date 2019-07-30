package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.vo.AccountPreferenceVO;

/**
 * @author vsha51
 */
public class AccountPreferencesResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560326L;

	AccountPreferenceVO accountPreferenceVO;

	/**
	 * @return the accountPreferenceVO
	 */
	public AccountPreferenceVO getAccountPreferenceVO() {
		return accountPreferenceVO;
	}

	/**
	 * @param accountPreferenceVO
	 *            the accountPreferenceVO to set
	 */
	public void setAccountPreferenceVO(AccountPreferenceVO accountPreferenceVO) {
		this.accountPreferenceVO = accountPreferenceVO;
	}

}
