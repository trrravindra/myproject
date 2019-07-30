package com.lcl.erefill.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Component;



@Component
public class CachePurgeUtil {

	@Autowired
	private SimpleCacheManager cacheManager;
	
	private Logger log = LoggerFactory.getLogger(CachePurgeUtil.class);
	
	@CacheEvict(value="pharmaStores", key="#storeId")
	public void clearStoreCache(String storeId){
		log.debug("Clearing cache for Store id: "+storeId);
	}
	@CacheEvict(value="pharmaStores", allEntries = true, beforeInvocation=true)
	public void clearAllStores(){
		log.debug("Clearing cache for all pharmaStores");
	}
	
	
	
	@CacheEvict( value="pharmaDepartments", key="#storeId.concat('-').concat(#departmentId)")
	public void clearPharmacyDepartmentCache(String storeId, String departmentId){
		log.debug("Clearing cache for Store id: "+storeId+" and depatment id: "+departmentId);
	}
	@CacheEvict( value="pharmaDepartments", allEntries = true, beforeInvocation=true)
	public void clearAllPharmacyDepartments(){
		log.debug("Clearing cache for all departments");
	}

	
	
	@CacheEvict( value="storeLocator", key="#location")
	public void clearPharmacyLocationCache(String location) {
		log.debug("Clearing cache for location: "+location);
	}
	@CacheEvict( value="storeLocator", allEntries = true, beforeInvocation=true)
	public void clearAllPharmacyLocations() {
		log.debug("Clearing cache for all pharmacy locations");
	}

	
	
	public String getStoreFromCache(String storeId) {
		Cache c=cacheManager.getCache("pharmaStores");
		ValueWrapper val=c.get(storeId);
		
		if(val!=null){
			return val.get().toString();
		}
		return null;
	}
	
	public String getStoreDepartmentFromCache(String storeId, String departmentId) {
		Cache c=cacheManager.getCache("pharmaDepartments");
		ValueWrapper val=c.get(storeId+"-"+departmentId);
		
		if(val!=null){
			return val.get().toString();
		}
		return null;
	}

	public String getLocationFromCache(String location) {
		Cache c=cacheManager.getCache("storeLocator");
		ValueWrapper val=c.get(location);
		
		if(val!=null){
			return val.get().toString();
		}
		return null;
	}
	
}
