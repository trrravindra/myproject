package com.lcl.erefill.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.utils.PharmaUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.vo.StoreLocatorJSONResponse;
import com.lcl.erefill.core.vo.StoreRequest;

@Component
public class StoreService {
	
	//private static final Logger log = LoggerFactory.getLogger(StoreService.class);
	
	@Autowired
	PharmaUtils pharmaUtils;
	/**
	 * 
	 * @param request
	 * @return
	 */
	
	public StoreLocatorJSONResponse getLocation( StoreRequest request ) {
		
		String atgResponse = pharmaUtils.getPharmacyLocationDetails(request , PropertyUtil.isAtgPharmacyStoreLocationCacheable());		
		StoreLocatorJSONResponse response = new StoreLocatorJSONResponse();
		response.setResponse(atgResponse);
		return response;
		
	}

		
}
