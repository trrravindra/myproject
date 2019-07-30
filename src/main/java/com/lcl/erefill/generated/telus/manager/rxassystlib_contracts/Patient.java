
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EGender;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ELanguage;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EPHNType;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EProvince;


/**
 * <p>Java class for Patient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Patient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Accounts" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PatientAccounts"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Contacts" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PatientContacts"/>
 *         &lt;element name="CreatinineClearance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DISExcluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DISKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Deceased" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DeliveryActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DeliveryAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryComments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryPostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryProvince" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eProvince"/>
 *         &lt;element name="Facility" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Facility"/>
 *         &lt;element name="FacilityActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FacilityBed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityDepartureDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FacilityFloor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityReturnDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FacilityRoom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityTable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FamilyPhysician" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Prescriber"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Gender" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGender"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HeightWeightModificationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HospitalCardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Language" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eLanguage"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LoyaltyCardActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LoyaltyCardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ModificationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NoSubstitute" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PHN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PHNExpiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PHNType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ePHNType"/>
 *         &lt;element name="PatientFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Province" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eProvince"/>
 *         &lt;element name="ReferenceFileNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShortRemark" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WorkPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BirthDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="HeightWeightModificationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CreationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ModificationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FacilityDepartureDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FacilityReturnDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DefaultPharmacy" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Pharmacy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Patient", propOrder = {
    "accounts",
    "address",
    "alias",
    "birthDate",
    "city",
    "comments",
    "contacts",
    "creatinineClearance",
    "creationDate",
    "disExcluded",
    "disKey",
    "deceased",
    "deliveryActive",
    "deliveryAddress",
    "deliveryCity",
    "deliveryComments",
    "deliveryPhoneNumber",
    "deliveryPostalCode",
    "deliveryProvince",
    "facility",
    "facilityActive",
    "facilityBed",
    "facilityDepartureDate",
    "facilityFloor",
    "facilityReturnDate",
    "facilityRoom",
    "facilityTable",
    "familyPhysician",
    "firstName",
    "gender",
    "height",
    "heightWeightModificationDate",
    "hospitalCardNumber",
    "language",
    "lastName",
    "loyaltyCardActive",
    "loyaltyCardNumber",
    "modificationDate",
    "noSubstitute",
    "oid",
    "phn",
    "phnExpiration",
    "phnType",
    "patientFile",
    "phoneNumber",
    "postalCode",
    "province",
    "referenceFileNumber",
    "shortRemark",
    "userName",
    "weight",
    "workPhoneNumber",
    "birthDateV2",
    "heightWeightModificationDateV2",
    "creationDateV2",
    "modificationDateV2",
    "facilityDepartureDateV2",
    "facilityReturnDateV2",
    "defaultPharmacy"
})
@XmlSeeAlso({
    PatientAssigned.class
})
public class Patient {

    @XmlElement(name = "Accounts", required = true, nillable = true)
    protected PatientAccounts accounts;
    @XmlElement(name = "Address", required = true, nillable = true)
    protected String address;
    @XmlElement(name = "Alias", required = true, nillable = true)
    protected String alias;
    @XmlElement(name = "BirthDate")
    protected Integer birthDate;
    @XmlElement(name = "City", required = true, nillable = true)
    protected String city;
    @XmlElement(name = "Comments", required = true, nillable = true)
    protected String comments;
    @XmlElement(name = "Contacts", required = true, nillable = true)
    protected PatientContacts contacts;
    @XmlElement(name = "CreatinineClearance")
    protected int creatinineClearance;
    @XmlElement(name = "CreationDate")
    protected Integer creationDate;
    @XmlElement(name = "DISExcluded")
    protected boolean disExcluded;
    @XmlElement(name = "DISKey", required = true, nillable = true)
    protected String disKey;
    @XmlElement(name = "Deceased")
    protected boolean deceased;
    @XmlElement(name = "DeliveryActive")
    protected boolean deliveryActive;
    @XmlElement(name = "DeliveryAddress", required = true, nillable = true)
    protected String deliveryAddress;
    @XmlElement(name = "DeliveryCity", required = true, nillable = true)
    protected String deliveryCity;
    @XmlElement(name = "DeliveryComments", required = true, nillable = true)
    protected String deliveryComments;
    @XmlElement(name = "DeliveryPhoneNumber", required = true, nillable = true)
    protected String deliveryPhoneNumber;
    @XmlElement(name = "DeliveryPostalCode", required = true, nillable = true)
    protected String deliveryPostalCode;
    @XmlElement(name = "DeliveryProvince", required = true)
    protected EProvince deliveryProvince;
    @XmlElement(name = "Facility", required = true, nillable = true)
    protected Facility facility;
    @XmlElement(name = "FacilityActive")
    protected boolean facilityActive;
    @XmlElement(name = "FacilityBed", required = true, nillable = true)
    protected String facilityBed;
    @XmlElement(name = "FacilityDepartureDate")
    protected Integer facilityDepartureDate;
    @XmlElement(name = "FacilityFloor", required = true, nillable = true)
    protected String facilityFloor;
    @XmlElement(name = "FacilityReturnDate")
    protected Integer facilityReturnDate;
    @XmlElement(name = "FacilityRoom", required = true, nillable = true)
    protected String facilityRoom;
    @XmlElement(name = "FacilityTable", required = true, nillable = true)
    protected String facilityTable;
    @XmlElement(name = "FamilyPhysician", required = true, nillable = true)
    protected Prescriber familyPhysician;
    @XmlElement(name = "FirstName", required = true, nillable = true)
    protected String firstName;
    @XmlElement(name = "Gender", required = true)
    protected EGender gender;
    @XmlElement(name = "Height")
    protected int height;
    @XmlElement(name = "HeightWeightModificationDate")
    protected Integer heightWeightModificationDate;
    @XmlElement(name = "HospitalCardNumber", required = true, nillable = true)
    protected String hospitalCardNumber;
    @XmlElement(name = "Language", required = true)
    protected ELanguage language;
    @XmlElement(name = "LastName", required = true, nillable = true)
    protected String lastName;
    @XmlElement(name = "LoyaltyCardActive")
    protected boolean loyaltyCardActive;
    @XmlElement(name = "LoyaltyCardNumber", required = true, nillable = true)
    protected String loyaltyCardNumber;
    @XmlElement(name = "ModificationDate")
    protected Integer modificationDate;
    @XmlElement(name = "NoSubstitute")
    protected boolean noSubstitute;
    @XmlElement(name = "OID", required = true, nillable = true)
    protected String oid;
    @XmlElement(name = "PHN", required = true, nillable = true)
    protected String phn;
    @XmlElement(name = "PHNExpiration", required = true, nillable = true)
    protected String phnExpiration;
    @XmlElement(name = "PHNType", required = true)
    protected EPHNType phnType;
    @XmlElement(name = "PatientFile", required = true, nillable = true)
    protected String patientFile;
    @XmlElement(name = "PhoneNumber", required = true, nillable = true)
    protected String phoneNumber;
    @XmlElement(name = "PostalCode", required = true, nillable = true)
    protected String postalCode;
    @XmlElement(name = "Province", required = true)
    protected EProvince province;
    @XmlElement(name = "ReferenceFileNumber", required = true, nillable = true)
    protected String referenceFileNumber;
    @XmlElement(name = "ShortRemark", required = true, nillable = true)
    protected String shortRemark;
    @XmlElementRef(name = "UserName", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> userName;
    @XmlElement(name = "Weight")
    protected int weight;
    @XmlElement(name = "WorkPhoneNumber", required = true, nillable = true)
    protected String workPhoneNumber;
    @XmlElementRef(name = "BirthDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> birthDateV2;
    @XmlElementRef(name = "HeightWeightModificationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> heightWeightModificationDateV2;
    @XmlElementRef(name = "CreationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> creationDateV2;
    @XmlElementRef(name = "ModificationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> modificationDateV2;
    @XmlElementRef(name = "FacilityDepartureDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> facilityDepartureDateV2;
    @XmlElementRef(name = "FacilityReturnDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> facilityReturnDateV2;
    @XmlElementRef(name = "DefaultPharmacy", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<Pharmacy> defaultPharmacy;

    /**
     * Gets the value of the accounts property.
     * 
     * @return
     *     possible object is
     *     {@link PatientAccounts }
     *     
     */
    public PatientAccounts getAccounts() {
        return accounts;
    }

    /**
     * Sets the value of the accounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientAccounts }
     *     
     */
    public void setAccounts(PatientAccounts value) {
        this.accounts = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBirthDate(Integer value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link PatientContacts }
     *     
     */
    public PatientContacts getContacts() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientContacts }
     *     
     */
    public void setContacts(PatientContacts value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the creatinineClearance property.
     * 
     */
    public int getCreatinineClearance() {
        return creatinineClearance;
    }

    /**
     * Sets the value of the creatinineClearance property.
     * 
     */
    public void setCreatinineClearance(int value) {
        this.creatinineClearance = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCreationDate(Integer value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the disExcluded property.
     * 
     */
    public boolean isDISExcluded() {
        return disExcluded;
    }

    /**
     * Sets the value of the disExcluded property.
     * 
     */
    public void setDISExcluded(boolean value) {
        this.disExcluded = value;
    }

    /**
     * Gets the value of the disKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISKey() {
        return disKey;
    }

    /**
     * Sets the value of the disKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISKey(String value) {
        this.disKey = value;
    }

    /**
     * Gets the value of the deceased property.
     * 
     */
    public boolean isDeceased() {
        return deceased;
    }

    /**
     * Sets the value of the deceased property.
     * 
     */
    public void setDeceased(boolean value) {
        this.deceased = value;
    }

    /**
     * Gets the value of the deliveryActive property.
     * 
     */
    public boolean isDeliveryActive() {
        return deliveryActive;
    }

    /**
     * Sets the value of the deliveryActive property.
     * 
     */
    public void setDeliveryActive(boolean value) {
        this.deliveryActive = value;
    }

    /**
     * Gets the value of the deliveryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the value of the deliveryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryAddress(String value) {
        this.deliveryAddress = value;
    }

    /**
     * Gets the value of the deliveryCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryCity() {
        return deliveryCity;
    }

    /**
     * Sets the value of the deliveryCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryCity(String value) {
        this.deliveryCity = value;
    }

    /**
     * Gets the value of the deliveryComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryComments() {
        return deliveryComments;
    }

    /**
     * Sets the value of the deliveryComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryComments(String value) {
        this.deliveryComments = value;
    }

    /**
     * Gets the value of the deliveryPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryPhoneNumber() {
        return deliveryPhoneNumber;
    }

    /**
     * Sets the value of the deliveryPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryPhoneNumber(String value) {
        this.deliveryPhoneNumber = value;
    }

    /**
     * Gets the value of the deliveryPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    /**
     * Sets the value of the deliveryPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryPostalCode(String value) {
        this.deliveryPostalCode = value;
    }

    /**
     * Gets the value of the deliveryProvince property.
     * 
     * @return
     *     possible object is
     *     {@link EProvince }
     *     
     */
    public EProvince getDeliveryProvince() {
        return deliveryProvince;
    }

    /**
     * Sets the value of the deliveryProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link EProvince }
     *     
     */
    public void setDeliveryProvince(EProvince value) {
        this.deliveryProvince = value;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link Facility }
     *     
     */
    public Facility getFacility() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Facility }
     *     
     */
    public void setFacility(Facility value) {
        this.facility = value;
    }

    /**
     * Gets the value of the facilityActive property.
     * 
     */
    public boolean isFacilityActive() {
        return facilityActive;
    }

    /**
     * Sets the value of the facilityActive property.
     * 
     */
    public void setFacilityActive(boolean value) {
        this.facilityActive = value;
    }

    /**
     * Gets the value of the facilityBed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityBed() {
        return facilityBed;
    }

    /**
     * Sets the value of the facilityBed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityBed(String value) {
        this.facilityBed = value;
    }

    /**
     * Gets the value of the facilityDepartureDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFacilityDepartureDate() {
        return facilityDepartureDate;
    }

    /**
     * Sets the value of the facilityDepartureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFacilityDepartureDate(Integer value) {
        this.facilityDepartureDate = value;
    }

    /**
     * Gets the value of the facilityFloor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityFloor() {
        return facilityFloor;
    }

    /**
     * Sets the value of the facilityFloor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityFloor(String value) {
        this.facilityFloor = value;
    }

    /**
     * Gets the value of the facilityReturnDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFacilityReturnDate() {
        return facilityReturnDate;
    }

    /**
     * Sets the value of the facilityReturnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFacilityReturnDate(Integer value) {
        this.facilityReturnDate = value;
    }

    /**
     * Gets the value of the facilityRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityRoom() {
        return facilityRoom;
    }

    /**
     * Sets the value of the facilityRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityRoom(String value) {
        this.facilityRoom = value;
    }

    /**
     * Gets the value of the facilityTable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityTable() {
        return facilityTable;
    }

    /**
     * Sets the value of the facilityTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityTable(String value) {
        this.facilityTable = value;
    }

    /**
     * Gets the value of the familyPhysician property.
     * 
     * @return
     *     possible object is
     *     {@link Prescriber }
     *     
     */
    public Prescriber getFamilyPhysician() {
        return familyPhysician;
    }

    /**
     * Sets the value of the familyPhysician property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prescriber }
     *     
     */
    public void setFamilyPhysician(Prescriber value) {
        this.familyPhysician = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link EGender }
     *     
     */
    public EGender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGender }
     *     
     */
    public void setGender(EGender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Gets the value of the heightWeightModificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHeightWeightModificationDate() {
        return heightWeightModificationDate;
    }

    /**
     * Sets the value of the heightWeightModificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHeightWeightModificationDate(Integer value) {
        this.heightWeightModificationDate = value;
    }

    /**
     * Gets the value of the hospitalCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalCardNumber() {
        return hospitalCardNumber;
    }

    /**
     * Sets the value of the hospitalCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalCardNumber(String value) {
        this.hospitalCardNumber = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link ELanguage }
     *     
     */
    public ELanguage getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link ELanguage }
     *     
     */
    public void setLanguage(ELanguage value) {
        this.language = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the loyaltyCardActive property.
     * 
     */
    public boolean isLoyaltyCardActive() {
        return loyaltyCardActive;
    }

    /**
     * Sets the value of the loyaltyCardActive property.
     * 
     */
    public void setLoyaltyCardActive(boolean value) {
        this.loyaltyCardActive = value;
    }

    /**
     * Gets the value of the loyaltyCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyCardNumber() {
        return loyaltyCardNumber;
    }

    /**
     * Sets the value of the loyaltyCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyCardNumber(String value) {
        this.loyaltyCardNumber = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModificationDate(Integer value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the noSubstitute property.
     * 
     */
    public boolean isNoSubstitute() {
        return noSubstitute;
    }

    /**
     * Sets the value of the noSubstitute property.
     * 
     */
    public void setNoSubstitute(boolean value) {
        this.noSubstitute = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOID() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOID(String value) {
        this.oid = value;
    }

    /**
     * Gets the value of the phn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHN() {
        return phn;
    }

    /**
     * Sets the value of the phn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHN(String value) {
        this.phn = value;
    }

    /**
     * Gets the value of the phnExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHNExpiration() {
        return phnExpiration;
    }

    /**
     * Sets the value of the phnExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHNExpiration(String value) {
        this.phnExpiration = value;
    }

    /**
     * Gets the value of the phnType property.
     * 
     * @return
     *     possible object is
     *     {@link EPHNType }
     *     
     */
    public EPHNType getPHNType() {
        return phnType;
    }

    /**
     * Sets the value of the phnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EPHNType }
     *     
     */
    public void setPHNType(EPHNType value) {
        this.phnType = value;
    }

    /**
     * Gets the value of the patientFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientFile() {
        return patientFile;
    }

    /**
     * Sets the value of the patientFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientFile(String value) {
        this.patientFile = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link EProvince }
     *     
     */
    public EProvince getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link EProvince }
     *     
     */
    public void setProvince(EProvince value) {
        this.province = value;
    }

    /**
     * Gets the value of the referenceFileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceFileNumber() {
        return referenceFileNumber;
    }

    /**
     * Sets the value of the referenceFileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceFileNumber(String value) {
        this.referenceFileNumber = value;
    }

    /**
     * Gets the value of the shortRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortRemark() {
        return shortRemark;
    }

    /**
     * Sets the value of the shortRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortRemark(String value) {
        this.shortRemark = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserName(JAXBElement<String> value) {
        this.userName = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(int value) {
        this.weight = value;
    }

    /**
     * Gets the value of the workPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    /**
     * Sets the value of the workPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPhoneNumber(String value) {
        this.workPhoneNumber = value;
    }

    /**
     * Gets the value of the birthDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBirthDateV2() {
        return birthDateV2;
    }

    /**
     * Sets the value of the birthDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBirthDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.birthDateV2 = value;
    }

    /**
     * Gets the value of the heightWeightModificationDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getHeightWeightModificationDateV2() {
        return heightWeightModificationDateV2;
    }

    /**
     * Sets the value of the heightWeightModificationDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setHeightWeightModificationDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.heightWeightModificationDateV2 = value;
    }

    /**
     * Gets the value of the creationDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getCreationDateV2() {
        return creationDateV2;
    }

    /**
     * Sets the value of the creationDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setCreationDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.creationDateV2 = value;
    }

    /**
     * Gets the value of the modificationDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getModificationDateV2() {
        return modificationDateV2;
    }

    /**
     * Sets the value of the modificationDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setModificationDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.modificationDateV2 = value;
    }

    /**
     * Gets the value of the facilityDepartureDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFacilityDepartureDateV2() {
        return facilityDepartureDateV2;
    }

    /**
     * Sets the value of the facilityDepartureDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFacilityDepartureDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.facilityDepartureDateV2 = value;
    }

    /**
     * Gets the value of the facilityReturnDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFacilityReturnDateV2() {
        return facilityReturnDateV2;
    }

    /**
     * Sets the value of the facilityReturnDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFacilityReturnDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.facilityReturnDateV2 = value;
    }

    /**
     * Gets the value of the defaultPharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Pharmacy }{@code >}
     *     
     */
    public JAXBElement<Pharmacy> getDefaultPharmacy() {
        return defaultPharmacy;
    }

    /**
     * Sets the value of the defaultPharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Pharmacy }{@code >}
     *     
     */
    public void setDefaultPharmacy(JAXBElement<Pharmacy> value) {
        this.defaultPharmacy = value;
    }

}
