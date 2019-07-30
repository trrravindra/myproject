package com.lcl.erefill.core.utils;

import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_FIRSTNAME;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_GLOBAL_NOTIFICATION;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_LOGIN_STATUS;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_STORE_ID;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_UNIQUIE_NAME;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_USERNAME;
import static com.lcl.erefill.core.constants.ERefillConstants.COOKIE_USER_CITY;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CookieUtils {
	
	private static final Logger log = LoggerFactory.getLogger(CookieUtils.class);

	private CookieUtils() {}

	public static Cookie getCookie(HttpServletRequest req, String name) {	
		log.debug(" Entering CookieUtils:getCookie() ");
		HttpServletRequest request = (HttpServletRequest) req;
		Cookie erefillSignInCookie = null;
		for(Cookie c : request.getCookies()){
			if(c.getName().equals(name)){
				erefillSignInCookie = c;
				break;
			}
		}
		log.debug(" Exiting CookieUtils:getCookie() ");
		return erefillSignInCookie;
	}	


	public static Cookie getCookie(Cookie[] cookies, String name) {	
		log.debug(" Entering CookieUtils:getCookie() ");
		Cookie erefillSignInCookie = null;
		if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals(name)){
				erefillSignInCookie = c;
				break;
			}
		}
		log.debug(" Exiting CookieUtils:getCookie() ");
		return erefillSignInCookie;
		}else{
			return null;
		}
	}	
	
	

	public static void deleteCookie(final String name, HttpServletRequest request, HttpServletResponse response) {	
		log.debug(" Entering CookieUtils:deleteCookie() ");	
		Cookie cookie = getCookie(request.getCookies(), name);						
		if (cookie != null) {			
			cookie.setValue(null);
			cookie.setPath("/");
		    cookie.setVersion(0);
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		}		 
		log.debug(" Exiting CookieUtils:deleteCookie() ");	
	}
	
	public static void deleteErefillCookies(HttpServletRequest request, HttpServletResponse response) {
		log.info("delete all erefill cookies");
		CookieUtils.deleteCookie(COOKIE_LOGIN_STATUS, request, response);
		CookieUtils.deleteCookie(COOKIE_FIRSTNAME, request,response);
		CookieUtils.deleteCookie(COOKIE_USERNAME, request,response);
		CookieUtils.deleteCookie(COOKIE_UNIQUIE_NAME, request,response);
		CookieUtils.deleteCookie(COOKIE_GLOBAL_NOTIFICATION, request,response);
		CookieUtils.deleteCookie(COOKIE_USER_CITY, request, response);
		CookieUtils.deleteCookie(COOKIE_STORE_ID, request, response);
	}
	
	
	
}
