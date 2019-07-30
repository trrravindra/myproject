package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import com.lcl.erefill.core.vo.DrugHeaderView;
import com.lcl.erefill.core.vo.DrugInformation;


public class MedicationRecordDetailResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrugInformation drugInformation;
	private DrugHeaderView drugHeaderView;
	private List<String> drugList;
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
	/**
	 * @return the drugHeaderView
	 */
	public DrugHeaderView getDrugHeaderView() {
		return drugHeaderView;
	}
	/**
	 * @param drugHeaderView the drugHeaderView to set
	 */
	public void setDrugHeaderView(DrugHeaderView drugHeaderView) {
		this.drugHeaderView = drugHeaderView;
	}
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
