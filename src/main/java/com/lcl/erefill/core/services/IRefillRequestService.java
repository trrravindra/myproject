/**
 * 
 */
package com.lcl.erefill.core.services;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;

/**
 * @author hkokel
 * version 1.0
 */
@Component
public interface IRefillRequestService {
	
	/**
	 * refillRequest
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier refillRequest(DataCarrier dto);
	
	/**
	 * refillRequestSubmit
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier refillRequestSubmit(DataCarrier dto);

}
