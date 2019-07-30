/**
 * 
 */
package com.lcl.erefill.core.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.IPharmacyDetailService;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PharmaDeptVO;

/**
 * @author hkokel version 1.0
 */
@Component
public class PharmacyBusinessDelegate implements IPharmacyBusinessDelegate {

	private static final Logger logger = LoggerFactory
			.getLogger(PharmacyBusinessDelegate.class);

	@Autowired
	IPharmacyDetailService pharmaService;

	@Autowired
	SessionManager sessionManager;

	/**
	 * getPharmacyDetails
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getPharmacyDetails(DataCarrier dto) {
		UserToken userToken;
		DataCarrier dc = new DataCarrier();
		try {
			ERefillSession eRefillSession = (ERefillSession) dto
					.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			userToken = (UserToken) sessionManager.getToken(eRefillSession);
			PharmaDeptVO pharmaStores = pharmaService.getPharmaStores(
					userToken, null, null, eRefillSession);

			if (pharmaStores == null) {
				dc.addObject("error", "Pharma details not found");
			} else {
				dc.addObject(ERefillConstants.REQUEST_PHARMACY, pharmaStores);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
		}
		return dc;
	}

	/**
	 * getOperatingHours
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getOperatingHours(DataCarrier dto) {
		try {
			String storeId = (String) dto.getObject(ERefillConstants.STOREID);
			ERefillSession eRefillSession = (ERefillSession) dto
					.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
			UserToken userToken = (UserToken) sessionManager.getToken(eRefillSession);
		
			String jsonOpHours = pharmaService.getOperatingHours(userToken, storeId, eRefillSession);
			dto = new DataCarrier();

			dto.addObject(ERefillConstants.OPERATINGHOURS, jsonOpHours);
		}  catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
		}

		return dto;
	}

	/**
	 * getDelOperatingHours
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getDelOperatingHours(DataCarrier dto) {
		try {
			String storeId = (String) dto.getObject(ERefillConstants.STOREID);
			String jsonDelOpHours = pharmaService.getDelOperatingHours(storeId);
			dto = new DataCarrier();

			dto.addObject(ERefillConstants.DEL_OPERATING_HOURS, jsonDelOpHours);
		}  catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
		}

		return dto;
	}

	/**
	 * getPharmaStores
	 * 
	 * @param eRefillSession
	 * @param storeId
	 * @return pharmaStores
	 */
	public PharmaDeptVO getPharmaStores(ERefillSession eRefillSession,
			String storeId) {
		final String methodName = "getPharmaStores";
		PharmaDeptVO pharmaStores = null;
		UserToken userToken = null;
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
        try{
		 userToken = sessionManager.getToken(eRefillSession);
		 pharmaStores = pharmaService.getPharmaStores(userToken,
				null, null, eRefillSession);
        } catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception: " + e);
		}
		if (pharmaStores != null) {
			sessionManager.setToken(userToken, eRefillSession);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return pharmaStores;
	}
}
