
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.session.rxassystlib.EVerifyIdentityReason;


/**
 * <p>Java class for VerifyIdentityReason complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerifyIdentityReason">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentityReason" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eVerifyIdentityReason"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyIdentityReason", propOrder = {
    "identityReason"
})
public class VerifyIdentityReason {

    @XmlElement(name = "IdentityReason", required = true)
    protected EVerifyIdentityReason identityReason;

    /**
     * Gets the value of the identityReason property.
     * 
     * @return
     *     possible object is
     *     {@link EVerifyIdentityReason }
     *     
     */
    public EVerifyIdentityReason getIdentityReason() {
        return identityReason;
    }

    /**
     * Sets the value of the identityReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link EVerifyIdentityReason }
     *     
     */
    public void setIdentityReason(EVerifyIdentityReason value) {
        this.identityReason = value;
    }

}
