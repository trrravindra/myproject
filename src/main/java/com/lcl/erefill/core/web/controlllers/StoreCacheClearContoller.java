package com.lcl.erefill.core.web.controlllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcl.erefill.core.cache.CachePurgeUtil;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.PharmaUtils;
import com.lcl.erefill.core.vo.StoreRequest;

// /cache/store/{storeid}
// /cache/store/{storeid}/department/{departmentid}
// /cache/location/{locationSearchString}

@Controller
@RequestMapping("{locale}/cache")
public class StoreCacheClearContoller {
		
	@Autowired
	private CachePurgeUtil purgeUtil;
	
	@Autowired
	private PharmaUtils pharmaUtils;
	
	private String notFoundResp= "{\"status\": \"404\", \"message\": \"Not found in cache\"}";
	private String exceptionResp= "{\"status\": \"500\", \"message\": \"Exception\"}";
	
	
	@RequestMapping(method = {RequestMethod.GET }, value = "/store/{storeid}", headers = {"Accept=application/json" })
	@ResponseBody
	public  JsonNode getStoreCache(@PathVariable String storeid, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		ObjectMapper o = new ObjectMapper();
		JsonNode json=null, errorJson =null;
		
		try {
			errorJson = o.readTree(exceptionResp);
			String storeCache = purgeUtil.getStoreFromCache(storeid);
			if(storeCache!=null){
				json= o.readTree(storeCache);
				return json;
			}
			json = o.readTree(notFoundResp);
		} catch (JsonProcessingException e) {
			return errorJson;
		} catch (IOException e) {
			return errorJson;
		}catch(Exception e){
			return errorJson;
		}
		return json;
	}
	
	@RequestMapping(method = {RequestMethod.GET }, value = "/store/{storeid}/department/{departmentid}", headers = {"Accept=application/json" })
	@ResponseBody
	public  JsonNode getStoreDeptCache(@PathVariable String storeid, @PathVariable String departmentid, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		ObjectMapper o = new ObjectMapper();
		JsonNode json=null, errorJson =null;
		try {
			errorJson = o.readTree(exceptionResp);
			String storeDeptCache=purgeUtil.getStoreDepartmentFromCache(storeid, departmentid);
			if(storeDeptCache!=null){
				json= o.readTree(storeDeptCache);
				return json;
			}
			json = o.readTree(notFoundResp);
		} catch (JsonProcessingException e) {
			return errorJson;
		} catch (IOException e) {
			return errorJson;
		}catch(Exception e){
			return errorJson;
		}
		return json;
	}
	 
	@RequestMapping(method = {RequestMethod.GET }, value="/location/{locationSearchString}", headers = {"Accept=application/json" })
	@ResponseBody
	public  JsonNode getStoreLocationCache(@PathVariable String locationSearchString, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		ObjectMapper o = new ObjectMapper();
		JsonNode json=null, errorJson =null;
		try {
			errorJson = o.readTree(exceptionResp);
			String locationCache=purgeUtil.getLocationFromCache(locationSearchString);
			if(locationCache!=null){
				json= o.readTree(locationCache);
				return json;
			}
			json = o.readTree(notFoundResp);
		} catch (JsonProcessingException e) {
			return errorJson;
		} catch (IOException e) {
			return errorJson;
		}catch(Exception e){
			return errorJson;
		}
		return json;
	}
	
	@RequestMapping(method = { RequestMethod.PUT }, value = "/store/{storeid}", headers = {"Accept=application/json" })
	@ResponseBody
	public  JsonNode  updateStoreCache(@PathVariable String storeid, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		ObjectMapper o = new ObjectMapper();
		JsonNode json=null;
		JsonNode errorJson=null;
		try {
			errorJson = o.readTree(exceptionResp);
			String resp = pharmaUtils.getPharmacyStoreDetails(storeid, true);
			json = o.readTree(resp);
		} catch (JsonProcessingException e) {
			return 	errorJson;	
		} catch (IOException e) {
			return 	errorJson;	
		} catch(ERefillBusinessException e){
			String erefillErrorResp="{\"status\": \"500\", \"message\": \""+e.getMessage()+"\"}";
				try {
					errorJson = o.readTree(erefillErrorResp);
				} catch (JsonProcessingException e1) {
					return 	errorJson;
				} catch (IOException e1) {
					return 	errorJson;
				}
				return 	errorJson;		
		}catch(Exception e){
			return 	errorJson;
		}
		return json;
	}
	
	
	@RequestMapping(method = {RequestMethod.PUT }, value="/store/{storeid}/department/{departmentid}", headers = {"Accept=application/json" })
	@ResponseBody
	public JsonNode updateStoreDeptCache(@PathVariable String storeid, @PathVariable String departmentid, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		ObjectMapper o = new ObjectMapper();
		JsonNode json=null;
		JsonNode errorJson=null;
		try {
			errorJson = o.readTree(exceptionResp);
			String storeDeptCache=pharmaUtils.getPharmacyDepartmentDetails(storeid, departmentid, true);
			json = o.readTree(storeDeptCache);
		} catch (JsonProcessingException e) {
			return 	errorJson;
		} catch (IOException e) {
			return 	errorJson;
		} catch(ERefillBusinessException e){
			String erefillErrorResp="{\"status\": \"500\", \"message\": \""+e.getMessage()+"\"}";
			try {
				errorJson = o.readTree(erefillErrorResp);
			} catch (JsonProcessingException e1) {
				return 	errorJson;
			} catch (IOException e1) {
				return 	errorJson;
			}
			return 	errorJson;		
		}catch(Exception e){
			return 	errorJson;
		}
		return json;
	}
	
	@RequestMapping(method = {RequestMethod.PUT }, value="/location/{locationSearchString}", headers = {"Accept=application/json" })
	@ResponseBody
	public JsonNode updateStoreLocationCache(@PathVariable String locationSearchString, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		StoreRequest storeRequest = new StoreRequest();
		storeRequest.setStores("10");
		storeRequest.setDepartments("300064");
		storeRequest.setProximity("50");
		storeRequest.setLocation(locationSearchString);

		ObjectMapper o = new ObjectMapper();
		JsonNode json=null;
		JsonNode errorJson=null;
		
		try {
			errorJson = o.readTree(exceptionResp);
			String locationCache=pharmaUtils.getPharmacyLocationDetails(storeRequest, true);
			json = o.readTree(locationCache);
		} catch (JsonProcessingException e) {
			return 	errorJson;
		} catch (IOException e) {
			return 	errorJson;
		} catch(ERefillBusinessException e){
			String erefillErrorResp="{\"status\": \"500\", \"message\": \""+e.getMessage()+"\"}";
			try {
				errorJson = o.readTree(erefillErrorResp);
			} catch (JsonProcessingException e1) {
				return 	errorJson;
			} catch (IOException e1) {
				return 	errorJson;
			}
			return 	errorJson;		
		}catch(Exception e){
			return 	errorJson;
		}
		return json;
	}
	
	@RequestMapping(method = {RequestMethod.DELETE }, value="/store/{storeid}")
	public void clearStoreCache(@PathVariable String storeid, HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearStoreCache(storeid);
	}
	
	@RequestMapping(method = {RequestMethod.DELETE }, value="/store/{storeid}/department/{departmentid}")
	public void clearStoreDeptCache(@PathVariable String storeid, @PathVariable String departmentid, HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearPharmacyDepartmentCache(storeid, departmentid);
	}
	
	@RequestMapping(method = {RequestMethod.DELETE }, value="/location/{locationSearchString}" )
	public void clearStoreLocationCache(@PathVariable String locationSearchString, HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearPharmacyLocationCache(locationSearchString);
	}
	
	
	@RequestMapping(method = {RequestMethod.DELETE }, value="/store/clearall" )
	public void clearAllStoreCache(HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearAllStores();
	}
	@RequestMapping(method = {RequestMethod.DELETE }, value="/store/department/clearall" )
	public void clearAllStoreDeptCache(HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearAllPharmacyDepartments();
	}
	@RequestMapping(method = {RequestMethod.DELETE }, value="/location/clearall" )
	public void clearAllStoreLocationCache(HttpServletRequest request, HttpServletResponse response) {
			purgeUtil.clearAllPharmacyLocations();
	}
	
	
	
}