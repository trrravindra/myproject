package com.lcl.erefill.core.common.telus.response;

import java.util.List;

/**
 * @author vsha51
 */
public class RefillReminderResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262570226L;

	List<List<String>> reminderList;

	/**
	 * @return the reminderList
	 */
	public List<List<String>> getReminderList() {
		return reminderList;
	}

	/**
	 * @param reminderList
	 *            the reminderList to set
	 */
	public void setReminderList(List<List<String>> reminderList) {
		this.reminderList = reminderList;
	}
}
