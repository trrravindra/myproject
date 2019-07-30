package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;

import com.lcl.erefill.core.vo.PharmacyOperatingHours;
import com.lcl.erefill.core.utils.CommonUtils;

public class PharmacyVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4679054506694691570L;
	
	private String storeId;
	private String depttId;
	private String freeDelDepttId;
	private String storeNameFr;
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
	private String pharmacyLogoFR;
	private String managerName;
	private String managerEmail;
	private List<PharmacyOperatingHours> operatingHoursList;
	private List<PharmacyOperatingHours> deliveryOperatingHoursList;
	private String pharmaJson;
	private String description;
	private String deliveryJson;
	
	/**
	 * added from CQ code
	 */
	private String homeDelivery; //not being used
	private String deliveryDepttId; //not being used
	private String pharmaDeliveryJson; //not being used
	private String descriptionFR;
	public String getHomeDelivery() {
		return homeDelivery;
	}

	public void setHomeDelivery(String homeDelivery) {
		this.homeDelivery = homeDelivery;
	}

	public String getDeliveryDepttId() {
		return deliveryDepttId;
	}

	public void setDeliveryDepttId(String deliveryDepttId) {
		this.deliveryDepttId = deliveryDepttId;
	}

	public String getPharmaDeliveryJson() {
		return pharmaDeliveryJson;
	}

	public void setPharmaDeliveryJson(String pharmaDeliveryJson) {
		this.pharmaDeliveryJson = pharmaDeliveryJson;
	}

	public String getDescriptionFR() {
		return descriptionFR;
	}

	public void setDescriptionFR(String descriptionFR) {
		this.descriptionFR = descriptionFR;
	}

	/**********************************************************************************/
	
	
	
	
	
	
	public String getDeliveryJson() {
		return deliveryJson;
	}

	public void setDeliveryJson(String deliveryJson) {
		this.deliveryJson = deliveryJson;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFreeDelDepttId() {
		return freeDelDepttId;
	}

	public void setFreeDelDepttId(String freeDelDepttId) {
		this.freeDelDepttId = freeDelDepttId;
	}

	public String getPharmaJson() {
		return pharmaJson;
	}

	public void setPharmaJson(String pharmaJson) {
		this.pharmaJson = pharmaJson;
	}

	/**
	 * 
	 * @return storeName in French
	 */
	public String getStoreNameFr() {
		return storeNameFr;
	}
	
	/***
	 * 
	 * @param storeNameFr
	 */
	
	public void setStoreNameFr(String storeNameFr) {
		this.storeNameFr = storeNameFr;
	}
	
	/**
	 * @return the storeId
	 */
	public String getStoreId() {
		return storeId;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	/**
	 * @return the depttId
	 */
	public String getDepttId() {
		return depttId;
	}
	/**
	 * @param depttId the depttId to set
	 */
	public void setDepttId(String depttId) {
		this.depttId = depttId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return CommonUtils.formatPhone(phone);
		//return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return CommonUtils.formatPhone(fax);
		//return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the countryAddress
	 */
	public String getCountryAddress() {
		return countryAddress;
	}
	/**
	 * @param countryAddress the countryAddress to set
	 */
	public void setCountryAddress(String countryAddress) {
		this.countryAddress = countryAddress;
	}
	/**
	 * @return the cityAddress
	 */
	public String getCityAddress() {
		return cityAddress;
	}
	/**
	 * @param cityAddress the cityAddress to set
	 */
	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}
	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	/**
	 * @return the pharmacyTitle
	 */
	public String getPharmacyTitle() {
		return pharmacyTitle;
	}
	/**
	 * @param pharmacyTitle the pharmacyTitle to set
	 */
	public void setPharmacyTitle(String pharmacyTitle) {
		this.pharmacyTitle = pharmacyTitle;
	}
	/**
	 * @return the pharmacyLogo
	 */
	public String getPharmacyLogo() {
		return pharmacyLogo;
	}
	/**
	 * @param pharmacyLogo the pharmacyLogo to set
	 */
	public void setPharmacyLogo(String pharmacyLogo) {
		this.pharmacyLogo = pharmacyLogo;
	}
	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * @return the managerEmail
	 */
	public String getManagerEmail() {
		return managerEmail;
	}
	/**
	 * @param managerEmail the managerEmail to set
	 */
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	/**
	 * @return the operatingHoursList
	 */
	public List<PharmacyOperatingHours> getOperatingHoursList() {
		return operatingHoursList;
	}
	/**
	 * @param operatingHoursList the operatingHoursList to set
	 */
	public void setOperatingHoursList(
			List<PharmacyOperatingHours> operatingHoursList) {
		this.operatingHoursList = operatingHoursList;
	}

	/**
	 * @return the deliveryOperatingHoursList
	 */
	public List<PharmacyOperatingHours> getDeliveryOperatingHoursList() {
		return deliveryOperatingHoursList;
	}

	/**
	 * @param deliveryOperatingHoursList the deliveryOperatingHoursList to set
	 */
	public void setDeliveryOperatingHoursList(
			List<PharmacyOperatingHours> deliveryOperatingHoursList) {
		this.deliveryOperatingHoursList = deliveryOperatingHoursList;
	}

	public String getPharmacyLogoFR() {
		return pharmacyLogoFR;
	}

	public void setPharmacyLogoFR(String pharmacyLogoFR) {
		this.pharmacyLogoFR = pharmacyLogoFR;
	}
}
