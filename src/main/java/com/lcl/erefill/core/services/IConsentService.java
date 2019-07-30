package com.lcl.erefill.core.services;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.vo.ConsentVO;

public interface IConsentService {
	/**
	 * getConsent
	 * 
	 * @param dto
	 * @param userToken
	 * @return consentVO
	 */
	public ConsentVO getConsent(DataCarrier dto, UserToken userToken);
	
	/**
	 * subscribe
	 * 
	 * @param userToken
	 * @param consentId
	 * @return usertoken
	 */
	public UserToken subscribe( UserToken userToken,
			int consentId);
}

