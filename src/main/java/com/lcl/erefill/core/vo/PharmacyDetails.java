package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;

public class PharmacyDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3597973328231042924L;

	private String name;

	private String phone;

	private String fax;

	private String countryAddress;

	private String cityAddress;

	private String postalCode;

	private String province;

	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	private String pharmacyTitle;

	private String pharmacyLogo;

	private String managerName;

	private String managerEmail;

	private String storeAddress;

	private String storePhone;

	private String storeFax;

	private String storeOpq;
	
	private String collegeStreet;
	
	private String collegeCity;
	
	private String collegeProvince;
	
	private String collegePostalCode;
	
	private String collegeUrl;
	
	

	public String getCollegeUrl() {
		return collegeUrl;
	}

	public void setCollegeUrl(String collegeUrl) {
		this.collegeUrl = collegeUrl;
	}

	public String getCollegeStreet() {
		return collegeStreet;
	}

	public void setCollegeStreet(String collegeStreet) {
		this.collegeStreet = collegeStreet;
	}

	public String getCollegeCity() {
		return collegeCity;
	}

	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}

	public String getCollegeProvince() {
		return collegeProvince;
	}

	public void setCollegeProvince(String collegeProvince) {
		this.collegeProvince = collegeProvince;
	}

	public String getCollegePostalCode() {
		return collegePostalCode;
	}

	public void setCollegePostalCode(String collegePostalCode) {
		this.collegePostalCode = collegePostalCode;
	}

	private List<PharmacyOperatingHours> operatingHoursList;
	
	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreFax() {
		return storeFax;
	}

	public void setStoreFax(String storeFax) {
		this.storeFax = storeFax;
	}

	public String getStoreOpq() {
		return storeOpq;
	}

	public void setStoreOpq(String storeOpq) {
		this.storeOpq = storeOpq;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PharmacyOperatingHours> getOperatingHoursList() {
		return operatingHoursList;
	}

	public void setOperatingHoursList(
			List<PharmacyOperatingHours> operatingHoursList) {
		this.operatingHoursList = operatingHoursList;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCountryAddress() {
		return countryAddress;
	}

	public void setCountryAddress(String countryAddress) {
		this.countryAddress = countryAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getPharmacyTitle() {
		return pharmacyTitle;
	}

	public void setPharmacyTitle(String pharmacyTitle) {
		this.pharmacyTitle = pharmacyTitle;
	}

	public String getPharmacyLogo() {
		return pharmacyLogo;
	}

	public void setPharmacyLogo(String pharmacyLogo) {
		this.pharmacyLogo = pharmacyLogo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

}
