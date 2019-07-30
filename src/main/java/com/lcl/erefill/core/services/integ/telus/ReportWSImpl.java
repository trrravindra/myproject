package com.lcl.erefill.core.services.integ.telus;

import java.util.Locale;

import javax.xml.ws.Holder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;
import com.lcl.erefill.generated.telus.report.IReportSvcGetReportErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005.ArrayOfParameterValue;
import com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005.ParameterValue;
import com.lcl.erefill.generated.telus.report.rxassystlib.ECulture;
import com.lcl.erefill.generated.telus.report.rxassystlib.EReportName;
import com.lcl.erefill.generated.telus.report.rxassystlib.EReportOutputFormat;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.ReportInput;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken;

@Component
public class ReportWSImpl extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(ReportWSImpl.class);

	/**
	 * getTaxReceiptReport
	 * 
	 * @param userToken
	 * @param request
	 * @return taxReceiptReportResponse
	 */
	public TaxReceiptReportResponse getTaxReceiptReport(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			TaxReceiptReportRequest request) {

		TaxReceiptReportResponse taxReceiptReportResponse = new TaxReceiptReportResponse();
		try {
			Locale locale = request.getLocale();
			Holder<UserToken> userTokenHolder = null;
			Holder<byte[]> content = new Holder<byte[]>();
			Holder<String> extension = new Holder<String>();
			Holder<String> mimeType = new Holder<String>();

			ReportInput reportInput = new ReportInput();
			reportInput.setReportName(EReportName.TAX_RECEIPT);
			reportInput.setOutputFormat(EReportOutputFormat.PDF);
			if (locale.getLanguage().toString().equalsIgnoreCase("fr")) {
				reportInput.setCulture(ECulture.FR_CA);
			} else {
				reportInput.setCulture(ECulture.EN_CA);
			}

			ParameterValue parameterValueStartDate = new ParameterValue();
			parameterValueStartDate.setLabelField(ERefillConstants.START_DATE);
			parameterValueStartDate.setNameField(ERefillConstants.START_DATE);
			parameterValueStartDate.setValueField(request.getStartDate());

			ParameterValue parameterValueEndDate = new ParameterValue();
			parameterValueEndDate.setLabelField(ERefillConstants.END_DATE);
			parameterValueEndDate.setNameField(ERefillConstants.END_DATE);
			parameterValueEndDate.setValueField(request.getEndDate());

			ParameterValue parameterValueDispDrugName = new ParameterValue();
			parameterValueDispDrugName
					.setLabelField(ERefillConstants.DISPLAY_DRUG_NAME);
			parameterValueDispDrugName
					.setNameField(ERefillConstants.DISPLAY_DRUG_NAME);
			parameterValueDispDrugName.setValueField(request
					.getExcludeMedication().toString());

			ArrayOfParameterValue arrayOfParameterValue = new ArrayOfParameterValue();
			arrayOfParameterValue.getParameterValue().add(parameterValueStartDate);
			arrayOfParameterValue.getParameterValue().add(parameterValueEndDate);
			arrayOfParameterValue.getParameterValue().add(parameterValueDispDrugName);
			
			if(StringUtils.isNotBlank(request.getPatientOID())){
				ParameterValue parameterValuePatientOID = new ParameterValue();
				parameterValuePatientOID
						.setLabelField(ERefillConstants.PATIENT_OID);
				parameterValuePatientOID.setNameField(ERefillConstants.PATIENT_OID);
				parameterValuePatientOID.setValueField(request.getPatientOID());
				arrayOfParameterValue.getParameterValue().add(parameterValuePatientOID);
			}
			
			reportInput.setParametersValue(arrayOfParameterValue);

			userTokenHolder = prepareReportTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getReportService().getReport(userTokenHolder, reportInput, content,
					extension, mimeType);
			log.info(ERefillConstants.EXTERNAL_SRVC_GET_TAX_RECEIPT_REPORT
					+ "|" + CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));

			taxReceiptReportResponse.setResponseStatus(userTokenHolder.value
					.getStatus().get(0));
			taxReceiptReportResponse.setUserToken(userToken);
			if (content != null) {
				taxReceiptReportResponse.setContent(content.value);
			}
			if (extension != null) {
				taxReceiptReportResponse.setExtension(extension.value);
			}
			if (mimeType != null) {
				taxReceiptReportResponse.setMimeType(mimeType.value);
			}
		} catch (IReportSvcGetReportErrorFaultFaultMessage e) {
			taxReceiptReportResponse.setResponseStatus(ERefillConstants.STATUS_TOKEN_EXPIRED);
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			taxReceiptReportResponse.setResponseStatus(ERefillConstants.STATUS_SERVICE_ERROR);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			taxReceiptReportResponse.setResponseStatus(ERefillConstants.STATUS_SERVICE_ERROR);
			ErrorHandler.handleError(e);
		}
		return taxReceiptReportResponse;
	}
}
