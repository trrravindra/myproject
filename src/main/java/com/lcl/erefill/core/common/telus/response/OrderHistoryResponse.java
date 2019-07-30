package com.lcl.erefill.core.common.telus.response;

import java.util.List;
import java.util.Map;

import com.lcl.erefill.core.common.entity.RefillPrescriptionVO;


public class OrderHistoryResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, List<RefillPrescriptionVO>> mpRefill;
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
	/**
	 * @return the mpRefill
	 */
	public Map<String, List<RefillPrescriptionVO>> getMpRefill() {
		return mpRefill;
	}
	/**
	 * @param mpRefill the mpRefill to set
	 */
	public void setMpRefill(Map<String, List<RefillPrescriptionVO>> mpRefill) {
		this.mpRefill = mpRefill;
	}
	
}
