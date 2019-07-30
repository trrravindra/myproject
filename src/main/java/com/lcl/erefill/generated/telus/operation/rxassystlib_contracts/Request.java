
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EMedReleaseMode;
import com.lcl.erefill.generated.telus.operation.rxassystlib.ERequestState;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Delivery" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RequestDelivery"/>
 *         &lt;element name="EMail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LastState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRequestState"/>
 *         &lt;element name="LastStateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MedReleaseMode" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eMedReleaseMode"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PharmacyContractNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReleaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobilePhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "comments",
    "delivery",
    "eMail",
    "lastState",
    "lastStateDate",
    "medReleaseMode",
    "oid",
    "pharmacyContractNumber",
    "releaseDate",
    "phone",
    "mobilePhoneNumber"
})
@XmlSeeAlso({
    RxNewRequest.class
})
public class Request {

    @XmlElement(name = "Comments", required = true, nillable = true)
    protected String comments;
    @XmlElement(name = "Delivery", required = true, nillable = true)
    protected RequestDelivery delivery;
    @XmlElement(name = "EMail", required = true, nillable = true)
    protected String eMail;
    @XmlElement(name = "LastState", required = true)
    protected ERequestState lastState;
    @XmlElement(name = "LastStateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastStateDate;
    @XmlElement(name = "MedReleaseMode", required = true)
    protected EMedReleaseMode medReleaseMode;
    @XmlElementRef(name = "OID", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> oid;
    @XmlElement(name = "PharmacyContractNumber", required = true, nillable = true)
    protected String pharmacyContractNumber;
    @XmlElement(name = "ReleaseDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar releaseDate;
    @XmlElementRef(name = "Phone", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> phone;
    @XmlElementRef(name = "MobilePhoneNumber", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> mobilePhoneNumber;

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
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link RequestDelivery }
     *     
     */
    public RequestDelivery getDelivery() {
        return delivery;
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestDelivery }
     *     
     */
    public void setDelivery(RequestDelivery value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the eMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Sets the value of the eMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMail(String value) {
        this.eMail = value;
    }

    /**
     * Gets the value of the lastState property.
     * 
     * @return
     *     possible object is
     *     {@link ERequestState }
     *     
     */
    public ERequestState getLastState() {
        return lastState;
    }

    /**
     * Sets the value of the lastState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERequestState }
     *     
     */
    public void setLastState(ERequestState value) {
        this.lastState = value;
    }

    /**
     * Gets the value of the lastStateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastStateDate() {
        return lastStateDate;
    }

    /**
     * Sets the value of the lastStateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastStateDate(XMLGregorianCalendar value) {
        this.lastStateDate = value;
    }

    /**
     * Gets the value of the medReleaseMode property.
     * 
     * @return
     *     possible object is
     *     {@link EMedReleaseMode }
     *     
     */
    public EMedReleaseMode getMedReleaseMode() {
        return medReleaseMode;
    }

    /**
     * Sets the value of the medReleaseMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EMedReleaseMode }
     *     
     */
    public void setMedReleaseMode(EMedReleaseMode value) {
        this.medReleaseMode = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOID() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOID(JAXBElement<String> value) {
        this.oid = value;
    }

    /**
     * Gets the value of the pharmacyContractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPharmacyContractNumber() {
        return pharmacyContractNumber;
    }

    /**
     * Sets the value of the pharmacyContractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPharmacyContractNumber(String value) {
        this.pharmacyContractNumber = value;
    }

    /**
     * Gets the value of the releaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReleaseDate(XMLGregorianCalendar value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhone(JAXBElement<String> value) {
        this.phone = value;
    }

    /**
     * Gets the value of the mobilePhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /**
     * Sets the value of the mobilePhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMobilePhoneNumber(JAXBElement<String> value) {
        this.mobilePhoneNumber = value;
    }

}
