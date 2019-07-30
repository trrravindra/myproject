package com.lcl.erefill.core.web.interceptors;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

@Component
public class PathVariableLocaleChangeInterceptor extends
		HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(PathVariableLocaleChangeInterceptor.class);
	
	public static final String DEFAULT_PARAM_NAME = "locale";
	private String paramName = DEFAULT_PARAM_NAME;

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return this.paramName;
	}

	/**
	 * preHandle
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		final String methodName = "preHandle";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		Locale locale = extractLocale(request);
		
		logger.info("Client Accept-Language locale: "+request.getLocale());
		logger.info("preHandle Locale: "+locale.getLanguage());
		
		if (locale != null) {
			LocaleResolver localeResolver = RequestContextUtils
					.getLocaleResolver(request);
			if (localeResolver == null) {
				throw new IllegalStateException("No LocaleResolver found.");
			}else if(!(locale.toString().equals("en_CA") || locale.toString().equals("fr_CA")))
			{
				throw new IllegalStateException("No LocaleResolver found.");	
			}
			localeResolver.setLocale(request, response, locale);
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		return true;
	}

	/**
	 * extractLocale
	 * 
	 * @param request
	 * @return
	 */
	private Locale extractLocale(HttpServletRequest request) {
		String newLocale = extractLocaleString(request);
		if (StringUtils.hasText(newLocale)) {
			return StringUtils.parseLocaleString(newLocale);
		}
		return request.getLocale();
	}

	/**
	 * extractLocaleString
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private String extractLocaleString(HttpServletRequest request) {
		final String methodName = "extractLocaleString";
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Entering");
		}
		Map pathVariables = (Map) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		logger.info("extractLocaleString pathVariables: "+pathVariables);
		String newLocale = null;
		if (MapUtils.isNotEmpty(pathVariables)) {
			newLocale = (String) pathVariables.get(getParamName());
			logger.info("extractLocaleString newLocale: "+newLocale);
		}
		if (!StringUtils.hasText(newLocale)) {
			newLocale = request.getParameter(getParamName());
		}
		if(logger.isDebugEnabled()){
			logger.debug(methodName + " Exiting");
		}
		return newLocale;
	}
}
