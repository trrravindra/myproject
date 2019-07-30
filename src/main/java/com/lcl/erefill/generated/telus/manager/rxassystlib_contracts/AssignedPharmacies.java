
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssignedPharmacies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignedPharmacies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssignedPharmacy" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}AssignedPharmacy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignedPharmacies", propOrder = {
    "assignedPharmacy"
})
public class AssignedPharmacies {

    @XmlElement(name = "AssignedPharmacy", nillable = true)
    protected List<AssignedPharmacy> assignedPharmacy;

    /**
     * Gets the value of the assignedPharmacy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignedPharmacy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignedPharmacy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssignedPharmacy }
     * 
     * 
     */
    public List<AssignedPharmacy> getAssignedPharmacy() {
        if (assignedPharmacy == null) {
            assignedPharmacy = new ArrayList<AssignedPharmacy>();
        }
        return this.assignedPharmacy;
    }

}
