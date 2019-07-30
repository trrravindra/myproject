package com.lcl.erefill.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.dao.ISessionDAO;
import com.lcl.erefill.core.dao.SessionDAOFactory;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.Patient;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.UserSession;

/**
 * @author vsha51
 */
@Component
public class SessionManager {

	private static final Logger logger = LoggerFactory.getLogger(SessionManager.class);
	
	private SessionDAOFactory sessionDAOFactory = null;
	
	private ISessionDAO sessionDAO = null;
	
	public SessionManager(){
		super();
		sessionDAOFactory = new SessionDAOFactory();
		sessionDAO = sessionDAOFactory.getSessionDAO();
	}
	
	/**
	 * getToken
	 * 
	 * @param session
	 * @return token
	 */
	public UserToken getToken(ISession session){
		final String methodName = "getToken";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		UserToken token = null;
		//Call the readSession method on sessionDAO to read the token details
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					token = userSession.getCurrentToken();
					if(null != token){
					logger.info(methodName + " Token: "+token.getToken());
					token.setStatus("Ok");
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting user token ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return token;
	}
	
	/**
	 * setToken
	 * 
	 * @param token
	 * @param session
	 */
	public void setToken(UserToken token, ISession session){
		final String methodName = "setToken";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			if(token != null){
				ERefillSession eRefillSession = (ERefillSession) session;
				try {
					UserSession userSession = (UserSession) eRefillSession
							.getAttribute(ERefillConstants.MAP_KEY_USER);
					userSession.setCurrentToken(token);
					logger.info(methodName + " Token: "+token.getToken());
					
					//Call the updateSession method on sessionDAO to update session
					sessionDAO.updateSession(session);
				} catch (Exception e) {
					logger.error(methodName + " Exception caught while setting user token ", e);
				}
			}			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getPatientID
	 * 
	 * @param session
	 * @return patientID
	 */
	public String getPatientID (ISession session){
		final String methodName = "getPatientID";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String patientID = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					patientID = userSession.getOid();
					logger.info(methodName + " PatientID: "+patientID);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting oid ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return patientID;
	}
	
	/**
	 * setPatientID
	 * 
	 * @param patientID
	 * @param session
	 */
	public void setPatientID(String patientID, ISession session){
		final String methodName = "setPatientID";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setOid(patientID);
				logger.info(methodName + " PatientID: "+patientID);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting oid ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getSelectedPatientOID
	 * 
	 * @param session
	 * @return patientID
	 */
	public String getSelectedPatientOID (ISession session){
		final String methodName = "getSelectedPatientOID";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String patientOid = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					if(StringUtils.isNotBlank(userSession.getOid()) && !userSession.getOid().
							equalsIgnoreCase(StringUtils.trimToEmpty(userSession.getSelectedPatientOid()))){
						patientOid = userSession.getSelectedPatientOid();
					}
					logger.info(methodName + " SelectedPatientOID: "+patientOid);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting selected patient oid ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return patientOid;
	}
	
	/**
	 * setSelectedPatientOID
	 * 
	 * @param patientID
	 * @param session
	 */
	public void setSelectedPatientOID(String patientOid, ISession session){
		final String methodName = "setSelectedPatientOID";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setSelectedPatientOid(patientOid);
				logger.info(methodName + " SelectedPatientOID: "+patientOid);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting selected patient oid ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getUserName
	 * 
	 * @param session
	 * @return userName
	 */
	public String getUserName (ISession session){
		final String methodName = "getUserName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String userName = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					userName = userSession.getUserName();
					logger.info(methodName + " UserName: "+userName);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting userName ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return userName;
	}
	
	/**
	 * setUserName
	 * 
	 * @param userName
	 * @param session
	 */
	public void setUserName(String userName, ISession session){
		final String methodName = "setUserName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setUserName(userName);
				logger.info(methodName + " UserName: "+userName);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting userName ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getEmail
	 * 
	 * @param session
	 * @return email
	 */
	public String getEmail (ISession session){
		final String methodName = "getEmail";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String email = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					email = userSession.getEmail();
					logger.info(methodName + " email: "+email);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting email ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return email;
	}
	
	/**
	 * setEmail
	 * 
	 * @param userName
	 * @param session
	 */
	public void setEmail(String email, ISession session){
		final String methodName = "setEmail";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setEmail(email);
				logger.info(methodName + " Email: "+email);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting email ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getPassword
	 * 
	 * @param session
	 * @return userName
	 */
	public String getPassword (ISession session){
		final String methodName = "getPassword";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String password = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					password = userSession.getPassword();
					//logger.info(methodName + " password: "+password);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting password ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return password;
	}
	
	/**
	 * setPassword
	 * 
	 * @param password
	 * @param session
	 */
	public void setPassword(String password, ISession session){
		final String methodName = "setPassword";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setPassword(password);
				//logger.info(methodName + " password: "+password);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting password ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * deleteSession
	 * 
	 * @param session
	 */
	public void deleteSession( ISession session){
		final String methodName = "deleteSession";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				//Call the delete method on sessionDAO to invalidate session
				sessionDAO.deleteSession(eRefillSession);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while invalidating session ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getFirstName
	 * 
	 * @param session
	 * @return firstName
	 */
	public String getFirstName (ISession session){
		final String methodName = "getFirstName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String firstName = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						firstName = userSession.getFirstName();
						logger.info(methodName + " FirstName: "+firstName);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting firstName ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return firstName;
	}
	
	/**
	 * setFirstName
	 * 
	 * @param firstName
	 * @param session
	 */
	public void setFirstName(String firstName, ISession session){
		final String methodName = "setFirstName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setFirstName(firstName);
				logger.info(methodName + " FirstName: "+firstName);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting firstName ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getName
	 * 
	 * @param session
	 * @return name
	 */
	public String getName (ISession session){
		final String methodName = "getName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		String name = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						name = userSession.getFirstName();
						if(name != null){
							name = name + " " + userSession.getLastName();
						} else {
							name = userSession.getLastName();
						}
						logger.info(methodName + " Name: "+name);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting Name ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return name;
	}
	
	/**
	 * setName
	 * 
	 * @param firstName
	 * @param lastName
	 * @param session
	 */
	public void setName(String firstName, String lastName, ISession session){
		final String methodName = "setName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setFirstName(firstName);
				logger.info(methodName + " FirstName: "+firstName);
				
				userSession.setLastName(lastName);
				logger.info(methodName + " LastName: "+lastName);
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting Name ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * getPharmacyDetails
	 * 
	 * @param session
	 * @return pharmaDeptVO
	 */
	public PharmaDeptVO getPharmacyDetails (ISession session){
		final String methodName = "getPharmacyDetails";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		PharmaDeptVO pharmaDeptVO = null;
		
		synchronized (this) {
			String patientOid = null;
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						if(StringUtils.isNotBlank(userSession.getOid()) && !userSession.getOid().
								equalsIgnoreCase(StringUtils.trimToEmpty(userSession.getSelectedPatientOid()))){
							patientOid = userSession.getSelectedPatientOid();
						}
						logger.info(methodName + " SelectedPatientOID: "+patientOid);
						Map<String, PharmaDeptVO> pharmaDeptVOs = userSession.getPharmaDeptVOs();
						if( pharmaDeptVOs != null && !pharmaDeptVOs.isEmpty() ){
							if(StringUtils.isBlank(patientOid)){
								pharmaDeptVO = pharmaDeptVOs.get("DEFAULT");
							} else {
								pharmaDeptVO = pharmaDeptVOs.get(patientOid);
							}
						}
						logger.info(methodName + " pharmaDeptVO: "+pharmaDeptVO);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting pharmaDeptVO ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return pharmaDeptVO;
	}
	
	/**
	 * setPharmaDetails
	 * 
	 * @param pharmaDeptVO
	 * @param session
	 */
	public void setPharmaDetails(PharmaDeptVO pharmaDeptVO, ISession session){
		final String methodName = "setPharmaDetails";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			String patientOid = null;
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				
				if(StringUtils.isNotBlank(userSession.getOid()) && !userSession.getOid().
						equalsIgnoreCase(StringUtils.trimToEmpty(userSession.getSelectedPatientOid()))){
					patientOid = userSession.getSelectedPatientOid();
				}
				logger.info(methodName + " SelectedPatientOID: "+patientOid);
				Map<String, PharmaDeptVO> pharmaDeptVOs = userSession.getPharmaDeptVOs();
				if( pharmaDeptVOs == null ){
					pharmaDeptVOs = new HashMap<String, PharmaDeptVO>();
				}
				
				if(StringUtils.isBlank(patientOid)){
					pharmaDeptVOs.put("DEFAULT", pharmaDeptVO);
				} else {
					pharmaDeptVOs.put(patientOid, pharmaDeptVO);
				}
				userSession.setPharmaDeptVOs(pharmaDeptVOs);
				logger.info(methodName + " pharmaDeptVO: "+pharmaDeptVO);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting pharmaDeptVO ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	/**
	 * getAssignedPatients
	 * 
	 * @param session
	 * @return Map
	 */
	public List<AssignedPatientResponse> getAssignedPatients(ISession session){
		final String methodName = "getAssignedPatients";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		List<AssignedPatientResponse> assignedPatients=null;
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						assignedPatients = userSession.getAssignedPatients();
						logger.info(methodName + " assignedPatients: "+assignedPatients);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting assignedPatients ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return assignedPatients;
	}
	
	/**
	 * setAssignedPatients
	 * 
	 * @param session
	 * @return Map
	 */
	public void setAssignedPatients(List<AssignedPatientResponse> assignedPatients,ISession session){
		final String methodName = "getAssignedPatients";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						userSession.setAssignedPatients(assignedPatients);
						logger.info(methodName + " assignedPatients: "+assignedPatients);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting assignedPatients ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
	
	}
	
	/**
	 * getPatient
	 * 
	 * @param session
	 * @return patient
	 */
	public Patient getPatient (ISession session){
		final String methodName = "getPatient";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		Patient patient = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						patient = userSession.getPatient();
						logger.info(methodName + " patient: "+patient);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting patient ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return patient;
	}
	
	/**
	 * setPatient
	 * 
	 * @param patient
	 * @param session
	 */
	public void setPatient(Patient patient, ISession session){
		final String methodName = "setPatient";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setPatient(patient);
				logger.info(methodName + " Patient: "+patient);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting Patient ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	/**
	 * getPendingCustodianRequests
	 * 
	 * @param session
	 * @return pendingCustodianRequests
	 */
	public Integer getPendingCustodianRequests (ISession session){
		final String methodName = "getPendingCustodianRequests";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		Integer pendingCustodianRequests = null;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						pendingCustodianRequests = userSession.getPendingCustodianRequests();
						logger.info(methodName + " PendingCustodianRequests: "+pendingCustodianRequests);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting pendingCustodianRequests ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return pendingCustodianRequests;
	}
	
	/**
	 * setPendingCustodianRequests
	 * 
	 * @param pendingCustodianRequests
	 */
	public void setPendingCustodianRequests(Integer pendingCustodianRequests,ISession session){
		final String methodName = "setPendingCustodianRequests";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setPendingCustodianRequests(pendingCustodianRequests);
				logger.info(methodName + " PendingCustodianRequests: "+pendingCustodianRequests);				
				
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting pendingCustodianRequests ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * 
	 * @param session
	 * @return user role string
	 */
	public String getUserRole(ISession session){
		final String methodName="getUserRole";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		String userRole=null;
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						userRole = userSession.getUserRole();
						logger.info(methodName + " user role: "+userRole);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting user role ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return userRole;
	}
	
	
	/**
	 * 
	 * @param userRole
	 * @param session
	 */
	public void setUserRole(String userRole, ISession session){
		final String methodName = "setUserRole";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setUserRole(userRole);
				logger.info(methodName+ " user role is: " + userRole);
				
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting user Role " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * 
	 * @param session
	 * @return refill type string
	 */
	public String getRefillType(ISession session){
		final String methodName="getRefillType";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		String refillType=null;
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						refillType = userSession.getRefillType();
						logger.info(methodName + " refill type is: "+refillType);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting refill type ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return refillType;
	}
	
	/**
	 * 
	 * @param refill type
	 * @param session
	 */
	public void setRefillType(String refillType, ISession session){
		final String methodName = "setRefillType";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(null != userSession){
				userSession.setRefillType(refillType);
				}
				logger.info(methodName+ "refill type is: " + refillType);
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting refill type " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}

	/**
	 * 
	 * @param lstChkdPresc
	 * @param session
	 */
	public void setListCheckedPresc(List<String> lstChkdPresc, ISession session) {
		final String methodName = "setListCheckedPresc";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(null != userSession){
				userSession.setListCheckedPresc(lstChkdPresc);
				}
				logger.info(methodName+ " list of checked prescription: " + lstChkdPresc);
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting list of checkd prescriptions " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		
	}

	
	/**
	 * 
	 * @param session
	 * @return user role string
	 */
	public List<String> getListCheckedPresc(ISession session){
		final String methodName="getListCheckedPresc";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		List<String> listChkdPresc=new ArrayList<String>();
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						listChkdPresc = userSession.getListCheckedPresc();
						logger.info(methodName + " list of checked prescription: " + listChkdPresc);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting list of checkd prescriptions ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return listChkdPresc;
	}
	
	/**
	 * 
	 * @param selectedPresc
	 * @param session
	 */
	public void setSelectedPresc(Set<String> selectedPresc, ISession session) {
		final String methodName = "setSelectedPresc";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(null != userSession){
				userSession.setSelectedPresc(selectedPresc);
				}
				logger.info(methodName+ " Pagination: list of selected prescription: " + selectedPresc);
				
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting selected prescriptions " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @return checked prescriptions list
	 */
	public Set<String> getSelectedPresc(ISession session){
		final String methodName="getSelectedPresc";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		Set<String> selectedPresc=new HashSet<String>();
		
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						selectedPresc = userSession.getSelectedPresc();
						logger.info(methodName + " list of checked prescription: " + selectedPresc);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting selected prescriptions ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return selectedPresc;
	}
	
	/**
	 * 
	 * @param selectedPresc
	 * @param session
	 */
	public void setRememberMe(String rememberMe, ISession session) {
		final String methodName = "setRememberMe";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setRememberMe(rememberMe);
				logger.info(methodName+ " Remember me is (on/off) " + rememberMe);
				
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting remember me " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @return remember me value (on/off)
	 */
	public String getRememberMe(ISession session){
		final String methodName="getRememberMe";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		String rememberMe=StringUtils.EMPTY;
		
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						rememberMe = userSession.getRememberMe();
						logger.info(methodName + " Remember is (on/off): " + rememberMe);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting remember me ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return rememberMe;
	}
	
	/**
	 * 
	 * @param selectedPresc
	 * @param session
	 */
	public void setErefillUserName(String erefillUserName, ISession session) {
		final String methodName = "setErefillUserName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		
		synchronized(this){
			ERefillSession eRefillSession = (ERefillSession) session;
			try{
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setErefillUserName(erefillUserName);
				logger.info(methodName+ " erefillUserName " + erefillUserName);
				
				sessionDAO.updateSession(session);
			}catch(Exception e){
				logger.error(methodName + " Exception caught while setting erefillUserName " , e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @return remember me value (on/off)
	 */
	public String getErefillUserName(ISession session){
		final String methodName="getErefillUserName";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Entering");
		}
		String erefillUserName=StringUtils.EMPTY;
		
		synchronized(this){
			ERefillSession eRefillSession= (ERefillSession)sessionDAO.readSession(session);
			try {
				if( eRefillSession != null ){	
					UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
					if(userSession != null){
						erefillUserName = userSession.getErefillUserName();
						logger.info(methodName + " erefillUserName is " + erefillUserName);
					}
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting erefillUserName ", e);
			}
			
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + "Exiting");
		}
		return erefillUserName;
	}
	
	/**
	 * isRegistrationFlow
	 * 
	 * @param session
	 * @return isRegistrationFlow
	 */
	public boolean isRegistrationFlow (ISession session){
		final String methodName = "isRegistrationFlow";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		boolean isRegistrationFlow = false;
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) sessionDAO.readSession(session);
			try {
				UserSession userSession = (UserSession) eRefillSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if(userSession != null){
					isRegistrationFlow = userSession.isRegistrationFlow();
					logger.info(methodName + " IsregistrationFlow: "+isRegistrationFlow);
				}
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while getting registration flow ", e);
			}
					
			if(logger.isDebugEnabled()){
				logger.debug(methodName + " Exiting");
			}
		}
		return isRegistrationFlow;
	}
	
	/**
	 * setRegistrationFlow
	 * 
	 * @param isRegistrationFlow
	 * @param session
	 */
	public void setRegistrationFlow(boolean isRegistrationFlow, ISession session){
		final String methodName = "setRegistrationFlow";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		
		synchronized (this) {
			ERefillSession eRefillSession = (ERefillSession) session;
			try {
				UserSession userSession = (UserSession) eRefillSession
						.getAttribute(ERefillConstants.MAP_KEY_USER);
				userSession.setRegistrationFlow(isRegistrationFlow);
				logger.info(methodName + " IsRegistrationFlow: "+isRegistrationFlow);
				
				//Call the updateSession method on sessionDAO to update session
				sessionDAO.updateSession(session);
			} catch (Exception e) {
				logger.error(methodName + " Exception caught while setting registration flow ", e);
			}
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
	}
	
}
