
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsentStatuses complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsentStatuses">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Consents" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ArrayOfConsent"/>
 *         &lt;element name="Statuses" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ArrayOfConsentStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsentStatuses", propOrder = {
    "consents",
    "statuses"
})
public class ConsentStatuses {

    @XmlElement(name = "Consents", required = true, nillable = true)
    protected ArrayOfConsent consents;
    @XmlElement(name = "Statuses", required = true, nillable = true)
    protected ArrayOfConsentStatus statuses;

    /**
     * Gets the value of the consents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConsent }
     *     
     */
    public ArrayOfConsent getConsents() {
        return consents;
    }

    /**
     * Sets the value of the consents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConsent }
     *     
     */
    public void setConsents(ArrayOfConsent value) {
        this.consents = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConsentStatus }
     *     
     */
    public ArrayOfConsentStatus getStatuses() {
        return statuses;
    }

    /**
     * Sets the value of the statuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConsentStatus }
     *     
     */
    public void setStatuses(ArrayOfConsentStatus value) {
        this.statuses = value;
    }

}
