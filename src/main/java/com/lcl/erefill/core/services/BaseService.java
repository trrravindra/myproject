package com.lcl.erefill.core.services;

import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.ADVISOR_ADVISROSHEETS;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.CONSENT;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.MANAGER;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.OPERATION;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.PROFILE;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.REPORT;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.REQUEST_PRESCRIPTION;
import static com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator.SESSION;

import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lcl.erefill.core.common.entity.ERefillToken;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.services.integ.telus.util.TelusServiceLocator;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.IAdvisorSheetsSvc;
import com.lcl.erefill.generated.telus.consent.IConsentSvc;
import com.lcl.erefill.generated.telus.manager.IManagerSvc;
import com.lcl.erefill.generated.telus.operation.IOperationSvc;
import com.lcl.erefill.generated.telus.profile.IProfileSvc;
import com.lcl.erefill.generated.telus.report.IReportSvc;
import com.lcl.erefill.generated.telus.request.prescription.IRequestRxSvc;
import com.lcl.erefill.generated.telus.session.ISessionSvc;

@Service
public class BaseService {

	private static final Logger log = LoggerFactory.getLogger(BaseService.class);
	
	protected Holder<com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken> prepareProfileTokenHolder(
			com.lcl.erefill.core.common.entity.UserToken token) {
		Holder<com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected Holder<com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken> prepareRequestPrescriptionTokenHolder(
			com.lcl.erefill.core.common.entity.UserToken token) {
		Holder<com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> prepareSessionTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected ERefillToken getToken(UserToken userToken) {
		ERefillToken erefillToken = new ERefillToken();
		if(null!=userToken){
			erefillToken.fill(userToken.getStatus(), userToken.getToken());
			log.debug("Base Service getToken >>>>UserStatus "
					+ userToken.getStatus() + " >>> UserToken >>"
					+ userToken.getToken());
		}
		return erefillToken;
	}

	protected Holder<com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken> prepareConsentTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected Holder<com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken> prepareAdvisorSheetsTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> prepareManagerTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}

	protected Holder<com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken> prepareReportTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}
	
	protected Holder<com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken> prepareOperationTokenHolder(
			UserToken token) {
		Holder<com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken> tokenHolder = new Holder<com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken>();
		com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken userToken = new com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken();
		getToken(token).fill(userToken);
		tokenHolder.value = userToken;
		return tokenHolder;
	}
	
	protected ISessionSvc getSessionService() {
		return TelusServiceLocator.getInstance().getService(SESSION);
	}

	protected IConsentSvc getConsentService() {
		return TelusServiceLocator.getInstance().getService(CONSENT);
	}

	protected IProfileSvc getProfileService() {
		return TelusServiceLocator.getInstance().getService(PROFILE);
	}

	protected IAdvisorSheetsSvc getAdvisorSheetsService() {
		return TelusServiceLocator.getInstance().getService(
				ADVISOR_ADVISROSHEETS);
	}

	protected IRequestRxSvc getRequestService() {
		return TelusServiceLocator.getInstance().getService(
				REQUEST_PRESCRIPTION);
	}

	protected IManagerSvc getManagerService() {
		return TelusServiceLocator.getInstance().getService(MANAGER);
	}
	
	protected IReportSvc getReportService() {
		return TelusServiceLocator.getInstance().getService(REPORT);
	}
	
	protected IOperationSvc getOperationService() {
		return TelusServiceLocator.getInstance().getService(OPERATION);
	}
}
