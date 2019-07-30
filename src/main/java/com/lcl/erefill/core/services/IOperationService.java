package com.lcl.erefill.core.services;

import com.lcl.erefill.core.common.telus.response.AutomatedRefillCalendarResponse;
import com.lcl.erefill.core.common.telus.response.AutomatedRefillResponse;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.common.telus.response.RefillReminderResponse;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.core.vo.RxNewRequest;

/**
 * 
 * @author vsha51
 * 
 */
public interface IOperationService {

	/**
	 * getExpectedAutomatedRefill
	 * 
	 * @param userToken
	 * @param storeId
	 * @param originalPrescriptionOID
	 * @param releaseMode
	 * @param daysSupply 
	 * @param rxDate 
	 * @return automatedRefillCalendarResponse
	 */
	public AutomatedRefillCalendarResponse getExpectedAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String storeId, String originalPrescriptionOID, String releaseMode, int rxDate, short daysSupply);

	/**
	 * addAutomatedRefill
	 * 
	 * @param userToken
	 * @param patientOID
	 * @param rxNewRequest
	 * @return operationAddResponse
	 */
	public OperationAddResponse addAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, RxNewRequest rxNewRequest,String locale);

	/**
	 * getAutomatedRefillByPatientOID
	 * 
	 * @param userToken
	 * @param patientOID
	 * @param storeId
	 * @param locale 
	 * @return automatedRefillResponse
	 */
	public AutomatedRefillResponse getAutomatedRefillByPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, String storeId, String locale);

	/**
	 * getRefillRemindersByPatientOID
	 * 
	 * @param userToken
	 * @param patientOID
	 * @return refillReminderResponse
	 */
	public RefillReminderResponse getRefillRemindersByPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID);

	/**
	 * addRefillReminder
	 * 
	 * @param userToken
	 * @param originalPrescriptionOID
	 * @param patientOID
	 * @param bufferTimeHours
	 * @param email
	 * @param phone
	 * @return operationAddResponse
	 */
	public OperationAddResponse addRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String originalPrescriptionOID, String patientOID,
			int bufferTimeHours, String email, String phone);

	/**
	 * deleteAutomatedRefill
	 * 
	 * @param userToken
	 * @param Oid
	 * @return opResponse
	 */
	public OperationAddResponse deleteAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid);

	/**
	 * deleteRefillReminder
	 * 
	 * @param userToken
	 * @param oid
	 * @return
	 */
	public OperationAddResponse deleteRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid);

	/**
	 * updateAutoRefillReminder
	 * 
	 * @param userToken
	 * @param autoRefillReminderRequest
	 * @param oid
	 * @param patientOid
	 * @return
	 */
	public OperationAddResponse updateAutoRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			AutoRefillReminderRequest autoRefillReminderRequest, String oid,
			String patientOid);

	/**
	 * getAutomatedRefillByOID
	 * 
	 * @param userToken
	 * @param oid
	 * @return automatedRefillResponse
	 */
	public AutomatedRefillResponse getAutomatedRefillByOID(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid);
}
