package com.lcl.erefill.core.services.integ.telus.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.helpers.LoadingByteArrayOutputStream;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.common.entity.ERefillToken;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.NoCounsellingSheetException;
import com.lcl.erefill.core.utils.CommonUtils;

public class TelusFaultInterceptor extends AbstractPhaseInterceptor<Message> {

	private static final Logger log = LoggerFactory
			.getLogger(TelusFaultInterceptor.class);

	private static final String FAULT_CODE_TAG_START = "<faultcode>";
	private static final String FAULT_CODE_TAG_END = "</faultcode>";
	private static final String INTERNAL_ERROR_CODE_TAG_START = "<InternalErrorCode>";
	private static final String INTERNAL_ERROR_CODE_TAG_END = "</InternalErrorCode>";
	// This will be a static reference even though read from the configuration;
	// since this not meant to be configurable and providing option to configure
	// the status if telus add any new
	private static final List<String> unCheckedStatusList = Arrays
			.asList(ERefillConfigService.TELUS_UNCHECKED_STATUS);

	public TelusFaultInterceptor() {
		super(Phase.RECEIVE);
	}

	/**
	 * handleMessage
	 * 
	 * @param message
	 * @return
	 */
	public void handleMessage(Message message) throws Fault {
		log.info("Handling message in TelusFaultInterceptor");
		String faultCode = null;
		LoadingByteArrayOutputStream bos = new LoadingByteArrayOutputStream();
		try {

			InputStream is = message.getContent(InputStream.class);
			List<byte[]> inbound = new CopyOnWriteArrayList<byte[]>();
			if (is == null) {
				return;
			}
			IOUtils.copy(is, bos);
			is.close();
			bos.close();
			inbound.add(bos.toByteArray());
			faultCode = getFaultCode(bos.toString());
			ByteArrayInputStream bis = bos.createInputStream();
			message.setContent(InputStream.class, bis);

		} catch (Exception ex) {
			log.error("handleMessage defaultException block", ex.getMessage());
			// Do nothing. CXF will take care exception in the next Interceptor
			// in chain.
		}
		if (null != faultCode && isUnCheckedStatus(faultCode)) {
			if (faultCode.contains(ERefillConstants.STATUS_ACCESS_DENIED)
					&& null != getInternalErrorCode(bos.toString())
					&& getInternalErrorCode(bos.toString()).equals("11")) {
				log.info(ERefillConstants.STATUS_MINOR_USER);
				throw new ERefillApplicationException(
						ERefillConstants.STATUS_MINOR_USER);
			}else if(faultCode.contains(ERefillConstants.STATUS_ACCESS_DENIED)){
				throw new ERefillApplicationException(
						ERefillConstants.STATUS_ACCESS_DENIED);
			} else {
				log.info(
						"Un expected fault returned from telus web service [faultCode : {}]",
						faultCode);
				log.info(ERefillConstants.STATUS_SERVICE_ERROR);
				throw new ERefillApplicationException(
						ERefillConstants.STATUS_SERVICE_ERROR);
			}
		} else if (null != faultCode
				&& faultCode
						.contains(ERefillConstants.STATUS_INVALID_USER_PASSWORD)) {
			log.info("Fault returned from telus web service [faultCode : {}]",
					faultCode);
			log.info(ERefillConstants.STATUS_INVALID_USER_PASSWORD);

			String status = getStatus(bos.toString());
			String token = getToken(bos.toString());

			if (null != status && null != token) {
				throw new ERefillBusinessException(
						ERefillConstants.STATUS_INVALID_USER_PASSWORD, status,
						token);
			} else {
				throw new ERefillApplicationException(
						ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			}

		} else if (null != faultCode
				&& faultCode.contains(ERefillConstants.STATUS_TOKEN_EXPIRED)) {
			log.info("Fault returned from telus web service [faultCode : {}]",
					faultCode);
			log.info(ERefillConstants.STATUS_TOKEN_EXPIRED);
			throw new ERefillApplicationException(
					ERefillConstants.STATUS_TOKEN_EXPIRED);
		} else if (null != faultCode
				&& faultCode
						.contains(ERefillConstants.NOCOUNSELLINGSHEET_EXCEPTION)) {
			log.info("FaultCode:" + faultCode);
			ERefillToken erefillToken = getErefillToken(bos.toString());
			throw new NoCounsellingSheetException(erefillToken.getStatus().get(
					0), CommonUtils.byteArrayAsString(erefillToken.getToken()
					.getValue()));
		} else {
			log.info(
					"Fault returned from telus web service *****  [faultCode : {}]",
					faultCode);
		}
	}

	/**
	 * getFaultCode
	 * 
	 * @param xml
	 * @return
	 */
	private String getFaultCode(final String xml) {
		String faultCode = null;
		log.info("getFaultCode ... Iterating from  ", xml);
		if (!CommonUtils.isNullOrBlank(xml)
				&& xml.contains(FAULT_CODE_TAG_START)
				&& xml.contains(FAULT_CODE_TAG_END)) {
			faultCode = xml.substring(xml.indexOf(FAULT_CODE_TAG_START) + 11,
					xml.indexOf(FAULT_CODE_TAG_END));
		}
		log.info("getFaultCode ... FaultCode: ", faultCode);
		return faultCode;
	}

	/**
	 * getInternalErrorCode
	 * 
	 * @param xml
	 * @return
	 */
	private String getInternalErrorCode(final String xml) {
		String internalErrorCode = null;
		log.info("getInternalErrorCode ... Iterating from  ", xml);
		if (!CommonUtils.isNullOrBlank(xml)
				&& xml.contains(INTERNAL_ERROR_CODE_TAG_START)
				&& xml.contains(INTERNAL_ERROR_CODE_TAG_END)) {
			internalErrorCode = xml.substring(
					xml.indexOf(INTERNAL_ERROR_CODE_TAG_START) + 19,
					xml.indexOf(INTERNAL_ERROR_CODE_TAG_END));
		}
		return internalErrorCode;
	}

	/**
	 * getErefillToken
	 * 
	 * @param xml
	 * @return
	 */
	private ERefillToken getErefillToken(final String xml) {

		ERefillToken erefillToken = new ERefillToken();
		String status = null;
		String token = null;
		if (!CommonUtils.isNullOrBlank(xml) && xml.contains("<a:Status>")
				&& xml.contains("</a:Status>")) {
			status = xml.substring(xml.indexOf("<a:Status>") + 10,
					xml.indexOf("</a:Status>"));
		}
		if (!CommonUtils.isNullOrBlank(xml) && xml.contains("<a:Token>")
				&& xml.contains("</a:Token>")) {
			token = xml.substring(xml.indexOf("<a:Token>") + 9,
					xml.indexOf("</a:Token>"));
		}
		erefillToken.fill(status, token);
		return erefillToken;
	}

	private String getStatus(final String xml) {
		String status = null;
		if (!CommonUtils.isNullOrBlank(xml) && xml.contains("<a:Status>")
				&& xml.contains("</a:Status>")) {
			status = xml.substring(xml.indexOf("<a:Status>") + 10,
					xml.indexOf("</a:Status>"));
		}
		return status;

	}

	private String getToken(final String xml) {
		String token = null;
		if (!CommonUtils.isNullOrBlank(xml) && xml.contains("<a:Token>")
				&& xml.contains("</a:Token>")) {
			token = xml.substring(xml.indexOf("<a:Token>") + 9,
					xml.indexOf("</a:Token>"));
		}
		return token;
	}

	private boolean isUnCheckedStatus(final String faultCode) {
		if (!CommonUtils.isNullOrEmpty(unCheckedStatusList)
				&& !CommonUtils.isNullOrBlank(faultCode)) {
			for (String status : unCheckedStatusList) {
				if (faultCode.contains(status))
					return true;
			}
		}
		return false;
	}
}
