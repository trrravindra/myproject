package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;

/**
 * @author vsha51
 */
public class UserSession implements Serializable {

	private static final long serialVersionUID = -8703042687923805513L;

	private UserToken currentToken;

	private String sessionId;

	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String oid;
	
	private String selectedPatientOid;
	
	private Map<String,PharmaDeptVO> pharmaDeptVOs;
	
	private List<AssignedPatientResponse> assignedPatients;
	
	private String email;
	
	private String password;
	
	private Patient patient;
	
	private Integer pendingCustodianRequests;
	
	private String userRole;
	
	private String refillType;
	
	private List<String> listCheckedPresc;
	
	private Set<String> selectedPresc;
	
	private String rememberMe;
	private String erefillUserName;
	
	private boolean isRegistrationFlow;
	
	public boolean isRegistrationFlow() {
		return isRegistrationFlow;
	}

	public void setRegistrationFlow(boolean isRegistrationFlow) {
		this.isRegistrationFlow = isRegistrationFlow;
	}

	public String getErefillUserName() {
		return erefillUserName;
	}

	public void setErefillUserName(String erefillUserName) {
		this.erefillUserName = erefillUserName;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	public Set<String> getSelectedPresc() {
		return selectedPresc;
	}

	public void setSelectedPresc(Set<String> selectedPresc) {
		this.selectedPresc = selectedPresc;
	}

	public List<String> getListCheckedPresc() {
		return listCheckedPresc;
	}

	public void setListCheckedPresc(List<String> listCheckedPresc) {
		this.listCheckedPresc = listCheckedPresc;
	}

	public String getRefillType() {
		return refillType;
	}

	public void setRefillType(String refillType) {
		this.refillType = refillType;
	}
	
	
	/**
	 *  @return userRole which could be patient, custodian, caregiver
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole to set the user role for a user
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pharmaDeptVOs
	 */
	public Map<String, PharmaDeptVO> getPharmaDeptVOs() {
		return pharmaDeptVOs;
	}

	/**
	 * @param pharmaDeptVOs the pharmaDeptVOs to set
	 */
	public void setPharmaDeptVOs(Map<String, PharmaDeptVO> pharmaDeptVOs) {
		this.pharmaDeptVOs = pharmaDeptVOs;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return the selectedPatientOid
	 */
	public String getSelectedPatientOid() {
		return selectedPatientOid;
	}

	/**
	 * @param selectedPatientOid the selectedPatientOid to set
	 */
	public void setSelectedPatientOid(String selectedPatientOid) {
		this.selectedPatientOid = selectedPatientOid;
	}

	/**
	 * @return the currentToken
	 */
	public UserToken getCurrentToken() {
		return currentToken;
	}

	/**
	 * @param currentToken
	 *            the currentToken to set
	 */
	public void setCurrentToken(UserToken currentToken) {
		this.currentToken = currentToken;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the assignedPatients
	 */
	public List<AssignedPatientResponse> getAssignedPatients() {
		return assignedPatients;
	}

	/**
	 * @param assignedPatients the assignedPatients to set
	 */
	public void setAssignedPatients(List<AssignedPatientResponse> assignedPatients) {
		this.assignedPatients = assignedPatients;
	}

	/**
	 * @return the pendingCustodianRequests
	 */
	public Integer getPendingCustodianRequests() {
		return pendingCustodianRequests;
	}

	/**
	 * @param pendingCustodianRequests the pendingCustodianRequests to set
	 */
	public void setPendingCustodianRequests(Integer pendingCustodianRequests) {
		this.pendingCustodianRequests = pendingCustodianRequests;
	}

}
