package com.lcl.erefill.core.vo;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;


public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6728778752478047026L;

	private PatientAccounts accounts;
	private String address;
	private String storeID;
	private String alias;
	private Integer birthDate;
	private String city;
	private String comments;
	private PatientContacts contacts;
	private int creatinineClearance;
	private Integer creationDate;
	private boolean disExcluded;
	private String disKey;
	private boolean deceased;
	private boolean deliveryActive;
	private String deliveryAddress;
	private String deliveryCity;
	private String deliveryComments;
	private String deliveryPhoneNumber;
	private String deliveryPostalCode;
	private String deliveryProvince;
	private Facility facility;
	private boolean facilityActive;
	private String facilityBed;
	private Integer facilityDepartureDate;
	private String facilityFloor;
	private Integer facilityReturnDate;
	private String facilityRoom;
	private String facilityTable;
	private Prescriber familyPhysician;
	private String firstName;
	private String gender;
	private int height;
	private Integer heightWeightModificationDate;
	private String hospitalCardNumber;
	private String language;
	private String lastName;
	private boolean loyaltyCardActive;
	private String loyaltyCardNumber;
	private Integer modificationDate;
	private boolean noSubstitute;
	private String oid;
	private String phn;
	private String phnExpiration;
	private String phnType;
	private String patientFile;
	private String phoneNumber;
	private String postalCode;
	private String primaryAddressPostalCode;
	private String province;
	private String referenceFileNumber;
	private String shortRemark;
	private String userName;
	private int weight;
	private String workPhoneNumber;
	private XMLGregorianCalendar birthDateV2;
	private XMLGregorianCalendar heightWeightModificationDateV2;
	private XMLGregorianCalendar creationDateV2;
	private XMLGregorianCalendar modificationDateV2;
	private XMLGregorianCalendar facilityDepartureDateV2;
	private XMLGregorianCalendar facilityReturnDateV2;
	private Pharmacy defaultPharmacy;
	private String EProvince;
	private String primaryEProvince;

	public String getEProvince() {
		return EProvince;
	}

	public void setEProvince(String eProvince) {
		EProvince = eProvince;
	}

	public String getPrimaryEProvince() {
		return primaryEProvince;
	}

	public void setPrimaryEProvince(String primaryEProvince) {
		this.primaryEProvince = primaryEProvince;
	}

	public PatientAccounts getAccounts() {
		return accounts;
	}

	public void setAccounts(PatientAccounts accounts) {
		this.accounts = accounts;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public PatientContacts getContacts() {
		return contacts;
	}

	public void setContacts(PatientContacts contacts) {
		this.contacts = contacts;
	}

	public int getCreatinineClearance() {
		return creatinineClearance;
	}

	public void setCreatinineClearance(int creatinineClearance) {
		this.creatinineClearance = creatinineClearance;
	}

	public Integer getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Integer creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isDisExcluded() {
		return disExcluded;
	}

	public void setDisExcluded(boolean disExcluded) {
		this.disExcluded = disExcluded;
	}

	public String getDisKey() {
		return disKey;
	}

	public void setDisKey(String disKey) {
		this.disKey = disKey;
	}

	public boolean isDeceased() {
		return deceased;
	}

	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}

	public boolean isDeliveryActive() {
		return deliveryActive;
	}

	public void setDeliveryActive(boolean deliveryActive) {
		this.deliveryActive = deliveryActive;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryComments() {
		return deliveryComments;
	}

	public void setDeliveryComments(String deliveryComments) {
		this.deliveryComments = deliveryComments;
	}

	public String getDeliveryPhoneNumber() {
		return deliveryPhoneNumber;
	}

	public void setDeliveryPhoneNumber(String deliveryPhoneNumber) {
		this.deliveryPhoneNumber = deliveryPhoneNumber;
	}

	public String getDeliveryPostalCode() {
		return deliveryPostalCode;
	}

	public void setDeliveryPostalCode(String deliveryPostalCode) {
		this.deliveryPostalCode = deliveryPostalCode;
	}

	public String getDeliveryProvince() {
		return deliveryProvince;
	}

	public void setDeliveryProvince(String deliveryProvince) {
		this.deliveryProvince = deliveryProvince;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public boolean isFacilityActive() {
		return facilityActive;
	}

	public void setFacilityActive(boolean facilityActive) {
		this.facilityActive = facilityActive;
	}

	public String getFacilityBed() {
		return facilityBed;
	}

	public void setFacilityBed(String facilityBed) {
		this.facilityBed = facilityBed;
	}

	public Integer getFacilityDepartureDate() {
		return facilityDepartureDate;
	}

	public void setFacilityDepartureDate(Integer facilityDepartureDate) {
		this.facilityDepartureDate = facilityDepartureDate;
	}

	public String getFacilityFloor() {
		return facilityFloor;
	}

	public void setFacilityFloor(String facilityFloor) {
		this.facilityFloor = facilityFloor;
	}

	public Integer getFacilityReturnDate() {
		return facilityReturnDate;
	}

	public void setFacilityReturnDate(Integer facilityReturnDate) {
		this.facilityReturnDate = facilityReturnDate;
	}

	public String getFacilityRoom() {
		return facilityRoom;
	}

	public void setFacilityRoom(String facilityRoom) {
		this.facilityRoom = facilityRoom;
	}

	public String getFacilityTable() {
		return facilityTable;
	}

	public void setFacilityTable(String facilityTable) {
		this.facilityTable = facilityTable;
	}

	public Prescriber getFamilyPhysician() {
		return familyPhysician;
	}

	public void setFamilyPhysician(Prescriber familyPhysician) {
		this.familyPhysician = familyPhysician;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Integer getHeightWeightModificationDate() {
		return heightWeightModificationDate;
	}

	public void setHeightWeightModificationDate(
			Integer heightWeightModificationDate) {
		this.heightWeightModificationDate = heightWeightModificationDate;
	}

	public String getHospitalCardNumber() {
		return hospitalCardNumber;
	}

	public void setHospitalCardNumber(String hospitalCardNumber) {
		this.hospitalCardNumber = hospitalCardNumber;
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

	public boolean isLoyaltyCardActive() {
		return loyaltyCardActive;
	}

	public void setLoyaltyCardActive(boolean loyaltyCardActive) {
		this.loyaltyCardActive = loyaltyCardActive;
	}

	public String getLoyaltyCardNumber() {
		return loyaltyCardNumber;
	}

	public void setLoyaltyCardNumber(String loyaltyCardNumber) {
		this.loyaltyCardNumber = loyaltyCardNumber;
	}

	public Integer getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Integer modificationDate) {
		this.modificationDate = modificationDate;
	}

	public boolean isNoSubstitute() {
		return noSubstitute;
	}

	public void setNoSubstitute(boolean noSubstitute) {
		this.noSubstitute = noSubstitute;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public String getPhnExpiration() {
		return phnExpiration;
	}

	public void setPhnExpiration(String phnExpiration) {
		this.phnExpiration = phnExpiration;
	}

	public String getPhnType() {
		return phnType;
	}

	public void setPhnType(String phnType) {
		this.phnType = phnType;
	}

	public String getPatientFile() {
		return patientFile;
	}

	public void setPatientFile(String patientFile) {
		this.patientFile = patientFile;
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

	public String getReferenceFileNumber() {
		return referenceFileNumber;
	}

	public void setReferenceFileNumber(String referenceFileNumber) {
		this.referenceFileNumber = referenceFileNumber;
	}

	public String getShortRemark() {
		return shortRemark;
	}

	public void setShortRemark(String shortRemark) {
		this.shortRemark = shortRemark;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the birthDateV2
	 */
	public XMLGregorianCalendar getBirthDateV2() {
		return birthDateV2;
	}

	/**
	 * @param birthDateV2 the birthDateV2 to set
	 */
	public void setBirthDateV2(XMLGregorianCalendar birthDateV2) {
		this.birthDateV2 = birthDateV2;
	}

	/**
	 * @return the heightWeightModificationDateV2
	 */
	public XMLGregorianCalendar getHeightWeightModificationDateV2() {
		return heightWeightModificationDateV2;
	}

	/**
	 * @param heightWeightModificationDateV2 the heightWeightModificationDateV2 to set
	 */
	public void setHeightWeightModificationDateV2(
			XMLGregorianCalendar heightWeightModificationDateV2) {
		this.heightWeightModificationDateV2 = heightWeightModificationDateV2;
	}

	/**
	 * @return the creationDateV2
	 */
	public XMLGregorianCalendar getCreationDateV2() {
		return creationDateV2;
	}

	/**
	 * @param creationDateV2 the creationDateV2 to set
	 */
	public void setCreationDateV2(XMLGregorianCalendar creationDateV2) {
		this.creationDateV2 = creationDateV2;
	}

	/**
	 * @return the modificationDateV2
	 */
	public XMLGregorianCalendar getModificationDateV2() {
		return modificationDateV2;
	}

	/**
	 * @param modificationDateV2 the modificationDateV2 to set
	 */
	public void setModificationDateV2(XMLGregorianCalendar modificationDateV2) {
		this.modificationDateV2 = modificationDateV2;
	}

	/**
	 * @return the facilityDepartureDateV2
	 */
	public XMLGregorianCalendar getFacilityDepartureDateV2() {
		return facilityDepartureDateV2;
	}

	/**
	 * @param facilityDepartureDateV2 the facilityDepartureDateV2 to set
	 */
	public void setFacilityDepartureDateV2(
			XMLGregorianCalendar facilityDepartureDateV2) {
		this.facilityDepartureDateV2 = facilityDepartureDateV2;
	}

	/**
	 * @return the facilityReturnDateV2
	 */
	public XMLGregorianCalendar getFacilityReturnDateV2() {
		return facilityReturnDateV2;
	}

	/**
	 * @param facilityReturnDateV2 the facilityReturnDateV2 to set
	 */
	public void setFacilityReturnDateV2(XMLGregorianCalendar facilityReturnDateV2) {
		this.facilityReturnDateV2 = facilityReturnDateV2;
	}

	/**
	 * @return the defaultPharmacy
	 */
	public Pharmacy getDefaultPharmacy() {
		return defaultPharmacy;
	}

	/**
	 * @param defaultPharmacy the defaultPharmacy to set
	 */
	public void setDefaultPharmacy(Pharmacy defaultPharmacy) {
		this.defaultPharmacy = defaultPharmacy;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getPrimaryAddressPostalCode() {
		return primaryAddressPostalCode;
	}

	public void setPrimaryAddressPostalCode(String primaryAddressPostalCode) {
		this.primaryAddressPostalCode = primaryAddressPostalCode;
	}

}
