package com.lcl.erefill.core.vo;

import java.util.GregorianCalendar;

import com.lcl.erefill.core.common.entity.UserToken;

public class FamilyManagerPatientRequestsVO extends UserToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String userName;

	private String requestState;

	private GregorianCalendar stateDate;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String description;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the requestState
	 */
	public String getRequestState() {
		return requestState;
	}

	/**
	 * @param requestState
	 *            the requestState to set
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	/**
	 * @return the stateDate
	 */
	public GregorianCalendar getStateDate() {
		return stateDate;
	}

	/**
	 * @param stateDate
	 *            the stateDate to set
	 */
	public void setStateDate(GregorianCalendar stateDate) {
		this.stateDate = stateDate;
	}
}
