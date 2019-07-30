
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EMedReleaseMode;


/**
 * <p>Java class for MedReleaseMode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MedReleaseMode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eMedReleaseMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedReleaseMode", propOrder = {
    "mode"
})
public class MedReleaseMode {

    @XmlElement(name = "Mode")
    protected EMedReleaseMode mode;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link EMedReleaseMode }
     *     
     */
    public EMedReleaseMode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EMedReleaseMode }
     *     
     */
    public void setMode(EMedReleaseMode value) {
        this.mode = value;
    }

}
