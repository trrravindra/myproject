package com.lcl.erefill.core.services.integ.telus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.AccountCreatorVO;
import com.lcl.erefill.core.common.entity.PrescriptionsVO;
import com.lcl.erefill.core.common.entity.RefillPrescriptionVO;
import com.lcl.erefill.core.common.telus.response.OrderHistoryResponse;
import com.lcl.erefill.core.common.telus.response.RequestPrescriptionAddResponse;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.generated.telus.request.prescription.IRequestRxSvcAddErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.request.prescription.IRequestRxSvcListErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EMedReleaseMode;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EProvince;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.ERequestState;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.ERxPrescriptionState;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestDelivery;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestStateWrapper;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxListRequest;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxListRequests;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxNewRequest;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxPrescription;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxPrescriptions;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxRenewPrescription;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxRenewPrescriptions;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken;

@Component
public class RequestWSImpl extends BaseService {
	
	@Autowired
	private PropertyUtil propertyUtil;

	private static final Logger log = LoggerFactory.getLogger(RequestWSImpl.class);

	public RequestPrescriptionAddResponse add(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, com.lcl.erefill.core.vo.RxNewRequest rxNewRequest) {
		RequestPrescriptionAddResponse reqAddResponse = new RequestPrescriptionAddResponse();
		try {
			Holder<UserToken> userTokenHolder = prepareRequestPrescriptionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			RxNewRequest rxReq = getRxNewRequest(rxNewRequest);
			getRequestService().add(userTokenHolder, patientOID, rxReq);
			log.info("add|" + CommonUtils.executionTime(startTime));
			reqAddResponse.setStatus(userTokenHolder.value.getStatus().get(0));
			reqAddResponse.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IRequestRxSvcAddErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			try {
				reqAddResponse.setStatus(e.getFaultInfo().getType().get(0));
				reqAddResponse.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));

				userToken.setStatus(e.getFaultInfo().getType().get(0));
				userToken.setToken(CommonUtils.byteArrayAsString(e
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
			} catch (Exception exception) {
				reqAddResponse.setStatus("error");

			}
			return reqAddResponse;
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			reqAddResponse.setStatus("error");
			return reqAddResponse;
		} catch (Error e) {
			log.error(e.getMessage(), e);
			reqAddResponse.setStatus("error");
			return reqAddResponse;
		}

		return reqAddResponse;

	}

	/**
	 * @param rxNewRequest
	 * @return
	 */
	private RxNewRequest getRxNewRequest(
			com.lcl.erefill.core.vo.RxNewRequest rxNewRequest) {
		RxNewRequest rxReq = new RxNewRequest();
		if (rxNewRequest != null) {
			rxReq.setComments(rxNewRequest.getComments());
			rxReq.setEMail(rxNewRequest.getEmail());
			rxReq.setLastState(ERequestState.fromValue(rxNewRequest
					.getLastState()));
			rxReq.setLastStateDate(CommonUtils.getDateTime(new Date()));
			rxReq.setMedReleaseMode(EMedReleaseMode.fromValue(rxNewRequest
					.getMedReleaseMode()));
			if ("delivery".equalsIgnoreCase(rxNewRequest.getMedReleaseMode())) {
				rxReq.setReleaseDate(CommonUtils.getDateTime(rxNewRequest
						.getDelReleaseDate(), rxNewRequest.getDelReleaseTime()));
				rxReq.setDelivery(getRequestDelivery(rxNewRequest.getDelivery()));
			} else {				
				rxReq.setReleaseDate(CommonUtils.getDateTime(
						rxNewRequest.getPickReleaseDate(),
						rxNewRequest.getPickReleaseTime()));

			}
			JAXBElement<String> jaxbElementPhone = new JAXBElement<String>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"Phone"), String.class, rxNewRequest.getAlternatePhone());
			rxReq.setPhone(jaxbElementPhone);
			
			JAXBElement<String> jaxbElementMobilePhoneNumber = new JAXBElement<String>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"MobilePhoneNumber"), String.class, rxNewRequest.getPhone());
			
			rxReq.setMobilePhoneNumber(jaxbElementMobilePhoneNumber);
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

	public List<String> getDrugHeaderFrmOrdHist(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, String drugDIN) {
		List<String> retListVal = new ArrayList<String>();
		RequestStateWrapper reqState = new RequestStateWrapper();
		reqState.setState(ERequestState.fromValue("All"));
		XMLGregorianCalendar filterDate = CommonUtils.getDateTime("2008-05-21");
		boolean flgStopSearch = false;
		List<String> tempList = new ArrayList<String>();
		RxListRequests rxListRqsts = list(userToken, reqState, filterDate,
				patientOID);
		if (null != rxListRqsts) {
			List<RxListRequest> lstReq = rxListRqsts.getRxListRequest();
			if (!CommonUtils.isNullOrEmpty(lstReq)) {
				for (RxListRequest rxReq : lstReq) {
					if (null != rxReq.getPrescriptions()
							&& !CommonUtils.isNullOrEmpty(rxReq
									.getPrescriptions().getRxPrescription()))
						for (RxPrescription presc : rxReq.getPrescriptions()
								.getRxPrescription()) {
							if (presc.getProductDin().equals(drugDIN)) {
								tempList.add(presc.getProductName());
								tempList.add(presc.getProductStrength()
										.getValue());
								flgStopSearch = true;
								break;
							}
						}
					if (flgStopSearch) {
						break;
					}
				}
			}
		}
		retListVal.addAll(tempList);

		return retListVal;
	}

	private RxListRequests list(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			RequestStateWrapper reqState, XMLGregorianCalendar filterDate,
			String patientOID) {
		RxListRequests rxListRqsts = null;
		try {
			Holder<UserToken> userTokenHolder = prepareRequestPrescriptionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			rxListRqsts = getRequestService().list(userTokenHolder, reqState,
					filterDate, patientOID, null);
			log.info("list|" + CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			return rxListRqsts;
		} catch (IRequestRxSvcListErrorFaultFaultMessage e) {
			log.error(e.getMessage()); 
			ErrorHandler.handleException(e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return rxListRqsts;
	}

	/****
	 * 
	 * @param request
	 * @param response
	 * @param dateFilter
	 * @param requestStateWrapper
	 * @return
	 * @throws IRequestRxSvcListErrorFaultFaultMessage
	 * @throws ParseException
	 */

	public OrderHistoryResponse getPatientOnlineOrderHistory(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, String dateFilter, String requestStateWrapper,
			int pageNum, String strLocale) {

		Map<String, List<RefillPrescriptionVO>> model = new LinkedHashMap<String, List<RefillPrescriptionVO>>();
		Map<String, List<RefillPrescriptionVO>> paginationModel = new LinkedHashMap<String, List<RefillPrescriptionVO>>();
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		
		XMLGregorianCalendar filterDate = null;
		filterDate = CommonUtils.getDateTime("2008-05-21");

		try{
			if (null != dateFilter) {
				Date date = null;
				if (dateFilter.equals(ERefillConstants.LAST_30_DAYS)) {
					date = CommonUtils.getFromAndToDate(dateFilter)[0];
				} else if (dateFilter.equals(ERefillConstants.LAST_90_DAYS)) {
					date = CommonUtils.getFromAndToDate(dateFilter)[0];
				} else if (dateFilter.equals(ERefillConstants.LAST_180_DAYS)) {
					date = CommonUtils.getFromAndToDate(dateFilter)[0];
				} else {
					date = CommonUtils.getFromAndToDate(ERefillConstants.LAST_730_DAYS)[0];
				}
	
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				StringBuilder dateAsString = new StringBuilder(format.format(date));
				filterDate = CommonUtils.getDateTime(dateAsString.toString());
			}
	
			RequestStateWrapper reqState = new RequestStateWrapper();
			reqState.setState(ERequestState.fromValue("All"));
			RxListRequests rxListRqsts = list(userToken, reqState, filterDate, patientOID);
	
			if (null != rxListRqsts) {
				List<RxListRequest> lstReq = rxListRqsts.getRxListRequest();
				if (null != lstReq) {
					for (RxListRequest rxReq : lstReq) {
						RefillPrescriptionVO prescVO = new RefillPrescriptionVO();
						String lastSateDate = CommonUtils.getLastStateDate(rxReq.getLastStateDate(), strLocale);
						List<RefillPrescriptionVO> lstRefillVo;
						if (model.containsKey(lastSateDate)) {
							lstRefillVo = model.get(lastSateDate);
							for (RxPrescription presc : rxReq.getPrescriptions().getRxPrescription()) {
								if (requestStateWrapper.equalsIgnoreCase("All")|| requestStateWrapper.equalsIgnoreCase(presc.getLastState().value())) {
									RxPrescription renewPrescription = presc.getRxNewPrescription();
									//if (prescVO.getPrescriptionsVO() == null)
										prescVO = new RefillPrescriptionVO();
										prescVO.setPrescriptionsVO(new PrescriptionsVO());
										prescVO.setAccountCreatorVO(new AccountCreatorVO());
										prescVO.getPrescriptionsVO().setMedicineName(presc.getProductName());
										prescVO.getPrescriptionsVO().setProductForm(presc.getProductForm().getValue());
										prescVO.getPrescriptionsVO().setProductDIN(presc.getProductDin());
										prescVO.getPrescriptionsVO().setProductStrength(presc.getProductStrength().getValue());
										prescVO.getPrescriptionsVO().setQuantityFilled(presc.getQuantityFilled() / 100);
										prescVO.getPrescriptionsVO().setLastState(presc.getLastState().value());
									
										if (null != renewPrescription && null != renewPrescription.getComments()) {
											prescVO.getPrescriptionsVO().setPharmacistComments(renewPrescription.getComments());
									}
									
										prescVO.getAccountCreatorVO().setAccountCreatorFirstName(rxReq.getAcccountCreator().getFirstName());
										prescVO.getAccountCreatorVO().setAccountCreatorLastName(rxReq.getAcccountCreator().getLastName());
										prescVO.getPrescriptionsVO().setRxNumber(presc.getRxNumber());
										lstRefillVo.add(prescVO);
								}
							}
	
							if (null != lstRefillVo && !lstRefillVo.isEmpty()) {
								model.remove(lastSateDate);
								model.put(lastSateDate, lstRefillVo);
							}
						} else {
							lstRefillVo = new ArrayList<RefillPrescriptionVO>();
							for (RxPrescription presc : rxReq.getPrescriptions().getRxPrescription()) {
								if (requestStateWrapper.equalsIgnoreCase("All") || requestStateWrapper.equalsIgnoreCase(presc.getLastState().value())) {
									RxPrescription renewPrescription = presc.getRxNewPrescription();
									//if (prescVO.getPrescriptionsVO() == null)
									prescVO = new RefillPrescriptionVO();
									prescVO.setPrescriptionsVO(new PrescriptionsVO());
									prescVO.setAccountCreatorVO(new AccountCreatorVO());
									prescVO.getPrescriptionsVO().setMedicineName(presc.getProductName());
									prescVO.getPrescriptionsVO().setProductForm(presc.getProductForm().getValue());
									prescVO.getPrescriptionsVO().setProductDIN(presc.getProductDin());
									prescVO.getPrescriptionsVO().setProductStrength(presc.getProductStrength().getValue());
									prescVO.getPrescriptionsVO().setQuantityFilled(presc.getQuantityFilled() / 100);
									prescVO.getPrescriptionsVO().setLastState(presc.getLastState().value());
									if (null != renewPrescription && null != renewPrescription.getComments()) {
										prescVO.getPrescriptionsVO().setPharmacistComments(renewPrescription.getComments());
									}
									prescVO.getAccountCreatorVO().setAccountCreatorFirstName(rxReq.getAcccountCreator().getFirstName());
									prescVO.getAccountCreatorVO().setAccountCreatorLastName(rxReq.getAcccountCreator().getLastName());
									prescVO.getPrescriptionsVO().setRxNumber(presc.getRxNumber());
									lstRefillVo.add(prescVO);
																		
								}
							}
						}
						/*if (prescVO.getAccountCreatorVO() == null)
							prescVO.setAccountCreatorVO(new AccountCreatorVO());
						
						for (RxPrescription presc : rxReq.getPrescriptions().getRxPrescription()) {
							if (requestStateWrapper.equals("All") || requestStateWrapper.equals(presc.getLastState().value())) {
								prescVO.getAccountCreatorVO().setAccountCreatorFirstName(rxReq.getAcccountCreator().getFirstName());
								prescVO.getAccountCreatorVO().setAccountCreatorLastName(rxReq.getAcccountCreator().getLastName());
								lstRefillVo.add(prescVO);
							}
						}*/
	
						if (null != lstRefillVo && !lstRefillVo.isEmpty()) {
							model.put(lastSateDate, lstRefillVo);
						}
					}
				}
			}
	
			try {
				model = CommonUtils.sortDescOrderHistoryMap(model, strLocale);
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
				throw new ERefillApplicationException(e);
			}
	
			int numRecords = model.size();
	
			String pageSize = ERefillConfigService.PAGE_LENGTH_ORDERHISTORY;
			int numOfPages = CommonUtils.getNumberOfPages(numRecords, Integer.parseInt(pageSize));
			int firstRecord = 0;
			if (numRecords != 0) {
				firstRecord = ((pageNum - 1) * Integer.parseInt(pageSize)) + 1;
			}
			
			orderHistoryResponse.setNumOfPages(numOfPages);
			orderHistoryResponse.setTotalRecords(numRecords);
			orderHistoryResponse.setFirstRecord(firstRecord);
			
			if (null != model) {
				Set<String> keySet = model.keySet();
				List<String> paginationList = new ArrayList<String>(keySet);
				paginationList = getPagination(paginationList, Integer.parseInt(pageSize), pageNum);
	
				if (null != paginationList) {
					for (String str : paginationList) {
						paginationModel.put(str, model.get(str));
					}
				}
			}
		} catch (ERefillApplicationException e){
			log.error(e.getMessage(), e);
			throw new ERefillApplicationException(e);
		} catch (Exception e){
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		}
		orderHistoryResponse.setMpRefill(paginationModel);
		return orderHistoryResponse;
	}

	public static List<String> getPagination(List<String> refillLst,int pageSize,int pageNum){
		List<String> retChildList = null;
		if(null != refillLst) {
			int numOfPages = CommonUtils.getNumberOfPages(refillLst.size(), pageSize);
			if (pageNum < numOfPages) {
				retChildList = refillLst.subList(((pageNum - 1) * pageSize), (pageNum * pageSize));
			} else if (pageNum == numOfPages) {
				retChildList = refillLst.subList(((pageNum - 1) * pageSize), refillLst.size());
			} else {
				retChildList = refillLst;
			}
		}
		return retChildList;
	}
	
	public XMLGregorianCalendar list(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String requestSate, Calendar dateFilter, String patientOID) {

		log.debug("executing list() start");
		XMLGregorianCalendar cal = null;
		RxListRequests rxListRequests = null;
		boolean statePresent = false;
		for (ERequestState states : ERequestState.values()) {
			if (requestSate.equalsIgnoreCase(states.toString())) {
				statePresent = true;
				break;
			}
		}

		if (statePresent) {
			try {
				Date dateField = dateFilter.getTime();
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(dateField);
				XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
						.newInstance().newXMLGregorianCalendar(c);
				com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestStateWrapper requestStateWrapper = new com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestStateWrapper();
				requestStateWrapper.setState(ERequestState.ALL);
				rxListRequests = list(userToken, requestStateWrapper,
						xmlGregorianCalendar, patientOID);
				if (null != rxListRequests) {
					Iterator<RxListRequest> itr = rxListRequests
							.getRxListRequest().iterator();
					while (itr.hasNext()) {
						RxListRequest rxListRequest = (RxListRequest) itr
								.next();
						RxPrescriptions rxPrescriptions = rxListRequest
								.getPrescriptions();
						Iterator<RxPrescription> rxPrescriptionsitr = rxPrescriptions
								.getRxPrescription().iterator();
						while (rxPrescriptionsitr.hasNext()) {
							RxPrescription rxPrescription = (RxPrescription) rxPrescriptionsitr
									.next();
							String displayDays=propertyUtil.getGLOBAL_NOTIFICATION_DISPLAY_DAYS();
							if (rxPrescription
									.getLastState()
									.value()
									.equalsIgnoreCase(
											ERxPrescriptionState
													.fromValue(
															ERxPrescriptionState.DECLINED
																	.value())
													.value())
								&& null != displayDays &&CommonUtils.getDaysDiff(new Date(),
										rxPrescription.getLastStateDate()
												.toGregorianCalendar()
												.getTime()) <= Integer
										.parseInt(displayDays)) {
								cal = rxPrescription.getLastStateDate();
								break;
							}
						}
					}
				}
			} catch (DatatypeConfigurationException e) {
				log.error(e.getMessage(), e);
				throw new ERefillApplicationException(e);
			}catch(Exception ex){
				log.error(ex.getMessage(), ex);
				ErrorHandler.handleException(ex);
			}
		}
		log.debug("executing list() end");
		return cal;
	}
}
