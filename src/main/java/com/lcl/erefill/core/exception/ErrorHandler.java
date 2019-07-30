package com.lcl.erefill.core.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.constants.ERefillConstants;



public abstract class ErrorHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
	
	public static void handleException(Throwable e){
		log.info("Handling exception - " + e.getMessage());
		  
		if(e.getMessage().toString().contains(ERefillConstants.STATUS_INVALID_USER_PASSWORD)){
			log.info(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			//throw new ERefillBusinessException(e);
		}else if(e.getMessage().toString().contains(ERefillConstants.STATUS_SERVICE_ERROR)){
			log.info(ERefillConstants.STATUS_SERVICE_ERROR);
			//throw new ERefillBusinessException(e);
		}else{
			log.info("Un known status code. Re throwing the erefill exceptions=");
			throw new ERefillApplicationException(e);
		}		
	}

	public static void handleError(Error e) {
		log.debug(">>>>> Error handler >>> handle error");
		log.debug("Error>> {}",e.getMessage());
		log.debug(">>>>> throws new ErefillException >>>");
		throw new ERefillApplicationException(e);
	}
	
	public static void handleException(HttpServletRequest request, HttpServletResponse response, Throwable e){
		log.info("Handling exception - " + e.getMessage());
		  
		try{
			if(e.getMessage().toString().contains(ERefillConstants.STATUS_INVALID_USER_PASSWORD)){
				log.info(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
				String url = ERefillConstants.STATUS_INVALID_USER_PASSWORD;
				log.info("redirecting to ..."+url);
				response.sendRedirect(url);
			}else if(e.getMessage().toString().contains(ERefillConstants.STATUS_SERVICE_ERROR)){
				log.info(ERefillConstants.STATUS_SERVICE_ERROR);
				response.sendRedirect(ERefillConstants.STATUS_SERVICE_ERROR);
			}else{
				log.info("Un known status code. Re throwing the erefill exceptions=");
				throw new ERefillApplicationException(e);
			}
		}catch(IOException ioe){
			log.info("IOException",e.getMessage());
			log.error(ioe.getMessage(),ioe);
			throw new ERefillApplicationException(ioe);
		}
	}
	
	public static void handleError(HttpServletRequest request, HttpServletResponse response, Error e){
		log.debug(">>>>> Error handler >>> handle error");
		log.debug("Error>> {}",e.getMessage());
		log.debug(">>>>> throws new ErefillException >>>");
		throw new ERefillApplicationException(e);
	}
	

}
