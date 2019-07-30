package com.lcl.erefill.core.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.utils.csrf.CSRFTokenService;
import com.lcl.erefill.core.utils.csrf.CSRFTokenServiceImpl;

@Configurable
@Component
public class CSRFInterceptor implements HandlerInterceptor { 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CSRFInterceptor.class);
	
	CSRFTokenService csrfTokenService = new CSRFTokenServiceImpl();

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean rv = true;
		if( request.getRequestURI().contains("login")) {
				return rv;
		}
		
		
		
		if(CSRFTokenService.METHODS_TO_CHECK.contains(StringUtils.defaultIfEmpty(request.getMethod(), "").toUpperCase())
				&& !csrfTokenService.acceptsTokenIn(request)) {
			//response.addHeader("X-DailyFratze-InvalidCSRFToken", Boolean.toString(true));
			//response.sendError(HttpServletResponse.SC_FORBIDDEN);
			
			LOGGER.info("CSRF error! Invalidating Session");
			request.getSession(false).invalidate();			
			String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
			/**
			 * Handle Ajax requests
			 */
			if ( "XMLHttpRequest".equalsIgnoreCase(ajaxHeader)) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN );
				response.setHeader("URL", getHomePage(request));					
				
			} else {
				response.sendRedirect(getHomePage(request));				
			}			
			rv = false;
		} 		
		return rv;
	}
 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {	
	}
 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {		
	}		
	
	private String getHomePage(HttpServletRequest httpRequest) {
		String locale = httpRequest.getRequestURL().toString().contains("en_CA")?"en_CA":"fr_CA";
		String homePageURI = httpRequest.getContextPath()+"/home/"+locale+"/welcome?securityerror=csrf";
		return homePageURI;
	}
}