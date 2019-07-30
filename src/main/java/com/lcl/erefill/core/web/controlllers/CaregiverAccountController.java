package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.IAccountBusinessDelegate;
import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.IManagedAccountDelegate;
import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.AccountPreferenceVO;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.MyAccountJSONResponse;
import com.lcl.erefill.core.vo.UpdateSecurityQuestions;
import com.lcl.erefill.core.web.validators.ChangePasswordRequestValidator;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceEAccountPreferenceType;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

@Controller
@RequestMapping("{locale}/myaccount")
public class CaregiverAccountController {
	
	private static final Logger logger=LoggerFactory.getLogger(CaregiverAccountController.class);
	
	@Autowired
	SessionManager sessionManager;

	@Autowired
	IAccountBusinessDelegate accountBusinessDelegate;

	@Autowired
	IManagedAccountDelegate managedAccountDelegate;

	@Autowired
	ILoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	private ReloadableResourceBundleMessageSource resourceBundleMessageSource;

	@Autowired
	private ChangePasswordRequestValidator changePasswordRequestValidator;

	@InitBinder("changePasswordRequest")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(changePasswordRequestValidator);
	}


	@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, value="/caregiver/details")
	@ResponseBody
	@ResponseStatus(value= HttpStatus.OK)
	public ModelAndView getAccountDetails(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response){
		final String methodName="getAccountDetails";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		String appContext = request.getContextPath();
		//Enable cross domain calls
		
		
		//setting the locale
		Locale localeObj = setLocale(locale);
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		} 
		model.addAttribute(ERefillConstants.USER_ROLE, sessionManager.getUserRole(eRefillSession));
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,isLoggedInUser);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_ACCOUNT_PAGE_TITLE);
		
		String secQuestionsKey = "my.account.security.questions";
		String secQuestions = resourceBundleMessageSource.getMessage(secQuestionsKey, null, localeObj);
		AccountDetailsResponse accountDetailsResponse = null;
		
		//UserToken userTokn= sessionManager.getToken(eRefillSession);
		
		
		try {
			accountDetailsResponse = accountBusinessDelegate.getMyAccountDetails(eRefillSession, secQuestions);
			if (accountDetailsResponse.getUserToken() == null) {
				throw new Exception("User Token Expired");
			}
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		// Fetch the alternate language security questions.
		Locale localeObjAlt = null;
		if ("en_CA".equalsIgnoreCase(locale)) {
			localeObjAlt = setLocale("fr_CA");
		} else {
			localeObjAlt = setLocale("en_CA");
		}
		String secQuestionsAlt = resourceBundleMessageSource.getMessage(secQuestionsKey, null, localeObjAlt);
		List<String> questionsAlt = null;
		try {
			questionsAlt = accountBusinessDelegate.getListSecurityQuestions(secQuestionsAlt);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		
		String mailId = accountDetailsResponse.getAccountPreferenceVO().getMailId();
		if(mailId==null || mailId.isEmpty()){
			mailId="";
		}
		
		AccountPreferenceVO accountPreferenceVO = accountDetailsResponse.getAccountPreferenceVO();
		String delimiter= ".";
		String questionKeyFromResponse = accountPreferenceVO.getSecurityQuestion1();
		
		if(questionKeyFromResponse.contains(":")){
			delimiter=":";
		}
		List<String> questions = accountDetailsResponse.getQuestions();
		Map<String, String> questionsMap = new HashMap<String, String>();
		int count = 1;
		for (String que : questions) {
			String key = secQuestionsKey + delimiter + count;
			questionsMap.put(CommonUtils.formatStringInUTF8(key), que);
			count++;
		}

		Map<String, String> questionsMapAll = new HashMap<String, String>();
		count = 1;
		for (String que : questions) {
			String key = secQuestionsKey + delimiter + count;
			questionsMapAll.put(que, CommonUtils.formatStringInUTF8(key));
			count++;
		}
		count = 1;
		for (String que : questionsAlt) {
			String key = secQuestionsKey + delimiter + count;
			questionsMapAll.put(que, CommonUtils.formatStringInUTF8(key));
			count++;
		}

		
		Iterator<Entry<String, String>> it = questionsMapAll.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			if (accountPreferenceVO.getSecurityQuestion1().contains(entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion1(entry.getValue().toString());
			}
			if (accountPreferenceVO.getSecurityQuestion2().contains(entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion2(entry.getValue().toString());
			}
			if (accountPreferenceVO.getSecurityQuestion3().contains(entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion3(entry.getValue().toString());
			}
		}

		// Set objects in the model.
		model.addAttribute(ERefillConstants.MAP_KEY_ACCOUNT,accountDetailsResponse.getAccount());
		model.addAttribute(ERefillConstants.MAP_KEY_USERNAME,accountDetailsResponse.getUserName());
		model.addAttribute(ERefillConstants.MAP_KEY_ACCOUNT_PREFERENCE,accountPreferenceVO);
		model.addAttribute(ERefillConstants.MAP_KEY_MAIL_ID, mailId);
		model.addAttribute(ERefillConstants.MAP_KEY_QUESTIONS_MAP, questionsMap);
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.CARE_GIVER_PAGE_NAME_MY_ACCOUNT);
		
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return (new ModelAndView("caregiverMyAccount"));
	}
	
	/**
	 * setLocale
	 * 
	 * @param loc
	 * @return
	 */
	private Locale setLocale(String loc) {
		Locale locale = new Locale("en", "CA");
		if (loc != null && "fr_CA".equalsIgnoreCase(loc)) {
			locale = new Locale("fr", "CA");
		}
		return locale;
	}
	
	/**
	 * changePassword
	 * 
	 * @param locale
	 * @param changePassword
	 * @param result
	 * @param request
	 * @param response
	 * @return myAccountJSONResponse
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/caregiver/password/change", headers = {
			"Accept=text/plain;charset=UTF-8",
			"Content-Type=application/x-www-form-urlencoded" })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public MyAccountJSONResponse changePassword(
			@PathVariable String locale,
			@ModelAttribute("changePassword") @Validated ChangePassword changePassword,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "changePassword";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		MyAccountJSONResponse myAccountJSONResponse = null;
		// Enable cross domain calls
		String appContext = request.getContextPath();

		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		try {
			ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = accountBusinessDelegate.changePassword(changePassword, eRefillSession);
			myAccountJSONResponse = createChangePasswordJSONResponse(changeMyAccountPasswordResponse);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			myAccountJSONResponse = new MyAccountJSONResponse();
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

	/**
	 * createChangePasswordJSONResponse
	 * 
	 * @param changeMyAccountPasswordResponse
	 * @return myAccountJSONResponse
	 */
	private MyAccountJSONResponse createChangePasswordJSONResponse(
			ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse) {
		final String methodName = "createChangePasswordJSONResponse";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		MyAccountJSONResponse myAccountJSONResponse = new MyAccountJSONResponse();

		if (changeMyAccountPasswordResponse == null) {
			logger.info(methodName + " changeMyAccountPasswordResponse: "
					+ changeMyAccountPasswordResponse);
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		myAccountJSONResponse.setUpdate_status("exception");
		if (ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(changeMyAccountPasswordResponse
						.getChangePasswordStatus())) {
			logger.info(methodName + " Response Status: "
					+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			myAccountJSONResponse.setUpdate_status("ok");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken().getToken()) {
				myAccountJSONResponse.setToken_value(changeMyAccountPasswordResponse.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status(changeMyAccountPasswordResponse.getUserToken().getStatus());

		} else if (ERefillConstants.STATUS_INVALID_USER_PASSWORD
				.equalsIgnoreCase(changeMyAccountPasswordResponse.getChangePasswordStatus())) {
			logger.info(methodName + " Response Status: "+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			myAccountJSONResponse.setUpdate_status("error");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken().getToken()) {
				myAccountJSONResponse.setToken_value(changeMyAccountPasswordResponse.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status("Ok");
		} else {
			myAccountJSONResponse.setUpdate_status("error1");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken().getToken()) {
				myAccountJSONResponse.setToken_value(changeMyAccountPasswordResponse.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status("Ok");
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

	/**
	 * updateSecurityQuestions
	 * 
	 * @param locale
	 * @param updateSecurityQuestions
	 * @param result
	 * @param request
	 * @param response
	 * @return myAccountJSONResponse
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/caregiver/securityquestions/update", headers = {
			"Accept=text/plain;charset=UTF-8",
			"Content-Type=application/x-www-form-urlencoded" })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public MyAccountJSONResponse updateSecurityQuestions(
			@PathVariable String locale,
			@ModelAttribute("updateSecurityQuestions") @Validated UpdateSecurityQuestions updateSecurityQuestions,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "updateSecurityQuestions";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		MyAccountJSONResponse myAccountJSONResponse = null;
		// Enable cross domain calls
		String appContext = request.getContextPath();
		
		ArrayOfAccountPreference arrayOfAccountPreference = new ArrayOfAccountPreference();
		AccountPreference accountPreference1 = new AccountPreference();
		accountPreference1.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_1);
		accountPreference1.setValue(updateSecurityQuestions.getQuestion1());

		AccountPreference accountPreference2 = new AccountPreference();
		accountPreference2.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_2);
		accountPreference2.setValue(updateSecurityQuestions.getQuestion2());

		AccountPreference accountPreference3 = new AccountPreference();
		accountPreference3.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_3);
		accountPreference3.setValue(updateSecurityQuestions.getQuestion3());

		AccountPreference accountPreference4 = new AccountPreference();
		accountPreference4.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_1);
		accountPreference4.setValue(updateSecurityQuestions.getAnswer1());

		AccountPreference accountPreference5 = new AccountPreference();
		accountPreference5.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_2);
		accountPreference5.setValue(updateSecurityQuestions.getAnswer2());

		AccountPreference accountPreference6 = new AccountPreference();
		accountPreference6.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_3);
		accountPreference6.setValue(updateSecurityQuestions.getAnswer3());

		arrayOfAccountPreference.getAccountPreference().add(accountPreference1);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference2);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference3);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference4);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference5);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference6);

		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
			UpdatePreferencesResponse updatePreferencesResponse = accountBusinessDelegate.updatePasswordReminder(arrayOfAccountPreference,eRefillSession);
			myAccountJSONResponse = createUpdatePreferencesJSONResponse(updatePreferencesResponse, "security", true);

		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			myAccountJSONResponse = new MyAccountJSONResponse();
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

	/**
	 * createUpdatePreferencesJSONResponse
	 * 
	 * @param updatePreferencesResponse
	 * @param value
	 * @return myAccountJSONResponse
	 */
	private MyAccountJSONResponse createUpdatePreferencesJSONResponse(
			UpdatePreferencesResponse updatePreferencesResponse, String value,
			boolean isEngagement) {
		final String methodName = "createUpdatePreferencesJSONResponse";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		MyAccountJSONResponse myAccountJSONResponse = new MyAccountJSONResponse();

		if (updatePreferencesResponse == null) {
			logger.info(methodName + " updatePreferencesResponse: "
					+ updatePreferencesResponse);
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		if (updatePreferencesResponse.getUserToken() != null
				&& ERefillConstants.STATUS_SUCCESS
						.equalsIgnoreCase(updatePreferencesResponse
								.getUserToken().getStatus())) {
			logger.info(methodName + " Response Status: "
					+ updatePreferencesResponse.getUserToken().getStatus());
			myAccountJSONResponse.setUpdate_status("ok");
		} else if (updatePreferencesResponse.getUserToken() != null
				&& ERefillConstants.STATUS_INVALID_ARGUMENTS
						.equalsIgnoreCase(updatePreferencesResponse
								.getUserToken().getStatus())
				&& value.equalsIgnoreCase("phone")) {
			logger.info(methodName + " Response Status: "
					+ updatePreferencesResponse.getUserToken().getStatus());
			myAccountJSONResponse.setUpdate_status("invalid");
		} else {
			logger.info(methodName + " Response Status: error");
			myAccountJSONResponse.setUpdate_status("error");
		}

		if (isEngagement) {
			myAccountJSONResponse.setEngagement(value);
		} else {
			myAccountJSONResponse.setUnsubscribed(value);
		}
		myAccountJSONResponse.setToken_status(updatePreferencesResponse
				.getUserToken().getStatus());
		if (null != updatePreferencesResponse.getUserToken().getToken()) {
			myAccountJSONResponse.setToken_value(updatePreferencesResponse
					.getUserToken().getToken());
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

}
