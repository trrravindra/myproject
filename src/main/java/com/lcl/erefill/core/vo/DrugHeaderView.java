package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class DrugHeaderView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -965837625258545449L;
	private String din;
	private String name;
	private String genericName;
	private String strength;
	private String rxNum;
	private String instructions;
	
	/**
	 * @return the din
	 */
	public String getDin() {
		return din;
	}

	/**
	 * @param din : the din to set
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
	 * @param name : the name to set
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
	 * @param genericName : the genericName to set
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
	 * @param strength : the strength to set
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}

	/**
	 * @return the rxNum
	 */
	public String getRxNum() {
		return rxNum;
	}

	/**
	 * @param rxNum : the rxNum to set
	 */
	public void setRxNum(String rxNum) {
		this.rxNum = rxNum;
	}

	/**
	 * @return the instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions : the instructions to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}