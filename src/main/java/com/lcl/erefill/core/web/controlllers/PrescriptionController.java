package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.ILoginBusinessDelegate;
import com.lcl.erefill.core.business.IPharmacyBusinessDelegate;
import com.lcl.erefill.core.business.IPrescriptionBusinessDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.common.entity.RefillPrescriptionVO;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordDetailResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordResponse;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.common.telus.response.RefillHistoryResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.DrugHeaderView;
import com.lcl.erefill.core.vo.DrugInformation;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.MedicationRecordDetailModel;
import com.lcl.erefill.core.vo.MedicationRecordModel;
import com.lcl.erefill.core.vo.OrderHistoryModel;
import com.lcl.erefill.core.vo.PrescriptionModel;

@Controller
public class PrescriptionController {

	private static final Logger log = LoggerFactory
			.getLogger(PrescriptionController.class);

	@Autowired
	SessionManager sessionManager;

	@Autowired
	IPharmacyBusinessDelegate pharmaBusinessDelegate;

	@Autowired
	ILoginBusinessDelegate loginBusinessDelegate;

	@Autowired
	IPrescriptionBusinessDelegate prescriptionBusinessDelegate;

	/**
	 * getCaregiverPrescriptionDetails
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST , RequestMethod.GET}, value = "/{locale}/caregiver/prescription/details")
	public String getCaregiverPrescriptionDetails(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getPrescriptionDetails";
		String appContext = request.getContextPath();
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.USER_ROLE, sessionManager.getUserRole(eRefillSession));
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME, sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_PRESCRIPTION_PAGE_TITLE);
		String useRole= sessionManager.getUserRole(eRefillSession);
		UserToken userTokn= sessionManager.getToken(eRefillSession);
		if(log.isDebugEnabled()){
			log.debug("the token 0.5 is:---------->>>>" +userTokn);
		}
		
		DataCarrier dto = new DataCarrier();
		
		/******************************************************************/
		PrescriptionModel prescriptionModel=new PrescriptionModel();
		prescriptionModel.setDate_range(request.getParameter("date_range"));
		prescriptionModel.setPage_num(request.getParameter("page_num"));
		prescriptionModel.setFrom(request.getParameter("from"));
		prescriptionModel.setTo(request.getParameter("to"));
		prescriptionModel.setSort_by(request.getParameter("sort_by"));
		/******************************************************************/
		
		if(useRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER) && (sessionManager.getPatientID(eRefillSession)==(null))){
			sessionManager.setPatientID(ERefillConstants.CARE_GIVER+ERefillConstants.CARE_GIVER,eRefillSession);
		}
		if(useRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
			String requestCurrentAccount= request.getParameter("current-account");
			String selectedPatientIDSession= sessionManager.getSelectedPatientOID(eRefillSession);
			if(requestCurrentAccount!=null){
				sessionManager.setSelectedPatientOID(requestCurrentAccount, eRefillSession);
			}else if(selectedPatientIDSession==null || 
					(selectedPatientIDSession.equalsIgnoreCase(ERefillConstants.CARE_GIVER) && requestCurrentAccount==null)){
				sessionManager.setSelectedPatientOID(ERefillConstants.CARE_GIVER, eRefillSession);
			}
		}

		try {
			dto.addObject(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
			dto.addObject(ERefillConstants.LOGIN_MODEL, model);
			dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,	eRefillSession);
			dto.addObject("prescriptionModel", prescriptionModel);
			dto.addObject(ERefillConstants.MAP_KEY_LOCALE, locale);
			if (StringUtils.isNotBlank(sessionManager.getSelectedPatientOID(eRefillSession)) 
					&& !sessionManager.getSelectedPatientOID(eRefillSession).equalsIgnoreCase(ERefillConstants.CARE_GIVER)) {
				dto.addObject(ERefillConstants.SELECTED_PATIENT_OID,sessionManager.getSelectedPatientOID(eRefillSession));
				if(sessionManager.getPatientID(eRefillSession)==null){
					dto.addObject(ERefillConstants.PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
				}
			} 
			/*StringUtils.isBlank(sessionManager.getSelectedPatientOID(eRefillSession)))
			&& useRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)*/
			else if(sessionManager.getSelectedPatientOID(eRefillSession).equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				/*sessionManager.setPatientID(ERefillConstants.CARE_GIVER+ERefillConstants.CARE_GIVER,eRefillSession);
				sessionManager.setSelectedPatientOID(ERefillConstants.CARE_GIVER, eRefillSession);
				*/sessionManager.setToken(userTokn, eRefillSession);
			}

			//String patientId= sessionManager.getPatientID(eRefillSession);
			String selectedPatientOid= (String) dto.getObject(ERefillConstants.SELECTED_PATIENT_OID);
			
			if(!selectedPatientOid.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				
				//prescriptionBusinessDelegate.processToMyPrescription(dto);
				PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.processToMyPrescription(dto);
				
				List<Object> parameterList = prescriptionBusinessDelegate.getPrescRequestParameterList(dto);
				log.debug("parameters::" + parameterList);			
				//PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.getPrescriptionList(dto, parameterList, locale);
				List<PrescriptionsBO> userPresBO = prescriptionFilterResponse.getLstPresc();
				List<String> autoRefillOriginalOids = new ArrayList<String>();
				List<String> autoRefillOids = new ArrayList<String>();
				List<String> refillDate = new ArrayList<String>();
				log.info("RefillDate::::" + refillDate);
				
				if (userPresBO!=null) {
					Iterator<PrescriptionsBO> itrUserPresBO = userPresBO
							.iterator();
					while (itrUserPresBO.hasNext()) {
						PrescriptionsBO prescrBO = itrUserPresBO.next();
						int isAllowed = prescrBO.getAutomatedRefillAllowed();

						if (isAllowed >= 2) {
							String opEventOid = prescrBO
									.getOperationalEventOid();
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
						int isRefillRemainder = prescrBO
								.getRefillReminderAllowed();

						if (isRefillRemainder >= 2) {
							String opEventOid = prescrBO
									.getOperationalEventOid();
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
				model.addAttribute("automatedRefills", autoRefillOriginalOids);
				model.addAttribute("autoRefillOids", autoRefillOids);
				model.addAttribute("refillDate", refillDate);
				
			}
			
			List<AssignedPatientResponse> assignedPatients = sessionManager.getAssignedPatients(eRefillSession);
			log.info("assignedPatients:: " + assignedPatients);
			String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
				isLoggedInUser = false;
			} 
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER, isLoggedInUser);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.CARE_GIVER_PAGE_NAME_MY_PRESCRIPTIONS);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, selectedPatientOID);
			model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));

			/*******************************************************************/
		/**************************************************/
			
			String strCheckedPresc = null;
			String dateFilter = ERefillConstants.LAST_730_DAYS;
			Date fromDate = null;
			Date toDate = null;
			
			String reqDateFilter = prescriptionModel.getDate_range();
			String reqSortField = prescriptionModel.getSort_by();
			String reqFromDate = prescriptionModel.getFrom();
			String reqToDate = prescriptionModel.getTo();
			String strUnchkdPresc = request.getParameter("removedOrderInfo");
			String reqChkdPresc = request.getParameter("orderInfo");

			strCheckedPresc =request.getParameter("orderInfo");
			dateFilter = (String) model.get(dateFilter);
			if (model.get(fromDate) != null)
				fromDate = (Date) model.get(fromDate);
			if (model.get(toDate) != null)
				toDate = (Date) model.get(toDate);

			if (strCheckedPresc != null)
				request.setAttribute("orderInfo", strCheckedPresc);
			else
				request.setAttribute("orderInfo", "");
			
			
			Set<String> selectedPresc=sessionManager.getSelectedPresc(eRefillSession);
			if (null != reqChkdPresc && !reqChkdPresc.isEmpty()) {
				List<String> checkedPresc = new ArrayList<String>(Arrays.asList(reqChkdPresc.split(ERefillConstants.COMMA_CHAR)));
				Set<String> setOfPresc = new HashSet<String>(checkedPresc);
				if(setOfPresc!=null){
					if(selectedPresc==null){
						selectedPresc=new HashSet<String>();
						selectedPresc.addAll(setOfPresc);
					}
					else{
						selectedPresc.addAll(setOfPresc);
					}
				}
			}
			
			if (null != strUnchkdPresc && !strUnchkdPresc.isEmpty()) {
				List<String> uncheckedPresc = new ArrayList<String>(Arrays.asList(strUnchkdPresc.split(ERefillConstants.COMMA_CHAR)));
				for (String uncheck: uncheckedPresc){
					if(selectedPresc.contains(uncheck)){
						selectedPresc.remove(uncheck);
					}
				}
			}
		
			if(selectedPresc!=null){
				sessionManager.setSelectedPresc(selectedPresc, eRefillSession);
			}
			
			String clickedPage = request.getParameter("page_num");
			if (null != clickedPage && !clickedPage.isEmpty()) {
				if (clickedPage.contains("prev_")) {
					clickedPage = clickedPage.replace("prev_", "");
				}
				if (clickedPage.contains("next_")) {
					clickedPage = clickedPage.replace("next_", "");
				}
			} else {
				clickedPage = "1";
			}
			log.info("clicked page is::" + clickedPage);
			
			model.addAttribute("dateFilter", dateFilter);
			model.addAttribute(ERefillConstants.PAGE_NUM_QUERY_STR,	clickedPage);
			model.addAttribute(ERefillConstants.CHKD_PRESC_QUERY_STR, selectedPresc);
			model.addAttribute(ERefillConstants.DATE_FILTER_QUERY_STR,	getDateFilter(reqDateFilter));
			model.addAttribute(ERefillConstants.SORT_FILTER_QUERY_STR, reqSortField);
			model.addAttribute(ERefillConstants.FROM_DT_QUERY_STR, reqFromDate);
			model.addAttribute(ERefillConstants.TO_DT_QUERY_STR, reqToDate);
			
			/*model.addAttribute("page_num", prescriptionModel.getPage_num());
			model.addAttribute("sort_by", prescriptionModel.getSort_by());
			model.addAttribute("date_range", prescriptionModel.getDate_range());
			model.addAttribute("from", prescriptionModel.getFrom());
			model.addAttribute("to", prescriptionModel.getTo());*/
			
			model.addAttribute("orderInfo", request.getParameter("orderInfo"));
			
			if(selectedPatientOid==null || !selectedPatientOid.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				getGlobalNotification(model, eRefillSession, request);
			}
			
		} catch (ERefillBusinessException e) {
			log.error(methodName + " Error1: " + e);
			throw e;
		} catch (ERefillApplicationException e){
			log.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		} catch (Exception e) {
			log.error(methodName + " Error1: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
				ErrorHandler.handleException(e1);
			}
		}
		userTokn= sessionManager.getToken(eRefillSession);
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
			log.debug("the token 5.5 is:---------->>>>" +userTokn);
		}
		return "caregiverMyPrescription";			
	}
	/**
	 * getPrescriptionDetails
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/{locale}/prescription/details")
	public String getPrescriptionDetails(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getPrescriptionDetails";
		String appContext = request.getContextPath();
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering now");
		}

		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,	sessionManager.getFirstName(eRefillSession));
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_PRESCRIPTION_PAGE_TITLE);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS, sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS, sessionManager.getPendingCustodianRequests(eRefillSession));

		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);

		DataCarrier dto = new DataCarrier();
		PrescriptionModel prescriptionModel=new PrescriptionModel();
		
		prescriptionModel.setDate_range(request.getParameter("date_range"));
		prescriptionModel.setPage_num(request.getParameter("page_num"));
		prescriptionModel.setFrom(request.getParameter("from"));
		prescriptionModel.setTo(request.getParameter("to"));
		prescriptionModel.setSort_by(request.getParameter("sort_by"));
		
		try {
			dto.addObject(ERefillConstants.LOGIN_MODEL, model);
			dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,	eRefillSession);
			dto.addObject("prescriptionModel", prescriptionModel);
			dto.addObject(ERefillConstants.MAP_KEY_LOCALE, locale);
			if (StringUtils.isNotBlank(request.getParameter("current-account"))) {
				sessionManager.setSelectedPatientOID(request.getParameter("current-account"),eRefillSession);
				dto.addObject(ERefillConstants.SELECTED_PATIENT_OID, request.getParameter("current-account"));
			} else {
				dto.addObject(ERefillConstants.SELECTED_PATIENT_OID, sessionManager.getSelectedPatientOID(eRefillSession));
			}
			
			//prescriptionBusinessDelegate.processToMyPrescription(dto);
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.processToMyPrescription(dto);
			List<Object> parameterList = prescriptionBusinessDelegate.getPrescRequestParameterList(dto);
			log.debug("parameters::" + parameterList);			
			//PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.getPrescriptionList(dto, parameterList, locale);
			List<PrescriptionsBO> userPresBO = prescriptionFilterResponse.getLstPresc();
			List<String> autoRefillOriginalOids = new ArrayList<String>();
			List<String> autoRefillOids = new ArrayList<String>();
			List<String> refillDate = new ArrayList<String>();
			
			if (userPresBO!=null) {
				Iterator<PrescriptionsBO> itrUserPresBO = userPresBO.iterator();
				while (itrUserPresBO.hasNext()) {
					PrescriptionsBO prescrBO = itrUserPresBO.next();
					int isAllowed = prescrBO.getAutomatedRefillAllowed();
					if (isAllowed >= 2) {
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
			/*@SuppressWarnings("unchecked")
			List<List<String>> automatedRefills = (List<List<String>>) dto.getObject(ERefillConstants.MAP_KEY_AUTOMATED_REFILL_RESPONSE);
			List<String> autoRefillOriginalOids = automatedRefills.get(0);			
			List<String> autoRefillOids = automatedRefills.get(1);
			List<String> refillDate = automatedRefills.get(2);
			
			Iterator<String> itrAutoRefillOrgOids = autoRefillOriginalOids.iterator();
			while(itrAutoRefillOrgOids.hasNext()){
				log.info("AutoRefillOrgOids<<>><<>>"+itrAutoRefillOrgOids.next());
			}
			Iterator<String> itrautoRefillOids = autoRefillOids.iterator();
			while(itrautoRefillOids.hasNext()){
				log.info("AutoRefillOids<<>><<>>"+itrautoRefillOids.next());
			}
			
			Iterator<String> itrRefillDate = refillDate.iterator();
			while(itrRefillDate.hasNext()){
				log.info("Refill Date<<>><<>>"+itrRefillDate.next());
			}
			log.info("RefillDate::::" + refillDate);

			@SuppressWarnings("unchecked")
			List<List<String>> refillReminders = (List<List<String>>) dto.getObject(ERefillConstants.MAP_KEY_REFILL_REMINDER_RESPONSE);

			List<String> refillReminderOriginalOids = new ArrayList<String>();
			List<String> refillReminderOids = new ArrayList<String>();
			if (refillReminders != null) {
				refillReminderOriginalOids = refillReminders.get(0);
				refillReminderOids = refillReminders.get(1);
			}*/
			
			List<String> refillReminderOriginalOids = new ArrayList<String>();
			List<String> refillReminderOids = new ArrayList<String>();
			if (userPresBO!=null) {
				Iterator<PrescriptionsBO> itrRefillRemainder = userPresBO
						.iterator();
				while (itrRefillRemainder.hasNext()) {
					PrescriptionsBO prescrBO = itrRefillRemainder.next();
					int isRefillRemainder = prescrBO.getRefillReminderAllowed();

					if (isRefillRemainder >= 2) {
						String opEventOid = prescrBO.getOperationalEventOid();
						String originalOid = prescrBO.getOriginalOID();

						if (opEventOid != null && originalOid != null) {
							refillReminderOriginalOids.add(originalOid);
							refillReminderOids.add(opEventOid);
						}

					}
				}
			}
			
			/*Iterator<String> itr1 = refillReminderOriginalOids.iterator();
			while(itr1.hasNext()){
				log.info("??????>"+itr1.next());
			}
			Iterator<String> itr2 = refillReminderOids.iterator();
			while(itr2.hasNext()){
				log.info("??????."+itr2.next());
			}*/
			
			model.addAttribute("refillReminders", refillReminderOriginalOids);
			model.addAttribute("refillReminderOids", refillReminderOids);

			List<AssignedPatientResponse> assignedPatients = sessionManager.getAssignedPatients(eRefillSession);
			log.info("assignedPatients:: " + assignedPatients);
			String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null) {
				isLoggedInUser = false;
			}
			
			model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,isLoggedInUser);
			model.addAttribute("automatedRefills", autoRefillOriginalOids);
			model.addAttribute("autoRefillOids", autoRefillOids);
			model.addAttribute("refillDate", refillDate);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.PAGE_NAME_MY_PRESCRIPTIONS);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY, sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID, selectedPatientOID);
			model.addAttribute(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(eRefillSession));
			
			/**************************************************/
			
			String strCheckedPresc = null;
			String dateFilter = ERefillConstants.LAST_730_DAYS;
			Date fromDate = null;
			Date toDate = null;
			
			String reqDateFilter = prescriptionModel.getDate_range();
			String reqSortField = prescriptionModel.getSort_by();
			String reqFromDate = prescriptionModel.getFrom();
			String reqToDate = prescriptionModel.getTo();
			String strUnchkdPresc = request.getParameter("removedOrderInfo");
			String reqChkdPresc = request.getParameter("orderInfo");

			strCheckedPresc =request.getParameter("orderInfo");
			dateFilter = (String) model.get(dateFilter);
			if (model.get(fromDate) != null)
				fromDate = (Date) model.get(fromDate);
			if (model.get(toDate) != null)
				toDate = (Date) model.get(toDate);

			if (strCheckedPresc != null)
				request.setAttribute("orderInfo", strCheckedPresc);
			else
				request.setAttribute("orderInfo", "");
			
			
			Set<String> selectedPresc=sessionManager.getSelectedPresc(eRefillSession);
			if (null != reqChkdPresc && !reqChkdPresc.isEmpty()) {
				List<String> checkedPresc = new ArrayList<String>(Arrays.asList(reqChkdPresc.split(ERefillConstants.COMMA_CHAR)));
				Set<String> setOfPresc = new HashSet<String>(checkedPresc);
				if(setOfPresc!=null){
					if(selectedPresc==null){
						selectedPresc=new HashSet<String>();
						selectedPresc.addAll(setOfPresc);
					}
					else{
						selectedPresc.addAll(setOfPresc);
					}
				}
			}
			if (null != strUnchkdPresc && !strUnchkdPresc.isEmpty()) {
				List<String> uncheckedPresc = new ArrayList<String>(Arrays.asList(strUnchkdPresc.split(ERefillConstants.COMMA_CHAR)));
				for (String uncheck: uncheckedPresc){
					if(selectedPresc.contains(uncheck)){
						selectedPresc.remove(uncheck);
					}
				}
			}
		
			if(selectedPresc!=null){
				sessionManager.setSelectedPresc(selectedPresc, eRefillSession);
			}
			
			String clickedPage = request.getParameter("page_num");
			if (null != clickedPage && !clickedPage.isEmpty()) {
				if (clickedPage.contains("prev_")) {
					clickedPage = clickedPage.replace("prev_", "");
				}
				if (clickedPage.contains("next_")) {
					clickedPage = clickedPage.replace("next_", "");
				}
			} else {
				clickedPage = "1";
			}
			log.info("clicked page is::" + clickedPage);

			/*if (null != reqChkdPresc && !reqChkdPresc.isEmpty()) {
				List<String> lstCheckedPresc = new ArrayList<String>(Arrays.asList(reqChkdPresc.split(ERefillConstants.COMMA_CHAR)));
				if (cacheObj.getObject(cacheKeyChkdPresc) != null) {
					@SuppressWarnings("unchecked")
					List<String> cachedList = (ArrayList<String>) cacheObj.getObject(cacheKeyChkdPresc);
					for (int i = 0; i < lstCheckedPresc.size(); i++) {
						String eleChkdPresc = lstCheckedPresc.get(i);
						if (!cachedList.contains(eleChkdPresc)) {
							cachedList.add(eleChkdPresc);
						}
					}
					cacheObj.putObject(cacheKeyChkdPresc, cachedList);
				} else {
					cacheObj.putObject(cacheKeyChkdPresc, lstCheckedPresc);
				}
				log.info("inside fn1");
			}

			if (null != strUnchkdPresc && !strUnchkdPresc.isEmpty()) {
				List<String> lstUnchkdPresc = new ArrayList<String>(Arrays.asList(strUnchkdPresc.split(ERefillConstants.COMMA_CHAR)));
				if (cacheObj.getObject(cacheKeyChkdPresc) != null) {
					@SuppressWarnings("unchecked")
					List<String> cachedList = (ArrayList<String>) cacheObj.getObject(cacheKeyChkdPresc);
					for (String eleUnchkdPresc : lstUnchkdPresc) {
						if (cachedList.contains(eleUnchkdPresc)) {
							cachedList.remove(eleUnchkdPresc);
						}
					}
					cacheObj.putObject(cacheKeyChkdPresc, cachedList);
				}
				log.info("inside fn2");
			}

			String retCheckedPresc = null;
			if (null != cacheObj.getObject(cacheKeyChkdPresc)) {
				@SuppressWarnings("unchecked")
				List<String> tempCheckedList = (ArrayList<String>) cacheObj.getObject(cacheKeyChkdPresc);
				StringBuffer tempBuffer = new StringBuffer();
				for (int i = 0; i < tempCheckedList.size(); i++) {
					tempBuffer.append(tempCheckedList.get(i));
					if (i != (tempCheckedList.size() - 1)) {
						tempBuffer.append(ERefillConstants.COMMA_CHAR);
					}
				}
				retCheckedPresc = tempBuffer.toString();
				log.info("inside fn1::" + retCheckedPresc);
			}*/
			model.addAttribute("dateFilter", dateFilter);
			model.addAttribute(ERefillConstants.PAGE_NUM_QUERY_STR,	clickedPage);
			model.addAttribute(ERefillConstants.CHKD_PRESC_QUERY_STR, selectedPresc);
			model.addAttribute(ERefillConstants.DATE_FILTER_QUERY_STR,	getDateFilter(reqDateFilter));
			model.addAttribute(ERefillConstants.SORT_FILTER_QUERY_STR, reqSortField);
			model.addAttribute(ERefillConstants.FROM_DT_QUERY_STR, reqFromDate);
			model.addAttribute(ERefillConstants.TO_DT_QUERY_STR, reqToDate);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,	ERefillConstants.PAGE_NAME_MY_PRESCRIPTIONS);
			
			/**********************************************************/
			/*model.addAttribute("page_num", prescriptionModel.getPage_num());
			model.addAttribute("sort_by", prescriptionModel.getSort_by());
			model.addAttribute("date_range", prescriptionModel.getDate_range());
			model.addAttribute("from", prescriptionModel.getFrom());

			model.addAttribute("to", prescriptionModel.getTo());*/
			model.addAttribute("orderInfo", request.getParameter("orderInfo"));
			
			/**
			 * set the gobal notification cookie
			 */
			setGlobalNotifierCookie(response, request);
			getGlobalNotification(model, eRefillSession, request);
		}catch(ERefillBusinessException e){
			log.error(methodName + " Error2: " + e.getMessage()+"******\n\n\n*******"+e.getCause());
			throw e;
		}catch (ERefillApplicationException e){
			log.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			log.error(methodName + " Error2: " + e.getMessage()+"******\n\n\n*******"+e.getCause());
			
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+ "/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
				ErrorHandler.handleException(e1);
			}
			
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return "myPrescriptions";	
	}
	
	/**
	 * setGlobalNotifierCookie
	 * 
	 * This method will set the notifier which will be used in first call to decide the display
	 * 
	 * @param response
	 * @param request
	 */
	private void setGlobalNotifierCookie(HttpServletResponse response, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		for (Cookie tmpCookie : cookies) {
			if (tmpCookie.getName().equalsIgnoreCase(
					ERefillConstants.COOKIE_GLOBAL_NOTIFICATION)) {
				break;
			} else {
				Cookie notificationCookie = new Cookie( ERefillConstants.COOKIE_GLOBAL_NOTIFICATION, "init");
				notificationCookie.setSecure(true);
				notificationCookie.setPath("/");
				response.addCookie( notificationCookie );
				break;
			}
		}
		
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
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
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
			log.error(methodName + " Error1: " + e);
			throw new ERefillApplicationException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
	}

	/**
	 * filterPrescriptions
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
/*	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/{locale}/prescription/filter/custom")
	//@RequestMapping(method = { RequestMethod.POST}, value = "/{locale}/prescription/details")
	public ModelAndView filterPrescriptions(@PathVariable String locale,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws ServletException, IOException {
		final String methodName = "filterPrescriptions";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

		DataCarrier dto = new DataCarrier();
		try {

			dto.addObject("eRefillSession", eRefillSession);
			dto.addObject("reqPageNum", request.getParameter("page_num"));
			dto.addObject("reqChkdPresc", request.getParameter("orderInfo"));
			dto.addObject("reqDateFilter", request.getParameter("date-range"));
			dto.addObject("reqSortField", request.getParameter("sort-by"));
			dto.addObject("reqFromDate", request.getParameter("from"));
			dto.addObject("reqToDate", request.getParameter("to"));
			dto.addObject("strUnchkdPresc",	request.getParameter("removedOrderInfo"));
			List<Object> parameterList = prescriptionBusinessDelegate.getPrescRequestParameterList(dto);
			log.info("parameters::" + parameterList);
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionBusinessDelegate.getPrescriptionList(dto, parameterList, locale);

			/*String strCheckedPresc = null;
			String dateFilter = ERefillConstants.LAST_730_DAYS;
			Date fromDate = null;
			Date toDate = null;

			String reqChkdPresc = request.getParameter("orderInfo");
			String reqDateFilter = request.getParameter("date-range");
			String reqSortField = request.getParameter("sort-by");
			String reqFromDate = request.getParameter("from");
			String reqToDate = request.getParameter("to");
			String strUnchkdPresc = request.getParameter("removedOrderInfo");

			strCheckedPresc = (String) parameterList.get(1);
			dateFilter = (String) parameterList.get(2);
			if (parameterList.get(4) != null)
				fromDate = (Date) parameterList.get(4);
			if (parameterList.get(5) != null)
				toDate = (Date) parameterList.get(5);

			if (strCheckedPresc != null)
				request.setAttribute("orderInfo", strCheckedPresc);
			else
				request.setAttribute("orderInfo", "");

			CacheLoader cacheObj = CacheLoader.getInstance();
			String cacheKeyChkdPresc = CommonUtils.createCacheKey(request,
					ERefillConstants.CACHE_KEY_CHECKED_PRESCS);
			String clickedPage = request.getParameter("page_num");
			if (null != clickedPage && !clickedPage.isEmpty()) {
				if (clickedPage.contains("prev_")) {
					clickedPage = clickedPage.replace("prev_", "");
				}
				if (clickedPage.contains("next_")) {
					clickedPage = clickedPage.replace("next_", "");
				}
			} else {
				clickedPage = "1";
			}
			log.info("clicked page is::" + clickedPage);

			if (null != reqChkdPresc && !reqChkdPresc.isEmpty()) {
				List<String> lstCheckedPresc = new ArrayList<String>(
						Arrays.asList(reqChkdPresc
								.split(ERefillConstants.COMMA_CHAR)));
				if (cacheObj.getObject(cacheKeyChkdPresc) != null) {
					@SuppressWarnings("unchecked")
					List<String> cachedList = (ArrayList<String>) cacheObj
							.getObject(cacheKeyChkdPresc);
					for (int i = 0; i < lstCheckedPresc.size(); i++) {
						String eleChkdPresc = lstCheckedPresc.get(i);
						if (!cachedList.contains(eleChkdPresc)) {
							cachedList.add(eleChkdPresc);
						}
					}
					cacheObj.putObject(cacheKeyChkdPresc, cachedList);
				} else {
					cacheObj.putObject(cacheKeyChkdPresc, lstCheckedPresc);
				}
				log.info("inside fn1");
			}

			if (null != strUnchkdPresc && !strUnchkdPresc.isEmpty()) {
				List<String> lstUnchkdPresc = new ArrayList<String>(
						Arrays.asList(strUnchkdPresc
								.split(ERefillConstants.COMMA_CHAR)));
				if (cacheObj.getObject(cacheKeyChkdPresc) != null) {
					@SuppressWarnings("unchecked")
					List<String> cachedList = (ArrayList<String>) cacheObj
							.getObject(cacheKeyChkdPresc);
					for (String eleUnchkdPresc : lstUnchkdPresc) {
						if (cachedList.contains(eleUnchkdPresc)) {
							cachedList.remove(eleUnchkdPresc);
						}
					}
					cacheObj.putObject(cacheKeyChkdPresc, cachedList);
				}
				log.info("inside fn2");
			}

			String retCheckedPresc = null;
			if (null != cacheObj.getObject(cacheKeyChkdPresc)) {
				@SuppressWarnings("unchecked")
				List<String> tempCheckedList = (ArrayList<String>) cacheObj
						.getObject(cacheKeyChkdPresc);
				StringBuffer tempBuffer = new StringBuffer();
				for (int i = 0; i < tempCheckedList.size(); i++) {
					tempBuffer.append(tempCheckedList.get(i));
					if (i != (tempCheckedList.size() - 1)) {
						tempBuffer.append(ERefillConstants.COMMA_CHAR);
					}
				}
				retCheckedPresc = tempBuffer.toString();
				log.info("inside fn1::" + retCheckedPresc);
			}

			try {
				String selectedPatientOID = sessionManager
						.getSelectedPatientOID(eRefillSession);
				boolean isLoggedInUser = true;
				if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
					isLoggedInUser = false;
				} 
				model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,
						isLoggedInUser);*/
		
	
	
	
/***************commenting extra code*****/
	
				/*model.addAttribute("lstPresc",	prescriptionFilterResponse.getLstPresc());
				model.addAttribute("firstRecord", prescriptionFilterResponse.getFirstRecord());
				model.addAttribute("numOfPages", prescriptionFilterResponse.getNumOfPages());
				model.addAttribute("totalRecords",	prescriptionFilterResponse.getTotalRecords());
				model.addAttribute("pageNum", request.getParameter("page_num"));*/
				
/****************commenting extra code*****/			
				
				
				/*model.addAttribute("dateFilter", dateFilter);*/
			
				/*model.addAttribute(ERefillConstants.PAGE_NUM_QUERY_STR,	clickedPage);
				model.addAttribute(ERefillConstants.CHKD_PRESC_QUERY_STR, strCheckedPresc);
				model.addAttribute(ERefillConstants.DATE_FILTER_QUERY_STR,	getDateFilter(reqDateFilter));
				model.addAttribute(ERefillConstants.SORT_FILTER_QUERY_STR, reqSortField);
				model.addAttribute(ERefillConstants.FROM_DT_QUERY_STR, reqFromDate);
				model.addAttribute(ERefillConstants.TO_DT_QUERY_STR, reqToDate);
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,	ERefillConstants.PAGE_NAME_MY_PRESCRIPTIONS);*/
			/*} catch (Exception e) {
				log.error(methodName + " Error: " + e);
				model.addAttribute("error", "Exception Occured");
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			}*/
	

/***************commenting extra code*****/
		/*} catch (Exception e) {
			log.error(methodName + " Error3: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return new ModelAndView("myPrescriptions");
	}*/
	/***************commenting extra code*****/
	/**
	 * getDateFilter
	 * 
	 * @param strDateFilter
	 * @return
	 */
	private String getDateFilter(String strDateFilter) {
		log.debug("entered into PrescriptionFilterServlet.getDateFilter()");
		String strRetVal = ERefillConstants.ALL_DAYS;
		if (null != strDateFilter && strDateFilter.contains("30")) {
			strRetVal = ERefillConstants.LAST_30_DAYS;
		} else if (null != strDateFilter && strDateFilter.contains("90")) {
			strRetVal = ERefillConstants.LAST_90_DAYS;
		} else if (null != strDateFilter && strDateFilter.contains("180")) {
			strRetVal = ERefillConstants.LAST_180_DAYS;
		}
		return strRetVal;
	}

	/**
	 * getMedicationRecord
	 * 
	 * @param locale
	 * @param medicationRecordModel
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/{locale}/mymedicationrecord")
	public ModelAndView getMedicationRecord(
			@PathVariable String locale,
			@ModelAttribute("medicationRecord") MedicationRecordModel medicationRecordModel,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getMedicationRecord";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext= request.getContextPath();
		// Enable cross domain calls
		

		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		Locale localeObj = setLocale(locale);
		String userRole= sessionManager.getUserRole(eRefillSession);
		model.addAttribute(ERefillConstants.USER_ROLE, userRole);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		} 
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,isLoggedInUser);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,selectedPatientOID);

		if(/*(!isLoggedInUser && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) //caregiver user but different patient
				||8*/(!isLoggedInUser || !userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER) //not a caregiver but logged in user
				)){
			int pageNum = 1;

			if (StringUtils.isNotBlank(medicationRecordModel.getPage_num())) {
				try {
					pageNum = new Integer(medicationRecordModel.getPage_num()).intValue();
				} catch (Exception e) {
					log.error("Error while getting pageNum");
					pageNum = 1;
				}
			}
			try {
				MedicationRecordResponse medicationRecordResponse = prescriptionBusinessDelegate
						.getMedicationRecord(eRefillSession, medicationRecordModel,
								String.valueOf(pageNum), localeObj);
				List<PrescriptionsBO> lstPresc = medicationRecordResponse
						.getLstPresc();
				model.addAttribute("lstPresc", lstPresc);
				model.addAttribute("filterDate", medicationRecordResponse.getFilterDate());
				model.addAttribute("totalRecords", medicationRecordResponse.getTotalRecords());
				model.addAttribute("firstRecord", medicationRecordResponse.getFirstRecord());
				model.addAttribute("numOfPages", medicationRecordResponse.getNumOfPages());
				model.addAttribute("pageNum", pageNum);
				model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
				model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
				model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,sessionManager.getPendingCustodianRequests(eRefillSession));
				model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
				model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,selectedPatientOID);
			}catch (ERefillBusinessException e) {
				log.error(methodName + " Error1: " + e);
				throw e;
			}catch (ERefillApplicationException e){
				log.error(methodName + " Error6: " + e);
				//throw e;
				if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
				}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
					
				}else{
					throw e;
				}
				
			}catch (Exception e) {
				log.error(methodName + " Error4: " + e);
				model.addAttribute("error", "Exception Occured");
				loginBusinessDelegate.logOut(eRefillSession, request, response);
				try {
					
					String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
					ErrorHandler.handleException(e1);
				}
			}
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.PAGE_NAME_MY_MEDICATION_RECORD);
			model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE,ERefillConstants.MY_MEDICATION_RECORD_PAGE_TITLE);
			if(userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.CARE_GIVER_PAGE_NAME_MEDICATION);
				return new ModelAndView("caregiverMyMedicationRecord");
			}else{
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.PAGE_NAME_MY_MEDICATION_RECORD);
				return new ModelAndView("myMedicationRecord");
			}
		}
		else{
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.CARE_GIVER_PAGE_NAME_MEDICATION);
			model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE,ERefillConstants.MY_MEDICATION_RECORD_PAGE_TITLE);
			return new ModelAndView("caregiverMyMedicationRecord");
		}
}

	/**
	 * getMedicationRecordDetail
	 * 
	 * @param locale
	 * @param medicationRecordDetailModel
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/{locale}/mymedicationrecord/details")
	public ModelAndView getMedicationRecordDetail(
			@PathVariable String locale,
			@ModelAttribute("medicationRecordDetail") MedicationRecordDetailModel medicationRecordDetailModel,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getMedicationRecordDetail";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		String strDIN = StringUtils.EMPTY;
		if (medicationRecordDetailModel != null) {
			strDIN = medicationRecordDetailModel.getData_drug_id();
		}
		if (StringUtils.isNotBlank(strDIN)) {
			String strDisclaimer = null;
			String imageUrl = null;
			String drugHeadName = null;
			String drugHeadStrength = null;
			Locale localeObj = setLocale(locale);
			ERefillSession eRefillSession = (ERefillSession) request
					.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

			try {
				MedicationRecordDetailResponse medicationRecordDetailResponse = prescriptionBusinessDelegate
						.getMedicationRecordDetail(eRefillSession, strDIN,
								localeObj.toString());

				DrugInformation drugInformation = null;
				DrugHeaderView drugHeaderView = null;
				List<String> drugList = null;
				if (medicationRecordDetailResponse != null) {
					drugInformation = medicationRecordDetailResponse
							.getDrugInformation();
					drugHeaderView = medicationRecordDetailResponse
							.getDrugHeaderView();
					drugList = medicationRecordDetailResponse.getDrugList();
					if (!CommonUtils.isNullOrEmpty(drugList)) {
						drugHeadName = drugList.get(0);
						drugHeadStrength = drugList.get(1);
					}
					if (drugHeaderView != null) {
						model.addAttribute("drugName", drugHeaderView.getName());
						model.addAttribute("drugGenericName",
								drugHeaderView.getGenericName());
						model.addAttribute("drugStrength",
								drugHeaderView.getStrength());
					} else {
						model.addAttribute("drugName", drugHeadName);
						model.addAttribute("drugStrength", drugHeadStrength);
					}
				}

				strDisclaimer = null != drugInformation
						&& null != drugInformation.getDisclaimer() ? drugInformation
						.getDisclaimer() : "";
				imageUrl = null != drugInformation
						&& null != drugInformation.getImageURL() ? drugInformation
						.getImageURL() : "https://loblaw.stagingws.teluspharmaspace.com/vigilance/Image/English/DinNoImage.jpg";
				String selectedPatientOID = sessionManager
						.getSelectedPatientOID(eRefillSession);
				boolean isLoggedInUser = true;
				if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
					isLoggedInUser = false;
				} 
				model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,
						isLoggedInUser);
				model.addAttribute("strDisclaimer", strDisclaimer);
				model.addAttribute("imageUrl", imageUrl);
				model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
						sessionManager.getPharmacyDetails(eRefillSession));
				model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
						sessionManager.getFirstName(eRefillSession));
				model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
						sessionManager.getAssignedPatients(eRefillSession));
				model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
						sessionManager
								.getPendingCustodianRequests(eRefillSession));
				model.addAttribute(ERefillConstants.PATIENT_OID,
						sessionManager.getPatientID(eRefillSession));
				model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
						selectedPatientOID);
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,
						ERefillConstants.PAGE_NAME_MY_MEDICATION_RECORD);
				if (null != drugInformation
						&& null != drugInformation.getDetails()) {
					model.addAttribute("drugInfoList",
							drugInformation.getDetails());
				}
			}catch (ERefillBusinessException e) {
				log.error(methodName + " Error1: " + e);
				throw e;
			} catch (ERefillApplicationException e){
				log.error(methodName + " Error6: " + e);
				//throw e;
				if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
				}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
					
				}else{
					throw e;
				}
				
			}catch (Exception e) {
				log.error(methodName + " Error5: " + e);
				model.addAttribute("error", "Exception Occured");
				loginBusinessDelegate.logOut(eRefillSession, request, response);
				try {
					String redirect = appContext+ "/home/" + locale	+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
					ErrorHandler.handleException(e1);
				}
			}
		}

		return new ModelAndView("drugdetails");
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/{locale}/orderhistory/getorderhistory")
	public ModelAndView getOrderHistory(@PathVariable String locale,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response){
		final String methodName = "getOrderHistory";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		//boolean isNotPatient;
		String appContext = request.getContextPath();
		// Enable cross domain calls
		
		
		// Set the locale
		Locale localeObj = setLocale(locale);
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String userRole = sessionManager.getUserRole(eRefillSession);
		model.addAttribute(ERefillConstants.USER_ROLE, userRole);
		String selectedPatientOID = sessionManager.getSelectedPatientOID(eRefillSession);
		boolean isLoggedInUser = true;
		if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
			isLoggedInUser = false;
		} 
		model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,isLoggedInUser);
		model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,sessionManager.getAssignedPatients(eRefillSession));
		
		/*if(sessionManager.getAssignedPatients(eRefillSession)!=null){
			isNotPatient=true;
		}*/
				
		if(/*(!isLoggedInUser && userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) //caregiver user but different patient
				||(isLoggedInUser && !userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)) //not a caregiver but logged in user
				|| isNotPatient  //can be a custodian
*/				!isLoggedInUser || !userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
			try {
				String status = "All";
				String dateFilter = "All";
				int pageNum = 1;
				Map<String, List<RefillPrescriptionVO>> mpRefill = null;
				if (StringUtils.isNotBlank((String) request.getAttribute("pageNum"))) {
					try {
						pageNum = new Integer(((String) request.getAttribute("pageNum"))).intValue();
					} catch (Exception e) {
						log.error("Error while getting pageNum");
						pageNum = 1;
					}
				}
				OrderHistoryResponse orderHistoryResponse = prescriptionBusinessDelegate.getPatientOnlineOrderHistory(eRefillSession, dateFilter,
								status, pageNum, localeObj.toString());
				if (orderHistoryResponse != null) {
					mpRefill = orderHistoryResponse.getMpRefill();
				}
				model.addAttribute("mpRefill", mpRefill);
				model.addAttribute("totalRecords", mpRefill.size());

				model.addAttribute("firstRecord",orderHistoryResponse.getFirstRecord());
				model.addAttribute("totalRecords",orderHistoryResponse.getTotalRecords());
				model.addAttribute("numOfPages",orderHistoryResponse.getNumOfPages());
				model.addAttribute("pageNum", pageNum);
				model.addAttribute("locale", locale);
				model.addAttribute("filterDate", dateFilter);
				model.addAttribute("status", status);
				model.addAttribute(ERefillConstants.REQUEST_PHARMACY,sessionManager.getPharmacyDetails(eRefillSession));
				model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,sessionManager.getFirstName(eRefillSession));
				
				model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,sessionManager.getPendingCustodianRequests(eRefillSession));
				model.addAttribute(ERefillConstants.PATIENT_OID,sessionManager.getPatientID(eRefillSession));
				model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,selectedPatientOID);
				model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
				
			}catch (ERefillBusinessException e){ 
				log.error(methodName + " Error6: " + e);
				throw e;
			}catch (ERefillApplicationException e){
				log.error(methodName + " Error6: " + e);
				//throw e;
				if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
				}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
				{
					try {
						String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
						response.sendRedirect(redirect);
						return null;
					} catch (IOException e1) {
						log.error("Exception while redirecting: ", e1);
					}
					
				}else{
					throw e;
				}
				
			}
			catch (Exception e) {
				log.error(methodName + " Error6: " + e);
				model.addAttribute("error", "Exception Occured");
				loginBusinessDelegate.logOut(eRefillSession, request, response);
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}
			model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE,
					ERefillConstants.MY_ORDER_HISTORY_PAGE_TITLE);
			if(userRole.equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.CARE_GIVER_PAGE_NAME_ORDER_HISTORY);
				model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_ORDER_HISTORY_PAGE_TITLE);
				return new ModelAndView("caregiverOrderHistory");
			}else{
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,ERefillConstants.PAGE_NAME_MY_ORDER_HISTORY);
				return new ModelAndView("orderHistory");
			}
			} else{
				model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.MY_ORDER_HISTORY_PAGE_TITLE);
				model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, ERefillConstants.CARE_GIVER_PAGE_NAME_ORDER_HISTORY);
			return new ModelAndView("caregiverOrderHistory");
		}
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/{locale}/orderhistory/specificorderhistory")
	public ModelAndView getSpecificOrderHistory(
			@PathVariable String locale,
			@ModelAttribute("orderhistory") OrderHistoryModel orderHistoryModel,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getSpecificOrderHistory";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		// Enable cross domain calls
		

		// Set the locale
		Locale localeObj = setLocale(locale);
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		try {
			String status = orderHistoryModel.getStatus();
			String dateFilter = orderHistoryModel.getDate_range();
			if(StringUtils.isBlank(status)){
				status = "All";
			}
			if(StringUtils.isBlank(dateFilter)){
				dateFilter = "All";
			}
			int pageNum = 1;
			Map<String, List<RefillPrescriptionVO>> mpRefill = null;
			if (StringUtils.isNotBlank(orderHistoryModel.getPage_num())) {
				try {
					pageNum = new Integer((orderHistoryModel.getPage_num()))
							.intValue();
				} catch (Exception e) {
					log.error("Error while getting pageNum");
					pageNum = 1;
				}
			}
			OrderHistoryResponse orderHistoryResponse = prescriptionBusinessDelegate
					.getPatientOnlineOrderHistory(eRefillSession, dateFilter,
							status, pageNum, localeObj.toString());
			if (orderHistoryResponse != null) {
				mpRefill = orderHistoryResponse.getMpRefill();
			}
			model.addAttribute("mpRefill", mpRefill);
			model.addAttribute("totalRecords", mpRefill.size());

			String selectedPatientOID = sessionManager
					.getSelectedPatientOID(eRefillSession);
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
				isLoggedInUser = false;
			} 
			model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,
					isLoggedInUser);
			model.addAttribute("firstRecord",
					orderHistoryResponse.getFirstRecord());
			model.addAttribute("totalRecords",
					orderHistoryResponse.getTotalRecords());
			model.addAttribute("numOfPages",
					orderHistoryResponse.getNumOfPages());
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("locale", locale);
			model.addAttribute("filterDate", dateFilter);
			model.addAttribute("status", status);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
					sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
					sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
					sessionManager.getPendingCustodianRequests(eRefillSession));
			model.addAttribute(ERefillConstants.PATIENT_OID,
					sessionManager.getPatientID(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
					selectedPatientOID);
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
			model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME,
					ERefillConstants.PAGE_NAME_MY_ORDER_HISTORY);
		}catch (ERefillBusinessException e){ 
			log.error(methodName + " Error7: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			log.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			log.error(methodName + " Error7: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
				ErrorHandler.handleException(e1);
			}
		}
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE,
				ERefillConstants.MY_ORDER_HISTORY_PAGE_TITLE);
		return new ModelAndView("orderHistory");
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
	 * getDrugDetails
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/{locale}/orderhistory/drugdetails")
	public ModelAndView getDrugDetails(
			@PathVariable String locale,
			@ModelAttribute("medicationRecordDetail") MedicationRecordDetailModel medicationRecordDetailModel,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		final String methodName = "getDrugDetails";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String strDIN = StringUtils.EMPTY;
		if (medicationRecordDetailModel != null) {
			strDIN = medicationRecordDetailModel.getData_drug_id();
		}
		if (StringUtils.isBlank(strDIN)) {
			return new ModelAndView("overlay-drug-information");
		}
		try {
			
			DataCarrier dto = prescriptionBusinessDelegate.getDrugDetails(
				eRefillSession, strDIN, locale);
		
			if (dto.getObject(ERefillConstants.DRUG_INFO) != null) {
				model.addAttribute(ERefillConstants.DRUG_INFO,
						dto.getObject(ERefillConstants.DRUG_INFO));
			}
			if (dto.getObject(ERefillConstants.DRUG_INFO_HEADER) != null) {
				model.addAttribute(ERefillConstants.DRUG_INFO_HEADER,
						dto.getObject(ERefillConstants.DRUG_INFO_HEADER));
			}
			if (dto.getObject(ERefillConstants.DRUG_INFO_HEADER_NAME) != null) {
				model.addAttribute(ERefillConstants.DRUG_INFO_HEADER_NAME,
						dto.getObject(ERefillConstants.DRUG_INFO_HEADER_NAME));
			}
			if (dto.getObject(ERefillConstants.DRUG_INFO_HEADER_STRENGTH) != null) {
				model.addAttribute(
						ERefillConstants.DRUG_INFO_HEADER_STRENGTH,
						dto.getObject(ERefillConstants.DRUG_INFO_HEADER_STRENGTH));
			}
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
					sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
					sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
					sessionManager.getPendingCustodianRequests(eRefillSession));
			model.addAttribute(ERefillConstants.PATIENT_OID,
					sessionManager.getPatientID(eRefillSession));
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
					sessionManager.getSelectedPatientOID(eRefillSession));
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		} catch (ERefillApplicationException e){
			log.error(methodName + " Error6: " + e);
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
				
			}else{
				log.error(methodName + " Error8: " + e);
				return new ModelAndView("overlay-error-generic");
			}
		}catch (NullPointerException e) {
			log.error(methodName + " Error nullpointer: " + e);
			return new ModelAndView("overlay-error-generic");
		}
		catch (Exception e) {
			log.error(methodName + " Error9: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
			}
		} 

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-drug-information");
	}

	/**
	 * getRefillHistory
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/{locale}/user/refillHistory/{details}")
	public ModelAndView getRefillHistory(@PathVariable String locale,
			@PathVariable String details, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "getRefillHistory";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		String appContext = request.getContextPath();
		ERefillSession eRefillSession = (ERefillSession) request
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		String prescOID = request.getParameter("prescOID");
		String strPageNum = request.getParameter("pageNum");

		String[] presDetails = details.split("&&&");
		if (presDetails != null && presDetails.length == 2) {
			strPageNum = presDetails[0];
			prescOID = presDetails[1];
		}

		Integer pageNum = Integer.valueOf(1);
		if (StringUtils.isNotBlank(strPageNum)) {
			try {
				pageNum = Integer.parseInt(strPageNum);
			} catch (Exception e) {
				pageNum = Integer.valueOf(1);
			}
		}
	
		try {
			model.addAttribute(ERefillConstants.MAP_KEY_FIRSTNAME,
					sessionManager.getFirstName(eRefillSession));
			model.addAttribute(ERefillConstants.ASSIGNED_PATIENTS,
					sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute(ERefillConstants.PENDING_CUSTODIANREQUESTS,
					sessionManager.getPendingCustodianRequests(eRefillSession));
			model.addAttribute(ERefillConstants.PATIENT_OID,
					sessionManager.getPatientID(eRefillSession));
			DataCarrier dto = prescriptionBusinessDelegate.getRefillHistory(
					eRefillSession, prescOID, pageNum, locale);
			
			if (dto.getObject(ERefillConstants.REFILL_HISTORY_DRUG_HEADER) != null) {
				model.addAttribute(
						ERefillConstants.REFILL_HISTORY_DRUG_HEADER,
						dto.getObject(ERefillConstants.REFILL_HISTORY_DRUG_HEADER));
			}
			if (dto.getObject(ERefillConstants.REFILL_HISTORY_LIST) != null) {
				RefillHistoryResponse refillHistoryResponse = (RefillHistoryResponse) dto
						.getObject(ERefillConstants.REFILL_HISTORY_LIST);
				model.addAttribute(ERefillConstants.REFILL_HISTORY_LIST,
						refillHistoryResponse.getLstPresc());
				model.addAttribute("numOfPages",
						refillHistoryResponse.getNumOfPages());
				model.addAttribute("totalRecords",
						refillHistoryResponse.getTotalRecords());
				model.addAttribute("pageNum", pageNum);
			}
			if (dto.getObject(ERefillConstants.REFILL_HISTORY_DRUG_INFO) != null) {
				model.addAttribute(
						ERefillConstants.REFILL_HISTORY_DRUG_INFO,
						dto.getObject(ERefillConstants.REFILL_HISTORY_DRUG_INFO));
			}

			String selectedPatientOID = sessionManager
					.getSelectedPatientOID(eRefillSession);
			boolean isLoggedInUser = true;
			if (selectedPatientOID != null && !selectedPatientOID.equalsIgnoreCase(ERefillConstants.CARE_GIVER) ) {
				isLoggedInUser = false;
			} 
			model.addAttribute(ERefillConstants.IS_LOGGED_IN_USER,
					isLoggedInUser);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					sessionManager.getPharmacyDetails(eRefillSession));
			model.addAttribute("prescOID", prescOID);
			model.addAttribute(ERefillConstants.SELECTED_PATIENT_OID,
					selectedPatientOID);
			model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		} catch (ERefillBusinessException e){ 
			log.error(methodName + " Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			log.error(methodName + " Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.NOCOUNSELLINGSHEET_EXCEPTION) || e.toString().contains("NoCounsellingSheetException")){
						model.addAttribute(ERefillConstants.REFILL_HISTORY_LIST, ERefillConstants.NOCOUNSELLINGSHEET_EXCEPTION);
						return new ModelAndView("overlay-refill-history-error");
				
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					response.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					log.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			log.error(methodName + " Error10: " + e);
			model.addAttribute("error", "Exception Occured");
			loginBusinessDelegate.logOut(eRefillSession, request, response);
			try {
				String redirect = appContext+"/home/" + locale+ "/welcome?signinerror=eProcessingError";
				response.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				log.error("Exception while redirecting: ", e1);
			}
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-refill-history");
	}

	/**
	 * prescriptionInstructionView
	 * 
	 * @param locale
	 * @param details
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/{locale}/prescription/instructions", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView prescriptionInstructionView(
			@PathVariable("locale") String locale, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "prescriptionInstructionView";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		model.addAttribute("locale", locale);

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return new ModelAndView("overlay-prescriptions-instructions");
	}

}
