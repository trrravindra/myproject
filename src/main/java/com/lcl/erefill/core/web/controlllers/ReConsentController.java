package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lcl.erefill.core.business.IManagedAccountDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;


@Controller
@SessionAttributes
@RequestMapping("/{locale}/reconsent")
public class ReConsentController {
	
	@Autowired
	IManagedAccountDelegate managedAccountDelegate;
	
	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/view")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView reConsent(@PathVariable String locale,
			ModelMap model,HttpServletRequest request, HttpServletResponse response){
		
		DataCarrier dto = new DataCarrier();
		logger.debug("Entering re-consent");
		String nextPage = "error";
		
		try {
		dto.addObject(ERefillConstants.LOGIN_MODEL, model);
		ERefillSession eRefillSession = (ERefillSession) request
					.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		dto.addObject(ERefillConstants.MAP_KEY_EREFILL_SESSION,eRefillSession);
		
		reConsentView(model,eRefillSession,locale,dto);
		nextPage = "reConsent";
		model.addAttribute("isConsentExpired",true);
		model.addAttribute("status","reconsent");
		}
		catch(Exception e){
			logger.error("Exception while re-consent : ", e);
		}
		return new ModelAndView(nextPage);
	}
	
	private ModelMap reConsentView(ModelMap model, ERefillSession eRefillSession, String locale,DataCarrier dto){
		final String methodName = "reConsentView";
		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Entering");
		}
		
		try {
			dto.addObject(ERefillConstants.CONSENT_TYPE, ERefillConstants.CONSENT_TYPE_ENROLLMENT);
			ConsentVO consentVO = managedAccountDelegate.getConsent(dto,
					eRefillSession);
			
			if (consentVO != null) {
				String agreeClause = locale.equals("en_CA") ? consentVO
						.getAgreementEnglish() : consentVO.getAgreementFrench();
				model.addAttribute("agreeClause", agreeClause);
				model.addAttribute("consentId", consentVO.getId());
			}
			model.addAttribute("locale", locale);
			
		} catch (Exception e) {
			logger.debug(methodName + " Error " + e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(methodName + " Exiting");
		}
		return model;
	}
	
	/**
	 * Confirm Reconcent Cancel view
	*/
	@RequestMapping(value = "/confirmReconsentCancel", method = RequestMethod.GET)
	public ModelAndView viewReconcentCancel(@PathVariable String locale, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new ModelAndView("confirmReconsentCancel");
	}
}
