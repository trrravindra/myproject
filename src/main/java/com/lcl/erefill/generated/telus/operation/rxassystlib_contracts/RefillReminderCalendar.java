
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillReminderCalendar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefillReminderCalendar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExpectedEvents" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ArrayOfExpectedEvent"/>
 *         &lt;element name="OriginalPrescriptionOID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefillReminderCalendar", propOrder = {
    "expectedEvents",
    "originalPrescriptionOID"
})
public class RefillReminderCalendar {

    @XmlElement(name = "ExpectedEvents", required = true, nillable = true)
    protected ArrayOfExpectedEvent expectedEvents;
    @XmlElement(name = "OriginalPrescriptionOID", required = true, nillable = true)
    protected String originalPrescriptionOID;

    /**
     * Gets the value of the expectedEvents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfExpectedEvent }
     *     
     */
    public ArrayOfExpectedEvent getExpectedEvents() {
        return expectedEvents;
    }

    /**
     * Sets the value of the expectedEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfExpectedEvent }
     *     
     */
    public void setExpectedEvents(ArrayOfExpectedEvent value) {
        this.expectedEvents = value;
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

}
