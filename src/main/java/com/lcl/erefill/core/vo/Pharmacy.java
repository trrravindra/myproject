package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;

public class Pharmacy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String address;
	protected String chain;
	protected String city;
	protected String contractNumber;
	protected String faxNumber;
	protected String imageChecksum;
	protected String message;
	protected String name;
	protected String number;
	protected String owner;
    protected List<PharmacyOpeningHour> pharmacyOpeningHours;
	protected String phoneNumber;
	protected String postalCode;
	protected String province;
	protected String email;
	protected String internalId;

	
	public List<PharmacyOpeningHour> getPharmacyOpeningHours() {
		return pharmacyOpeningHours;
	}

	public void setPharmacyOpeningHours(
			List<PharmacyOpeningHour> pharmacyOpeningHours) {
		this.pharmacyOpeningHours = pharmacyOpeningHours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChain() {
		return chain;
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getImageChecksum() {
		return imageChecksum;
	}

	public void setImageChecksum(String imageChecksum) {
		this.imageChecksum = imageChecksum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

}
