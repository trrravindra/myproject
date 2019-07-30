package com.lcl.erefill.core.web.controlllers;

import static com.lcl.erefill.core.constants.ERefillConstants.REQUEST_USER_TOKEN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.ILoginUserBusinessDelegate;
import com.lcl.erefill.core.business.IManagedAccountDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.utils.csrf.CSRFTokenService;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.User;

@Controller
@SessionAttributes
@RequestMapping("/{locale}/user")
public class LoginController {
	
	@Autowired
	CSRFTokenService csrfTokenService;

	@Autowired
	SessionManager sessionManager;

	@Autowired
	ILoginBusinessDelegate loginBD;
	
	@Autowired
	IManagedAccountDelegate managedAccountDelegate;
	
	@Autowired
	ILoginUserBusinessDelegate loginUserBD;
	
	@Autowired
	PropertyUtil propertyUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(@PathVariable String locale, ModelMap model,
			HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		return "signin";
	}

	/**
	 * logOut
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut(@PathVariable String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String appContext = request.getContextPath();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String rememberMe=sessionManager.getRememberMe(eRefillSession);
		String userName=StringUtils.EMPTY;
		if(sessionManager.getErefillUserName(eRefillSession)!=null){
			userName=sessionManager.getErefillUserName(eRefillSession);
		}
		Boolean flag=false;
		Cookie[] cookiesArray = null;
		cookiesArray = request.getCookies();
		List<Cookie> cookiesList = new ArrayList<Cookie>();
		cookiesList = Arrays.asList(cookiesArray);
		if(rememberMe!=null && rememberMe.equalsIgnoreCase("on")){
		    if(cookiesList != null ){    
		        for (Cookie cookie: cookiesList){
		           if(cookie.getName().equalsIgnoreCase(ERefillConstants.EREFILL_USERNAME)){
		        	   cookie.setValue(userName);
		        	   cookie.setPath(appContext);
		        	   response.addCookie(cookie);
		        	   flag=true;
		        	   break;
		           }
		        }
		    }
		    if(!flag){
		    	Cookie newCookie = new Cookie(ERefillConstants.EREFILL_USERNAME, userName);
		    	newCookie.setPath(appContext);
				response.addCookie(newCookie);
		    }
		}
		if(rememberMe!=null && rememberMe.equalsIgnoreCase("off")){
			if(cookiesList != null ){    
				for (Cookie cookie: cookiesList){           
		           if(cookie.getName().equalsIgnoreCase(ERefillConstants.EREFILL_USERNAME)){
		        	   String user=cookie.getValue();
		        	   if(user.equalsIgnoreCase(userName)){
		        		   cookie.setValue(null);
		        		   cookie.setMaxAge(0);
		        		   cookie.setPath(appContext);
			        	   response.addCookie(cookie);
		        	   }
		        	   break;
		           }
		        }
			}
		}
			
		loginBD.logOut(eRefillSession, request, response);
		try {
			if(request.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && request.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE)){
				model.addAttribute("status", "true");
				model.addAttribute("userName", userName);
				response.setStatus(200);
			}else{
				String redirect = appContext +"/home/"+locale+"/welcome";
				response.sendRedirect(redirect);
			}
		} catch (IOException e1) {
			LOGGER.error("Exception while redirecting: ", e1);
		}
	}

	/**
	 * login
	 * 
	 * @param locale
	 * @param user
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String getLogin(@PathVariable String locale,
			@ModelAttribute("user") User user, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		DataCarrier dto = new DataCarrier();
		LOGGER.debug("Entering login");
		String nextPage = "error";
		String appContext = request.getContextPath();
		try {
			if (CommonUtils.isNullOrBlank(user.getUsername())
					|| CommonUtils.isNullOrBlank(user.getPassword())) {
				
				try {
					String redirect = appContext+"/home/" + locale+ "/welcome";
					response.sendRedirect(redirect);
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			} else {

				dto.addObject(ERefillConstants.LOGIN_USER, user);
				dto.addObject(ERefillConstants.LOGIN_REMEMBER,request.getParameter("remember"));
				dto.addObject(ERefillConstants.LOGIN_MODEL, model);
				ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
				dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,eRefillSession);
				dto.addObject(ERefillConstants.HTTP_REQUEST, request);
				
				if(propertyUtil.getIsNewLoginFlow()){
					nextPage = userNewLogin(dto, locale, model, request, response,eRefillSession);
				}else{
					nextPage = userLogin(dto, locale, model, request, response,eRefillSession);
				}
				
			}

		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
		}
		return nextPage;

	}
	
	/**
	 * login
	 * 
	 * @param locale
	 * @param user
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public ModelAndView login(@PathVariable String locale,
			@ModelAttribute("user") User user, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		DataCarrier dto = new DataCarrier();
		LOGGER.debug("Entering login");
		String nextPage = "error";
		String appContext = request.getContextPath();
		try {
			if (CommonUtils.isNullOrBlank(user.getUsername())
					|| CommonUtils.isNullOrBlank(user.getPassword())) {
				//model.addAttribute("error", "invalid username and/or password");
				try {
					String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eInvalidUserPassword";
					response.sendRedirect(redirect);
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			} else {

				dto.addObject(ERefillConstants.LOGIN_USER, user);
				dto.addObject(ERefillConstants.LOGIN_REMEMBER,request.getParameter("remember"));
				dto.addObject(ERefillConstants.LOGIN_MODEL, model);
				ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
				dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,eRefillSession);
				dto.addObject(ERefillConstants.HTTP_REQUEST, request);
				
				
				if(propertyUtil.getIsNewLoginFlow()){
					//model.addAttribute("isConsentExpired", false);
					nextPage = userNewLogin(dto, locale, model, request, response,eRefillSession);
				}else{
					nextPage = userLogin(dto, locale, model, request, response,eRefillSession);
				}
				
				/*** for mobile implementation **/
				if(nextPage.equalsIgnoreCase("resetPassword")){
					model.addAttribute("registrationStep",nextPage);
					model.addAttribute("status",dto.getObject("status"));
					model.remove("user");
				}
				/*** for mobile implementation **/
				if(nextPage.equalsIgnoreCase("reConsent")){
					String redirect = appContext + "/" + locale+ "/reconsent/view";
					model.addAttribute("reConsentStep", "view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/reconsent/view");
					//model.addAttribute("isConsentExpired", true);
					response.sendRedirect(redirect);
				}
			}

		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
			//throw e;
			ErrorHandler.handleException(e);
		}
		return new ModelAndView(nextPage);

	}
	
	/**
	 * reconsentLogin
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reconsentLogin", method = {RequestMethod.GET})
	public String getLogin(@PathVariable String locale,	ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		DataCarrier dto = new DataCarrier();
		LOGGER.debug("Entering login");
		String nextPage = "error";
		String appContext = request.getContextPath();
		try {
			ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			if (CommonUtils.isNullOrBlank(sessionManager.getUserName(eRefillSession))
					|| CommonUtils.isNullOrBlank(sessionManager.getPassword(eRefillSession))) {
				
				try {
					String redirect = appContext+"/home/" + locale+ "/welcome";
					response.sendRedirect(redirect);
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			} else {
				User user = new User();
				user.setUsername(sessionManager.getUserName(eRefillSession));
				user.setPassword(sessionManager.getPassword(eRefillSession));
				dto.addObject(ERefillConstants.LOGIN_USER, user);
				dto.addObject(ERefillConstants.LOGIN_REMEMBER,request.getParameter("remember"));
				dto.addObject(ERefillConstants.LOGIN_MODEL, model);
				dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,eRefillSession);
				dto.addObject(ERefillConstants.HTTP_REQUEST, request);
				if(propertyUtil.getIsNewLoginFlow()){
					//model.addAttribute("isConsentExpired", false);
					nextPage = userNewLogin(dto, locale, model, request, response,eRefillSession);
				}else{
					nextPage = userLogin(dto, locale, model, request, response,eRefillSession);
				}
			}

		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
			ErrorHandler.handleException(e);
		}
		return nextPage;

	}

	
	/*
	 * UserNewLogin
	 * */
	private String userNewLogin(DataCarrier dto, String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			ISession eRefillSession) {
		
		LOGGER.debug("Entering userLogin");
		String nextPage = "error";
		String userRole = "patient";
		String appContext = request.getContextPath();
		try{
			loginUserBD.logOn(dto);
			nextPage = (String) dto.getObject(ERefillConstants.LOGIN_NEXT_PAGE);
			userRole = (String) dto.getObject(ERefillConstants.USER_ROLE);
			
			if ("signin".equalsIgnoreCase(nextPage)) {	
				String homePage = "/home/" + locale + "/welcome?";
				StringBuilder redirect = new StringBuilder (homePage);	
				return "redirect:" +redirect.toString();
			}else if("careGiverFlow".equalsIgnoreCase(nextPage)) {	
				String homePage = "/home/" + locale + "/welcome?&signinerror=eCaregiverNotAllowed";
				StringBuilder redirect = new StringBuilder (homePage);	
				return "redirect:" +redirect.toString();
			}
			
			eRefillSession = (ERefillSession) dto.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			request.setAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION, eRefillSession);		

			boolean isRoleCareGiver= false;
			if(userRole != null && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				isRoleCareGiver = true;
			}
			LOGGER.info("the next page is "+nextPage +" user role in login method is: " +userRole);
			//model.addAttribute(ERefillConstants.USER_ROLE,sessionManager.getUserRole(eRefillSession));
			model.addAttribute(ERefillConstants.USER_ROLE, userRole);
			
			request.getSession(false).setAttribute("userRole", userRole );
			
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			
			model.addAttribute("_tk", csrfTokenService.getTokenFromSession(request));
			
			if ("registration".equalsIgnoreCase(nextPage)) {
				if(isRoleCareGiver){
					//request.setAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION, eRefillSession);
					nextPage = "caregiverAccountPreferences";
					String redirect = appContext + "/" + locale+ "/registration/accountpref/view";
					response.sendRedirect(redirect);
				}else{
					nextPage = "verifyIdentity";
					String redirect = appContext + "/" + locale+ "/registration/identity/validate/view";
					model.addAttribute("registrationStep", "verifyIdentity");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/identity/validate/view");
					model.remove("user");
					response.sendRedirect(redirect);
				}
			}
			/** for status eMustChangePassword */
			if( "userAccountPreferences".equalsIgnoreCase(nextPage)) {
				User user = (User) dto.getObject(ERefillConstants.LOGIN_USER);
				ERefillSession session = (ERefillSession) dto.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
				sessionManager.setUserName(user.getUsername(), session);
				sessionManager.setPassword(user.getPassword(), session);
				if(isRoleCareGiver){
					nextPage = "caregiverAccountPreferences";
					String redirect = appContext + "/" + locale+ "/registration/accountpref/view";
					response.sendRedirect(redirect);
				}else{					
					String redirect = appContext + "/" + locale+ "/registration/user/accountpref/view";
					model.addAttribute("registrationStep", "user-accountpref-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/user/accountpref/view");
					model.remove("user");
					response.sendRedirect(redirect);
				}
				
			}
			if ("myPrescriptions".equalsIgnoreCase(nextPage)){
				model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_PRESCRIPTION_PAGE_TITLE);
				if(isRoleCareGiver){
					boolean isLoggedInUser = true;
					model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
					nextPage="caregiverMyPrescription";
					String redirect = appContext + "/" + locale+ "/caregiver/prescription/details";
					response.sendRedirect(redirect);
				}else{
					String redirect = appContext + "/" + locale+ "/prescription/details";
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/prescription/details");
					response.sendRedirect(redirect);
				}
			}
			if("accountInfo".equalsIgnoreCase(nextPage)){
				nextPage = "accountInfo";
				String redirect = appContext + "/" + locale+ "/registration/accountinfo/view";
				model.addAttribute("registrationStep", "accountinfo-view");
				model.addAttribute("isRedirect", true);
				model.addAttribute("redirectURL", "/registration/accountinfo/view");
				response.sendRedirect(redirect);
			}
			
			if (dto.getObject(REQUEST_USER_TOKEN) != null && !isRoleCareGiver) {
				UserToken userToken = (UserToken) dto
						.getObject(REQUEST_USER_TOKEN);
				
				request.setAttribute(REQUEST_USER_TOKEN, userToken);
				PharmaDeptVO pharmaDeptVO = null;
				if (dto.getObject(ERefillConstants.REQUEST_PHARMACY) != null) {
					pharmaDeptVO = (PharmaDeptVO) dto.getObject(ERefillConstants.REQUEST_PHARMACY);
				}

				if (pharmaDeptVO != null && pharmaDeptVO.getPharmaVO() != null) {
					Cookie storeId = new Cookie(
							ERefillConstants.COOKIE_STORE_ID,
							((PharmaDeptVO) dto
									.getObject(ERefillConstants.REQUEST_PHARMACY))
									.getPharmaVO().getStoreId());
					storeId.setPath(appContext);
					response.addCookie(storeId);
				}
			}
			if(!isRoleCareGiver){
				model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
				model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
				model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
				model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(eRefillSession));
				model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
			}
			
		}catch (ERefillBusinessException e) {
			LOGGER.error("Exception while login: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error("Exception while login: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
			try {
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				LOGGER.error("Exception while redirecting: ", e1);
			}
		}
		
		return nextPage;
	}

	/**
	 * loginSuccess
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login/success", method = RequestMethod.POST)
	public String loginSuccess(@PathVariable String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		DataCarrier dto = new DataCarrier();
		LOGGER.debug("Entering loginSuccess");
		String nextPage = "error";
		try {
			User user = new User();
			ERefillSession eRefillSession = (ERefillSession) request
					.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			user.setUsername(sessionManager.getUserName(eRefillSession));
			user.setPassword(sessionManager.getPassword(eRefillSession));

			dto.addObject(ERefillConstants.LOGIN_USER, user);
			dto.addObject(ERefillConstants.LOGIN_MODEL, model);
			dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,	eRefillSession);
			dto.addObject(ERefillConstants.HTTP_REQUEST, request);
			
			if(propertyUtil.getIsNewLoginFlow()){
				//model.addAttribute("isConsentExpired", false);
				nextPage = userNewLogin(dto, locale, model, request, response,eRefillSession);
			}else{
				nextPage = userLogin(dto, locale, model, request, response,eRefillSession);
			}
			

		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
			ErrorHandler.handleException(e);
		}
		return nextPage;

	}

	/**
	 * userLogin
	 * 
	 * @param dto
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @param eRefillSession
	 * @return nextPage
	 */
	private String userLogin(DataCarrier dto, String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			ISession eRefillSession) {
		LOGGER.debug("Entering userLogin");
		String nextPage = "error";
		String userRole = "patient";
		String appContext = request.getContextPath();
		try {
			loginBD.logOn(dto);
			nextPage = (String) dto.getObject(ERefillConstants.LOGIN_NEXT_PAGE);
			userRole = (String) dto.getObject(ERefillConstants.USER_ROLE);
			
			if ("signin".equalsIgnoreCase(nextPage)) {	
				String homePage = "/home/" + locale + "/welcome?";
				StringBuilder redirect = new StringBuilder (homePage);	
				return "redirect:" +redirect.toString();
			}else if("careGiverFlow".equalsIgnoreCase(nextPage)) {	
				String homePage = "/home/" + locale + "/welcome?&signinerror=eCaregiverNotAllowed";
				StringBuilder redirect = new StringBuilder (homePage);	
				return "redirect:" +redirect.toString();
			}
			
			eRefillSession = (ERefillSession) dto.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			request.setAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION, eRefillSession);		
			
			boolean isRoleCareGiver= false;
			if(userRole != null && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				isRoleCareGiver = true;
			}
			LOGGER.info("the next page is "+nextPage +" user role in login method is: " +userRole);
			model.addAttribute(ERefillConstants.USER_ROLE, userRole);
			request.getSession(false).setAttribute("userRole", userRole );
			
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			
			model.addAttribute("_tk", csrfTokenService.getTokenFromSession(request));
			
			if ("registration".equalsIgnoreCase(nextPage)) {
				if(isRoleCareGiver){
					nextPage = "caregiverAccountPreferences";
					String redirect = appContext + "/" + locale+ "/registration/accountpref/view";
					response.sendRedirect(redirect);
				}else{
					nextPage = "verifyIdentity";
					String redirect = appContext + "/" + locale+ "/registration/identity/validate/view";
					
					model.addAttribute("registrationStep", "verifyIdentity");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/identity/validate/view");
					model.remove("user");
					response.sendRedirect(redirect);
				}
			} 
			/** for status eMustChangePassword */
			if( "userAccountPreferences".equalsIgnoreCase(nextPage)) {
				User user = (User) dto.getObject(ERefillConstants.LOGIN_USER);
				ERefillSession session = (ERefillSession) dto.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
				sessionManager.setUserName(user.getUsername(), session);
				sessionManager.setPassword(user.getPassword(), session);
				if(isRoleCareGiver){
					nextPage = "caregiverAccountPreferences";
					String redirect = appContext + "/" + locale+ "/registration/accountpref/view";
					response.sendRedirect(redirect);
				}else{					
					String redirect = appContext + "/" + locale+ "/registration/user/accountpref/view";
					model.addAttribute("registrationStep", "user-accountpref-view");
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/registration/user/accountpref/view");
					model.remove("user");
					response.sendRedirect(redirect);
				}
			}
			if ("myPrescriptions".equalsIgnoreCase(nextPage)){
				model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_PRESCRIPTION_PAGE_TITLE);
				if(isRoleCareGiver){
					boolean isLoggedInUser = true;
					model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
					nextPage="caregiverMyPrescription";
					String redirect = appContext + "/" + locale+ "/caregiver/prescription/details";
					response.sendRedirect(redirect);
				}else{
					String redirect = appContext + "/" + locale+ "/prescription/details";
					model.addAttribute("isRedirect", true);
					model.addAttribute("redirectURL", "/prescription/details");
					response.sendRedirect(redirect);
				}
			}
			if("accountInfo".equalsIgnoreCase(nextPage)){
				nextPage = "accountInfo";
				String redirect = appContext + "/" + locale+ "/registration/accountinfo/view";
				model.addAttribute("registrationStep", "accountinfo-view");
				model.addAttribute("isRedirect", true);
				model.addAttribute("redirectURL", "/registration/accountinfo/view");
				response.sendRedirect(redirect);
			}
			
			if (dto.getObject(REQUEST_USER_TOKEN) != null && !isRoleCareGiver) {
				UserToken userToken = (UserToken) dto
						.getObject(REQUEST_USER_TOKEN);
				
				request.setAttribute(REQUEST_USER_TOKEN, userToken);
				PharmaDeptVO pharmaDeptVO = null;
				if (dto.getObject(ERefillConstants.REQUEST_PHARMACY) != null) {
					pharmaDeptVO = (PharmaDeptVO) dto.getObject(ERefillConstants.REQUEST_PHARMACY);
				}

				if (pharmaDeptVO != null && pharmaDeptVO.getPharmaVO() != null) {
					Cookie storeId = new Cookie(
							ERefillConstants.COOKIE_STORE_ID,
							((PharmaDeptVO) dto
									.getObject(ERefillConstants.REQUEST_PHARMACY))
									.getPharmaVO().getStoreId());
					storeId.setPath(appContext);
					response.addCookie(storeId);
				}
			}
			if(!isRoleCareGiver){
				model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
				model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
				model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
				model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(eRefillSession));
				model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
			}
			
		} catch (ERefillBusinessException e) {
			LOGGER.error("Exception while login: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error("Exception while login: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception while logging in: ", e);
			try {
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				LOGGER.error("Exception while redirecting: ", e1);
			}
		}
		
		return nextPage;
	}

	/**
	 * termsandconditions
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/terms-and-conditions", method = RequestMethod.GET)
	public ModelAndView termsandconditions(@PathVariable String locale,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isUserLoggedIn = isUserLoggedIn(request, response);	
		
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_TC);
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.TERMS_AND_CONDITIONS_PAGE_TITLE);
		
		if(!isUserLoggedIn){
			return new ModelAndView("termsAndConditionsLO");
		}
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
		
		return new ModelAndView("termsAndConditions");
	
		
	}

	/**
	 * privacypolicy
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/privacy-policy", method = RequestMethod.GET)
	public ModelAndView privacypolicy(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isUserLoggedIn = isUserLoggedIn(request, response);	
		
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_PRIVACY);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.PRIVACY_PAGE_TITLE);
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		
		if(! isUserLoggedIn){
			return new ModelAndView("privacyPolicyLO");
		}
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
		
		
		return new ModelAndView("privacyPolicy");
		
		
	}

	/**
	 * consent
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/consent", method = RequestMethod.GET)
	public ModelAndView consent(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isUserLoggedIn = isUserLoggedIn(request, response);	
		
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_CONSENT);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.CONSENT_PAGE_TITLE);
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		
		if(! isUserLoggedIn){
			return new ModelAndView("consentLO");
		}
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
		
		return new ModelAndView("consent");
		
		
	}

	/**
	 * viewHelp
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public ModelAndView viewHelp(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRol= sessionManager.getUserRole(eRefillSession);
		model.addAttribute(ERefillConstants.USER_ROLE, userRol);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.HELP_PAGE_TITLE);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		} 
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
		if(userRol.equals(ERefillConstants.CARE_GIVER)){
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.CARE_GIVER_PAGE_NAME_HELP);
			return new ModelAndView("caregiverHelp");
		}else{
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_HELP);
			return new ModelAndView("help");
		}
		
		
	}

	/**
	 * viewContactUs
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView viewContactUs(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRol= sessionManager.getUserRole(eRefillSession);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USER_ROLE, userRol);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.CONTACT_US_PAGE_TITLE);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		} 
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
		if(userRol.equals(ERefillConstants.CARE_GIVER)){
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.CARE_GIVER_PAGE_NAME_CONTACT_US);
			return new ModelAndView("caregiverContactUs");
		}else{
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_CONTACT_US);
			return new ModelAndView("contactUs");
		}
	}
	
	private boolean isUserLoggedIn(HttpServletRequest request, HttpServletResponse response){
		boolean isUserLogedIn = false;
		boolean isRegistrationFlow = false;
		String userName = StringUtils.EMPTY;
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
				if(eRefillSession.getAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION)==null){
						return isUserLogedIn;
				}else{
					userName = sessionManager.getUserName(eRefillSession);
					isRegistrationFlow = sessionManager.isRegistrationFlow(eRefillSession);
				
					if(StringUtils.isBlank(userName) || isRegistrationFlow==true){
						isUserLogedIn = false;
					}else{
						isUserLogedIn = true;
					}
				}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e);
		}
		return isUserLogedIn;
	}
}
