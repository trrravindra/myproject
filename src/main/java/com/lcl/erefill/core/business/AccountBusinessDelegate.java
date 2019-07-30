package com.lcl.erefill.core.business;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.AccountPreferencesResponse;
import com.lcl.erefill.core.common.telus.response.CaregiverAccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.CurrentAccountResponse;
import com.lcl.erefill.core.common.telus.response.ERefillResponse;
import com.lcl.erefill.core.common.telus.response.EmailStatusResponse;
import com.lcl.erefill.core.common.telus.response.LogOnResponse;
import com.lcl.erefill.core.common.telus.response.PatientDataResponse;
import com.lcl.erefill.core.common.telus.response.RevokeConsentResponse;
import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.common.telus.response.UpdateAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.UserAccountGroup;
import com.lcl.erefill.core.common.telus.response.ValidateUserResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.IAccountService;
import com.lcl.erefill.core.services.IProfileService;
import com.lcl.erefill.core.services.IReportService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.PasswordReminder;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;
import com.lcl.erefill.core.vo.User;
import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

/**
 * @author vsha51
 */
@Component
public class AccountBusinessDelegate implements IAccountBusinessDelegate {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AccountBusinessDelegate.class);

	@Autowired
	IAccountService accountService;

	@Autowired
	ISessionService sessionService;
	
	@Autowired
	IReportService reportService;

	@Autowired
	IProfileService profileService;

	@Autowired
	SessionManager sessionManager;

	/**
	 * changePassword
	 * 
	 * @param changePassword
	 * @param session
	 * 
	 * @return changeMyAccountPasswordResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public ChangeMyAccountPasswordResponse changePassword(
			ChangePassword changePassword, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "changePassword";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = accountService
				.changePassword(changePassword, userToken);
		if (changeMyAccountPasswordResponse != null) {
			LOGGER.info(methodName + " changeMyAccountPasswordResponse: "
					+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			if (changeMyAccountPasswordResponse.getUserToken() != null) {
				sessionManager
						.setToken(
								changeMyAccountPasswordResponse.getUserToken(),
								session);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}

	/**
	 * updateAccountAlias
	 * 
	 * @param userName
	 * @param session
	 * 
	 * @return updateAccountAliasResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public UpdateAccountAliasResponse updateAccountAlias(String userName,
			ISession session) throws ERefillApplicationException,
			ERefillBusinessException {
		final String methodName = "updateAccountAlias";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UpdateAccountAliasResponse updateAccountAliasResponse = accountService
				.updateAccountAlias(userName, userToken);

		if (updateAccountAliasResponse != null) {
			LOGGER.info(methodName + " updateAccountAliasResponse: "
					+ updateAccountAliasResponse.getStatus());
			if (updateAccountAliasResponse.getUserToken() != null) {
				sessionManager.setToken(
						updateAccountAliasResponse.getUserToken(), session);
			}
			if (updateAccountAliasResponse.getStatus().equalsIgnoreCase("Ok")) {
				sessionManager.setUserName(userName, session);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return updateAccountAliasResponse;
	}

	/**
	 * updateAccountPreferences
	 * 
	 * @param arrayOfAccountPreference
	 * @param session
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public UpdatePreferencesResponse updateAccountPreferences(
			ArrayOfAccountPreference arrayOfAccountPreference, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "updateAccountPreferences";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UpdatePreferencesResponse updatePreferencesResponse = accountService
				.updateAccountPreferences(arrayOfAccountPreference, userToken);

		if (updatePreferencesResponse != null) {
			LOGGER.info(methodName + " updatePreferencesResponse: "
					+ updatePreferencesResponse.getUserToken());
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
	 * unsubscribe
	 * 
	 * @param isEmail
	 * @param isPhone
	 * @param session
	 * @return returnMap
	 */
	public Map<String, String> unsubscribe(Boolean isEmail, Boolean isPhone,
			ISession session) {
		final String methodName = "unsubscribe";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		Map<String, String> returnMap = sessionService
				.unsubscribe(userToken, isEmail, isPhone);

		sessionManager.setToken(userToken, session);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return returnMap;
	}

	/**
	 * updatePasswordReminder
	 * 
	 * @param arrayOfAccountPreference
	 * @param session
	 * @return updatePreferencesResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public UpdatePreferencesResponse updatePasswordReminder(
			ArrayOfAccountPreference arrayOfAccountPreference, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "updatePasswordReminder";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		UpdatePreferencesResponse updatePreferencesResponse = accountService
				.updatePasswordReminder(arrayOfAccountPreference, userToken);

		if (updatePreferencesResponse != null) {
			LOGGER.info(methodName + " updatePreferencesResponse: "
					+ updatePreferencesResponse.getUserToken());
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
	 * getMyAccountDetails
	 * 
	 * @param session
	 * @param securityQuestions
	 * @return accountDetailsResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public AccountDetailsResponse getMyAccountDetails(ISession session,
			String securityQuestions) throws ERefillApplicationException,
			ERefillBusinessException {
		final String methodName = "getMyAccountDetails";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		AccountDetailsResponse accountDetailsResponse = new AccountDetailsResponse();
		UserToken userToken = sessionManager.getToken(session);

		if (userToken == null) {
			return accountDetailsResponse;
		}
		CurrentAccountResponse currentAccountResponse = accountService.getCurrentAccount(userToken);
		if (currentAccountResponse != null) {
			LOGGER.info(methodName + " account: "+ currentAccountResponse.getAccount());
		}
		accountDetailsResponse.setAccount(currentAccountResponse.getAccount());

		if (currentAccountResponse.getUserToken() == null) {
			return accountDetailsResponse;
		}
		AccountAliasResponse accountAliasResponse = accountService.getAccountAlias(currentAccountResponse.getUserToken());
		if (accountAliasResponse != null) {
			LOGGER.info(methodName + " userName: "+ accountAliasResponse.getUserName());
		}
		accountDetailsResponse.setUserName(accountAliasResponse.getUserName());

		if (accountAliasResponse.getUserToken() == null) {
			return accountDetailsResponse;
		}
		AccountPreferencesResponse accountPreferenceResponse = accountService.listPreferences(accountAliasResponse.getUserToken());
		if (accountPreferenceResponse != null) {
			LOGGER.info(methodName + " accountPreferenceVO: "+ accountPreferenceResponse.getAccountPreferenceVO());
		}
		accountDetailsResponse.setAccountPreferenceVO(accountPreferenceResponse.getAccountPreferenceVO());

		if (accountPreferenceResponse.getUserToken() == null) {
			return accountDetailsResponse;
		}
		EmailStatusResponse emailStatusResponse = accountService.getEmailStatus(accountPreferenceResponse.getUserToken());
		accountDetailsResponse.setMailStatus(emailStatusResponse.getEmailStatus());

		if (emailStatusResponse.getUserToken() == null) {
			return accountDetailsResponse;
		}
		
		Map<String, String> phoneStatus = sessionService.getPhoneNumberStatus(emailStatusResponse.getUserToken());
		if (phoneStatus != null) {
			accountDetailsResponse.setPhoneStatus(phoneStatus.get("status"));
			accountDetailsResponse.setPhoneNumber(phoneStatus.get("phnno"));
		}
		
		PatientDataResponse patientDataResponse = profileService.getPatientData(emailStatusResponse.getUserToken());
		if (patientDataResponse != null) {
			accountDetailsResponse.setUserToken(patientDataResponse.getUserToken());
			if (patientDataResponse.getUserToken() != null) {
				sessionManager.setToken(patientDataResponse.getUserToken(),session);
			}
			if (patientDataResponse.getPatient() != null) {
				if (patientDataResponse.getPatient().getUserName() != null) {
					sessionManager.setUserName(patientDataResponse.getPatient().getUserName(), session);
				}
				sessionManager.setPatientID(patientDataResponse.getPatient().getOid(), session);
			}
		}

		List<String> questions = accountService.getListSecurityQuestions(securityQuestions);
		accountDetailsResponse.setQuestions(questions);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return accountDetailsResponse;
	}

	/**
	 * getCaregiverAccountDetails
	 */
	public CaregiverAccountDetailsResponse getCaregiverAccountDetails(ISession session, String securityQuestions)
		throws ERefillApplicationException,ERefillBusinessException {
		
		final String methodName ="getCaregiverAccountDetails";
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug(methodName + "Entering"); 
		}
		
		CaregiverAccountDetailsResponse caregiverAccDetailResponse= new CaregiverAccountDetailsResponse();
		UserToken userToken= sessionManager.getToken(session);
		
		if(userToken==null){
			return caregiverAccDetailResponse;
		}
		
		CurrentAccountResponse currentAccountResponse = accountService.getCurrentAccount(userToken);
		if(currentAccountResponse!=null){
			LOGGER.debug(methodName +" Account: " +currentAccountResponse.getAccount());
		}
		caregiverAccDetailResponse.setAccount(currentAccountResponse.getAccount());
		
		if(currentAccountResponse.getUserToken()==null){
			return caregiverAccDetailResponse;
		}
		caregiverAccDetailResponse.setUserToken(currentAccountResponse.getUserToken());
		sessionManager.setToken(currentAccountResponse.getUserToken(), session);
		
		/*EmailStatusResponse emailStatusResponse = accountService.getEmailStatus(currentAccountResponse.getUserToken());
		caregiverAccDetailResponse.setMailStatus(emailStatusResponse.getEmailStatus());
		
		if (emailStatusResponse.getUserToken() == null) {
			return caregiverAccDetailResponse;
		}
		Map<String, String> mailStatus = caregiverAccDetailResponse.getMailStatus();
		sessionManager.setToken(emailStatusResponse.getUserToken(), session);
		String mailId="";
		if (null != mailStatus && !mailStatus.isEmpty()){
			mailId = (String) mailStatus.get("mailid");
		}
		
		*/
		/*AccountPreferencesResponse accountPreferenceResponse = accountService.listPreferences(currentAccountResponse.getUserToken());
		if(accountPreferenceResponse!=null){
			LOGGER.debug(methodName + " accountPreferenceVO: "+ accountPreferenceResponse.getAccountPreferenceVO());
			sessionManager.setToken(accountPreferenceResponse.getUserToken(), session);
		}
		caregiverAccDetailResponse.setAccountPreferenceVO(accountPreferenceResponse.getAccountPreferenceVO());
		if(accountPreferenceResponse.getUserToken()==null){
			return caregiverAccDetailResponse;
		}
		
		List<String> questions = accountService.getListSecurityQuestions(securityQuestions);
		caregiverAccDetailResponse.setQuestions(questions);
		*/
		/*AccountAliasResponse accountAliasResponse = accountService.getAccountAlias(currentAccountResponse.getUserToken());
		if(accountAliasResponse!=null){
			LOGGER.debug(methodName + " userName: "+ accountAliasResponse.getUserName());
		}
		caregiverAccDetailResponse.setUserName(accountAliasResponse.getUserName());
		if(accountAliasResponse.getUserToken()==null){
			return caregiverAccDetailResponse;
		}
		
		
		AccountPreferencesResponse accountPreferenceResponse = accountService.listPreferences(accountAliasResponse.getUserToken());
		if(accountPreferenceResponse!=null){
			LOGGER.debug(methodName + " accountPreferenceVO: "+ accountPreferenceResponse.getAccountPreferenceVO());
		}
		caregiverAccDetailResponse.setAccountPreferenceVO(accountPreferenceResponse.getAccountPreferenceVO());
		if(accountPreferenceResponse.getUserToken()==null){
			return caregiverAccDetailResponse;
		}
		*/
		return caregiverAccDetailResponse;
				
	}
	/**
	 * getListSecurityQuestions
	 * 
	 * @param securityQuestions
	 * @return questions
	 */
	public List<String> getListSecurityQuestions(String securityQuestions) throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getListSecurityQuestions";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		List<String> questions = accountService
				.getListSecurityQuestions(securityQuestions);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return questions;
	}

	/**
	 * revokeConsent
	 * 
	 * @param session
	 * @param reasonKey
	 * @return revokeConsentResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public RevokeConsentResponse revokeConsent(ISession session,
			String reasonKey) throws ERefillApplicationException,
			ERefillBusinessException {
		final String methodName = "revokeConsent";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		RevokeConsentResponse revokeConsentResponse = accountService
				.revokeConsent(userToken, reasonKey);

		if (revokeConsentResponse != null
				&& revokeConsentResponse.getUserToken() != null) {
			sessionManager.setToken(revokeConsentResponse.getUserToken(),
					session);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return revokeConsentResponse;
	}

	/**
	 * closeAccount
	 * 
	 * @param session
	 * @return eRefillResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public ERefillResponse closeAccount(ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "closeAccount";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		ERefillResponse eRefillResponse = accountService
				.closeAccount(userToken);

		if (eRefillResponse != null && eRefillResponse.getUserToken() != null) {
			sessionManager.setToken(eRefillResponse.getUserToken(), session);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return eRefillResponse;
	}

	public ValidateUserResponse validateUser(String userName)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "validateUser";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		ValidateUserResponse validateUserResponse = null;

		validateUserResponse = accountService.validateUser(userName);
		if (ERefillConstants.STATUS_SUCCESS
				.equalsIgnoreCase(validateUserResponse.getStatus())) {
			PasswordReminder passwordReminder = new PasswordReminder();
			passwordReminder = accountService.getPasswordReminder(userName);
			validateUserResponse.setPasswordReminder(passwordReminder);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return validateUserResponse;
	}

	public ValidateUserResponse validateUser(ISession session, String userName)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "validateUser";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		LogOnResponse logOnResponse = null;
		ValidateUserResponse validateUserResponse = new ValidateUserResponse();

		UserToken userToken = sessionManager.getToken(session);
		String password = StringUtils.trimToEmpty(CommonUtils
				.decodeString(CommonUtils.decodeURL(userToken.getToken())));
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		logOnResponse = accountService.validateUser(user);
		validateUserResponse.setStatus(logOnResponse.getStatus());
		if (StringUtils.isNotBlank(logOnResponse.getToken())) {
			UserToken userReturnToken = new UserToken(
					logOnResponse.getStatus(), logOnResponse.getToken());
			sessionManager.setToken(userReturnToken, session);
			validateUserResponse.setToken(logOnResponse.getToken());
		}
		
		if(!ERefillConstants.STATUS_INVALID_USER_PASSWORD.equalsIgnoreCase(logOnResponse.getStatus())){
			/* calling service to get the user role
			 * in resetPassword controller changing the flow if the userRole is caregiver
			 */
			userToken = sessionManager.getToken(session);
			UserAccountGroup userGroup= sessionService.getUserRole(userToken);
			userToken = userGroup.getUserToken();
			String userRole = userGroup.getUserRole();
			sessionManager.setToken(userToken, session);
			sessionManager.setUserRole(userRole, session);
			
			
			if (ERefillConstants.STATUS_EMUST_CHANGE_PASSWORD
					.equalsIgnoreCase(logOnResponse.getStatus()) && (!userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER))) {
				PasswordReminder passwordReminder = new PasswordReminder();
				passwordReminder = accountService.getPasswordReminder(user.getUsername());
				validateUserResponse.setPasswordReminder(passwordReminder);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return validateUserResponse;
	}

	public String validateSecurityAnswer(
			ValidateSecurityAnswerRequest validateSecAnsRequest)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "validateSecurityAnswer";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		String status = StringUtils.EMPTY;

		status = accountService.validateSecurityAnswer(validateSecAnsRequest);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return status;
	}

	public ChangeMyAccountPasswordResponse changeResetPassword(
			ChangePassword changePassword, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "changeResetPassword";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		UserToken userToken = sessionManager.getToken(session);
		ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = accountService
				.changeResetPassword(changePassword, userToken);
		if (changeMyAccountPasswordResponse != null) {
			LOGGER.info(methodName + " changeMyAccountPasswordResponse: "
					+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			if (changeMyAccountPasswordResponse.getUserToken() != null) {
				sessionManager
						.setToken(
								changeMyAccountPasswordResponse.getUserToken(),
								session);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return changeMyAccountPasswordResponse;
	}

	/**
	 * getPatientTaxReceiptReport
	 * 
	 * @param taxReceiptReportRequest
	 * @param session
	 * 
	 * @return taxReceiptReportResponse
	 * @throws ERefillApplicationException
	 *             , ERefillBusinessException
	 */
	public TaxReceiptReportResponse getPatientTaxReceiptReport(
			TaxReceiptReportRequest taxReceiptReportRequest, ISession session)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getPatientTaxReceiptReport";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		UserToken userToken = sessionManager.getToken(session);
		// String patientID = sessionManager.getPatientID(session);
		// taxReceiptReportRequest.setPatientOID(patientID);

		TaxReceiptReportResponse taxReceiptReportResponse = reportService
				.getTaxReceiptReport(taxReceiptReportRequest, userToken);

		//String path = null;
		// String path = generatePDF(taxReceiptReportRequest.getStartDate(),
		// taxReceiptReportRequest.getEndDate());

		if (taxReceiptReportResponse != null) {
			LOGGER.info(methodName + " taxReceiptReportResponse: "
					+ taxReceiptReportResponse.getResponseStatus());
			if (taxReceiptReportResponse.getUserToken() != null) {
				sessionManager.setToken(
						taxReceiptReportResponse.getUserToken(), session);
			}
			//path = generatePDF(taxReceiptReportResponse);
			//LOGGER.info(methodName + " Path: " + path);
			//taxReceiptReportResponse.setFilePath(path);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return taxReceiptReportResponse;
	}

	/**
	 * generatePDF
	 * 
	 * @param taxReceiptReportResponse
	 * @return path
	 */
	/*private String generatePDF(TaxReceiptReportResponse taxReceiptReportResponse) {
		final String methodName = "generatePDF";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		if (taxReceiptReportResponse.getContent() == null) {
			return null;
		}

		String path = "d:/"+"taxReport"+Math.random()+".pdf";
		FileOutputStream fos = null;
		try {
			LOGGER.debug(methodName + " taxReceiptReportResponse Content: "
					+ taxReceiptReportResponse.getContent() + " Extension: "
					+ taxReceiptReportResponse.getExtension() + " Mimetype: "
					+ taxReceiptReportResponse.getMimeType());
			fos = new FileOutputStream(path);
			fos.write(taxReceiptReportResponse.getContent());
		} catch (Exception e) {
			LOGGER.error(methodName + " Exception while creating pdf: " + e);
			return null;
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				LOGGER.error(methodName
						+ " Exception while closing output stream: " + e);
				return null;
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return path;
	}*/
}
