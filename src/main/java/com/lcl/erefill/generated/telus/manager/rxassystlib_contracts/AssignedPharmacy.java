
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssignedPharmacy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignedPharmacy">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Pharmacy">
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
@XmlType(name = "AssignedPharmacy", propOrder = {
    "assigned"
})
public class AssignedPharmacy
    extends Pharmacy
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
