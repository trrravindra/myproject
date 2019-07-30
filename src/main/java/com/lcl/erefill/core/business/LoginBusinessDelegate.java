package com.lcl.erefill.core.business;

import static com.lcl.erefill.core.constants.ERefillConstants.REQUEST_USER_TOKEN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.common.telus.response.CurrentAccountResponse;
import com.lcl.erefill.core.common.telus.response.LogOnResponse;
import com.lcl.erefill.core.common.telus.response.PatientDataResponse;
import com.lcl.erefill.core.common.telus.response.UserAccountGroup;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.services.IAccountService;
import com.lcl.erefill.core.services.ILoginService;
import com.lcl.erefill.core.services.IManagedAccountService;
import com.lcl.erefill.core.services.IPharmacyDetailService;
import com.lcl.erefill.core.services.IProfileService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.services.integ.telus.ManagerWSImpl;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.User;
import com.lcl.erefill.core.vo.UserSession;

@Component
public class LoginBusinessDelegate implements ILoginBusinessDelegate {

	

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginBusinessDelegate.class);

	private static final List<String> unCheckedStausList = Arrays
			.asList(ERefillConfigService.TELUS_UNCHECKED_STATUS);

	@Autowired
	ILoginService loginService;

	@Autowired
	IAccountService accountService;

	@Autowired
	ISessionService sessionService;

	@Autowired
	IProfileService profileService;
	
	@Autowired
	IManagedAccountService managedAccountService;

	@Autowired
	ManagerWSImpl managerWSImpl;

	@Autowired
	IPharmacyDetailService pharmaService;

	@Autowired
	SessionManager sessionManager;
	
	@Autowired
	SessionWSImpl sessionWSImpl;

	@SuppressWarnings({ "unchecked"})
	public void logOn(DataCarrier dto) throws Exception {
		User user;
		try {
			user = (User) dto.getObject(ERefillConstants.LOGIN_USER);
			ModelMap model = (ModelMap) dto
					.getObject(ERefillConstants.LOGIN_MODEL);
			String userName = user.getUsername();
			String checkbox = "off";
			String returnValue = "";

			if (null != dto.getObject(ERefillConstants.LOGIN_REMEMBER)) {
				checkbox = (String) dto.getObject(ERefillConstants.LOGIN_REMEMBER);
			}

			loginService.logOn(dto);
			LogOnResponse logOnResponse = (LogOnResponse) dto.getObject(ERefillConstants.LOGIN_RESPONSE);
			String status = logOnResponse.getStatus();

			UserAccountGroup userAccountGroup;
			
			if(ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(status)
					||ERefillConstants.STATUS_EMUST_CONSENT.equalsIgnoreCase(status)
					||ERefillConstants.STATUS_EMUST_CHANGE_PASSWORD.equalsIgnoreCase(status)
					||ERefillConstants.STATUS_EMUST_GIVE_PASSWORD_REMINDER.equalsIgnoreCase(status)){
				/**
				 * create a new session for successful login & registration flow
				 */
				createNewSession(dto);
				
				ERefillSession session = (ERefillSession) dto.getObject(ERefillConstants.MAP_KEY_EREFILL_SESSION);
				
				/**
				 * GetUserRole
				 */
				UserToken userToken = (UserToken) dto.getObject(REQUEST_USER_TOKEN);
				userAccountGroup = sessionService.getUserRole(userToken);
				
				
				/************ Restricting Caregiver to login in Mobile View*********/
				HttpServletRequest httpRequest = (HttpServletRequest) dto.getObject(ERefillConstants.HTTP_REQUEST);
				if(httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE) && userAccountGroup.getUserRole().equalsIgnoreCase(ERefillConstants.CARE_GIVER)){
						returnValue = "careGiverFlow";
						dto.addObject(ERefillConstants.LOGIN_NEXT_PAGE, returnValue);
						return;
				}
				/************ Restricting Caregiver to login : END *********/
				/**
				 * GetCurrentAccount
				 */
				Map<String, String> name = getName(userToken);
				String firstName = "";
				String lastName = "";

				if (!name.isEmpty()) {
					firstName = name.get("firstName");
					lastName = name.get("lastName");
				}
				dto.addObject(ERefillConstants.EREFILL_FIRSTNAME, firstName);
				dto.addObject(REQUEST_USER_TOKEN,userAccountGroup.getUserToken());
				dto.addObject(ERefillConstants.USER_ROLE, userAccountGroup.getUserRole());
				
				LOGGER.debug(">> Group Status::"+userAccountGroup.getUserRole());
				
				sessionManager.setName(firstName, lastName, session);
				sessionManager.setUserRole((String)dto.getObject(ERefillConstants.USER_ROLE), session);
				sessionManager.setToken(userToken, session);
				sessionManager.setUserName(userName, session);
				
				sessionManager.setPassword(user.getPassword(), session);
				
				dto.addObject(ERefillConstants.COOKIE_UNIQUIE_NAME, userName);
			
				if ("on".equalsIgnoreCase(checkbox)) {
					dto.addObject(ERefillConstants.EREFILL_USERNAME, userName);
				} else {
					dto.addObject(ERefillConstants.EREFILL_USERNAME, "");
				}
				sessionManager.setRememberMe(checkbox, session);
				sessionManager.setErefillUserName(userName, session);
			
				if(ERefillConstants.STATUS_SUCCESS.equalsIgnoreCase(status)) {
						LOGGER.debug(userName+ " logged into the application successfully");
						MDC.put("user-id", user.getUsername());
						MDC.remove("temp-id");
						dto.addObject(ERefillConstants.COOKIE_LOGIN_STATUS,ERefillConstants.COOKIE_AUTHENTICATED);
						dto.addObject(ERefillConstants.COOKIE_UNIQUIE_NAME, userName);
						
						/**
						 * not a caregiver flow
						 */
						if(null != userAccountGroup && !dto.getObject(ERefillConstants.USER_ROLE).equals(ERefillConstants.CARE_GIVER)){
							/**
							 * GetAccountAliases
							 */
							AccountAliasResponse getAcc = sessionWSImpl.getAccountAlias(userToken);
							
							if(null != getAcc && getAcc.getUserToken()!=null){
								userToken = getAcc.getUserToken();
								dto.addObject(REQUEST_USER_TOKEN, userToken);
								sessionManager.setToken(userToken, session);
							}
							if(null != getAcc && getAcc.getUserName() != null){
								dto.addObject("page", "myprescriptions");
							}else{
								dto.addObject("page", "accountInfo");
								returnValue = "accountInfo";
								dto.addObject(ERefillConstants.LOGIN_NEXT_PAGE, returnValue);
								sessionManager.setPassword(user.getPassword(), session);
								return;
							}
							
							/**
							 * GetPatientData
							 */
							PatientDataResponse patientDataResponse = profileService.getPatientData((UserToken) dto.getObject(REQUEST_USER_TOKEN));
							String storeId = null;
							if (patientDataResponse != null) {
								if (patientDataResponse.getPatient() != null) {
									firstName = patientDataResponse.getPatient().getFirstName();
									lastName = patientDataResponse.getPatient().getLastName();
									dto.addObject("lastName", lastName);
									storeId = patientDataResponse.getPatient().getStoreID();
								}
								sessionManager.setName(firstName, lastName, session);
								dto.addObject(ERefillConstants.EREFILL_FIRSTNAME, firstName);

								PharmaDeptVO pharmaStores = pharmaService.getPharmaStores(
										userToken, storeId, null, session);
								if (pharmaStores == null) {
									model.addAttribute("error", "Pharma details not found");
								} else { 
									sessionManager.setPharmaDetails(pharmaStores, session);
								}
								if (patientDataResponse.getUserToken() != null) {
									userToken = patientDataResponse.getUserToken();
									sessionManager.setToken(userToken, session);
								}
								if (patientDataResponse.getPatient() != null) {
									if (patientDataResponse.getPatient().getUserName() != null) {
										sessionManager.setUserName(patientDataResponse.getPatient().getUserName(), session);
									}
									sessionManager.setPatientID(patientDataResponse.getPatient().getOid(), session);
									dto.addObject(ERefillConstants.PATIENT_OID, patientDataResponse.getPatient().getOid());
								}
							}		
							/**
							 * GetManagerRequests
							 */
							Integer pendingCustodianRequests=managedAccountService.pendingCustodianRequests(dto, (UserToken) dto.getObject(REQUEST_USER_TOKEN));
							sessionManager.setPendingCustodianRequests(pendingCustodianRequests, session);
						}
						/**
						 * GetAssignedPatients
						 */
						dto = managedAccountService.getAssignedPatients(dto,userToken);
						
						if(null != userAccountGroup && dto.getObject(ERefillConstants.USER_ROLE).equals(ERefillConstants.CARE_GIVER)){
							LOGGER.debug(userName+ " is a caregiver user");
							sessionManager.setUserName(userName, session);
							sessionManager.setToken(userToken, session);	
							
							List<AssignedPatientResponse> assignedPatientResponseList=(List<AssignedPatientResponse>)dto.getObject(ERefillConstants.ASSIGNED_PATIENTS);
							if(null != assignedPatientResponseList){
								for(AssignedPatientResponse assignedPatientResponse: assignedPatientResponseList){
									if(assignedPatientResponse.getPatientOID()==null || assignedPatientResponse.getPatientOID().isEmpty()){
										assignedPatientResponse.setPatientOID(ERefillConstants.CARE_GIVER);
										break;
									}
								}
							}
						}
						sessionManager.setAssignedPatients((List<AssignedPatientResponse>) dto.getObject(ERefillConstants.ASSIGNED_PATIENTS),session);
						userToken = (UserToken) dto.getObject(REQUEST_USER_TOKEN);	
						sessionManager.setToken(userToken, session);		
						returnValue = "myPrescriptions";
				}else if(ERefillConstants.STATUS_EMUST_CONSENT.equalsIgnoreCase(status)){
						LOGGER.debug(">>> Registration Flow will start");						
						dto.addObject("page", "registration");
						sessionManager.setRegistrationFlow(true, session);
						returnValue = "registration";
						
				}else if (ERefillConstants.STATUS_EMUST_CHANGE_PASSWORD.equalsIgnoreCase(status)) {
					dto.addObject("status", status);
					
					sessionManager.setRegistrationFlow(true, session);
					returnValue = "resetPassword";
					
				}else if (ERefillConstants.STATUS_EMUST_GIVE_PASSWORD_REMINDER.equalsIgnoreCase(status)) {
					sessionManager.setRegistrationFlow(true, session);
					returnValue = "userAccountPreferences";
				} 
		}else if (ERefillConstants.STATUS_ACCOUNT_LOCKED.equalsIgnoreCase(status)) {
			model.addAttribute(ERefillConstants.SIGNINERROR, ERefillConstants.STATUS_ACCOUNT_LOCKED);				
			returnValue = ERefillConstants.PAGE_SIGNIN;
		}else if(ERefillConstants.STATUS_INVALID_USER_PASSWORD.equals(status) || ERefillConstants.STATUS_UNSUBSRCIBE.equals(status) || ERefillConstants.STATUS_TEMP_PASSWORD_EXPIRED.equals(status)) {
			model.addAttribute(ERefillConstants.SIGNINERROR, ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			returnValue = ERefillConstants.PAGE_SIGNIN;
		}else if (ERefillConstants.STATUS_MINOR_USER.equalsIgnoreCase(status)) {
			model.addAttribute(ERefillConstants.SIGNINERROR, ERefillConstants.STATUS_MINOR_USER);
			returnValue = ERefillConstants.PAGE_SIGNIN;
		}else if (ERefillConstants.STATUS_MAX_SESSIONS_REACHED.equalsIgnoreCase(status)) {
			model.addAttribute(ERefillConstants.SIGNINERROR, ERefillConstants.STATUS_MAX_SESSIONS_REACHED);
			returnValue = ERefillConstants.PAGE_SIGNIN;
		} else if (!ERefillConstants.STATUS_INVALID_USER_PASSWORD.equals(status)
					&& ERefillConstants.STATUS_TOKEN_EXPIRED.equals(status)
					&& !isUnCheckedStatus(status)) {
								returnValue = ERefillConstants.ERROR;
		}else{
			model.addAttribute(ERefillConstants.SIGNINERROR,ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			returnValue = ERefillConstants.PAGE_SIGNIN;
		}
		dto.addObject(ERefillConstants.LOGIN_NEXT_PAGE, returnValue);

		} catch (Exception e) {
			LOGGER.error("Exception: " + e.getStackTrace());
			throw e;
		}
	}

	/**
	 * @param dto
	 * @param eRefillSession
	 * @throws Exception
	 */
	private void createNewSession(DataCarrier dto) throws Exception {
		HttpSession httpSession;
		UserSession userSession;
		ERefillSession eRefillSession = new ERefillSession();
		
		/*****************************************************************************************
		 * Creating session for the first time as the user is logged in
		 * 
		 */
		HttpServletRequest httpRequest = (HttpServletRequest)dto.getObject(ERefillConstants.HTTP_REQUEST);
		httpSession = httpRequest.getSession(false);
		if (httpSession==null){
			httpSession = httpRequest.getSession(true);
		}
		httpSession.setMaxInactiveInterval(ERefillConstants.SESSION_TIME_OUT);
		userSession = new UserSession();
		userSession.setSessionId(httpSession.getId());
		
		eRefillSession.addAttribute(ERefillConstants.MAP_KEY_USER, userSession);
		eRefillSession.addAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION, httpSession);
		
		dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION, eRefillSession);
	}

	private boolean isUnCheckedStatus(final String faultCode) {
		if (!CommonUtils.isNullOrEmpty(unCheckedStausList)
				&& !CommonUtils.isNullOrBlank(faultCode)) {
			for (String status : unCheckedStausList) {
				if (faultCode.contains(status))
					return true;
			}
		}
		return false;
	}

	/**
	 * logOut
	 * 
	 * @param eRefillSession
	 * @param request
	 * @param response
	 * @return
	 */
	public void logOut(ERefillSession eRefillSession,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "logOut";
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Entering");
		}
		try {
			if (eRefillSession != null) {
				com.lcl.erefill.core.common.entity.UserToken userToken = sessionManager
						.getToken(eRefillSession);
				loginService.logOut(userToken, request, response);
				
			}
		} catch (Exception e) {
			LOGGER.error("Exception while logging out: " + e);
		} finally {
			LOGGER.info("Clearing application cookies and user session");
			//CookieUtils.deleteErefillCookies(request, response);
			if (eRefillSession != null) {
				sessionManager.deleteSession(eRefillSession);
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(methodName + " Exiting");
		}
	}

	/**
	 * getName
	 * 
	 * @param userToken
	 * @return name
	 */
	private Map<String, String> getName(UserToken userToken) {
		String firstName, lastName;

		Map<String, String> name = new HashMap<String, String>();
		CurrentAccountResponse currentAccountResponse = accountService
				.getCurrentAccount(userToken);
		if (currentAccountResponse != null
				&& currentAccountResponse.getAccount() != null) {
			firstName = currentAccountResponse.getAccount().getFirstName();
			lastName = currentAccountResponse.getAccount().getLastName();
			name.put("firstName", firstName);
			name.put("lastName", lastName);
			userToken.setStatus(currentAccountResponse.getUserToken()
					.getStatus());
			userToken
					.setToken(currentAccountResponse.getUserToken().getToken());
		}
		return name;
	}
}
