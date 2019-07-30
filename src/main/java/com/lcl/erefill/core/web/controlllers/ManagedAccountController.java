package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.IManagedAccountDelegate;
import com.lcl.erefill.core.business.IPrescriptionBusinessDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PrescriptionModel;

/***
 * 
 * @author gpunno version 1.0
 */

@Controller
@RequestMapping("/{locale}/managedaccount")
public class ManagedAccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagedAccountController.class);

	@Autowired
	SessionManager sessionManager;

	@Autowired
	private IManagedAccountDelegate managerAccountDelegate;

	@Autowired
	ILoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	private ReloadableResourceBundleMessageSource resourceBundleMessageSource;
	
	@Autowired
	IPrescriptionBusinessDelegate prescriptionBusinessDelegate;

	private Locale localeObj;

	/**
	 * getMyManagedAccountDetails
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/details")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getMyManagedAccountDetails(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		final String methodName = "managedAccountDetails";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		Map<String, Object> managedAccountResponse = null;
		String appContext = request.getContextPath();
		try {
			managedAccountResponse = managerAccountDelegate.getManagedAccountDetails(eRefillSession);
		
		}catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(methodName + " Error6: " + e);
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
			LOGGER.error(methodName + " Error: " + e);
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext +"/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				LOGGER.error("Exception while fecthing managed account details: ", e1);
			}
		}

		if (null != managedAccountResponse.get("PendingListManager")) {
			model.addAttribute("managerListPending", managedAccountResponse.get("PendingListManager"));
		} else
			model.addAttribute("managerListPending", null);

		if (null != managedAccountResponse.get("AcceptedListManager"))
			model.addAttribute("managerListAccepted", managedAccountResponse.get("AcceptedListManager"));
		else
			model.addAttribute("managerListAccepted", null);

		if (null != managedAccountResponse.get("familyListPending"))
			model.addAttribute("familyListPending", managedAccountResponse.get("familyListPending"));
		else
			model.addAttribute("familyListPending", null);

		if (null != managedAccountResponse.get("familyListAccepted"))
			model.addAttribute("familyListAccepted", managedAccountResponse.get("familyListAccepted"));
		else
			model.addAttribute("familyListAccepted", null);

		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_MY_MANAGED_ACCOUNT);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_MANAGED_ACCOUNT_PAGE_TITLE);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return new ModelAndView("myManagedAccounts");

	}

	/**
	 * getConsent
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/getConsent", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ConsentVO getConsent(@PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res, String consentType) {

		final String methodName = "getConsent";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		DataCarrier dto = new DataCarrier();

		if (StringUtils.isBlank(consentType)) {
			consentType = req.getParameter("consentType");
		}
		ERefillSession eRefillSession = (ERefillSession) req.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		if (StringUtils.isEmpty(consentType))
			consentType = "FamilyMember";
		try {
			dto.addObject(ERefillConstants.CONSENT_TYPE, consentType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConsentVO consent = null;
		String appContext = req.getContextPath();
		try {
			consent = managerAccountDelegate.getConsent(dto, eRefillSession);
		} catch (ERefillBusinessException e) {
			LOGGER.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					LOGGER.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			LOGGER.error(methodName + " Error: " + e);
			loginBusinessDelegate.logOut(eRefillSession, req, res);
			try {
				String redirect = appContext + "/home/" + locale + "/welcome?signinerror=eProcessingError";
				res.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				LOGGER.error("Exception while redirecting: ", e1);
			}
		}
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		return consent;
	}

	@RequestMapping(value = "/getMinorAge", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public int getMinorAge(ERefillSession erefillSession) {
		int ageLimit = 14;
		try {
			ageLimit = managerAccountDelegate.getMinorAge(erefillSession);
		} catch (Exception e) {
			return 14;
		}
		return ageLimit;
	}

	/**
	 * grantAccess
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/grantAccess", method = RequestMethod.POST)
	public void grantAccess(@PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		final String methodName = "[grantAccess] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		JSONObject responseObj = new JSONObject();
		DataCarrier dto = new DataCarrier();
		String managerName = StringUtils.trimToEmpty(req.getParameter("username"));
		String dob = StringUtils.trimToEmpty(req.getParameter("date-of-birth-date"));
		String consentOID = StringUtils.trimToEmpty(req.getParameter("consentOID"));
		String relationship = StringUtils.trimToEmpty(req.getParameter("relationship"));
		String[] date = null;
		ERefillSession erefillSession = (ERefillSession) req.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		try {
			if (null != dob) {
				date = dob.split("-");
			}
			dto.addObject(ERefillConstants.GUEST_USER_NAME, managerName);
			dto.addObject(ERefillConstants.REQ_PARAM_MONTH, date[1]);
			dto.addObject(ERefillConstants.REQ_PARAM_DAY, date[2]);
			dto.addObject(ERefillConstants.REQ_PARAM_YEAR, date[0]);
			dto.addObject(ERefillConstants.CONSENT_OID, consentOID);
			dto.addObject(ERefillConstants.RELATIONSHIP, relationship);
			dto = managerAccountDelegate.grantAccess(dto, erefillSession);			

			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);			
			if (dto == null) {								
				responseObj.append("message", "0");
				responseObj.append("errorType", "536");		
			} else if ("mismatch".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {		
				responseObj.append("message", "0");
				responseObj.append("errorType", "mismatch");				
			}else if (("2058".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) || 
					("2059".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR)))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "maximum");				
			}else if ("2069".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "2069");				
			}else if ("2073".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "2073");				
			} else if ("2074".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "2074");				
			} else if ("2079".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "2079");				
			} else if ("sessionexpired".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "sessionexpired");				
			} else if ("error".equalsIgnoreCase((String) dto.getObject(ERefillConstants.ERROR))) {	
				responseObj.append("message", "1");
				responseObj.append("errorType", "0");				
			}
			
			if(!responseObj.has("message")){
				responseObj.append("message", "2");
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred in grantAccess",e);
			try {
				responseObj.append("message", "1");				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}			
		}		
		setResponseTextAsJson(responseObj.toString(),res);		
	}

	/**
	 * setupCustodianForMinor
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/setupCustodianForMinor", method = RequestMethod.POST)
	public void setupCustodianForMinor(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		DataCarrier dtc = new DataCarrier();
		ERefillSession erefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userName = StringUtils.trimToEmpty(request.getParameter("username"));
		String password = StringUtils.trimToEmpty(request.getParameter("password"));
		String dob = StringUtils.trimToEmpty(request.getParameter("date-of-birth-date"));
		String relationShip = StringUtils.trimToEmpty(request.getParameter("relationship"));
		String consentOID = StringUtils.trimToEmpty(request.getParameter("consentOID"));
		JSONObject responseObj = new JSONObject();		
		String[] date = null;
		if (null != dob) {
			date = dob.split("-");
		}
		try {
			dtc.addObject(ERefillConstants.GUEST_USER_NAME, userName);
			dtc.addObject(ERefillConstants.PASSWORD, password);
			dtc.addObject(ERefillConstants.CONSENT_OID, consentOID);
			dtc.addObject(ERefillConstants.REQ_PARAM_MONTH, date[1]);
			dtc.addObject(ERefillConstants.REQ_PARAM_DAY, date[2]);
			dtc.addObject(ERefillConstants.REQ_PARAM_YEAR, date[0]);
			dtc.addObject(ERefillConstants.RELATIONSHIP, relationShip);
			dtc = managerAccountDelegate.setupCustodianForMinor(dtc, erefillSession);			
			
			if (dtc == null) {	
				responseObj.append("message", "0");
				responseObj.append("errorType", "536");//json.append("errorType", "536");
			} else if ("mismatch".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "0");
				responseObj.append("errorType", "mismatch");			
			} else if ("2073".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "1");
				responseObj.append("errorType", "2073");				
			} else if ("2074".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "1");
				responseObj.append("errorType", "2074");				
			} else if ("2079".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "1");
				responseObj.append("errorType", "2079");			
			} else if ("2084".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {
				responseObj.append("message", "1");			
				responseObj.append("errorType", "2084");
			}else if ("2059".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {
				responseObj.append("message", "1");			
				responseObj.append("errorType", "2059");
			}else if ("2090".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {
				responseObj.append("message", "1");			
				responseObj.append("errorType", "2090");
			}else if ("password-error".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "0");
				responseObj.append("errorType", "invalidpassword");				
			} else if ("sessionexpired".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "1");
				responseObj.append("errorType", "sessionexpired");				
			} else if ("error".equalsIgnoreCase((String) dtc.getObject(ERefillConstants.ERROR))) {				
				responseObj.append("message", "1");
				responseObj.append("errorType", "0");
			}
			if(!responseObj.has("message")){
				responseObj.append("message", "2");
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception occurred in setupCustodianForMinor",e);
			try {				
				responseObj.append("message", "1");
			} catch (NoSuchMessageException e1) {	
				LOGGER.error(e1.getMessage());
			} catch (JSONException e1) {
				LOGGER.error(e1.getMessage());
			}
			}		
		setResponseTextAsJson(responseObj.toString(),response);

	}

	/**
	 * revokeAccess
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/revokeAccess", method = RequestMethod.POST)
	public void revokeAccess(@PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		final String methodName = "[revokeAccess] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}		
		/*Locale localeObj = new Locale("en", "CA");
		if (locale != null && "fr".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}*/
		DataCarrier dto = new DataCarrier();
		ERefillSession erefillSession = (ERefillSession) req.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String managerUserName = StringUtils.trimToEmpty(req.getParameter("managerUserName"));
		String managedUserName = StringUtils.trimToEmpty(req.getParameter("managedUserName"));		
		
		JSONObject responseObj = new JSONObject();
		try {
			dto.addObject(ERefillConstants.MANAGER_USERNAME, managerUserName);
			dto.addObject(ERefillConstants.MANAGED_USERNAME, managedUserName);
			dto.addObject("requestType", req.getParameter("requestType"));		
			if(StringUtils.isNotBlank(req.getParameter("notify-custodian"))){
				dto.addObject(ERefillConstants.SEND_NOTIFICATION , "true");
			}else{
				dto.addObject(ERefillConstants.SEND_NOTIFICATION, "false");
			}						
			managerAccountDelegate.revokeAccess(dto, erefillSession);
			UserToken token = sessionManager.getToken(erefillSession);
			if(!token.getStatus().equalsIgnoreCase("error")){
				responseObj.append("message", "2");	
			}else{
				responseObj.append("message", "1");
			}
			
			//model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(erefillSession));
			/*if (StringUtils.isNotBlank(req.getParameter("requestType"))) {
				model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(erefillSession));
				return new ModelAndView("overlay-manage-cancel-being-custodian-submission-success");
			} else
				return new ModelAndView("overlay-manage-revoke-access-submission-success");*/

		} catch (Exception e) {
			try {
				responseObj.append("message", "1");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			// LOGGER.error(e.getMessage(), e);
			//model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			//model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			//return new ModelAndView("mymanagedaccount-overlay-failure");
		}
		setResponseTextAsJson(responseObj.toString(), res);
	}

	/**
	 * acceptRequest
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/acceptRequest", method = RequestMethod.POST)
	public void acceptRequest(@PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		final String methodName = "[declineRequest] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		JSONObject responseObj = new JSONObject();
		DataCarrier dto = new DataCarrier();
		ERefillSession erefillSession = (ERefillSession) req.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String username = req.getParameter("requestorUserName");
		String consentOID = StringUtils.trimToEmpty(req.getParameter("consentOID"));
		try {
			dto.addObject(ERefillConstants.REQUESTOR_USERNAME, username);
			dto.addObject(ERefillConstants.CONSENT_OID, consentOID);
			managerAccountDelegate.familyManagerAssignAccept(dto, erefillSession);
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(erefillSession));
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(erefillSession));
			UserToken token = sessionManager.getToken(erefillSession);
			if(!token.getStatus().equalsIgnoreCase("error")){
				responseObj.append("message", "2");	
			}else{
				responseObj.append("message", "1");
			}
			//return new ModelAndView("overlay-manage-accept-being-custodian-submission-success");

		} catch (Exception e) {
			try {
				responseObj.append("message", "1");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			/*model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			return new ModelAndView("mymanagedaccount-overlay-failure");*/
		}
		setResponseTextAsJson(responseObj.toString(), res);
	}

	/**
	 * declineRequest
	 * 
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/declineRequest", method = RequestMethod.POST)
	public void declineRequest(@PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		final String methodName = "[declineRequest] ";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + "Entering");
		}
		JSONObject responseObj = new JSONObject();
		/*Locale localeObj = new Locale("en", "CA");
		if (locale != null && "fr".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}*/
		DataCarrier dto = new DataCarrier();
		ERefillSession erefillSession = (ERefillSession) req.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String requestor = req.getParameter("requestorUserName");
		try {
			dto.addObject(ERefillConstants.REQUESTOR_USERNAME, requestor);
			managerAccountDelegate.familyManagerAssignDecline(dto, erefillSession);
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			UserToken token = sessionManager.getToken(erefillSession);
			if(!token.getStatus().equalsIgnoreCase("error")){
				responseObj.append("message", "2");	
			}else{
				responseObj.append("message", "1");
			}
			//return new ModelAndView("overlay-manage-decline-tobe-custodian-submission-success");
		} catch (Exception e) {
			try {
				responseObj.append("message", "1");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			/*model.addAttribute("error", resourceBundleMessageSource.getMessage("sys.errMsg", null, localeObj));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);*/
			//return new ModelAndView("mymanagedaccount-overlay-failure");
		}
		setResponseTextAsJson(responseObj.toString(), res);
	}

	/**
	 * custodianshipInfoView
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/info", method = RequestMethod.GET)
	public ModelAndView custodianshipInfoView(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));

		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		return new ModelAndView("overlay-manage-whatis-custodian-access");

	}

	/**
	 * custodianshipDeclineReqConfirmation
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/declinerequest/requestoruser/{requestoruser}/patientname/{patientname}/relationship/{relationship}", method = RequestMethod.GET)
	public ModelAndView custodianDeclineReqConfirmation(@PathVariable String requestoruser,@PathVariable String locale, 
			@PathVariable String patientname ,@PathVariable String relationship,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));

		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, requestoruser);
		
		String requestURI = request.getRequestURI();
		String decodedURI = URLDecoder.decode(requestURI, "UTF-8");
		String[] splitedURL=decodedURI.split("/");
		String relation=splitedURL[11];
		
		model.addAttribute("name",patientname);
		model.addAttribute("relationship",relation);
		return new ModelAndView("overlay-manage-decline-request");

	}

	/**
	 * custodianAcceptReqConfirmation
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/acceptrequest/requestoruser/{requestoruser}/patientname/{patientname}/relationship/{relationship}", method = RequestMethod.GET)
	public ModelAndView custodianAcceptReqConfirmation(@PathVariable String requestoruser,@PathVariable String locale, 
			@PathVariable String patientname ,@PathVariable String relationship, Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		ConsentVO consent = getConsent(locale, model, request, response, "ManagerAccept");
		model.addAttribute(ERefillConstants.CONSENT_OID, consent.getOid());
		if (locale.contains(ERefillConstants.STR_FRENCH_LOCALE)) {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementFrench());
		} else {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementEnglish());
		}
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));

		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, requestoruser);
		
		String requestURI = request.getRequestURI();
		String decodedURI = URLDecoder.decode(requestURI, "UTF-8");
		String[] splitedURL=decodedURI.split("/");
		String relation=splitedURL[11];
		
		model.addAttribute("name",patientname);
		model.addAttribute("relationship",relation);
		return new ModelAndView("overlay-manage-accept-being-custodian");

	}

	/**
	 * custodianCancelAccess
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/cancelaccess/patientname/{patientname}/relationship/{relationship}/managerusername/{managerusername}", method = RequestMethod.GET)
	public ModelAndView custodianCancelAccess(@PathVariable String locale, @PathVariable String patientname ,@PathVariable String relationship,
			@PathVariable String managerusername,Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
		
		String requestURI = request.getRequestURI();
		String decodedURI = URLDecoder.decode(requestURI, "UTF-8");
		String[] splitedURL=decodedURI.split("/");
		String relation=splitedURL[9];
		
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		model.addAttribute("name",patientname);
		model.addAttribute("relationship",relation);
		model.addAttribute("managerUserName",managerusername);
		return new ModelAndView("overlay-manage-cancel-access");

	}

	/**
	 * custodianGrantAccess
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/grantaccess", method = RequestMethod.GET)
	public ModelAndView custodianGrantAccess(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		ConsentVO consent = getConsent(locale, model, request, response, "");
		model.addAttribute(ERefillConstants.CONSENT_OID, consent.getOid());
		if (locale.contains(ERefillConstants.STR_FRENCH_LOCALE)) {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementFrench());
		} else {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementEnglish());
		}
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));

		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		return new ModelAndView("overlay-manage-grant-custodian-access");

	}

	/**
	 * custodianRevokeAccess
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/revokeaccess/patientname/{patientname}/relationship/{relationship}/managerusername/{managerusername}", method = RequestMethod.GET)
	public ModelAndView custodianRevokeAccess(@PathVariable String locale, @PathVariable String patientname ,@PathVariable String relationship,
			@PathVariable String managerusername,Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		
		String requestURI = request.getRequestURI();
		String decodedURI = URLDecoder.decode(requestURI, "UTF-8");
		String[] splitedURL=decodedURI.split("/");
		String relation=splitedURL[9];
		
		model.addAttribute("name",patientname);
		model.addAttribute("relationship",relation);
		model.addAttribute("managerUserName",managerusername);
		return new ModelAndView("overlay-manage-revoke-access");

	}

	/**
	 * custodianRemoveRequest
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/removerequest/patientname/{patientname}/relationship/{relationship}/managerusername/{managerusername}", method = RequestMethod.GET)
	public ModelAndView custodianRemoveRequest(@PathVariable String locale, @PathVariable String patientname ,@PathVariable String relationship,
			@PathVariable String managerusername,Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		
		String requestURI = request.getRequestURI();
		String decodedURI = URLDecoder.decode(requestURI, "UTF-8");
		String[] splitedURL=decodedURI.split("/");
		String relation=splitedURL[9];
		
		model.addAttribute("name",patientname);
		model.addAttribute("relationship",relation);
		model.addAttribute("managerUserName",managerusername);
		
		return new ModelAndView("overlay-manage-remove-request");

	}

	/**
	 * custodianSetUpMinor
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @return modelAndView
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/custodianship/minor", method = RequestMethod.GET)
	public ModelAndView custodianSetUpMinor(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		ConsentVO consent = getConsent(locale, model, request, response, "FamilyManager");
		model.addAttribute(ERefillConstants.CONSENT_OID, consent.getOid());
		if (locale.contains(ERefillConstants.STR_FRENCH_LOCALE)) {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementFrench());
		} else {
			model.addAttribute(ERefillConstants.CONSENT_AGREEMENT, consent.getAgreementEnglish());
		}
		int ageLimit = getMinorAge(eRefillSession);
		model.addAttribute(ERefillConstants.MINOR_AGE_LIMIT, ageLimit);
		model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
		model.addAttribute(ERefillConstants.USERNAME, sessionManager.getUserName(eRefillSession));
		response.setHeader("Cache-Control", "no-cache");
		return new ModelAndView("overlay-manage-setup-custodian-minor");

	}

	public Locale getLocaleObj(String locale) {
		localeObj = new Locale("en", "CA");
		if (locale != null && "fr".equalsIgnoreCase(locale)) {
			localeObj = new Locale("fr", "CA");
		}
		return localeObj;

	}
	/**
	 * setResponseTextAsJson
	 * 
	 * @param responseMessage
	 * @param response
	 */
	private void setResponseTextAsJson(String responseMessage,
			HttpServletResponse response) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(responseMessage);
		} catch (IOException ioExcep) {

			throw new ERefillApplicationException(ioExcep);
		}
	}
	
	/**
	 * getGrantCustodianStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/grantAccess/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getGrantCustodianStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
 HttpServletResponse response) {

		//String name = request.getParameter("name");

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null
				&& !selectedPatientOID
						.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);

		String view = null;
		if (status.equalsIgnoreCase("success")) {
			view = "overlay-manage-grant-custodian-access-success";
		//	model.addAttribute("name", name);
		} else {
			view = "overlay-manage-grant-custodian-access-failure";
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		return new ModelAndView(view);
	}
	
	/**
	 * getGrantCustodianStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/setupCustodianForMinor/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getGrantCustodianMinor(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
 HttpServletResponse response) {

		//String name = request.getParameter("name");

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null
				&& !selectedPatientOID
						.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);

		String view = null;
		if (status.equalsIgnoreCase("success")) {
			view = "overlay-manage-setup-custodian-minor-success";
		//	model.addAttribute("name", name);
		} else {
			view = "overlay-manage-setup-custodian-minor-failure";
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		return new ModelAndView(view);
	}
	
	/**
	 * getGrantCustodianStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/revokeAccess/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView revokeStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
 HttpServletResponse response) {

		//String name = request.getParameter("name");

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null
				&& !selectedPatientOID
						.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);

		String view = null;
		if (status.equalsIgnoreCase("success")) {
			view = "overlay-manage-revoke-access-submission-success";
		//	model.addAttribute("name", name);
		} else {
			view = "overlay-manage-revoke-access-submission-failure";
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		return new ModelAndView(view);
	}
	/**
	 * declineRequest
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/declineRequest/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView declineRequestStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
 HttpServletResponse response) {

		//String name = request.getParameter("name");

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null
				&& !selectedPatientOID
						.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);

		String view = null;
		if (status.equalsIgnoreCase("success")) {
			view = "overlay-manage-decline-tobe-custodian-submission-success";
		//	model.addAttribute("name", name);
		} else {
			view = "mymanagedaccount-overlay-failure";
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		return new ModelAndView(view);
	}
	
	/**
	 * declineRequest
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/acceptRequest/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView acceptRequestStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
 HttpServletResponse response) {

		//String name = request.getParameter("name");

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null
				&& !selectedPatientOID
						.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);

		String view = null;
		if (status.equalsIgnoreCase("success")) {
			view = "overlay-manage-accept-being-custodian-submission-success";
		//	model.addAttribute("name", name);
		} else {
			view = "mymanagedaccount-overlay-failure";
		}

		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		return new ModelAndView(view);
	}
	
	/**
	 * 
	 * @param locale
	 * @param prescriptionModel
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(method = {RequestMethod.GET }, value = "/prescription/username/{username}")
	public String getCustodianPrescriptions(@PathVariable String locale,@PathVariable String username,
			@ModelAttribute PrescriptionModel prescriptionModel,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getPrescriptionDetails";
		String appContext = request.getContextPath();
		

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
				sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
				sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
				sessionManager.getPendingCustodianRequests(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);

		DataCarrier dto = new DataCarrier();
		try {
			String patientOID = managerAccountDelegate.getPatientOID(eRefillSession, username);

			dto.addObject(ERefillConstants.LOGIN_MODEL, model);
			dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,
					eRefillSession);
			dto.addObject("prescriptionModel", prescriptionModel);
			if (StringUtils.isNotBlank(patientOID)) {
				sessionManager
						.setSelectedPatientOID(patientOID,
								eRefillSession);
				dto.addObject(ERefillConstants.SELECTED_PATIENT_OID,patientOID);
			} else {
				dto.addObject(ERefillConstants.SELECTED_PATIENT_OID,
						sessionManager.getSelectedPatientOID(eRefillSession));
			}

			prescriptionBusinessDelegate.processToMyPrescription(dto);
			/*@SuppressWarnings("unchecked")
			List<List<String>> automatedRefills = (List<List<String>>) dto
					.getObject(ERefillConstants.MAP_KEY_AUTOMATED_REFILL_RESPONSE);
			List<String> autoRefillOriginalOids = automatedRefills.get(0);
			List<String> autoRefillOids = automatedRefills.get(1);
			List<String> refillDate = automatedRefills.get(2);
			LOGGER.info("RefillDate::::" + refillDate);

			@SuppressWarnings("unchecked")
			List<List<String>> refillReminders = (List<List<String>>) dto
					.getObject(ERefillConstants.MAP_KEY_REFILL_REMINDER_RESPONSE);

			List<String> refillReminderOriginalOids = new ArrayList<String>();
			List<String> refillReminderOids = new ArrayList<String>();
			if (refillReminders != null) {
				refillReminderOriginalOids = refillReminders.get(0);
				refillReminderOids = refillReminders.get(1);
			}*/
			
			List<Object> parameterList = prescriptionBusinessDelegate.getPrescRequestParameterList(dto);
			LOGGER.debug("Managed Account parameters::" + parameterList);			
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.getPrescriptionList(dto, parameterList, locale);
			List<PrescriptionsBO> userPresBO = prescriptionFilterResponse.getLstPresc();
			List<String> autoRefillOriginalOids = new ArrayList<String>();
			List<String> autoRefillOids = new ArrayList<String>();
			List<String> refillDate = new ArrayList<String>();
			
			if (userPresBO!=null) {
				Iterator<PrescriptionsBO> itrUserPresBO = userPresBO.iterator();
				while (itrUserPresBO.hasNext()) {
					PrescriptionsBO prescrBO = itrUserPresBO.next();
					int isAllowed = prescrBO.getAutomatedRefillAllowed();
					LOGGER.debug("ManagedAcc<<>><<>><<>><<>>"+prescrBO.getRxNumber()+":::"+isAllowed);
					if (isAllowed >= 2) {
						LOGGER.debug("ManagedAcc<<>><<>><<>>"+prescrBO.getRxNumber());
						String opEventOid = prescrBO.getOperationalEventOid();
						String originalOid = prescrBO.getOriginalOID();
						String nextExpDate = prescrBO.getNextExpectedDate();
						if (opEventOid != null && originalOid != null) {
							autoRefillOriginalOids.add(originalOid);
							autoRefillOids.add(opEventOid);
							refillDate.add(nextExpDate);
						}
					}
				}
			}
			
			List<String> refillReminderOriginalOids = new ArrayList<String>();
			List<String> refillReminderOids = new ArrayList<String>();
			if (userPresBO!=null) {
				Iterator<PrescriptionsBO> itrRefillRemainder = userPresBO
						.iterator();
				while (itrRefillRemainder.hasNext()) {
					PrescriptionsBO prescrBO = itrRefillRemainder.next();
					int isRefillRemainder = prescrBO.getRefillReminderAllowed();
					LOGGER.debug("ManagedAcc<<>><<>><<>><<>>...."+prescrBO.getRxNumber()+":::"+isRefillRemainder);

					if (isRefillRemainder >= 2) {
						LOGGER.debug("ManagedAcc<<>><<>><<>>...."+prescrBO.getRxNumber());
						String opEventOid = prescrBO.getOperationalEventOid();
						String originalOid = prescrBO.getOriginalOID();

						if (opEventOid != null && originalOid != null) {
							refillReminderOriginalOids.add(originalOid);
							refillReminderOids.add(opEventOid);
						}

					}
				}
			}				
			model.addAttribute("refillReminders", refillReminderOriginalOids);
			model.addAttribute("refillReminderOids", refillReminderOids);

			List<AssignedPatientResponse> assignedPatients = sessionManager
					.getAssignedPatients(eRefillSession);
			LOGGER.info("assignedPatients:: " + assignedPatients);
			String selectedPatientOID = sessionManager
					.getSelectedPatientOID(eRefillSession);
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null) {
				isLoggedInUser = false;
			}
			model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,
					isLoggedInUser);
			model.addAttribute("automatedRefills", autoRefillOriginalOids);
			model.addAttribute("autoRefillOids", autoRefillOids);
			model.addAttribute("refillDate", refillDate);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,
					ERefillConstants.PAGE_NAME_MY_PRESCRIPTIONS);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
					selectedPatientOID);
			model.addAttribute(ERefillConstants.PATIENT_OID,
					sessionManager.getPatientID(eRefillSession));

			model.addAttribute("page_num", prescriptionModel.getPage_num());
			model.addAttribute("sort_by", prescriptionModel.getSort_by());
			model.addAttribute("date_range", prescriptionModel.getDate_range());
			model.addAttribute("from", prescriptionModel.getFrom());
			model.addAttribute("to", prescriptionModel.getTo());

			getGlobalNotification(model, eRefillSession, request);
		} catch (ERefillBusinessException e) {
			LOGGER.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			LOGGER.error(methodName + " Error6: " + e);
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
			LOGGER.error(methodName + " Error: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				LOGGER.error("Exception while redirecting: ", e1);
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return "myPrescriptions";	
	}

	/**
	 * getGlobalNotification
	 * 
	 * @param model
	 * @param eRefillSession
	 * @param request
	 * @return
	 */
	private void getGlobalNotification(ModelMap model,
			ERefillSession eRefillSession, HttpServletRequest request) {
		final String methodName = "getGlobalNotification";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		DataCarrier dto = new DataCarrier();
		try {
			dto.addObject("eRefillSession", eRefillSession);
			XMLGregorianCalendar calendar = prescriptionBusinessDelegate
					.getGlobalNotification(dto);
			SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMMMdd");
			Cookie[] cookies = request.getCookies();
			Cookie globalNotificationCookie = null;
			String lastStateDate = null;
			String notificationclicked = "";
			for (Cookie tmpCookie : cookies) {
				if (tmpCookie.getName().equalsIgnoreCase(
						ERefillConstants.COOKIE_GLOBAL_NOTIFICATION)) {
					globalNotificationCookie = tmpCookie;
				}
			}
			if (calendar != null) {
				Date xmlgrctodate = calendar.toGregorianCalendar().getTime();
				lastStateDate = date_format.format(xmlgrctodate);
			}
			if (globalNotificationCookie != null) {
				notificationclicked = globalNotificationCookie.getValue();
			}
			model.addAttribute("lastStateDate", lastStateDate);
			model.addAttribute("notificationclicked", notificationclicked);
			model.addAttribute("notify", ERefillConstants.COOKIE_CLICKED);

		} catch (Exception e) {
			throw new ERefillApplicationException(e);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
	}
}
