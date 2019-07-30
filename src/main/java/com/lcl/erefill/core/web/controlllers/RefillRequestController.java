/**
 * 
 */
package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.IAccountBusinessDelegate;
import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.IRefillRequestBusinessDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.RxNewRequest;

/**
 * @author hkokel version 1.0
 */
@Controller
@SessionAttributes
@RequestMapping("/{locale}/refillrequest")
public class RefillRequestController {

	private static final Logger logger = LoggerFactory
			.getLogger(RefillRequestController.class);

	@Autowired
	IRefillRequestBusinessDelegate refillRequestBD;

	@Autowired
	IAccountBusinessDelegate accountBusinessDelegate;

	@Autowired
	ILoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	SessionManager sessionManager;

	/**
	 * refillRequestView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/view", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView refillRequestView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "refillRequestView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		List<String> lstChkdPresc = new ArrayList<String>();
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String appContext = request.getContextPath();
		DataCarrier dto = new DataCarrier();
		String page = "refillrequest";
		String userRole = sessionManager.getUserRole(eRefillSession);
		String refillType=null;
		
		if(request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE)==null)		
			refillType=sessionManager.getRefillType(eRefillSession);
		Enumeration<String> paramNames = request.getParameterNames();
		
		try {
			if (request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE)!="" && request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE)!= null && !request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE).equalsIgnoreCase(ERefillConstants.NORMAL_REFILL_REQUEST)) {
				String[] refill = request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE).split(ERefillConstants.SPLIT_CHAR);
				logger.info("refill type:" + refill[0] + "|PrescriptionOID:"+ refill[1]);
				lstChkdPresc.add(refill[1]);
				PharmaDeptVO pharmaDeptVO = sessionManager.getPharmacyDetails(eRefillSession);
				
				if (pharmaDeptVO != null && pharmaDeptVO.getPharmaVO() != null) {
					dto.addObject(ERefillConstants.STOREID, pharmaDeptVO.getPharmaVO().getStoreId());
				}
				if (refill[0].contains(ERefillConstants.AUTO_REFILL_REQUEST)) {
						dto.addObject(ERefillConstants.REFILL_REQUEST_TYPE,	ERefillConstants.AUTO_REFILL_REQUEST);
						model.addAttribute(ERefillConstants.REFILL_REQUEST_TYPE, ERefillConstants.AUTO_REFILL_REQUEST);
						page = "autoRefill";
				} else if (request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE).contains(ERefillConstants.REFILL_REMINDER_REQUEST)) {
						dto.addObject(ERefillConstants.REFILL_REQUEST_TYPE,	ERefillConstants.REFILL_REMINDER_REQUEST);
						model.addAttribute(ERefillConstants.REFILL_REQUEST_TYPE, ERefillConstants.REFILL_REMINDER_REQUEST);
						page = "autoRefill";
				}
				sessionManager.setRefillType(refill[0], eRefillSession);
			} else if(refillType!=null){			
				if (refillType.contains(ERefillConstants.AUTO_REFILL_REQUEST)) {
					dto.addObject(ERefillConstants.REFILL_REQUEST_TYPE,	ERefillConstants.AUTO_REFILL_REQUEST);
					model.addAttribute(ERefillConstants.REFILL_REQUEST_TYPE, ERefillConstants.AUTO_REFILL_REQUEST);
					page = "autoRefill";
				} else if (refillType.contains(ERefillConstants.REFILL_REMINDER_REQUEST)) {
					dto.addObject(ERefillConstants.REFILL_REQUEST_TYPE,	ERefillConstants.REFILL_REMINDER_REQUEST);
					model.addAttribute(ERefillConstants.REFILL_REQUEST_TYPE, ERefillConstants.REFILL_REMINDER_REQUEST);
					page = "autoRefill";
				}
			}
			
			/* to retain selected prescription across pages: *******************************/
			if(request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE)!=null && request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE).equalsIgnoreCase(ERefillConstants.NORMAL_REFILL_REQUEST)){
				Set<String> selectedPrescFromPages=sessionManager.getSelectedPresc(eRefillSession);
				if(selectedPrescFromPages!=null){
					for(String pres: selectedPrescFromPages){
						if(!lstChkdPresc.contains(pres)){
							lstChkdPresc.add(pres);
						}
					}
				}
			}
			if(paramNames.hasMoreElements()){
				while(paramNames.hasMoreElements()) {
						boolean selected = false;
						String chkBoxName = paramNames.nextElement();
						selected = Boolean.parseBoolean(request
								.getParameter(chkBoxName));
						if (selected) {
							if (!lstChkdPresc.contains(chkBoxName)) {
								lstChkdPresc.add(chkBoxName);
							}
						
						}
				}
				refillType=request.getParameter(ERefillConstants.REFILL_REQUEST_TYPE);
				sessionManager.setRefillType(refillType, eRefillSession);
				sessionManager.setListCheckedPresc(lstChkdPresc, eRefillSession);
			}else{
				lstChkdPresc=sessionManager.getListCheckedPresc(eRefillSession);
			}
			
			sessionManager.setSelectedPresc(null, eRefillSession);
			model.addAttribute("page_num", request.getParameter("page_num"));
			dto.addObject(ERefillConstants.EREFILL_SESSION, eRefillSession);
			dto.addObject(ERefillConstants.REFILL_REQUEST_CHKDPRESC, lstChkdPresc);
			dto.addObject(ERefillConstants.REQUEST_LOCALE, locale);
			dto = refillRequestBD.refillRequest(dto);
			model.addAttribute(ERefillConstants.DEL_OPERATING_HOURS, dto.getObject(ERefillConstants.DEL_OPERATING_HOURS));
			model.addAttribute(ERefillConstants.OPERATINGHOURS, dto.getObject(ERefillConstants.OPERATINGHOURS));
			model.addAttribute(ERefillConstants.REFILL_REQUEST_PRESC, dto.getObject(ERefillConstants.REFILL_REQUEST_PRESC));
			model.addAttribute(ERefillConstants.REFILL_REQUEST_PATIENT,	dto.getObject(ERefillConstants.REFILL_REQUEST_PATIENT));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
			List<AssignedPatientResponse> assignedPatients = sessionManager.getAssignedPatients(eRefillSession);
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, assignedPatients);
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(eRefillSession));
			model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
			String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
			String name = "";
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
				isLoggedInUser = false;
				for (AssignedPatientResponse assignedPatientResponse : assignedPatients) {
					if(assignedPatientResponse.getPatientOID().equalsIgnoreCase(selectedPatientOID)){
						name = assignedPatientResponse.getFirstName();
						break;
					}
				}
				
			}
	        model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
			model.addAttribute("name", name);
	        model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, selectedPatientOID);
			Map<String, String> emailStatus = (Map<String, String>) dto.getObject(ERefillConstants.REFILL_REQUEST_ACCOUNTMAP);
			model.addAttribute("emailStatus", emailStatus.get("status"));
			model.addAttribute("account", emailStatus.get("mailid"));
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute ("mobileNumber", dto.getObject("mobileNumber"));
			model.addAttribute ("mobileStatus", dto.getObject("mobileStatus"));
			
			//List<AutomatedRefillCalendar> pickUpCalendarList = (List<AutomatedRefillCalendar>) dto.getObject("pickupDates");
			//List<String> pickUpDates = getFormattedDateList(pickUpCalendarList,	locale);
			/* String pickUpDate=null;
			 String deliveryDate=null;
			 XMLGregorianCalendar nextDatePickUp=null;
			 XMLGregorianCalendar nextDateDelivery=null;*/
			
			 /************************************/
			/*List<AutomatedRefillCalendar> pickUpExpectedDate=(List<AutomatedRefillCalendar>) dto.getObject("pickupDates");
			if(pickUpExpectedDate!=null){
				List<ExpectedEvent> pickUpExpectedEvent =  pickUpExpectedDate.get(0).getExpectedEvents().getExpectedEvent();
				if(pickUpExpectedEvent != null &&  !pickUpExpectedEvent.isEmpty() && pickUpExpectedDate.get(0) != null ) {
					nextDatePickUp = CommonUtils.getNextDate(pickUpExpectedEvent);
					logger.info("Time zone in refill controller: "+nextDatePickUp.getTimezone());
	                if(nextDatePickUp != null) {
	                	 pickUpDate=CommonUtils.getFormattedDate(nextDatePickUp, locale);
	                }
				}
			}*/
            /****************************************************/
			//List<AutomatedRefillCalendar> deliveryCalendarList = (List<AutomatedRefillCalendar>) dto.getObject("deliveryDates");
			//List<String> deliveryDates = getFormattedDateList(deliveryCalendarList, locale);
			
			/**************************************************/
			
			/*List<AutomatedRefillCalendar> deliveryExpectedDate=(List<AutomatedRefillCalendar>) dto.getObject("deliveryDates");
			if(deliveryExpectedDate!=null){
				List<ExpectedEvent> deliveryExpectedEvent =  deliveryExpectedDate.get(0).getExpectedEvents().getExpectedEvent();
				if(deliveryExpectedEvent != null &&  !deliveryExpectedEvent.isEmpty() && deliveryExpectedEvent.get(0) != null ) {
					nextDateDelivery = CommonUtils.getNextDate(deliveryExpectedEvent);
	                if(nextDateDelivery != null) {
	                	deliveryDate=CommonUtils.getFormattedDate(nextDateDelivery, locale);
	                }
				}
			}*/
            /****************************************************/
			
			
			model.addAttribute("pickUpDate", dto.getObject("pickupDates"));
			model.addAttribute("deliveryDate", dto.getObject("deliveryDates"));
			model.addAttribute("pickUpDateValue", dto.getObject("pickupDates"));
			model.addAttribute("deliveryDateValue", dto.getObject("deliveryDates"));
						
			/*if(nextDatePickUp!=null){
				model.addAttribute("pickUpDateValue", nextDatePickUp.toString());
			}
			if(nextDateDelivery!=null){
				model.addAttribute("deliveryDateValue", nextDateDelivery.toString());
			}*/
			
			AccountDetailsResponse accountDetailsResponse = null;
			
			if(userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				try {
					accountDetailsResponse = accountBusinessDelegate.getMyAccountDetails(eRefillSession, null);
					if (accountDetailsResponse.getUserToken() == null) {
						throw new Exception("User Token Expired");
					}
					String mailId = accountDetailsResponse.getAccountPreferenceVO().getMailId();
					if(mailId==null || mailId.isEmpty()){
						mailId="";
					}
					model.addAttribute("account", mailId);
					model.addAttribute("emailStatus", "ok");
					sessionManager.setToken(accountDetailsResponse.getUserToken(), eRefillSession);
					
					
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
		return new ModelAndView(page);

	}

	/**
	 * submitRefillRequest
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST,headers = {
			"Accept=application/json",
			"Content-Type=application/json" })
	public void submitRefillRequest(@PathVariable("locale") String locale,
			@RequestBody RxNewRequest rxNewRequest, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
	
		final String methodName = "submitRefillRequest";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		//RxRenewPrescriptions renewPrescs = new RxRenewPrescriptions();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		rxNewRequest.setLastState("Pending");
		
		/*String[] lstOID = request.getParameterValues("medOID");
		String[] lstCommnets = request.getParameterValues("drug_id_here");
		
		if (null != lstOID && null != lstCommnets) {
			logger.debug("medicine oid and comments are not null >>>");

			for (int i = 0; i < lstOID.length; i++) {
				RxRenewPrescription presc = new RxRenewPrescription();
				presc.setOid(lstOID[i]);
				logger.debug("Medicine OID>>>" + lstOID[i]);
				if (StringUtils.isNotBlank(lstCommnets[i])) {
					presc.setComments(lstCommnets[i]);
					logger.debug("Prescription comments>>>>" + lstCommnets[i]);
				} else {
					presc.setComments(" ");
				}
				renewPrescs.getRxRenewPrescription().add(presc);
			}
		}*/
		
		//renewPrescs=rxNewRequest.getPrescriptions();

		//rxNewRequest.setPrescriptions(renewPrescs);
		DataCarrier dto = new DataCarrier();
		try {
			dto.addObject(ERefillConstants.REFILL_REQUEST_PATIENTOID, rxNewRequest.getPatientOID());
			
			
			dto.addObject(ERefillConstants.STOREID,	rxNewRequest.getStoreId());
			dto.addObject(ERefillConstants.DELDEPARTMENTID,	rxNewRequest.getFreeDelDeptId());

			dto.addObject(ERefillConstants.REFILL_REQUEST_RX, rxNewRequest);
			dto.addObject(ERefillConstants.EREFILL_SESSION, eRefillSession);
			dto = refillRequestBD.refillRequestSubmit(dto);			
			if (dto.getObject(ERefillConstants.REFILL_REQUEST_JSON) != null) {
				setResponseTextAsJson(
						(String) dto
								.getObject(ERefillConstants.REFILL_REQUEST_JSON),
						response);
			}
			if (logger.isDebugEnabled()) {
				logger.debug(methodName + " Exiting");
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
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
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
				String redirect = appContext +"/home/" + locale + "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}		
	}

	/**
	 * setResponseTextAsJson
	 * 
	 * @param responseMessage
	 * @param response
	 */
	public static void setResponseTextAsJson(String responseMessage,
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
	 * getRefillSuccessView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/submit/success")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRefillSuccessView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getRefillSuccessView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		ERefillSession eRefillSession = (ERefillSession)request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
			for (AssignedPatientResponse patient : sessionManager.getAssignedPatients(eRefillSession)) {
				if (patient.getPatientOID().equalsIgnoreCase(selectedPatientOID)){
					 model.addAttribute("name", patient.getFirstName());
					 break;
				}
					
			}
		}
		
        model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		sessionManager.setSelectedPresc(null, eRefillSession);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-refill-request-success");
	}

	/**
	 * getRefillFailureView
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/submit/failure")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRefillFailureView(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getRefillFailureView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		ERefillSession eRefillSession = (ERefillSession)request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
			for (AssignedPatientResponse patient : sessionManager.getAssignedPatients(eRefillSession)) {
				if (patient.getPatientOID().equalsIgnoreCase(selectedPatientOID)){
					 model.addAttribute("name", patient.getFirstName());
					 break;
				}
					
			}
	        
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-refill-request-error");
	}

	/**
	 * getAutoRefillStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/autorefill/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getAutoRefillStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getAutoRefillStatus";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		String date = request.getParameter("date");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deliveryChoice = request.getParameter("deliveryChoice");		
		
		ERefillSession eRefillSession = (ERefillSession)request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		}
        model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
        
		String view = null;
		if(status.equalsIgnoreCase("success")){
			view = "overlay-auto-refill-success";
			model.addAttribute("deliveryChoice", deliveryChoice);
			model.addAttribute("date", date);
			model.addAttribute("email", email);
			model.addAttribute("mobile", phone);
		} else {
			view = "overlay-auto-refill-error";
		}
		
		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(view);
	}
	
	/**
	 * getRefillReminderStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/refillreminder/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRefillReminderStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getRefillReminderStatus";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		String email = request.getParameter("email");
		String mobile = request.getParameter("phone");
		
		ERefillSession eRefillSession = (ERefillSession)request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		}
        model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
        
		String view = null;
		if(status.equalsIgnoreCase("success")){
			view = "overlay-refill-reminder-success";
			model.addAttribute("email", email);
			model.addAttribute("mobile", mobile);
		} else {
			view = "overlay-refill-reminder-error";
		}
		
		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(view);
	}

	/**
	 * getRefillRequestStatus
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/refill/{status}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView getRefillRequestStatus(@PathVariable String locale,
			@PathVariable String status,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getRefillRequestStatus";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		String name = request.getParameter("name");
		
		ERefillSession eRefillSession = (ERefillSession)request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		}
        model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
        
		String view = null;
		if(status.equalsIgnoreCase("success")){
			view = "overlay-refill-request-success";
			model.addAttribute("name", name);
		} else {
			view = "overlay-refill-request-error";
		}
		
		// Enable cross domain calls
		
		model.addAttribute("locale", locale);
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView(view);
	}
	
	/**
	 * getFormattedDateList
	 * 
	 * @param list
	 * @return dateList
	 *//*
	private List<String> getFormattedDateList(
			List<AutomatedRefillCalendar> list, String locale) {
		List<String> dateList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			logger.info("list size: " + list.size());
			AutomatedRefillCalendar automatedRefillCalendar = list.get(0);
			List<ExpectedEvent> expectedEventList = automatedRefillCalendar
					.getExpectedEvents().getExpectedEvent();
			if (expectedEventList != null && expectedEventList.size() > 0) {
				logger.info("list size: " + expectedEventList.size());
				Iterator<ExpectedEvent> itr = expectedEventList.iterator();
				while (itr.hasNext()) {
					ExpectedEvent event = itr.next();
					String date = CommonUtils.getFormattedDate(event.getDate(),
							locale);
					dateList.add(date);
				}
			}
		}
		return dateList;
	}*/
}
