
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ConsentStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsentStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PatientOID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ConsentStatus.eStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsentStatus", propOrder = {
    "consentId",
    "date",
    "id",
    "patientOID",
    "status"
})
public class ConsentStatus {

    @XmlElement(name = "ConsentId")
    protected int consentId;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "PatientOID", required = true, nillable = true)
    protected String patientOID;
    @XmlElement(name = "Status", required = true)
    protected ConsentStatusEStatus status;

    /**
     * Gets the value of the consentId property.
     * 
     */
    public int getConsentId() {
        return consentId;
    }

    /**
     * Sets the value of the consentId property.
     * 
     */
    public void setConsentId(int value) {
        this.consentId = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the patientOID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientOID() {
        return patientOID;
    }

    /**
     * Sets the value of the patientOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientOID(String value) {
        this.patientOID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentStatusEStatus }
     *     
     */
    public ConsentStatusEStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentStatusEStatus }
     *     
     */
    public void setStatus(ConsentStatusEStatus value) {
        this.status = value;
    }

}
