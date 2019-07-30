/**
 * 
 */
package com.lcl.erefill.core.business;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.RxNewRequest;

/**
 * @author hkokel version 1.0
 */
@Component
public interface IRefillRequestBusinessDelegate {

	/**
	 * refillRequest
	 * 
	 * @param dto
	 * @return dto
	 */
	public DataCarrier refillRequest(DataCarrier dto);

	/**
	 * refillRequestSubmit
	 * 
	 * @param dto
	 * @return dto
	 */
	public DataCarrier refillRequestSubmit(DataCarrier dto);

	/**
	 * addAutomatedRefill
	 * 
	 * @param session
	 * @param rxNewRequest
	 * @return operationAddResponse
	 */
	public OperationAddResponse addAutomatedRefill(ERefillSession session,
			RxNewRequest rxNewRequest,String locale);

	/**
	 * addRefillReminder
	 * 
	 * @param session
	 * @param rxNewRequest
	 * @param dateRange
	 * @return operationAddResponse
	 */
	public OperationAddResponse addRefillReminder(ERefillSession session,
			RxNewRequest rxNewRequest, int dateRange);

	/**
	 * deleteAutomatedRefill
	 * 
	 * @param session
	 * @param oid
	 * @return operationAddResponse
	 */
	public OperationAddResponse deleteAutomatedRefill(ERefillSession session,
			String oid);

	/**
	 * deleteRefillReminder
	 * 
	 * @param session
	 * @param oid
	 * @return
	 */
	public OperationAddResponse deleteRefillReminder(ERefillSession session,
			String oid);

	/**
	 * updateAutoRefillView
	 * 
	 * @param session
	 * @param oid
	 * @return phoneStatus
	 */
	public Map<String, String> updateAutoRefillView(ERefillSession session,
			String oid);
	
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
			AutoRefillReminderRequest autoRefillReminderRequest, String oid);
}
