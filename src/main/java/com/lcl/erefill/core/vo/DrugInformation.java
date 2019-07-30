package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;

public class DrugInformation implements Serializable{

	private static final long serialVersionUID = -8802990667249888296L;
	
	private String imageURL;
	private String disclaimer;
	private List<Details> details;
	
	private String completeHtml;
	
	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}
	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	/**
	 * @return the disclaimer
	 */
	public String getDisclaimer() {
		return disclaimer;
	}
	/**
	 * @param disclaimer the disclaimer to set
	 */
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	
	/**
	 * @return the details
	 */
	public List<Details> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<Details> details) {
		this.details = details;
	}
	public String getCompleteHtml() {
		return completeHtml;
	}
	public void setCompleteHtml(String completeHtml) {
		this.completeHtml = completeHtml;
	}
}