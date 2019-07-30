/**
 * 
 */
package com.lcl.erefill.core.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AutomatedRefillCalendarResponse;
import com.lcl.erefill.core.common.telus.response.AutomatedRefillResponse;
import com.lcl.erefill.core.common.telus.response.EmailStatusResponse;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.IAccountService;
import com.lcl.erefill.core.services.IOperationService;
import com.lcl.erefill.core.services.IRefillRequestService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.PrescDetailsView;
import com.lcl.erefill.core.vo.RxNewRequest;
import com.lcl.erefill.core.vo.RxRenewPrescription;

/**
 * @author hkokel version 1.0
 */
@Component
public class RefillRequestBusinessDelegate implements
		IRefillRequestBusinessDelegate {

	private static final Logger log = LoggerFactory
			.getLogger(RefillRequestBusinessDelegate.class);

	@Autowired
	IRefillRequestService refillRequestService;

	@Autowired
	IOperationService operationService;

	@Autowired
	ISessionService sessionService;

	@Autowired
	IAccountService accountService;

	@Autowired
	SessionManager sessionManager;

	/**
	 * refillRequest
	 * 
	 * @param dto
	 * @return dto
	 */
	public DataCarrier refillRequest(DataCarrier dto) {
		final String methodName = "refillRequest";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		ISession session = null;
		try {
			session = (ERefillSession) dto
					.getObject(ERefillConstants.EREFILL_SESSION);
			UserToken userToken = sessionManager.getToken(session);
			
			String patientOID = sessionManager.getSelectedPatientOID(session);
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			dto.addObject(ERefillConstants.SELECTED_PATIENT_OID, patientOID);
			dto = refillRequestService.refillRequest(dto);
			userToken = (UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN);

			Map<String, String> phoneStatus = sessionService
					.getPhoneNumberStatus(userToken);
			if ( MapUtils.isNotEmpty(phoneStatus)) {
				dto.addObject("mobileNumber", phoneStatus.get("phnno"));
				dto.addObject("mobileStatus", phoneStatus.get("status"));
			}

			String requestType = (String) dto
					.getObject(ERefillConstants.REFILL_REQUEST_TYPE);
			if (ERefillConstants.AUTO_REFILL_REQUEST.equals(requestType)) {
				/*String storeId = (String) dto
						.getObject(ERefillConstants.STOREID);*/
				@SuppressWarnings("unchecked")
				List<PrescDetailsView> viewList = (List<PrescDetailsView>) dto
						.getObject(ERefillConstants.REFILL_REQUEST_PRESC);
				//String originalPrescriptionOID = null;
				String estFillDate = null;
				
				if (null != viewList && viewList.size() > 0) {
					//originalPrescriptionOID = viewList.get(0).getOriginalOid();
					estFillDate = viewList.get(0).getEstimatedFillDate();
					log.debug("Prescription estimated refill date is > "+viewList.get(0).getEstimatedFillDate());
				}
				//AutomatedRefillCalendarResponse automatedRefillCalendar = getExpectedAutomatedRefill((ERefillSession)session, storeId, originalPrescriptionOID, "both", viewList.get(0).getRxDate(), viewList.get(0).getDaysSupply());
				//userToken = automatedRefillCalendar.getUserToken();
				dto.addObject("pickupDates", estFillDate);
				dto.addObject("deliveryDates", estFillDate);
			}
			sessionManager.setToken(userToken, session);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			log.error(methodName + " Error: " + e);
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
			ErrorHandler.handleException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return dto;
	}

	/**
	 * refillRequestSubmit
	 * 
	 * @param dto
	 * @return dto
	 */
	public DataCarrier refillRequestSubmit(DataCarrier dto) {
		final String methodName = "refillRequestSubmit";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		ISession session = null;
		try {
			session = (ERefillSession) dto
					.getObject(ERefillConstants.EREFILL_SESSION);
			UserToken userToken = sessionManager.getToken(session);
		    
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			dto = refillRequestService.refillRequestSubmit(dto);
			userToken = (UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN);
			sessionManager.setToken(userToken, session);
		} catch (ERefillBusinessException e) {
			log.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error(methodName + " Error: " + e);
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
			ErrorHandler.handleException(e);			
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return dto;
	}

	/**
	 * getExpectedAutomatedRefill
	 * 
	 * @param session
	 * @param storeId
	 * @param originalPrescriptionOID
	 * @param releaseMode
	 * @param daysSupply 
	 * @param rxDate 
	 * @return automatedRefillCalendarResponse
	 */
	public AutomatedRefillCalendarResponse getExpectedAutomatedRefill(
			ERefillSession session, String storeId,
			String originalPrescriptionOID, String releaseMode, int rxDate, short daysSupply) {
		final String methodName = "getExpectedAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		AutomatedRefillCalendarResponse automatedRefillCalendarResponse = null;
		try {
			UserToken userToken = sessionManager.getToken(session);
			automatedRefillCalendarResponse = operationService
					.getExpectedAutomatedRefill(userToken, storeId,
							originalPrescriptionOID, releaseMode, rxDate, daysSupply);

			if (automatedRefillCalendarResponse != null
					&& automatedRefillCalendarResponse.getUserToken() != null) {
				sessionManager
						.setToken(
								automatedRefillCalendarResponse.getUserToken(),
								session);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return automatedRefillCalendarResponse;
	}

	/**
	 * addAutomatedRefill
	 * 
	 * @param session
	 * @param rxNewRequest
	 * @return operationAddResponse
	 */
	public OperationAddResponse addAutomatedRefill(ERefillSession session,
			RxNewRequest rxNewRequest,String locale) {
		final String methodName = "addAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse operationAddResponse = null;
		try {
			UserToken userToken = sessionManager.getToken(session);
			String patientOID = sessionManager.getSelectedPatientOID(session);
			//String patientId=sessionManager.getPatientID(session);
			operationAddResponse = operationService.addAutomatedRefill(
					userToken, patientOID, rxNewRequest,locale);
		
			if (operationAddResponse != null
					&& operationAddResponse.getUserToken() != null) {
				sessionManager.setToken(operationAddResponse.getUserToken(),
						session);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * addRefillReminder
	 * 
	 * @param session
	 * @param rxNewRequest
	 * @param dateRange
	 * @return operationAddResponse
	 */
	public OperationAddResponse addRefillReminder(ERefillSession session,
			RxNewRequest rxNewRequest, int dateRange) {
		final String methodName = "addRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse operationAddResponse = null;
		try {
			RxRenewPrescription rxRenewPrescription = null;
			if (!rxNewRequest.getPrescriptions().getRxRenewPrescription()
					.isEmpty()) {
				rxRenewPrescription = rxNewRequest.getPrescriptions()
						.getRxRenewPrescription().get(0);
			}
			UserToken userToken = sessionManager.getToken(session);
			//String patientOID = sessionManager.getPatientID(session);
			String patientOID = sessionManager.getSelectedPatientOID(session);
			operationAddResponse = operationService.addRefillReminder(
					userToken, rxRenewPrescription.getOid(),
					patientOID, dateRange, rxNewRequest.getEmail(),
					rxNewRequest.getPhone());

			if (operationAddResponse != null
					&& operationAddResponse.getUserToken() != null) {
				sessionManager.setToken(operationAddResponse.getUserToken(),
						session);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * deleteAutomatedRefill
	 * 
	 * @param session
	 * @param oid
	 * @return operationAddResponse
	 */
	public OperationAddResponse deleteAutomatedRefill(ERefillSession session,
			String oid) {
		final String methodName = "deleteAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse operationAddResponse = null;
		UserToken userToken = sessionManager.getToken(session);

		try {
			operationAddResponse = operationService.deleteAutomatedRefill(
					userToken, oid);
			if (operationAddResponse != null
					&& operationAddResponse.getUserToken() != null) {
				sessionManager.setToken(operationAddResponse.getUserToken(),
						session);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * deleteRefillReminder
	 * 
	 * @param session
	 * @param oid
	 * @return
	 */
	public OperationAddResponse deleteRefillReminder(ERefillSession session,
			String oid) {
		final String methodName = "deleteRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse operationAddResponse = null;
		UserToken userToken = sessionManager.getToken(session);

		try {
			operationAddResponse = operationService.deleteRefillReminder(
					userToken, oid);
			if (operationAddResponse != null
					&& operationAddResponse.getUserToken() != null) {
				sessionManager.setToken(operationAddResponse.getUserToken(),
						session);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * updateAutoRefillView
	 * 
	 * @param session
	 * @param oid
	 * @return phoneStatus
	 */
	public Map<String, String> updateAutoRefillView(ERefillSession session,
			String oid) {
		final String methodName = "updateAutoRefillView";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		Map<String, String> updateAutoRefillMap = new HashMap<String, String>();
		UserToken userToken = sessionManager.getToken(session);

		try {
			AutomatedRefillResponse automatedRefill = operationService
					.getAutomatedRefillByOID(userToken, oid);

			// If user has selected the email option while sending the auto refill request
			String selectedEmail = automatedRefill.getAutomatedRefill().getRequest()
					.getEMail();
			if (selectedEmail != null && !selectedEmail.equalsIgnoreCase("null")
					&& !selectedEmail.isEmpty()) {
				updateAutoRefillMap.put("selectedEmail", selectedEmail);
			}
			// If user has selected the email option while sending the auto refill request
			String selectedPhone = automatedRefill.getAutomatedRefill().getRequest()
					.getMobilePhoneNumber().getValue();
			if (selectedPhone != null && !selectedPhone.equalsIgnoreCase("null")
					&& !selectedPhone.isEmpty()) {
				updateAutoRefillMap.put("selectedPhone", selectedPhone);
			}

			// Checking the status of Email and Phone number 
			Map<String, String> phoneStatus = sessionService.getPhoneNumberStatus(userToken);
			if (phoneStatus != null) {
				updateAutoRefillMap.put("mobileNumber", phoneStatus.get("phnno"));
				updateAutoRefillMap.put("mobileStatus", phoneStatus.get("status"));
				}

			EmailStatusResponse emailStatusResponse = accountService.getEmailStatus(userToken);
			Map<String, String> emailStatus = emailStatusResponse.getEmailStatus();
			if (emailStatus.containsKey("mailid")) {
				updateAutoRefillMap.put("emailId", emailStatus.get("mailid"));
				if (null != emailStatus.get("status")) {
					updateAutoRefillMap.put("emailStatus",
							emailStatus.get("status"));
				}
			}
			sessionManager.setToken(userToken, session);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(methodName + " Error: " + e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return updateAutoRefillMap;
	}

	/**
	 * updateAutoRefillReminder
	 * 
	 * @param session
	 * @param autoRefillReminderRequest
	 * @param oid
	 * @return
	 */
	public OperationAddResponse updateAutoRefillReminder(
			ERefillSession session,
			AutoRefillReminderRequest autoRefillReminderRequest, String oid) {
		final String methodName = "updateAutoRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		UserToken userToken = sessionManager.getToken(session);
		String patientOid = sessionManager.getSelectedPatientOID(session);

		OperationAddResponse operationAddResponse = null;
		operationAddResponse = operationService.updateAutoRefillReminder(
				userToken, autoRefillReminderRequest, oid, patientOid);

		if (operationAddResponse != null) {
			sessionManager.setToken(operationAddResponse.getUserToken(),
					session);
		}
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}
}
