package com.lcl.erefill.core.vo;

import javax.xml.datatype.Duration;

public class PharmacyOpeningHour {

	protected Integer hourFrom;
	protected Integer hourTo;
	protected String weekDay;
	protected Duration hourFromV2;
	protected Duration hourToV2;

	public Integer getHourFrom() {
		return hourFrom;
	}

	public void setHourFrom(Integer hourFrom) {
		this.hourFrom = hourFrom;
	}

	public Integer getHourTo() {
		return hourTo;
	}

	public void setHourTo(Integer hourTo) {
		this.hourTo = hourTo;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public Duration getHourFromV2() {
		return hourFromV2;
	}

	public void setHourFromV2(Duration hourFromV2) {
		this.hourFromV2 = hourFromV2;
	}

	public Duration getHourToV2() {
		return hourToV2;
	}

	public void setHourToV2(Duration hourToV2) {
		this.hourToV2 = hourToV2;
	}

}
