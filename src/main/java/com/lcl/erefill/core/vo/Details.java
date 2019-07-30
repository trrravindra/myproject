package com.lcl.erefill.core.vo;

import java.io.Serializable;

public class Details implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6307030776157263293L;
	
	private String title;
	private String[] description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}
}
