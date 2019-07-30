package com.lcl.erefill.core.vo;

import com.lcl.erefill.generated.telus.consent.rxassystlib.ConsentType;

public class ConsentVO extends UserToken{

	private static final long serialVersionUID = 3922546841197436235L;
	
	private String oid;
	private ConsentType consentType;
	private String agreementEnglish;
	private String agreementFrench;
	private Integer id;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * @return the consentType
	 */
	public ConsentType getConsentType() {
		return consentType;
	}
	/**
	 * @param consentType the consentType to set
	 */
	public void setConsentType(ConsentType consentType) {
		this.consentType = consentType;
	}
	/**
	 * @return the agreementEnglish
	 */
	public String getAgreementEnglish() {
		return agreementEnglish;
	}
	/**
	 * @param agreementEnglish the agreementEnglish to set
	 */
	public void setAgreementEnglish(String agreementEnglish) {
		this.agreementEnglish = agreementEnglish;
	}
	/**
	 * @return the agreementFrench
	 */
	public String getAgreementFrench() {
		return agreementFrench;
	}
	/**
	 * @param agreementFrench the agreementFrench to set
	 */
	public void setAgreementFrench(String agreementFrench) {
		this.agreementFrench = agreementFrench;
	}
}