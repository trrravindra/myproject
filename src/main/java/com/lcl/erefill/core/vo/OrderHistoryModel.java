package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class OrderHistoryModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4784415622076913349L;

	private String date_range;
	private String status;
	private String page_num;
	
	/**
	 * @return the page_num
	 */
	public String getPage_num() {
		return page_num;
	}

	/**
	 * @param page_num the page_num to set
	 */
	public void setPage_num(String page_num) {
		this.page_num = page_num;
	}
	
	/**
	 * @return the date_range
	 */
	public String getDate_range() {
		return date_range;
	}

	/**
	 * @param date_range the date_range to set
	 */
	public void setDate_range(String date_range) {
		this.date_range = date_range;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
