/**
 * 
 */
package com.lcl.erefill.core.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.integ.telus.ProfileWSImpl;
import com.lcl.erefill.core.services.integ.telus.RequestWSImpl;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.Patient;
import com.lcl.erefill.core.vo.PrescDetailsView;
import com.lcl.erefill.core.vo.PrescriptionAddResponse;
import com.lcl.erefill.core.vo.RxNewRequest;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;

/**
 * @author hkokel version 1.0
 */
@Component
public class RefillRequestService implements IRefillRequestService {

	private static final Logger log = LoggerFactory
			.getLogger(RefillRequestService.class);

	@Autowired
	ProfileWSImpl profileWSImpl;

	@Autowired
	IPharmacyDetailService pharmaService;

	@Autowired
	SessionWSImpl sessionWSImpl;

	@Autowired
	RequestWSImpl requestWSImlp;

	public DataCarrier refillRequest(DataCarrier dto) {
		try {
			@SuppressWarnings("unchecked")
			List<String> lstChkdPresc = (List<String>) dto
					.getObject(ERefillConstants.REFILL_REQUEST_CHKDPRESC);
			UserToken userToken = (UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN);

			String strLocale = (String) dto
					.getObject(ERefillConstants.REQUEST_LOCALE);
			List<PrescDetailsView> viewList = profileWSImpl
					.getRefillRequestList(
							userToken,
							lstChkdPresc,
							strLocale,
							(String) dto
									.getObject(ERefillConstants.SELECTED_PATIENT_OID));
			PatientExtendedInfo extEntInfo = new PatientExtendedInfo();
			extEntInfo.getExtendedInfo().add("All");
			Patient entityPatient = profileWSImpl.getPatientData(userToken,
					extEntInfo, (String) dto.getObject(ERefillConstants.SELECTED_PATIENT_OID));
			Map<String, String> accountMap = sessionWSImpl.getEmailStatus(
					userToken, (String) dto
							.getObject(ERefillConstants.SELECTED_PATIENT_OID));

			
			String storeId = entityPatient.getStoreID();
			String jsonDelOperatingHours = pharmaService
					.getDelOperatingHours(storeId);
			
			
			
			ISession session = (ERefillSession) dto.getObject(ERefillConstants.EREFILL_SESSION);
			String jsonOperatingHours = pharmaService
					.getOperatingHours(userToken, storeId, session);
			
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
			dto.addObject(ERefillConstants.REFILL_REQUEST_PRESC, viewList);
			dto.addObject(ERefillConstants.DEL_OPERATING_HOURS,
					jsonDelOperatingHours);
			dto.addObject(ERefillConstants.OPERATINGHOURS, jsonOperatingHours);
			dto.addObject(ERefillConstants.REFILL_REQUEST_PATIENT,
					entityPatient);
			dto.addObject(ERefillConstants.REFILL_REQUEST_ACCOUNTMAP,
					accountMap);
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			log.error("Error: " + e1);
			ErrorHandler.handleException(e1);
		}
		return dto;
	}

	public DataCarrier refillRequestSubmit(DataCarrier dto) {
		String json = null;
		final ObjectMapper o = new ObjectMapper();
		PrescriptionAddResponse response = new PrescriptionAddResponse();
		try {
			UserToken userToken = (UserToken) dto
					.getObject(ERefillConstants.REQUEST_USER_TOKEN);
			String patientOID = (String) dto
					.getObject(ERefillConstants.REFILL_REQUEST_PATIENTOID);
			RxNewRequest rxNewRequest = (RxNewRequest) dto
					.getObject(ERefillConstants.REFILL_REQUEST_RX);
			com.lcl.erefill.core.common.telus.response.RequestPrescriptionAddResponse reqPrescAddResponse = requestWSImlp
					.add(userToken, patientOID, rxNewRequest);
			dto = new DataCarrier();
			dto.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);

			if (null != reqPrescAddResponse) {

				if ("ok".equalsIgnoreCase(reqPrescAddResponse.getStatus())) {
					log.debug("status is ok >>>> successfully inserted");
					// setResponseText("ok", response);

					response.setUpdate_status("ok");
					response.setRefillType("refill");
					/*if (null != reqPrescAddResponse.getToken()) {
						log.debug("telus response >> token is not null >>"
								+ reqPrescAddResponse.getToken());
						response.setToken_value(reqPrescAddResponse.getToken());
					}*/
					if (null != reqPrescAddResponse.getStatus()) {
						log.debug("telus response >> status is not null >>"
								+ reqPrescAddResponse.getStatus());
						response.setToken_status(reqPrescAddResponse
								.getStatus());
					}
					json = o.writeValueAsString(response);
					dto.addObject(ERefillConstants.REFILL_REQUEST_JSON, json);
				} else {
					log.debug("refill request submission failed >>>>");
					response.setUpdate_status("error");
					response.setRefillType("refill");
					/*if (null != reqPrescAddResponse.getToken()) {
						log.debug("telus response >> token is not null >>"
								+ reqPrescAddResponse.getToken());
						response.setToken_value(reqPrescAddResponse.getToken());
					}*/
					if (null != reqPrescAddResponse.getStatus()) {
						response.setToken_status(reqPrescAddResponse
								.getStatus());
						log.debug("telus response >> status is not null >>"
								+ reqPrescAddResponse.getStatus());
					}
					json = o.writeValueAsString(response);
					dto.addObject(ERefillConstants.REFILL_REQUEST_JSON, json);
				}
			} else {
				response.setUpdate_status("exception");
				json = o.writeValueAsString(response);
				dto.addObject(ERefillConstants.REFILL_REQUEST_JSON, json);
			}
		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			log.error("Error: " + e1);
			ErrorHandler.handleException(e1);
		}

		return dto;
	}
}
