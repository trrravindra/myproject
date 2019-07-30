package com.lcl.erefill.core.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CacheLoader {

	private static final Logger log = LoggerFactory
			.getLogger(CacheLoader.class);
//
//	/**
//	 * Static cache loader instance
//	 */
	private static CacheLoader instance;
//
	public static CacheLoader getInstance() {
		if (null == instance) {
			synchronized (CacheLoader.class) {
				if (null == instance) {
					instance = new CacheLoader();
					log.debug("Cacheloader instance created");
				} else {
					log.debug("Using the existing Cacheloader instance");
				}
			}
		}
	return instance;
	}

	
	public Object getObject(final String key) {
		return null;
	}
//
//
//	public void putObject(String cacheKey,
//			com.lcl.erefill.core.vo.Patient entityPatient) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void putObject(String storeId, HashMap<String, Object> pharmaMap) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void putObject(String cacheKey, String jsonDepartments) {
//		// TODO Auto-generated method stub
//		
//	}


	public void putObject(String cacheKeyChkdPresc, List<String> cachedList) {
		// TODO Auto-generated method stub
		
	}
	
}
