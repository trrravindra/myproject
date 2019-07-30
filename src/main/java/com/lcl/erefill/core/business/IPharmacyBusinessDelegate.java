/**
 * 
 */
package com.lcl.erefill.core.business;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PharmaDeptVO;

/**
 * @author hkokel
 * version 1.0
 */
@Component
public interface IPharmacyBusinessDelegate {

	/**
	 * getPharmacyDetails
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getPharmacyDetails(DataCarrier dto);

	/**
	 * getOperatingHours
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getOperatingHours(DataCarrier dto);

	/**
	 * getDelOperatingHours
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getDelOperatingHours(DataCarrier dto);
	
	/**
	 * getPharmaStores
	 * 
	 * @param eRefillSession
	 * @param storeId
	 * @return pharmaStores
	 */
	public PharmaDeptVO getPharmaStores(ERefillSession eRefillSession, String storeId);
}
