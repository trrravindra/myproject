/**
 * 
 */
package com.lcl.erefill.core.vo;

/**
 * @author hkokel version 1.0
 */
public class RxRenewPrescription {

	protected String comments;
	protected String oid;
	protected String originalOID;
	
	/**
	 * @return the originalOID
	 */
	public String getOriginalOID() {
		return originalOID;
	}

	/**
	 * @param originalOID the originalOID to set
	 */
	public void setOriginalOID(String originalOID) {
		this.originalOID = originalOID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

}
