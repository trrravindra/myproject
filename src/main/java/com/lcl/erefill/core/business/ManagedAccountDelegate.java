package com.lcl.erefill.core.business;

import static com.lcl.erefill.core.constants.ERefillConstants.REQUEST_USER_TOKEN;

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
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.IConsentService;
import com.lcl.erefill.core.services.IManagedAccountService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.services.ManagedAccountService;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;


/***
 * 
 * @author gpunno
 * version 1.0
 */

@Component
public class ManagedAccountDelegate implements IManagedAccountDelegate{
	
	@Autowired
	IManagedAccountService managedAccountService;
	
	@Autowired
	IConsentService consentService;
	
	@Autowired
	ISessionService sessionService;

	@Autowired
	SessionManager sessionManager;
	
	private ConsentVO consent = null;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagedAccountService.class);
	
	public ConsentVO getConsent(DataCarrier dto, ERefillSession session) {
		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		try {
			userToken = sessionManager.getToken(session);
		} catch (Exception e1) {
			logger.error("Exception: "+ e1);
		}
		
		try{
		consent = consentService.getConsent(dto, userToken);
		}catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
			return null;
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			return null;
			}
		userToken.setStatus(consent.getStatus());
		userToken.setToken(consent.getToken());
		sessionManager.setToken(userToken, session);
		return consent;
	}

	public DataCarrier grantAccess(DataCarrier dto, ERefillSession session) {
		
		try {
			com.lcl.erefill.core.common.entity.UserToken userToken = null;
			userToken = sessionManager.getToken(session);
			UpdatePreferencesResponse validUser = sessionService.verifyIdentity(dto, userToken);
			userToken.setStatus(validUser.getUserToken().getStatus());
			userToken.setToken(validUser.getUserToken().getToken());
			sessionManager.setToken(userToken, session);
			if(StringUtils.isNotBlank((String) dto.getObject(ERefillConstants.CONSENT_OID)) && 
					validUser!=null && "true".equalsIgnoreCase(validUser.getResponseStatus())) {
				dto = managedAccountService.accountAssignManagerRequest(dto, userToken);
				userToken = (UserToken) dto.getObject(ERefillConstants.REQUEST_USER_TOKEN);
				if(userToken!=null)
					sessionManager.setToken(userToken, session);
				else
					dto.addObject(ERefillConstants.ERROR, "sessionexpired");
				return dto;
			}else if(validUser!=null && "mismatch".equalsIgnoreCase(StringUtils.trimToEmpty(validUser.getResponseStatus()))) {
				dto.addObject(ERefillConstants.ERROR, "mismatch");
				return dto;
			}else
				return null;
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
			return null;
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			return null;
			}
		
	}

	@SuppressWarnings("unchecked")
	public void revokeAccess(DataCarrier dto, ERefillSession session) {
		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		try {
		userToken = sessionManager.getToken(session);
		userToken = managedAccountService.deleteAccountAssociation(dto, userToken);
		if(userToken !=null && StringUtils.isNotBlank((String) dto.getObject("requestType"))){
			dto.addObject(ERefillConstants.EREFILL_FIRSTNAME, sessionManager.getFirstName(session));
			dto.addObject(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(session));
			if(sessionManager.getPatient(session)!=null)
				dto.addObject("lastName",sessionManager.getPatient(session).getLastName());
			else
				dto.addObject("lastName","");
			dto = managedAccountService.getAssignedPatients(dto,userToken);
			sessionManager.setAssignedPatients((List<AssignedPatientResponse>) dto.getObject(ERefillConstants.ASSIGNED_PATIENTS),
					session);
			userToken = (UserToken) dto.getObject(REQUEST_USER_TOKEN);
			}
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		sessionManager.setToken(userToken, session);
	}

	@SuppressWarnings("unchecked")
	public void familyManagerAssignAccept(DataCarrier dto, ERefillSession session) {
		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		userToken = sessionManager.getToken(session);
		try {
			if(consent!=null) 
				dto.addObject(ERefillConstants.CONSENT_OID, consent.getOid());
			userToken = managedAccountService.familyManagerAssignAccept(dto, userToken);
			if(userToken !=null){
				dto.addObject(ERefillConstants.EREFILL_FIRSTNAME, sessionManager.getFirstName(session));
				dto.addObject(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(session));
				if(sessionManager.getPatient(session)!=null)
					dto.addObject("lastName",sessionManager.getPatient(session).getLastName());
				else
					dto.addObject("lastName","");	
				dto = managedAccountService.getAssignedPatients(dto,userToken);
				sessionManager.setAssignedPatients((List<AssignedPatientResponse>) dto.getObject(ERefillConstants.ASSIGNED_PATIENTS),
						session);
			userToken = (UserToken) dto
					.getObject(REQUEST_USER_TOKEN);
			}
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		
		sessionManager.setToken(userToken, session);
	}
	
	public void familyManagerAssignDecline(DataCarrier dto, ERefillSession session) {
		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		userToken = sessionManager.getToken(session);
		userToken = managedAccountService.familyManagerAssignDecline(dto, userToken);
		sessionManager.setToken(userToken, session);
	}
	
	
  public Map<String,Object> getManagedAccountDetails(ISession iSession) throws Exception{
		
	    com.lcl.erefill.core.common.entity.UserToken userToken = sessionManager.getToken(iSession);	
		Map<String, Object> managedAccountResponse = null;
		try {
			managedAccountResponse = managedAccountService.getManagerRequest(userToken);
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
			
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			
			}
		
		if(null != managedAccountResponse){
			
			userToken = new com.lcl.erefill.core.common.entity.UserToken();
			userToken.setStatus((String)managedAccountResponse.get("status"));
			userToken.setToken((String)managedAccountResponse.get("token"));
			sessionManager.setToken(userToken,iSession);
			if(managedAccountResponse.get(ERefillConstants.PENDING_CUSTODIANREQUESTS) !=null)			
				sessionManager.setPendingCustodianRequests((Integer) managedAccountResponse.get(ERefillConstants.PENDING_CUSTODIANREQUESTS), iSession);
			else
				sessionManager.setPendingCustodianRequests(null, iSession);
				
		}
		
		return managedAccountResponse;
	}

@SuppressWarnings("unchecked")
public DataCarrier setupCustodianForMinor(DataCarrier dto,
		ERefillSession session) {
	try {
		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		userToken = sessionManager.getToken(session);
		UpdatePreferencesResponse validUser = sessionService.verifyIdentity(dto, userToken);
		userToken.setStatus(validUser.getUserToken().getStatus());
		userToken.setToken(validUser.getUserToken().getToken());
		sessionManager.setToken(userToken, session);
		if(StringUtils.isNotBlank((String) dto.getObject(ERefillConstants.CONSENT_OID))
				&& validUser!=null && "true".equalsIgnoreCase(validUser.getResponseStatus())) {
			dto.addObject(ERefillConstants.CONSENT_OID, consent.getOid());
			dto = managedAccountService.managerAssignAccountRequest(dto, userToken);
			userToken = (UserToken) dto.getObject(ERefillConstants.REQUEST_USER_TOKEN);
			if(userToken !=null){
				dto.addObject(ERefillConstants.EREFILL_FIRSTNAME, sessionManager.getFirstName(session));
				dto.addObject(ERefillConstants.PATIENT_OID, sessionManager.getPatientID(session));
				if(sessionManager.getPatient(session)!=null)
					dto.addObject("lastName",sessionManager.getPatient(session).getLastName());
				else
					dto.addObject("lastName","");
				
				if(null!=dto.getObject(ERefillConstants.ERROR) && dto.getObject(ERefillConstants.ERROR).equals("password-error")){
					return dto;
				}
				dto = managedAccountService.getAssignedPatients(dto,userToken);
				sessionManager.setAssignedPatients((List<AssignedPatientResponse>) dto.getObject(ERefillConstants.ASSIGNED_PATIENTS),
						session);
				userToken = (UserToken) dto
						.getObject(REQUEST_USER_TOKEN);
				sessionManager.setToken(userToken, session);
			}else
				dto.addObject(ERefillConstants.ERROR, "sessionexpired");
		}else if(validUser!=null && "mismatch".equalsIgnoreCase(StringUtils.trimToEmpty(validUser.getResponseStatus()))) {
			dto.addObject(ERefillConstants.ERROR, "mismatch");
			return dto;
		}else
			return null;
	} catch (Exception e) {
		logger.error("Exception while fetching managed account details:  " + e);
		ErrorHandler.handleException(e);
		return null;
	}catch (Error e) {
		logger.error(e.getMessage(), e);
		ErrorHandler.handleError(e);
		return null;
		}
	return dto;
}
	public int getMinorAge(ERefillSession session) {
		int ageLimit=14;
		try {
			com.lcl.erefill.core.common.entity.UserToken userToken = null;
			userToken = sessionManager.getToken(session);
			String patientOid=sessionManager.getPatientID(session);
			String storeId=sessionManager.getPharmacyDetails(session).getPharmaVO().getStoreId();
			
			String contractNumber=StringUtils.EMPTY;
			
			DataCarrier dataCarrier = managedAccountService.
					getHierarchicalParameters(userToken,contractNumber,patientOid,storeId);
						
			if(dataCarrier!=null) {
				ageLimit = (Integer) dataCarrier.getObject(ERefillConstants.MINOR_AGE_LIMIT);
				userToken = (UserToken) dataCarrier.getObject(ERefillConstants.REQUEST_USER_TOKEN);
				if(userToken!=null)
					sessionManager.setToken(userToken, session);
				else
					dataCarrier.addObject(ERefillConstants.ERROR, "sessionexpired");
			}else
				return ageLimit;
		} catch (Exception e) {
			return ageLimit;
		}
		return ageLimit;
	}


	public String getPatientOID(ERefillSession session, String username) {

		com.lcl.erefill.core.common.entity.UserToken userToken = null;
		String patientOID=null;
		try {
		userToken = sessionManager.getToken(session);
		Map<String, String> resMap;
		resMap = managedAccountService.getPatientOID(userToken, username);
		patientOID = resMap.get("patientOID");
		userToken.setToken(resMap.get(ERefillConstants.REQUEST_USER_TOKEN));
		sessionManager.setToken(userToken, session)	;	
		} catch (Exception e) {
			logger.error("Exception while fecthing managed account details:  " + e);
			ErrorHandler.handleException(e);
		}catch (Error e) {
			logger.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}		
	
		return patientOID;
	}
}
