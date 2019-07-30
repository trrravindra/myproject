package com.lcl.erefill.core.services.integ.telus;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.common.telus.response.PrescriptionFilterResponse;
import com.lcl.erefill.core.common.telus.response.RefillHistoryResponse;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.ServiceUtils;
import com.lcl.erefill.core.vo.DrugHeaderView;
import com.lcl.erefill.core.vo.PharmacyOpeningHour;
import com.lcl.erefill.core.vo.PrescDetailsView;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ERxPrescriptionState;
import com.lcl.erefill.generated.telus.profile.IProfileSvcGetPatientDataErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.profile.IProfileSvcGetPrescriptionHistoryErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.profile.IProfileSvcGetPrescriptionsErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.ArrayOfPharmacyOpeningHour;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.CustomFilters;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Patient;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Pharmacy;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Prescription;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PrescriptionDisplay;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PrescriptionExtendedInfo;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PrescriptionRestriction;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Prescriptions;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Product;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.ProfilePrescription;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.ProfilePrescriptions;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken;

@Service
public class ProfileWSImpl extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(ProfileWSImpl.class);
	
	private Boolean isMedicationPage=false;

	public PrescriptionFilterResponse getListOfPrescriptions(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOid, int pageNum, String sortFieldVal,
			String dateFilter, Date fromDate, Date toDate, boolean flagReload,
			String page, String strLocale, Integer totalRecords, Integer firstRecord,
			Integer numOfPages) {
		List<PrescriptionsBO> retList = null;
		PrescriptionFilterResponse prescriptionFilterResponse = new PrescriptionFilterResponse();
		try {

			List<PrescriptionsBO> listProfPresc = null;
			if("myMedicationRecord".equalsIgnoreCase(page)){
				isMedicationPage=true;
			}
			listProfPresc = getPrescriptions(userToken, strLocale, patientOid);
			List<PrescriptionsBO> filteredList = null;
			
			if ("myPrescriptions".equalsIgnoreCase(page)) {

				List<PrescriptionsBO> tempFilteredList = ServiceUtils
						.filterValidPrescriptions(listProfPresc, dateFilter);
				if (null != fromDate && null != toDate) {
					filteredList = ServiceUtils.filterValidPrescriptions(
							tempFilteredList, fromDate, toDate);
				} else {
					filteredList = ServiceUtils.filterValidPrescriptions(
							tempFilteredList, dateFilter);
				}
			} else {
				if (null != fromDate && null != toDate) {
					filteredList = ServiceUtils.filterValidPrescriptions(
							listProfPresc, fromDate, toDate);
				} else {
					filteredList = ServiceUtils.filterValidPrescriptions(
							listProfPresc, dateFilter);
				}
			}

			if (null != fromDate && null != toDate) {
				filteredList = ServiceUtils.filterValidPrescriptions(
						listProfPresc, fromDate, toDate);
			} else {
				filteredList = ServiceUtils.filterValidPrescriptions(
						listProfPresc, dateFilter);
			}

			if (null != filteredList && !filteredList.isEmpty()) {
				totalRecords = filteredList.size();
				numOfPages = CommonUtils.getNumberOfPages(totalRecords);
				String pageSize = ERefillConfigService.PAGE_LENGTH_MYPRESCRIPTION;
				firstRecord = ((pageNum - 1) * Integer.parseInt(pageSize)) + 1;
				retList = ServiceUtils.getSortedPrescriptions(filteredList,
						sortFieldVal, pageNum, false);
				prescriptionFilterResponse.setFirstRecord(firstRecord);
				prescriptionFilterResponse.setNumOfPages(numOfPages);
				prescriptionFilterResponse.setLstPresc(retList);
				prescriptionFilterResponse.setTotalRecords(totalRecords);
			}
			prescriptionFilterResponse.setUserToken(userToken);
			
		}catch(ERefillApplicationException e){ 
			log.error(e.getMessage(), e);
			throw e;
		} 
		catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return prescriptionFilterResponse;
	}

	/**
	 * getPrescriptions
	 * 
	 * @param userToken
	 * @param strLocale
	 * @param patientOid
	 * @return lstRetPrescs
	 */
	public List<PrescriptionsBO> getPrescriptions(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String strLocale, String patientOid) {
		log.debug("executing getPrescriptions() start");
		log.info("\n\npatientOid: "+patientOid);
		log.info("\nuserToken: "+userToken);
		
		CustomFilters customFilters=null;
		List<PrescriptionsBO> lstRetPrescs = new ArrayList<PrescriptionsBO>();
		try {
			Holder<UserToken> userTokenHolder = prepareProfileTokenHolder(userToken);
			PrescriptionExtendedInfo prescExtInfo = new PrescriptionExtendedInfo();
			
			if(isMedicationPage){
				log.debug(">> Next page is medication page");
				customFilters = getCustomFilters();
				isMedicationPage=false;
			}
			
			prescExtInfo.getExtendedInfo().add(
					ERefillConstants.PRESCRIPTION_EXTENDED_INFO_ALL);
			long startTime = System.currentTimeMillis();
			log.debug("performing executingprofileSvc.getPrescriptions start");
			ProfilePrescriptions prescWrap = getProfileService()
					.getPrescriptions(userTokenHolder, prescExtInfo,
							patientOid, null, customFilters);
			log.debug("performing executingprofileSvc.getPrescriptions end");
			log.info("getPrescriptions" + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

			if (null != prescWrap && null != prescWrap.getProfilePrescription()) {
				List<ProfilePrescription> profilePrescriptionList = prescWrap
						.getProfilePrescription();
				for (ProfilePrescription telusProfilePrescription : profilePrescriptionList) {
					PrescriptionsBO prescBO = new PrescriptionsBO();
					prescBO.setLocale(CommonUtils
							.getLocaleFromString(strLocale));
					if (null != telusProfilePrescription.getProduct()) {
						Product temp = telusProfilePrescription.getProduct();
						if (null != temp.getName()) {
							prescBO.setName(temp.getName());
							log.info("\n\nName: "+temp.getName());
							log.info("\nisNarcotic: "+telusProfilePrescription.isNarcotic());
							
						} else {
							prescBO.setName("");
						}

						if (null != temp.getGenericName()) {
							prescBO.setGenericName(temp.getGenericName());
						} else {
							prescBO.setGenericName("");
						}

						if (null != temp.getStrength()) {
							prescBO.setStrength(temp.getStrength());
						} else {
							prescBO.setStrength("");
						}

						if (null != temp.getDIN()) {
							prescBO.setDIN(temp.getDIN());
						} else {
							prescBO.setDIN("");
						}
					}

					if (null != telusProfilePrescription.getRxNumber()) {
						prescBO.setRxNumber(telusProfilePrescription
								.getRxNumber());
					} else {
						prescBO.setRxNumber("");
					}

					prescBO.setLastState(null != telusProfilePrescription.getLastState() ? telusProfilePrescription.getLastState().value() : null);

					prescBO.setQuantityFilled((telusProfilePrescription.getQuantityFilled() / 100));
					prescBO.setDaysSupply(telusProfilePrescription.getDaysSupply());
					prescBO.setRxDate(telusProfilePrescription.getRxDate());

					if (null != telusProfilePrescription.getOriginalPrescription() && null != telusProfilePrescription.getOriginalPrescription().getValue()) {
						prescBO.setOriginalOID(telusProfilePrescription.getOriginalPrescription().getValue().getOID());
					}

					/*
					 * if (null != telusProfilePrescription
					 * .getPrescriptionDisplay() && null !=
					 * telusProfilePrescription
					 * .getPrescriptionDisplay().getValue()) {
					 * PrescriptionDisplay tempPrescDisp =
					 * telusProfilePrescription
					 * .getPrescriptionDisplay().getValue(); if (null !=
					 * tempPrescDisp.getRemainingRepeats() && null !=
					 * tempPrescDisp.getRemainingRepeats() .getValue()) {
					 * prescBO.setRefillRemaining(telusProfilePrescription
					 * .getPrescriptionDisplay().getValue()
					 * .getRemainingRepeats().getValue()); } else {
					 * prescBO.setRefillRemaining(0); } } else {
					 * prescBO.setRefillRemaining(0); }
					 */

					if (null != telusProfilePrescription.getRxDate()) {
						if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
							prescBO.setLastFilledDate(CommonUtils.getFormattedDate(telusProfilePrescription.getRxDate(),ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR,strLocale));
							
							prescBO.setEstimatedFillDate(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(telusProfilePrescription.getRxDate(),	
															telusProfilePrescription.getDaysSupply()),ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR,strLocale));
							prescBO.setEstimatedFillDateEn(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(telusProfilePrescription.getRxDate(),telusProfilePrescription.getDaysSupply()),
									ERefillConstants.DATE_FORMAT_PRESCRIPTION,ERefillConstants.EREFILL_DEFAULT_LOCALE));
						} else {
							prescBO.setLastFilledDate(CommonUtils.getFormattedDate(telusProfilePrescription.getRxDate(),ERefillConstants.DATE_FORMAT_PRESCRIPTION, strLocale));
							
							prescBO.setEstimatedFillDate(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(telusProfilePrescription.getRxDate(),
											telusProfilePrescription.getDaysSupply()),ERefillConstants.DATE_FORMAT_PRESCRIPTION,strLocale));
							prescBO.setEstimatedFillDateEn(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(telusProfilePrescription.getRxDate(),telusProfilePrescription.getDaysSupply()),
									ERefillConstants.DATE_FORMAT_PRESCRIPTION,strLocale));
						}
					} else {
						if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
							prescBO.setLastFilledDate(CommonUtils.getFormattedDate(20130401,ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR,strLocale));
							prescBO.setEstimatedFillDate(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(20130401,telusProfilePrescription.getDaysSupply()),
															ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR,strLocale));
						} else {
							prescBO.setLastFilledDate(CommonUtils.getFormattedDate(20130401,ERefillConstants.DATE_FORMAT_PRESCRIPTION,strLocale));
							prescBO.setEstimatedFillDate(CommonUtils.getFormattedDate(CommonUtils.getNextFillDate(20130401,telusProfilePrescription.getDaysSupply()),
															ERefillConstants.DATE_FORMAT_PRESCRIPTION,strLocale));
						}
					}

					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							&& null != telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getExpirationDate()) {

						log.info(">>>> expiration date validation >>>");

						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getExpirationDate().getValue()) {
							prescBO.setPrescriptionDisplayExpirationDate(CommonUtils
									.getFormattedDate(telusProfilePrescription
											.getPrescriptionDisplay()
											.getValue().getExpirationDate()
											.getValue(), strLocale));

						}

					}

					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							.getRemainingQuantity()) {
						log.info(">>>> remaining quanity validation >>>");
						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getRemainingQuantity().getValue()) {
							prescBO.setPrescriptionDisplayRemainingQuantity(telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getRemainingQuantity().getValue());
						}

					}
					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							.getRemainingRepeats()) {
						log.info(">>>> remaining repeats validation >>>");
						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getRemainingRepeats().getValue()) {
							prescBO.setPrescriptionDisplayRemainingRepeats(telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getRemainingRepeats().getValue());
						}

					}
					
					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							.getRemainingRepeats()) {
						log.info(">>>> IsAutomatedRefillAllowed validation >>>");
						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getIsAutomatedRefillAllowed().getValue()) {
							prescBO.setAutomatedRefillAllowed(telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getIsAutomatedRefillAllowed().getValue());
							//log.info("<<>><<>> IsAutomatedRefillAllowed   "+prescBO.getAutomatedRefillAllowed());
						}

					}
					
					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							.getRemainingRepeats()) {
						log.info(">>>> RefillReminderAllowed validation >>>");
						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getIsRefillReminderAllowed().getValue()) {
							prescBO.setRefillReminderAllowed(telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getIsRefillReminderAllowed().getValue());
							//log.info("<<>><<>> IsRefillReminderAllowed   "+prescBO.getRefillReminderAllowed());
						}

					}
					
					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							&& null != telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getNextExpectedDate()) {

						log.info(">>>> NextExpectedDate validation >>>");

						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getNextExpectedDate().getValue()) {
							prescBO.setNextExpectedDate(CommonUtils
									.getFormattedDate(telusProfilePrescription
											.getPrescriptionDisplay()
											.getValue().getNextExpectedDate()
											.getValue(), strLocale));
							//log.info("RefillNextDate<<>><<>>"+prescBO.getNextExpectedDate());

						}

					}
					
					if (null != telusProfilePrescription
							.getPrescriptionDisplay().getValue()
							.getOperationalEventOid()) {
						log.info(">>>> OperationalEventOid validation >>>");
						if (null != telusProfilePrescription
								.getPrescriptionDisplay().getValue()
								.getOperationalEventOid().getValue()) {
							prescBO.setOperationalEventOid(telusProfilePrescription
									.getPrescriptionDisplay().getValue()
									.getOperationalEventOid().getValue());
							//log.info("<<>><<>> OperationalEventOid   "+prescBO.getOperationalEventOid());
						}

					}

					if (null != telusProfilePrescription.getPrescriber()
							&& null != telusProfilePrescription.getPrescriber()
									.getFirstName()) {
						prescBO.setPrescriberFirstName(telusProfilePrescription
								.getPrescriber().getFirstName());
					} else {
						prescBO.setPrescriberFirstName("");
					}
					if (null != telusProfilePrescription.getPrescriber()
							&& null != telusProfilePrescription.getPrescriber()
									.getLastName()) {
						prescBO.setPrescriberLastName(telusProfilePrescription
								.getPrescriber().getLastName());
					} else {
						prescBO.setPrescriberLastName("");
					}
					prescBO.setSigDecoded(telusProfilePrescription
							.getSigDecoded());
					//prescBO.setNarcotic(telusProfilePrescription.isNarcotic());
					prescBO.setPrescOID(telusProfilePrescription.getOID());
					
					setRestrictionOptions(telusProfilePrescription, prescBO);
					setPrescriptionDisplayOptions(telusProfilePrescription,
							prescBO, strLocale);

					lstRetPrescs.add(prescBO);
				}
			}

		} catch (IProfileSvcGetPrescriptionsErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			ErrorHandler.handleException(e);
			//throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		log.debug("executing getPrescriptions() end");
		return lstRetPrescs;
	}

	
	/**  only for my medication record
	   <rxas:Aborted>false</rxas:Aborted>
	   <rxas:ActivePeriod>2010-01-18T14:09:45.418</rxas:ActivePeriod> --- last 72 months(6 years)
	   **************CR: 12th Feb 2016 : now 72 months has been changed to 60 months
	   <rxas:Expired>1900-01-01T00:00:00.000</rxas:Expired>
	   *************CR: 12th Feb 2016 : now 9999 months has been changed to 60 months
	   <rxas:ConsiderExcludedDINList>true</rxas:ConsiderExcludedDINList>
	   <rxas:Otc>true</rxas:Otc>
	 */
	private CustomFilters getCustomFilters()
			throws DatatypeConfigurationException {
		CustomFilters customFilters = new CustomFilters();
		
		GregorianCalendar greCalendar = new GregorianCalendar();
		
		/*XMLGregorianCalendar expiredDateCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(greCalendar);
		expiredDateCalendar.setYear(1900);
		expiredDateCalendar.setMonth(01);
		expiredDateCalendar.setDay(01);*/
		
		greCalendar.add(Calendar.MONTH, -60);		
		XMLGregorianCalendar activatePeriodCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(greCalendar);
		XMLGregorianCalendar expiredDateCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(greCalendar);
		
		/* setting custom filter values */
		customFilters.setAborted(new JAXBElement<Boolean>(new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data","Aborted"), Boolean.class, null, false));
		customFilters.setActivePeriod(new JAXBElement<XMLGregorianCalendar>(new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data","ActivePeriod"), XMLGregorianCalendar.class, null, activatePeriodCalendar));
		customFilters.setExpired(new JAXBElement<XMLGregorianCalendar>(new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data","Expired"), XMLGregorianCalendar.class, null, expiredDateCalendar));
		customFilters.setConsiderExcludedDINList(new JAXBElement<Boolean>(new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data","ConsiderExcludedDINList"), Boolean.class, null, true));
		customFilters.setOtc(new JAXBElement<Boolean>(new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data","Otc"), Boolean.class, null, true));
		
		return customFilters;
	}

	/**
	 * This method is used to read the Restrictions Element and set the Values
	 * to Refillable, display messages, etc.
	 * 
	 * @param telusProfilePrescription
	 * @param prescBO
	 */
	@SuppressWarnings("static-access")
	private void setRestrictionOptions(
			ProfilePrescription telusProfilePrescription,
			PrescriptionsBO prescBO) {

		boolean isRefillAllowed = true;
		boolean isNoRefill = false;
		boolean isNarcotic = false;
		boolean isControlled = false;
		if (null != telusProfilePrescription.getRestrictions()	&& null != telusProfilePrescription.getRestrictions().getValue()) {
			List<PrescriptionRestriction> tempRestrList = telusProfilePrescription.getRestrictions().getValue().getPrescriptionRestriction();
			for (PrescriptionRestriction restrict : tempRestrList) {
				if (!restrict.isRefillAllowed()) {
					
					isRefillAllowed = false;
				}
				if (restrict.getType().equals(restrict.getType().NO_REFILL)) {
					isNoRefill = true;
				}
				if (restrict.getType().equals(restrict.getType().NARCOTIC)) {
					isNarcotic = true;
				}
				if (restrict.getType().equals(restrict.getType().CONTROLLED)) {
					isControlled = true;
				}
			}
			if (isRefillAllowed) {
				if (isNoRefill) {
					prescBO.setNoRefill(isNoRefill);
				}
				if (telusProfilePrescription.getLastState().value().equals(ERxPrescriptionState.RECEIVED_ETA_REQUIRED.value())
						|| telusProfilePrescription.getLastState().value().equals(ERxPrescriptionState.RECEIVED.value())
						|| telusProfilePrescription.getLastState().value().equals(ERxPrescriptionState.PENDING.value())) {
					prescBO.setRefillAllowed(false);
				} else {
					prescBO.setRefillAllowed(true);
				}
			} else if (isNarcotic) {
				prescBO.setNarcotic(isNarcotic);
			} else if (isControlled) {
				prescBO.setControlled(isControlled);
			}
		} else {

			prescBO.setRefillAllowed(true);
		}
	}

	/**
	 * This method is used to read the PrescriptionDispla Element and set the
	 * Values to RemainingRepeats, ExpirationDate and Remaining quantity.
	 * 
	 * @param telusProfilePrescription
	 * @param prescBO
	 */
	private void setPrescriptionDisplayOptions(
			ProfilePrescription telusProfilePrescription,
			PrescriptionsBO prescBO, String strLocale) {

		if (null != telusProfilePrescription.getPrescriptionDisplay()) {

			JAXBElement<PrescriptionDisplay> prescriptionDisplay = telusProfilePrescription
					.getPrescriptionDisplay();
			JAXBElement<XMLGregorianCalendar> expirationDate = prescriptionDisplay
					.getValue().getExpirationDate();
			JAXBElement<Integer> remainingQuantity = prescriptionDisplay
					.getValue().getRemainingQuantity();
			JAXBElement<Integer> remainingRepeats = prescriptionDisplay
					.getValue().getRemainingRepeats();

			String expirationDateStr = null;
			String remainingQuantityStr = null;
			String remainingRepeatsStr = null;

			if (null != expirationDate) {
				if (null != expirationDate.getValue()) {
					expirationDateStr = CommonUtils.getFormattedDate(
							expirationDate.getValue(), strLocale);
				}
			}
			if (null != remainingQuantity) {
				if (null != remainingQuantity.getValue()) {
					remainingQuantityStr = String.valueOf(remainingQuantity
							.getValue()/100);
				}

			}
			if (null != remainingRepeats) {
				if (null != remainingRepeats.getValue()) {
					remainingRepeatsStr = String.valueOf(remainingRepeats
							.getValue());
				}
			}
			prescBO.setExpirationDate(expirationDateStr);
			prescBO.setRemainigRefills(remainingRepeatsStr);
			prescBO.setRemainingQuantity(remainingQuantityStr);
		}

	}

	public List<Object> getPrescRequestParameterList(String reqPageNum,
			String reqChkdPresc, String reqDateFilter, String reqSortField,
			String reqFromDate, String reqToDate) {
		List<Object> retList = new ArrayList<Object>();
		Integer pageNum = !CommonUtils.isStringNullOrEmpty(reqPageNum) ? Integer
				.parseInt(reqPageNum) : new Integer(1);
		String strCheckedPresc = !CommonUtils.isStringNullOrEmpty(reqChkdPresc) ? reqChkdPresc
				: null;
		String dateFilter = !CommonUtils.isStringNullOrEmpty(reqDateFilter) ? reqDateFilter
				: ERefillConstants.LAST_730_DAYS;
		String sortField = !CommonUtils.isStringNullOrEmpty(reqSortField) ? reqSortField
				: ERefillConstants.LAST_FILLED_DATE;
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = !CommonUtils.isStringNullOrEmpty(reqFromDate) ? CommonUtils
					.getCustomFormatDate(reqFromDate,
							ERefillConstants.DATE_FORMAT_IP_FIELDS) : null;
			toDate = !CommonUtils.isStringNullOrEmpty(reqToDate) ? CommonUtils
					.getCustomFormatDate(reqToDate,
							ERefillConstants.DATE_FORMAT_IP_FIELDS) : null;
		} catch (ParseException parExe) {
			log.error(parExe.getMessage(), parExe);
			fromDate = null;
			toDate = null;
		}
		retList.add(pageNum);
		retList.add(strCheckedPresc);
		retList.add(dateFilter);
		retList.add(sortField);
		retList.add(fromDate);
		retList.add(toDate);
		return retList;
	}

	public com.lcl.erefill.core.vo.Patient getPatientData(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			PatientExtendedInfo patientExtendedInfo, String patientOID) {

		log.debug("executing getPatientData() start");
		Patient patient = null;
		com.lcl.erefill.core.vo.Patient entityPatient = null;
		log.info("entityPatient is not in cache >>>> getting from Telus ... START");
		try {
			Holder<UserToken> userTokenHolder = prepareProfileTokenHolder(userToken);
			Holder<Patient> objPatientHolder = new Holder<Patient>();
			Holder<String> objEmailHolder = new Holder<String>();
			log.debug("Holder created successfully");
			long startTime = System.currentTimeMillis();
			log.debug("performing profileSvc.getPatientData start");
			getProfileService().getPatientData(userTokenHolder,
					patientExtendedInfo, patientOID, objPatientHolder,
					objEmailHolder);
			log.debug("performing profileSvc.getPatientData end");
			log.info("getPatientData" + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			String strEmailAddress = objEmailHolder.value;
			log.debug("The field EmailAddress from GetPatientData method >> "
					+ strEmailAddress);
			if (null != objPatientHolder.value) {
				log.debug("Object Patient holder is not null");
				patient = objPatientHolder.value;
				entityPatient = new com.lcl.erefill.core.vo.Patient();
				entityPatient.setAddress(patient.getAddress());
				entityPatient.setCity(patient.getCity());
				entityPatient.setPhn(patient.getPhoneNumber());
				entityPatient.setDeliveryAddress(patient.getDeliveryAddress());
				entityPatient.setDeliveryCity(patient.getDeliveryCity());
				entityPatient.setDeliveryPhoneNumber(patient
						.getDeliveryPhoneNumber());
				entityPatient.setDeliveryPostalCode(patient
						.getDeliveryPostalCode());
				entityPatient.setEProvince(patient.getDeliveryProvince()
						.value());
				entityPatient.setPrimaryAddressPostalCode(patient
						.getPostalCode());
				entityPatient
						.setPrimaryEProvince(patient.getProvince().value());
				entityPatient.setPhoneNumber(patient.getPhoneNumber());
				entityPatient.setStoreID(patient.getDefaultPharmacy()
						.getValue().getContractNumber());
				entityPatient.setOid(patient.getOID());
				entityPatient.setFirstName(patient.getFirstName());
				entityPatient.setLastName(patient.getLastName());
				entityPatient.setUserName(patient.getUserName().getValue());
				entityPatient.setDefaultPharmacy(getDefaultPharmacy(patient
						.getDefaultPharmacy().getValue()));
				if (null != entityPatient) {
					log.info("storeId in set in entityPatient >>>{} "
							+ entityPatient.getStoreID());
				}
			}
			log.debug("enitiyPatient from Telus ws call:" + entityPatient);
		} catch (IProfileSvcGetPatientDataErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		log.info("entityPatient from Cache before return to View:"
				+ entityPatient);
		log.debug("executing getPatientData() end");
		return entityPatient;
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
		for (com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PharmacyOpeningHour telusPharmacyOpeningHour : arrayOfPharmacyOpeningHour
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
	
	public DrugHeaderView getDrugDetailsHeader(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String strPrescOID, String strLocale, String patientOID) {
		log.info(">>>>>> Drug Details header >>>> start ");
		DrugHeaderView retDrugHeader = null;
		List<PrescriptionsBO> cachedList = getPrescriptions(userToken,
				strLocale, patientOID);

		for (PrescriptionsBO cachePresc : cachedList) {
			if (null != cachePresc.getPrescOID()
					&& cachePresc.getPrescOID().equals(strPrescOID)) {
				retDrugHeader = new DrugHeaderView();
				retDrugHeader.setDin(cachePresc.getDIN());
				retDrugHeader.setName(cachePresc.getName());
				retDrugHeader.setGenericName(cachePresc.getGenericName());
				retDrugHeader.setStrength(cachePresc.getStrength());
				retDrugHeader.setRxNum(cachePresc.getRxNumber());
				retDrugHeader.setInstructions(cachePresc.getSigDecoded());
			}
		}
		return retDrugHeader;
	}

	/**
	 * getListRefillHistory
	 * 
	 * @param userToken
	 * @param prescOID
	 * @param pageNum
	 * @param strLocale
	 * @return refillHistoryResponse
	 */
	public RefillHistoryResponse getListRefillHistory(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String prescOID, Integer pageNum, String strLocale) {
		log.info(">>>>>> Refill History >>> getListRefillHistory >>> START");
		List<PrescriptionsBO> listRefillPresc = getPrescriptionHistory(
				userToken, prescOID, strLocale);
		RefillHistoryResponse refillHistoryResponse = new RefillHistoryResponse();
		List<PrescriptionsBO> retList = null;
		int numPages = 0;
		int pageSize = Integer.parseInt(ERefillConfigService.REF_HIST_PG_SIZE);
		if (null != listRefillPresc) {
			numPages = CommonUtils.getNumberOfPages(listRefillPresc.size(), pageSize);
			String strTempFormat = strLocale
					.equals(ERefillConstants.STR_FRENCH_LOCALE) ? ERefillConstants.DATE_FORMAT_REFILL_HIST_FR
					: ERefillConstants.DATE_FORMAT_REFILL_HIST;
			CommonUtils.sortEntities(
					listRefillPresc,
					PrescriptionsBO.getLastFilledComp(strTempFormat,
							CommonUtils.getLocaleFromString(strLocale)),
					ERefillConstants.ORDER_DESCENDING);
			
			retList = ServiceUtils.pagination(listRefillPresc, pageSize, pageNum);
			refillHistoryResponse.setLstPresc(retList);
			refillHistoryResponse.setNumOfPages(numPages);
			refillHistoryResponse.setTotalRecords(listRefillPresc.size());
		}
		
		log.info(">>>>>> Refill History >>> getListRefillHistory >>> END");
		return refillHistoryResponse;
	}

	public List<PrescriptionsBO> getPrescriptionHistory(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String prescOID, String strLocale) {
		log.debug("executing getPrescriptionHistory() start");
		List<PrescriptionsBO> retListVal = new ArrayList<PrescriptionsBO>();
		try {
			Holder<UserToken> userTokenHolder = prepareProfileTokenHolder(userToken);
			PrescriptionExtendedInfo prescExtInfo = new PrescriptionExtendedInfo();
			prescExtInfo.getExtendedInfo().add(
					ERefillConstants.PRESCRIPTION_EXTENDED_INFO_ALL);
			long startTime = System.currentTimeMillis();
			log.debug("executing profileSvc.getPrescriptionHistory start");
			Prescriptions telPrescWrap = getProfileService()
					.getPrescriptionHistory(userTokenHolder, prescOID,
							prescExtInfo, null);
			log.debug("executing profileSvc.getPrescriptionHistory end");
			log.info("getPrescriptionHistory" + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

			List<Prescription> prescriptionList = telPrescWrap
					.getPrescription();
			if (!CommonUtils.isNullOrEmpty(prescriptionList)) {

				for (Prescription prescription : prescriptionList) {
					PrescriptionsBO prescBO = new PrescriptionsBO();
					prescBO.setLocale(CommonUtils
							.getLocaleFromString(strLocale));
					if (null != prescription.getProduct()) {
						Product tempProd = prescription.getProduct();
						if (null != tempProd.getName()) {
							prescBO.setName(tempProd.getName());
						} else {
							prescBO.setName("");
						}
						if (null != tempProd.getGenericName()) {
							prescBO.setGenericName(tempProd.getGenericName());
						} else {
							prescBO.setGenericName("");
						}
						if (null != tempProd.getStrength()) {
							prescBO.setStrength(tempProd.getStrength());
						} else {
							prescBO.setStrength("");
						}
					}

					if (null != prescription.getRxNumber()) {
						prescBO.setRxNumber(prescription.getRxNumber());
					} else {
						prescBO.setRxNumber("");
					}

					if (null != prescription.getOriginalPrescription()
							&& null != prescription.getOriginalPrescription()
									.getValue()) {
						prescBO.setOriginalOID(prescription
								.getOriginalPrescription().getValue().getOID());
					}

					if (null != prescription.getSigDecoded()) {
						prescBO.setSigDecoded(prescription.getSigDecoded());
					} else {
						prescBO.setSigDecoded("");
					}
					prescBO.setQuantityFilled(prescription.getQuantityFilled() / 100);
					prescBO.setDaysSupply(prescription.getDaysSupply());
					if (null != prescription.getRxDate()) {
						if (strLocale
								.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
							prescBO.setHistLastFillDate(CommonUtils.getFormattedDate(
									prescription.getRxDate(),
									ERefillConstants.DATE_FORMAT_REFILL_HIST_FR,
									strLocale));
						} else {
							prescBO.setHistLastFillDate(CommonUtils.getFormattedDate(
									prescription.getRxDate(),
									ERefillConstants.DATE_FORMAT_REFILL_HIST,
									strLocale));
						}
					} else {
						if (strLocale
								.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
							prescBO.setHistLastFillDate(CommonUtils
									.getFormattedDate(
											20130401,
											ERefillConstants.DATE_FORMAT_REFILL_HIST_FR,
											strLocale));
						} else {
							prescBO.setHistLastFillDate(CommonUtils
									.getFormattedDate(
											20130401,
											ERefillConstants.DATE_FORMAT_REFILL_HIST,
											strLocale));
						}
					}
					retListVal.add(prescBO);
				}
			}

		} catch (IProfileSvcGetPrescriptionHistoryErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			userToken.setStatus(null);
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		log.debug("executing getPrescriptionHistory() end");
		return retListVal;
	}

	public List<PrescDetailsView> getRefillRequestList(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			List<String> compareList, String strLocale, String patientOID) {
		List<PrescDetailsView> retListVal = null;
		List<PrescriptionsBO> tempList = null;
		if (null != compareList && !compareList.isEmpty()) {

			tempList = getPrescriptions(userToken, strLocale, patientOID);
			retListVal = new ArrayList<PrescDetailsView>();
			PrescDetailsView retViewObj = null;
			CommonUtils.sortEntities(tempList, PrescriptionsBO.medNameComp,
					ERefillConstants.ORDER_ASCENDING);
			for (PrescriptionsBO prescBO : tempList) {
				if (compareList.contains(prescBO.getPrescOID())) {
					retViewObj = new PrescDetailsView();
					retViewObj.setOid(prescBO.getPrescOID());
					retViewObj.setDin(prescBO.getDIN());
					retViewObj.setName(prescBO.getName());
					retViewObj.setGenericName(prescBO.getGenericName());
					retViewObj.setRxNumber(prescBO.getRxNumber());
					retViewObj.setStrength(prescBO.getStrength());
					retViewObj.setQuantityFilled(new Integer(prescBO
							.getQuantityFilled()).toString());
					retViewObj.setOriginalOid(prescBO.getOriginalOID());
					retViewObj.setRxDate(prescBO.getRxDate());
					retViewObj.setDaysSupply(prescBO.getDaysSupply());
					retViewObj.setEstimatedFillDate(prescBO.getEstimatedFillDate());
					retListVal.add(retViewObj);
					
				}
			}
		}
		return retListVal;
	}
}
