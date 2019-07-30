package com.lcl.erefill.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.ConsentWSImpl;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.generated.telus.consent.rxassystlib.ConsentType;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentCode;

/**
 * @author vmahe1
 * 
 */
@Component
public class ConsentService implements IConsentService {

	private static final Logger logger = LoggerFactory.getLogger(ConsentService.class);

	@Autowired
	ConsentWSImpl consentWSImpl;

	/**
	 * getConsent
	 * 
	 * @param dto
	 * @param userToken
	 * @return consentVO
	 */
	public ConsentVO getConsent(DataCarrier dto, UserToken userToken) {
		final String methodName = "getConsent";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		ConsentVO consentVO = new ConsentVO();
		ConsentCode consentCode = new ConsentCode();
		try {
			if ("FamilyManager".equalsIgnoreCase((String) dto
					.getObject(ERefillConstants.CONSENT_TYPE)))
				consentCode.setConsentType(ConsentType.FAMILY_MANAGER);
			else if ("ManagerAccept".equalsIgnoreCase((String) dto
					.getObject(ERefillConstants.CONSENT_TYPE)))
				consentCode.setConsentType(ConsentType.MANAGER_ACCEPT);
			else if ("Enrollment".equalsIgnoreCase((String) dto
					.getObject(ERefillConstants.CONSENT_TYPE)))
				consentCode.setConsentType(ConsentType.ENROLLMENT);
			else if ("RenewalAuthorizationRequest"
					.equalsIgnoreCase((String) dto
							.getObject(ERefillConstants.CONSENT_TYPE)))
				consentCode
						.setConsentType(ConsentType.RENEWAL_AUTHORIZATION_REQUEST);
			else
				consentCode.setConsentType(ConsentType.FAMILY_MEMBER);
		} catch (Exception e) {
			logger.error(methodName + " Error: " + e);
		}
		
		try {
			consentVO = consentWSImpl.getConsent(userToken, consentCode);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return consentVO;
	}

	/**
	 * subscribe
	 * 
	 * @param userToken
	 * @param consentId
	 * @return usertoken
	 */
	public UserToken subscribe(UserToken userToken, int consentId)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "subscribe";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UserToken retUserToken = null;

		try {
			retUserToken = consentWSImpl.subscribe(userToken, consentId);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return retUserToken;
	}
}
