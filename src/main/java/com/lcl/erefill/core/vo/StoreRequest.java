package com.lcl.erefill.core.vo;

public class StoreRequest implements IStoreRequest{

	
	private String location;
	private String stores;
	private String proximity;
	private String bannerIds;
	private String departments;
	private String locale;
	

	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStores() {
		return stores;
	}


	public void setStores(String stores) {
		this.stores = stores;
	}


	public String getProximity() {
		return proximity;
	}


	public void setProximity(String proximity) {
		this.proximity = proximity;
	}


	public String getBannerIds() {
		return bannerIds;
	}


	public void setBannerIds(String bannerIds) {
		this.bannerIds = bannerIds;
	}


	public String getDepartments() {
		return departments;
	}


	public void setDepartments(String departments) {
		this.departments = departments;
	}


	public String getStoreImplName() {		
		return "StoreLocationsRequest";
	}

}
