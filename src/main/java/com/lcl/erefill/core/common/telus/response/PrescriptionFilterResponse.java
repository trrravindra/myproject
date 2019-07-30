package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;


public class PrescriptionFilterResponse extends ERefillResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Object> parameterList;
	private List<PrescriptionsBO> lstPresc;
	private XMLGregorianCalendar calendar;
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
	 * @return the parameterList
	 */
	public List<Object> getParameterList() {
		return parameterList;
	}
	/**
	 * @param parameterList the parameterList to set
	 */
	public void setParameterList(List<Object> parameterList) {
		this.parameterList = parameterList;
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
	/**
	 * @return the calendar
	 */
	public XMLGregorianCalendar getCalendar() {
		return calendar;
	}
	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(XMLGregorianCalendar calendar) {
		this.calendar = calendar;
	}
	
	
}
