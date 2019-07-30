
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FacilityAssigned complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityAssigned">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Facility">
 *       &lt;sequence>
 *         &lt;element name="Assigned" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityAssigned", propOrder = {
    "assigned"
})
public class FacilityAssigned
    extends Facility
{

    @XmlElement(name = "Assigned")
    protected boolean assigned;

    /**
     * Gets the value of the assigned property.
     * 
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * Sets the value of the assigned property.
     * 
     */
    public void setAssigned(boolean value) {
        this.assigned = value;
    }

}
