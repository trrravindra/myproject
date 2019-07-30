package com.lcl.erefill.core.services.integ.telus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.telus.response.GetAssignedPatientsResponse;
import com.lcl.erefill.core.common.telus.response.ManagedAccountResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.vo.Facility;
import com.lcl.erefill.core.vo.FamilyManagerPatientRequestsVO;
import com.lcl.erefill.core.vo.PharmacyOpeningHour;
import com.lcl.erefill.core.vo.Prescriber;
import com.lcl.erefill.generated.telus.manager.IManagerSvc;
import com.lcl.erefill.generated.telus.manager.IManagerSvcAccountAssignManagerRequestErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcDeleteAccountAssociationErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcFamilyManagerAssignAcceptErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcFamilyManagerAssignDeclineErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetAssignedPatientsErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetFamilyManagerRequestsErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetFamilyManagersErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetHierarchicalParametersErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetManagerRequestsErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcGetPatientOIDErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.IManagerSvcManagerAssignAccountRequestErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ArrayOfeParameterProperty;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EFamilyManagerAssignRequestState;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EHierarchicalLevel;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ESettingType;
import com.lcl.erefill.generated.telus.manager.rxassystlib.UserAccount;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfPharmacyOpeningHour;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ExtendedInfo;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FamilyManagerPatientRequest;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FamilyManagerPatientRequests;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FamilyManagerRequestState;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FilterParameters;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ObjectFactory;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ParametersExtendedInfo;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Patient;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PatientAccount;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PatientAccounts;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PatientContact;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PatientContacts;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Patients;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Pharmacy;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyParameterValue;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyParametersValue;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyTarget;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccounts;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken;

/***
 * 
 * @author gpunno version 1.0
 */

@Component
public class ManagerWSImpl extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(ManagerWSImpl.class);

	@Autowired
	ProfileWSImpl profileWSImpl;

	/**
	 * accountAssignManagerRequest
	 * 
	 * @param userToken
	 * @param guestUserName
	 * @param guestPassword
	 * @param consentForGuest
	 * @param consentOID
	 * @param description
	 * @return
	 * @throws Exception
	 */
	public DataCarrier accountAssignManagerRequest(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String guestUserName, String guestPassword,
			boolean consentForGuest, String consentOID, String description)
			throws Exception {
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		com.lcl.erefill.core.common.entity.UserToken token = new com.lcl.erefill.core.common.entity.UserToken();
		DataCarrier dataCarrier = new DataCarrier();
		try {
			getManagerService().accountAssignManagerRequest(userTokenHolder,
					guestUserName, guestPassword, consentForGuest, consentOID,
					description);

			token.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value
					.getToken().getValue()));
			token.setStatus(userTokenHolder.value.getStatus().get(0));

		} catch (IManagerSvcAccountAssignManagerRequestErrorFaultFaultMessage e) {
			token.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				token.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
						.getUserToken().getValue().getToken().getValue()));
			}
			if (e.getFaultInfo() != null) {

				if (e.getFaultInfo().getInternalErrorCode() == 2073) {
					dataCarrier.addObject(ERefillConstants.ERROR, "2073");
				} else if (e.getFaultInfo().getInternalErrorCode() == 2074) {
					dataCarrier.addObject(ERefillConstants.ERROR, "2074");
				} else if (e.getFaultInfo().getInternalErrorCode() == 2059) {
					dataCarrier.addObject(ERefillConstants.ERROR, "2059");
				} else if (e.getFaultInfo().getInternalErrorCode() == 3
						|| e.getFaultInfo().getInternalErrorCode() == 9) {
					dataCarrier.addObject(ERefillConstants.ERROR,
							"sessionexpired");
				} else {
					dataCarrier.addObject(ERefillConstants.ERROR, "error");
				}
			} else {
				dataCarrier.addObject(ERefillConstants.ERROR, "error");
			}

		}catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		dataCarrier.addObject(ERefillConstants.REQUEST_USER_TOKEN, token);
		return dataCarrier;
	}

	/**
	 * getAssignedPatients
	 * 
	 * @param userToken
	 * @param requestState
	 * @return
	 */
	public GetAssignedPatientsResponse getAssignedPatients(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestState) {
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		GetAssignedPatientsResponse assignedPatientsResponse = new GetAssignedPatientsResponse();
		ExtendedInfo extInfo = new ExtendedInfo();
		extInfo.getPatientExtendedInfo().add("All");
		extInfo.getPatientExtendedInfo().add(requestState);

		try {
			Patients patients = getManagerService().getAssignedPatients(
					userTokenHolder, extInfo, null, null, null);
			List<Patient> telusPatientList = patients.getPatient();
			assignedPatientsResponse
					.setAssignedPatients(getPatientList(telusPatientList));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			assignedPatientsResponse.setUserToken(userToken);
		} catch (IManagerSvcGetAssignedPatientsErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				assignedPatientsResponse.setUserToken(userToken);
				return assignedPatientsResponse;
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return assignedPatientsResponse;
	}

	private List<com.lcl.erefill.core.vo.Patient> getPatientList(
			List<Patient> telusPatientList) {
		if (telusPatientList.isEmpty())
			return null;
		else {
			List<com.lcl.erefill.core.vo.Patient> patientList = new ArrayList<com.lcl.erefill.core.vo.Patient>();
			for (Patient telusPatient : telusPatientList) {
				com.lcl.erefill.core.vo.Patient patient = new com.lcl.erefill.core.vo.Patient();
				if (null != telusPatient.getAccounts()) {
					patient.setAccounts(getPatientAccountList(telusPatient
							.getAccounts()));
				}
				if (null != telusPatient.getAddress()) {
					patient.setAddress(telusPatient.getAddress());
				} else {
					patient.setAddress("");
				}
				if (null != telusPatient.getAlias()) {
					patient.setAlias(telusPatient.getAlias());
				} else {
					patient.setAlias("");
				}
				if (null != telusPatient.getBirthDate()) {
					patient.setBirthDate(telusPatient.getBirthDate());
				}

				if (null != telusPatient.getBirthDateV2()) {
					patient.setBirthDateV2(telusPatient.getBirthDateV2()
							.getValue());
				}
				patient.setCreatinineClearance(telusPatient
						.getCreatinineClearance());
				if (null != telusPatient.getCreationDate()) {
					patient.setCreationDate(telusPatient.getCreationDate());
				}
				if (null != telusPatient.getCity()) {
					patient.setCity(telusPatient.getCity());
				} else {
					patient.setCity("");
				}
				if (null != telusPatient.getComments()) {
					patient.setComments(telusPatient.getComments());
				} else {
					patient.setComments("");
				}
				if (null != telusPatient.getCreationDateV2()) {
					patient.setCreationDateV2(telusPatient.getCreationDateV2()
							.getValue());
				}
				if (null != telusPatient.getDefaultPharmacy()) {
					patient.setDefaultPharmacy(getDefaultPharmacy(telusPatient
							.getDefaultPharmacy().getValue()));
				}
				if (null != telusPatient.getContacts()) {
					patient.setContacts(getPatientContacts(telusPatient
							.getContacts()));
				}
				if (null != telusPatient.getDeliveryAddress()) {
					patient.setDeliveryAddress(telusPatient
							.getDeliveryAddress());
				} else {
					patient.setDeliveryAddress("");
				}
				if (null != telusPatient.getDeliveryCity()) {
					patient.setDeliveryCity(telusPatient.getDeliveryCity());
				} else {
					patient.setDeliveryCity("");
				}
				if (null != telusPatient.getDeliveryComments()) {
					patient.setDeliveryComments(telusPatient
							.getDeliveryComments());
				} else {
					patient.setDeliveryComments("");
				}
				if (null != telusPatient.getDeliveryPhoneNumber()) {
					patient.setDeliveryPhoneNumber(telusPatient
							.getDeliveryPhoneNumber());
				} else {
					patient.setDeliveryPhoneNumber("");
				}
				if (null != telusPatient.getDeliveryPostalCode()) {
					patient.setDeliveryPostalCode(telusPatient
							.getDeliveryPostalCode());
				} else {
					patient.setDeliveryPostalCode("");
				}
				if (null != telusPatient.getDeliveryProvince()) {
					patient.setDeliveryProvince(telusPatient
							.getDeliveryProvince().value());
				} else {
					patient.setDeliveryProvince("");
				}
				if (null != telusPatient.getDISKey()) {
					patient.setDisKey(telusPatient.getDISKey());
				} else {
					patient.setDisKey("");
				}
				if (null != telusPatient.getFacilityDepartureDate()) {
					patient.setFacilityDepartureDate(telusPatient
							.getFacilityDepartureDate());
				} else {
					patient.setFacilityDepartureDate(0);
				}
				if (null != telusPatient.getFacilityReturnDate()) {
					patient.setFacilityReturnDate(telusPatient
							.getFacilityReturnDate());
				} else {
					patient.setFacilityReturnDate(0);
				}
				if (null != telusPatient.getFacility()) {
					patient.setFacility(getFacility(telusPatient.getFacility()));
				}
				if (null != telusPatient.getFacilityBed()) {
					patient.setFacilityBed(telusPatient.getFacilityBed());
				} else {
					patient.setFacilityBed("");
				}
				if (null != telusPatient.getFacilityDepartureDateV2()) {
					patient.setFacilityDepartureDateV2(telusPatient
							.getFacilityDepartureDateV2().getValue());
				}
				if (null != telusPatient.getFacilityFloor()) {
					patient.setFacilityFloor(telusPatient.getFacilityFloor());
				} else {
					patient.setFacilityFloor("");
				}
				if (null != telusPatient.getFacilityReturnDateV2()) {
					patient.setFacilityReturnDateV2(telusPatient
							.getFacilityReturnDateV2().getValue());
				}
				if (null != telusPatient.getFacilityRoom()) {
					patient.setFacilityRoom(telusPatient.getFacilityRoom());
				} else {
					patient.setFacilityRoom("");
				}
				if (null != telusPatient.getFacilityTable()) {
					patient.setFacilityTable(telusPatient.getFacilityTable());
				} else {
					patient.setFacilityTable("");
				}
				if (null != telusPatient.getFamilyPhysician()) {
					patient.setFamilyPhysician(getPrescriber(telusPatient
							.getFamilyPhysician()));
				}
				if (null != telusPatient.getFirstName()) {
					patient.setFirstName(telusPatient.getFirstName());
				} else {
					patient.setFirstName("");
				}
				if (null != telusPatient.getGender()
						&& null != telusPatient.getGender().value()) {
					patient.setGender(telusPatient.getGender().value());
				} else {
					patient.setGender("");
				}
				patient.setHeight(telusPatient.getHeight());
				if (null != telusPatient.getHeightWeightModificationDate()) {
					patient.setHeightWeightModificationDate(telusPatient
							.getHeightWeightModificationDate());
				}
				if (null != telusPatient.getHeightWeightModificationDateV2()) {
					patient.setHeightWeightModificationDateV2(telusPatient
							.getHeightWeightModificationDateV2().getValue());
				}
				if (null != telusPatient.getHospitalCardNumber()) {
					patient.setHospitalCardNumber(telusPatient
							.getHospitalCardNumber());
				} else {
					patient.setHospitalCardNumber("");
				}
				if (null != telusPatient.getLanguage()) {
					patient.setLanguage(telusPatient.getLanguage().value());
				} else {
					patient.setLanguage("");
				}
				if (null != telusPatient.getLastName()) {
					patient.setLastName(telusPatient.getLastName());
				} else {
					patient.setLastName("");
				}
				if (null != telusPatient.getLoyaltyCardNumber()) {
					patient.setLoyaltyCardNumber(telusPatient
							.getLoyaltyCardNumber());
				} else {
					patient.setLoyaltyCardNumber("");
				}
				if (null != telusPatient.getModificationDate()) {
					patient.setModificationDate(telusPatient
							.getModificationDate());
				}
				if (null != telusPatient.getModificationDateV2()
						&& null != telusPatient.getModificationDateV2()
								.getValue()) {
					patient.setModificationDateV2(telusPatient
							.getModificationDateV2().getValue());
				}
				if (null != telusPatient.getOID()) {
					patient.setOid(telusPatient.getOID());
				} else {
					patient.setOid("");
				}
				if (null != telusPatient.getPatientFile()) {
					patient.setPatientFile(telusPatient.getPatientFile());
				} else {
					patient.setPatientFile("");
				}
				if (null != telusPatient.getPHN()) {
					patient.setPhn(telusPatient.getPHN());
				} else {
					patient.setPhn("");
				}
				if (null != telusPatient.getPHNExpiration()) {
					patient.setPhnExpiration(telusPatient.getPHNExpiration());
				} else {
					patient.setPhnExpiration("");
				}
				if (null != telusPatient.getPHNType()) {
					patient.setPhnType(telusPatient.getPHNType().value());
				} else {
					patient.setPhnType("");
				}
				if (null != telusPatient.getPhoneNumber()) {
					patient.setPhoneNumber(telusPatient.getPhoneNumber());
				} else {
					patient.setPhoneNumber("");
				}
				if (null != telusPatient.getPostalCode()) {
					patient.setPostalCode(telusPatient.getPostalCode());
				} else {
					patient.setPostalCode("");
				}
				if (null != telusPatient.getProvince()) {
					patient.setProvince(telusPatient.getProvince().value());
				} else {
					patient.setProvince("");
				}
				if (null != telusPatient.getReferenceFileNumber()) {
					patient.setReferenceFileNumber(telusPatient
							.getReferenceFileNumber());
				} else {
					patient.setReferenceFileNumber("");
				}
				if (null != telusPatient.getShortRemark()) {
					patient.setShortRemark(telusPatient.getShortRemark());
				} else {
					patient.setShortRemark("");
				}
				if (null != telusPatient.getUserName()
						&& null != telusPatient.getUserName().getValue()) {
					patient.setUserName(telusPatient.getUserName().getValue());
				} else {
					patient.setUserName("");
				}
				patient.setWeight(telusPatient.getWeight());
				if (null != telusPatient.getWorkPhoneNumber()) {
					patient.setWorkPhoneNumber(telusPatient
							.getWorkPhoneNumber());
				} else {
					patient.setWorkPhoneNumber("");
				}
				patientList.add(patient);
			}
			return patientList;
		}

	}

	private Prescriber getPrescriber(
			com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Prescriber telusFamilyPhysician) {
		Prescriber prescriber = new Prescriber();
		if (null != telusFamilyPhysician.getBirthDate()) {
			prescriber.setBirthDate(telusFamilyPhysician.getBirthDate());
		}
		if (null != telusFamilyPhysician.getAddress()) {
			prescriber.setAddress(telusFamilyPhysician.getAddress());
		} else {
			prescriber.setAddress("");
		}
		if (null != telusFamilyPhysician.getBirthDateV2()) {
			prescriber.setBirthDateV2(telusFamilyPhysician.getBirthDateV2()
					.getValue());
		}
		if (null != telusFamilyPhysician.getCity()) {
			prescriber.setCity(telusFamilyPhysician.getCity());
		} else {
			prescriber.setCity("");
		}
		if (null != telusFamilyPhysician.getFirstName()) {
			prescriber.setFirstName(telusFamilyPhysician.getFirstName());
		} else {
			prescriber.setFirstName("");
		}
		if (null != telusFamilyPhysician.getGender()
				&& null != telusFamilyPhysician.getGender().value()) {
			prescriber.setGender(telusFamilyPhysician.getGender().value());
		} else {
			prescriber.setGender("");
		}
		if (null != telusFamilyPhysician.getLanguage()
				&& null != telusFamilyPhysician.getLanguage().value()) {
			prescriber.setLanguage(telusFamilyPhysician.getLanguage().value());
		} else {
			prescriber.setLanguage("");
		}
		if (null != telusFamilyPhysician.getLastName()) {
			prescriber.setLastName(telusFamilyPhysician.getLastName());
		} else {
			prescriber.setLastName("");
		}
		if (null != telusFamilyPhysician.getLicense()) {
			prescriber.setLicense(telusFamilyPhysician.getLicense());
		} else {
			prescriber.setLicense("");
		}
		if (null != telusFamilyPhysician.getPhoneNumber()) {
			prescriber.setPhoneNumber(telusFamilyPhysician.getPhoneNumber());
		} else {
			prescriber.setPhoneNumber("");
		}
		if (null != telusFamilyPhysician.getPostalCode()) {
			prescriber.setPostalCode(telusFamilyPhysician.getPostalCode());
		} else {
			prescriber.setPostalCode("");
		}
		if (null != telusFamilyPhysician.getWorkPhoneNumber()) {
			prescriber.setWorkPhoneNumber(telusFamilyPhysician
					.getWorkPhoneNumber());
		} else {
			prescriber.setWorkPhoneNumber("");
		}
		if (null != telusFamilyPhysician.getProvince()
				&& null != telusFamilyPhysician.getProvince().value()) {
			prescriber.setProvince(telusFamilyPhysician.getProvince().value());
		} else {
			prescriber.setProvince("");
		}
		return prescriber;
	}

	private Facility getFacility(
			com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Facility telusFacility) {
		Facility facility = new Facility();
		if (null != telusFacility.getAddress()) {
			facility.setAddress(telusFacility.getAddress());
		} else {
			facility.setAddress("");
		}
		if (null != telusFacility.getCity()) {
			facility.setCity(telusFacility.getCity());
		} else {
			facility.setCity("");
		}
		if (null != telusFacility.getFax()) {
			facility.setFax(telusFacility.getFax());
		} else {
			facility.setFax("");
		}
		if (null != telusFacility.getName()) {
			facility.setName(telusFacility.getName());
		} else {
			facility.setName("");
		}
		if (null != telusFacility.getNumber()) {
			facility.setNumber(telusFacility.getNumber());
		} else {
			facility.setNumber("");
		}
		if (null != telusFacility.getOID()
				&& null != telusFacility.getOID().getValue()) {
			facility.setOid(telusFacility.getOID().getValue());
		} else {
			facility.setOid("");
		}
		if (null != telusFacility.getPhone()) {
			facility.setPhone(telusFacility.getPhone());
		} else {
			facility.setPhone("");
		}
		if (null != telusFacility.getPostalCode()) {
			facility.setPostalCode(telusFacility.getPostalCode());
		} else {
			facility.setPostalCode("");
		}
		if (null != telusFacility.getProvince()) {
			facility.setProvince(telusFacility.getProvince().value());
		} else {
			facility.setProvince("");
		}

		return facility;
	}

	private com.lcl.erefill.core.vo.PatientContacts getPatientContacts(
			PatientContacts contacts) {
		com.lcl.erefill.core.vo.PatientContacts patientContacts = new com.lcl.erefill.core.vo.PatientContacts();
		List<com.lcl.erefill.core.vo.PatientContact> patientContactList = new ArrayList<com.lcl.erefill.core.vo.PatientContact>();
		if (null != contacts && null != contacts.getPatientContact()) {
			List<PatientContact> list = contacts.getPatientContact();
			if (!list.isEmpty()) {
				Iterator<PatientContact> listItr = list.iterator();
				while (listItr.hasNext()) {
					PatientContact pc = listItr.next();
					com.lcl.erefill.core.vo.PatientContact patientContact = new com.lcl.erefill.core.vo.PatientContact();
					if (null != pc.getContactType()) {
						patientContact.setContactType(pc.getContactType()
								.value());
					}
					if (null != pc.getValue()) {
						patientContact.setValue(pc.getValue());
					}
					patientContactList.add(patientContact);
				}
				patientContacts.setPatientContact(patientContactList);
			}
		}
		return patientContacts;
	}

	private com.lcl.erefill.core.vo.Pharmacy getDefaultPharmacy(
			Pharmacy pharmacy) {
		com.lcl.erefill.core.vo.Pharmacy defaultPharmacy = new com.lcl.erefill.core.vo.Pharmacy();
		if (pharmacy != null) {
			if (null != pharmacy.getAddress()) {
				defaultPharmacy.setAddress(pharmacy.getAddress());
			} else {
				defaultPharmacy.setAddress("");
			}
			if (null != pharmacy.getChain()) {
				defaultPharmacy.setChain(pharmacy.getChain());
			} else {
				defaultPharmacy.setChain("");
			}
			if (null != pharmacy.getCity()) {
				defaultPharmacy.setCity(pharmacy.getCity());
			} else {
				defaultPharmacy.setCity("");
			}
			if (null != pharmacy.getContractNumber()) {
				defaultPharmacy.setContractNumber(pharmacy.getContractNumber());
			} else {
				defaultPharmacy.setContractNumber("");
			}
			if (null != pharmacy.getEmail()
					&& null != pharmacy.getEmail().getValue()) {
				defaultPharmacy.setEmail(pharmacy.getEmail().getValue());
			} else {
				defaultPharmacy.setEmail("");
			}
			if (null != pharmacy.getFaxNumber()) {
				defaultPharmacy.setFaxNumber(pharmacy.getFaxNumber());
			} else {
				defaultPharmacy.setFaxNumber("");
			}
			if (null != pharmacy.getImageChecksum()
					&& null != pharmacy.getImageChecksum().getValue()) {
				defaultPharmacy.setImageChecksum(pharmacy.getImageChecksum()
						.getValue());
			} else {
				defaultPharmacy.setImageChecksum("");
			}
			if (null != pharmacy.getInternalId()
					&& null != pharmacy.getInternalId().getValue()) {
				defaultPharmacy.setInternalId(pharmacy.getInternalId()
						.getValue());
			} else {
				defaultPharmacy.setInternalId("");
			}
			if (null != pharmacy.getMessage()
					&& null != pharmacy.getMessage().getValue()) {
				defaultPharmacy.setMessage(pharmacy.getMessage().getValue());
			} else {
				defaultPharmacy.setMessage("");
			}
			if (null != pharmacy.getPharmacyOpeningHours()
					&& null != pharmacy.getPharmacyOpeningHours().getValue()) {
				defaultPharmacy
						.setPharmacyOpeningHours(getPharmacyOpeningHours(pharmacy
								.getPharmacyOpeningHours().getValue()));
			}
			if (null != pharmacy.getName()) {
				defaultPharmacy.setName(pharmacy.getName());
			} else {
				defaultPharmacy.setName("");
			}
			if (null != pharmacy.getNumber()) {
				defaultPharmacy.setNumber(pharmacy.getNumber());
			} else {
				defaultPharmacy.setNumber("");
			}
			if (null != pharmacy.getOwner()) {
				defaultPharmacy.setOwner(pharmacy.getOwner());
			} else {
				defaultPharmacy.setOwner("");
			}
			if (null != pharmacy.getPhoneNumber()) {
				defaultPharmacy.setPhoneNumber(pharmacy.getPhoneNumber());
			} else {
				defaultPharmacy.setPhoneNumber("");
			}
			if (null != pharmacy.getPostalCode()) {
				defaultPharmacy.setPostalCode(pharmacy.getPostalCode());
			} else {
				defaultPharmacy.setPostalCode("");
			}
			if (null != pharmacy.getProvince()) {
				defaultPharmacy.setProvince(pharmacy.getProvince().value());
			} else {
				defaultPharmacy.setProvince("");
			}
			return defaultPharmacy;
		}
		return null;
	}

	private List<PharmacyOpeningHour> getPharmacyOpeningHours(
			ArrayOfPharmacyOpeningHour arrayOfPharmacyOpeningHour) {
		List<PharmacyOpeningHour> pharmacyOpeningHours = new ArrayList<PharmacyOpeningHour>();
		for (com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyOpeningHour telusPharmacyOpeningHour : arrayOfPharmacyOpeningHour
				.getPharmacyOpeningHour()) {
			PharmacyOpeningHour pharmacyOpeninghour = new PharmacyOpeningHour();
			if (null != telusPharmacyOpeningHour.getHourFrom()) {
				pharmacyOpeninghour.setHourFrom(telusPharmacyOpeningHour
						.getHourFrom());
			}
			if (null != telusPharmacyOpeningHour.getHourTo()) {
				pharmacyOpeninghour.setHourFrom(telusPharmacyOpeningHour
						.getHourTo());
			}
			if (null != telusPharmacyOpeningHour.getHourFromV2()) {
				pharmacyOpeninghour.setHourFromV2(telusPharmacyOpeningHour
						.getHourFromV2());
			}
			if (null != telusPharmacyOpeningHour.getHourToV2()) {
				pharmacyOpeninghour.setHourToV2(telusPharmacyOpeningHour
						.getHourToV2());
			}
			if (null != telusPharmacyOpeningHour.getWeekDay()) {
				pharmacyOpeninghour.setWeekDay(telusPharmacyOpeningHour
						.getWeekDay().value());
			}
			pharmacyOpeningHours.add(pharmacyOpeninghour);
		}
		return null;
	}

	private com.lcl.erefill.core.vo.PatientAccounts getPatientAccountList(
			PatientAccounts telusPatientAccounts) {
		com.lcl.erefill.core.vo.PatientAccounts patientAccounts = new com.lcl.erefill.core.vo.PatientAccounts();
		if (!telusPatientAccounts.getPatientAccount().isEmpty()) {
			for (PatientAccount telusPatientAccount : telusPatientAccounts
					.getPatientAccount()) {
				com.lcl.erefill.core.vo.PatientAccount patientAccount = new com.lcl.erefill.core.vo.PatientAccount();
				if (null != telusPatientAccount.getAddress()) {
					patientAccount.setAddress(telusPatientAccount.getAddress());
				}
				if (null != telusPatientAccount.getCity()) {
					patientAccount.setCity(telusPatientAccount.getCity());
				}
				if (null != telusPatientAccount.getFaxNumber()) {
					patientAccount.setFaxNumber(telusPatientAccount
							.getFaxNumber());
				}
				if (null != telusPatientAccount.getName()) {
					patientAccount.setName(telusPatientAccount.getName());
				}
				if (null != telusPatientAccount.getNumber()) {
					patientAccount.setNumber(telusPatientAccount.getNumber());
				}
				if (null != telusPatientAccount.getPhoneNumber()) {
					patientAccount.setPhoneNumber(telusPatientAccount
							.getPhoneNumber());
				}
				if (null != telusPatientAccount.getPostalCode()) {
					patientAccount.setPostalCode(telusPatientAccount
							.getPostalCode());
				}
				if (null != telusPatientAccount.getProvince()) {
					patientAccount.setProvince(telusPatientAccount
							.getProvince().value());
				}
				if (null != telusPatientAccount.getType()) {
					patientAccount.setType(telusPatientAccount.getType()
							.value());
				}
				patientAccounts.getPatientAccount().add(patientAccount);
			}
			return patientAccounts;
		}
		return null;
	}

	/**
	 * getManagerRequest
	 * 
	 * @param userToken
	 * @return
	 */
	public FamilyManagerPatientRequests getManagerRequest(
			com.lcl.erefill.core.common.entity.UserToken userToken) {

		FamilyManagerPatientRequests familyManagerPatientRequest = null;

		try {
			Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
			FamilyManagerRequestState familyManagerReqState = new FamilyManagerRequestState();
			familyManagerReqState
					.setState(EFamilyManagerAssignRequestState.ALL);
			familyManagerPatientRequest = getManagerService()
					.getManagerRequests(userTokenHolder, familyManagerReqState);

		} catch (IManagerSvcGetManagerRequestsErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}

		return familyManagerPatientRequest;

	}

	/**
	 * getFamilyManager
	 * 
	 * @param userToken
	 * @return
	 */
	public FamilyManagerPatientRequests getFamilyManager(
			com.lcl.erefill.core.common.entity.UserToken userToken) {

		FamilyManagerPatientRequests familyManagerPatientRequest = null;
		try {
			Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
			FamilyManagerRequestState familyManagerReqState = new FamilyManagerRequestState();
			familyManagerReqState
					.setState(EFamilyManagerAssignRequestState.PENDING);
			familyManagerPatientRequest = getManagerService()
					.getFamilyManagerRequests(userTokenHolder,
							familyManagerReqState);
		} catch (IManagerSvcGetFamilyManagerRequestsErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return familyManagerPatientRequest;

	}

	/**
	 * managerAssignAccountRequest
	 * 
	 * @param userToken
	 * @param guestUserName
	 * @param guestPassword
	 * @param consentForGuest
	 * @param consentOID
	 * @param description
	 * @return
	 * @throws Exception
	 */
	public DataCarrier managerAssignAccountRequest(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String guestUserName, String guestPassword,
			boolean consentForGuest, String consentOID, String description)
			throws Exception {

		Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		DataCarrier dataCarrier = new DataCarrier();
		try {
			getManagerService().managerAssignAccountRequest(userTokenHolder,
					guestUserName, guestPassword, consentForGuest, consentOID,
					description);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

		} catch (IManagerSvcManagerAssignAccountRequestErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			}
			if (e.getFaultInfo() != null) {
				if (e.getFaultInfo().getInternalErrorCode() == 2073)
					dataCarrier.addObject(ERefillConstants.ERROR, "2073");
				else if (e.getFaultInfo().getInternalErrorCode() == 2074)
					dataCarrier.addObject(ERefillConstants.ERROR, "2074");
				else if (e.getFaultInfo().getInternalErrorCode() == 2059)
					dataCarrier.addObject(ERefillConstants.ERROR, "2059");
				else if (e.getFaultInfo().getInternalErrorCode() == 2084)
					dataCarrier.addObject(ERefillConstants.ERROR, "2084");
				else if (e.getFaultInfo().getInternalErrorCode() == 3
						|| e.getFaultInfo().getInternalErrorCode() == 9)
					dataCarrier.addObject(ERefillConstants.ERROR,
							"sessionexpired");
				else
					dataCarrier.addObject(ERefillConstants.ERROR, "error");
			} else {
				dataCarrier.addObject(ERefillConstants.ERROR, "error");
			}
		} catch (Exception e) {			
			if (e.getMessage() != null
					&& e.getMessage().equalsIgnoreCase("eInvalidUserPassword")) {
				ERefillBusinessException invalidUserExc = (ERefillBusinessException) e
						.getCause();
				userToken.setToken(invalidUserExc.getUserToken().getToken());
				userToken.setStatus("error");
				dataCarrier.addObject(ERefillConstants.ERROR, "password-error");
			}

		}
		dataCarrier.addObject(ERefillConstants.REQUEST_USER_TOKEN, userToken);
		return dataCarrier;
	}

	/**
	 * deleteAccountAssociation
	 * 
	 * @param userToken
	 * @param managerUsername
	 * @param managedUsername
	 * @param sendNotification
	 * @return
	 */
	public com.lcl.erefill.core.common.entity.UserToken deleteAccountAssociation(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String managerUsername, String managedUsername,
			boolean sendNotification) {

		Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		try {
			getManagerService().deleteAccountAssociation(userTokenHolder,
					managerUsername, managedUsername, sendNotification);
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
		} catch (IManagerSvcDeleteAccountAssociationErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				return userToken;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}

		return userToken;
	}

	/**
	 * familyManagerAssignAccept
	 * 
	 * @param userToken
	 * @param requestorUserName
	 * @param consentOID
	 * @return
	 */
	public com.lcl.erefill.core.common.entity.UserToken familyManagerAssignAccept(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestorUserName, String consentOID) {
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		try {
			getManagerService().familyManagerAssignAccept(userTokenHolder,
					requestorUserName, consentOID);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IManagerSvcFamilyManagerAssignAcceptErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				return userToken;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return userToken;
	}

	/**
	 * familyManagerAssignDecline
	 * 
	 * @param userToken
	 * @param requestorUserName
	 * @return
	 */
	public com.lcl.erefill.core.common.entity.UserToken familyManagerAssignDecline(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestorUserName) {
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		try {
			getManagerService().familyManagerAssignDecline(userTokenHolder,
					requestorUserName);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IManagerSvcFamilyManagerAssignDeclineErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				return userToken;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		return userToken;
	}

	/**
	 * getManagerRequest
	 * 
	 * @param userToken
	 * @param requestState
	 * @return ManagedAccountResponse
	 * @throws Exception
	 */
	public ManagedAccountResponse getManagerRequest(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestState) throws Exception {

		ManagedAccountResponse accountResponse = new ManagedAccountResponse();
		FamilyManagerPatientRequests familyManagerPatientRequest = null;
		List<FamilyManagerPatientRequestsVO> acceptedPatientsList = new ArrayList<FamilyManagerPatientRequestsVO>();
		List<FamilyManagerPatientRequestsVO> pendingPatientsList = new ArrayList<FamilyManagerPatientRequestsVO>();
		Map<String, ArrayList<FamilyManagerPatientRequestsVO>> users = new HashMap<String, ArrayList<FamilyManagerPatientRequestsVO>>();
		Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		try {

			FamilyManagerRequestState familyManagerReqState = new FamilyManagerRequestState();
			familyManagerReqState.setState(EFamilyManagerAssignRequestState
					.fromValue(requestState));
			familyManagerPatientRequest = getManagerService()
					.getManagerRequests(userTokenHolder, familyManagerReqState);
			List<FamilyManagerPatientRequest> familyManagerList = familyManagerPatientRequest
					.getFamilyManagerPatientRequest();
			if (null != familyManagerList) {
				for (FamilyManagerPatientRequest patientReq : familyManagerList) {
					FamilyManagerPatientRequestsVO patientVO = new FamilyManagerPatientRequestsVO();
					patientVO.setFirstName(patientReq.getFirstName());
					patientVO.setLastName(patientReq.getLastName());
					patientVO.setUserName(patientReq.getUserName());
					patientVO.setRequestState(patientReq.getRequestsState()
							.value());
					patientVO.setDescription(patientReq.getDescription()
							.getValue());
					GregorianCalendar calendar = new GregorianCalendar(
							patientReq.getStateDate().getYear(), patientReq
									.getStateDate().getMonth(), patientReq
									.getStateDate().getDay(), patientReq
									.getStateDate().getHour(), patientReq
									.getStateDate().getMinute(), patientReq
									.getStateDate().getSecond());
					patientVO.setStateDate(calendar);
					if (users.containsKey(patientVO.getUserName())) {
						users.get(patientVO.getUserName()).add(patientVO);
					} else {
						ArrayList<FamilyManagerPatientRequestsVO> newList = new ArrayList<FamilyManagerPatientRequestsVO>();
						newList.add(patientVO);
						users.put(patientVO.getUserName(), newList);
					}
				}
			}
			for (ArrayList<FamilyManagerPatientRequestsVO> patient : users
					.values()) {
				Collections.sort(patient,
						new Comparator<FamilyManagerPatientRequestsVO>() {
							public int compare(
									FamilyManagerPatientRequestsVO o1,
									FamilyManagerPatientRequestsVO o2) {
								return o2.getStateDate().compareTo(
										o1.getStateDate());
							}
						});
				if (EFamilyManagerAssignRequestState.ACCEPTED.value().equals(
						(patient.get(0).getRequestState()))) {
					acceptedPatientsList.add(patient.get(0));
				}

				else if (EFamilyManagerAssignRequestState.PENDING.value()
						.equals((patient.get(0).getRequestState()))) {
					pendingPatientsList.add(patient.get(0));
				}
			}
			accountResponse.getManagerMap().put("acceptedListManager",
					acceptedPatientsList);
			accountResponse.getManagerMap().put("pendingListManager",
					pendingPatientsList);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IManagerSvcGetManagerRequestsErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
			}
		accountResponse.setUserToken(userToken);
		return accountResponse;
	}

	/**
	 * pendingCustodianRequests
	 * 
	 * @param userToken
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer pendingCustodianRequests(DataCarrier dataCarrier,
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		List<FamilyManagerPatientRequestsVO> patientList = null;
		try {
			ManagedAccountResponse accountResponse = getManagerRequest(
					userToken, "Pending");
			if (null != accountResponse) {
				if (null != accountResponse.getManagerMap()) {
					patientList = (List<FamilyManagerPatientRequestsVO>) accountResponse
							.getManagerMap().get("pendingListManager");
				}
				if (null != accountResponse.getUserToken()) {
					dataCarrier.addObject(ERefillConstants.REQUEST_USER_TOKEN,
							userToken);
				}
			}
		} catch (Exception e) {
			return null;
		}
		if (patientList != null && patientList.size() != 0)
			return patientList.size();
		else
			return null;
	}

	/**
	 * getManagedAccountDetails
	 * 
	 * @param userToken
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getManagedAccountDetails(
			com.lcl.erefill.core.common.entity.UserToken userToken)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		ManagedAccountResponse managedAccountResponse = new ManagedAccountResponse();
		try {
			managedAccountResponse = getFamilyManager(userToken, "Pending");

			if (null != managedAccountResponse) {
				map.put("pendingListFamilyManager", managedAccountResponse
						.getManagerMap().get("pendingListFamilyManager"));
			} else {
				map.put("pendingListFamilyManager", null);
			}

			managedAccountResponse = new ManagedAccountResponse();
			managedAccountResponse = getFamilyManager(userToken, "Accepted");

			if (null != managedAccountResponse) {
				map.put("acceptedListFamilyManager", managedAccountResponse
						.getManagerMap().get("acceptedListFamilyManager"));
			} else {
				map.put("acceptedListFamilyManager", null);
			}

			managedAccountResponse = new ManagedAccountResponse();

			managedAccountResponse = getManagerRequest(userToken, "Pending");

			if (null != managedAccountResponse) {
				map.put("pendingListManager", managedAccountResponse
						.getManagerMap().get("pendingListManager"));
			} else {
				map.put("pendingListManager", null);
			}

			managedAccountResponse = new ManagedAccountResponse();

			managedAccountResponse = getManagerRequest(userToken, "Accepted");

			if (null != managedAccountResponse) {
				map.put("acceptedListManager", managedAccountResponse
						.getManagerMap().get("acceptedListManager"));
			} else {
				map.put("acceptedListManager", null);
			}
		} catch (Exception e) {
			log.error("Exception while fetching managed account details:  "
					+ e);
			//return null;
			ErrorHandler.handleException(e);
		}catch (Error e) {
			log.error("Exception while fetching managed account details:  "
					+ e);
			ErrorHandler.handleError(e);
			}
		return map;
	}

	/**
	 * getFamilyManager
	 * 
	 * @param userToken
	 * @param requestState
	 * @return
	 */
	public ManagedAccountResponse getFamilyManager(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestState) {

		ManagedAccountResponse accountResponse = new ManagedAccountResponse();
		FamilyManagerPatientRequests familyManagerPatientRequest = null;
		List<FamilyManagerPatientRequestsVO> patientList = new ArrayList<FamilyManagerPatientRequestsVO>();
		Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);

		try {

			FamilyManagerRequestState familyManagerReqState = new FamilyManagerRequestState();
			familyManagerReqState.setState(EFamilyManagerAssignRequestState
					.fromValue(requestState));
			familyManagerPatientRequest = getManagerService()
					.getFamilyManagerRequests(userTokenHolder,
							familyManagerReqState);

			List<FamilyManagerPatientRequest> familyManagerList = familyManagerPatientRequest
					.getFamilyManagerPatientRequest();

			if (null != familyManagerList) {
				for (FamilyManagerPatientRequest patientReq : familyManagerList) {
					FamilyManagerPatientRequestsVO patientVO = new FamilyManagerPatientRequestsVO();
					patientVO.setFirstName(patientReq.getFirstName());
					patientVO.setLastName(patientReq.getLastName());
					patientVO.setUserName(patientReq.getUserName());
					patientVO.setDescription(patientReq.getDescription()
							.getValue());
					patientReq.getRequestsState().value();
					patientList.add(patientVO);
				}
			}

		} catch (IManagerSvcGetFamilyManagerRequestsErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				accountResponse.setUserToken(userToken);
				return accountResponse;
			}
		} catch (Error e) {
			ErrorHandler.handleError(e);
		}

		accountResponse.getManagerMap().put(requestState + "ListFamily",
				patientList);
		userToken.setStatus(userTokenHolder.value.getStatus().get(0));
		userToken.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value
				.getToken().getValue()));
		accountResponse.setUserToken(userToken);

		return accountResponse;
	}

	/**
	 * getPatientOID
	 * 
	 * @param userToken
	 * @param username
	 * @return
	 */
	public Map<String, String> getPatientOID(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String username) {
		IManagerSvc managerSvc = getManagerService();
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		Map<String, String> retObj = new HashMap<String, String>();
		String patientOID = "";
		try {
			patientOID = managerSvc.getPatientOID(userTokenHolder, username);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			retObj.put("patientOID", patientOID);
			retObj.put(ERefillConstants.REQUEST_USER_TOKEN, CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IManagerSvcGetPatientOIDErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				retObj.put(ERefillConstants.REQUEST_USER_TOKEN, CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
			}
		} catch (Error e) {
			ErrorHandler.handleError(e);
		}
		return retObj;
	}

	/**
	 * getFamilyManagersList
	 * 
	 * @param userToken
	 * @param username
	 * @return
	 */
	public List<UserAccount> getFamilyManagersList(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String username) {
		IManagerSvc managerSvc = getManagerService();
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		List<UserAccount> managersList = new ArrayList<UserAccount>();
		UserAccounts managerAccounts = new UserAccounts();
		try {
			managerAccounts = managerSvc.getFamilyManagers(userTokenHolder,
					username);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IManagerSvcGetFamilyManagersErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			}
		}
		if (managerAccounts != null) {
			managersList = managerAccounts.getUserAccount();
		}
		return managersList;
	}

	/**
	 * getHierarchicalParameters
	 * 
	 * @param userToken
	 * @param contractNumber
	 * @param patientOID
	 * @param StoreId
	 * @return
	 */
	public DataCarrier getHierarchicalParameters(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String contractNumber, String patientOID, String StoreId) {

		DataCarrier dataCarrier = new DataCarrier();
		IManagerSvc managerSvc = getManagerService();
		int ageLimit = 0;
		Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
		PharmacyParametersValue pharmacyParametersValue = null;
		PharmacyTarget target = new PharmacyTarget();
		ParametersExtendedInfo parametersExtendedInfo = new ParametersExtendedInfo();
		FilterParameters filterParameters = new FilterParameters();
		ArrayOfeParameterProperty arrayOfeParameterProperty = new ArrayOfeParameterProperty();
		try {
			arrayOfeParameterProperty.getEParameterProperty().add(
					"ConsentRevocationAge");
			if (filterParameters.getParametersList() != null)
				filterParameters.getParametersList().setValue(
						arrayOfeParameterProperty);
			else {
				ObjectFactory objectFactory = new ObjectFactory();
				filterParameters
						.setParametersList(objectFactory
								.createFilterParametersParametersList(arrayOfeParameterProperty));
			}
			filterParameters.setSettingType(ESettingType.ALL);
			target.setLevel(EHierarchicalLevel.PHARMACY);
			if (StringUtils.isNotBlank(contractNumber)) {
				target.setContractNumber(contractNumber);
			} else {
				target.setContractNumber(StoreId);
			}
			parametersExtendedInfo.getExtendedInfo().add("None");
			try {
				pharmacyParametersValue = managerSvc.getHierarchicalParameters(
						userTokenHolder, target, filterParameters,
						parametersExtendedInfo);
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));

			} catch (IManagerSvcGetHierarchicalParametersErrorFaultFaultMessage e) {
				userToken.setStatus("error");
				if (null != e.getFaultInfo().getUserToken()) {
					userToken.setToken(CommonUtils.byteArrayAsString(e
							.getFaultInfo().getUserToken().getValue()
							.getToken().getValue()));
				}

			}

			if (pharmacyParametersValue != null
					&& pharmacyParametersValue.getPharmacyParameterValue() != null
					&& !pharmacyParametersValue.getPharmacyParameterValue()
							.isEmpty()) {
				ageLimit = Integer.parseInt(pharmacyParametersValue
						.getPharmacyParameterValue().get(0).getValue()) / 12;
			}
			dataCarrier.addObject(ERefillConstants.REQUEST_USER_TOKEN,
					userToken);
			dataCarrier.addObject(ERefillConstants.MINOR_AGE_LIMIT, ageLimit);
		} catch (Exception e1) {
			log.error("Error: " + e1);
		}

		return dataCarrier;
	}

	/**
	 * getPharmacyAllParameter
	 * 
	 * @param userToken
	 * @param contractNumber
	 * @param patientOID
	 * @param storeId
	 * @return
	 */
	public Map<String, Object> getPharmacyAllParameter(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String storeId, String patientOID) {
		Map<String, Object> response = new HashMap<String, Object>();
		/*String pickUpBufferTime = "";
		String pickUpThreshold = "";
		String homeDropBufferTime = "";
		String homeDropThreshold = "";*/
		try {
			IManagerSvc managerSvc = getManagerService();
			Holder<UserToken> userTokenHolder = prepareManagerTokenHolder(userToken);
			
			/************************************************************************/
			
			PharmacyTarget target = new PharmacyTarget();
			target.setLevel(EHierarchicalLevel.PHARMACY);
			target.setContractNumber(storeId);
			QName valQName = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientOID");
			JAXBElement<String> dobElement = new JAXBElement<String>(valQName, String.class, patientOID);
			target.setPatientOID(dobElement);
			
			FilterParameters filterParameters = new FilterParameters();
			ArrayOfeParameterProperty arrayOfeParameterProperty = new ArrayOfeParameterProperty();
			arrayOfeParameterProperty.getEParameterProperty().add("WebSitePickupThresholdMinutes");
			arrayOfeParameterProperty.getEParameterProperty().add("WebSitePickupBufferTimeMinutes");
			arrayOfeParameterProperty.getEParameterProperty().add("WebSiteHomedropThresholdMinutes");
			arrayOfeParameterProperty.getEParameterProperty().add("WebSiteHomedropBufferTimeMinutes");
			ObjectFactory objectFactory = new ObjectFactory();
			filterParameters.setParametersList(objectFactory.createFilterParametersParametersList(arrayOfeParameterProperty));
			Map<String,String> portalToTelusvarMap = new HashMap<String, String>();
			portalToTelusvarMap.put("WebSitePickupThresholdMinutes", "pickUpThreshold");
			portalToTelusvarMap.put("WebSitePickupBufferTimeMinutes", "pickUpBufferTime");
			portalToTelusvarMap.put("WebSiteHomedropThresholdMinutes", "homeDropThreshold");
			portalToTelusvarMap.put("WebSiteHomedropBufferTimeMinutes", "homeDropBufferTime");
			
			ParametersExtendedInfo parametersExtendedInfo = new ParametersExtendedInfo();
			parametersExtendedInfo.getExtendedInfo().add("None");
			
			PharmacyParametersValue pharmacyParametersValue = managerSvc.getHierarchicalParameters(userTokenHolder, target, filterParameters, parametersExtendedInfo);
			
			if(pharmacyParametersValue!=null && pharmacyParametersValue.getPharmacyParameterValue()!=null && !pharmacyParametersValue.getPharmacyParameterValue().isEmpty()) {
				/*pickUpThreshold =pharmacyParametersValue.getPharmacyParameterValue().get(0).getValue();
				pickUpBufferTime =pharmacyParametersValue.getPharmacyParameterValue().get(1).getValue();
				homeDropThreshold =pharmacyParametersValue.getPharmacyParameterValue().get(2).getValue();
				homeDropBufferTime =pharmacyParametersValue.getPharmacyParameterValue().get(3).getValue();*/				
				
				Iterator<PharmacyParameterValue> pharmacyHours = pharmacyParametersValue.getPharmacyParameterValue().iterator();
				
				while (pharmacyHours.hasNext()) {
					PharmacyParameterValue pharmaParams = pharmacyHours.next();
					String pharmaParamName = portalToTelusvarMap.get(pharmaParams.getName());
					log.debug("pharmaParamName :: "+pharmaParamName);
					if(null != pharmaParamName){
						log.debug("Pharma Parameter Value :: "+pharmaParams.getValue());
						response.put(pharmaParamName,pharmaParams.getValue());
					}
				}
			}
			
		
			/************************************************************************/
			
			/*PharmacyParameters pharmacyParameters = managerSvc
					.getPharmacyAllParameter(userTokenHolder, storeId);
			
			if (pharmacyParameters != null) {
				pickUpBufferTime = ""
						+ pharmacyParameters
								.getWebSitePickupBufferTimeMinutes();
				pickUpThreshold = ""
						+ pharmacyParameters.getWebSitePickupThresholdMinutes();
				homeDropBufferTime = ""
						+ pharmacyParameters
								.getWebSiteHomedropBufferTimeMinutes();
				homeDropThreshold = ""
						+ pharmacyParameters
								.getWebSiteHomedropThresholdMinutes();
				
			}*/
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			response.put("userToken", userToken);
		} catch (IManagerSvcGetHierarchicalParametersErrorFaultFaultMessage e) {
			userToken.setStatus("error");
			if (null != e.getFaultInfo().getUserToken()) {
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				response.put("userToken", userToken);
			}
		} catch (Exception e) {
			log.error("Error: " + e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error("Error: " + e);
			ErrorHandler.handleError(e);
		}
		return response;
	}
}
