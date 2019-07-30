package com.lcl.erefill.core.common.telus.response;

import java.io.Serializable;

import com.lcl.erefill.core.common.entity.UserToken;

/**
 * @author vsha51
 */
public class ERefillResponse implements Serializable {

	private static final long serialVersionUID = 4784415622087913349L;

	UserToken userToken;

	/**
	 * @return the userToken
	 */
	public UserToken getUserToken() {
		return userToken;
	}

	/**
	 * @param userToken
	 *            the userToken to set
	 */
	public void setUserToken(UserToken userToken) {
		this.userToken = userToken;
	}

}
