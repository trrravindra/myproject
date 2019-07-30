
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.operation.rxassystlib.ERestriction;


/**
 * <p>Java class for PrescriptionRestriction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrescriptionRestriction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRestriction"/>
 *         &lt;element name="RefillAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RequireETA" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrescriptionRestriction", propOrder = {
    "type",
    "refillAllowed",
    "requireETA"
})
public class PrescriptionRestriction {

    @XmlElement(name = "Type", required = true)
    protected ERestriction type;
    @XmlElement(name = "RefillAllowed")
    protected boolean refillAllowed;
    @XmlElement(name = "RequireETA")
    protected boolean requireETA;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ERestriction }
     *     
     */
    public ERestriction getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERestriction }
     *     
     */
    public void setType(ERestriction value) {
        this.type = value;
    }

    /**
     * Gets the value of the refillAllowed property.
     * 
     */
    public boolean isRefillAllowed() {
        return refillAllowed;
    }

    /**
     * Sets the value of the refillAllowed property.
     * 
     */
    public void setRefillAllowed(boolean value) {
        this.refillAllowed = value;
    }

    /**
     * Gets the value of the requireETA property.
     * 
     */
    public boolean isRequireETA() {
        return requireETA;
    }

    /**
     * Sets the value of the requireETA property.
     * 
     */
    public void setRequireETA(boolean value) {
        this.requireETA = value;
    }

}
