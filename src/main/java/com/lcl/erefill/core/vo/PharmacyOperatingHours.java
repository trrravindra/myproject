package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class PharmacyOperatingHours implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1100309982186069901L;
	private String date;
	private String hours;
	private String day;
	private String dayFr;
	private String hoursFr;
	private boolean holiday;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDayFr() {
		return dayFr;
	}

	public void setDayFr(String dayFr) {
		this.dayFr = dayFr;
	}

	public String getHoursFr() {
		return hoursFr;
	}

	public void setHoursFr(String hoursFr) {
		this.hoursFr = hoursFr;
	}

	public boolean isHoliday() {
		return holiday;
	}

	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}
}
