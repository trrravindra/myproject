package com.lcl.erefill.core.common.telus.response;

import java.util.List;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefill;

/**
 * @author vsha51
 */
public class AutomatedRefillResponse extends ERefillResponse {

	private static final long serialVersionUID = 8946448551262570226L;

	List<List<String>> automatedRefillList;
	AutomatedRefill automatedRefill;

	/**
	 * @return the automatedRefill
	 */
	public AutomatedRefill getAutomatedRefill() {
		return automatedRefill;
	}

	/**
	 * @param automatedRefill
	 *            the automatedRefill to set
	 */
	public void setAutomatedRefill(AutomatedRefill automatedRefill) {
		this.automatedRefill = automatedRefill;
	}

	/**
	 * @return the automatedRefillList
	 */
	public List<List<String>> getAutomatedRefillList() {
		return automatedRefillList;
	}

	/**
	 * @param automatedRefillList
	 *            the automatedRefillList to set
	 */
	public void setAutomatedRefillList(List<List<String>> automatedRefillList) {
		this.automatedRefillList = automatedRefillList;
	}

}
