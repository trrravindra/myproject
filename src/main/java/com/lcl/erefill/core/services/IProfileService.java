package com.lcl.erefill.core.services;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.PatientDataResponse;

/**
 * @author vsha51
 */
@Component
public interface IProfileService {

	/**
	 * getPatientData
	 * 
	 * @param userToken
	 * @return patientDataResponse
	 */
	public PatientDataResponse getPatientData(UserToken userToken);
}
