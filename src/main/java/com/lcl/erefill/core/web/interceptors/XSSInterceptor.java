package com.lcl.erefill.core.web.interceptors;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lcl.erefill.core.utils.XSSUtils;

@Component
public class XSSInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if( handleXssInPathVariables(request, response) || handleXssInRequestParams(request, response) ) {
			request.getSession(false).invalidate();
			response.sendRedirect( getHomePage(request));
			return false;
			
		}
		
		return true;
	}

	
	private boolean handleXssInPathVariables(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		

		Map<String, String> pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		if( MapUtils.isNotEmpty(pathVariables)) {
		
			Iterator<Map.Entry<String, String>> entries = pathVariables.entrySet().iterator();
			while( entries.hasNext() ) {
				Map.Entry<String, String> entry =  entries.next();
				String key = entry.getKey();
				String value = entry.getValue();
				if( XSSUtils.detectXSS(value)) {
					return true;
					
				}
			}
		}
		
		return false;
	}

	

	
	private boolean handleXssInRequestParams(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//Map<String, String> pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Map<String, String[]> requestParams = request.getParameterMap();
		if( MapUtils.isNotEmpty(requestParams)) {
		
			Iterator iterator = requestParams.entrySet().iterator();
			
			while( iterator.hasNext()) {
			
				Map.Entry<String, String[]> entry = (Entry<String, String[]>) iterator.next();
				String key = entry.getKey();
				String[] values = entry.getValue();
				for ( String value : values){
					//String value = values[i];
					if( XSSUtils.detectXSS( value) ) {
						return true;
					}
				}
				
			}
		}
			 	
		return false;
	}
		
	private String getHomePage(HttpServletRequest httpRequest) {
		String locale = httpRequest.getRequestURL().toString().contains("en_CA")?"en_CA":"fr_CA";
		String homePageURI = httpRequest.getContextPath()+"/home/"+locale+"/welcome?securityerror=xss";
		return homePageURI;
	}

}
