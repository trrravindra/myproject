package com.lcl.erefill.core.common.telus.response;

import java.util.List;

import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefillCalendar;

/**
 * @author vsha51
 */
public class AutomatedRefillCalendarResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262560226L;

	List<List<AutomatedRefillCalendar>> automatedRefillCalendarList;

	/**
	 * @return the automatedRefillCalendarList
	 */
	public List<List<AutomatedRefillCalendar>> getAutomatedRefillCalendarList() {
		return automatedRefillCalendarList;
	}

	/**
	 * @param automatedRefillCalendarList
	 *            the automatedRefillCalendarList to set
	 */
	public void setAutomatedRefillCalendarList(
			List<List<AutomatedRefillCalendar>> automatedRefillCalendarList) {
		this.automatedRefillCalendarList = automatedRefillCalendarList;
	}

}
