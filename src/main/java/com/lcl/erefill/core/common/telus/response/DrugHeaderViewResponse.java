package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.vo.DrugHeaderView;


public class DrugHeaderViewResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrugHeaderView drugHeaderView;
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
	
}
