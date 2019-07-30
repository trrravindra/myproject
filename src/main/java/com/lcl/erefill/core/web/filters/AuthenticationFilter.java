package com.lcl.erefill.core.web.filters;

import java.io.IOException;
import java.util.UUID;
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
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.CookieUtils;
import com.lcl.erefill.core.utils.JSONErrorResponse;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.UserSession;

/**
 * @author vsha51
 */
@Component

public class AuthenticationFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthenticationFilter.class);

	private Pattern pattern;
	/**
	 * init
	 * 
	 * @param fConfig
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String excludePatterns =  fConfig.getInitParameter("excludePatterns");
		pattern = Pattern.compile(excludePatterns);
	}

	/**
	 * doFilter
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if( excludeUrlWithPatterns(httpRequest) ) {			
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession httpSession = null;
		UserSession userSession = null;
		ERefillSession eRefillSession = new ERefillSession();
		Boolean jsessionCookieExist = false;
		LOGGER.info(">>>>>>>>>> HTTP Request URI: "+httpRequest.getRequestURI());
		String cookieFromRequestHeader = httpRequest.getHeader("Cookie");
		if(cookieFromRequestHeader != null && !cookieFromRequestHeader.isEmpty()){
			jsessionCookieExist = cookieFromRequestHeader.contains(ERefillConstants.COOKIE_JSESSIONID);
		}
		
		/**
		 * If user is logging in for the first time, create new user session object
		 */
		if (httpRequest.getRequestURI().contains("validateuser/token")
				|| httpRequest.getRequestURI().contains("validatemobileuser/token")
				|| httpRequest.getRequestURI().contains("validateuser")
				|| httpRequest.getRequestURI().contains("getglobalconfig")
				|| httpRequest.getRequestURI().contains("confirmemail")
				|| httpRequest.getRequestURI().contains("confirmmobileemail")) {
			
			String tempUserId = request.getParameter("username");
			if( !CommonUtils.isNullOrBlank( tempUserId)) {
				MDC.put("temp-id", tempUserId );
			}
			MDC.put("user-id", "anonymous");
			
			/**
			 * Always create a new session for these requests
			 */
			
			httpSession = httpRequest.getSession(true);
			LOGGER.info("######## New session ####### URL "+ httpRequest.getRequestURL()+ " ### Session Id ####"+ httpSession.getId());
			
			/**
			 * reading from property : 11 mins
			 */
			httpSession.setMaxInactiveInterval(PropertyUtil.getSessionTimeout());
			userSession = new UserSession();
			userSession.setSessionId(httpSession.getId());
	
		} else if(httpRequest.getRequestURI().contains("terms-and-conditions")
				|| httpRequest.getRequestURI().contains("privacy-policy")
				|| httpRequest.getRequestURI().contains("consent")
				|| httpRequest.getRequestURI().contains("session")
				|| httpRequest.getRequestURI().contains("login/success")){
					httpSession = httpRequest.getSession(false);
					if( httpSession != null ) {
						userSession = (UserSession) httpSession.getAttribute(ERefillConstants.MAP_KEY_USER);
						try {
							eRefillSession.addAttribute(ERefillConstants.MAP_KEY_USER, userSession);
							eRefillSession.addAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION, httpSession);
						} catch (Exception e) {
							//TODO: Handle exception
						}
						if( userSession !=null && userSession.getErefillUserName() !=null ) {
							MDC.put("user-id", userSession.getErefillUserName() );
							MDC.put("sess-id", "ERID-"+userSession.getSessionId() +"-"+generateRandomId());
						} else {
							MDC.put("user-id", "anonymous" );
						}
					}
		}else if (!httpRequest.getRequestURI().contains("static")
				&& !httpRequest.getRequestURI().contains("welcome")
				&& !httpRequest.getRequestURI().contains("login")
				&& !httpRequest.getRequestURI().contains("store")
				&& !httpRequest.getRequestURI().contains("cache")){
						/**
						 * Get userSession object from the httpSession
						 */
						httpSession = httpRequest.getSession(false);
						/**
						 * Check for user session
						 */
						if( httpSession == null ) {
							String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
							/**
							 * Handle Ajax requests
							 */
							if ( "XMLHttpRequest".equalsIgnoreCase(ajaxHeader)) {
								httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN );
								httpResponse.setHeader("URL", getHomePage(httpRequest, httpResponse));		
								return;
							} else {
								if(jsessionCookieExist == false){
									if(httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE)){
										httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
										return;
									}
									httpResponse.sendRedirect(getHomePageWithoutSession(httpRequest, httpResponse));
									return;
								}else{
									if(httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && httpRequest.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE)){
										httpResponse=setErrorResponseJSON(httpResponse, getHomePage(httpRequest, httpResponse));
										return;
									}
									httpResponse.sendRedirect(getHomePage(httpRequest, httpResponse));
									return;
								}
							}
						} else {
							userSession = (UserSession) httpSession.getAttribute(ERefillConstants.MAP_KEY_USER);
							try {
								eRefillSession.addAttribute(ERefillConstants.MAP_KEY_USER, userSession);
								eRefillSession.addAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION, httpSession);
							} catch (Exception e) {
								//TODO: Handle exception
							}
							if( userSession !=null && userSession.getErefillUserName() !=null ) {
								MDC.put("user-id", userSession.getErefillUserName() );
								MDC.put("sess-id", "ERID-"+userSession.getSessionId() +"-"+generateRandomId());
							} else {
								MDC.put("user-id", "anonymous" );
							}
						}
		}
		try {
			eRefillSession.addAttribute(ERefillConstants.MAP_KEY_USER, userSession);
			eRefillSession.addAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION, httpSession);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e);
			//TODO: Handle exception
		}
	
		/**
		 * Pass the eRefillSession to the controller
		 */
		httpRequest.setAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION, eRefillSession);		
		chain.doFilter(request, response);
	}

	private HttpServletResponse setErrorResponseJSON(HttpServletResponse response, String url) throws IOException{
		JSONErrorResponse jsonErrorResponse = new JSONErrorResponse();
		jsonErrorResponse.setStatus(ERefillConstants.ERROR);
		jsonErrorResponse.setErrorType(ERefillConstants.SIGNINERROR);
		jsonErrorResponse.setErrorCode(ERefillConstants.STATUS_SESSION_EXPIRED);
		String json = new Gson().toJson(jsonErrorResponse);
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter().write(json);
		return response;
	}

	private String getHomePageWithoutSession(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		String locale = httpRequest.getRequestURL().toString().contains("fr_CA")?"fr_CA":"en_CA";
		String homePageURI = httpRequest.getContextPath()+"/home/"+locale+"/welcome";
		CookieUtils.deleteCookie(ERefillConstants.COOKIE_JSESSIONID, httpRequest, httpResponse);
		return homePageURI;
	}

	private String getHomePage(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		String locale = httpRequest.getRequestURL().toString().contains("fr_CA")?"fr_CA":"en_CA";
		String homePageURI = httpRequest.getContextPath()+"/home/"+locale+"/welcome?signinerror=eSessionExpired";
		CookieUtils.deleteCookie(ERefillConstants.COOKIE_JSESSIONID, httpRequest, httpResponse);
		return homePageURI;
	}
	
	private static String generateRandomId(){
		String randomAlphaDigit = UUID.randomUUID().toString();
		return randomAlphaDigit.substring(0, randomAlphaDigit.indexOf('-'));
	}

	private boolean excludeUrlWithPatterns(HttpServletRequest request) {
		
		//Pattern patter = Pattern.compile(excludePatterns);
		String url = request.getRequestURL().toString();
		Matcher m = pattern.matcher(url);
		return m.matches();
	}
    	
	/**
	 * destroy
	 */
	public void destroy() {
	}
}
