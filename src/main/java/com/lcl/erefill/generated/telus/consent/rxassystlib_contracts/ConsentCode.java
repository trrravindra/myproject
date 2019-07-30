
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.consent.rxassystlib.ConsentType;


/**
 * <p>Java class for ConsentCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsentCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsentType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ConsentType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsentCode", propOrder = {
    "consentType"
})
public class ConsentCode {

    @XmlElement(name = "ConsentType", required = true)
    protected ConsentType consentType;

    /**
     * Gets the value of the consentType property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentType }
     *     
     */
    public ConsentType getConsentType() {
        return consentType;
    }

    /**
     * Sets the value of the consentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentType }
     *     
     */
    public void setConsentType(ConsentType value) {
        this.consentType = value;
    }

}
