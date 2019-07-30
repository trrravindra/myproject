
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EFamilyManagerAssignRequestState;


/**
 * <p>Java class for FamilyManagerRequestState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FamilyManagerRequestState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eFamilyManagerAssignRequestState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyManagerRequestState", propOrder = {
    "state"
})
public class FamilyManagerRequestState {

    @XmlElement(name = "State", required = true)
    protected EFamilyManagerAssignRequestState state;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link EFamilyManagerAssignRequestState }
     *     
     */
    public EFamilyManagerAssignRequestState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link EFamilyManagerAssignRequestState }
     *     
     */
    public void setState(EFamilyManagerAssignRequestState value) {
        this.state = value;
    }

}
