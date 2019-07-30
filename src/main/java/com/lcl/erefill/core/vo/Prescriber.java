package com.lcl.erefill.core.vo;

import javax.xml.datatype.XMLGregorianCalendar;


public class Prescriber {
	
	protected String address;
	protected Integer birthDate;
	protected String city;
	protected String firstName;
	protected String gender;
	protected String language;
	protected String lastName;
	protected String license;
	protected String phoneNumber;
	protected String postalCode;
	protected String province;
	protected String workPhoneNumber;
	protected XMLGregorianCalendar birthDateV2;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Integer birthDate) {
		this.birthDate = birthDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
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
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}
	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}
	public XMLGregorianCalendar getBirthDateV2() {
		return birthDateV2;
	}
	public void setBirthDateV2(XMLGregorianCalendar birthDateV2) {
		this.birthDateV2 = birthDateV2;
	}
	
	
}
