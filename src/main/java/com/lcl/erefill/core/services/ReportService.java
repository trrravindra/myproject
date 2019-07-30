package com.lcl.erefill.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.ReportWSImpl;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;

@Component
public class ReportService implements IReportService {

	private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

	@Autowired
	ReportWSImpl reportWSImpl;

	/**
	 * getTaxReceiptReport
	 * 
	 * @param taxReceiptReportRequest
	 * @param userToken
	 * 
	 * @return taxReceiptReportResponse
	 * @throws ERefillApplicationException, ERefillBusinessException
	 */
	public TaxReceiptReportResponse getTaxReceiptReport(
			TaxReceiptReportRequest taxReceiptReportRequest, UserToken userToken)
			throws ERefillApplicationException, ERefillBusinessException {
		final String methodName = "getTaxReceiptReport";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}

		TaxReceiptReportResponse taxReceiptReportResponse = null;
		try {
			// Call the WS Impl
			taxReceiptReportResponse = reportWSImpl.getTaxReceiptReport(
					userToken, taxReceiptReportRequest);

		} catch (ERefillBusinessException e) {
			throw e;
		} catch (ERefillApplicationException e) {
			throw e;
		} catch (Exception e1) {
			logger.error(methodName + " Error: " + e1);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return taxReceiptReportResponse;
	}

}
