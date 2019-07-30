package com.lcl.erefill.core.services.integ.telus.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.utils.AESEncryptionUtil;
import com.lcl.erefill.core.utils.PropertyUtil;

public class SecureLoggerOutInterceptor extends LoggingOutInterceptor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecureLoggerOutInterceptor.class);

	@Override
	protected String formatLoggingMessage(LoggingMessage loggingMessage) {
		String outGoingMsg = loggingMessage.toString();
		String logMsg = maskSensitiveData(outGoingMsg);
		return (logMsg);
	}
	
	private String maskSensitiveData(String outGoingReq){
		String maskAttr = PropertyUtil.getMultiVal_SecureInfo();
		List<String> myMaskList = new ArrayList<String>(Arrays.asList(maskAttr.split(",")));		
		StringBuffer outReqStr = new StringBuffer(outGoingReq);
		for(String maskableAttribute: myMaskList){
			LOGGER.debug("Processing for out going request on element "+maskableAttribute);
			if(StringUtils.contains(outGoingReq, maskableAttribute)){
				int beginIndex = 0;
				int lastIndex = 0;
				beginIndex = StringUtils.indexOfIgnoreCase(outGoingReq, maskableAttribute, beginIndex);
				
				beginIndex = StringUtils.indexOf(outGoingReq, ">", beginIndex)+1;
				lastIndex = StringUtils.indexOf(outGoingReq, "<", beginIndex);
				
				String sensitiveData = StringUtils.substring(outGoingReq, beginIndex, lastIndex);				
				try {
					String encryptedSensitiveData = new AESEncryptionUtil().encrypt(sensitiveData);
					outReqStr.replace(beginIndex, lastIndex, encryptedSensitiveData);
				} catch (Exception e) {
					LOGGER.error("ERROR while masking sensitive info of customer. Invoking alternative method"+e.getMessage());
					outGoingReq = maskPasswords(outGoingReq);
				}
			}
			LOGGER.debug("Looping for next masking attribute");
		}
		return outReqStr.toString();
	}
	
	/*
	 * Alternative way to mask password
	 */
	private String maskPasswords(String outGoingRequest) {
		String maskAttr = PropertyUtil.getMultiVal_SecureInfo();
		List<String> keys = new ArrayList<String>(Arrays.asList(maskAttr.split(",")));
		for (String key : keys) {
			int beginIndex = 0;
			int lastIndex = -1;
			boolean emptyPass = false;
			while (beginIndex != -1
					&& (beginIndex = StringUtils.indexOfIgnoreCase(outGoingRequest, key, beginIndex)) > 0) {

				beginIndex = StringUtils.indexOf(outGoingRequest, ">", beginIndex);
				LOGGER.debug("Found at begining of "+beginIndex);
				if (beginIndex != -1) {
					char ch = outGoingRequest.charAt(beginIndex - 1);
					if (ch == '/') {
						emptyPass = true;
					}
					if (!emptyPass) {
						lastIndex = StringUtils.indexOf(outGoingRequest, "<", beginIndex);
						LOGGER.debug("Index ends at "+lastIndex);
						if (lastIndex != -1) {
							String overlay = "*";
							String str2 = StringUtils.substring(outGoingRequest, beginIndex + 1, lastIndex);
							if (str2 != null && str2.length() > 1) {
								overlay = StringUtils.rightPad(overlay,	str2.length(), "*");
								outGoingRequest = StringUtils.overlay(outGoingRequest, overlay,
										beginIndex + 1, lastIndex);
							}
						}
					}
					if (emptyPass) {
						emptyPass = false;
						lastIndex = beginIndex + 1;
					} else {
						if (lastIndex != -1) {
							lastIndex = StringUtils.indexOf(outGoingRequest, ">", lastIndex);
						}
					}
				}
				beginIndex = lastIndex;
			}
		}
		return outGoingRequest;
	}

}
