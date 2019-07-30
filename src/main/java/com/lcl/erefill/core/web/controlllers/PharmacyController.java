package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcl.erefill.core.business.IPharmacyBusinessDelegate;
import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.PharmacyOperatingHours;

@Controller
@SessionAttributes
public class PharmacyController {

	private static final Logger logger = LoggerFactory
			.getLogger(PharmacyController.class);

	@Autowired
	IPharmacyBusinessDelegate pharmabd;

	@Autowired
	SessionManager sessionManager;

	@RequestMapping(value = "/{locale}/pharmacyDetails")
	public String processRequest(@PathVariable("locale") String locale,
			ModelMap model, HttpServletRequest req, HttpServletResponse res) {
		DataCarrier dto = new DataCarrier();
		String appContext = req.getContextPath();
		try {
			ERefillSession eRefillSession = (ERefillSession) req
					.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);

			dto.addObject(ERefillConstants.EREFILL_SESSION, eRefillSession);
			DataCarrier dc = pharmabd.getPharmacyDetails(dto);
			model.addAttribute(ERefillConstants.REQUEST_PHARMACY,
					dc.getObject(ERefillConstants.REQUEST_PHARMACY));
			req.setAttribute(ERefillConstants.REQUEST_PHARMACY,
					dc.getObject(ERefillConstants.REQUEST_PHARMACY));
		} catch (ERefillBusinessException e){ 
			logger.error(" Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(" Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			logger.error(" Error" + e);
			try {
				String redirect = appContext+ "/home/" + locale + "/welcome?signinerror=eProcessingError";
				res.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}
		return "overlay-pharmacy-information";
	}

	@RequestMapping(value = "/pharmacyDetails/operatingHours")
	public String getOperatingHours(ModelMap model, HttpServletRequest req,
			HttpServletResponse res) {
		ERefillSession eRefillSession = (ERefillSession) req
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		PharmaDeptVO pharmacyDetails = sessionManager
				.getPharmacyDetails(eRefillSession);
		String appContext = req.getContextPath();
		String locale = "en_CA";
		if (pharmacyDetails == null) {
			return "error";
		}

		try {
			List<PharmacyOperatingHours> operatingHours = pharmacyDetails
					.getPharmaVO().getOperatingHoursList();
			ObjectMapper mapper = new ObjectMapper();
			StringBuffer hrsBuffer = new StringBuffer();
			if (operatingHours != null) {
				String json = mapper.writeValueAsString(operatingHours);
				hrsBuffer.append("{\"operatingHours\":");
				hrsBuffer.append(json);
				hrsBuffer.append("}");
			} else {
				hrsBuffer.append("{}");
			}
			model.addAttribute(ERefillConstants.OPERATINGHOURS,
					hrsBuffer.toString());

		}catch (ERefillBusinessException e){ 
			logger.error(" Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(" Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			logger.error(" Error" + e);
			try {
				String redirect = appContext + "/home/" + locale+ "welcome?signinerror=eProcessingError";
				res.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		return "refillrequest.datetimepopup";
	}

	@RequestMapping(value = "/pharmacyDetails/delOperatingHours")
	public String getDelOperatingHours(ModelMap model, HttpServletRequest req,
			HttpServletResponse res) {

		ERefillSession eRefillSession = (ERefillSession) req
				.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		PharmaDeptVO pharmacyDetails = sessionManager
				.getPharmacyDetails(eRefillSession);
		String locale = "en_CA";
		String appContext = req.getContextPath();
		try {
			List<PharmacyOperatingHours> operatingHours = pharmacyDetails
					.getPharmaVO().getDeliveryOperatingHoursList();
			ObjectMapper mapper = new ObjectMapper();
			StringBuffer hrsBuffer = new StringBuffer();
			if (operatingHours != null) {
				String json = mapper.writeValueAsString(operatingHours);
				hrsBuffer.append("{\"operatingHours\":");
				hrsBuffer.append(json);
				hrsBuffer.append("}");
			} else {
				hrsBuffer.append("{}");
			}

			model.addAttribute(ERefillConstants.DEL_OPERATING_HOURS,
					hrsBuffer.toString());
		}catch (ERefillBusinessException e){ 
			logger.error(" Error10: " + e);
			throw e;
		}catch (ERefillApplicationException e){
			logger.error(" Error6: " + e);
			//throw e;
			if(e.toString().contains(ERefillConstants.STATUS_ACCESS_DENIED))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eAccessDenied";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
			}else if(e.toString().contains(ERefillConstants.STATUS_INVALID_ARGUMENTS))
			{
				try {
					String redirect = appContext +"/home/" + locale+ "/welcome?signinerror=eProcessingError";
					res.sendRedirect(redirect);
					return null;
				} catch (IOException e1) {
					logger.error("Exception while redirecting: ", e1);
				}
				
			}else{
				throw e;
			}
			
		}catch (Exception e) {
			logger.error(" Error" + e);
			try {
				String redirect = appContext + "/home/" + locale+ "welcome?signinerror=eProcessingError";
				res.sendRedirect(redirect);
				return null;
			} catch (IOException e1) {
				logger.error("IOException: " + e1);
			}
		}

		return "refillrequest.deliverydatetimepopup";
	}

}
