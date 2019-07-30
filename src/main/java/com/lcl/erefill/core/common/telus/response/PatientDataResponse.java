package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.vo.Patient;

/**
 * @author vsha51
 */
public class PatientDataResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946458551262560326L;

	private Patient patient;

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
