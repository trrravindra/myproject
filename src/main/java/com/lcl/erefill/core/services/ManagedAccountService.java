package com.lcl.erefill.core.services;

import static com.lcl.erefill.core.constants.ERefillConstants.REQUEST_USER_TOKEN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.common.telus.response.GetAssignedPatientsResponse;
import com.lcl.erefill.core.common.telus.response.ManagedAccountResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.integ.telus.ManagerWSImpl;
import com.lcl.erefill.core.vo.FamilyManagerPatientRequestsVO;
import com.lcl.erefill.core.vo.Patient;

/****
 * 
 * @author gpunno version 1.0
 */

@Component
public class ManagedAccountService implements IManagedAccountService {

	private static final Logger logger = LoggerFactory.getLogger(ManagedAccountService.class);

	@Autowired
	ManagerWSImpl managerWSImpl;

	/**
	 * accountAssignManagerRequest
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 * @throws Exception
	 */
	public DataCarrier accountAssignManagerRequest(DataCarrier dto, UserToken userToken) {
		String guestUserName = StringUtils.EMPTY;
		String consentOid = StringUtils.EMPTY;
		String relationship = StringUtils.EMPTY;
		DataCarrier dataCarrier = null;
		try {
			guestUserName = (String) dto.getObject(ERefillConstants.GUEST_USER_NAME);
			consentOid = (String) dto.getObject(ERefillConstants.CONSENT_OID);
			relationship = (String) dto.getObject(ERefillConstants.RELATIONSHIP);
			dataCarrier = managerWSImpl.accountAssignManagerRequest(userToken, guestUserName, "", false, consentOid, relationship);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return dataCarrier;
	}

	/**
	 * managerAssignAccountRequest
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public DataCarrier managerAssignAccountRequest(DataCarrier dto, UserToken userToken) {

		String guestUserName = StringUtils.EMPTY;
		String consentOid = StringUtils.EMPTY;
		String description = StringUtils.EMPTY;
		String guestPassword = StringUtils.EMPTY;
		DataCarrier dataCarrier = null;
		try {
			guestUserName = (String) dto.getObject(ERefillConstants.GUEST_USER_NAME);
			consentOid = (String) dto.getObject(ERefillConstants.CONSENT_OID);
			guestPassword = (String) dto.getObject(ERefillConstants.PASSWORD);
			description = (String) dto.getObject(ERefillConstants.RELATIONSHIP);
			dataCarrier = managerWSImpl.managerAssignAccountRequest(userToken, guestUserName, guestPassword, true, consentOid, description);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return dataCarrier;
	}

	/**
	 * deleteAccountAssociation
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken deleteAccountAssociation(DataCarrier dto, UserToken userToken) {
		String managerUserName = StringUtils.EMPTY;
		String managedUserName = StringUtils.EMPTY;
		Boolean sendNotification = false;
		UserToken retUserToken = null;
		try {
			managerUserName = (String) dto.getObject(ERefillConstants.MANAGER_USERNAME);
			managedUserName = (String) dto.getObject(ERefillConstants.MANAGED_USERNAME);			
			String notify = (String)dto.getObject(ERefillConstants.SEND_NOTIFICATION);
			sendNotification  = Boolean.valueOf(notify);			
			retUserToken = managerWSImpl.deleteAccountAssociation(userToken, managerUserName, managedUserName, sendNotification);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error("Error: " + e1);
		}
		return retUserToken;
	}

	/**
	 * getAssignedPatients
	 * 
	 * @param dto
	 * @return
	 */
	public DataCarrier getAssignedPatients(DataCarrier dc, UserToken userToken) {

		try {

			GetAssignedPatientsResponse assignedPatientsResponse = managerWSImpl.getAssignedPatients(userToken, "All");

			List<AssignedPatientResponse> assignedPatientsList = null;
			if (assignedPatientsResponse.getAssignedPatients() != null) {
				assignedPatientsList = new ArrayList<AssignedPatientResponse>();
				List<Patient> patientsList = assignedPatientsResponse.getAssignedPatients();
				AssignedPatientResponse loggedInPatient = new AssignedPatientResponse();
				loggedInPatient.setFirstName((String) dc.getObject(ERefillConstants.EREFILL_FIRSTNAME));
				loggedInPatient.setLastName((String) dc.getObject("lastName"));
				loggedInPatient.setPatientOID((String) dc.getObject(ERefillConstants.PATIENT_OID));
				loggedInPatient.setBirthYear("You");
				assignedPatientsList.add(loggedInPatient);

				for (Patient patient : patientsList) {
					AssignedPatientResponse assignedPatient = new AssignedPatientResponse();
					assignedPatient.setFirstName(patient.getFirstName());
					assignedPatient.setLastName(patient.getLastName());
					assignedPatient.setBirthYear(Integer.toString(patient.getBirthDate()).substring(0, 4));
					assignedPatient.setPatientOID(patient.getOid());
					assignedPatientsList.add(assignedPatient);
				}

				dc.addObject(ERefillConstants.ASSIGNED_PATIENTS, assignedPatientsList);
				dc.addObject(REQUEST_USER_TOKEN, assignedPatientsResponse.getUserToken());
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error("Error: " + e1);
		}

		return dc;

	}

	/**
	 * familyManagerAssignAccept
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken familyManagerAssignAccept(DataCarrier dto, UserToken userToken) {
		String requestorUserName = StringUtils.EMPTY;
		String consentOID = StringUtils.EMPTY;
		UserToken retUserToken = null;
		try {
			requestorUserName = (String) dto.getObject(ERefillConstants.REQUESTOR_USERNAME);
			consentOID = (String) dto.getObject(ERefillConstants.CONSENT_OID);
			retUserToken = managerWSImpl.familyManagerAssignAccept(userToken, requestorUserName, consentOID);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error("Error: " + e1);
		}
		return retUserToken;
	}

	/**
	 * familyManagerAssignDecline
	 * 
	 * @param dto
	 * @param userToken
	 * @return
	 */
	public UserToken familyManagerAssignDecline(DataCarrier dto, UserToken userToken) {
		String requestorUserName = StringUtils.EMPTY;
		UserToken retUserToken = null;
		try {
			requestorUserName = (String) dto.getObject(ERefillConstants.REQUESTOR_USERNAME);
			retUserToken = managerWSImpl.familyManagerAssignDecline(userToken, requestorUserName);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error("Error: " + e1);
		}
		return retUserToken;
	}

	/**
	 * getManagerRequest
	 * 
	 * @param userToken
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getManagerRequest(UserToken userToken) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ManagedAccountResponse managedAccountResponse = new ManagedAccountResponse();
			managedAccountResponse = managerWSImpl.getManagerRequest(userToken, "Pending");

			if (null != managedAccountResponse && null != managedAccountResponse.getUserToken()) {
				List<FamilyManagerPatientRequestsVO> pendingListManager = null;
				map.put("PendingListManager", managedAccountResponse.getManagerMap().get("pendingListManager"));
				if (null != managedAccountResponse.getManagerMap()) {
					pendingListManager = (List<FamilyManagerPatientRequestsVO>) managedAccountResponse.getManagerMap().get("pendingListManager");
				}
				if (pendingListManager != null)
					map.put(ERefillConstants.PENDING_CUSTODIANREQUESTS, pendingListManager.size());
				else
					map.put(ERefillConstants.PENDING_CUSTODIANREQUESTS, null);

				userToken = managedAccountResponse.getUserToken();

				managedAccountResponse = new ManagedAccountResponse();
				managedAccountResponse = managerWSImpl.getManagerRequest(userToken, "All");
				map.put("AcceptedListManager", managedAccountResponse.getManagerMap().get("acceptedListManager"));

				userToken = managedAccountResponse.getUserToken();
				managedAccountResponse = new ManagedAccountResponse();
				managedAccountResponse = managerWSImpl.getFamilyManager(userToken, "Pending");
				map.put("familyListPending", managedAccountResponse.getManagerMap().get("PendingListFamily"));

				userToken = managedAccountResponse.getUserToken();
				managedAccountResponse = new ManagedAccountResponse();
				managedAccountResponse = managerWSImpl.getFamilyManager(userToken, "Accepted");
				map.put("familyListAccepted", managedAccountResponse.getManagerMap().get("AcceptedListFamily"));

				map.put("status", userToken.getStatus());
				map.put("token", userToken.getToken());
			}
		}catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return map;
	}

	/**
	 * getHierarchicalParameters
	 * 
	 * @param userToken
	 * @param contractNumber
	 * @param patientOID
	 * @return
	 */
	public DataCarrier getHierarchicalParameters(UserToken userToken, String contractNumber, String patientOID, String StoreId) {
		DataCarrier dc = new DataCarrier();
		try {
			dc = managerWSImpl.getHierarchicalParameters(userToken, contractNumber, patientOID, StoreId);

		}catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return dc;

	}

	/**
	 * pendingCustodianRequests
	 * 
	 * @param userToken
	 * @return
	 */

	public Integer pendingCustodianRequests(DataCarrier dataCarrier, UserToken userToken) {
		try {
			return managerWSImpl.pendingCustodianRequests(dataCarrier, userToken);
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			//return null;
			ErrorHandler.handleException(e);
			return null;
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			return null;
			}
	}

	
	public Map<String , String> getPatientOID(UserToken userToken, String username) {
		Map<String, String> resObj;		
		resObj= managerWSImpl.getPatientOID(userToken, username);
		return resObj;
	}

}
