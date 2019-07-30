
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillReminder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefillReminder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BufferTimehours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OperationalEvent" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}OperationalEvent"/>
 *         &lt;element name="OriginalPrescriptionOID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MobilePhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefillReminder", propOrder = {
    "bufferTimehours",
    "operationalEvent",
    "originalPrescriptionOID",
    "mobilePhoneNumber",
    "email"
})
public class RefillReminder {

    @XmlElement(name = "BufferTimehours")
    protected int bufferTimehours;
    @XmlElement(name = "OperationalEvent", required = true, nillable = true)
    protected OperationalEvent operationalEvent;
    @XmlElement(name = "OriginalPrescriptionOID", required = true, nillable = true)
    protected String originalPrescriptionOID;
    @XmlElementRef(name = "MobilePhoneNumber", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> mobilePhoneNumber;
    @XmlElementRef(name = "Email", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> email;

    /**
     * Gets the value of the bufferTimehours property.
     * 
     */
    public int getBufferTimehours() {
        return bufferTimehours;
    }

    /**
     * Sets the value of the bufferTimehours property.
     * 
     */
    public void setBufferTimehours(int value) {
        this.bufferTimehours = value;
    }

    /**
     * Gets the value of the operationalEvent property.
     * 
     * @return
     *     possible object is
     *     {@link OperationalEvent }
     *     
     */
    public OperationalEvent getOperationalEvent() {
        return operationalEvent;
    }

    /**
     * Sets the value of the operationalEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalEvent }
     *     
     */
    public void setOperationalEvent(OperationalEvent value) {
        this.operationalEvent = value;
    }

    /**
     * Gets the value of the originalPrescriptionOID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPrescriptionOID() {
        return originalPrescriptionOID;
    }

    /**
     * Sets the value of the originalPrescriptionOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPrescriptionOID(String value) {
        this.originalPrescriptionOID = value;
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

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmail(JAXBElement<String> value) {
        this.email = value;
    }

}
