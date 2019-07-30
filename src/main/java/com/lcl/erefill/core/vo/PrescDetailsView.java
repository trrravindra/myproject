package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class PrescDetailsView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String oid;
	private String din;
	private String name;
	private String genericName;
	private String strength;
	private String rxNumber;
	private String quantityFilled;
	private String originalOid;
	private int rxDate;
	private short daysSupply;
	private String estimatedFillDate;
	
	
	public String getEstimatedFillDate() {
		return estimatedFillDate;
	}

	public void setEstimatedFillDate(String estimatedFillDate) {
		this.estimatedFillDate = estimatedFillDate;
	}

	public short getDaysSupply() {
		return daysSupply;
	}
	
	public int getRxDate() {
		return rxDate;
	}

	public void setRxDate(int rxDate) {
		this.rxDate = rxDate;
	}


	public void setDaysSupply(short daysSupply) {
		this.daysSupply = daysSupply;
	}


	/**
	 * @return the originalOid
	 */
	public String getOriginalOid() {
		return originalOid;
	}
	/**
	 * @param originalOid the originalOid to set
	 */
	public void setOriginalOid(String originalOid) {
		this.originalOid = originalOid;
	}
	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	/**
	 * @return the din
	 */
	public String getDin() {
		return din;
	}
	/**
	 * @param din the din to set
	 */
	public void setDin(String din) {
		this.din = din;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the genericName
	 */
	public String getGenericName() {
		return genericName;
	}
	/**
	 * @param genericName the genericName to set
	 */
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	/**
	 * @return the strength
	 */
	public String getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(String strength) {
		this.strength = strength;
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
	 * @return the quantityFilled
	 */
	public String getQuantityFilled() {
		return quantityFilled;
	}
	/**
	 * @param quantityFilled the quantityFilled to set
	 */
	public void setQuantityFilled(String quantityFilled) {
		this.quantityFilled = quantityFilled;
	}

	
	
}