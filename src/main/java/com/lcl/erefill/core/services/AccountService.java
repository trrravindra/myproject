package com.lcl.erefill.core.services;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.AccountPreferencesResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.Consent;
import com.lcl.erefill.core.common.telus.response.CurrentAccountResponse;
import com.lcl.erefill.core.common.telus.response.ERefillResponse;
import com.lcl.erefill.core.common.telus.response.EmailStatusResponse;
import com.lcl.erefill.core.common.telus.response.LogOnResponse;
import com.lcl.erefill.core.common.telus.response.RevokeConsentResponse;
import com.lcl.erefill.core.common.telus.response.UpdateAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.ValidateUserResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.ConsentWSImpl;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;
import com.lcl.erefill.core.vo.Account;
import com.lcl.erefill.core.vo.AccountPreferenceVO;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.PasswordReminder;
import com.lcl.erefill.core.vo.User;
import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

@Component
public class AccountService implements IAccountService {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountService.class);
	
	@Autowired
	SessionWSImpl sessionWSImpl;
	@Autowired
	ConsentWSImpl consentWSImpl;
	
	/**
	 * changePassword
	 * 
	 * @param changePassword
	 * @param userToken
	 * 
	 * @return changeMyAccountPasswordResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ChangeMyAccountPasswordResponse changePassword(
			ChangePassword changePassword, UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "changePassword";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = null;

		try {
			changeMyAccountPasswordResponse = sessionWSImpl
					.changeMyAccountPassword(userToken,
							changePassword.getNewpassword(), changePassword.getCurrentpassword());
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}
	
	public ChangeMyAccountPasswordResponse changeResetPassword(
			ChangePassword changePassword, UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "changeResetPassword";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = null;

		try {
			changeMyAccountPasswordResponse = changePassword(changePassword,userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}

	/**
	 * updateAccountAlias
	 * 
	 * @param userName
	 * @param userToken
	 * @return updateAccountAliasResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdateAccountAliasResponse updateAccountAlias(String userName,
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "updateAccountAlias";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UpdateAccountAliasResponse updateAccountAliasResponse = null;

		try {
			updateAccountAliasResponse = sessionWSImpl.updateAccountAlias(
					userToken, userName);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return updateAccountAliasResponse;
	}

	/**
	 * updateAccountPreferences
	 * 
	 * @param arrayOfAccountPreference
	 * @param userToken
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdatePreferencesResponse updateAccountPreferences(
			ArrayOfAccountPreference arrayOfAccountPreference,
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "updateAccountPreferences";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UpdatePreferencesResponse updatePreferencesResponse = null;

		try {
			updatePreferencesResponse = sessionWSImpl.updatePreferences(
					userToken, arrayOfAccountPreference);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return updatePreferencesResponse;
	}
	
	/**
	 * updatePasswordReminder
	 * 
	 * @param arrayOfAccountPreference
	 * @param userToken
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdatePreferencesResponse updatePasswordReminder(
			ArrayOfAccountPreference arrayOfAccountPreference,
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "updatePasswordReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		UpdatePreferencesResponse updatePreferencesResponse = null;

		try {
			updatePreferencesResponse = sessionWSImpl.updatePreferences(
					userToken, arrayOfAccountPreference);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return updatePreferencesResponse;
	}
	
	/**
	 * getCurrentAccount
	 * 
	 * @param userToken
	 * @return currentAccountResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public CurrentAccountResponse getCurrentAccount(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getCurrentAccount";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		CurrentAccountResponse currentAccountResponse = new CurrentAccountResponse();

		try {
			Account account = sessionWSImpl.getCurrentAccount(userToken);
			currentAccountResponse.setAccount(account);
			currentAccountResponse.setUserToken(account.getUsertoken());
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return currentAccountResponse;		
	}

	/**
	 * getAccountAlias
	 * 
	 * @param userToken
	 * @return accountAliasResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public AccountAliasResponse getAccountAlias(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getAccountAlias";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		AccountAliasResponse accountAliasResponse = null;

		try {
			accountAliasResponse = sessionWSImpl.getAccountAlias(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return accountAliasResponse;	
	}

	/**
	 * listPreferences
	 * 
	 * @param userToken
	 * @return accountPreferencesResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public AccountPreferencesResponse listPreferences(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "listPreferences";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		AccountPreferencesResponse accountPreferencesResponse = new AccountPreferencesResponse();

		try {
			AccountPreferenceVO accountPreferenceVO = sessionWSImpl.listPreferences(userToken);
			accountPreferencesResponse.setAccountPreferenceVO(accountPreferenceVO);
			accountPreferencesResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return accountPreferencesResponse;
	}

	/**
	 * getEmailStatus
	 * 
	 * @param userToken
	 * @return emailStatusResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public EmailStatusResponse getEmailStatus(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getEmailStatus";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		EmailStatusResponse emailStatusResponse = new EmailStatusResponse();

		try {
			Map<String, String> emailStatus = sessionWSImpl.getEmailStatus(userToken,null);
			emailStatusResponse.setEmailStatus(emailStatus);
			emailStatusResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return emailStatusResponse;
	}

	/**
	 * getListSecurityQuestions
	 * 
	 * @param strQuestions
	 * @return list
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public List<String> getListSecurityQuestions(String strQuestions)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getListSecurityQuestions";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		List<String> securityQuestions = null;

		try {
			securityQuestions = sessionWSImpl.getListSecurityQuestions(strQuestions);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return securityQuestions;
	}
	
	
	/**
	 * revokeConsent
	 * 
	 * @param userToken
	 * @param reasonKey
	 * @return revokeConsentResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public RevokeConsentResponse revokeConsent (UserToken userToken, String reasonKey)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "revokeConsent";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		
		RevokeConsentResponse revokeConsentResponse = null;
		try {
			Consent consent = consentWSImpl.getRxAssyst(userToken);
			consentWSImpl.unsubscribe(userToken, reasonKey, consent.getId());
			
			revokeConsentResponse = new RevokeConsentResponse();
			revokeConsentResponse.setConsent(consent);
			revokeConsentResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error (methodName + " Error: " +e1);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return revokeConsentResponse;
	}
	
	/**
	 * closeAccount
	 * 
	 * @param userToken
	 * @return eRefillResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ERefillResponse closeAccount (UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "closeAccount";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		
		ERefillResponse eRefillResponse = null;
		try {
			Consent consent = consentWSImpl.getRxAssyst(userToken);
			consentWSImpl.unsubscribe(userToken,"noreasons",consent.getId());
			
			eRefillResponse = new ERefillResponse();
			eRefillResponse.setUserToken(userToken);
			
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error (methodName + " Error: " +e1);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return eRefillResponse;
	}
	/**
	 * validate User
	 * 
	 * @param 	
	 * 
	 * @return status
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ValidateUserResponse validateUser(String userName)
			throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "validateUser";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		ValidateUserResponse validateUserResponse = new ValidateUserResponse();
		UserToken userToken=new UserToken();
		try {
			validateUserResponse.setStatus(sessionWSImpl.emailValid(userToken, userName));
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return validateUserResponse;
	}
	
	
	/**
	 * @param user
	 * @return LogOnResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public LogOnResponse validateUser(User user)
			throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "validateUser";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		LogOnResponse logOnResponse;
		try {
			logOnResponse=sessionWSImpl.logOn(user);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return logOnResponse;		
	}
	
	public PasswordReminder getPasswordReminder(String userName)
			throws ERefillApplicationException, ERefillBusinessException  {
		final String methodName = "getPasswordReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		PasswordReminder passwordReminder;
		try {
			passwordReminder=sessionWSImpl.getPasswordReminder(userName);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return passwordReminder;
	}
	
	
	
	public String validateSecurityAnswer(
			ValidateSecurityAnswerRequest validateSecAnsRequest)
			throws ERefillApplicationException, ERefillBusinessException {
		String status=StringUtils.EMPTY;
		final String methodName = "validateSecurityAnswer";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		try {
			status=sessionWSImpl.sendPassword(validateSecAnsRequest.getUsername(),
					validateSecAnsRequest.getQuestion(), validateSecAnsRequest.getAnswer(),
					validateSecAnsRequest.getChoice());
			
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return status;
	}
	
	
}
