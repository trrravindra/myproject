package com.lcl.erefill.core.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AddAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePasswordReminderResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.vo.ISession;

/**
 * @author vsha51
 */
@Component
public interface IRegistrationBusinessDelegate {

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
			ERefillBusinessException;

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
			throws ERefillApplicationException, ERefillBusinessException;

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
	public ChangeMyAccountPasswordResponse changeRegistrationPassword(
			final String newPassword, String page, ISession session)
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * updatePreferencesResponse
	 * 
	 * @param eQuestions
	 * @param eAnswers
	 * @param email
	 * @param session
	 * @return updatePasswordReminderResponse
	 */
	public UpdatePreferencesResponse updateAccountPreferences(
			List<String> eQuestions, List<String> eAnswers, String email,
			String alias, ISession session);
	
	/**
	 * updatePasswordReminder
	 * 
	 * @param eQuestions
	 * @param eAnswers
	 * @param email
	 * @param session
	 * @return updatePasswordReminderResponse
	 */
	public UpdatePasswordReminderResponse updatePasswordReminder(
			List<String> eQuestions, List<String> eAnswers, String email,
			ISession session);

	/**
	 * addAccountAlias
	 * 
	 * @param alias
	 * @param session
	 * @return addAccountAliasResponse
	 */
	public AddAccountAliasResponse addAccountAlias(String alias,
			ISession session);
	
	/**
	 * confirmEmail
	 * 
	 * @param id
	 * @param userToken
	 * @param session
	 * @return code
	 */
	public String confirmEmail(final String id, ISession session);
}
