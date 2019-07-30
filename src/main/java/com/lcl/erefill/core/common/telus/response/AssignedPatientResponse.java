package com.lcl.erefill.core.common.telus.response;

import java.io.Serializable;


public class AssignedPatientResponse extends ERefillResponse  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private String birthYear;
	
	private String patientOID;

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

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getPatientOID() {
		return patientOID;
	}

	public void setPatientOID(String patientOID) {
		this.patientOID = patientOID;
	}
	
	
	
	

}
