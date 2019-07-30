package com.lcl.erefill.core.business;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.CaregiverAccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.ERefillResponse;
import com.lcl.erefill.core.common.telus.response.RevokeConsentResponse;
import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.common.telus.response.UpdateAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.ValidateUserResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;
import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

/**
 * @author vsha51
 */
@Component
public interface IAccountBusinessDelegate {

	/**
	 * changePassword
	 * 
	 * @param changePassword
	 * @param session
	 * 
	 * @return changeMyAccountPasswordResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ChangeMyAccountPasswordResponse changePassword(
			ChangePassword changePassword, ISession session)
			throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * updateAccountAlias
	 * 
	 * @param userName
	 * @param session
	 * 
	 * @return updateAccountAliasResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdateAccountAliasResponse updateAccountAlias(String userName,
			ISession session) throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * updateAccountPreferences
	 * 
	 * @param arrayOfAccountPreference
	 * @param session
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdatePreferencesResponse updateAccountPreferences(
			ArrayOfAccountPreference arrayOfAccountPreference,
			ISession session) throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * updatePasswordReminder
	 * 
	 * @param arrayOfAccountPreference
	 * @param session
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public UpdatePreferencesResponse updatePasswordReminder(
			ArrayOfAccountPreference arrayOfAccountPreference,
			ISession session) throws ERefillApplicationException, ERefillBusinessException;

	/**
	 * getMyAccountDetails
	 * 
	 * @param session
	 * @param securityQuestions
	 * @return accountDetailsResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public AccountDetailsResponse getMyAccountDetails(ISession session,
			String securityQuestions) throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * getListSecurityQuestions
	 * 
	 * @param securityQuestions
	 * @return questions
	 */
	public List<String> getListSecurityQuestions (String securityQuestions);
	
	/**
	 * revokeConsent
	 * 
	 * @param session
	 * @param reasonKey
	 * @return revokeConsentResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public RevokeConsentResponse revokeConsent (ISession session, String reasonKey)
			throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * closeAccount
	 * 
	 * @param session
	 * @return eRefillResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public ERefillResponse closeAccount (ISession session)
			throws ERefillApplicationException, ERefillBusinessException;
	
	
	public ValidateUserResponse validateUser(String userName)
			throws ERefillApplicationException;
	
	public ValidateUserResponse validateUser(ISession session,String userName)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public String validateSecurityAnswer(
			ValidateSecurityAnswerRequest validateSecAnsRequest)
			throws ERefillApplicationException, ERefillBusinessException;
	
	public ChangeMyAccountPasswordResponse changeResetPassword(
			ChangePassword changePassword, ISession session)
			throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * getPatientTaxReceiptReport
	 * 
	 * @param taxReceiptReportRequest
	 * @param session
	 * 
	 * @return taxReceiptReportResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public TaxReceiptReportResponse getPatientTaxReceiptReport(
			TaxReceiptReportRequest taxReceiptReportRequest, ISession session)
			throws ERefillApplicationException, ERefillBusinessException;
	
	/**
	 * unsubscribe
	 * 
	 * @param isEmail
	 * @param isPhone
	 * @param session
	 * @return returnMap
	 */
	public Map<String, String> unsubscribe(Boolean isEmail, Boolean isPhone,
			ISession session);
	
	/**
	 * getCaregiverAccountDetails
	 * 
	 * @param session
	 * @param question
	 * 
	 * @return caregiverAccountDetailsResponse
	 * @throws ERefillApplicationException
	 * @throws ERefillBusinessException
	 */
	public CaregiverAccountDetailsResponse getCaregiverAccountDetails(ISession session, String question)
			throws ERefillApplicationException, ERefillBusinessException;
}
