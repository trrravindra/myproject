/**
 * 
 */
package com.lcl.erefill.core.vo;

/**
 * @author hkokel version 1.0
 */
public class PrescriptionAddResponse {

	private String update_status;
	private String token_value;
	private String token_status;
	private String refillType;

	public String getUpdate_status() {
		return update_status;
	}

	public void setUpdate_status(String update_status) {
		this.update_status = update_status;
	}

	public String getToken_value() {
		return token_value;
	}

	public void setToken_value(String token_value) {
		this.token_value = token_value;
	}

	public String getToken_status() {
		return token_status;
	}

	public void setToken_status(String token_status) {
		this.token_status = token_status;
	}

	/**
	 * @return the refill_type
	 */
	public String getRefillType() {
		return refillType;
	}

	/**
	 * @param refill_type the refill_type to set
	 */
	public void setRefillType(String refill_type) {
		this.refillType = refill_type;
	}

}
