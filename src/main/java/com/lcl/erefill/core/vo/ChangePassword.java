package com.lcl.erefill.core.vo;

import java.io.Serializable;

/**
 * @author vsha51
 */
public class ChangePassword implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4784415622086913349L;

	private String newpassword;

	private String confirmpassword;

	private String currentpassword;

	/**
	 * @return the newpassword
	 */
	public String getNewpassword() {
		return newpassword;
	}

	/**
	 * @param newpassword
	 *            the newpassword to set
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	/**
	 * @return the confirmpassword
	 */
	public String getConfirmpassword() {
		return confirmpassword;
	}

	/**
	 * @param confirmpassword
	 *            the confirmpassword to set
	 */
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	/**
	 * @return the currentpassword
	 */
	public String getCurrentpassword() {
		return currentpassword;
	}

	/**
	 * @param currentpassword
	 *            the currentpassword to set
	 */
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
}
