package com.lcl.erefill.core.services;

import java.util.List;
import java.util.Map;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AddAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePasswordReminderResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.UserAccountGroup;

public interface ISessionService {

	/**
	 * verifyIdentity
	 * 
	 * @param dto
	 * @param userToken
	 * @return updatePreferencesResponse
	 */
	public UpdatePreferencesResponse verifyIdentity(DataCarrier dto,
			UserToken userToken);

	/**
	 * changeRegistrationPassword
	 * 
	 * @param userToken
	 * @param newPassword
	 * @param page
	 * @return changeMyAccountPasswordResponse
	 */
	public ChangeMyAccountPasswordResponse changeRegistrationPassword(
			UserToken userToken, String newPassword, String page);

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
			List<String> eAnswers, String email);

	/**
	 * addAccountAlias
	 * 
	 * @param userToken
	 * @param alias
	 * @return addAccountAliasResponse
	 */
	public AddAccountAliasResponse addAccountAlias(UserToken userToken,
			String alias);

	/**
	 * getUserRole
	 * 
	 * @param userToken
	 * @return
	 */
	public UserAccountGroup getUserRole(
			com.lcl.erefill.core.common.entity.UserToken userToken);

	/**
	 * getPhoneNumberStatus
	 * 
	 * @param userToken
	 * @return phoneStatus
	 */
	public Map<String, String> getPhoneNumberStatus(
			com.lcl.erefill.core.common.entity.UserToken userToken);

	/**
	 * performAgentLogin
	 * 
	 * @return userToken
	 */
	public UserToken performAgentLogin();

	/**
	 * confirmEmail
	 * 
	 * @param id
	 * @param userToken
	 * @return code
	 */
	public String confirmEmail(final String id, UserToken userToken);

	/**
	 * unsubscribe
	 * 
	 * @param userToken
	 * @param isEmail
	 * @param isPhone
	 * @return returnMap
	 */
	public Map<String, String> unsubscribe(UserToken userToken,
			Boolean isEmail, Boolean isPhone);
}
