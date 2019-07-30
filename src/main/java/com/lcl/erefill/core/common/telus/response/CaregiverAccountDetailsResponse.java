package com.lcl.erefill.core.common.telus.response;

import java.util.List;
import java.util.Map;

import com.lcl.erefill.core.vo.Account;
import com.lcl.erefill.core.vo.AccountPreferenceVO;

public class CaregiverAccountDetailsResponse extends ERefillResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6814341690179118026L;
	Account account;
	String userName;
	AccountPreferenceVO accountPreferenceVO;
	List<String> questions;
	Map<String, String> mailStatus;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public AccountPreferenceVO getAccountPreferenceVO() {
		return accountPreferenceVO;
	}
	public void setAccountPreferenceVO(AccountPreferenceVO accountPreferenceVO) {
		this.accountPreferenceVO = accountPreferenceVO;
	}
	public List<String> getQuestions() {
		return questions;
	}
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	public Map<String, String> getMailStatus() {
		return mailStatus;
	}
	public void setMailStatus(Map<String, String> mailStatus) {
		this.mailStatus = mailStatus;
	}
	
}
