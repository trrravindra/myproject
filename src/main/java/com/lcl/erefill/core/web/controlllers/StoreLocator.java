package com.lcl.erefill.core.web.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcl.erefill.core.services.StoreService;
import com.lcl.erefill.core.services.integ.atg.RestService;
import com.lcl.erefill.core.vo.IStoreRequest;
import com.lcl.erefill.core.vo.StoreLocatorJSONResponse;
import com.lcl.erefill.core.vo.StoreRequest;

@Controller
@RequestMapping( "/{locale}/store/" )

public class StoreLocator {

	@Autowired
	RestService atgService;
	
	@Autowired
	StoreService storeService;
	
	@RequestMapping( "/{storeId}" )
	public String getStoreDetails ( @RequestBody IStoreRequest storeDetailsRequest, @PathVariable String locale ) {
	
		
		return "";
	}
	
	/**
	 * 
	 * @param locale
	 * @param location
	 * @param departmentId
	 * @param proximity
	 * @param numOfStores
	 * @return
	 */
	@RequestMapping(
			method=RequestMethod.GET,
			value="/location/{location}/department/{departmentId}/proximity/{proximity}/fetch/{numOfStores}" ,
			headers={
					"Accept=text/plain, */*"
				}			
			)
	@ResponseBody 
	public StoreLocatorJSONResponse getStoreLocationDetails ( 
			@PathVariable String locale, @PathVariable String location,
			@PathVariable String departmentId, @PathVariable String proximity, @PathVariable String numOfStores
			
			) {
		// http://erefill.yourhealthmattershere.ca/services/en_CA/store/location/{location}/department/{depardtmentId}/proximity/{proximity}/fetch/10
		StoreRequest request = getStoreRequest(locale, location, departmentId, proximity, numOfStores);
		return storeService.getLocation(request);	
		
	}

	/**
	 * 
	 * @param locale
	 * @param location
	 * @param departmentId
	 * @param proximity
	 * @param numOfStores
	 */
	private StoreRequest getStoreRequest(String locale, String location,
			String departmentId, String proximity, String numOfStores) {
		StoreRequest request = new StoreRequest();
		request.setStores( numOfStores );
		request.setDepartments(departmentId);
		request.setProximity(proximity);
		request.setLocation(location);
		request.setLocale(locale);
		return request;
	}
	
	
}
