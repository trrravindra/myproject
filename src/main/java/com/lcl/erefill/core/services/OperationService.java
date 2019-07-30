package com.lcl.erefill.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.telus.response.AutomatedRefillCalendarResponse;
import com.lcl.erefill.core.common.telus.response.AutomatedRefillResponse;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.common.telus.response.RefillReminderResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.OperationWSImpl;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.core.vo.RxNewRequest;

/**
 * 
 * @author vsha51
 * 
 */
@Component
public class OperationService implements IOperationService {

	private static final Logger logger = LoggerFactory.getLogger(OperationService.class);

	@Autowired
	OperationWSImpl operationWSImpl;

	/**
	 * getExpectedAutomatedRefill
	 * 
	 * @param userToken
	 * @param storeId
	 * @param originalPrescriptionOID
	 * @param releaseMode
	 * @return automatedRefillCalendarResponse
	 */
	public AutomatedRefillCalendarResponse getExpectedAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String storeId, String originalPrescriptionOID, String releaseMode, int rxDate, short daysSupply) {
		final String methodName = "getExpectedAutomatedRefill";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		AutomatedRefillCalendarResponse automatedRefillCalendarResponse = null;

		try{
		automatedRefillCalendarResponse = operationWSImpl.getExpectedAutomatedRefill(userToken, storeId, originalPrescriptionOID, releaseMode, rxDate, daysSupply);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return automatedRefillCalendarResponse;
	}

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
			String patientOID, RxNewRequest rxNewRequest,String locale) {
		final String methodName = "addAutomatedRefill";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		OperationAddResponse operationAddResponse = null;
        try{
		operationAddResponse = operationWSImpl.addAutomatedRefill(userToken,
				patientOID, rxNewRequest,locale);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

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
			String patientOID, String storeId, String locale) {
		final String methodName = "getAutomatedRefillByPatientOID";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		AutomatedRefillResponse automatedRefillResponse = null;
        try{
		automatedRefillResponse = operationWSImpl
				.getAutomatedRefillByPatientOID(userToken, patientOID, storeId, locale);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} 
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return automatedRefillResponse;
	}

	/**
	 * getRefillRemindersByPatientOID
	 * 
	 * @param userToken
	 * @param patientOID
	 * @return refillReminderResponse
	 */
	public RefillReminderResponse getRefillRemindersByPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID) {
		final String methodName = "getRefillRemindersByPatientOID";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		RefillReminderResponse refillReminderResponse = null;
        try{
		refillReminderResponse = operationWSImpl
				.getRefillRemindersByPatientOID(userToken, patientOID);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return refillReminderResponse;
	}

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
			int bufferTimeHours, String email, String phone) {
		final String methodName = "addRefillReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		OperationAddResponse operationAddResponse = null;

		logger.info(methodName + " originalPrescriptionOID: "+originalPrescriptionOID);
		logger.info(methodName + " patientOID: "+patientOID);
		logger.info(methodName + " email: "+email);
		logger.info(methodName + " phone: "+phone);
		try{
		operationAddResponse = operationWSImpl.addRefillReminder(userToken,
				originalPrescriptionOID, patientOID, bufferTimeHours, email,
				phone);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * deleteAutomatedRefill
	 * 
	 * @param userToken
	 * @param Oid
	 * @return opResponse
	 */
	public OperationAddResponse deleteAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "deleteAutomatedRefill";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		OperationAddResponse operationAddResponse = null;
        try{  
		operationAddResponse = operationWSImpl.deleteAutomatedRefill(userToken,
				oid);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * deleteRefillReminder
	 * 
	 * @param userToken
	 * @param oid
	 * @return
	 */
	public OperationAddResponse deleteRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "deleteRefillReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		OperationAddResponse operationAddResponse = null;
        try{
		operationAddResponse = operationWSImpl.deleteRefillReminder(userToken,
				oid);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

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
			String patientOid) {
		final String methodName = "updateAutoRefillReminder";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		OperationAddResponse operationAddResponse = null;
        try{
		operationAddResponse = operationWSImpl.updateAutoRefillReminder(
				userToken, autoRefillReminderRequest, oid, patientOid);
        }catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return operationAddResponse;
	}

	/**
	 * getAutomatedRefillByOID
	 * 
	 * @param userToken
	 * @param oid
	 * @return automatedRefillResponse
	 */
	public AutomatedRefillResponse getAutomatedRefillByOID(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "getAutomatedRefillByOID";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		AutomatedRefillResponse automatedRefillResponse = null;
		try{
		automatedRefillResponse = operationWSImpl.getAutomatedRefillByOID(
				userToken, oid);
		}catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return automatedRefillResponse;
	}
}
