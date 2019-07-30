package com.lcl.erefill.core.common.entity;

import java.io.Serializable;

public class PrescriptionsVO implements Serializable {

	private static final long serialVersionUID = 4365637302205288623L;
	private String lastStateDate;
	private String medicineName;
	private String productForm;
	private String productStrength;
	private int quantityFilled;
	private int count;
	private String rxNumber;	
	private String productDIN;	
	private String pharmacistComments;
	private String lastState;
	
	/**
	 * @return the lastState
	 */
	public String getLastState() {
		return lastState;
	}
	/**
	 * @param lastState the lastState to set
	 */
	public void setLastState(String lastState) {
		this.lastState = lastState;
	}
	/**
	 * @return the lastStateDate
	 */
	public String getLastStateDate() {
		return lastStateDate;
	}
	/**
	 * @param lastStateDate the lastStateDate to set
	 */
	public void setLastStateDate(String lastStateDate) {
		this.lastStateDate = lastStateDate;
	}
	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * @param medicineName the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	/**
	 * @return the productForm
	 */
	public String getProductForm() {
		return productForm;
	}
	/**
	 * @param productForm the productForm to set
	 */
	public void setProductForm(String productForm) {
		this.productForm = productForm;
	}
	/**
	 * @return the productStrength
	 */
	public String getProductStrength() {
		return productStrength;
	}
	/**
	 * @param productStrength the productStrength to set
	 */
	public void setProductStrength(String productStrength) {
		this.productStrength = productStrength;
	}
	/**
	 * @return the quantityFilled
	 */
	public int getQuantityFilled() {
		return quantityFilled;
	}
	/**
	 * @param quantityFilled the quantityFilled to set
	 */
	public void setQuantityFilled(int quantityFilled) {
		this.quantityFilled = quantityFilled;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the rxNumber
	 */
	public String getRxNumber() {
		return rxNumber;
	}
	/**
	 * @param rxNumber the rxNumber to set
	 */
	public void setRxNumber(String rxNumber) {
		this.rxNumber = rxNumber;
	}
	/**
	 * @return the productDIN
	 */
	public String getProductDIN() {
		return productDIN;
	}
	/**
	 * @param productDIN the productDIN to set
	 */
	public void setProductDIN(String productDIN) {
		this.productDIN = productDIN;
	}
	/**
	 * @return the pharmacistComments
	 */
	public String getPharmacistComments() {
		return pharmacistComments;
	}
	/**
	 * @param pharmacistComments the pharmacistComments to set
	 */
	public void setPharmacistComments(String pharmacistComments) {
		this.pharmacistComments = pharmacistComments;
	}
}
