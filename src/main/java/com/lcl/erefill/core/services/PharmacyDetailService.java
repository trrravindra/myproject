package com.lcl.erefill.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.integ.telus.ManagerWSImpl;
import com.lcl.erefill.core.services.integ.telus.ProfileWSImpl;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PharmaUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.Patient;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.PharmacyOperatingHours;
import com.lcl.erefill.core.vo.PharmacyVO;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;

@Component
public class PharmacyDetailService implements IPharmacyDetailService {

	private static final Logger log = LoggerFactory
			.getLogger(PharmacyDetailService.class);

	@Autowired
	PharmaUtils pharmaUtils;
	
	@Autowired
	ProfileWSImpl profileWSImpl;

	@Autowired
	ManagerWSImpl managerWSImpl;

	@Autowired
	SessionManager sessionManager;

	final ObjectMapper o = new ObjectMapper();

	/**
	 * getPharmaStores
	 * 
	 * @param userToken
	 * @param storeId
	 * @param session
	 * @return
	 */
	public PharmaDeptVO getPharmaStores(UserToken userToken, String storeId,
			String patientOID, ISession session) {

		PharmaDeptVO retPharmaDeptt = new PharmaDeptVO();

		try {

			PharmaDeptVO retPharmaDeptVO = sessionManager
					.getPharmacyDetails(session);

			if (retPharmaDeptVO != null) {
				return retPharmaDeptVO;
			}

			PharmacyVO pharmacyVO = getPharmacyDetails(userToken, storeId,
					patientOID, session);
			if (pharmacyVO == null) {
				return null;
			} else {
				retPharmaDeptt.setPharmaVO(pharmacyVO);
			}

			log.info(" Department id used is " + pharmacyVO.getDepttId());

			String jsonDepartments = pharmacyVO.getPharmaJson();

			if (null != jsonDepartments) {
				JsonNode jsonDeptObject = o.readTree(jsonDepartments);
				JsonNode department = jsonDeptObject
						.findPath(ERefillConstants.DEPARTMENT);
				JsonNode pharmacy = department
						.findPath(ERefillConstants.PHARMACY);
				retPharmaDeptt.setCollegeStreet(pharmacy.findPath(
						ERefillConstants.COLLEGESTREET).asText());
				retPharmaDeptt.setCollegeCity(pharmacy.findPath(
						ERefillConstants.COLLEGECITY).asText());
				retPharmaDeptt.setCollegeProvince(pharmacy.findPath(
						ERefillConstants.COLLEGEPROVINCE).asText());
				retPharmaDeptt.setCollegeUrl(pharmacy.findPath(
						ERefillConstants.COLLEGEURL).asText());
				retPharmaDeptt.setCollegePostalCode(pharmacy.findPath(
						ERefillConstants.COLLEGEPOSTALCODE).asText());
				retPharmaDeptt.setStoreFax(pharmacy.findPath(
						ERefillConstants.COLLEGEFAX).asText());
				retPharmaDeptt.setStorePhone(pharmacy.findPath(
						ERefillConstants.COLLEGEPHONE).asText());
				try {
					retPharmaDeptt.setCollegeLicenseLogo(pharmacy.findPath(
							ERefillConstants.COLLEGELOGO).asText());
				} catch (NullPointerException jsonExe) {
					log.error("No license logo available getPharmaStores()");
					retPharmaDeptt.setCollegeLicenseLogo("");
				}
				try {
					retPharmaDeptt.setCollegeLicense(pharmacy.findPath(
							ERefillConstants.COLLEGELICENSE).asText());
				} catch (NullPointerException jsonExe) {
					log.error("No college license available getPharmaStores()");
					retPharmaDeptt.setCollegeLicense("");
				}
				try {
					retPharmaDeptt.setStoreOpq(pharmacy.findPath(
							ERefillConstants.ACCREDITION_NO).asText());
				} catch (NullPointerException jsonExe) {
					log.error("No accredition number available getPharmaStores()");
					retPharmaDeptt.setStoreOpq("");
				}
				retPharmaDeptt.setStoreAddress("Store Address");
				try {
					if (!CommonUtils.areEquals(
							department.findPath("managerPhoto").asText(),
							ERefillConstants.STR_NULL)) {
						retPharmaDeptt.setManagerPhoto(department.findPath(
								"managerPhoto").asText());
					} else {
						retPharmaDeptt.setManagerPhoto("");
					}
				} catch (NullPointerException e) {
					log.error("No manager photo available getPharmaStores()");
					retPharmaDeptt.setManagerPhoto("");
				}
				try{
					retPharmaDeptt.setLegalName(pharmacy.findPath(
							ERefillConstants.LEGALNAME).asText());
				}catch(NullPointerException e){
					log.error("No legal name available getPharmaStores()");
					retPharmaDeptt.setLegalName("");
				}
				try{
					retPharmaDeptt.setBusinessOwner(pharmacy.findPath(
							ERefillConstants.BUSINESSOWNER).asText());
				}catch(NullPointerException e){
					log.error("No business owner available getPharmaStores()");
					retPharmaDeptt.setBusinessOwner("");
				}
				try{
					retPharmaDeptt.setLegalNameFr(pharmacy.findPath(
							ERefillConstants.LEGALFRENCHNAME).asText());
				}catch(NullPointerException e){
					log.error("No french legal name available getPharmaStores()");
					retPharmaDeptt.setLegalNameFr("");
				}
			}

		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		return retPharmaDeptt;
	}

	/**
	 * getPharmacyDetails
	 * 
	 * @param userToken
	 * @param storeId
	 * @param patientOID
	 * @param session
	 * @return pharmaDetails
	 */
	public PharmacyVO getPharmacyDetails(UserToken userToken, String storeId,
			String patientOID, ISession session) {
		PharmacyVO pharmaDetails = null;
		Map<String, Object> pharmaMap = null;

		try {
			if (storeId == null || storeId.length() <= 0) {
				storeId = getStoreId(userToken, patientOID, session);
			}

			pharmaMap = getStoreInfo(storeId);
			pharmaDetails = (PharmacyVO) pharmaMap.get("pharmaDetails");		
			
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error(
					"Exception in PharmacyDetailsService::getPharmacyDetails()",
					e);
			ErrorHandler.handleException(e);
			return null;
		}
		log.debug("executing getPharmacyDetails() end");
		return pharmaDetails;
	}

	/**
	 * @param userToken
	 * @param patientOID
	 * @param session
	 * @return storeId
	 */
	private String getStoreId(UserToken userToken, String patientOID,
			ISession session) {
		log.debug("performing getService() call");
		String storeId = null;
		try {
			PatientExtendedInfo extEntInfo = new PatientExtendedInfo();
			extEntInfo.getExtendedInfo().add("All");
			log.info("performing profileWSImpl.getPatientData start");
			Patient entPatient = profileWSImpl.getPatientData(userToken,
					extEntInfo, patientOID);
			log.info("performing profileWSImpl.getPatientData end");
			if (null != entPatient) {
				sessionManager.setPatient(entPatient, session);
				storeId = entPatient.getStoreID();
				log.debug("Store ID in getPharmacyDetails else block "
						+ storeId);
			} else {
				log.debug("Store ID in getPharmacyDetails else of else block of "
						+ storeId);
			}
			log.debug("setting storeId has been completed");
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		} 
		return storeId;
	}

	/**
	 * 
	 */
	public HashMap<String, Object> getStoreInfo(String storeId) {
		log.info("executing getStoreInfo() start");
		
		PharmacyVO pharmaDetails = null;
		HashMap<String, Object> pharmaMap = null;		
		try {
			String strPharmaJson = pharmaUtils.getPharmacyStoreDetails(storeId, PropertyUtil.getIsAtgPharmacyStoreCacheable());
			log.info("Store results from ATG - [Store ID : " + storeId + " - "
					+ strPharmaJson + "] ");
			pharmaMap = new HashMap<String, Object>();
			pharmaDetails = processPharmacyDetails(strPharmaJson, storeId);
			pharmaMap.put("pharmaJson", pharmaDetails.getPharmaJson());
			pharmaMap.put("storeJson", strPharmaJson);
			pharmaMap.put("pharmaDetails", pharmaDetails);
			pharmaMap.put("deliveryJson",pharmaDetails.getDeliveryJson());
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		log.debug("exiting getStoreInfo()");
		return pharmaMap;
	}

	private PharmacyVO processPharmacyDetails(String jsonString, String storeId) {
		log.debug("executing processPharmacyDetails() start");
		String departmentId = null;
		PharmacyVO retPharmaVO = null;

		if (null != jsonString && null != storeId) {
			retPharmaVO = new PharmacyVO();
			retPharmaVO.setStoreId(storeId);
			JsonNode jsonObject;
			try {
				jsonObject = o.readTree(jsonString);

				JsonNode store = jsonObject.findPath(ERefillConstants.STORE);
				JsonNode address = jsonObject.findPath(ERefillConstants.ADDRESS);
				ArrayNode departments = (ArrayNode) store
						.get(ERefillConstants.DEPARTMENTS);

				for (int i = 0; i < departments.size(); i++) {
					JsonNode dept = departments.get(i);
					if ((dept.findPath(ERefillConstants.DEPARTMENTNAME)
							.asText()).toLowerCase().equals(
							ERefillConstants.PHARMACYNAME)) {
						departmentId = dept.findPath(
								ERefillConstants.DEPARTMENTID).asText();
						retPharmaVO.setDepttId(departmentId);

					} else if ((dept.findPath(ERefillConstants.DEPARTMENTNAME)
							.asText()).toLowerCase().equals(
							ERefillConstants.FREEDELIVERYPHARMACYNAME)) {
						departmentId = dept.findPath(
								ERefillConstants.DEPARTMENTID).asText();
						retPharmaVO.setFreeDelDepttId(departmentId);

					}
				}
				
				retPharmaVO.setName(store.findPath(ERefillConstants.STORENAME)
						.asText());
				retPharmaVO.setStoreNameFr(store.findPath(
						ERefillConstants.STORENAMEFR).asText());
				retPharmaVO.setCountryAddress(address.findPath(
						ERefillConstants.COUNTRY).asText());
				retPharmaVO.setCityAddress(address.findPath(
						ERefillConstants.CITY).asText());
				retPharmaVO.setPostalCode(address.findPath(
						ERefillConstants.POSTALCODE).asText());
				retPharmaVO.setProvince(address.findPath(
						ERefillConstants.PROVINCE).asText());
				retPharmaVO.setAddressLine1(address.findPath(
						ERefillConstants.ADDRESSLINE1).asText());
				retPharmaVO.setAddressLine2(address.findPath(
						ERefillConstants.CITY).asText()
						+ " "
						+ address.findPath(ERefillConstants.PROVINCE).asText());
				retPharmaVO.setPharmacyTitle(store.findPath(
						ERefillConstants.STORENAME).asText());
				retPharmaVO.setPharmacyLogo(store.findPath(
						ERefillConstants.LOGOURL).asText()						
						);
				retPharmaVO.setPharmacyLogoFR(store.findPath(
						ERefillConstants.LOGOURLFR).asText()						
						);
				
				List<PharmacyOperatingHours> operatingHoursList = new ArrayList<PharmacyOperatingHours>();
				String jsonDepartments = "";
				
				if(retPharmaVO.getDepttId()!=null){
					log.debug("Department ID passed to getPharmacyDepDetails is "+retPharmaVO.getDepttId());
					jsonDepartments = getPharmacyDepartmentDetails(storeId, retPharmaVO.getDepttId());
				}else{
					log.debug("Department ID is observed to be "+retPharmaVO.getDepttId());
					jsonDepartments = getPharmacyDepartmentDetails(storeId, departmentId);
				}				

				ArrayNode operatingHoursArr = null;
				retPharmaVO.setPharmaJson(jsonDepartments);
				if (null != jsonDepartments) {
					JsonNode jsonDeptObject = o.readTree(jsonDepartments);
					JsonNode department = jsonDeptObject
							.findPath(ERefillConstants.DEPARTMENT);
					try {
						operatingHoursArr = (ArrayNode) department
								.findPath(ERefillConstants.OPERATINGHOURS);
					} catch (Exception e) {
						log.error("operatingHoursArr1: " + e.getMessage());
					}

					try {
						retPharmaVO.setPhone(department.findPath(
								ERefillConstants.PHONENUMBER).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setPhone("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
					try {
						retPharmaVO.setFax(department.findPath(
								ERefillConstants.FAXNUMBER).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setFax("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
					try {
						retPharmaVO.setManagerName(department.findPath(
								ERefillConstants.MANAGER_NAME).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setManagerName("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
					try {
						retPharmaVO.setDescription(department.findPath(
								ERefillConstants.DESCRIPTION).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setDescription("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
					try {
						retPharmaVO.setDescriptionFR(department.findPath(
								ERefillConstants.DESCRIPTIONFR).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setDescriptionFR("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
					try {
						retPharmaVO.setManagerEmail(department
								.findPath(ERefillConstants.PHARMACY)
								.findPath(ERefillConstants.EMAIL).asText());
					} catch (NullPointerException e) {
						retPharmaVO.setManagerEmail("");
						log.error("process Pharmacy Details" + e.getMessage());
					}
				}
				String deliveryDepartments = getPharmacyDepartmentDetails(storeId, departmentId);
				retPharmaVO.setDeliveryJson(deliveryDepartments);

				if (null == operatingHoursArr
						|| (null != operatingHoursArr && operatingHoursArr
								.size() == 0)) {
					try {
						operatingHoursArr = (ArrayNode) store
								.findPath(ERefillConstants.OPERATINGHOURS);
					} catch (Exception e) {
						log.error("operatingHoursArr2: " + e.getMessage());
					}
				}

				if (null != operatingHoursArr && operatingHoursArr.size() != 0) {
					for (int i = 0; i < operatingHoursArr.size(); i++) {
						JsonNode obj = operatingHoursArr.get(i);
						PharmacyOperatingHours operatingHours = new PharmacyOperatingHours();
						operatingHours.setDate(obj.findPath(
								ERefillConstants.DATE).asText());
						String hours = obj.findPath(ERefillConstants.HOURS)
								.asText();

						if (null != hours) {
							if (!hours.equals("Closed")
									&& hours.split("-").length > 1) {
								String[] strArr = hours.split("-");
								StringBuffer strBuffer1 = new StringBuffer();
								strBuffer1.append(strArr[0].trim());
								strBuffer1.append(" - ");
								strBuffer1.append(strArr[1].trim());
								operatingHours.setHours(strBuffer1.toString());
							} else {
								operatingHours.setHours(hours);
							}
						}
						operatingHours.setDay(obj
								.findPath(ERefillConstants.DAY).asText());
						operatingHours.setDayFr(obj.findPath(
								ERefillConstants.DAYFR).asText());
						operatingHours.setHoursFr(CommonUtils
								.formatStringInUTF8(obj.findPath(
										ERefillConstants.HOURSFR).asText()));
						if (null != obj.findPath(ERefillConstants.HOLIDAY)) {
							operatingHours.setHoliday((Boolean) obj.findPath(
									ERefillConstants.HOLIDAY).asBoolean());
						}
						operatingHoursList.add(operatingHours);
					}
				}
				retPharmaVO.setOperatingHoursList(operatingHoursList);
				List<PharmacyOperatingHours> delOperatingHoursList = new ArrayList<PharmacyOperatingHours>();
				String jsonDeliveryDepartments = getPharmacyDepartmentDetails(
						storeId, departmentId);
				
				ArrayNode delOperatingHoursArr = null;
				if (null != jsonDeliveryDepartments) {
					JsonNode jsonDeptObject = o
							.readTree(jsonDeliveryDepartments);
					JsonNode delDepartment = jsonDeptObject
							.findPath(ERefillConstants.DEPARTMENT);
					try {
						delOperatingHoursArr = (ArrayNode) delDepartment
								.findPath(ERefillConstants.OPERATINGHOURS);
					} catch (Exception e) {
						log.error("delOperatingHoursArr1: " + e.getMessage());
					}
				}
				if (null == delOperatingHoursArr
						|| (null != delOperatingHoursArr && delOperatingHoursArr
								.size() == 0)) {
					try {
						delOperatingHoursArr = (ArrayNode) store
								.findPath(ERefillConstants.OPERATINGHOURS);
					} catch (Exception e) {
						log.error("delOperatingHoursArr2: " + e.getMessage());
					}
				}
				if (null != delOperatingHoursArr
						&& delOperatingHoursArr.size() != 0) {
					for (int i = 0; i < delOperatingHoursArr.size(); i++) {
						JsonNode obj = delOperatingHoursArr.get(i);
						PharmacyOperatingHours delOperatingHours = new PharmacyOperatingHours();
						delOperatingHours.setDate(obj.findPath(
								ERefillConstants.DATE).asText());
						String hours = obj.findPath(ERefillConstants.HOURS)
								.asText();

						if (null != hours) {
							if (!hours.equals("Closed")
									&& hours.split("-").length > 1) {
								String[] strArr = hours.split("-");
								StringBuffer strBuffer1 = new StringBuffer();
								strBuffer1.append(strArr[0].trim());
								strBuffer1.append(" - ");
								strBuffer1.append(strArr[1].trim());
								delOperatingHours.setHours(strBuffer1
										.toString());
							} else {
								delOperatingHours.setHours(hours);
							}
						}
						delOperatingHours.setDay(obj.findPath(
								ERefillConstants.DAY).asText());
						delOperatingHours.setDayFr(obj.findPath(
								ERefillConstants.DAYFR).asText());
						delOperatingHours.setHoursFr(CommonUtils
								.formatStringInUTF8(obj.findPath(
										ERefillConstants.HOURSFR).asText()));
						if (null != obj.findPath(ERefillConstants.HOLIDAY)) {
							delOperatingHours.setHoliday((Boolean) obj
									.findPath(ERefillConstants.HOLIDAY)
									.asBoolean());
						}
						delOperatingHoursList.add(delOperatingHours);
					}
				}
				retPharmaVO
						.setDeliveryOperatingHoursList(delOperatingHoursList);

			} catch (ERefillBusinessException e) {
				log.error("error "+e);
				throw e;
			} catch (ERefillApplicationException e) {
				log.error("error "+e);
				throw e;
			} catch (Exception e) {
				log.error("error "+e);
				ErrorHandler.handleException(e);
			}
		}
		log.debug("executing processPharmacyDetails() end");
		return retPharmaVO;
	}

	
	private String getPharmacyDepartmentDetails(String storeId,
			String departmentId) {
		log.debug("executing getPharmacyDepartmentDetails() start");
		String jsonDepartments = null;
		try {
			log.debug("Store ID : "+storeId+"; Department ID : "+departmentId+">><<>><<"+PropertyUtil.getIsAtgPharmacyDepartmentsCacheable());
			jsonDepartments = pharmaUtils.getPharmacyDepartmentDetails(storeId, departmentId, PropertyUtil.getIsAtgPharmacyDepartmentsCacheable());
			log.debug("Store department information [Store ID :" + storeId
					+ ", Department ID : " + departmentId + "] from ATG ["
					+ jsonDepartments + "]");
			log.debug("processPharmacyDetails Department response >> "
					+ jsonDepartments);
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		log.debug("executing getPharmacyDepartmentDetails() end");
		return jsonDepartments;
	}

	public String getDelOperatingHours(String storeId) {

		String operatingHours = null;
		try {
			log.debug("getOperatingHours():PharmacyDetailsService");
			if (storeId == null || storeId.length() <= 0) {
				throw new Exception();
			}
			Map<String, Object> pharmaMap = getStoreInfo(storeId);
			String deliveryJson = (String) pharmaMap.get("deliveryJson");
			if (null != deliveryJson) {
				operatingHours = getDeliveryHours(deliveryJson);
			}
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		return operatingHours;
	}

	private String getDeliveryHours(String deliveryJson) throws JSONException {

		log.debug("getPharmacyHours():PharmacyDetailsService");
		String operatingHours = null;

		try {

			JSONObject jsonDeptObject = new JSONObject(deliveryJson);
			JSONObject department = jsonDeptObject
					.getJSONObject(ERefillConstants.DEPARTMENT);
			JSONArray arr = department
					.getJSONArray(ERefillConstants.OPERATINGHOURS);

			StringBuffer hrsBuffer = new StringBuffer();
			hrsBuffer.append("{\"operatingHours\":");
			hrsBuffer.append(arr.toString());
			hrsBuffer.append("}");
			operatingHours = hrsBuffer.toString();
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		return operatingHours;

	}

	/**
	 * getOperatingHours
	 * 
	 * @param userToken
	 * @param storeId
	 * @return
	 */
	public String getOperatingHours(UserToken userToken, String storeId, ISession session) {

		String operatingHours = null;
		try {
			log.debug("getOperatingHours():PharmacyDetailsService");
			if (storeId == null || storeId.length() <= 0) {
				throw new Exception();
			}
			Map<String, Object> pharmaMap = getStoreInfo(storeId);
			String strStoreJson = (String) pharmaMap.get("storeJson");
			String strPharmaJson = (String) pharmaMap.get("pharmaJson");
			String deliveryJson = (String) pharmaMap.get("deliveryJson");
			String patientOID=sessionManager.getSelectedPatientOID(session);
			
			if (null != strPharmaJson && null != strStoreJson) {
				JSONObject jsonObject = new JSONObject(strStoreJson);
				JSONObject store = jsonObject.getJSONObject(ERefillConstants.STORE);
				Map<String, Object> pharmaParams = managerWSImpl
						.getPharmacyAllParameter(userToken, storeId, patientOID);
				String pickUpBufferTime = (String) pharmaParams
						.get("pickUpBufferTime");
				String pickUpThreshold = (String) pharmaParams
						.get("pickUpThreshold");
				String homeDropBufferTime = (String) pharmaParams
						.get("homeDropBufferTime");
				String homeDropThreshold = (String) pharmaParams
						.get("homeDropThreshold");

				operatingHours = getPharmacyHours(store, strPharmaJson,
						deliveryJson, pickUpBufferTime, pickUpThreshold,
						homeDropBufferTime, homeDropThreshold, userToken);
			}
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		return operatingHours;
	}

	/**
	 * getPharmacyHours
	 * 
	 * @param storeJson
	 * @param strPharmaJson
	 * @param deliveryJson
	 * @param pickUpBufferTime
	 * @param pickUpThreshold
	 * @param homeDropBufferTime
	 * @param homeDropThreshold
	 * @param token
	 * @return
	 */
	private String getPharmacyHours(JSONObject storeJson, String strPharmaJson,
			String deliveryJson, String pickUpBufferTime,
			String pickUpThreshold, String homeDropBufferTime,
			String homeDropThreshold, UserToken token) {

		String operatingHours = null;

		try {

			log.debug("getPharmacyHours():PharmacyDetailsService");

			JSONObject jsonDeptObject = new JSONObject(strPharmaJson);
			JSONObject department = jsonDeptObject
					.getJSONObject(ERefillConstants.DEPARTMENT);
			JSONArray arr = department
					.getJSONArray(ERefillConstants.OPERATINGHOURS);
			if (null == arr || (null != arr && arr.length() == 0)) {
				arr = storeJson.getJSONArray(ERefillConstants.OPERATINGHOURS);
			}
			
			JSONObject jsonDelDeptObject = new JSONObject(deliveryJson);
			
			JSONObject delDepartment = jsonDelDeptObject
					.getJSONObject(ERefillConstants.DEPARTMENT);
			JSONArray delArr = delDepartment
					.getJSONArray(ERefillConstants.OPERATINGHOURS);

			StringBuffer hrsBuffer = new StringBuffer();
		/*	hrsBuffer.append("{\"userToken\":");
			hrsBuffer.append("\""
					+ token.getToken()
					+ "\",");
			hrsBuffer.append("\"status\":");
			hrsBuffer.append("\"" + token.getStatus() + "\",");*/
			hrsBuffer.append("{\"pickUpBufferTime\":");
			hrsBuffer.append("\"" + pickUpBufferTime + "\",");
			hrsBuffer.append("\"pickUpThreshold\":");
			hrsBuffer.append("\"" + pickUpThreshold + "\",");
			hrsBuffer.append("\"homeDropBufferTime\":");
			hrsBuffer.append("\"" + homeDropBufferTime + "\",");
			hrsBuffer.append("\"homeDropThreshold\":");
			hrsBuffer.append("\"" + homeDropThreshold + "\",");
			hrsBuffer.append("\"pickupoperatingHours\":");
			hrsBuffer.append(arr.toString() + ",");
			hrsBuffer.append("\"deliveruoperatingHours\":");
			hrsBuffer.append(delArr.toString());
			hrsBuffer.append("}");
			operatingHours = hrsBuffer.toString();
		} catch (ERefillBusinessException e) {
			log.error("error "+e);
			throw e;
		} catch (ERefillApplicationException e) {
			log.error("error "+e);
			throw e;
		} catch (Exception e) {
			log.error("error "+e);
			ErrorHandler.handleException(e);
		}
		return operatingHours;
	}
}
