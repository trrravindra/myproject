
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatientModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthorizeOnlineBilling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientModule", propOrder = {
    "authorizeOnlineBilling"
})
public class PatientModule {

    @XmlElement(name = "AuthorizeOnlineBilling")
    protected boolean authorizeOnlineBilling;

    /**
     * Gets the value of the authorizeOnlineBilling property.
     * 
     */
    public boolean isAuthorizeOnlineBilling() {
        return authorizeOnlineBilling;
    }

    /**
     * Sets the value of the authorizeOnlineBilling property.
     * 
     */
    public void setAuthorizeOnlineBilling(boolean value) {
        this.authorizeOnlineBilling = value;
    }

}
