package com.lcl.erefill.core.web.controlllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.constants.ERefillConstants;




@Controller
@RequestMapping("/home")
public class HomePageController {
	
	@RequestMapping(value = "{locale}/welcome", method=RequestMethod.GET)
	public ModelAndView handleRequest( @PathVariable String locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		
		model.addAttribute(ERefillConstants.MAP_KEY_PAGE_NAME, "home");
		model.addAttribute(ERefillConstants.MAP_KEY_LOCALE, locale);
		model.addAttribute(ERefillConstants.PAGE_HEADER_TITLE, ERefillConstants.HOME_PAGE_TITLE);
		return new ModelAndView("myhomepage");
		
	}
}
