package com.lcl.erefill.core.common.telus.response;

import java.util.List;


public class DrugListResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> drugList;
	/**
	 * @return the drugList
	 */
	public List<String> getDrugList() {
		return drugList;
	}
	/**
	 * @param drugList the drugList to set
	 */
	public void setDrugList(List<String> drugList) {
		this.drugList = drugList;
	}
}
