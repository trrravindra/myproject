package com.lcl.erefill.core.services.integ.telus;

import static com.lcl.erefill.core.constants.ERefillConstants.EXTERNAL_SRVC_GETRXASSYST;
import static com.lcl.erefill.core.constants.ERefillConstants.EXTERNAL_SRVC_SUBSCRIBE;
import static com.lcl.erefill.core.constants.ERefillConstants.EXTERNAL_SRVC_UNSUBSCRIBE;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.telus.response.Consent;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.generated.telus.consent.IConsentSvcGetConsentErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.consent.IConsentSvcGetRxAssystErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.consent.IConsentSvcSubscribeErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.consent.IConsentSvcUnsubscribeErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.consent.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import com.lcl.erefill.generated.telus.consent.rxassystlib.ConsentType;
import com.lcl.erefill.generated.telus.consent.rxassystlib.EProfileReplicationOperation;
import com.lcl.erefill.generated.telus.consent.rxassystlib.EUnsubscribeReason;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentCode;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ReasonCode;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken;

@Component
public class ConsentWSImpl extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(ConsentWSImpl.class);

	public ConsentVO getConsent(com.lcl.erefill.core.common.entity.UserToken userToken,
			com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentCode consentCode) {
		com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Consent erefillConsent = new com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Consent();
		Holder<UserToken> userTokenHolder = prepareConsentTokenHolder(userToken);
		ConsentCode erefillConsentCode = new ConsentCode();
//		if(consentCode!=null && consentCode.getConsentType()!=null && StringUtils.isEmpty(consentCode.getConsentType().toString()))
//			erefillConsentCode.setConsentType(ConsentType.FAMILY_MANAGER);
//		if(consentCode.getConsentType()==null)
		erefillConsentCode.setConsentType(ConsentType.FAMILY_MEMBER);
		ConsentVO consentVO = new ConsentVO();
		try {
			erefillConsent = getConsentService().getConsent(userTokenHolder, consentCode);
			consentVO.setOid(erefillConsent.getOID().getValue());
			log.error("OID:::: " +consentVO.getOid());
			consentVO.setAgreementEnglish(erefillConsent.getAgreementEnglish());
			consentVO.setAgreementFrench(erefillConsent.getAgreementFrench());
			consentVO.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value.getToken().getValue()));
			consentVO.setStatus(userTokenHolder.value.getStatus().get(0));
			consentVO.setId(new Integer(erefillConsent.getId()));
			log.error("ID:::: " +consentVO.getId());
		} catch (IConsentSvcGetConsentErrorFaultFaultMessage e) {
			log.error(e.getMessage(), e);
			if(e.getFaultInfo()!=null && e.getFaultInfo().getUserToken()!=null){
				consentVO.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
				consentVO.setStatus(e.getFaultInfo().getUserToken().getValue().getStatus().get(0));
			}
		}catch (ERefillApplicationException e) {
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return consentVO;
	}
	
	public Consent getRxAssyst(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		Consent erefillConsent = new Consent();
		
		try {
			Holder<UserToken> userTokenHolder = prepareConsentTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentStatuses consentStatuses = getConsentService()
					.getRxAssyst(userTokenHolder);
			log.info(EXTERNAL_SRVC_GETRXASSYST+"|"+
					CommonUtils.executionTime(startTime));
			if (null != consentStatuses
					&& null != consentStatuses.getConsents()
					&& !CommonUtils.isNullOrEmpty(consentStatuses.getConsents()
							.getConsent())) {
				com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Consent consent = consentStatuses
						.getConsents().getConsent().get(0);
				erefillConsent.setAgreementEnglish(consent
						.getAgreementEnglish());
				erefillConsent.setAgreementFrench(consent.getAgreementFrench());
				erefillConsent.setId(consent.getId());
				erefillConsent.setStatus(userTokenHolder.value.getStatus().get(
						0));
				erefillConsent.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));

			}

		} catch (IConsentSvcGetRxAssystErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			erefillConsent.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			erefillConsent.setToken(CommonUtils.byteArrayAsString(e
					.getFaultInfo().getUserToken().getValue().getToken()
					.getValue()));
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
		}catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return erefillConsent;
	}

	public com.lcl.erefill.core.common.entity.UserToken subscribe(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			int consentIds) {
		try {
			ArrayOfint arrayOfint = new ArrayOfint();
			arrayOfint.getInt().add(consentIds);
			Holder<UserToken> userTokenHolder = prepareConsentTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getConsentService().subscribe(userTokenHolder, arrayOfint);
			log.info(EXTERNAL_SRVC_SUBSCRIBE+"|"+
					CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IConsentSvcSubscribeErrorFaultFaultMessage e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return userToken;
	}

	public void unsubscribe(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String reasonKey, int consentIds) {
		try {
			ArrayOfint arrInt = new ArrayOfint();
			arrInt.getInt().add(consentIds);
			EProfileReplicationOperation eProfileReplicationOperation = null;
			EUnsubscribeReason eUnsubscribeReason = null;
			JAXBElement<String> reasonText = null;
			Holder<UserToken> userTokenHolder = prepareConsentTokenHolder(userToken);
			if (ERefillConstants.REQ_PARAM_CLOSE_AC_FLAG.equals(reasonKey)) {
				eProfileReplicationOperation = EProfileReplicationOperation.STOP_REPLICATION;
				reasonText = CommonUtils.prepareJAXBElement(
						ERefillConstants.QNAME_RXASSYSTLIB_CONTRACTS_DATA,
						"ReasonText", String.class, reasonKey);
				eUnsubscribeReason = EUnsubscribeReason
						.fromValue(EUnsubscribeReason.OTHER.value());
			} else {
				eProfileReplicationOperation = EProfileReplicationOperation.NONE;
				String reasonValue = reasonKey;

				reasonText = CommonUtils.prepareJAXBElement(
						ERefillConstants.QNAME_RXASSYSTLIB_CONTRACTS_DATA,
						"ReasonText", String.class, reasonValue);
				eUnsubscribeReason = EUnsubscribeReason.fromValue(reasonValue);
			}
			ReasonCode reasonCode = new ReasonCode();
			reasonCode.setReasonForUnsubscribe(eUnsubscribeReason);
			reasonCode.setReasonText(reasonText);
			long startTime = System.currentTimeMillis();
			getConsentService().unsubscribe(userTokenHolder, arrInt,
					eProfileReplicationOperation, reasonCode);
			log.info(EXTERNAL_SRVC_UNSUBSCRIBE+"|"+
					CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (IConsentSvcUnsubscribeErrorFaultFaultMessage e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
	}

}
