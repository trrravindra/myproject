package com.lcl.erefill.core.common.entity;

import java.io.Serializable;

public class RefillPrescriptionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599502689477913003L;
	
	
	private PrescriptionsVO prescriptionsVO;
	private AccountCreatorVO accountCreatorVO;
	
	/**
	 * @return the prescriptionsVO
	 */
	public PrescriptionsVO getPrescriptionsVO() {
		return prescriptionsVO;
	}
	/**
	 * @param prescriptionsVO the prescriptionsVO to set
	 */
	public void setPrescriptionsVO(PrescriptionsVO prescriptionsVO) {
		this.prescriptionsVO = prescriptionsVO;
	}
	/**
	 * @return the accountCreatorVO
	 */
	public AccountCreatorVO getAccountCreatorVO() {
		return accountCreatorVO;
	}
	/**
	 * @param accountCreatorVO the accountCreatorVO to set
	 */
	public void setAccountCreatorVO(AccountCreatorVO accountCreatorVO) {
		this.accountCreatorVO = accountCreatorVO;
	}
}