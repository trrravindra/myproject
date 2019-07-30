package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;


public class RefillHistoryResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PrescriptionsBO> lstPresc;
	private Integer totalRecords = 0;
	private Integer numOfPages = 0;
	
	/**
	 * @return the totalRecords
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}
	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	/**
	 * @return the numOfPages
	 */
	public Integer getNumOfPages() {
		return numOfPages;
	}
	/**
	 * @param numOfPages the numOfPages to set
	 */
	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	/**
	 * @return the lstPresc
	 */
	public List<PrescriptionsBO> getLstPresc() {
		return lstPresc;
	}
	/**
	 * @param lstPresc the lstPresc to set
	 */
	public void setLstPresc(List<PrescriptionsBO> lstPresc) {
		this.lstPresc = lstPresc;
	}
}
