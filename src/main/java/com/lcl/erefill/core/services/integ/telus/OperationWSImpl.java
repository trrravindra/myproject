package com.lcl.erefill.core.services.integ.telus;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.telus.response.AutomatedRefillCalendarResponse;
import com.lcl.erefill.core.common.telus.response.AutomatedRefillResponse;
import com.lcl.erefill.core.common.telus.response.OperationAddResponse;
import com.lcl.erefill.core.common.telus.response.RefillReminderResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.services.ISessionService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.vo.AutoRefillReminderRequest;
import com.lcl.erefill.generated.telus.operation.IOperationSvc;
import com.lcl.erefill.generated.telus.operation.IOperationSvcAddAutomatedRefillErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcAddRefillReminderErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcDeleteAutomatedRefillErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcDeleteRefillReminderErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcGetAutomatedRefillByOIDErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcGetAutomatedRefillsByPatientOIDErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcGetExpectedAutomatedRefillErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcGetRefillRemindersByPatientOIDErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.IOperationSvcUpdateAutomatedRefillErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EMedReleaseMode;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EOperationalEventState;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EProvince;
import com.lcl.erefill.generated.telus.operation.rxassystlib.ERecurrenceType;
import com.lcl.erefill.generated.telus.operation.rxassystlib.ERequestState;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefill;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefillCalendar;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefillCalendars;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefills;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.MedReleaseMode;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.OperationalEvent;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RefillReminder;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RefillReminders;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.Request;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RequestDelivery;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxNewRequest;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxPrescription;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxPrescriptions;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxRenewPrescription;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxRenewPrescriptions;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken;
import com.lcl.erefill.generated.telus.profile.IProfileSvcGetPatientDataErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Patient;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;

/***
 * @author vsha51
 */
@Component
public class OperationWSImpl extends BaseService {

	private static final Logger log = LoggerFactory
			.getLogger(OperationWSImpl.class);
	
	@Autowired
	ISessionService sessionService;

	/**
	 * getExpectedAutomatedRefill
	 * 
	 * @param userToken
	 * @param storeId
	 * @param originalPrescriptionOID
	 * @param releaseMode
	 * @param daysSupply 
	 * @param rxDate 
	 * @return automatedRefillCalendarResponse
	 */
	public AutomatedRefillCalendarResponse getExpectedAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String storeId, String originalPrescriptionOID, String releaseMode, int rxIntDate, short daysShortSupply) {
		final String methodName = "getExpectedAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		AutomatedRefillCalendarResponse automatedRefillCalendarResponse = new AutomatedRefillCalendarResponse();
		if (storeId == null) {
			log.debug("performing profServ.getPatientData start");
			PatientExtendedInfo patientExtendedInfo = new PatientExtendedInfo();
			Holder<com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken> userTokenHolder = prepareProfileTokenHolder(userToken);
			Holder<Patient> objPatientHolder = new Holder<Patient>();
			Holder<String> objEmailHolder = new Holder<String>();
			patientExtendedInfo.getExtendedInfo().add("All");
			try {
				getProfileService().getPatientData(userTokenHolder,	patientExtendedInfo, null, objPatientHolder,objEmailHolder);
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value.getToken().getValue()));
			} catch (IProfileSvcGetPatientDataErrorFaultFaultMessage e) {
				log.error(e.getMessage(), e);
				if(null != userToken){
				userToken.setStatus("error");
				userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
				}
				automatedRefillCalendarResponse.setUserToken(userToken);
			} catch (ERefillApplicationException e) {
				throw e;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				ErrorHandler.handleException(e);
			} catch (Error e) {
				log.error(e.getMessage(), e);
				ErrorHandler.handleError(e);
			}
			Patient entPatient = objPatientHolder.value;
			log.debug("performing profServ.getPatientData end");
			if (null != entPatient) {
				storeId = entPatient.getDefaultPharmacy().getValue().getContractNumber();
				log.info("Store ID in getExpectedAutomatedRefill else block {}",storeId);
			}
		}

		log.info("setting storeId has been completed: " + storeId);
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		OperationalEvent operationalEvent = new OperationalEvent();
		XMLGregorianCalendar date = CommonUtils.getDateTime(new Date());
		
		String rxDate = String.valueOf(rxIntDate);
		String daysSupply = String.valueOf(daysShortSupply);
		XMLGregorianCalendar updatedRxDate = CommonUtils.getRxDateDaysSupply(rxDate, daysSupply);
				
		operationalEvent.setCreatedDate(date);
		
		XMLGregorianCalendar currentDatePlusOne = CommonUtils.currentDatePlusOne(date);
		currentDatePlusOne = (0 < currentDatePlusOne.toGregorianCalendar().compareTo(updatedRxDate.toGregorianCalendar())) 
				? currentDatePlusOne : updatedRxDate ;
		
		operationalEvent.setEventStart(currentDatePlusOne);
		operationalEvent.setNextOperation(currentDatePlusOne);
		operationalEvent.setOperationalEventState(EOperationalEventState.E_ACTIVE);
		operationalEvent.setRecurrenceType(ERecurrenceType.E_EXPECTED_REFILL_DATE);
		operationalEvent.setRecurrence(0);
		IOperationSvc operationSvc = getOperationService();
		List<List<AutomatedRefillCalendar>> listCalender = new ArrayList<List<AutomatedRefillCalendar>>();
		AutomatedRefillCalendars refillCalender = null;
		try {
			if (releaseMode.equalsIgnoreCase("both")) {
				MedReleaseMode medReleaseMode = new MedReleaseMode();
				medReleaseMode.setMode(EMedReleaseMode.fromValue("Pickup"));
				try {
					long startTime = System.currentTimeMillis();
					refillCalender = operationSvc.getExpectedAutomatedRefill(userTokenHolder, operationalEvent, storeId,originalPrescriptionOID, medReleaseMode);
					log.info("{}|{}", "getExpectedAutomatedRefill",CommonUtils.executionTime(startTime));
					userToken.setStatus(userTokenHolder.value.getStatus().get(0));
					userToken.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value.getToken().getValue()));
					listCalender.add(refillCalender.getAutomatedRefillCalendar());
					
				} catch (IOperationSvcGetExpectedAutomatedRefillErrorFaultFaultMessage e) {
					log.error(e.getMessage(), e);
					if(null != userToken){
					userToken.setStatus("error");
					userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
					}
					automatedRefillCalendarResponse.setUserToken(userToken);
					return automatedRefillCalendarResponse;
				}
				medReleaseMode.setMode(EMedReleaseMode.fromValue("Delivery"));
				refillCalender = null;
				try {
					long startTime = System.currentTimeMillis();
					refillCalender = operationSvc.getExpectedAutomatedRefill(userTokenHolder, operationalEvent, storeId,originalPrescriptionOID, medReleaseMode);
					log.info("{}|{}", "getExpectedAutomatedRefill",	CommonUtils.executionTime(startTime));
					userToken.setStatus(userTokenHolder.value.getStatus().get(0));
					userToken.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value.getToken().getValue()));
					listCalender.add(refillCalender.getAutomatedRefillCalendar());
					automatedRefillCalendarResponse.setAutomatedRefillCalendarList(listCalender);
				} catch (IOperationSvcGetExpectedAutomatedRefillErrorFaultFaultMessage e) {
					log.error(e.getMessage(), e);
					if(null != userToken){
					userToken.setStatus("error");
					userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
					}
					automatedRefillCalendarResponse.setUserToken(userToken);
					return automatedRefillCalendarResponse;
				}
			} else {
				MedReleaseMode medReleaseMode = new MedReleaseMode();
				medReleaseMode.setMode(EMedReleaseMode.fromValue(releaseMode));
				long startTime = System.currentTimeMillis();
				refillCalender = operationSvc.getExpectedAutomatedRefill(
						userTokenHolder, operationalEvent, storeId,
						originalPrescriptionOID, medReleaseMode);
				log.info("{}|{}", methodName,
						CommonUtils.executionTime(startTime));
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				listCalender.add(refillCalender.getAutomatedRefillCalendar());
				automatedRefillCalendarResponse
						.setAutomatedRefillCalendarList(listCalender);
				automatedRefillCalendarResponse.setUserToken(userToken);
			}
		} catch (IOperationSvcGetExpectedAutomatedRefillErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			if(null != userToken){
			userToken.setStatus("error");
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
			}
			automatedRefillCalendarResponse.setUserToken(userToken);
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return automatedRefillCalendarResponse;
	}

	/**
	 * addAutomatedRefill
	 * 
	 * @param userToken
	 * @param patientOID
	 * @param rxNewRequest
	 * @return operationAddResponse
	 */
	public OperationAddResponse addAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, com.lcl.erefill.core.vo.RxNewRequest rxNewRequest,String locale) {
		final String methodName = "addAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse opAddResponse = new OperationAddResponse();
		try {

			IOperationSvc operationSvc = getOperationService();
			Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
			OperationalEvent operationalEvent = new OperationalEvent();
			XMLGregorianCalendar date = CommonUtils.getDateTime(new Date());
			
			operationalEvent.setCreatedDate(date);
			operationalEvent
					.setEventStart(CommonUtils.currentDatePlusOne(date));
			operationalEvent.setNextOperation(date);
			operationalEvent
					.setOperationalEventState(EOperationalEventState.E_ACTIVE);
			operationalEvent
					.setRecurrenceType(ERecurrenceType.E_EXPECTED_REFILL_DATE);
			operationalEvent.setRecurrence(0);
			long startTime = System.currentTimeMillis();
			Holder<String> oid = new Holder<String>();
			RxNewRequest rxReq = getRxNewRequest(rxNewRequest,locale);
			log.info("patient oid {}",patientOID);
			operationSvc.addAutomatedRefill(userTokenHolder, patientOID, rxReq,
					operationalEvent, null, oid);
			opAddResponse.setOid(oid.value);
			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			opAddResponse.setUserToken(userToken);
		} catch (IOperationSvcAddAutomatedRefillErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			opAddResponse.setUserToken(userToken);
			opAddResponse.setErrorCode(e.getFaultInfo().getInternalErrorCode());
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opAddResponse.setUserToken(userToken);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opAddResponse.setUserToken(userToken);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return opAddResponse;

	}

	/**
	 * getRxNewRequest
	 * 
	 * @param rxNewRequest
	 * @return rxReq
	 */
	private RxNewRequest getRxNewRequest(
			com.lcl.erefill.core.vo.RxNewRequest rxNewRequest,String strLocale) {
		RxNewRequest rxReq = new RxNewRequest();
		if (rxNewRequest != null) {
			rxReq.setComments(rxNewRequest.getComments());
			rxReq.setEMail(rxNewRequest.getEmail());
			rxReq.setLastState(ERequestState.fromValue(rxNewRequest
					.getLastState()));
			rxReq.setLastStateDate(CommonUtils.getDateTime(new Date()));
			rxReq.setMedReleaseMode(EMedReleaseMode.fromValue(rxNewRequest
					.getMedReleaseMode()));
			if ("Delivery".equalsIgnoreCase(rxNewRequest.getMedReleaseMode())) {
		
				try {
					if (StringUtils.isNotBlank(rxNewRequest.getDelReleaseDate())) {
						if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
							GregorianCalendar grgCalendar = new GregorianCalendar();
							grgCalendar.add(grgCalendar.DAY_OF_MONTH, 1);
							Date tomorrow = grgCalendar.getTime();
							XMLGregorianCalendar cal=CommonUtils.getFormattedFrDate(rxNewRequest.getDelReleaseDate(),ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR);
							Date calendar=cal.toGregorianCalendar().getTime();
							if(calendar.after(new Date())) {
							rxReq.setReleaseDate(CommonUtils
									.getFormattedFrDate(rxNewRequest
											.getDelReleaseDate(),ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR));
						} else {
							rxReq.setReleaseDate(CommonUtils
									.getFormattedFrDate(CommonUtils.getFormatDateFr(tomorrow),ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR));
						}
						}
							else {
								if(CommonUtils.getCustomFormatDate(rxNewRequest.getDelReleaseDate(),"MMM dd yyyy").after(new Date())) {
							rxReq.setReleaseDate(CommonUtils.getDateTimeFormat(rxNewRequest.getDelReleaseDate()));
						}
					 else {
						rxReq.setReleaseDate(CommonUtils.getDateTime(new Date()));
					}
							}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					log.info(e.getMessage());
				}
				rxReq.setDelivery(getRequestDelivery(rxNewRequest.getDelivery()));
			} else {
				if (StringUtils.isNotBlank(rxNewRequest.getPickReleaseDate()) 
						&& StringUtils.isNotBlank(rxNewRequest.getPickReleaseTime())) {
					rxReq.setReleaseDate(CommonUtils.getDateTime(
							rxNewRequest.getPickReleaseDate(),
							rxNewRequest.getPickReleaseTime()));
				} else {
					rxReq.setReleaseDate(CommonUtils.getDateTime(new Date()));
				}

			}
			if (rxNewRequest.getPhone() != null) {
				JAXBElement<String> jaxbElementPhone = new JAXBElement<String>(
						new QName(
								"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
								"MobilePhoneNumber"), String.class,
						rxNewRequest.getPhone());
				rxReq.setMobilePhoneNumber(jaxbElementPhone);
			}

			rxReq.setMedReleaseMode(com.lcl.erefill.generated.telus.operation.rxassystlib.EMedReleaseMode
					.fromValue(rxNewRequest.getMedReleaseMode()));

			if (rxNewRequest.getPharmacyContractNumber() != null) {
				rxReq.setPharmacyContractNumber(rxNewRequest
						.getPharmacyContractNumber());
				rxReq.setPatientDefaultPharmacy((short) 1);
			} else {
				rxReq.setPatientDefaultPharmacy((short) 0);
			}
			rxReq.setPrescriptions(getPrescription(rxNewRequest
					.getPrescriptions()));
		}
		return rxReq;
	}

	/**
	 * getPrescription
	 * 
	 * @param prescriptions
	 * @return
	 */
	private RxRenewPrescriptions getPrescription(
			com.lcl.erefill.core.vo.RxRenewPrescriptions prescriptions) {
		RxRenewPrescriptions prescs = new RxRenewPrescriptions();

		for (com.lcl.erefill.core.vo.RxRenewPrescription p : prescriptions
				.getRxRenewPrescription()) {

			RxRenewPrescription presc = new RxRenewPrescription();
			presc.setOID(p.getOid());
			presc.setComments(p.getComments());
			prescs.getRxRenewPrescription().add(presc);
		}
		return prescs;
	}

	/**
	 * getRequestDelivery
	 * 
	 * @param delivery
	 * @return
	 */
	private RequestDelivery getRequestDelivery(
			com.lcl.erefill.core.vo.RequestDelivery delivery) {
		RequestDelivery reqDel = new RequestDelivery();
		if (delivery != null) {
			if (delivery.getAddress() != null) {
				reqDel.setAddress(delivery.getAddress());
			}
			if (delivery.getCity() != null) {
				reqDel.setCity(delivery.getCity());
			}
			if (delivery.getFax() != null) {
				reqDel.setFax(delivery.getFax());
			}
			if (delivery.getProvince() != null) {
				reqDel.setProvince(EProvince.fromValue(delivery.getProvince()));
			} else {
				reqDel.setProvince(EProvince.UNKNOWN);
			}
			if (delivery.getPostalCode() != null) {
				reqDel.setPostalCode(delivery.getPostalCode());
			}
			if (delivery.getPhone() != null && delivery.getPhone().length() > 0) {
				JAXBElement<String> jaxbElementPhone = new JAXBElement<String>(
						new QName(
								"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
								"Phone"), String.class, delivery.getPhone());
				reqDel.setPhone(jaxbElementPhone);
			}
			return reqDel;
		}
		return null;
	}

	/**
	 * getAutomatedRefillByPatientOID
	 * 
	 * @param userToken
	 * @param patientOID
	 * @param locale 
	 * @return automatedRefillResponse
	 */
	public AutomatedRefillResponse getAutomatedRefillByPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, String storeId, String locale) {
		final String methodName = "getAutomatedRefillByPatientOID";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		IOperationSvc operationSvc = getOperationService();
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		AutomatedRefillResponse automatedRefillResponse = new AutomatedRefillResponse();
		AutomatedRefills automatedRefills = null;
		try {
			long startTime = System.currentTimeMillis();

			automatedRefills = operationSvc.getAutomatedRefillsByPatientOID(
					userTokenHolder, patientOID);
			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

			List<String> originalOids = new ArrayList<String>();
			List<String> autoRefillOids = new ArrayList<String>();
			List<String> refillDate = new ArrayList<String>();
			for (AutomatedRefill automatedRefill : automatedRefills
					.getAutomatedRefill()) {
				log.info("<OriginalOID>"
						+ automatedRefill.getOriginalPrescriptionsOID()
								.getString().get(0) + "</originalOid>");
				originalOids.add(automatedRefill.getOriginalPrescriptionsOID()
						.getString().get(0));
				log.info("<autoRefillOids>"
						+ automatedRefill.getOperationalEvent().getOID()
								.getValue() + "</autoRefillOids>");

				autoRefillOids.add(automatedRefill.getOperationalEvent()
						.getOID().getValue());
				log.info("<emailNotify>"
						+ automatedRefill.getRequest().getEMail()
						+ "</emailNotify>");

				AutomatedRefillCalendarResponse refillCalenderResponse = getExpectedAutomatedRefill(
						userToken, storeId,	automatedRefill.getOriginalPrescriptionsOID().getString().get(0), 
						automatedRefill.getRequest().getMedReleaseMode().value(),
						automatedRefill.getRxPrescriptions().getValue().getRxPrescription().get(0).getRxDate(),
						automatedRefill.getRxPrescriptions().getValue().getRxPrescription().get(0).getDaysSupply());

				List<List<AutomatedRefillCalendar>> refillCalenderList = refillCalenderResponse
						.getAutomatedRefillCalendarList();

				if (!refillCalenderList.isEmpty()) {
					refillDate.add(CommonUtils.getFormattedDate(CommonUtils
							.getNextDate(refillCalenderList.get(0).get(0)
									.getExpectedEvents().getExpectedEvent()), locale));
				} else {
					refillDate.add("");
				}
			}
			List<List<String>> list = new ArrayList<List<String>>();
			log.info("originalOids:::"+originalOids.size());
			log.info("autoRefillOids:::"+autoRefillOids.size());
			log.info("refillDate:::"+refillDate.size());
			list.add(originalOids);
			list.add(autoRefillOids);
			list.add(refillDate);
			automatedRefillResponse.setAutomatedRefillList(list);

		} catch (IOperationSvcGetAutomatedRefillsByPatientOIDErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			automatedRefillResponse.setUserToken(userToken);
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return automatedRefillResponse;
	}

	/**
	 * getRefillRemindersByPatientOID
	 * 
	 * @param userToken
	 * @param patientOID
	 * @return refillReminderResponse
	 */
	public RefillReminderResponse getRefillRemindersByPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID) {
		final String methodName = "getRefillRemindersByPatientOID";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		IOperationSvc operationSvc = getOperationService();
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> originalOids = new ArrayList<String>();
		List<String> refillReminderOids = new ArrayList<String>();
		RefillReminderResponse refillReminderResponse = new RefillReminderResponse();
		RefillReminders refillReminders = null;
		try {
			long startTime = System.currentTimeMillis();

			refillReminders = operationSvc.getRefillRemindersByPatientOID(
					userTokenHolder, patientOID);
			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

			if (refillReminders != null) {
				for (RefillReminder refillReminder : refillReminders
						.getRefillReminder()) {
					log.info("<OriginalOID>"
							+ refillReminder.getOriginalPrescriptionOID()
							+ "</originalOid>");
					originalOids.add(refillReminder
							.getOriginalPrescriptionOID());
					log.info("<refillReminderOids>"
							+ refillReminder.getOperationalEvent().getOID()
									.getValue() + "</refillReminderOids>");

					refillReminderOids.add(refillReminder.getOperationalEvent()
							.getOID().getValue());
				}
				list.add(originalOids);
				list.add(refillReminderOids);
			}
			refillReminderResponse.setReminderList(list);
			refillReminderResponse.setUserToken(userToken);
		} catch (IOperationSvcGetRefillRemindersByPatientOIDErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			refillReminderResponse.setUserToken(userToken);
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return refillReminderResponse;
	}

	/**
	 * addRefillReminder
	 * 
	 * @param userToken
	 * @param originalPrescriptionOID
	 * @param patientOID
	 * @param bufferTimeHours
	 * @param emailnotify
	 * @param phonenotify
	 * @return
	 */
	public OperationAddResponse addRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String originalPrescriptionOID, String patientOID,
			int bufferTimeHours, String email, String phone) {
		final String methodName = "addRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		OperationAddResponse opAddResponse = new OperationAddResponse();
		try {

			IOperationSvc operationSvc = getOperationService();
			Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
			OperationalEvent operationalEvent = new OperationalEvent();
			XMLGregorianCalendar date = CommonUtils.getDateTime(new Date());
			operationalEvent.setCreatedDate(date);
			operationalEvent
					.setEventStart(CommonUtils.currentDatePlusOne(date));
			operationalEvent.setNextOperation(date);;
			operationalEvent
					.setOperationalEventState(EOperationalEventState.E_ACTIVE);
			operationalEvent
					.setRecurrenceType(ERecurrenceType.E_EXPECTED_REFILL_DATE);
			operationalEvent.setRecurrence(0);
			long startTime = System.currentTimeMillis();
			Holder<String> oid = new Holder<String>();
			operationSvc.addRefillReminder(userTokenHolder, operationalEvent,
					originalPrescriptionOID, patientOID, bufferTimeHours*24,
					phone, email);
			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			opAddResponse.setUserToken(userToken);

		} catch (IOperationSvcAddRefillReminderErrorFaultFaultMessage e) {
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			userToken.setStatus("error");
			opAddResponse.setUserToken(userToken);
			opAddResponse.setErrorCode(e.getFaultInfo().getInternalErrorCode());
			log.error(e.getMessage(), e);
			return opAddResponse;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opAddResponse.setUserToken(userToken);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opAddResponse.setUserToken(userToken);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return opAddResponse;

	}

	/**
	 * deleteAutomatedRefill
	 * 
	 * @param userToken
	 * @param oid
	 * @return opResponse
	 */
	public OperationAddResponse deleteAutomatedRefill(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "deleteAutomatedRefill";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		IOperationSvc operationSvc = getOperationService();
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		OperationAddResponse opResponse = new OperationAddResponse();
		try {
			long startTime = System.currentTimeMillis();

			operationSvc.deleteAutomatedRefill(userTokenHolder, oid);

			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			opResponse.setUserToken(userToken);
		} catch (IOperationSvcDeleteAutomatedRefillErrorFaultFaultMessage e) {

			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			log.error(e.getMessage(), e);
			return opResponse;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return opResponse;
	}

	/**
	 * deleteRefillReminder
	 * 
	 * @param userToken
	 * @param oid
	 * @return
	 */
	public OperationAddResponse deleteRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "deleteRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		IOperationSvc operationSvc = getOperationService();
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		OperationAddResponse opResponse = new OperationAddResponse();
		try {
			long startTime = System.currentTimeMillis();

			operationSvc.deleteRefillReminder(userTokenHolder, oid);

			log.info("{}|{}", "deleteAutomatedRefill",
					CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			opResponse.setUserToken(userToken);
		} catch (IOperationSvcDeleteRefillReminderErrorFaultFaultMessage e) {
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			log.error(e.getMessage(), e);
			return opResponse;
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			return opResponse;
		} catch (Error e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
			return opResponse;
		}
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return opResponse;
	}

	/**
	 * getAutomatedRefillByOID
	 * 
	 * @param userToken
	 * @param oid
	 * @return automatedRefillResponse
	 */
	public AutomatedRefillResponse getAutomatedRefillByOID(
			com.lcl.erefill.core.common.entity.UserToken userToken, String oid) {
		final String methodName = "getAutomatedRefillByOID";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		IOperationSvc operationSvc = getOperationService();
		Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
		AutomatedRefillResponse autoRefillResponse = new AutomatedRefillResponse();
		AutomatedRefill autoRefill = null;

		try {
			long startTime = System.currentTimeMillis();

			autoRefill = operationSvc.getAutomatedRefillByOID(userTokenHolder,
					oid);
			log.info("{}|{}", methodName, CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			autoRefillResponse.setUserToken(userToken);
			autoRefillResponse.setAutomatedRefill(autoRefill);
		} catch (IOperationSvcGetAutomatedRefillByOIDErrorFaultFaultMessage e) {
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			userToken.setStatus("error");
			autoRefillResponse.setUserToken(userToken);
			log.error(e.getMessage(), e);
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			autoRefillResponse.setUserToken(userToken);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			userToken.setStatus("error");
			autoRefillResponse.setUserToken(userToken);
			ErrorHandler.handleError(e);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return autoRefillResponse;

	}

	/**
	 * updateAutoRefillReminder
	 * 
	 * @param userToken
	 * @param autoRefillReminderRequest
	 * @param oid
	 * @param patientOid
	 * @return
	 */
	public OperationAddResponse updateAutoRefillReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			AutoRefillReminderRequest autoRefillReminderRequest, String oid,
			String patientOid) {
		final String methodName = "updateAutoRefillReminder";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}

		IOperationSvc operationSvc = getOperationService();
		AutomatedRefillResponse autoRefillResponse = getAutomatedRefillByOID(
				userToken, oid);
		AutomatedRefill autoRefill = autoRefillResponse.getAutomatedRefill();
		RxNewRequest rxNewRequest = getRxNewRequest(autoRefill);
		String phone = autoRefillReminderRequest.getPhone();
		if (null != phone) {
			log.info("phone number is not null");
			JAXBElement<String> jaxbElementPhone = new JAXBElement<String>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"MobilePhoneNumber"), String.class, phone);
			rxNewRequest.setMobilePhoneNumber(jaxbElementPhone);
		} else {
			rxNewRequest.setMobilePhoneNumber(null);
		}
		rxNewRequest.setEMail(autoRefillReminderRequest.getEmail());
		OperationAddResponse opResponse = new OperationAddResponse();

		if (autoRefill != null) {
			Holder<UserToken> userTokenHolder = prepareOperationTokenHolder(userToken);
			OperationalEvent operationalEvent = autoRefill
					.getOperationalEvent();

			try {
				long startTime = System.currentTimeMillis();

				operationSvc.updateAutomatedRefill(userTokenHolder, patientOid,
						rxNewRequest, operationalEvent);
				log.info("{}|{}", methodName,
						CommonUtils.executionTime(startTime));
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				opResponse.setUserToken(userToken);
			} catch (IOperationSvcUpdateAutomatedRefillErrorFaultFaultMessage e) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				userToken.setStatus("error");
				opResponse.setUserToken(userToken);
				log.error(e.getMessage(), e);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				userToken.setStatus("error");
				opResponse.setUserToken(userToken);
				ErrorHandler.handleException(e);
			} catch (Error e) {
				log.error(e.getMessage(), e);
				userToken.setStatus("error");
				opResponse.setUserToken(userToken);
				ErrorHandler.handleError(e);
			}

			log.info("<OriginalOID>"
					+ autoRefill.getOriginalPrescriptionsOID().getString()
							.get(0) + "</originalOid>");
		} else {
			userToken.setStatus("error");
			opResponse.setUserToken(userToken);
		}

		if (log.isDebugEnabled()) {
			log.debug(methodName + " Exiting");
		}
		return opResponse;
	}

	/**
	 * getRxNewRequest
	 * 
	 * @param autoRefill
	 * @return rxNewRequest
	 */
	private RxNewRequest getRxNewRequest(AutomatedRefill autoRefill) {
		final String methodName = "getRxNewRequest";
		if (log.isDebugEnabled()) {
			log.debug(methodName + " Entering");
		}
		RxNewRequest rxNewRequest = new RxNewRequest();
		if (autoRefill != null) {
			Request rxReq = autoRefill.getRequest();
			if (rxReq != null) {
				if (rxReq.getComments() != null)
					rxNewRequest.setComments(rxReq.getComments());
				if (rxReq.getDelivery() != null)
					rxNewRequest.setDelivery(rxReq.getDelivery());
				if (rxReq.getLastState() != null)
					rxNewRequest.setLastState(rxReq.getLastState());
				if (rxReq.getLastStateDate() != null)
					rxNewRequest.setLastStateDate(rxReq.getLastStateDate());
				if (rxReq.getMedReleaseMode() != null)
					rxNewRequest.setMedReleaseMode(rxReq.getMedReleaseMode());
				if (rxReq.getOID() != null)
					rxNewRequest.setOID(rxReq.getOID());
				if (rxReq.getPharmacyContractNumber() != null)
					rxNewRequest.setPharmacyContractNumber(rxReq
							.getPharmacyContractNumber());
				if (rxReq.getReleaseDate() != null) {
					XMLGregorianCalendar releaseDate = CommonUtils
							.getDateTime(new Date());
					releaseDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
					rxNewRequest.setReleaseDate(releaseDate);
				}
			}
			RxRenewPrescriptions rxRenewPrescs = new RxRenewPrescriptions();
			RxPrescriptions rxPrescs = autoRefill.getRxPrescriptions()
					.getValue();
			if (rxPrescs != null) {
				for (RxPrescription rxPresc : rxPrescs.getRxPrescription()) {
					RxRenewPrescription rxRenewPresc = new RxRenewPrescription();
					rxRenewPresc.setComments(rxPresc.getComments());
					rxRenewPresc.setOID(rxPresc.getOID());
					rxRenewPrescs.getRxRenewPrescription().add(rxRenewPresc);
				}
			}
			rxNewRequest.setPrescriptions(rxRenewPrescs);
		}
		return rxNewRequest;
	}
}
