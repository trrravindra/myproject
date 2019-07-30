package com.lcl.erefill.core.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.AccountPreferencesResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
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
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.PasswordReminder;
import com.lcl.erefill.core.vo.User;
import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

/**
 * @author vsha51
 */
@Component
public interface IAccountService {

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
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * updateAccountAlias
	 * 
	 * @param userName
	 * @param userToken
	 * @return updateAccountAliasResponse
	 * @throws ERefillApplicationException
	 */
	public UpdateAccountAliasResponse updateAccountAlias(String userName,
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException;

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
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException;

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
			UserToken userToken) throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * getCurrentAccount
	 * 
	 * @param userToken
	 * @return currentAccountResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public CurrentAccountResponse getCurrentAccount(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * getAccountAlias
	 * 
	 * @param userToken
	 * @return accountAliasResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public AccountAliasResponse getAccountAlias(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * listPreferences
	 * 
	 * @param userToken
	 * @return accountPreferencesResponse
	 * @throws ERefillApplicationException
	 */
	public AccountPreferencesResponse listPreferences(UserToken userToken)
			throws ERefillApplicationException;

	/**
	 * getEmailStatus
	 * 
	 * @param userToken
	 * @return emailStatusResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public EmailStatusResponse getEmailStatus(UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * getListSecurityQuestions
	 * 
	 * @param strQuestions
	 * @return list
	 * @throws ERefillApplicationException
	 */
	public List<String> getListSecurityQuestions(String strQuestions)
			throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * revokeConsent
	 * 
	 * @param userToken
	 * @param reasonKey
	 * @return revokeConsentResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public RevokeConsentResponse revokeConsent (UserToken userToken, String reasonKey)
			throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * closeAccount
	 * 
	 * @param userToken
	 * @return eRefillResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ERefillResponse closeAccount (UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public ValidateUserResponse validateUser(String userName)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public LogOnResponse validateUser(User user)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public PasswordReminder getPasswordReminder(String userName)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public String validateSecurityAnswer(
			ValidateSecurityAnswerRequest validateSecAnsRequest)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public ChangeMyAccountPasswordResponse changeResetPassword(
			ChangePassword changePassword, UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException;
}
