/**
 *
 */
package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.IAccountBusinessDelegate;
import com.lcl.erefill.core.business.IRefillRequestBusinessDelegate;
import com.lcl.erefill.core.business.LoginBusinessDelegate;
import com.lcl.erefill.core.common.telus.response.AccountDetailsResponse;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.RxNewRequest;

/**
 * @author vsha51 version 1.0
 */

@Controller
@SessionAttributes
@RequestMapping("/{locale}/autorefill")
public class AutoRefillController {

	private static final Logger logger = LoggerFactory
			.getLogger(AutoRefillController.class);

	@Autowired
	IRefillRequestBusinessDelegate refillRequestBusinessDelegate;
	
	@Autowired
	IAccountBusinessDelegate accountBusinessDelegate;

	@Autowired
	LoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	SessionManager sessionManager;

	/**
	 * addAutoRefillReminder
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
	public void addAutoRefillReminder(@PathVariable("locale") String locale,
			@RequestBody RxNewRequest rxNewRequest, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "addAutoRefillReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		JSONObject errorJson = new JSONObject();


		int dateRange = 0;
		if (StringUtils.isNotBlank(rxNewRequest.getDateRange())) {
			dateRange = Integer.valueOf(rxNewRequest.getDateRange());
		}


		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);


		rxNewRequest.setLastState("Pending");
		logger.info(methodName + " phone2: " + rxNewRequest.getPhone());

		try {
			if (rxNewRequest.getRefillType()
					.equalsIgnoreCase(ERefillConstants.AUTO_REFILL_REQUEST)) {

				OperationAddResponse operationAddResponse = refillRequestBusinessDelegate
						.addAutomatedRefill(eRefillSession, rxNewRequest,locale);

				errorJson.append("update_status", "error");

				if (null != operationAddResponse
						&& null != operationAddResponse.getUserToken()) {
					logger.info("add webservice status >>> "
							+ operationAddResponse.getUserToken().getStatus());

					if ("ok".equalsIgnoreCase(operationAddResponse
							.getUserToken().getStatus())) {
						logger.info("status is ok >>>> successfully inserted");
						JSONObject json = new JSONObject();
						json.append(ERefillConstants.REFILL_REQUEST_TYPE,ERefillConstants.AUTO_REFILL_REQUEST);
						json.append(ERefillConstants.REFILL_REQUEST_STATUS,"ok");
						json.append(ERefillConstants.REFILL_REQUEST_OID,operationAddResponse.getOid());
						/*if (emailNotify != null
								&& emailNotify.equalsIgnoreCase("on")) {*/
							json.append(ERefillConstants.REFILL_REQUEST_EMAIL,rxNewRequest.getEmail());
						//}
						/*if (phoneNotify != null
								&& phoneNotify.equalsIgnoreCase("on")) {*/
							json.append(ERefillConstants.REFILL_REQUEST_PHONE,rxNewRequest.getPhone());
						//}
						json.append(ERefillConstants.REFILL_REQUEST_DELIVERY_CHOICE,rxNewRequest.getDeliveryChoice());
						if (rxNewRequest.getDeliveryChoice().equalsIgnoreCase(ERefillConstants.DELIVERY)) {
							String deliveryDate = rxNewRequest.getDelReleaseDate();
							XMLGregorianCalendar deldate = null;
							if (deliveryDate != null) {
								if (locale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
								 deldate = CommonUtils.getFormattedFrDate(deliveryDate,ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR);
								}else{
								 deldate = CommonUtils.getDateTimeFormat(deliveryDate);
								}
								json.append(ERefillConstants.REFILL_REQUEST_DATE,CommonUtils.getFormattedDate(deldate,locale));
								//json.append(ERefillConstants.REFILL_REQUEST_DATE,deliveryDate);
							}
						} else if (rxNewRequest.getDeliveryChoice().equalsIgnoreCase(ERefillConstants.PICK_UP)) {
							String strPickupDate = rxNewRequest.getPickReleaseDate();
							logger.debug("The Pic Up Time is ::::::"+strPickupDate);
							XMLGregorianCalendar pickupdate = null;
							if (strPickupDate != null) {
								if (locale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
									pickupdate = CommonUtils.getFormattedFrDate(strPickupDate,ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR);
								}else{
								    pickupdate = CommonUtils.getDateTimeFormat(strPickupDate);
								}
							    logger.info("Time zone in auto refill: "+pickupdate.getTimezone());
								json.append(ERefillConstants.REFILL_REQUEST_DATE,CommonUtils.getFormattedDate(pickupdate,locale));
								//json.append(ERefillConstants.REFILL_REQUEST_DATE,pickupDate);
							}
						}
						/*if (null != operationAddResponse.getUserToken()
								.getToken()) {
							logger.info("telus response >> token is not null >>"
									+ operationAddResponse.getUserToken()
											.getToken());
							json.append(ERefillConstants.TOKEN_VALUE,
									operationAddResponse.getUserToken()
											.getToken());
						}*/
						if (null != operationAddResponse.getUserToken()
								.getStatus()) {
							logger.info("telus response >> status is not null >>"
									+ operationAddResponse.getUserToken()
											.getStatus());
							json.append(ERefillConstants.TOKEN_STATUS,
									operationAddResponse.getUserToken()
											.getStatus());
						}

						setResponseTextAsJson(json, response);
					} else {
						logger.debug("auto refill request submission failed >>>>");
						JSONObject json = new JSONObject();
						json.append(ERefillConstants.REFILL_REQUEST_STATUS,
								"error");
						json.append(ERefillConstants.REFILL_REQUEST_TYPE,
								ERefillConstants.AUTO_REFILL_REQUEST);
						/*if (null != operationAddResponse.getUserToken()
								.getToken()) {
							logger.debug("telus response >> token is not null >>"
									+ operationAddResponse.getUserToken()
											.getToken());
							json.append(ERefillConstants.TOKEN_VALUE,
									operationAddResponse.getUserToken()
											.getToken());
						}*/
						if (null != operationAddResponse.getUserToken()
								.getStatus()) {
							json.append(ERefillConstants.TOKEN_STATUS,
									operationAddResponse.getUserToken()
											.getStatus());
							logger.debug("telus response >> status is not null >>"
									+ operationAddResponse.getUserToken()
											.getStatus());
						}
						json.append(ERefillConstants.ERROR_CODE,
								operationAddResponse.getErrorCode());
						logger.debug("telus response >> error code is >>"
								+ operationAddResponse.getErrorCode());
						setResponseTextAsJson(json, response);
					}

				} else {
					setResponseTextAsJson(errorJson, response);
				}
			} else if (rxNewRequest.getRefillType().equalsIgnoreCase(
					ERefillConstants.REFILL_REMINDER_REQUEST)) {

				OperationAddResponse operationAddResponse = refillRequestBusinessDelegate
						.addRefillReminder(eRefillSession, rxNewRequest,
								dateRange);

				errorJson.append(ERefillConstants.REFILL_REQUEST_STATUS,
						"error");

				if (null != operationAddResponse
						&& null != operationAddResponse.getUserToken()) {
					logger.info("add webservice status >>> "
							+ operationAddResponse.getUserToken().getStatus());

					if ("ok".equalsIgnoreCase(operationAddResponse
							.getUserToken().getStatus())) {
						logger.info("status is ok >>>> successfully inserted");
						// setResponseText("ok", response);
						JSONObject json = new JSONObject();
						json.append(ERefillConstants.REFILL_REQUEST_TYPE,	ERefillConstants.REFILL_REMINDER_REQUEST);
						json.append(ERefillConstants.REFILL_REQUEST_STATUS,	"ok");
						json.append(ERefillConstants.REFILL_REQUEST_DATE, dateRange);
						//if (null != email && !email.isEmpty()) {
							json.append(ERefillConstants.REFILL_REQUEST_EMAIL,
									rxNewRequest.getEmail());
						//}

						if (null != rxNewRequest.getPhone()) {
							json.append(ERefillConstants.REFILL_REQUEST_PHONE,
									rxNewRequest.getPhone());
						}

						/*json.append(ERefillConstants.TOKEN_VALUE,
								operationAddResponse.getUserToken().getToken());*/
						json.append(ERefillConstants.TOKEN_STATUS,
								operationAddResponse.getUserToken().getStatus());
						setResponseTextAsJson(json, response);
					} else {
						logger.debug("refill reminder request submission failed >>>>");
						JSONObject json = new JSONObject();
						json.append(ERefillConstants.REFILL_REQUEST_STATUS,
								"error");
						json.append(ERefillConstants.REFILL_REQUEST_TYPE,
								ERefillConstants.REFILL_REMINDER_REQUEST);
						if (operationAddResponse.getErrorCode() != 0) {
							json.append(ERefillConstants.ERROR_CODE,
									operationAddResponse.getErrorCode());
							logger.debug("telus response >> error code is >>"
									+ operationAddResponse.getErrorCode());
						}
						/*if (null != operationAddResponse.getUserToken()
								.getToken()) {
							logger.debug("telus response >> token is not null >>"
									+ operationAddResponse.getUserToken()
											.getToken());
							json.append(ERefillConstants.TOKEN_VALUE,
									operationAddResponse.getUserToken()
											.getToken());
						}*/
						if (null != operationAddResponse.getUserToken()
								.getStatus()) {
							json.append(ERefillConstants.TOKEN_STATUS,
									operationAddResponse.getUserToken()
											.getStatus());
							logger.debug("telus response >> status is not null >>"
									+ operationAddResponse.getUserToken()
											.getStatus());
						}
						setResponseTextAsJson(json, response);
					}

				} else {
					setResponseTextAsJson(errorJson, response);
				}
			}
			
		/*	String selectedPatientName=null;
			List<AssignedPatientResponse> assignedPatientsList=sessionManager.getAssignedPatients(eRefillSession);
			
			for(AssignedPatientResponse assignedPatientObj : assignedPatientsList){
				if(sessionManager.getSelectedPatientOID(eRefillSession).equalsIgnoreCase(assignedPatientObj.getPatientOID())){
					selectedPatientName=assignedPatientObj.getFirstName()+assignedPatientObj.getLastName()+"("+assignedPatientObj.getBirthYear()+")";
					break;
				}
					
			}
			
			model.addAttribute("selectedPatientName", selectedPatientName);*/
			
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
					sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_USER_FULLNAME,
					sessionManager.getName(eRefillSession));
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
					sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
					sessionManager.getPendingCustodianRequests(eRefillSession));
			model.addAttribute(ERefillConstants.PATIENT_OID,
					sessionManager.getPatientID(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
					sessionManager.getSelectedPatientOID(eRefillSession));
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute("emailStatus", rxNewRequest.getEmailStatus());
			model.addAttribute("account", rxNewRequest.getEmail());
			model.addAttribute(ERefillConstants.REFILL_REQUEST_TYPE, rxNewRequest.getRefillType());
			model.addAttribute("phoneNo", rxNewRequest.getPhone());
		}catch (ERefillBusinessException e) {
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
			
		}catch (Exception e) {
			e.printStackTrace();
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext +"/home/" + locale	+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}




	/**
	 * updateAutoRefillConfirm
	 *
	 * @param locale
	 * @param mode
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateAutoRefillConfirm(@PathVariable("locale") String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "updateAutoRefillConfirm";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		String mobilenotifypresc = request.getParameter("mobilenotifypresc");
		String mobilenotifyuser = request.getParameter("mobilenotifyuser");
		String emailnotifypresc = request.getParameter("emailnotifypresc");
		String emailnotifyuser = request.getParameter("emailnotifyuser");
		String notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_OUT;
		String email = null;
		String phone = null;
		if (mobilenotifyuser != null && mobilenotifyuser.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			phone = request.getParameter("mobileuser");
		} else if (mobilenotifypresc != null
				&& mobilenotifypresc.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			phone = request.getParameter("mobilepresc");
		}
		if (emailnotifyuser != null && emailnotifyuser.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			email = request.getParameter("emailuser");
		} else if (emailnotifypresc != null
				&& emailnotifypresc.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			email = request.getParameter("emailpresc");
		}
		String oid = request.getParameter(ERefillConstants.AUTO_REFILL_OID);
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		AutoRefillReminderRequest autoRefillReminderRequest = new AutoRefillReminderRequest();
		autoRefillReminderRequest.setEmail(email);
		autoRefillReminderRequest.setPhone(phone);

		OperationAddResponse opAddResponse = refillRequestBusinessDelegate
				.updateAutoRefillReminder(eRefillSession,
						autoRefillReminderRequest, oid);

		JSONObject errorJson = new JSONObject();
		try {
			errorJson.append(ERefillConstants.REFILL_REQUEST_STATUS,
					"error");

			if (null != opAddResponse) {
				//String token = opAddResponse.getUserToken().getToken();
				String status = opAddResponse.getUserToken().getStatus();

				logger.info("Update webservice status >>> " + status);

				if ("ok".equalsIgnoreCase(status)) {
					logger.info("status is ok >>>> successfully updated");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_TYPE,
							ERefillConstants.AUTO_REFILL_REQUEST);
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "ok");
					json.append(ERefillConstants.UPDATE_TYPE, notify);
					if (notify
							.equalsIgnoreCase(ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN)) {
						if (phone != null) {
							json.append(ERefillConstants.REFILL_REQUEST_PHONE,
									phone);
						}
						if (email != null) {
							json.append(ERefillConstants.REFILL_REQUEST_EMAIL,
									email);
						}
					}
					/*if (null != token) {
						logger.info("telus response >> token is not null >>"
								+ token);
						json.append(ERefillConstants.TOKEN_VALUE, token);
					}*/
					if (null != status) {
						json.append(ERefillConstants.TOKEN_STATUS, status);
					}
					setResponseTextAsJson(json, response);

				} else {
					logger.debug("auto refill request update failed >>>>");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "error");
					/*if (null != token) {
						json.append(ERefillConstants.TOKEN_VALUE, token);
					}*/
					if (null != status) {
						json.append(ERefillConstants.TOKEN_STATUS, status);
					}
					setResponseTextAsJson(json, response);
				}

			} else {
				setResponseTextAsJson(errorJson, response);
			}
		} catch (JSONException e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		model.addAttribute("updateType", notify);
		model.addAttribute("account", email);
		model.addAttribute("phone", phone);
		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
			}

	/**
	 * autoRefillOptOut
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/optout", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView autoRefillOptOut(@PathVariable("locale") String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "autoRefillOptOut";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		/*String mobilenotifypresc = request.getParameter("mobilenotifypresc");
		String mobilenotifyuser = request.getParameter("mobilenotifyuser");
		String emailnotifypresc = request.getParameter("emailnotifypresc");
		String emailnotifyuser = request.getParameter("emailnotifyuser");

		String notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_OUT;
		String email = null;
		String phone = null;
		if (mobilenotifyuser != null && mobilenotifyuser.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			phone = request.getParameter("mobileuser");
		} else if (mobilenotifypresc != null
				&& mobilenotifypresc.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			phone = request.getParameter("mobilepresc");
		}
		if (emailnotifyuser != null && emailnotifyuser.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			email = request.getParameter("emailuser");
		} else if (emailnotifypresc != null
				&& emailnotifypresc.equalsIgnoreCase("on")) {
			notify = ERefillConstants.AUTO_REFILL_UPDATE_OPT_IN;
			email = request.getParameter("emailpresc");
		}

		model.addAttribute("updateType", notify);
		model.addAttribute("account", email);
		model.addAttribute("phone", phone);
		model.addAttribute("locale", locale);*/

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-auto-opted-in");
	}

	/**
	 * updateAutoRefillView
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/reminder/update/{oid}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updateAutoRefillView(
			@PathVariable("locale") String locale,
			@PathVariable("oid") String oid, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "updateAutoRefillView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		String userRole = sessionManager.getUserRole(eRefillSession);
		if(!userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
			Map<String, String> updateAutoRefillMap = refillRequestBusinessDelegate
					.updateAutoRefillView(eRefillSession, oid);
			model.addAttribute("emailId", updateAutoRefillMap.get("emailId"));
			model.addAttribute("emailStatus", updateAutoRefillMap.get("emailStatus"));
			model.addAttribute("mobileNumber", updateAutoRefillMap.get("mobileNumber"));
			model.addAttribute("mobileStatus", updateAutoRefillMap.get("mobileStatus"));
			model.addAttribute("selectedEmail", updateAutoRefillMap.get("selectedEmail"));
			model.addAttribute("selectedPhone", updateAutoRefillMap.get("selectedPhone"));
		}else{
			AccountDetailsResponse accountDetailsResponse = null;
			String appContext = request.getContextPath();
			
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
		}

		model.addAttribute(ERefillConstants.USER_ROLE, userRole);
		model.addAttribute("locale", locale);
		model.addAttribute("oid", oid);
		
		
		

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-update-auto-refill");
	}

	/**
	 * stopAutoRefillView
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/stop/confirm", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView stopAutoRefillView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "stopAutoRefillView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-stop-auto-refill");
	}

	/**
	 * stopAutoRefill
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/stop", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void stopAutoRefill(@PathVariable("locale") String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "stopAutoRefill";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		JSONObject errorJson = new JSONObject();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String prescOID = request.getParameter("prescOID");
		try {
			errorJson.append(ERefillConstants.REFILL_REQUEST_STATUS,
					"exception");
			OperationAddResponse opAddResponse = refillRequestBusinessDelegate
					.deleteAutomatedRefill(eRefillSession, prescOID);

			if (null != opAddResponse) {
				logger.info("stop auto refill webservice status >>> "
						+ opAddResponse.getUserToken().getStatus());

				if ("ok".equalsIgnoreCase(opAddResponse.getUserToken()
						.getStatus())) {
					logger.info("status is ok >>>> successfully stopped");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_TYPE,
							ERefillConstants.AUTO_REFILL_REQUEST);
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "ok");
					json.append(ERefillConstants.UPDATE_TYPE, "stop");
					/*if (null != opAddResponse.getUserToken().getToken()) {
						logger.info("telus response >> token is not null >>"
								+ opAddResponse.getUserToken().getToken());
						json.append(ERefillConstants.TOKEN_VALUE, opAddResponse
								.getUserToken().getToken());
					}*/
					if (null != opAddResponse.getUserToken().getStatus()) {
						logger.info("telus response >> status is not null >>"
								+ opAddResponse.getUserToken().getStatus());
						json.append(ERefillConstants.TOKEN_STATUS,
								opAddResponse.getUserToken().getStatus());
					}

					setResponseTextAsJson(json, response);

				} else {
					logger.debug("auto refill request submission failed >>>>");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "error");
					json.append(ERefillConstants.REFILL_REQUEST_TYPE,
							ERefillConstants.AUTO_REFILL_REQUEST);
					/*if (null != opAddResponse.getUserToken().getToken()) {
						logger.debug("telus response >> token is not null >>"
								+ opAddResponse.getUserToken().getToken());
						json.append(ERefillConstants.TOKEN_VALUE, opAddResponse
								.getUserToken().getToken());
					}*/
					if (null != opAddResponse.getUserToken().getStatus()) {
						json.append(ERefillConstants.TOKEN_STATUS,
								opAddResponse.getUserToken().getStatus());
						logger.debug("telus response >> status is not null >>"
								+ opAddResponse.getUserToken().getStatus());
					}
					setResponseTextAsJson(json, response);
				}
			} else {
				setResponseTextAsJson(errorJson, response);
			}
		}catch (ERefillBusinessException e) {
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
				String redirect = appContext +"/home/" + locale	+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		model.addAttribute("locale", locale);
		model.addAttribute("prescOID", prescOID);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}

	/**
	 * stopRefillReminderView
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/reminder/stop/confirm", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView stopRefillReminderView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "stopRefillReminderView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String selectedPatientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		}
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-stop-refill-reminders");
	}

	/**
	 * stopRefillReminder
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reminder/stop", method = {RequestMethod.POST, RequestMethod.GET})
	public void stopRefillReminder(@PathVariable("locale") String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "stopRefillReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		JSONObject errorJson = new JSONObject();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String prescOID = request.getParameter("prescOID");
		try {
			errorJson.append(ERefillConstants.REFILL_REQUEST_STATUS,
					"exception");
			OperationAddResponse opAddResponse = refillRequestBusinessDelegate
					.deleteRefillReminder(eRefillSession, prescOID);

			if (null != opAddResponse) {
				logger.info("stop refill reminder webservice status >>> "
						+ opAddResponse.getUserToken().getStatus());

				if ("ok".equalsIgnoreCase(opAddResponse.getUserToken()
						.getStatus())) {
					logger.info("status is ok >>>> successfully stopped");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_TYPE,
							ERefillConstants.REFILL_REMINDER_REQUEST);
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "ok");
					json.append(ERefillConstants.UPDATE_TYPE, "stop");
					/*if (null != opAddResponse.getUserToken().getToken()) {
						logger.info("telus response >> token is not null >>"
								+ opAddResponse.getUserToken().getToken());
						json.append(ERefillConstants.TOKEN_VALUE, opAddResponse
								.getUserToken().getToken());
					}*/
					if (null != opAddResponse.getUserToken().getStatus()) {
						logger.info("telus response >> status is not null >>"
								+ opAddResponse.getUserToken().getStatus());
						json.append(ERefillConstants.TOKEN_STATUS,
								opAddResponse.getUserToken().getStatus());
					}

					setResponseTextAsJson(json, response);

				} else {
					logger.debug("auto refill request submission failed >>>>");
					JSONObject json = new JSONObject();
					json.append(ERefillConstants.REFILL_REQUEST_STATUS, "error");
					json.append(ERefillConstants.REFILL_REQUEST_TYPE,
							ERefillConstants.REFILL_REMINDER_REQUEST);
					/*if (null != opAddResponse.getUserToken().getToken()) {
						logger.debug("telus response >> token is not null >>"
								+ opAddResponse.getUserToken().getToken());
						json.append(ERefillConstants.TOKEN_VALUE, opAddResponse
								.getUserToken().getToken());
					}*/
					if (null != opAddResponse.getUserToken().getStatus()) {
						json.append(ERefillConstants.TOKEN_STATUS,
								opAddResponse.getUserToken().getStatus());
						logger.debug("telus response >> status is not null >>"
								+ opAddResponse.getUserToken().getStatus());
					}
					setResponseTextAsJson(json, response);
				}
			} else {
				setResponseTextAsJson(errorJson, response);
			}
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error1: " + e);
			throw e;
		}  catch (Exception e) {
			logger.error("Exception: " + e);
			loginBusinessDelegate.logOut(null, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		model.addAttribute("locale", locale);
		model.addAttribute("prescOID", prescOID);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}

	/**
	 * autoRefillUpdateErrorView : Error from the overlays: stop-auto-reminder and update-auto-reminder overlays
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/updateerror", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView autoRefillUpdateErrorView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "autoRefillUpdateErrorView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-auto-refill-error");
	}

	/**
	 * autoRefillErrorView
	 *
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/error", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView autoRefillErrorView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "autoRefillErrorView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		model.addAttribute("locale", locale);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-auto-refill-error");
	}

	/**
	 * setResponseTextAsJson
	 *
	 * @param responseMessage
	 * @param response
	 */
	public void setResponseTextAsJson(JSONObject responseMessage,
			HttpServletResponse response) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(responseMessage.toString());
		} catch (IOException ioExcep) {
			throw new ERefillApplicationException(ioExcep);
		}
	}
}
