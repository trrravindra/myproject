/**
 * 
 */
package com.lcl.erefill.core.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hkokel version 1.0
 */
public class RxRenewPrescriptions {
	protected List<RxRenewPrescription> rxRenewPrescription;

	public void setRxRenewPrescription(List<RxRenewPrescription> rxRenewPrescription) {
		this.rxRenewPrescription = rxRenewPrescription;
	}

	public List<RxRenewPrescription> getRxRenewPrescription() {
		if (rxRenewPrescription == null) {
			rxRenewPrescription = new ArrayList<RxRenewPrescription>();
		}
		return this.rxRenewPrescription;
	}
}
