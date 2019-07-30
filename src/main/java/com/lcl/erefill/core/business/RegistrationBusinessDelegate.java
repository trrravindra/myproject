package com.lcl.erefill.core.business;

import java.util.List;

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
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.IAccountService;
import com.lcl.erefill.core.services.IConsentService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceEAccountPreferenceType;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

/**
 * @author vsha51
 */
@Component
public class RegistrationBusinessDelegate implements
		IRegistrationBusinessDelegate {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationBusinessDelegate.class);

	@Autowired
	ISessionService sessionService;

	@Autowired
	IAccountService accountService;

	@Autowired
	IConsentService consentService;

	@Autowired
	SessionManager sessionManager;

	/**
	 * verifyIdentity
	 * 
	 * @param dto
	 * @param session
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException
	 * @throws ERefillBusinessException
	 */
	public UpdatePreferencesResponse verifyIdentity(DataCarrier dto,
			ISession session) throws ERefillApplicationException,
			ERefillBusinessException {
		final String methodName = "verifyIdentity";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UpdatePreferencesResponse updatePreferencesResponse = sessionService
				.verifyIdentity(dto, userToken);
		if (updatePreferencesResponse != null) {
			LOGGER.info(methodName + " updatePreferencesResponse: "
					+ updatePreferencesResponse.getResponseStatus());
			if (updatePreferencesResponse.getUserToken() != null) {
				sessionManager.setToken(
						updatePreferencesResponse.getUserToken(), session);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return updatePreferencesResponse;
	}

	/**
	 * subscribe
	 * 
	 * @param consentId
	 * @param session
	 * @return userToken
	 * @throws ERefillApplicationException
	 * @throws ERefillBusinessException
	 */
	public UserToken subscribe(int consentId, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "subscribe";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UserToken retUserToken = consentService.subscribe(userToken, consentId);

		if (retUserToken != null) {
			sessionManager.setToken(retUserToken, session);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return retUserToken;
	}

	/**
	 * changeRegistrationPassword
	 * 
	 * @param userToken
	 * @param newPassword
	 * @param page
	 * @return changeMyAccountPasswordResponse
	 * @throws ERefillApplicationException
	 * @throws ERefillBusinessException
	 */
	public ChangeMyAccountPasswordResponse changeRegistrationPassword(final String newPassword, String page, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "changeRegistrationPassword";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		sessionManager.setPassword(newPassword, session);
		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = sessionService
				.changeRegistrationPassword(userToken, newPassword, page);

		if (changeMyAccountPasswordResponse != null	&& changeMyAccountPasswordResponse.getUserToken() != null) {
			sessionManager.setToken(changeMyAccountPasswordResponse.getUserToken(), session);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}

	/**
	 * updatePreferencesResponse
	 * 
	 * @param eQuestions
	 * @param eAnswers
	 * @param email
	 * @param session
	 * @return updatePasswordReminderResponse
	 */
	public UpdatePreferencesResponse updateAccountPreferences(List<String> eQuestions, List<String> eAnswers, String email,	String alias, ISession session) 
			throws ERefillApplicationException, ERefillBusinessException{
		final String methodName = "updateAccountPreferences";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UpdatePreferencesResponse updatePreferencesResponse = new UpdatePreferencesResponse();
		UserToken userToken = sessionManager.getToken(session);

		
		ArrayOfAccountPreference arrayOfAccountPreference = new ArrayOfAccountPreference();
		AccountPreference accountPreference = new AccountPreference();
		accountPreference.setType(AccountPreferenceEAccountPreferenceType.EMAIL);
		accountPreference.setValue(email);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference);
		
		// Update Email
		updatePreferencesResponse = accountService.updateAccountPreferences(arrayOfAccountPreference, userToken);
		userToken = updatePreferencesResponse.getUserToken();
		if (null != updatePreferencesResponse && ERefillConstants.STATUS_SUCCESS.equals(updatePreferencesResponse.getResponseStatus())) {
			LOGGER.info("New user registered to the system with email >> "+ email);
		}

		if (userToken != null) {
			sessionManager.setToken(userToken, session);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return updatePreferencesResponse;
	}

	/**
	 * updatePasswordReminder
	 * 
	 * @param eQuestions
	 * @param eAnswers
	 * @param email
	 * @param session
	 * @return updatePasswordReminderResponse
	 */
	public UpdatePasswordReminderResponse updatePasswordReminder(List<String> eQuestions, List<String> eAnswers, String email,ISession session) 
			throws ERefillApplicationException, ERefillBusinessException{
		final String methodName = "updatePasswordReminder";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UpdatePasswordReminderResponse updatePasswordReminderResponse = sessionService.updatePasswordReminder(userToken, eQuestions, eAnswers, email);

		if (updatePasswordReminderResponse != null	&& updatePasswordReminderResponse.getUserToken() != null) {
			sessionManager.setToken(updatePasswordReminderResponse.getUserToken(), session);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return updatePasswordReminderResponse;
	}

	/**
	 * addAccountAlias
	 * 
	 * @param alias
	 * @param session
	 * @return addAccountAliasResponse
	 */
	public AddAccountAliasResponse addAccountAlias(String alias, ISession session) 
			throws ERefillApplicationException, ERefillBusinessException{
		final String methodName = "addAccountAlias";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		AddAccountAliasResponse addAccountAliasResponse = sessionService
				.addAccountAlias(userToken, alias);

		if (addAccountAliasResponse != null
				&& addAccountAliasResponse.getUserToken() != null) {
			sessionManager.setToken(addAccountAliasResponse.getUserToken(),
					session);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return addAccountAliasResponse;
	}

	/**
	 * confirmEmail
	 * 
	 * @param id
	 * @param session
	 * @return code
	 */
	public String confirmEmail(String id, ISession session) throws ERefillApplicationException, ERefillBusinessException{
		final String methodName = "confirmEmail";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionService.performAgentLogin();
		String code = sessionService.confirmEmail(id, userToken);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return code;
	}
	
}
