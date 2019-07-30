package com.lcl.erefill.core.vo;

import java.util.ArrayList;
import java.util.List;


public class PatientContacts {
	
    protected List<PatientContact> patientContact;

    public List<PatientContact> getPatientContact() {
        if (patientContact == null) {
            patientContact = new ArrayList<PatientContact>();
        }
        return this.patientContact;
    }

	/**
	 * @param patientContact the patientContact to set
	 */
	public void setPatientContact(List<PatientContact> patientContact) {
		this.patientContact = patientContact;
	}
}
