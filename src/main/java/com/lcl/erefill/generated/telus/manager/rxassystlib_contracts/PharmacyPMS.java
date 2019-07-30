
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EPMS;


/**
 * <p>Java class for PharmacyPMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacyPMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PMS" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ePMS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyPMS", propOrder = {
    "pms"
})
public class PharmacyPMS {

    @XmlElement(name = "PMS", required = true)
    protected EPMS pms;

    /**
     * Gets the value of the pms property.
     * 
     * @return
     *     possible object is
     *     {@link EPMS }
     *     
     */
    public EPMS getPMS() {
        return pms;
    }

    /**
     * Sets the value of the pms property.
     * 
     * @param value
     *     allowed object is
     *     {@link EPMS }
     *     
     */
    public void setPMS(EPMS value) {
        this.pms = value;
    }

}
