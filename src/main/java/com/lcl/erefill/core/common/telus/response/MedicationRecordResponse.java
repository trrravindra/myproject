package com.lcl.erefill.core.common.telus.response;

import java.util.ArrayList;
import java.util.List;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;


public class MedicationRecordResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PrescriptionsBO> lstPresc;
	private String filterDate;
	private Integer totalRecords = 0;
	private Integer firstRecord = 0;
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
	 * @return the firstRecord
	 */
	public Integer getFirstRecord() {
		return firstRecord;
	}
	/**
	 * @param firstRecord the firstRecord to set
	 */
	public void setFirstRecord(Integer firstRecord) {
		this.firstRecord = firstRecord;
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
	public MedicationRecordResponse() {
		this.lstPresc = new ArrayList<PrescriptionsBO>();
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
		this.lstPresc.clear();
		if(lstPresc != null){
			this.lstPresc.addAll(lstPresc);
		} else {
			this.lstPresc = null;
		}
	}
	/**
	 * @return the filterDate
	 */
	public String getFilterDate() {
		return filterDate;
	}
	/**
	 * @param filterDate the filterDate to set
	 */
	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}
	
}
