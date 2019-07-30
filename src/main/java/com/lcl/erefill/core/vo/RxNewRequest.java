/**
 * 
 */
package com.lcl.erefill.core.vo;

import com.lcl.erefill.core.vo.RequestDelivery;

/**
 * @author hkokel version 1.0
 */
public class RxNewRequest extends Request {

	protected String pharmacyContractNumber;
	protected RxRenewPrescriptions prescriptions;
	protected String dummy;
	protected RequestDelivery delivery;
	protected String patientOID;
	protected String refillType;
	protected String deliveryChoice;
	protected String emailStatus;
	protected String dateRange;
	protected String delReleaseTime; //
	
	
	/****************for multiple refill request*******************/
	protected String storeId;
	protected String freeDelDeptId;
	
	protected String alternatePhone;
	
	public String getAlternatePhone() {
		return alternatePhone;
	}
	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}
	public String getDelReleaseTime() {
		return delReleaseTime;
	}

	public void setDelReleaseTime(String delReleaseTime) {
		this.delReleaseTime = delReleaseTime;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getFreeDelDeptId() {
		return freeDelDeptId;
	}

	public void setFreeDelDeptId(String freedeldeptid) {
		this.freeDelDeptId = freedeldeptid;
	}
	/*************************************/
	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getDeliveryChoice() {
		return deliveryChoice;
	}

	public void setDeliveryChoice(String deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	public String getRefillType() {
		return refillType;
	}

	public void setRefillType(String refillType) {
		this.refillType = refillType;
	}

	public String getPatientOID() {
		return patientOID;
	}

	public void setPatientOID(String patientOID) {
		this.patientOID = patientOID;
	}

	/**
	 * @return the delivery
	 */
	public RequestDelivery getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery
	 *            the delivery to set
	 */
	public void setDelivery(RequestDelivery delivery) {
		this.delivery = delivery;
	}

	public String getPharmacyContractNumber() {
		return pharmacyContractNumber;
	}

	public void setPharmacyContractNumber(String pharmacyContractNumber) {
		this.pharmacyContractNumber = pharmacyContractNumber;
	}

	public RxRenewPrescriptions getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(RxRenewPrescriptions prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

}
