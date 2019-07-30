package com.lcl.erefill.core.services;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.TaxReceiptReportResponse;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.vo.TaxReceiptReportRequest;

/**
 * @author vsha51
 */
@Component
public interface IReportService {

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
			throws ERefillApplicationException, ERefillBusinessException;	
}
