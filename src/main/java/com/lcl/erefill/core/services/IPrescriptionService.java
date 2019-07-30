package com.lcl.erefill.core.services;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.DrugHeaderViewResponse;
import com.lcl.erefill.core.common.telus.response.DrugInformationResponse;
import com.lcl.erefill.core.common.telus.response.DrugListResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordResponse;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.vo.MedicationRecordModel;

@Component
public interface IPrescriptionService {

	/**
	 * processToMyPrescription
	 * 
	 * @param dto
	 */
	public PrescriptionFilterResponse processToMyPrescription(DataCarrier dto);

	/**
	 * getMedicationRecord
	 * 
	 * @param userToken
	 * @param medicationRecordModel
	 * @param pageNum
	 * @param locale
	 * @return medicationRecordResponse
	 */
	public MedicationRecordResponse getMedicationRecord(UserToken userToken,String patientOID,
			MedicationRecordModel medicationRecordModel, String pageNum,
			Locale locale);

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
			UserToken userToken,String patientOID, String dateFilter, String requestStateWrapper,
			int pageNum, String strLocale);

	/**
	 * getPrescRequestParameterList
	 * 
	 * @param dto
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getPrescRequestParameterList(
			DataCarrier dto);

	/**
	 * getPrescriptionList
	 * 
	 * @param dto
	 * @param parameterList
	 * @param locale
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getPrescriptionList(DataCarrier dto,String patientOID,
			List<Object> parameterList, String locale);

	/**
	 * getCalendar
	 * 
	 * @param dto
	 * @return prescriptionFilterResponse
	 */
	public PrescriptionFilterResponse getCalendar(DataCarrier dto);

	/**
	 * getDrugInfo
	 * 
	 * @param userToken
	 * @param strDin
	 * @param locale
	 * @return dto
	 */
	public DataCarrier getDrugInfo(UserToken userToken, String strDin,String patientOID,
			String locale);

	/**
	 * getMedCouncellingSheet
	 * 
	 * @param userToken
	 * @param locale
	 * @param strDIN
	 * @return drugInformationResponse
	 */ 
	public DrugInformationResponse getMedCouncellingSheet(UserToken userToken,
			String locale, String strDIN);

	/**
	 * getDrugOverlayHeader
	 * 
	 * @param userToken
	 * @param strDIN
	 * @param locale
	 * @return drugHeaderViewResponse
	 */
	public DrugHeaderViewResponse getDrugOverlayHeader(UserToken userToken,String patientOID,
			String strDIN, String locale);

	/**
	 * getDrugHeaderFrmOrdHist
	 * 
	 * @param userToken
	 * @param strDIN
	 * @return drugListResponse
	 */
	public DrugListResponse getDrugHeaderFrmOrdHist(UserToken userToken,String patientOID,
			String strDIN);

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
			String prescOID, Integer pageNum, String locale);
}
