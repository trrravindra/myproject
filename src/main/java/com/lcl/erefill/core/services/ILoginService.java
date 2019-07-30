package com.lcl.erefill.core.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;


@Component
public interface ILoginService {

	/**
	 * logOn
	 * 
	 * @param dto
	 * @throws Exception 
	 */
	public void logOn(DataCarrier dto) throws Exception;

	/**
	 * logOut
	 * 
	 * @param userToken
	 * @param request
	 * @param response
	 */
	public void logOut(com.lcl.erefill.core.common.entity.UserToken userToken,HttpServletRequest request,HttpServletResponse response);
	
	
	/**
	 * logOnUser
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void logOnUser(DataCarrier dto) throws Exception;
}
