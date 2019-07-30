package com.lcl.erefill.core.web.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.utils.JSONErrorResponse;
import com.lcl.erefill.core.utils.StatusExposingServletResponse;

@Component
public class StatusReportingFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatusReportingFilter.class);

	private Pattern pattern;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		if (excludeUrlWithPatterns(httpRequest)) {
			chain.doFilter(req, res);
			return;
		}
		StatusExposingServletResponse response = new StatusExposingServletResponse((HttpServletResponse) res, httpRequest);
		chain.doFilter(req, response);
		Integer status = response.getStatus();
		if(httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE)){
			if (status == 701) {
				// error check
				if (response.getRedirectLocation().contains(ERefillConstants.SIGNINERROR) || response.getRedirectLocation().contains(ERefillConstants.SECURITYERROR)) {
					JSONErrorResponse jsonErrorResponse = new JSONErrorResponse();
					String url = response.getRedirectLocation();
					jsonErrorResponse.setStatus(ERefillConstants.ERROR);
					jsonErrorResponse.setUrl(url);
					
					if(response.getRedirectLocation().contains(ERefillConstants.SIGNINERROR)){
						url=url.split("signinerror=")[1];
						jsonErrorResponse.setErrorType(ERefillConstants.SIGNINERROR);
					}else{
						url=url.split("securityerror=")[1];
						jsonErrorResponse.setErrorType(ERefillConstants.SECURITYERROR);
					}
					if(url.contains("&")){
						url=url.substring(0,url.indexOf("&"));
					}
					jsonErrorResponse.setErrorCode(url);
					String json = new Gson().toJson(jsonErrorResponse);
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					response.getWriter().write(json);
				} else{ // else redirect
					LOGGER.info(response.getResponse().getOutputStream().toString());
				}
				LOGGER.info("URL: " + response.getRedirectLocation());
			}
			return;
		}
	}

	public void init(FilterConfig config) throws ServletException {
		String excludePatterns = config.getInitParameter("excludePatterns");
		pattern = Pattern.compile(excludePatterns);
	}

	public void destroy() {
		// empty
	}

	private boolean excludeUrlWithPatterns(HttpServletRequest request) {

		// Pattern patter = Pattern.compile(excludePatterns);
		String url = request.getRequestURL().toString();
		Matcher m = pattern.matcher(url);
		return m.matches();
	}

}