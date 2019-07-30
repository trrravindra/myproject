package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.IAccountBusinessDelegate;
import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.IManagedAccountDelegate;
import com.lcl.erefill.core.business.IRegistrationBusinessDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AddAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePasswordReminderResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.generated.telus.session.rxassystlib.EConfirmEmailReturnCode;

@Controller
@RequestMapping("/{locale}/registration")
/**
 * @author vsha51
 */
public class RegistrationController {
	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	@Autowired
	SessionManager sessionManager;

	@Autowired
	IRegistrationBusinessDelegate registrationBusinessDelegate;

	@Autowired
	IManagedAccountDelegate managedAccountDelegate;

	@Autowired
	IAccountBusinessDelegate accountBusinessDelegate;
	
	@Autowired
	ILoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	private ReloadableResourceBundleMessageSource resourceBundleMessageSource;

	/**
	 * validateIdentityView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/identity/validate/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateIdentityView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "validateIdentityView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		

		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		String error = request.getParameter("error");

		model.addAttribute("currentYear", currentYear);
		model.addAttribute("mismatch", "mismatch");
		model.addAttribute("eAccountLocked", "eAccountLocked");
		model.addAttribute("error", error);
		model.addAttribute("registrationStep", "verifyIdentity");
		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("verifyIdentity");
	}

	/**
	 * validateIdentity
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/identity/validate")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateIdentity(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		final String methodName = "validateIdentity";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);

		

		String year = request.getParameter(ERefillConstants.REQ_PARAM_YEAR);
		String month = request.getParameter(ERefillConstants.REQ_PARAM_MONTH);
		String day = request.getParameter(ERefillConstants.REQ_PARAM_DAY);

		DataCarrier dto = new DataCarrier();
		try {
			dto.addObject(ERefillConstants.REQ_PARAM_MONTH, month);
			dto.addObject(ERefillConstants.REQ_PARAM_DAY, day);
			dto.addObject(ERefillConstants.REQ_PARAM_YEAR, year);

			ERefillSession eRefillSession = (ERefillSession) request
					.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

			UpdatePreferencesResponse updatePreferencesResponse = registrationBusinessDelegate
					.verifyIdentity(dto, eRefillSession);

			model.addAttribute("currentYear", currentYear);
			model.addAttribute("mismatch", "mismatch");
			model.addAttribute("eAccountLocked", "eAccountLocked");
			model.addAttribute("registrationStep", "verifyIdentity");
			model.addAttribute("locale", locale);

			if (updatePreferencesResponse.getResponseStatus().equals(
					"eAccountLocked")) {
				model.addAttribute("error", "eAccountLocked");
			} else {
				if (Boolean.parseBoolean(updatePreferencesResponse.getResponseStatus())) {
					String redirect = appContext + "/" + locale	+ "/registration/termsofuse/view";
					model.addAttribute("registrationStep", "termsofuse-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/termsofuse/view");
					response.sendRedirect(redirect);
					
				} else {
					model.addAttribute("error", "mismatch");
				}
			}
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
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
			
		}catch (Exception e) {
			logger.error(methodName + " Error" + e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}

		return new ModelAndView("verifyIdentity");
	}

	/**
	 * termsOfUseView
	 * @param model 
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/termsofuse/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView termsOfUseView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		final String methodName = "termsOfUseView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
			DataCarrier dto = new DataCarrier();
			dto.addObject(ERefillConstants.CONSENT_TYPE, ERefillConstants.CONSENT_TYPE_ENROLLMENT);
			ConsentVO consentVO = managedAccountDelegate.getConsent(dto,
					eRefillSession);

			if (consentVO != null) {
				String agreeClause = locale.equals("en_CA") ? consentVO
						.getAgreementEnglish() : consentVO.getAgreementFrench();
				model.addAttribute("agreeClause", agreeClause);
				model.addAttribute("consentId", consentVO.getId());
			}
			model.addAttribute("registrationStep", "termsofuse");
			model.addAttribute("locale", locale);

		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(methodName + " Error6: " + e);
			throw e;				
		}catch (Exception e) {
			logger.debug(methodName + " Error " + e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("termsOfUse");
	}

	/**
	 * subsrcibeTerms
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/termsofuse/subscribe")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView subsrcibeTerms(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		final String methodName = "subsrcibeTerms";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		String consentString = request
				.getParameter(ERefillConstants.REQ_PARAM_CONSENTID);
		int consentId = (CommonUtils.isNullOrBlank(consentString)) ? 0
				: Integer.parseInt(consentString);

		String nextPage = "termsOfUse";
		try {
			UserToken userToken = registrationBusinessDelegate.subscribe(
					consentId, eRefillSession);

			if (null != userToken) {
				
				if(userToken.getStatus().equalsIgnoreCase(ERefillConstants.STATUS_SUCCESS)){
					String redirect = appContext+ "/" + locale+ "/user/reconsentLogin";
					model.addAttribute("reConsentStep", "reconsentLogin");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/user/reconsentLogin");
					model.addAttribute("isExistingUser",true);
					response.sendRedirect(redirect);
				}
				else{
				String redirect = appContext+ "/" + locale+ "/registration/accountpref/view";	
				model.addAttribute("registrationStep", "accountpref-view");
				model.addAttribute("isRedirect", true);
				model.addAttribute("redirectURL", "/registration/accountpref/view");
				response.sendRedirect(redirect);
				}
			} else {
				loginBusinessDelegate.logOut(eRefillSession, request, response);
				try {
					String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e) {
			logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}

	/**
	 * privacyPolicyView : Privacy overlay on termsOfUse privacy clause
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/privacypolicy/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView privacyPolicyView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "privacyPolicyView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String nextPage = "overlay-privacy-policy";
		String appContext = request.getContextPath();
		try {
			model.addAttribute("registrationStep", "termsofuse");
			model.addAttribute("locale", locale);
		} catch (Exception e) {
			logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext +"/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	
	
	/**
	 * Below view is for normal Registration flow: show both password and security question in one page
	 * + accountPreferencesView : for caregiver - eMustChangePassword
	 * for normal user - eMustChangePassword - go to - /user/accountpref/view
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/accountpref/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView accountPreferencesView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "accountPreferencesView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRole = sessionManager.getUserRole(eRefillSession);
		model.addAttribute("registrationStep", "accountpref");
		String nextPage = "accountPreferences";
		String caregiverNextPage= "caregiverAccountPreferences";
		getQuestionMap(locale, request, response, model);
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		if(userRole!=null && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
			model.addAttribute("nextPage", caregiverNextPage);
			return new ModelAndView(caregiverNextPage);
		}else{
			model.addAttribute("nextPage", nextPage);
			return new ModelAndView(nextPage);
		}
	}
	
	/**
	 * updateAccountPreferences
	 * 
	 * Below method is for normal Reg flow: update both password and security question in one go.
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/accountpref/update")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView updateAccountPreferences(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "updateAccountPreferences";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		String newPwd = request.getParameter(ERefillConstants.NEWPASSWORD);
						
		String nextPage = "accountInfo";
		model.addAttribute("registrationStep", "accountpref");
		model.addAttribute("locale", locale);
		try{
			ChangeMyAccountPasswordResponse changePasswordResponse = registrationBusinessDelegate.changeRegistrationPassword(newPwd, "changePassword",eRefillSession);
	
			
			if((changePasswordResponse != null && ERefillConstants.STATUS_EMUST_GIVE_PASSWORD_REMINDER.equalsIgnoreCase(changePasswordResponse.getChangePasswordStatus())) || 
					(StringUtils.isNotEmpty(newPwd) && "hidden".equals(newPwd)) || 
					(changePasswordResponse != null && ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(changePasswordResponse.getChangePasswordStatus()) 
					&& !ERefillConstants.STATUS_INVALID_USER_PASSWORD.equalsIgnoreCase(changePasswordResponse.getChangePasswordStatus()))){
							
				UpdatePasswordReminderResponse updatePasswordReminderResponse = updateSecurityQuestions(locale, request, response, appContext,
						eRefillSession);
			
				if(ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(updatePasswordReminderResponse.getUpdateResponse())){
					String redirect = appContext + "/" + locale + "/registration/accountinfo/view";
					model.addAttribute("registrationStep", "accountinfo-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/accountpref/view");					
					sessionManager.setPassword(newPwd, eRefillSession);
					response.sendRedirect(redirect);
				}
			}						
			if (ERefillConstants.STATUS_INVALID_USER_PASSWORD.equals(changePasswordResponse.getChangePasswordStatus())) {
				model.addAttribute("error", "pwdError");
				model.addAttribute("registrationStep", "accountpref");
				getQuestionMap(locale, request, response, model);
				nextPage = "accountPreferences";
				
			} else {
				nextPage = "error";
				model.addAttribute("error", "error");
			}
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e){
			logger.error(methodName + " Exception: ", e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	/**
	 * userAccountPreferencesView
	 * 
	 * for normal user|eMustChangePassword | Show only Security Questions | Password covered from the reset password jsp
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/user/accountpref/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView userAccountPreferencesView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "accountPreferencesView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		model.addAttribute("registrationStep", "accountpref");
		String nextPage = "userAccountPreferences";
		model.addAttribute("nextPage", "userAccountPreferences");
		getQuestionMap(locale, request, response, model);
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	
	/**
	 * userAccountPreferenceUpdate
	 * 
	 * for normal user|eMustChangePassword | Validate Only Security Questions
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method={RequestMethod.POST}, value="/user/accountpref/update")
	@ResponseBody
	@ResponseStatus(value= HttpStatus.OK)
	public ModelAndView userAccountPreferenceUpdate(@PathVariable String locale, ModelMap model, 
			HttpServletRequest request, HttpServletResponse response){
		final String methodName = "updateAccountPreferences";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
	
		response.setHeader("Access-Control-Allow-Origin", "*");
		String nextPage="accountInfo";
		String appContext = request.getContextPath();
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		UpdatePasswordReminderResponse updatePasswordReminderResponse = updateSecurityQuestions(locale, request, response, appContext,
				eRefillSession);
		if(ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(updatePasswordReminderResponse.getUpdateResponse())){
			String redirect = appContext + "/" + locale + "/registration/accountinfo/view";
			model.addAttribute("status", "success");
			model.addAttribute("registrationStep", "accountinfo-view");
			model.addAttribute("isRedirect", true);
			model.addAttribute("redirectURL", "/registration/accountinfo/view");			
			try {
				response.sendRedirect(redirect);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		return new ModelAndView(nextPage);
	}
	
	/**
	 * caregiverAccountPreferenceUpdate
	 * 
	 * to check 
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method={RequestMethod.POST}, value="/caregiver/accountpref/update")
	@ResponseBody
	@ResponseStatus(value= HttpStatus.OK)
	public ModelAndView caregiverAccountPreferenceUpdate(@PathVariable String locale, ModelMap model, 
			HttpServletRequest request, HttpServletResponse response){
		final String methodName = "updateAccountPreferences";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String nextPage="success";
		String appContext = request.getContextPath();
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		UpdatePasswordReminderResponse updatePasswordReminderResponse = updateSecurityQuestions(locale, request, response, appContext,
				eRefillSession);
		if(ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(updatePasswordReminderResponse.getUpdateResponse())){
			nextPage="success";
		}else{
			nextPage="error";
		}
		return new ModelAndView(nextPage);
	}

	

	/**
	 * accountInfoView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/accountinfo/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView accountInfoView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "accountInfoView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		String nextPage = "accountInfo";
		try {
			model.addAttribute("registrationStep", "accountinfo");
			model.addAttribute("locale", locale);
			model.addAttribute("username", "");
			model.addAttribute("email", "");
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e) {
			logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}

	/**
	 * updateAccountInfo
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/accountinfo/update")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView updateAccountInfo(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "updateAccountInfo";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
	
		String alias = request.getParameter(ERefillConstants.USERNAME);
		String email = request.getParameter(ERefillConstants.EMAIL);

		String nextPage = "success";
		model.addAttribute("registrationStep", "success");
		model.addAttribute("locale", locale);
		model.addAttribute("username", alias);
		model.addAttribute("email", email);
		
		try{
			
			AddAccountAliasResponse addAliasStatusReponse = registrationBusinessDelegate.addAccountAlias(alias, eRefillSession);
			UpdatePreferencesResponse updateAccountPreferences=null;
			
			if(addAliasStatusReponse != null && ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(addAliasStatusReponse.getRegUserStatus())){
				if(StringUtils.isNotEmpty(email)){
					updateAccountPreferences=registrationBusinessDelegate.updateAccountPreferences(null, null, email, alias, eRefillSession);
				}
				if(null!= updateAccountPreferences){
					if (ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(updateAccountPreferences.getResponseStatus())) {
						logger.info("New user registered to the system with username: "+alias+":email: "+email);
						sessionManager.setUserName(alias, eRefillSession);
						sessionManager.setEmail(email, eRefillSession);
						String redirect = appContext + "/" + locale + "/registration/success/view";
						model.addAttribute("registrationStep", "success");
						model.addAttribute("isRedirect", true);
						model.addAttribute("redirectURL", "/registration/success/view");
						response.sendRedirect(redirect);
						
				}else if(ERefillConstants.STATUS_INVALID_ARGUMENTS.equals(updateAccountPreferences.getResponseStatus())){
						model.addAttribute("error", "dupUser");
						model.addAttribute("username", alias);
						model.addAttribute("email", email);
						model.addAttribute("registrationStep", "accountinfo");
						nextPage = "accountInfo";	
					}
				}
				else{				
					logger.info("New user registered to the system without emailId: "+alias);
					String redirect = appContext + "/" + locale + "/registration/success/view";
					model.addAttribute("registrationStep", "success");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/success/view");
					sessionManager.setUserName(alias, eRefillSession);
					response.sendRedirect(redirect);
					
				}
				
			}else if(addAliasStatusReponse != null && ERefillConstants.STATUS_INVALID_ARGUMENTS.equals(addAliasStatusReponse.getRegUserStatus())){
				model.addAttribute("error", "dupUser");
				model.addAttribute("username", alias);
				model.addAttribute("email", email);
				model.addAttribute("registrationStep", "accountinfo");
				nextPage = "accountInfo";	
			}
			
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e){
			logger.error(methodName + " Exception: ", e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	
	
	/**
	 * successView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/success/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView successView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "successView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		String email = sessionManager.getEmail(eRefillSession);
		String successEmailText = "";
		if(StringUtils.isNotBlank(email)){
			// Set the locale
			Locale localeObj = setLocale(locale);
			String successEmailTextKey = "registration.success.email.text";
			successEmailText = resourceBundleMessageSource.getMessage(successEmailTextKey, null, localeObj);
			successEmailText = successEmailText.replace(ERefillConstants.EMAIL_PLACEHOLDER, email  );
		}
		
		String nextPage = "success";
		try {
			model.addAttribute("registrationStep", "success");
			model.addAttribute("locale", locale);
			model.addAttribute("successEmailText", successEmailText);
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e) {
			logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	
	/**
	 * confirmEmail
	 * 
	 * @param locale
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = {"/confirmemail/{id}","/confirmmobileemail/{id}"})
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView confirmEmail(@PathVariable String locale,
			@PathVariable String id,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "confirmEmail";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String nextPage = "emailconfirmation";
		model.addAttribute("strStatus", "emailConfirmed");
		String code = null;
		
		try {
			code = registrationBusinessDelegate.confirmEmail(id, eRefillSession);
			
			if (EConfirmEmailReturnCode.INVALIDKEY.value().equalsIgnoreCase(code) || "eInvalidArguments".equalsIgnoreCase(code)) {
				model.addAttribute("strStatus", "invalidkey");
			} else if (EConfirmEmailReturnCode.CANCELLED.value().equals(code)) {
				model.addAttribute("strStatus", "cancelled");
			} else if (EConfirmEmailReturnCode.ALREADY_CONFIRMED.value().equalsIgnoreCase(code)){
				model.addAttribute("strStatus", "AlreadyConfirmed");
			}
			model.addAttribute("locale", locale);
			
		}catch (ERefillBusinessException e){ 
			logger.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
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
			
		}catch (Exception e) {
			logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(nextPage);
	}
	
	
	
	private UpdatePasswordReminderResponse updateSecurityQuestions(String locale,
			HttpServletRequest request, HttpServletResponse response,
			String appContext, ERefillSession eRefillSession) {
		
		UpdatePasswordReminderResponse updatePasswordReminderResponse = null;
		
		List<String> eAnswers = new ArrayList<String>();
		List<String> eQuestions = new ArrayList<String>();
		eQuestions.add(request.getParameter(ERefillConstants.QUESTION1));
		eQuestions.add(request.getParameter(ERefillConstants.QUESTION2));
		eQuestions.add(request.getParameter(ERefillConstants.QUESTION3));
		eAnswers.add(request.getParameter(ERefillConstants.ANSWER1));
		eAnswers.add(request.getParameter(ERefillConstants.ANSWER2));
		eAnswers.add(request.getParameter(ERefillConstants.ANSWER3));
		
		try{
			updatePasswordReminderResponse = registrationBusinessDelegate.updatePasswordReminder(eQuestions, eAnswers, null, eRefillSession);
			if(updatePasswordReminderResponse.getUserToken()==null){
				throw new Exception("User Token Expired");
			}
		}catch (ERefillBusinessException e){ 
			logger.error(" Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(" Error6: " + e);
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
			
		}catch (Exception e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext + "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}
		return updatePasswordReminderResponse;
	}
	
	private HashMap<String, String> getQuestionMap(String locale, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		HashMap<String, String> questionMap = new HashMap<String, String>();
		// Set the locale
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String appContext = request.getContextPath();
		Locale localeObj = setLocale(locale);
		String secQuestionsKey = "my.account.security.questions";
		String secQuestions = resourceBundleMessageSource.getMessage(secQuestionsKey, null, localeObj);
		
		try {
			List<String> securityQuestions = 
					accountBusinessDelegate.getListSecurityQuestions(secQuestions);
			Map<String, String> questionsMap = new HashMap<String, String>();
			int count = 1;
		    for (String que : securityQuestions) {
		    	String key = secQuestionsKey + "." + count;
		    	questionsMap.put(CommonUtils.formatStringInUTF8(key), que);
		    	count++;
		    }
		    
			
			model.addAttribute("locale", locale);
			model.addAttribute("questionsMap", questionsMap);
			
		}catch (ERefillBusinessException e){ 
			logger.error(" Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(" Error6: " + e);
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
			
		}catch (Exception e) {
			e.printStackTrace();
			//logger.debug(methodName + " Error " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("Exception while redirecting: ", e1);
			}
		}
		return questionMap;
	}
	
	
	
	
	/**
	 * setLocale
	 * 
	 * @param loc
	 * @return locale
	 */
	private Locale setLocale(String loc) {
		Locale locale = new Locale("en", "CA");
		if (loc != null && "fr_CA".equalsIgnoreCase(loc)) {
			locale = new Locale("fr", "CA");
		}
		return locale;
	}
}
