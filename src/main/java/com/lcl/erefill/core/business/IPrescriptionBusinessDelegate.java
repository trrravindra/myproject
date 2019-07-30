package com.lcl.erefill.core.business;

import java.util.List;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.telus.response.MedicationRecordDetailResponse;
import com.lcl.erefill.core.common.telus.response.MedicationRecordResponse;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.MedicationRecordModel;

@Component
public interface IPrescriptionBusinessDelegate {

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
			MedicationRecordModel medicationRecordModel, String pageNumber,
			Locale locale);

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
			String requestStateWrapper, int pageNum, String strLocale);

	/**
	 * getPrescRequestParameterList
	 * 
	 * @param dto
	 * @return
	 */
	public List<Object> getPrescRequestParameterList(DataCarrier dto);

	/**
	 * getPrescriptionList
	 * 
	 * @param dto
	 * @param parameterList
	 * @param locale
	 * @return
	 */
	public PrescriptionFilterResponse getPrescriptionList(DataCarrier dto,
			List<Object> parameterList, String locale);

	/**
	 * getGlobalNotification
	 * 
	 * @param dto
	 * @return
	 */
	public XMLGregorianCalendar getGlobalNotification(DataCarrier dto);

	/**
	 * getMedicationRecordDetail
	 * 
	 * @param session
	 * @param strDIN
	 * @param locale
	 * @return
	 */
	public MedicationRecordDetailResponse getMedicationRecordDetail(
			ISession session, String strDIN, String locale);

	/**
	 * getDrugDetails
	 * 
	 * @param session
	 * @param strDin
	 * @param locale
	 * @return
	 */
	public DataCarrier getDrugDetails(ISession session, String strDin,
			String locale);

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
			Integer pageNum, String locale);

	/**
	 * processToMyPrescription
	 * 
	 * @param dto
	 */
	public PrescriptionFilterResponse processToMyPrescription(DataCarrier dto);
}
