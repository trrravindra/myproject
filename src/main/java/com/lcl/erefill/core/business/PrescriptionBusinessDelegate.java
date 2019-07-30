package com.lcl.erefill.core.business;

import java.util.List;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.DrugHeaderViewResponse;
import com.lcl.erefill.core.common.telus.response.DrugInformationResponse;
import com.lcl.erefill.core.common.telus.response.DrugListResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordDetailResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordResponse;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.IAccountService;
import com.lcl.erefill.core.services.IOperationService;
import com.lcl.erefill.core.services.IPharmacyDetailService;
import com.lcl.erefill.core.services.IPrescriptionService;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.MedicationRecordModel;
import com.lcl.erefill.core.vo.PharmaDeptVO;

@Component
public class PrescriptionBusinessDelegate implements
		IPrescriptionBusinessDelegate {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PrescriptionBusinessDelegate.class);

	@Autowired
	IPrescriptionService prescriptionService;

	@Autowired
	IAccountService accountService;

	@Autowired
	SessionManager sessionManager;

	@Autowired
	IPharmacyDetailService pharmaService;

	@Autowired
	IOperationService operationService;

	/**
	 * getMedicationRecord
	 * 
	 * @param eRefillSession
	 * @param medicationRecordModel
	 * @param pageNumber
	 * @param locale
	 * @return
	 */
	public MedicationRecordResponse getMedicationRecord(
			ISession eRefillSession,
			MedicationRecordModel medicationRecordModel, String pageNum,
			Locale locale) {
		LOGGER.debug("Entering getMedicationRecord");
		MedicationRecordResponse medicationRecordResponse = new MedicationRecordResponse();
		UserToken userToken = sessionManager.getToken(eRefillSession);
		String patientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		try {
			medicationRecordResponse = prescriptionService.getMedicationRecord(
					userToken, patientOID, medicationRecordModel, pageNum,
					locale);
			if (medicationRecordResponse.getUserToken() != null) {
				sessionManager
						.setToken(medicationRecordResponse.getUserToken(),
								eRefillSession);
			}
			return medicationRecordResponse;
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
            ErrorHandler.handleException(e);
		}
		LOGGER.debug("Exiting getMedicationRecord");
		return medicationRecordResponse;
	}

	/**
	 * getPatientOnlineOrderHistory
	 * 
	 * @param eRefillSession
	 * @param dateFilter
	 * @param requestStateWrapper
	 * @param pageNum
	 * @param strLocale
	 * @return
	 */
	public OrderHistoryResponse getPatientOnlineOrderHistory(
			ISession eRefillSession, String dateFilter,
			String requestStateWrapper, int pageNum, String strLocale) {
		LOGGER.debug("Entering getMedicationRecord in Prescription Business Delegate");
		UserToken userToken = sessionManager.getToken(eRefillSession);
		String patientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		try {
			orderHistoryResponse = prescriptionService
					.getPatientOnlineOrderHistory(userToken, patientOID,
							dateFilter, requestStateWrapper, pageNum, strLocale);
			if (orderHistoryResponse.getUserToken() != null) {
				sessionManager.setToken(orderHistoryResponse.getUserToken(),
						eRefillSession);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		LOGGER.debug("Exiting getMedicationRecord in Prescription Business Delegate");
		return orderHistoryResponse;
	}

	/**
	 * getPrescRequestParameterList
	 * 
	 * @param dto
	 * @return
	 */
	public List<Object> getPrescRequestParameterList(DataCarrier dto) {
		try {
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionService
					.getPrescRequestParameterList(dto);
			return prescriptionFilterResponse.getParameterList();
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
            ErrorHandler.handleException(e);
			return null;
		}
	}

	/**
	 * getPrescriptionList
	 * 
	 * @param dto
	 * @param parameterList
	 * @param locale
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getPrescriptionList(DataCarrier dto,
			List<Object> parameterList, String locale) {
		try {
			String patientOID = sessionManager
					.getSelectedPatientOID((ERefillSession) dto
							.getObject("eRefillSession"));
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionService
					.getPrescriptionList(dto, patientOID, parameterList, locale);
			if (dto.getObject("eRefillSession") != null) {
				sessionManager.setToken(
						prescriptionFilterResponse.getUserToken(),
						(ERefillSession) dto.getObject("eRefillSession"));
			}
			return prescriptionFilterResponse;
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e.getStackTrace());
			ErrorHandler.handleException(e);
            return null;
		}
	}

	/**
	 * getGlobalNotification
	 * 
	 * @param dto
	 * @return
	 */
	public XMLGregorianCalendar getGlobalNotification(DataCarrier dto) {
		try {
			PrescriptionFilterResponse prescriptionFilterResponse = prescriptionService
					.getCalendar(dto);
			if (dto.getObject("eRefillSession") != null) {
				sessionManager.setToken(
						prescriptionFilterResponse.getUserToken(),
						(ERefillSession) dto.getObject("eRefillSession"));
			}
			return prescriptionFilterResponse.getCalendar();
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
            ErrorHandler.handleException(e);
			return null;
		}
	}

	/**
	 * getMedicationRecordDetail
	 * 
	 * @param eRefillSession
	 * @param strDIN
	 * @param locale
	 * @return
	 */
	public MedicationRecordDetailResponse getMedicationRecordDetail(
			ISession eRefillSession, String strDIN, String locale) {
		LOGGER.debug("Entering Prescription Business Delegate");
		MedicationRecordDetailResponse medicationRecordDetailResponse = new MedicationRecordDetailResponse();
		UserToken userToken = sessionManager.getToken(eRefillSession);
		String patientOID = sessionManager
				.getSelectedPatientOID(eRefillSession);
		try {
			DrugInformationResponse drugInformationResponse = prescriptionService
					.getMedCouncellingSheet(userToken, locale, strDIN);
			if (drugInformationResponse != null) {
				medicationRecordDetailResponse
						.setDrugInformation(drugInformationResponse
								.getDrugInformation());
				medicationRecordDetailResponse
						.setUserToken(drugInformationResponse.getUserToken());
				DrugHeaderViewResponse drugHeaderViewResponse = prescriptionService
						.getDrugOverlayHeader(
								drugInformationResponse.getUserToken(),
								patientOID, strDIN, locale);
				if (drugHeaderViewResponse != null) {
					medicationRecordDetailResponse
							.setDrugHeaderView(drugHeaderViewResponse
									.getDrugHeaderView());
					medicationRecordDetailResponse
							.setUserToken(drugHeaderViewResponse.getUserToken());
					if (drugHeaderViewResponse.getDrugHeaderView() == null) {
						DrugListResponse drugListResponse = prescriptionService
								.getDrugHeaderFrmOrdHist(
										drugHeaderViewResponse.getUserToken(),
										patientOID, strDIN);
						if (drugListResponse != null) {
							medicationRecordDetailResponse
									.setDrugList(drugListResponse.getDrugList());
							medicationRecordDetailResponse
									.setUserToken(drugListResponse
											.getUserToken());
						}
					}
				} else {
					DrugListResponse drugListResponse = prescriptionService
							.getDrugHeaderFrmOrdHist(
									drugInformationResponse.getUserToken(),
									patientOID, strDIN);
					if (drugListResponse != null) {
						medicationRecordDetailResponse
								.setDrugList(drugListResponse.getDrugList());
						medicationRecordDetailResponse
								.setUserToken(drugListResponse.getUserToken());
					}
				}
				if (medicationRecordDetailResponse.getUserToken() != null) {
					sessionManager.setToken(userToken, eRefillSession);
				}
			}
			return medicationRecordDetailResponse;
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
            ErrorHandler.handleException(e);
		}
		LOGGER.debug("Exiting Prescription Business Delegate");
		return medicationRecordDetailResponse;
	}

	/**
	 * getDrugDetails
	 * 
	 * @param session
	 * @param strDin
	 * @param locale
	 * @return
	 */
	public DataCarrier getDrugDetails(ISession session, String strDin,
			String locale) {
		DataCarrier dto = new DataCarrier();

		try {
			UserToken userToken = sessionManager.getToken(session);
			String patientOID = sessionManager.getSelectedPatientOID(session);
			dto = prescriptionService.getDrugInfo(userToken, patientOID,
					strDin, locale);
			/*sessionManager.setToken((UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN), session);*/
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
            ErrorHandler.handleException(e);
			return null;
		} finally {
			
			try {
				sessionManager.setToken((UserToken) dto
						.getObject(ERefillConstants.REQUEST_USER_TOKEN), session);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * getRefillHistory
	 * 
	 * @param session
	 * @param prescOID
	 * @param pageNum
	 * @param locale
	 * @return
	 */
	public DataCarrier getRefillHistory(ISession session, String prescOID,
			Integer pageNum, String locale) {
		DataCarrier dto = new DataCarrier();
		try {
			UserToken userToken = sessionManager.getToken(session);
			String patientOID = sessionManager.getSelectedPatientOID(session);
			dto = prescriptionService.getRefillHistory(userToken, patientOID,
					prescOID, pageNum, locale);
			sessionManager.setToken((UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN), session);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("Exception: " + e);
			ErrorHandler.handleException(e);
            return null;
		}
		return dto;
	}

	/**
	 * processToMyPrescription
	 * 
	 * @param dto
	 */
	public PrescriptionFilterResponse processToMyPrescription(DataCarrier dto)
			throws ERefillApplicationException {
		final String methodName = "processToMyPrescription";
		PrescriptionFilterResponse response = null;
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}

		try {
			ERefillSession session = (ERefillSession) dto
					.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			UserToken userToken = sessionManager.getToken(session);
			if( LOGGER.isDebugEnabled() ) {
				LOGGER.debug("the token 1 is:---------->>>> " +userToken);
			}
			
			
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			response = prescriptionService.processToMyPrescription(dto);
			String patientOID = (String) dto
					.getObject(ERefillConstants.SELECTED_PATIENT_OID);
			
			if( LOGGER.isDebugEnabled() ) {
				LOGGER.debug("the token 2 is:---------->>>> " +userToken);
			}
			
			PharmaDeptVO pharmaStores = pharmaService.getPharmaStores(
					userToken, null, patientOID, session);
			//String storeId = null;
			if (pharmaStores != null) {
				sessionManager.setPharmaDetails(pharmaStores, session);
				dto.addObject(ERefillConstants.REQUEST_PHARMACY, pharmaStores);

				/*if (pharmaStores.getPharmaVO() != null) {
					storeId = pharmaStores.getPharmaVO().getStoreId();
				}*/
			}

			if( LOGGER.isDebugEnabled() ) {
				LOGGER.debug("the token 3 is:---------->>>> " +userToken);
			}
			/*AutomatedRefillResponse automatedRefillResponse = operationService
					.getAutomatedRefillByPatientOID(userToken, patientOID,
							storeId, (String)dto.getObject(ERefillConstants.MAP_KEY_LOCALE));
			dto.addObject(ERefillConstants.MAP_KEY_AUTOMATED_REFILL_RESPONSE,
					automatedRefillResponse.getAutomatedRefillList());*/

			if( LOGGER.isDebugEnabled() ) {
				LOGGER.debug("the token 4 is:---------->>>> " +userToken);
			}
			/*RefillReminderResponse refillReminderResponse = operationService
					.getRefillRemindersByPatientOID(userToken, patientOID);
			if (refillReminderResponse != null
					&& refillReminderResponse.getReminderList() != null) {
				dto.addObject(
						ERefillConstants.MAP_KEY_REFILL_REMINDER_RESPONSE,
						refillReminderResponse.getReminderList());
			}*/

			if( LOGGER.isDebugEnabled() ) {
				LOGGER.debug("the token 5 is:---------->>>> " +userToken);
			}
			sessionManager.setToken((UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN), session);

		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(methodName + " Exception: " + e);
			ErrorHandler.handleException(e);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
		return response;
	}
}
