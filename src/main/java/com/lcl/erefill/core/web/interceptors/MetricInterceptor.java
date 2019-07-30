package com.lcl.erefill.core.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MetricInterceptor extends HandlerInterceptorAdapter  {

	private static final Logger logger = LoggerFactory
			.getLogger(MetricInterceptor.class);
	
	/**
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);	
		StringBuffer metricLog = new StringBuffer();
		metricLog.append("Request URL :::: ").append( request.getRequestURL().toString()).append(" START ---->>>>>");
		logger.info( metricLog.toString());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}


	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (Long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		StringBuffer metricLog = new StringBuffer();
		metricLog.append("Request URL :::: ").append( request.getRequestURL().toString()).append(" :::: Time taken ::::").append( timeTaken ).append(" ms");
		metricLog.append("Request URL :::: ").append( request.getRequestURL().toString()).append(" <<<<<-------END");
		logger.info( metricLog.toString());
		MDC.remove("user-id");
		
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	}

		
	
	
}
