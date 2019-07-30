package com.lcl.erefill.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.PatientDataResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.integ.telus.ProfileWSImpl;
import com.lcl.erefill.core.vo.Patient;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;

@Component
public class ProfileService implements IProfileService {

	private static final Logger logger = LoggerFactory
			.getLogger(ProfileService.class);
	
	@Autowired
	ProfileWSImpl profileWSImpl;
	
	/**
	 * getPatientData
	 * 
	 * @param userToken
	 * @return patientDataResponse
	 */
	public PatientDataResponse getPatientData(UserToken userToken) {
		final String methodName = "getPatientData";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		
		PatientDataResponse patientDataResponse = new PatientDataResponse();
		PatientExtendedInfo extEntInfo = new PatientExtendedInfo();
		extEntInfo.getExtendedInfo().add("All");
		try{
			logger.info("Performing profileWSImpl.getPatientData start");
			Patient patient = profileWSImpl.getPatientData(userToken,
					extEntInfo, null);
			
			patientDataResponse.setPatient(patient);
			patientDataResponse.setUserToken(userToken);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error ("Error: " +e1);
			ErrorHandler.handleException(e1);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return patientDataResponse;
	}
}
