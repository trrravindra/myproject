package com.lcl.erefill.core.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AddAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePasswordReminderResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.UserAccountGroup;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;

@Component
public class SessionService implements ISessionService {

	private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

	@Autowired
	SessionWSImpl sessionWSImpl;

	/**
	 * verifyIdentity
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UpdatePreferencesResponse verifyIdentity(DataCarrier dto,
			UserToken userToken) {
		UpdatePreferencesResponse updatePreferencesResponse=null;
		try {
			
			updatePreferencesResponse=sessionWSImpl.verifyIdentity(userToken, StringUtils.trimToEmpty((String) dto.getObject(ERefillConstants.REQ_PARAM_MONTH)), StringUtils.trimToEmpty((String) dto.getObject(ERefillConstants.REQ_PARAM_DAY)),
					StringUtils.trimToEmpty((String) dto.getObject(ERefillConstants.REQ_PARAM_YEAR)),StringUtils.trimToEmpty((String) dto.getObject(ERefillConstants.GUEST_USER_NAME)));
			
		}catch (ERefillBusinessException e) {
 			logger.error(" Error1: " + e);
 			throw e;
 			
 		}catch (ERefillApplicationException e) {
 			logger.error(" Error1: " + e);
 			throw e;
 			
 		}catch (Exception e) {
			logger.error(" Error: " + e);
			return null;
		}
		return updatePreferencesResponse;
	}

	/**
	 * changeRegistrationPassword
	 * 
	 * @param userToken
	 * @param newPassword
	 * @param page
	 * @return changeMyAccountPasswordResponse
	 */
	public ChangeMyAccountPasswordResponse changeRegistrationPassword(
			UserToken userToken, final String newPassword, String page) {
		final String methodName = "changePassword";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = null;
        try{ 
		changeMyAccountPasswordResponse = sessionWSImpl
				.changeRegistrationPassword(userToken, newPassword, page);
         }catch (ERefillBusinessException e) {
 			logger.error(methodName + " Error1: " + e);
 			throw e;
 		} catch (ERefillApplicationException e) {
 			logger.error(methodName + " Error1: " + e);
 			throw e;
 		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}

	/**
	 * updatePasswordReminder
	 * 
	 * @param userToken
	 * @param eQuestions
	 * @param eAnswers
	 * @param email
	 * @return updatePasswordReminderResponse
	 */
	public UpdatePasswordReminderResponse updatePasswordReminder(
			UserToken userToken, List<String> eQuestions,
			List<String> eAnswers, String email) {
		final String methodName = "updatePasswordReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		UpdatePasswordReminderResponse updatePasswordReminderResponse = null;
		try{
		updatePasswordReminderResponse = sessionWSImpl.updatePasswordReminder(
				userToken, eQuestions, eAnswers, email);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return updatePasswordReminderResponse;
	}

	/**
	 * addAccountAlias
	 * 
	 * @param userToken
	 * @param alias
	 * @return addAccountAliasResponse
	 */
	public AddAccountAliasResponse addAccountAlias(UserToken userToken,
			String alias) {
		final String methodName = "addAccountAlias";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		AddAccountAliasResponse addAccountAliasResponse = null;
		try{
		addAccountAliasResponse = sessionWSImpl.addAccountAlias(userToken,
				alias);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		}catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return addAccountAliasResponse;
	}

	/**
	 * getUserRole
	 * 
	 * @param userToken
	 * @return
	 */
	public UserAccountGroup getUserRole(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		final String methodName = "getUserRole";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UserAccountGroup userAccountGroup = null;
        try{  
		userAccountGroup = sessionWSImpl
				.getUserRole(userToken);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return userAccountGroup;
	}
	
	/**
	 * getPhoneNumberStatus
	 * 
	 * @param userToken
	 * @return phoneStatus
	 */
	public Map<String, String> getPhoneNumberStatus(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		final String methodName = "getPhoneNumberStatus";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		Map<String, String> phoneStatus = new HashMap<String, String>();
		try{
			phoneStatus = sessionWSImpl
				.getPhoneNumberStatus(userToken);
		} catch (Exception e) {
					
					return phoneStatus;

				} catch (Error e) {
					
					return phoneStatus;

				}
		

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return phoneStatus;
	}
	
	/**
	 * performAgentLogin
	 * 
	 * @return userToken
	 */
	public UserToken performAgentLogin() {
		final String methodName = "performAgentLogin";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UserToken userToken = null;
        try{
		userToken = sessionWSImpl.performAgentLogin();
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		}catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return userToken;
	}
	
	/**
	 * confirmEmail
	 * 
	 * @param id
	 * @param userToken
	 * @return code
	 */
	public String confirmEmail(final String id, UserToken userToken) {
		final String methodName = "confirmEmail";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String code = null;
        try{
		code = sessionWSImpl.confirmEmail(id, userToken);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		}catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} 

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return code;
	}

	/**
	 * unsubscribe
	 * 
	 * @param userToken
	 * @param isEmail
	 * @param isPhone
	 * @return returnMap
	 */
	public Map<String, String> unsubscribe(UserToken userToken,
			Boolean isEmail, Boolean isPhone) {
		final String methodName = "unsubscribe";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		Map<String, String> returnMap = sessionWSImpl.unsubscribe(userToken,
				isEmail, isPhone);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return returnMap;
	}
}
