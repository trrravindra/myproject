package com.lcl.erefill.core.vo;

import java.io.Serializable;

import com.lcl.erefill.core.utils.CommonUtils;

public class PharmaDeptVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4595748790152227320L;
	
	private PharmacyVO pharmaVO;
	private String collegeStreet;
	private String collegeCity;
	private String collegeProvince;
	private String collegePostalCode;
	private String collegeUrl;
	private String collegeLicenseLogo;
	private String collegeLicense;
	private String storeFax;
	private String storePhone;
	private String storeOpq;
	private String storeAddress;
	private String managerPhoto;
	
	/*** Code added for CR:  25th Nov **/
	private String legalName;
	private String legalNameFr;
	private String businessOwner;
	
	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalNameFr() {
		return legalNameFr;
	}

	public void setLegalNameFr(String legalNameFr) {
		this.legalNameFr = legalNameFr;
	}
	
	public String getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(String businessOwner) {
		this.businessOwner = businessOwner;
	}
	/*** End: Code added for CR:  25th Nov **/
	
	public String getManagerPhoto() {
		return managerPhoto;
	}
	public void setManagerPhoto(String managerPhoto) {
		this.managerPhoto = managerPhoto;
	}
	/**
	 * @return the pharmaVO
	 */
	public PharmacyVO getPharmaVO() {
		return pharmaVO;
	}
	/**
	 * @param pharmaVO the pharmaVO to set
	 */
	public void setPharmaVO(PharmacyVO pharmaVO) {
		this.pharmaVO = pharmaVO;
	}
	/**
	 * @return the collegeStreet
	 */
	public String getCollegeStreet() {
		return collegeStreet;
	}
	/**
	 * @param collegeStreet the collegeStreet to set
	 */
	public void setCollegeStreet(String collegeStreet) {
		this.collegeStreet = collegeStreet;
	}
	/**
	 * @return the collegeCity
	 */
	public String getCollegeCity() {
		return collegeCity;
	}
	/**
	 * @param collegeCity the collegeCity to set
	 */
	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}
	/**
	 * @return the collegeProvince
	 */
	public String getCollegeProvince() {
		return collegeProvince;
	}
	/**
	 * @param collegeProvince the collegeProvince to set
	 */
	public void setCollegeProvince(String collegeProvince) {
		this.collegeProvince = collegeProvince;
	}
	/**
	 * @return the collegePostalCode
	 */
	public String getCollegePostalCode() {
		return collegePostalCode;
	}
	/**
	 * @param collegePostalCode the collegePostalCode to set
	 */
	public void setCollegePostalCode(String collegePostalCode) {
		this.collegePostalCode = collegePostalCode;
	}
	/**
	 * @return the collegeUrl
	 */
	public String getCollegeUrl() {
		return collegeUrl;
	}
	/**
	 * @param collegeUrl the collegeUrl to set
	 */
	public void setCollegeUrl(String collegeUrl) {
		this.collegeUrl = collegeUrl;
	}
	
	/**
	 * @return the collegeLicenseLogo
	 */
	public String getCollegeLicenseLogo() {
		return collegeLicenseLogo;
	}
	
	/**
	 * @param collegeLicenseLogo the collegeLicenseLogo to set
	 */
	public void setCollegeLicenseLogo(String collegeLicenseLogo) {
		this.collegeLicenseLogo = collegeLicenseLogo;
	}
	
	/**
	 * @return the collegeLicense
	 */
	public String getCollegeLicense() {
		return collegeLicense;
	}
	
	/**
	 * @param collegeLicense the collegeLicense to set
	 */
	public void setCollegeLicense(String collegeLicense) {
		this.collegeLicense = collegeLicense;
	}
	
	/**
	 * @return the storeFax
	 */
	public String getStoreFax() {
		return CommonUtils.formatPhone(storeFax);
		//return storeFax;
	}
	/**
	 * @param storeFax the storeFax to set
	 */
	public void setStoreFax(String storeFax) {
		this.storeFax = storeFax;
	}
	/**
	 * @return the storePhone
	 */
	public String getStorePhone() {
		return CommonUtils.formatPhone(storePhone);
		//return storePhone;
	}
	/**
	 * @param storePhone the storePhone to set
	 */
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	/**
	 * @return the storeOpq
	 */
	public String getStoreOpq() {
		return storeOpq;
	}
	/**
	 * @param storeOpq the storeOpq to set
	 */
	public void setStoreOpq(String storeOpq) {
		this.storeOpq = storeOpq;
	}
	/**
	 * @return the storeAddress
	 */
	public String getStoreAddress() {
		return storeAddress;
	}
	/**
	 * @param storeAddress the storeAddress to set
	 */
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

}
