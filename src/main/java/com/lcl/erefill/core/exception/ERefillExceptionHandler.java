package com.lcl.erefill.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ERefillExceptionHandler extends ResponseEntityExceptionHandler{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ERefillExceptionHandler.class);
	
	@ResponseStatus( value=HttpStatus.INTERNAL_SERVER_ERROR )
	@ExceptionHandler(value= {ERefillApplicationException.class, ERefillBusinessException.class, RuntimeException.class} )
	public ModelAndView handleRuntimeExceptions( HttpServletRequest req, Exception e){
	
		LOGGER.error("RUNTIME EXCEPTION "+e);
		
		e.printStackTrace();
		String locale="en_CA";
		if( req.getRequestURL().toString().contains("fr_CA") ) {
			locale="fr_CA";
		}
		
		ModelAndView mav = new ModelAndView("internalerror");
		mav.addObject("locale",locale);
		mav.addObject("error",e);
		
		return mav;		
		
		
	}
	
	@ResponseStatus( value=HttpStatus.SERVICE_UNAVAILABLE )
	@ExceptionHandler(value= Exception.class)
	public ModelAndView handleBaseExceptions( HttpServletRequest req, Exception e){
		
        LOGGER.error("BASE EXCEPTION "+e);
		
		e.printStackTrace();
		String locale="en_CA";
		if( req.getRequestURL().toString().contains("fr_CA") ) {
			locale="fr_CA";
		}
		
		ModelAndView mav = new ModelAndView("internalerror");
		mav.addObject("locale",locale);
		mav.addObject("error",e);
		
		return mav;		
		
	}
	
	
}
