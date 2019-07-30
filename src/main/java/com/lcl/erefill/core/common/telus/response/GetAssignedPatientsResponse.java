package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import com.lcl.erefill.core.vo.Patient;

/**
 * @author vsha51
 */
public class GetAssignedPatientsResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946458551262560326L;

	private List<Patient>  assignedPatients;

	/**
	 * @return the assignedPatients
	 */
	public List<Patient> getAssignedPatients() {
		return assignedPatients;
	}

	/**
	 * @param assignedPatients the assignedPatients to set
	 */
	public void setAssignedPatients(List<Patient> assignedPatients) {
		this.assignedPatients = assignedPatients;
	}

}
