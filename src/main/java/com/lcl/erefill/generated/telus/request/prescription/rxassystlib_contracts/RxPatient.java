
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EGender;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.ELanguage;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EProvince;


/**
 * <p>Java class for RxPatient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxPatient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Gender" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGender"/>
 *         &lt;element name="Language" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eLanguage"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PHN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Province" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eProvince"/>
 *         &lt;element name="BirthDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxPatient", propOrder = {
    "address",
    "birthDate",
    "city",
    "firstName",
    "gender",
    "language",
    "lastName",
    "oid",
    "phn",
    "patientFile",
    "phoneNumber",
    "postalCode",
    "province",
    "birthDateV2"
})
public class RxPatient {

    @XmlElement(name = "Address", required = true, nillable = true)
    protected String address;
    @XmlElement(name = "BirthDate")
    protected Integer birthDate;
    @XmlElement(name = "City", required = true, nillable = true)
    protected String city;
    @XmlElement(name = "FirstName", required = true, nillable = true)
    protected String firstName;
    @XmlElement(name = "Gender", required = true)
    protected EGender gender;
    @XmlElement(name = "Language", required = true)
    protected ELanguage language;
    @XmlElement(name = "LastName", required = true, nillable = true)
    protected String lastName;
    @XmlElement(name = "OID", required = true, nillable = true)
    protected String oid;
    @XmlElement(name = "PHN", required = true, nillable = true)
    protected String phn;
    @XmlElement(name = "PatientFile", required = true, nillable = true)
    protected String patientFile;
    @XmlElement(name = "PhoneNumber", required = true, nillable = true)
    protected String phoneNumber;
    @XmlElement(name = "PostalCode", required = true, nillable = true)
    protected String postalCode;
    @XmlElement(name = "Province", required = true)
    protected EProvince province;
    @XmlElementRef(name = "BirthDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> birthDateV2;

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

}
