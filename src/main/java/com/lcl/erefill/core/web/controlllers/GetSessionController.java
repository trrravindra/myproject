package com.lcl.erefill.core.web.controlllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.core.common.telus.response.AssignedPatientResponse;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.utils.SessionManager;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.Patient;

/**
 * 
 * @author ssi159
 *
 */
@Controller
@SessionAttributes
@RequestMapping("/{locale}/session")
public class GetSessionController {

	@Autowired
	SessionManager sessionManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(GetSessionController.class);

	/*
	sessionManager.getAssignedPatients(eRefillSession);
	sessionManager.getEmail(eRefillSession);
	sessionManager.getErefillUserName(eRefillSession);
	sessionManager.getFirstName(eRefillSession);
	sessionManager.getListCheckedPresc(eRefillSession);
	sessionManager.getName(eRefillSession);
	sessionManager.getPassword(eRefillSession);
	sessionManager.getPatient(eRefillSession);
	sessionManager.getPatientID(eRefillSession);
	sessionManager.getPendingCustodianRequests(eRefillSession);
	sessionManager.getRefillType(eRefillSession);
	sessionManager.getRememberMe(eRefillSession);
	sessionManager.getSelectedPatientOID(eRefillSession);
	sessionManager.getSelectedPresc(eRefillSession);
	sessionManager.getToken(eRefillSession);
	sessionManager.getUserName(eRefillSession);
	sessionManager.getUserRole(eRefillSession);
	*/
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAssignedPatients(@PathVariable String locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		
		if(eRefillSession!=null){
			model.addAttribute("email", sessionManager.getEmail(eRefillSession));
			model.addAttribute("assignedPatients", sessionManager.getAssignedPatients(eRefillSession));
			model.addAttribute("firstName", sessionManager.getFirstName(eRefillSession));
			model.addAttribute("name", sessionManager.getName(eRefillSession));
			model.addAttribute("patient", sessionManager.getPatient(eRefillSession));
			model.addAttribute("patientID", sessionManager.getPatientID(eRefillSession));
			model.addAttribute("userRole", sessionManager.getUserRole(eRefillSession));
			model.addAttribute("userName", sessionManager.getUserName(eRefillSession));
			model.addAttribute("selectedPatientOID", sessionManager.getSelectedPatientOID(eRefillSession));
		}else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
			
		return "success";
	}

	@RequestMapping(value = "/getAssignedPatients", method = RequestMethod.GET)
	public List<AssignedPatientResponse> getAssignedPatients(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getAssignedPatients(eRefillSession);
	}
	
	@RequestMapping(value = "/getEmail", method = RequestMethod.GET)
	public String getEmail(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getEmail(eRefillSession);
	}
	
	@RequestMapping(value = "/getErefillUserName", method = RequestMethod.GET)
	public String getErefillUserName(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getErefillUserName(eRefillSession);
	}
	
	@RequestMapping(value = "/getFirstName", method = RequestMethod.GET)
	public String getFirstName(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getFirstName(eRefillSession);
	}
	
	@RequestMapping(value = "/getName", method = RequestMethod.GET)
	public String getName(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getName(eRefillSession);
	}
	
	@RequestMapping(value = "/getPassword", method = RequestMethod.GET)
	public String getPassword(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getPassword(eRefillSession);
	}
	
	@RequestMapping(value = "/getPatient", method = RequestMethod.GET)
	public Patient getPatient(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getPatient(eRefillSession);
	}
	
	@RequestMapping(value = "/getPatientID", method = RequestMethod.GET)
	public String getPatientID(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getPatientID(eRefillSession);
	}
		
	@RequestMapping(value = "/getPendingCustodianRequests", method = RequestMethod.GET)
	public Integer getPendingCustodianRequests(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getPendingCustodianRequests(eRefillSession);
	}
	
	@RequestMapping(value = "/getRefillType", method = RequestMethod.GET)
	public String getRefillType(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getRefillType(eRefillSession);
	}
	
	@RequestMapping(value = "/getRememberMe", method = RequestMethod.GET)
	public String getRememberMe(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getRememberMe(eRefillSession);
	}
	
	@RequestMapping(value = "/getSelectedPatientOID", method = RequestMethod.GET)
	public String getSelectedPatientOID(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getSelectedPatientOID(eRefillSession);
	}
	
	@RequestMapping(value = "/getSelectedPresc", method = RequestMethod.GET)
	public Set<String> getSelectedPresc(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getSelectedPresc(eRefillSession);
	}
	
	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	public UserToken getToken(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getToken(eRefillSession);
	}
	
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	public String getUserName(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getUserName(eRefillSession);
	}
	
	@RequestMapping(value = "/getUserRole", method = RequestMethod.GET)
	public String getUserRole(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		
		ERefillSession eRefillSession = (ERefillSession) request.getAttribute(ERefillConstants.MAP_KEY_EREFILL_SESSION);
		return sessionManager.getUserRole(eRefillSession);
	}
	
}