package com.lcl.erefill.core.common.telus.response;

import java.util.HashMap;
import java.util.Map;

public class ManagedAccountResponse extends ERefillResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> managerMap ;
	
	
	public ManagedAccountResponse() {
		// TODO Auto-generated constructor stub
		managerMap = new HashMap<String,Object>();
	}


	public Map<String, Object> getManagerMap() {
		return managerMap;
	}


	public void setManagerMap(Map<String, Object> managerMap) {
		this.managerMap = managerMap;
	}
	
	

}
