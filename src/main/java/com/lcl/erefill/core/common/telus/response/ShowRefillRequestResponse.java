package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import com.lcl.erefill.core.vo.Patient;
import com.lcl.erefill.core.vo.PrescDetailsView;


public class ShowRefillRequestResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PrescDetailsView> viewList;
	private EmailStatusResponse emailStatusResponse;
	private Patient patient;

	/**
	 * @return the viewList
	 */
	public List<PrescDetailsView> getViewList() {
		return viewList;
	}

	/**
	 * @param viewList the viewList to set
	 */
	public void setViewList(List<PrescDetailsView> viewList) {
		this.viewList = viewList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the emailStatusResponse
	 */
	public EmailStatusResponse getEmailStatusResponse() {
		return emailStatusResponse;
	}

	/**
	 * @param emailStatusResponse the emailStatusResponse to set
	 */
	public void setEmailStatusResponse(EmailStatusResponse emailStatusResponse) {
		this.emailStatusResponse = emailStatusResponse;
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
	
	
	
}
