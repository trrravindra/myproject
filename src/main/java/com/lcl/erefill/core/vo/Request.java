/**
 * 
 */
package com.lcl.erefill.core.vo;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

/**
 * @author hkokel version 1.0
 */
public class Request {

	protected String comments; //

	protected String email; //
	
	
	protected String lastState;
	protected XMLGregorianCalendar lastStateDate;
	protected String medReleaseMode; //
	protected String oid;
	protected String pharmacyContractNumber;
	protected String delReleaseDate; //
	

	protected String pickReleaseDate; //
	

	protected String pickReleaseTime; //
	

	protected String phone; //
	protected String phone1; //
	protected String phone2; //
	protected String phone3; //
	protected RequestDelivery delivery;
	public String getPickReleaseTime() {
		return pickReleaseTime;
	}

	public void setPickReleaseTime(String pickReleaseTime) {
		this.pickReleaseTime = pickReleaseTime;
	}
	public String getPickReleaseDate() {
		return pickReleaseDate;
	}

	public void setPickReleaseDate(String pickReleaseDate) {
		this.pickReleaseDate = pickReleaseDate;
	}
	public String getDelReleaseDate() {
		return delReleaseDate;
	}

	public void setDelReleaseDate(String delReleaseDate) {
		this.delReleaseDate = delReleaseDate;
	}

	

	

	

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public RequestDelivery getDelivery() {
		return delivery;
	}

	public void setDelivery(RequestDelivery delivery) {
		this.delivery = delivery;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public String getEMail() {
		return email;
	}

	public void setEMail(String eMail) {
		this.email = eMail;
	}
*/
	public String getLastState() {
		return lastState;
	}

	public void setLastState(String lastState) {
		this.lastState = lastState;
	}

	public XMLGregorianCalendar getLastStateDate() {
		return lastStateDate;
	}

	public void setLastStateDate(XMLGregorianCalendar lastStateDate) {
		this.lastStateDate = lastStateDate;
	}

	public String getMedReleaseMode() {
		return medReleaseMode;
	}

	public void setMedReleaseMode(String medReleaseMode) {
		this.medReleaseMode = medReleaseMode;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getPharmacyContractNumber() {
		return pharmacyContractNumber;
	}

	public void setPharmacyContractNumber(String pharmacyContractNumber) {
		this.pharmacyContractNumber = pharmacyContractNumber;
	}

	public String getPhone() {
		if (StringUtils.isNotBlank(phone1) && StringUtils.isNotBlank(phone2) && StringUtils.isNotBlank(phone3)) {
			return phone1.concat(phone2.concat(phone3));
		}
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
