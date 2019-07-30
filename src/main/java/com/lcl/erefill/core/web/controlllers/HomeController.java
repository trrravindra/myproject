package com.lcl.erefill.core.web.controlllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.constants.ERefillConstants;




@Controller
@RequestMapping( "/" )
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView handleRequest( Model model, HttpServletRequest req, HttpServletResponse res) {
		
		/**
		 * set the default locale to en_US
		 */
		
		
		if( LOGGER.isDebugEnabled() ) {
			LOGGER.debug(" Setting locale to default locale: "+ERefillConstants.EREFILL_DEFAULT_LOCALE);
		}
		
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, ERefillConstants.EREFILL_DEFAULT_LOCALE );
		
		return new ModelAndView("myhomepage");
		
	}
}
