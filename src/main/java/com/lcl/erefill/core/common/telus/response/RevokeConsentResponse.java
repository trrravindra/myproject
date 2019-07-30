package com.lcl.erefill.core.common.telus.response;



/**
 * @author vsha51
 */
public class RevokeConsentResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560226L;
	
	Consent consent;

	/**
	 * @return the consent
	 */
	public Consent getConsent() {
		return consent;
	}

	/**
	 * @param consent the consent to set
	 */
	public void setConsent(Consent consent) {
		this.consent = consent;
	}
	
}
