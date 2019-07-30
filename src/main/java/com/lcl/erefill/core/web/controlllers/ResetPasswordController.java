package com.lcl.erefill.core.web.controlllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import com.lcl.erefill.core.business.IRegistrationBusinessDelegate;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.ValidateUserResponse;
import com.lcl.erefill.core.connection.ErefillRecaptchaLoader;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ChangePassword;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;
import com.lcl.erefill.core.vo.ValidateUserRequest;
import com.lcl.erefill.core.web.validators.ChangePasswordRequestValidator;
import com.lcl.erefill.core.web.validators.SecurityAnswerRequestValidator;
import com.lcl.erefill.core.utils.HttpClientLoblaw;

@Controller
@RequestMapping("/{locale}/resetpassword")
/**
 * @author srao8
 */
public class ResetPasswordController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResetPasswordController.class);
	
	private String recaptchaSecretKey= PropertyUtil.getRecaptchaSecretKey();
	private String noCaptchaPrivateKey= PropertyUtil.getRecaptchav2PrivateKey();
	private String SITE_VERIFY_URL= PropertyUtil.getRecaptchav2Url();
	private boolean isLclProxyEnabled= PropertyUtil.getIsProxyEnabled();
	private String proxyHost= PropertyUtil.getProxyHost();
	private String proxyPort= PropertyUtil.getProxyPort();
	private String lclProxyUser= PropertyUtil.getProxyUserName();
	private String proxyPass= PropertyUtil.getProxyUserPassword();
	//private ErefillRecaptchaLoader httpLoader = ErefillRecaptchaLoader.getInstance();
	
	@Autowired
	ErefillRecaptchaLoader httpLoader;
	
	@Autowired
	IAccountBusinessDelegate accountBusinessDelegate;
	
	@Autowired
	IRegistrationBusinessDelegate registrationBusinessDelegate;

	@Autowired
	private ReloadableResourceBundleMessageSource resourceBundleMessageSource;

	@Autowired
	private ChangePasswordRequestValidator changePasswordRequestValidator;

	@Autowired
	private SecurityAnswerRequestValidator securityAnswerRequestValidator;

	@Autowired
	SessionManager sessionManager;

	@InitBinder("validateSecurityAnswerRequest")
	protected void initSecAnsReqBinder(WebDataBinder binder) {
		binder.setValidator(securityAnswerRequestValidator);
	}

	@InitBinder("resetPasswordRequest")
	protected void initResetPwdBinder(WebDataBinder binder) {
		binder.setValidator(changePasswordRequestValidator);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/validateuser")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateUser(@PathVariable String locale, @ModelAttribute("validateUserRequest") ValidateUserRequest validateUserRequest,
			ModelMap modelmap, Model model, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Values  from Property file>>>>>>>"+noCaptchaPrivateKey +"<<<<<<>>>>>>>>>"+SITE_VERIFY_URL);
		ERefillSession erefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		final String methodName = "[validateUser] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		Locale localeObj = new Locale("en", "CA");
		if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}
		
		String userName = sessionManager.getUserName(erefillSession);
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_RESETPWD);
		model.addAttribute("loader", httpLoader);
		if (StringUtils.isNotBlank(validateUserRequest.getUsername()) || StringUtils.isNotBlank(userName)) {
			ModelAndView modelAndView = null;
			if(StringUtils.isNotBlank(validateUserRequest.getUsername())){
				boolean isCaptchaValid = false;
				String gCaptchachallenge = request.getParameter("g-recaptcha-response");
				LOGGER.debug("gRecaptchaResponse in validateuser >>>>>>>"+gCaptchachallenge);
				isCaptchaValid = callGoogleReCaptchaService(gCaptchachallenge);
				
				if ( isCaptchaValid ) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Captcha is valid");
					}
					modelAndView =	userValidationAndQuestionMap(request, response, model, erefillSession, validateUserRequest.getUsername(), localeObj, locale);
					} else {
					LOGGER.error(resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
					model.addAttribute("captchaErrorMessage", "Invalid Captcha");
					return new ModelAndView("resetPwdUserValidation");
				}
			}else{
				modelAndView =	userValidationAndQuestionMap(request, response, model, erefillSession, userName, localeObj, locale);
			}
			return modelAndView;
			
			
		} else {
			return new ModelAndView("resetPwdUserValidation");

		}
}

	private ReCaptchaImpl initializeRecaptcha(HttpServletRequest request) {
		
		ReCaptchaImpl reCaptcha = null;
		if( PropertyUtil.getIsRecaptchaEnabled() ) {
			reCaptcha = new ReCaptchaImpl();			
			reCaptcha.setHttpLoader(httpLoader);						
			reCaptcha.setPrivateKey( recaptchaSecretKey);			
		}	
		return reCaptcha;
	}
	
	private ModelAndView userValidationAndQuestionMap(HttpServletRequest request, HttpServletResponse response, Model model, ERefillSession erefillSession,
			String userName, Locale localeObj, String locale){
		try {
			ValidateUserResponse validateUserResponse = accountBusinessDelegate.validateUser(userName);
			if (ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(validateUserResponse.getStatus())) {
				
				sessionManager.setUserName(userName, erefillSession);
				
				String separator = "";
				//retrieving the value of question key for a user stored during account creation.
				List<String> questions = validateUserResponse.getPasswordReminder().getQuestions();
				if(!questions.isEmpty()){
					String questionSeparatorString = questions.get(0);
					if(questionSeparatorString.contains(":")){
						separator=":";
					}else{
						separator=".";
					}
				}
				Random random = new Random();
				int choice = random.nextInt(3);
				String question = questions.get(choice);
				String questionValue=null;
				
				HashMap<String, String> questionMap = getSecurityQuestionsMap(localeObj, separator);
				if(questionMap.containsKey(question)){
					questionValue=questionMap.get(question);
				}
				
				request.setAttribute("userProvidedQuestions", questions.toArray());
				model.addAttribute("userProvidedQuestions", questions);
				model.addAttribute("securityQuestion", questionValue);
				model.addAttribute("choice", choice);
				model.addAttribute("userName", userName);
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				return new ModelAndView("resetPwdAnswerValidation");

			} else if (ERefillConstants.STATUS_INVALID_ARGUMENTS.equalsIgnoreCase(validateUserResponse.getStatus())) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("User {} is a invalid user " + userName);
				}
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.username.errmsg", null, localeObj));
				return new ModelAndView("resetPwdUserValidation");
			} else {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("User {} do not have a valid email " + userName);
				}
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				model.addAttribute("userName", userName);
				model.addAttribute("status", "invalidEmail");
				return new ModelAndView("resetPwdStatus");

			}

		}catch (ERefillBusinessException e) {
			LOGGER.error(" Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(" Error6: " + e);
			throw e;					
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			return new ModelAndView("resetPwdUserValidation");
		}
	}
	private HashMap<String, String> getSecurityQuestionsMap(Locale localeObj, String separator) {
	
		// creating a hash map of questions to display the question instead of keys 
		String secQuestionsKey = "my.account.security.questions";
		
		//getting the question from property file
		String secQuestions = resourceBundleMessageSource.getMessage(
				secQuestionsKey, null, localeObj);
		
		//creating the list of question from, the value of question from property file
		List<String> questionsRepo = new ArrayList<String>();
		questionsRepo = accountBusinessDelegate
					.getListSecurityQuestions(secQuestions);
		
		//creating map of questions.
		HashMap<String, String> questionMap= new HashMap<String, String>();
		if(questionsRepo!=null && !questionsRepo.isEmpty()){
			int count=1;
			//String questionKey=secQuestionsKey+"."+count;
			for(String questionVal: questionsRepo){
				String questionKey=secQuestionsKey+separator+count;
				questionMap.put(questionKey, questionVal);
				count++;
			}	
		}
		return questionMap;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = {"/validateuser/token","/validatemobileuser/token"})
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateUserWithToken(@PathVariable String locale,
			@ModelAttribute("validateUserRequest") ValidateUserRequest validateUserRequest, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "[validateUserWithToken] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		Locale localeObj = new Locale("en", "CA");
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute("loader", httpLoader);
		if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_RESETPWD);
		String token = request.getParameter("user_token");
		if (!StringUtils.isNotBlank(token)) {
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPwdUserValidation");
		} else if (StringUtils.isNotBlank(token) && !StringUtils.isNotBlank(validateUserRequest.getUsername())) {
			request.setAttribute("user_token", token);
			//model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.username.errmsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPwdUserValidation");
		} else {
			
			try {
			
				boolean isCaptchaValid = false;
				/*ReCaptcha reCaptcha = initializeRecaptcha(request);
				ReCaptchaResponse reCaptchaResponse = null;
				String remoteAddr = request.getRemoteAddr();
				String challenge = request.getParameter("recaptcha_challenge_field");
				String uresponse = request.getParameter("recaptcha_response_field");
				if( reCaptcha!=null ) {
					reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
					isCaptchaValid = reCaptchaResponse.isValid();
				} else {
					// recaptcha is not enabled and so setting to true;
					isCaptchaValid = true;
				}*/
				
				String gCaptchachallenge = request.getParameter("g-recaptcha-response");
				LOGGER.debug("gRecaptchaResponse in validateuser-token >>>>>>>"+gCaptchachallenge);
				isCaptchaValid = callGoogleReCaptchaService(gCaptchachallenge);
				if (isCaptchaValid) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Captcha is valid");
					}
				UserToken userToken = new UserToken(StringUtils.EMPTY, CommonUtils.encodeURL(token));
				sessionManager.setToken(userToken, eRefillSession);
				ValidateUserResponse validateUserResponse = accountBusinessDelegate.validateUser(eRefillSession,StringUtils.trimToEmpty(validateUserRequest.getUsername()));
				sessionManager.setUserName(StringUtils.trimToEmpty(validateUserRequest.getUsername()), eRefillSession);
				if (ERefillConstants.STATUS_EMUST_CHANGE_PASSWORD.equalsIgnoreCase(validateUserResponse.getStatus())) {
					LOGGER.debug("User {} have a valid email " + validateUserRequest.getUsername());
					model.addAttribute("userName", validateUserRequest.getUsername());
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPassword");

				} else if (ERefillConstants.STATUS_ACCOUNT_LOCKED.equals(validateUserResponse.getStatus())) {
					request.setAttribute("user_token", validateUserResponse.getToken());
					model.addAttribute("error", resourceBundleMessageSource.getMessage("account.locked.user.errmsg", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdUserValidation");

				} else if (ERefillConstants.STATUS_INVALID_USER_PASSWORD.equals(validateUserResponse.getStatus())){
					request.setAttribute("user_token", validateUserResponse.getToken());
					model.addAttribute("error", resourceBundleMessageSource.getMessage("registration.confirm.email.invalid.message", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdUserValidation");
				}else {
					request.setAttribute("user_token", validateUserResponse.getToken());
					model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.username.errmsg", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdUserValidation");
				}}else {
					LOGGER.error(resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
					model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdUserValidation");
				}

			} catch (ERefillBusinessException e) {
				LOGGER.error(" Error1: " + e);
				throw e;
			} catch (ERefillApplicationException e){
				LOGGER.error(" Error6: " + e);
				throw e;					
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				request.setAttribute("user_token", token);
				model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				return new ModelAndView("resetPwdUserValidation");
			}
		}

	}

	@RequestMapping(method = { RequestMethod.POST}, value = "/validatesecanswer")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateSecurityAnswer(@PathVariable String locale,
			@ModelAttribute("validateSecurityAnswerRequest") @Validated ValidateSecurityAnswerRequest validateSecAnswerRequest, ModelMap model,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "[validateSecurityAnswer] ";
		model.addAttribute("loader", httpLoader);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		Locale localeObj = new Locale("en", "CA");
		if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}

		if (result.hasErrors()) {

			Iterator<ObjectError> errorItr = result.getAllErrors().iterator();
			StringBuilder errMsg = new StringBuilder();
			while (errorItr.hasNext()) {
				ObjectError error = errorItr.next();
				errMsg.append(resourceBundleMessageSource.getMessage(error.getCode(), null, localeObj));
			}
			model.addAttribute("error", errMsg.toString());
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPwdAnswerValidation");
		}
		try {
			boolean isCaptchaValid = false;
		/*	ReCaptcha reCaptcha = initializeRecaptcha(request);
			ReCaptchaResponse reCaptchaResponse = null;
			String remoteAddr = request.getRemoteAddr();
			String challenge = request.getParameter("recaptcha_challenge_field");
			String uresponse = request.getParameter("recaptcha_response_field");
			if( reCaptcha!=null ) {
				reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
				isCaptchaValid = reCaptchaResponse.isValid();
			} else {
				// recaptcha is not enabled and so setting to true;
				isCaptchaValid = true;
			}*/
			String gCaptchachallenge = request.getParameter("g-recaptcha-response");
			LOGGER.debug("gRecaptchaResponse in validateuser >>>>>>>"+gCaptchachallenge);
			isCaptchaValid = callGoogleReCaptchaService(gCaptchachallenge);

			if (isCaptchaValid) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Captcha is valid");
				}
				String status = accountBusinessDelegate.validateSecurityAnswer(validateSecAnswerRequest);
				if ("valid".equalsIgnoreCase(status)) {
	
					model.addAttribute("status", "mailSent");
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdStatus");
	
				} else {
					securityQuestionAnsValidation(locale,
							validateSecAnswerRequest, model, request, localeObj, true);
					return new ModelAndView("resetPwdAnswerValidation");
				}
			}else {
				LOGGER.error(resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				securityQuestionAnsValidation(locale,
						validateSecAnswerRequest, model, request, localeObj, false);
				return new ModelAndView("resetPwdAnswerValidation");
			}

		}catch (ERefillBusinessException e) {
			LOGGER.error(" Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(" Error6: " + e);
			throw e;					
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			model.addAttribute("securityQuestion", validateSecAnswerRequest.getQuestion());
			model.addAttribute("choice", validateSecAnswerRequest.getChoice());
			model.addAttribute("userName", validateSecAnswerRequest.getUsername());
			model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPwdAnswerValidation");
		}

	}

	private void securityQuestionAnsValidation(String locale,
			ValidateSecurityAnswerRequest validateSecAnswerRequest,
			ModelMap model, HttpServletRequest request, Locale localeObj, boolean invalidAnswer) {
		model.addAttribute("loader", httpLoader);
		String separator = "";
		
		String userProvidedQuestionString=request.getParameter("userProvidedQuestions");
		String userProvidedQuestionString2=userProvidedQuestionString.substring(1, userProvidedQuestionString.length()-1);
		if(userProvidedQuestionString2.contains(":")){
			separator = ":";
		}else{
			separator = ".";
		}
		String[] userProvidedQuestionArray= userProvidedQuestionString2.split(",");
		List<String> userProvidedQuestions= new ArrayList<String>();
		for(String userProvidedQuest: userProvidedQuestionArray){
			userProvidedQuestions.add(userProvidedQuest);
		}
		Random random = new Random();
		int choice = random.nextInt(3);
		String question = userProvidedQuestions.get(choice);
		
		String questionValue=null;
		HashMap<String, String> questionMap = getSecurityQuestionsMap(localeObj, separator);
		if(questionMap.containsKey(question.trim())){
			questionValue=questionMap.get(question.trim());
		}
		
		model.addAttribute("userProvidedQuestions", userProvidedQuestions);
		model.addAttribute("securityQuestion", questionValue);
		model.addAttribute("choice", choice);
		if(invalidAnswer){
			model.addAttribute("invalidAnswer", "true");
			model.addAttribute("errormsg", resourceBundleMessageSource.getMessage("invalid.sec.answer.errmsg", null, localeObj));
		}else{
			model.addAttribute("errormsg", resourceBundleMessageSource.getMessage("invalid.captcha", null, localeObj));
		}
		model.addAttribute("userName", validateSecAnswerRequest.getUsername());
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
	}
	
	
	private boolean callGoogleReCaptchaService(String gRecaptchaResponse) {
		boolean responseValidation = false;
		LOGGER.info("Inside callGoogleReCaptchaService()");
		if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
			LOGGER.info("Captcha not entered or blank");
			return responseValidation;
		}
		else { 
			try {
			String postParams = "secret=" + noCaptchaPrivateKey + "&response=" + gRecaptchaResponse;
			LOGGER.info("Validating captcha response entered by user updated-> " + postParams );
			LOGGER.info("SITE_VERIFY_URL---> " + SITE_VERIFY_URL );
			
			 responseValidation = new HttpClientLoblaw(isLclProxyEnabled, proxyHost, Integer.parseInt(proxyPort), lclProxyUser, proxyPass).httpPostRequest(SITE_VERIFY_URL, postParams);
			
		} catch (Exception exception) {
			LOGGER.info("Inside try for callGoogleReCaptchaService() exception---->"+exception.getMessage()+"{}{}{}"+exception.getMessage()+"{}{}{}"+exception.getCause().getStackTrace().toString());
		}
			LOGGER.info("Recaptcha validation returned --> "+ responseValidation);
		return responseValidation;
	 }
	}
	
	@RequestMapping(method = { RequestMethod.GET }, value = "/validatesecanswer")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateSecurityAnswer(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		final String methodName = "[validateSecurityAnswer] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		model.addAttribute("loader", httpLoader);
		/*Locale localeObj = new Locale("en", "CA");
		if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}*/
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		
		return new ModelAndView("resetPwdUserValidation");
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/changepwd")
	public ModelAndView getResetPassword(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response){
		final String methodName = "getResetPassword";
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug(methodName + "Entering");
		}
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRole= sessionManager.getUserRole(eRefillSession);
		
		request.setAttribute(ERefillConstants.USER_ROLE, userRole);
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.USER_ROLE, userRole);
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug(methodName + "Exiting");
		}
		return new ModelAndView("resetPassword");
	}
	
	@RequestMapping(method = { RequestMethod.POST}, value = "/changepwd")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView resetPassword(@PathVariable String locale, @ModelAttribute("resetPasswordRequest") @Validated ChangePassword changePassword,
			Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "resetPassword";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		
		String appContext = request.getContextPath();
		Locale localeObj = new Locale("en", "CA");
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRole= sessionManager.getUserRole(eRefillSession);
		boolean isRoleCareGiver = false;
		boolean isStatusChecked = false;
		if(StringUtils.isNotBlank(userRole) && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
			isRoleCareGiver = true;
		}
		request.setAttribute(ERefillConstants.USER_ROLE, userRole);
		
		if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}
		if (result.hasErrors()) {
			model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.pwd.errmsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPassword");
		}

		try {
			ChangeMyAccountPasswordResponse changeMyAccountPasswordResponse = new ChangeMyAccountPasswordResponse();
			if(isRoleCareGiver){
				changeMyAccountPasswordResponse =registrationBusinessDelegate.changeRegistrationPassword(changePassword.getConfirmpassword(), null, eRefillSession);
				if (ERefillConstants.STATUS_EMUST_GIVE_PASSWORD_REMINDER.equalsIgnoreCase(changeMyAccountPasswordResponse.getChangePasswordStatus())) {
					model.addAttribute("status", "success");
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					model.addAttribute(ERefillConstants.USER_ROLE, userRole);
					request.setAttribute("user_token", changeMyAccountPasswordResponse.getUserToken());
					String redirect = appContext+"/" + locale
							+ "/registration/accountpref/view";	
					isStatusChecked=true;
					model.addAttribute("registrationStep", "user-accountpref-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/accountpref/view");
					response.sendRedirect(redirect);
				}
			}else{
				changeMyAccountPasswordResponse = accountBusinessDelegate.changeResetPassword(changePassword,
						eRefillSession);
				if (ERefillConstants.STATUS_EMUST_GIVE_PASSWORD_REMINDER.equalsIgnoreCase(changeMyAccountPasswordResponse.getChangePasswordStatus())) {
					sessionManager.setPassword(changePassword.getConfirmpassword(), eRefillSession);
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					model.addAttribute(ERefillConstants.USER_ROLE, userRole);
					String redirectPath = "/registration/user/accountpref/view";
					String redirect = appContext+"/" + locale + redirectPath;
					
					isStatusChecked=true;
					model.addAttribute("registrationStep", "user-accountpref-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", redirectPath);
					response.sendRedirect(redirect);
				}
			}
			request.setAttribute("user_token", changeMyAccountPasswordResponse.getUserToken());		
			if(!isStatusChecked){
				if (ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(changeMyAccountPasswordResponse.getChangePasswordStatus())) {
					model.addAttribute("status", "success");
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPwdStatus");
	
				} else if (ERefillConstants.STATUS_INVALID_USER_PASSWORD.equalsIgnoreCase(changeMyAccountPasswordResponse.getChangePasswordStatus())) {
					model.addAttribute("pwdvalid", "true");
					model.addAttribute("error", resourceBundleMessageSource.getMessage("reset.password.already.exists.errmsg", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPassword");
				} else {
					model.addAttribute("error", resourceBundleMessageSource.getMessage("invalid.pwd.errmsg", null, localeObj));
					model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
					return new ModelAndView("resetPassword");
				}
			}else{
				return new ModelAndView("resetPassword");
			}
		} catch (ERefillBusinessException e) {
			LOGGER.error(" Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(" Error6: " + e);
			throw e;					
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("resetPassword");
		}

	}
	
	@RequestMapping(method = { RequestMethod.GET}, value = "/getglobalconfig")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRecaptcha(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute("key",PropertyUtil.getRecaptchaSitekey().trim());
		return new ModelAndView("globalconfig");
	
		
	}
	

}
