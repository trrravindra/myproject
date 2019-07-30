package com.lcl.erefill.core.services;

import static com.lcl.erefill.core.constants.ERefillConstants.REQUEST_USER_TOKEN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.LogOnResponse;
import com.lcl.erefill.core.common.telus.response.LogOnUserResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.services.integ.telus.SessionWSImpl;
import com.lcl.erefill.core.vo.User;

@Component
public class LoginService implements ILoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	SessionWSImpl sessionWSImpl;
	
	
	@Autowired
	IPrescriptionService prescriptionService;

	/**
	 * logOn
	 * 
	 * @param dto
	 * @throws Exception 
	 */
	public void logOn(DataCarrier dto) throws Exception {
		final String methodName = "logOn";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		User user = null;
		try {
			user = (User) dto.getObject(ERefillConstants.LOGIN_USER);
			LogOnResponse logOnResponse = sessionWSImpl.logOn(user);
			dto.addObject(ERefillConstants.LOGIN_RESPONSE, logOnResponse);
			UserToken userToken = new UserToken(logOnResponse.getStatus(),
					logOnResponse.getToken());
			dto.addObject(REQUEST_USER_TOKEN, userToken);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (Exception e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}
	
	/**
	 * logOnUser
	 * 
	 * @param dto
	 * @throws Exception 
	 */
	public void logOnUser(DataCarrier dto) throws Exception {
		final String methodName = "logOnUser";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		User user = null;
		try {
			user = (User) dto.getObject(ERefillConstants.LOGIN_USER);
			LogOnUserResponse logOnUserResponse = sessionWSImpl.logOnUser(user);
			dto.addObject(ERefillConstants.LOGIN_RESPONSE, logOnUserResponse);
			UserToken userToken = new UserToken(logOnUserResponse.getStatus(),
					logOnUserResponse.getToken());
			dto.addObject(REQUEST_USER_TOKEN, userToken);
		} catch (ERefillBusinessException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (ERefillApplicationException e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		} catch (Exception e) {
			logger.error(methodName + " Error: " + e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}

	/**
	 * logOut
	 * 
	 * @param userToken
	 * @param request
	 * @param response
	 */
	public void logOut(com.lcl.erefill.core.common.entity.UserToken userToken,
			HttpServletRequest request, HttpServletResponse response) {
		final String methodName = "logOut";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		sessionWSImpl.logoff(userToken, request, response);

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
	}
}
