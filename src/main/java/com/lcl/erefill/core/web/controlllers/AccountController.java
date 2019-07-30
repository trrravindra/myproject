package com.lcl.erefill.core.web.controlllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.common.telus.response.UpdateAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.AccountPreferenceVO;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.MyAccountJSONResponse;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;
import com.lcl.erefill.core.vo.UpdateSecurityQuestions;
import com.lcl.erefill.core.web.validators.ChangePasswordRequestValidator;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceEAccountPreferenceType;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;

@Controller
@RequestMapping("/{locale}/myaccount")
/**
 * @author vsha51
 */
public class AccountController {
	private static final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

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

	/**
	 * getMyAccountDetails
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/details")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getMyAccountDetails(@PathVariable String locale,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getMyAccountDetails";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		// Enable cross domain calls
		

		// Set the locale
		Locale localeObj = setLocale(locale);
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String secQuestionsKey = "my.account.security.questions";
		String secQuestions = resourceBundleMessageSource.getMessage(
				secQuestionsKey, null, localeObj);
		AccountDetailsResponse accountDetailsResponse = null;
		try {
			accountDetailsResponse = accountBusinessDelegate
					.getMyAccountDetails(eRefillSession, secQuestions);
			if (accountDetailsResponse.getUserToken() == null) {
				throw new Exception("User Token Expired");
			}
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			throw e;
		} catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			loginBusinessDelegate.logOut(null, request, response);
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
				String redirect = appContext+ "/home/" + locale	+ "/welcome?signinerror=eProcessingError";
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
		String secQuestionsAlt = resourceBundleMessageSource.getMessage(
				secQuestionsKey, null, localeObjAlt);
		List<String> questionsAlt = null;
		try {
			questionsAlt = accountBusinessDelegate
					.getListSecurityQuestions(secQuestionsAlt);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			loginBusinessDelegate.logOut(null, request, response);
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
				model.addAttribute("isRedirect",true);
				
				throw e;
			}
			
		}catch (Exception e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		Map<String, String> mailStatus = accountDetailsResponse.getMailStatus();
		String mailId = "";
		String mailIdStatus = "";
		if (null != mailStatus && !mailStatus.isEmpty())
			mailId = (String) mailStatus.get("mailid");
		if (mailId == null || mailId.isEmpty())
			mailId = "";
		if (null != mailStatus && !mailStatus.isEmpty()
				&& mailStatus.size() > 0)
			mailIdStatus = (String) mailStatus.get("status");

		if ("Invalidkey".equals(mailIdStatus)) {
			mailIdStatus = resourceBundleMessageSource.getMessage(
					"my.account.email.not.present.label", null, localeObj);
		} else if ("Pending".equals(mailIdStatus)) {
			mailIdStatus = resourceBundleMessageSource.getMessage(
					"my.account.email.pending.label", null, localeObj);
		} else if ("OK".equals(mailIdStatus)) {
			mailIdStatus = resourceBundleMessageSource.getMessage(
					"my.account.email.ok.label", null, localeObj);
		}

		String phoneStatus = "";
		if (StringUtils.isNotBlank(accountDetailsResponse.getPhoneStatus())) {
			phoneStatus = accountDetailsResponse.getPhoneStatus();
		}
		if ("0".equals(phoneStatus)) {
			phoneStatus = resourceBundleMessageSource.getMessage(
					"my.account.telephone.confirmed.label", null, localeObj);
		} else if ("1".equals(phoneStatus)) {
			phoneStatus = resourceBundleMessageSource.getMessage(
					"my.account.telephone.pending.label", null, localeObj);
		} else if ("2".equals(phoneStatus)) {
			phoneStatus = resourceBundleMessageSource.getMessage(
					"my.account.telephone.not.present.label", null, localeObj);
		}

		AccountPreferenceVO accountPreferenceVO = accountDetailsResponse
				.getAccountPreferenceVO();
		String delimiter = ".";
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

		
		Iterator<Entry<String, String>> it = questionsMapAll.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it
					.next();
			if (accountPreferenceVO.getSecurityQuestion1().contains(
					entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion1(entry.getValue()
						.toString());
			}
			if (accountPreferenceVO.getSecurityQuestion2().contains(
					entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion2(entry.getValue()
						.toString());
			}
			if (accountPreferenceVO.getSecurityQuestion3().contains(
					entry.getKey().toString())) {
				accountPreferenceVO.setSecurityQuestion3(entry.getValue()
						.toString());
			}
		}

		String phoneNum1 = "";
		String phoneNum2 = "";
		String phoneNum3 = "";
		if (StringUtils.isNotBlank(accountDetailsResponse.getPhoneNumber())) {
			String phoneNumber = accountDetailsResponse.getPhoneNumber();
			if (phoneNumber.length() == 10) {
				phoneNum1 = phoneNumber.substring(0, 3);
				phoneNum2 = phoneNumber.substring(3, 6);
				phoneNum3 = phoneNumber.substring(6, 10);
			}
		}

		String termsofUseText = resourceBundleMessageSource.getMessage(
				"my.account.terms.of.use.text", null, localeObj);
		String path = appContext+ "/" + locale+ "/myaccount/termsofuse";
		String text = "<a href=\"\" class=\"modal\" data-modal=" + path + " >";
		termsofUseText = termsofUseText.replace("{", text);
		termsofUseText = termsofUseText.replace("}", "</a>");

		// Set objects in the model.
		model.addAttribute(ERefillConstants.MAP_KEY_ACCOUNT,
				accountDetailsResponse.getAccount());
		model.addAttribute(ERefillConstants.MAP_KEY_USERNAME,
				accountDetailsResponse.getUserName());
		model.addAttribute(ERefillConstants.MAP_KEY_ACCOUNT_PREFERENCE,
				accountPreferenceVO);
		model.addAttribute(ERefillConstants.MAP_KEY_MAIL_ID, mailId);
		model.addAttribute(ERefillConstants.MAP_KEY_MAIL_STATUS, mailIdStatus);
		model.addAttribute(ERefillConstants.MAP_KEY_QUESTIONS_MAP, questionsMap);
		model.addAttribute(ERefillConstants.MAP_KEY_TERMS_OF_USE_TEXT,
				termsofUseText);
		model.addAttribute(ERefillConstants.MAP_KEY_PHONE_NUM1, phoneNum1);
		model.addAttribute(ERefillConstants.MAP_KEY_PHONE_NUM2, phoneNum2);
		model.addAttribute(ERefillConstants.MAP_KEY_PHONE_NUM3, phoneNum3);
		model.addAttribute(ERefillConstants.MAP_KEY_PHONE_STATUS, phoneStatus);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
				sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
				sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,
				ERefillConstants.PAGE_NAME_MY_ACCOUNT);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
				sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
				sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_ACCOUNT_PAGE_TITLE);
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("myAccount");
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
	@RequestMapping(method = RequestMethod.POST, value = "/password/change", headers = {
			"Accept=application/json,text/plain;charset=UTF-8",
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
		//String appContext = request.getContextPath();
		MyAccountJSONResponse myAccountJSONResponse = null;
		// Enable cross domain calls
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
			ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = accountBusinessDelegate
					.changePassword(changePassword, eRefillSession);
			myAccountJSONResponse = createChangePasswordJSONResponse(changeMyAccountPasswordResponse);
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
		if (ERefillConstants.STATUS_SUCCESS
				.equalsIgnoreCase(changeMyAccountPasswordResponse
						.getChangePasswordStatus())) {
			logger.info(methodName + " Response Status: "
					+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			myAccountJSONResponse.setUpdate_status("ok");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken()
							.getToken()) {
				myAccountJSONResponse
						.setToken_value(changeMyAccountPasswordResponse
								.getUserToken().getToken());
			}
			myAccountJSONResponse
					.setToken_status(changeMyAccountPasswordResponse
							.getUserToken().getStatus());

		} else if (ERefillConstants.STATUS_INVALID_USER_PASSWORD
				.equalsIgnoreCase(changeMyAccountPasswordResponse
						.getChangePasswordStatus())) {
			logger.info(methodName + " Response Status: "
					+ changeMyAccountPasswordResponse.getChangePasswordStatus());
			myAccountJSONResponse.setUpdate_status("error");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken()
							.getToken()) {
				myAccountJSONResponse
						.setToken_value(changeMyAccountPasswordResponse
								.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status("Ok");
		} else {
			myAccountJSONResponse.setUpdate_status("error1");
			myAccountJSONResponse.setEngagement("password");

			if (null != changeMyAccountPasswordResponse.getUserToken()
					&& null != changeMyAccountPasswordResponse.getUserToken()
							.getToken()) {
				myAccountJSONResponse
						.setToken_value(changeMyAccountPasswordResponse
								.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status("Ok");
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

	/**
	 * updateUserName
	 * 
	 * @param locale
	 * @param result
	 * @param request
	 * @param response
	 * @return myAccountJSONResponse
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/username/update", headers = {
			"Accept=application/json,text/plain;charset=UTF-8",
			"Content-Type=application/x-www-form-urlencoded" })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public MyAccountJSONResponse updateUserName(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "updateUserName";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		//String appContext= request.getContextPath();
		// Enable cross domain calls
		
		MyAccountJSONResponse myAccountJSONResponse = null;
		String userName = request
				.getParameter(ERefillConstants.REQ_PARAM_USERNAME);
		if (StringUtils.isBlank(userName)) {
			myAccountJSONResponse = new MyAccountJSONResponse();
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		try {
			UpdateAccountAliasResponse updateAccountAliasResponse = accountBusinessDelegate
					.updateAccountAlias(userName, eRefillSession);
			myAccountJSONResponse = createUpdateUserNameJSONResponse(updateAccountAliasResponse);

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
	 * createUpdateUserNameJSONResponse
	 * 
	 * @param updateAccountAliasResponse
	 * @return myAccountJSONResponse
	 */
	private MyAccountJSONResponse createUpdateUserNameJSONResponse(
			UpdateAccountAliasResponse updateAccountAliasResponse) {
		final String methodName = "createUpdateUserNameJSONResponse";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		MyAccountJSONResponse myAccountJSONResponse = new MyAccountJSONResponse();

		if (updateAccountAliasResponse == null) {
			logger.info(methodName + " updateAccountAliasResponse: "
					+ updateAccountAliasResponse);
			myAccountJSONResponse.setUpdate_status("exception");
			return myAccountJSONResponse;
		}

		if (ERefillConstants.STATUS_SUCCESS
				.equalsIgnoreCase(updateAccountAliasResponse.getStatus())) {
			logger.info(methodName + " Response Status: "
					+ updateAccountAliasResponse.getStatus());
			myAccountJSONResponse.setUpdate_status("ok");
			myAccountJSONResponse.setEngagement("username");

			if (null != updateAccountAliasResponse.getUserToken()
					&& null != updateAccountAliasResponse.getUserToken()
							.getToken()) {
				myAccountJSONResponse.setToken_value(updateAccountAliasResponse
						.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status(updateAccountAliasResponse
					.getUserToken().getStatus());

		} else {
			logger.info(methodName + " Response Status: error");
			myAccountJSONResponse.setUpdate_status("error");
			myAccountJSONResponse.setEngagement("username");

			if (null != updateAccountAliasResponse.getUserToken()
					&& null != updateAccountAliasResponse.getUserToken()
							.getToken()) {
				myAccountJSONResponse.setToken_value(updateAccountAliasResponse
						.getUserToken().getToken());
			}
			myAccountJSONResponse.setToken_status("Ok");
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return myAccountJSONResponse;
	}

	/**
	 * updateEmail
	 * 
	 * @param locale
	 * @param result
	 * @param request
	 * @param response
	 * @return myAccountJSONResponse
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/email/update", headers = {
			"Accept=application/json,text/plain;charset=UTF-8",
			"Content-Type=application/x-www-form-urlencoded" })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public MyAccountJSONResponse updateEmail(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "updateEmail";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		// Enable cross domain calls
		
		MyAccountJSONResponse myAccountJSONResponse = null;
		String email = request.getParameter(ERefillConstants.REQ_PARAM_EMAILID);
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		// Unsubscribe
		if (StringUtils.isBlank(email)) {

			try {

				Map<String, String> unsubscribedStatus = accountBusinessDelegate
						.unsubscribe(Boolean.TRUE, Boolean.FALSE,
								eRefillSession);

				UpdatePreferencesResponse updatePreferencesResponse = new UpdatePreferencesResponse();
				UserToken userToken = new UserToken();
				userToken.setStatus(unsubscribedStatus.get("status"));
				userToken.setToken(unsubscribedStatus.get("token"));
				updatePreferencesResponse.setUserToken(userToken);

				myAccountJSONResponse = createUpdatePreferencesJSONResponse(
						updatePreferencesResponse, "email", false);
			} catch (Exception e) {
				myAccountJSONResponse = new MyAccountJSONResponse();
				myAccountJSONResponse.setUpdate_status("exception");
				return myAccountJSONResponse;
			}
			
			//email unsubscribed fix
			String unSubscribe = "my.account.email.not.present.label";
			String i18nEmailStatus = resourceBundleMessageSource.getMessage(unSubscribe, null, setLocale(locale));
			myAccountJSONResponse.setEmailstatus(i18nEmailStatus);
			logger.debug("Email Status in i18n<<<<<<<<<<<<<<"+i18nEmailStatus);
			return myAccountJSONResponse;

		} else { // update
			SessionManager session = new SessionManager();
			UserToken userToken=session.getToken(eRefillSession);
			SessionWSImpl sessionimpl = new SessionWSImpl();
			ArrayOfAccountPreference arrayOfAccountPreference = new ArrayOfAccountPreference();
			AccountPreference accountPreference = new AccountPreference();
			accountPreference
					.setType(AccountPreferenceEAccountPreferenceType.EMAIL);
			accountPreference.setValue(email);
			arrayOfAccountPreference.getAccountPreference().add(
					accountPreference);

			try {
				UpdatePreferencesResponse updatePreferencesResponse = accountBusinessDelegate
						.updateAccountPreferences(arrayOfAccountPreference,
 								eRefillSession);
				myAccountJSONResponse = createUpdatePreferencesJSONResponse(
						updatePreferencesResponse, "email", true);
				Map<String, String> mailStatus = sessionimpl.getEmailStatus(userToken,null);
				
				String mailIdStatus = "";
				
				String unSubscribe = "my.account.email.not.present.label";
				String i18nEmailStatus = resourceBundleMessageSource.getMessage(unSubscribe, null, setLocale(locale));
				
				if (null != mailStatus && !mailStatus.isEmpty() && mailStatus.size() > 0) {				
					String pendingKey = "my.account.email.pending.label";
					String okKey = "my.account.email.ok.label";
					
					mailIdStatus = (String) mailStatus.get("status");										
					if(mailIdStatus.equalsIgnoreCase("pending")){
						i18nEmailStatus = resourceBundleMessageSource.getMessage(pendingKey, null, setLocale(locale));
					} else{
						i18nEmailStatus = resourceBundleMessageSource.getMessage(okKey, null, setLocale(locale));
					}
				}
				logger.debug("Email Status in i18n>>>>>>>>>>>>>"+i18nEmailStatus);
				myAccountJSONResponse.setEmailstatus(i18nEmailStatus);
				
			} catch (Exception e) {
				myAccountJSONResponse = new MyAccountJSONResponse();
				myAccountJSONResponse.setUpdate_status("exception");
				return myAccountJSONResponse;
			}
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

	/**
	 * updatePhone
	 * 
	 * @param locale
	 * @param result
	 * @param request
	 * @param response
	 * @return myAccountJSONResponse
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/phone/update", headers = {
			"Accept=application/json,text/plain;charset=UTF-8",
			"Content-Type=application/x-www-form-urlencoded" })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public MyAccountJSONResponse updatePhone(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "updatePhone";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		// Enable cross domain calls
		
		MyAccountJSONResponse myAccountJSONResponse = null;
		String phone1 = request.getParameter(ERefillConstants.REQ_PARAM_PHONE1);
		String phone2 = request.getParameter(ERefillConstants.REQ_PARAM_PHONE2);
		String phone3 = request.getParameter(ERefillConstants.REQ_PARAM_PHONE3);
		String phone = "";
		if (StringUtils.isNotBlank(phone1)) {
			phone += phone1.trim();
		}
		if (StringUtils.isNotBlank(phone2)) {
			phone += phone2.trim();
		}
		if (StringUtils.isNotBlank(phone3)) {
			phone += phone3.trim();
		}
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		// Unsubscribe
		if (StringUtils.isBlank(phone)) {

			try {

				Map<String, String> unsubscribedStatus = accountBusinessDelegate
						.unsubscribe(Boolean.FALSE, Boolean.TRUE,
								eRefillSession);

				UpdatePreferencesResponse updatePreferencesResponse = new UpdatePreferencesResponse();
				UserToken userToken = new UserToken();
				userToken.setStatus(unsubscribedStatus.get("status"));
				userToken.setToken(unsubscribedStatus.get("token"));
				updatePreferencesResponse.setUserToken(userToken);
                myAccountJSONResponse = createUpdatePreferencesJSONResponse(
						updatePreferencesResponse, "phone", false);
			} catch (Exception e) {
				myAccountJSONResponse = new MyAccountJSONResponse();
				myAccountJSONResponse.setUpdate_status("exception");
				return myAccountJSONResponse;
			}
			
			//phone unsubscribed fix
			String unSubscribe = "my.account.telephone.not.present.label";
			String i18nPhoneStatus = resourceBundleMessageSource.getMessage(unSubscribe, null, setLocale(locale));
			myAccountJSONResponse.setPhonestatus(i18nPhoneStatus);
			logger.debug("Phone Status in i18n<<<<<<<<<<<<<<"+i18nPhoneStatus);
			
			return myAccountJSONResponse;

		} else { // update

			SessionManager session = new SessionManager();
			UserToken userToken=session.getToken(eRefillSession);
			SessionWSImpl sessionimpl = new SessionWSImpl();
			
			ArrayOfAccountPreference arrayOfAccountPreference = new ArrayOfAccountPreference();
			AccountPreference accountPreference = new AccountPreference();
			accountPreference
					.setType(AccountPreferenceEAccountPreferenceType.MOBILE_PHONE_NUMBER);
			accountPreference.setValue(phone);
			arrayOfAccountPreference.getAccountPreference().add(
					accountPreference);

			try {
				UpdatePreferencesResponse updatePreferencesResponse = accountBusinessDelegate
						.updateAccountPreferences(arrayOfAccountPreference,
								eRefillSession);
				myAccountJSONResponse = createUpdatePreferencesJSONResponse(
						updatePreferencesResponse, "phone", true);
				
				/**
				 *   In prev call, if phone number is invalid, Telus will return userToken Status as eInvalidArguments.
				 *   If userToken status is 'eInvalidArguments', setting it to 'Ok' before making next call, as it will throw soap fault exception if we pass 
				 *   <Status>eInvalidArguments</Status>  in SOAP Request
				 *   **/
				if(userToken.getStatus().equalsIgnoreCase(ERefillConstants.STATUS_INVALID_ARGUMENTS)){
					userToken.setStatus(ERefillConstants.STATUS_SUCCESS);
				}
				Map<String, String> phoneStatus = sessionimpl.getPhoneNumberStatus(userToken);
				
				String phoneNumberStatus = "";
				
				String unSubscribe = "my.account.telephone.not.present.label";
				String i18nPhoneStatus = resourceBundleMessageSource.getMessage(unSubscribe, null, setLocale(locale));
				
				if (null != phoneStatus && !phoneStatus.isEmpty() && phoneStatus.size() > 0) {				
					String pendingKey = "my.account.telephone.pending.label";
					String okKey = "my.account.telephone.ok.label";
					
					phoneNumberStatus = (String) phoneStatus.get("status");										
					if(phoneNumberStatus.equalsIgnoreCase("1")){
						i18nPhoneStatus = resourceBundleMessageSource.getMessage(pendingKey, null, setLocale(locale));
					}
				}
				logger.debug("Phone Status in i18n >>>>>>>>>>>>>"+i18nPhoneStatus);
				myAccountJSONResponse.setPhonestatus(i18nPhoneStatus);
				
			} catch (Exception e) {
				myAccountJSONResponse = new MyAccountJSONResponse();
				myAccountJSONResponse.setUpdate_status("exception");
				return myAccountJSONResponse;
			}
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
	@RequestMapping(method = RequestMethod.POST, value = "/securityquestions/update", headers = {
			"Accept=application/json,text/plain;charset=UTF-8",
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
		

		ArrayOfAccountPreference arrayOfAccountPreference = new ArrayOfAccountPreference();
		AccountPreference accountPreference1 = new AccountPreference();
		accountPreference1
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_1);
		accountPreference1.setValue(updateSecurityQuestions.getQuestion1());

		AccountPreference accountPreference2 = new AccountPreference();
		accountPreference2
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_2);
		accountPreference2.setValue(updateSecurityQuestions.getQuestion2());

		AccountPreference accountPreference3 = new AccountPreference();
		accountPreference3
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_3);
		accountPreference3.setValue(updateSecurityQuestions.getQuestion3());

		AccountPreference accountPreference4 = new AccountPreference();
		accountPreference4
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_1);
		accountPreference4.setValue(updateSecurityQuestions.getAnswer1());

		AccountPreference accountPreference5 = new AccountPreference();
		accountPreference5
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_2);
		accountPreference5.setValue(updateSecurityQuestions.getAnswer2());

		AccountPreference accountPreference6 = new AccountPreference();
		accountPreference6
				.setType(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_3);
		accountPreference6.setValue(updateSecurityQuestions.getAnswer3());

		arrayOfAccountPreference.getAccountPreference().add(accountPreference1);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference2);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference3);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference4);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference5);
		arrayOfAccountPreference.getAccountPreference().add(accountPreference6);

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
			UpdatePreferencesResponse updatePreferencesResponse = accountBusinessDelegate
					.updatePasswordReminder(arrayOfAccountPreference,
							eRefillSession);
			myAccountJSONResponse = createUpdatePreferencesJSONResponse(
					updatePreferencesResponse, "security", true);

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
	 * revokeConsent
	 * 
	 * @param locale
	 * @param result
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/consent/revoke")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void revokeConsent(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "revokeConsent";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext= request.getContextPath();
		// Enable cross domain calls
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String reasonKey = request.getParameter("radio1");

		try {
			accountBusinessDelegate.revokeConsent(eRefillSession, reasonKey);
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
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_MINOR_USER)){
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eMinorUser";
					response.sendRedirect(redirect);
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			try {
				loginBusinessDelegate.logOut(null, request, response);
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error(methodName + " IOException: " + e);
			}
		}
		finally{
			String redirect = appContext + "/"+locale+ "/user/logout" ;
			try {
				response.sendRedirect(redirect);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		
	}

	/**
	 * closeAccount
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/account/close")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void closeAccount(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "closeAccount";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		// Enable cross domain calls
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		try {
			accountBusinessDelegate.closeAccount(eRefillSession);
		} catch (Exception e) {
			try {
				loginBusinessDelegate.logOut(null, request, response);
				String redirect = appContext+ "/home/" + locale	+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error(methodName + " IOException: " + e);
			}
		}	finally{
			String redirect = appContext + "/"+locale+ "/user/logout" ;
			try {
				response.sendRedirect(redirect);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * getPatientTaxReceiptReport
	 * 
	 * @param locale
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/taxreceipt/report")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void getPatientTaxReceiptReport(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "getPatientTaxReceiptReport";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		JSONObject errorJson = new JSONObject();
		JSONObject expired = new JSONObject();
		String appContext = request.getContextPath();
		// Set the locale
		Locale localeObj = setLocale(locale);

		// Enable cross domain calls
		
		String taxDates = request
				.getParameter(ERefillConstants.REQ_PARAM_TAX_DATES);
		String fromDate = request
				.getParameter(ERefillConstants.REQ_PARAM_FROM_DATE);
		String toDate = request
				.getParameter(ERefillConstants.REQ_PARAM_TO_DATE);
		String excludeMedication = request
				.getParameter(ERefillConstants.REQ_PARAM_EXCLUDE_MEDICATION);

		if (StringUtils.isNotBlank(taxDates)
				&& !taxDates.equalsIgnoreCase("specified-range")) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = new GregorianCalendar(Calendar.getInstance()
					.get(Calendar.YEAR), 0, 1);
			fromDate = sdf.format(calendar.getTime());
			Calendar today = Calendar.getInstance();
			Calendar april = new GregorianCalendar(Calendar.getInstance().get(
					Calendar.YEAR), 3, 30);
			calendar = new GregorianCalendar(Calendar.getInstance().get(
					Calendar.YEAR), 11, 31);
			if (today.after(april)) {
				today.add(Calendar.DATE, -1);
				toDate = sdf.format(today.getTime());
			} else {
				Calendar fromCalendar = new GregorianCalendar(Calendar
						.getInstance().get(Calendar.YEAR) - 1, 0, 1);
				fromDate = sdf.format(fromCalendar.getTime());
				Calendar toCalendar = new GregorianCalendar(Calendar
						.getInstance().get(Calendar.YEAR) - 1, 11, 31);
				toDate = sdf.format(toCalendar.getTime());
			}
		}

		TaxReceiptReportRequest taxReceiptReportRequest = new TaxReceiptReportRequest();
		taxReceiptReportRequest.setLocale(localeObj);
		taxReceiptReportRequest.setStartDate(fromDate);
		taxReceiptReportRequest.setEndDate(toDate);
		taxReceiptReportRequest.setPatientOID("");
		if (StringUtils.isNotBlank(excludeMedication)) {
			taxReceiptReportRequest.setExcludeMedication(Boolean.FALSE);
		} else {
			taxReceiptReportRequest.setExcludeMedication(Boolean.TRUE);
		}

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		OutputStream outStream = null;
		FileInputStream inStream = null;
		try {
			errorJson.append("status", "exception");
			String url = CommonUtils.prepareURL(appContext, "/myaccount/details", locale,
					"error=" + ERefillConstants.STATUS_SERVICE_ERROR);
			errorJson.append("path", url);
		} catch (JSONException e2) {
		}
		try {
			TaxReceiptReportResponse taxReceiptReportResponse = accountBusinessDelegate
					.getPatientTaxReceiptReport(taxReceiptReportRequest,
							eRefillSession);

			String fileName = "taxReport"+Math.random()+".pdf";
			expired.append("pdf", "expired");
		
			if (taxReceiptReportResponse != null)
					/*&& StringUtils.isNotBlank(taxReceiptReportResponse
							.getFilePath()))*/ {
			/*	response.setContentType("application/pdf");
				File downloadFile = new File(
						taxReceiptReportResponse.getFilePath());
				inStream = new FileInputStream(downloadFile);
				response.setHeader("Content-disposition",
						"attachment; filename=\"" + downloadFile.getName()
								+ "\"");
				response.setContentLength((int) downloadFile.length());
				outStream = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				try {
					File file = new File(taxReceiptReportResponse.getFilePath());
					file.delete();
				} catch (Exception e) {
					logger.info("File cannot be deleted:: " + e);
				}

				inStream.close();
				outStream.close();
				
*/			
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename="+ fileName);
				response.setContentLength( taxReceiptReportResponse.getContent().length);
				
				OutputStream os = response.getOutputStream();
				os.write( taxReceiptReportResponse.getContent());
				os.flush();
				os.close();
			
			} else {
				String url = CommonUtils.prepareURL("/myaccount/details",
						locale, "error="
								+ ERefillConstants.STATUS_SERVICE_ERROR);
				errorJson.append("path", url);
				response.setContentType("text/html");
				response.getWriter().write(errorJson.toString());
			}
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Business exception: " + e);
			response.setContentType("text/html");
			try {
				errorJson.append("status","error");
				response.getWriter().write(errorJson.toString());
			} catch (Exception e1) {
				logger.error(methodName + " Exception: " + e1);
			}
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Application Exception: " + e);
			try {
				errorJson.append("status","error");
				response.getWriter().write(errorJson.toString());
			} catch (Exception e1) {
				logger.error(methodName + " Exception: " + e1);
			}
		} catch (Exception e) {
			try {
				loginBusinessDelegate.logOut(null, request, response);
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error(methodName + " IOException: " + e1);
			}
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception: " + e);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}

	/**
	 * getRevokeConsentView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/consent/revoke/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRevokeConsentView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getRevokeConsentView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlayRevokeConsent");
	}

	/**
	 * getCloseAccountView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/account/close/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getCloseAccountView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getCloseAccountView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlayCloseAccount");
	}

	/**
	 * getTermsOfUse
	 * 
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/termsofuse")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getTermsOfUse(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "getTermsOfUse";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		// Enable cross domain calls
		

		DataCarrier dto = new DataCarrier();
		ERefillSession erefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		ConsentVO consent = managedAccountDelegate.getConsent(dto,
				erefillSession);

		String agreeClause = locale.equals("en_CA") ? consent
				.getAgreementEnglish() : consent.getAgreementFrench();
		model.addAttribute("agreeClause", agreeClause);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlayTermsofUse");
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
}
