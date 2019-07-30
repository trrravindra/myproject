package com.lcl.erefill.core.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.vo.ERefillSession;

@Component
public interface ILoginUserBusinessDelegate {

	/**
	 * logOnUser
	 * 
	 * @param dto
	 * @throws Exception 
	 */
	public void logOn(DataCarrier dto) throws Exception;

	/**
	 * logOut
	 * 
	 * @param eRefillSession
	 * @param request
	 * @param response
	 */
	public void logOut(ERefillSession eRefillSession,HttpServletRequest request,HttpServletResponse response);
}
