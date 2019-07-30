package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.vo.DrugInformation;


public class DrugInformationResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrugInformation drugInformation;
	/**
	 * @return the drugInformation
	 */
	public DrugInformation getDrugInformation() {
		return drugInformation;
	}
	/**
	 * @param drugInformation the drugInformation to set
	 */
	public void setDrugInformation(DrugInformation drugInformation) {
		this.drugInformation = drugInformation;
	}
	
}
