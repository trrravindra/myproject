package com.lcl.erefill.core.common.telus.response;

import java.util.List;
import java.util.Map;

import com.lcl.erefill.core.vo.Account;
import com.lcl.erefill.core.vo.AccountPreferenceVO;

/**
 * @author vsha51
 */
public class AccountDetailsResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560226L;

	Account account;
	String userName;
	AccountPreferenceVO accountPreferenceVO;
	Map<String, String> mailStatus;
	List<String> questions;
	String phoneNumber;
	String phoneStatus;
	
	/**
	 * @return the phoneStatus
	 */
	public String getPhoneStatus() {
		return phoneStatus;
	}

	/**
	 * @param phoneStatus the phoneStatus to set
	 */
	public void setPhoneStatus(String phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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

	/**
	 * @return the mailStatus
	 */
	public Map<String, String> getMailStatus() {
		return mailStatus;
	}

	/**
	 * @param mailStatus
	 *            the mailStatus to set
	 */
	public void setMailStatus(Map<String, String> mailStatus) {
		this.mailStatus = mailStatus;
	}

	/**
	 * @return the questions
	 */
	public List<String> getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

}
