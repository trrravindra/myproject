package com.lcl.erefill.core.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.DrugHeaderViewResponse;
import com.lcl.erefill.core.common.telus.response.DrugInformationResponse;
import com.lcl.erefill.core.common.telus.response.DrugListResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordResponse;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.common.telus.response.RefillHistoryResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.exception.NoCounsellingSheetException;
import com.lcl.erefill.core.services.integ.telus.AdvisorWSImpl;
import com.lcl.erefill.core.services.integ.telus.ProfileWSImpl;
import com.lcl.erefill.core.services.integ.telus.RequestWSImpl;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.DrugHeaderView;
import com.lcl.erefill.core.vo.DrugInformation;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.MedicationRecordModel;
import com.lcl.erefill.core.vo.PrescriptionModel;

@Component
public class PrescriptionService implements IPrescriptionService {

	private static final Logger logger = LoggerFactory
			.getLogger(PrescriptionService.class);

	@Autowired
	ProfileWSImpl profileWSImpl;

	@Autowired
	RequestWSImpl requestWSImpl;

	@Autowired
	SessionManager sessionManager;

	@Autowired
	AdvisorWSImpl advisorWSImpl;
	
	@Autowired
	PropertyUtil propertyUtil;

	/**
	 * processToMyPrescription
	 * 
	 * @param dto
	 */
	public PrescriptionFilterResponse processToMyPrescription(DataCarrier dto) {
		PrescriptionFilterResponse response = null;
		try {
			UserToken userToken = (UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN);
			ModelMap model = (ModelMap) dto
					.getObject(ERefillConstants.LOGIN_MODEL);
			PrescriptionModel prescriptionModel = (PrescriptionModel) dto
					.getObject("prescriptionModel");
			String patientOid = sessionManager
					.getSelectedPatientOID((ERefillSession) dto
							.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION));
			Integer pageNum = 1;
			boolean flagServCall = false;
			String dateFilter = ERefillConstants.LAST_730_DAYS;
			String sortField = ERefillConstants.LAST_FILLED_DATE;
			Date fromDate = null;
			Date toDate = null;
			Integer totalRecords = Integer.valueOf(0);
			Integer firstRecord = Integer.valueOf(0);
			Integer numOfPages = Integer.valueOf(0);

			String reqPageNum = prescriptionModel.getPage_num();
			String reqChkdPresc = "";
			String reqDateFilter = prescriptionModel.getDate_range();
			if (StringUtils.isBlank(reqDateFilter) || "all".equalsIgnoreCase(reqDateFilter)) {
				reqDateFilter = ERefillConstants.ALL_DAYS;
			}
			String reqSortField = prescriptionModel.getSort_by();
			if(StringUtils.isBlank(reqSortField)){
				reqSortField = ERefillConstants.LAST_FILLED_DATE;
			}
			String reqFromDate = prescriptionModel.getFrom();
			String reqToDate = prescriptionModel.getTo();

			List<Object> parameterList = profileWSImpl
					.getPrescRequestParameterList(reqPageNum, reqChkdPresc,
							reqDateFilter, reqSortField, reqFromDate, reqToDate);

			logger.info("Check service::" + parameterList);

			if (parameterList != null && parameterList.size() == 6) {
				pageNum = (Integer) parameterList.get(0);
				dateFilter = (String) parameterList.get(2);
				sortField = (String) parameterList.get(3);
				if (parameterList.get(4) != null)
					fromDate = (Date) parameterList.get(4);
				if (parameterList.get(5) != null)
					toDate = (Date) parameterList.get(5);
			}
			response = profileWSImpl
					.getListOfPrescriptions(userToken, patientOid, pageNum,
							sortField, dateFilter, fromDate, toDate,
							flagServCall, "myPrescriptions", (String) model.get("locale"),
							totalRecords, firstRecord, numOfPages);

			model.addAttribute("lstPresc", response.getLstPresc());
			model.addAttribute("strCheckedPresc", (String) parameterList.get(1));
			model.addAttribute("dateFilter", prescriptionModel.getDate_range());
			model.addAttribute("sortFilter", prescriptionModel.getSort_by());
			model.addAttribute("fromDate", reqFromDate);
			model.addAttribute("toDate", reqToDate);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("totalRecords", response.getTotalRecords()
					.intValue());
			model.addAttribute("numOfPages", response.getNumOfPages()
					.intValue());
			model.addAttribute("firstRecord", response.getFirstRecord()
					.intValue());
			userToken = response.getUserToken();
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);

		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			try {
				dto.addObject("status", e.getMessage());
			} catch (Exception e1) {
				logger.error("Exception: " + e1);
			}
			logger.error("Exception: " + e);
		}
		return response;

		}
		

	/**
	 * getMedicationRecord
	 * 
	 * @param userToken
	 * @param medicationRecordModel
	 * @param pageNum
	 * @param locale
	 * @return medicationRecordResponse
	 */
	public MedicationRecordResponse getMedicationRecord(UserToken userToken,
			String patientOID, MedicationRecordModel medicationRecordModel,
			String pageNumber, Locale locale) {

		MedicationRecordResponse medicationRecordResponse = new MedicationRecordResponse();
		boolean flagReload = false;
		int pageNum = 1;
		String filterDate = medicationRecordModel.getDate_range();
		if (StringUtils.isBlank(filterDate)) {
			filterDate = ERefillConstants.ALL_DAYS;
			flagReload = true;
		}
		if (StringUtils.isNotBlank(pageNumber)) {
			try {
				pageNum = Integer.parseInt(pageNumber);
			} catch (NumberFormatException ex) {
				pageNum = 1;
			}
		}
		String sortField = ERefillConstants.LAST_FILLED_DATE;
		Integer totalRecords = Integer.valueOf(0);
		Integer firstRecord = Integer.valueOf(0);
		Integer numOfPages = Integer.valueOf(0);
		PrescriptionFilterResponse prescriptionFilterResponse = null;

		try {
			prescriptionFilterResponse = profileWSImpl.getListOfPrescriptions(
					userToken, patientOID, pageNum, sortField, filterDate,
					null, null, flagReload, "myMedicationRecord",
					locale.toString(), totalRecords, firstRecord, numOfPages);
			medicationRecordResponse.setTotalRecords(prescriptionFilterResponse
					.getTotalRecords());
			medicationRecordResponse.setFirstRecord(prescriptionFilterResponse
					.getFirstRecord());
			medicationRecordResponse.setNumOfPages(prescriptionFilterResponse
					.getNumOfPages());
			medicationRecordResponse.setLstPresc(prescriptionFilterResponse
					.getLstPresc());
			medicationRecordResponse.setFilterDate(filterDate);
			medicationRecordResponse.setUserToken(prescriptionFilterResponse
					.getUserToken());
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}

		return medicationRecordResponse;
	}

	/**
	 * getPatientOnlineOrderHistory
	 * 
	 * @param userToken
	 * @param dateFilter
	 * @param requestStateWrapper
	 * @param pageNum
	 * @param strLocale
	 * @return orderHistoryResponse
	 */
	public OrderHistoryResponse getPatientOnlineOrderHistory(
			UserToken userToken, String patientOID, String dateFilter,
			String requestStateWrapper, int pageNum, String strLocale) {
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		try {
			orderHistoryResponse = requestWSImpl.getPatientOnlineOrderHistory(
					userToken, patientOID, dateFilter, requestStateWrapper,
					pageNum, strLocale);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return orderHistoryResponse;
	}

	/**
	 * getPrescRequestParameterList
	 * 
	 * @param dto
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getPrescRequestParameterList(
			DataCarrier dto) {
		try {
			PrescriptionFilterResponse prescriptionFilterResponse = new PrescriptionFilterResponse();
			String reqPageNum = dto.getObject("reqPageNum") != null ? dto
					.getObject("reqPageNum").toString() : null;
			String reqChkdPresc = dto.getObject("reqChkdPresc") != null ? dto
					.getObject("reqChkdPresc").toString() : null;
			String reqDateFilter = dto.getObject("reqDateFilter") != null ? dto
					.getObject("reqDateFilter").toString() : null;
			String reqSortField = dto.getObject("reqSortField") != null ? dto
					.getObject("reqSortField").toString() : null;
			String reqFromDate = dto.getObject("reqFromDate") != null ? dto
					.getObject("reqFromDate").toString() : null;
			String reqToDate = dto.getObject("reqToDate") != null ? dto
					.getObject("reqToDate").toString() : null;
			if ("all".equalsIgnoreCase(reqDateFilter)) {
				reqDateFilter = ERefillConstants.LAST_730_DAYS;
			}
			List<Object> parameterList = profileWSImpl
					.getPrescRequestParameterList(reqPageNum, reqChkdPresc,
							reqDateFilter, reqSortField, reqFromDate, reqToDate);
			prescriptionFilterResponse.setParameterList(parameterList);
			return prescriptionFilterResponse;

		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e.getStackTrace());
			ErrorHandler.handleException(e);
		}
		return null;
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
			String patientOID, List<Object> parameterList, String locale) {
		PrescriptionFilterResponse prescriptionFilterResponse = new PrescriptionFilterResponse();
		try {
			UserToken userToken = sessionManager.getToken((ERefillSession) dto
					.getObject("eRefillSession"));

			int pageNum = 1;
			boolean flagServCall = false;
			String dateFilter = ERefillConstants.LAST_730_DAYS;
			String sortField = ERefillConstants.LAST_FILLED_DATE;
			Date fromDate = null;
			Date toDate = null;

			String reqDateFilter = dto.getObject("reqDateFilter") != null ? dto
					.getObject("reqDateFilter").toString() : null;
			if (CommonUtils.isStringNullOrEmpty(reqDateFilter)) {
				flagServCall = true;
			}
			pageNum = (Integer) parameterList.get(0);
			dateFilter = (String) parameterList.get(2);
			sortField = (String) parameterList.get(3);
			if (parameterList.get(4) != null)
				fromDate = (Date) parameterList.get(4);
			if (parameterList.get(5) != null)
				toDate = (Date) parameterList.get(5);

			Integer totalRecords = Integer.valueOf(0);
			Integer firstRecord = Integer.valueOf(0);
			Integer numOfPages = Integer.valueOf(0);
			prescriptionFilterResponse = profileWSImpl.getListOfPrescriptions(
					userToken, patientOID, pageNum, sortField, dateFilter,
					fromDate, toDate, flagServCall, "myPrescriptions", locale,
					totalRecords, firstRecord, numOfPages);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return prescriptionFilterResponse;
	}

	/**
	 * getCalendar
	 * 
	 * @param dto
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getCalendar(DataCarrier dto) {
		PrescriptionFilterResponse prescriptionFilterResponse = new PrescriptionFilterResponse();
		try {
			UserToken userToken = sessionManager.getToken((ERefillSession) dto
					.getObject("eRefillSession"));
			String patientOid = sessionManager
					.getSelectedPatientOID((ERefillSession) dto
							.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION));
			Calendar c = Calendar.getInstance();
			
			//c.set(2011, 06, 01, 01, 01);
			
			/** Instead of calling whole order history, call only for the prescriptions which have been modified in last 7 days ~ <LastStateDate**/
			String displayDays=propertyUtil.getGLOBAL_NOTIFICATION_DISPLAY_DAYS();
			c.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(displayDays));

			XMLGregorianCalendar calendar = null;

			calendar = requestWSImpl.list(userToken, "ALL", c, patientOid);
			logger.info("calenda1r::" + calendar);
			prescriptionFilterResponse.setUserToken(userToken);
			prescriptionFilterResponse.setCalendar(calendar);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e.getStackTrace());
			ErrorHandler.handleException(e);
		}
		return prescriptionFilterResponse;
	}

	/**
	 * getMedCouncellingSheet
	 * 
	 * @param userToken
	 * @param locale
	 * @param strDIN
	 * @return drugInformationResponse
	 */
	public DrugInformationResponse getMedCouncellingSheet(UserToken userToken,
			String locale, String strDIN) {
		DrugInformation drugInformation = null;
		DrugInformationResponse drugInformationResponse = new DrugInformationResponse();
		try {
			drugInformation = advisorWSImpl.getMedCouncellingSheet(userToken,
					locale, strDIN);
			drugInformationResponse.setDrugInformation(drugInformation);
			drugInformationResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return drugInformationResponse;
	}

	/**
	 * getDrugOverlayHeader
	 * 
	 * @param userToken
	 * @param strDIN
	 * @param locale
	 * @return drugHeaderViewResponse
	 */
	public DrugHeaderViewResponse getDrugOverlayHeader(UserToken userToken,
			String patientOID, String strDIN, String locale) {
		DrugHeaderView drugHeaderView = null;
		DrugHeaderViewResponse drugHeaderViewResponse = new DrugHeaderViewResponse();
		try {
			drugHeaderView = advisorWSImpl.getDrugOverlayHeader(userToken,
					patientOID, strDIN, locale);
			drugHeaderViewResponse.setDrugHeaderView(drugHeaderView);
			drugHeaderViewResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return drugHeaderViewResponse;
	}

	/**
	 * getDrugHeaderFrmOrdHist
	 * 
	 * @param userToken
	 * @param strDIN
	 * @return drugListResponse
	 */
	public DrugListResponse getDrugHeaderFrmOrdHist(UserToken userToken,
			String patientOID, String strDIN) {
		List<String> drugList = null;
		DrugListResponse drugListResponse = new DrugListResponse();
		try {
			drugList = requestWSImpl.getDrugHeaderFrmOrdHist(userToken,
					patientOID, strDIN);
			drugListResponse.setDrugList(drugList);
			drugListResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return drugListResponse;
	}

	/**
	 * getDrugInfo
	 * 
	 * @param userToken
	 * @param strDin
	 * @param locale
	 * @return dto
	 */
	public DataCarrier getDrugInfo(UserToken userToken, String patientOID,
			String strDin, String locale) {

		DataCarrier dto = new DataCarrier();
		try {
			
		DrugInformation drugInfo = advisorWSImpl.getMedCouncellingSheet(
				userToken, locale, strDin);
		DrugHeaderView drugHeader = advisorWSImpl.getDrugOverlayHeader(
				userToken, patientOID, strDin, locale);
		String drugHeadName = null;
		String drugHeadStrength = null;
		if (null == drugHeader) {
			List<String> tempList = requestWSImpl.getDrugHeaderFrmOrdHist(
					userToken, patientOID, strDin);
			if (!CommonUtils.isNullOrEmpty(tempList)) {
				drugHeadName = tempList.get(0);
				drugHeadStrength = tempList.get(1);
			}
		}
		
		
			dto.addObject(ERefillConstants.DRUG_INFO, drugInfo);
			dto.addObject(ERefillConstants.DRUG_INFO_HEADER, drugHeader);
			dto.addObject(ERefillConstants.DRUG_INFO_HEADER_NAME, drugHeadName);
			dto.addObject(ERefillConstants.DRUG_INFO_HEADER_STRENGTH,
					drugHeadStrength);
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
		} catch ( NoCounsellingSheetException nce ) {
			try {
				dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ERefillBusinessException e) {			
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return dto;
	}

	/**
	 * getRefillHistory
	 * 
	 * @param userToken
	 * @param prescOID
	 * @param pageNum
	 * @param locale
	 * @return dto
	 */
	public DataCarrier getRefillHistory(UserToken userToken, String patientOID,
			String prescOID, Integer pageNum, String locale) {
		DataCarrier dto = new DataCarrier();
		try {
		RefillHistoryResponse refillHistoryResponse = profileWSImpl
				.getListRefillHistory(userToken, prescOID, pageNum, locale);
		DrugHeaderView drugHeader = profileWSImpl.getDrugDetailsHeader(
				userToken, prescOID, locale, patientOID);
		DrugInformation drugInfo = null;
		if (drugHeader != null) {
			drugInfo = advisorWSImpl.getMedCouncellingSheet(userToken, locale,
					drugHeader.getDin());
		}
		
		
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			dto.addObject(ERefillConstants.REFILL_HISTORY_LIST,
					refillHistoryResponse);
			dto.addObject(ERefillConstants.REFILL_HISTORY_DRUG_HEADER,
					drugHeader);
			dto.addObject(ERefillConstants.REFILL_HISTORY_DRUG_INFO, drugInfo);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
			ErrorHandler.handleException(e);
		}
		return dto;
	}

}
