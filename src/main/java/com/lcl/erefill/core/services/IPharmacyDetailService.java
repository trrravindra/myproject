package com.lcl.erefill.core.services;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.PharmacyVO;

@Component
public interface IPharmacyDetailService {

	/**
	 * getPharmaStores
	 * 
	 * @param userToken
	 * @param storeId
	 * @param session
	 * @return
	 */
	public PharmaDeptVO getPharmaStores(UserToken userToken, String storeId,
			String patientOID, ISession session);

	/**
	 * getPharmacyDetails
	 * 
	 * @param userToken
	 * @param storeId
	 * @param patientOID
	 * @param session
	 * @return pharmaDetails
	 */
	public PharmacyVO getPharmacyDetails(UserToken userToken, String storeId,
			String patientOID, ISession session);

	/**
	 * getDelOperatingHours
	 * 
	 * @param storeId
	 * @return
	 */
	public String getDelOperatingHours(String storeId);

	/**
	 * getOperatingHours
	 * 
	 * @param userToken
	 * @param storeId
	 * @param eRefillSession 
	 * @return
	 */
	public String getOperatingHours(UserToken userToken, String storeId, ISession eRefillSession);

	/**
	 * getStoreInfo
	 * 
	 * @param storeId
	 * @return
	 */
	public HashMap<String, Object> getStoreInfo(String storeId);
}
