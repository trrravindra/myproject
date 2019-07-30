package com.lcl.erefill.core.utils;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.services.integ.atg.RestService;
import com.lcl.erefill.core.vo.StoreRequest;

@Component
public class PharmaUtils {

	private Logger log = LoggerFactory.getLogger(PharmaUtils.class);

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	
	@Cacheable( value="pharmaStores", key="#storeId", condition="#isCacheable" )
	public String getPharmacyStoreDetails( String storeId, boolean isCacheable ) {
		
		log.debug("Did not find store information in cache for store id "+storeId +". Fetching from ATG");
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(PropertyUtil.getAtgStoreLocatorUri());
		strBuffer.append(storeId);
		 
		String pharmaStoreDetailsAsJSON = RestService.executeService(
				PropertyUtil.getAtgStoreBaseUrl(),
				strBuffer.toString(),
				PropertyUtil.getAtgStoreLocatorUserName(),
				PropertyUtil.getAtgStoreLocatorPassword(),
				PropertyUtil.getProxyHost(),
				PropertyUtil.getProxyPort()
				);
		
		return pharmaStoreDetailsAsJSON;
	
	}
	
	/**
	 * 
	 * @param storeId
	 * @param departmentId
	 * @return
	 */
	@Cacheable( value="pharmaDepartments", key="#storeId.concat('-').concat(#departmentId)", condition="#isCacheable")
	public String getPharmacyDepartmentDetails( String storeId, String departmentId, boolean isCacheable ){
		
		log.debug("Not found store department information [Store ID : "
				+ storeId + ", Department ID : " + departmentId + "] in cache. Fetching from ATG");
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(PropertyUtil.getAtgStoreLocatorUri());
		strBuffer.append(storeId);
		strBuffer.append( PropertyUtil.getAtgStoreLocatorDepartmentUri());
		strBuffer.append(departmentId);
		
		String pharmaDepartmentsAsJSON = RestService.executeService(
				PropertyUtil.getAtgStoreBaseUrl(),
				strBuffer.toString(), 
				PropertyUtil.getAtgStoreLocatorUserName(),
				PropertyUtil.getAtgStoreLocatorPassword(),
				PropertyUtil.getProxyHost(),
				PropertyUtil.getProxyPort()
				);
		return pharmaDepartmentsAsJSON;
	}
	
	@Cacheable( value="storeLocator", key="#request.location" , condition="#isCacheable")
	public String getPharmacyLocationDetails( StoreRequest request, boolean isCacheable) {
		
		log.debug("Could not find results in cache for location "+ request.getLocation()+": Fetching store location from ATG service..");
		String serviceUri = getAtgServiceUri(request);		
		String atgResponse = RestService.executeService(
				PropertyUtil.getAtgStoreBaseUrl(),
				serviceUri,
				PropertyUtil.getAtgStoreLocatorUserName(),
				PropertyUtil.getAtgStoreLocatorPassword(),
				PropertyUtil.getProxyHost(),
				PropertyUtil.getProxyPort()
				);
		return atgResponse;
		
	}
	
	/**
	 * 
	 * @param request
	 */
	private static String getAtgServiceUri(StoreRequest request) {
		StringBuilder url = new StringBuilder( PropertyUtil.getAtgStoreLocatorUri());
		//url.append( atgStoreLocatorUri );
		url.append("locator");
		url.append("?");
		if( request.getLocation() !=null ) {
			url.append( "location=").append(URLEncoder.encode(request.getLocation()));
		}
		if( request.getProximity()!=null ) {
			url.append( "&proximity=").append( request.getProximity() );
		}
		if( request.getStores() !=null ) {
			url.append("&stores=").append( request.getStores() );
		}
		if( request.getDepartments() !=null ) {
			url.append("&departments=").append( request.getDepartments() );
		}
		if( request.getLocale() !=null ) {
			url.append("&lang=").append( request.getLocale() );
		}
		
		return url.toString();
	}

		
	
	
}
