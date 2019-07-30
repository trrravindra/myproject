package com.lcl.erefill.core.vo;

import java.io.Serializable;

/**
 * @author vsha51
 */
public class AutoRefillReminderRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7736667206365984470L;

	private String phonenotify;
	private String phone;
	private String emailnotify;
	private String email;

	/**
	 * @return the phonenotify
	 */
	public String getPhonenotify() {
		return phonenotify;
	}

	/**
	 * @param phonenotify
	 *            the phonenotify to set
	 */
	public void setPhonenotify(String phonenotify) {
		this.phonenotify = phonenotify;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the emailnotify
	 */
	public String getEmailnotify() {
		return emailnotify;
	}

	/**
	 * @param emailnotify
	 *            the emailnotify to set
	 */
	public void setEmailnotify(String emailnotify) {
		this.emailnotify = emailnotify;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
