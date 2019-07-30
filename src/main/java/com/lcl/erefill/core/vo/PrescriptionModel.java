package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class PrescriptionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4784415622076913349L;

	private String date_range;
	private String from;
	private String to;
	private String sort_by;
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
	 * @param date_range
	 *            the date_range to set
	 */
	public void setDate_range(String date_range) {
		this.date_range = date_range;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the sort_by
	 */
	public String getSort_by() {
		return sort_by;
	}

	/**
	 * @param sort_by
	 *            the sort_by to set
	 */
	public void setSort_by(String sort_by) {
		this.sort_by = sort_by;
	}
}
