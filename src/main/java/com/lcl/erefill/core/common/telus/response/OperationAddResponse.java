package com.lcl.erefill.core.common.telus.response;

/**
 * @author vsha51
 */
public class OperationAddResponse extends ERefillResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oid;
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
}
