package com.lcl.erefill.core.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.lcl.erefill.core.constants.ERefillConstants;

public class StatusExposingServletResponse extends HttpServletResponseWrapper {

    private int httpStatus;
    private String redirectLocation;
    private HttpServletRequest request;

    public StatusExposingServletResponse(HttpServletResponse response, HttpServletRequest request) {
        super(response);
        response.setContentType("application/json");
        this.request=request;
    }

    
    
    @Override
    public void sendRedirect(String location) throws IOException {
    	if(request.getHeader(ERefillConstants.HEADER_VIEW_TYPE)!=null && request.getHeader(ERefillConstants.HEADER_VIEW_TYPE).equalsIgnoreCase(ERefillConstants.VIEW_TYPE_MOBILE)){    
    		// capturing redirect for mobile
    	httpStatus=701;
        redirectLocation = location;
      }else{
    		super.sendRedirect(location);
    	}
    }


    @Override
    public void setStatus(int sc) {
        httpStatus = sc;
        super.setStatus(sc);
    }

    public int getStatus() {
        return httpStatus;
    }
    
    public String getRedirectLocation(){
    	return redirectLocation;
    }

}