package com.lcl.erefill.core.services;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;

/***
 * 
 * @author gpunno version 1.0
 */

@Component
public interface IManagedAccountService {
	
	/**
	 * accountAssignManagerRequest
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public DataCarrier accountAssignManagerRequest (DataCarrier dto,UserToken userToken);

	/**
	 * deleteAccountAssociation
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken deleteAccountAssociation(DataCarrier dto,
			UserToken userToken);

	/**
	 * familyManagerAssignAccept
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken familyManagerAssignAccept(DataCarrier dto,
			UserToken userToken);

	/**
	 * familyManagerAssignDecline
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken familyManagerAssignDecline(DataCarrier dto,
			UserToken userToken);


	/**
	 * getManagerRequest
	 * 
	 * @param userToken
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getManagerRequest(UserToken userToken) throws Exception;

	/**
	 * managerAssignAccountRequest
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public DataCarrier managerAssignAccountRequest(DataCarrier dto,
			UserToken userToken);
	
	/**
	 * getHierarchicalParameters
	 * 
	 * @param userToken
	 * @param contractNumber
	 * @param patientOID
	 * @return
	 */
	public DataCarrier getHierarchicalParameters(UserToken userToken,String contractNumber, 
			String patientOID,String StoreId);

	/**
	 * @param userToken
	 * @return
	 */
	public DataCarrier getAssignedPatients(DataCarrier dc,UserToken userToken);

	/**
	 * @param dataCarrier
	 * @param userToken
	 * @return
	 */
	public Integer pendingCustodianRequests(DataCarrier dataCarrier,UserToken userToken);
	
	public Map<String , String> getPatientOID(UserToken userToken, String username);
		
	
}