
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrescriptionRestrictions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrescriptionRestrictions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrescriptionRestriction" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PrescriptionRestriction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrescriptionRestrictions", propOrder = {
    "prescriptionRestriction"
})
public class PrescriptionRestrictions {

    @XmlElement(name = "PrescriptionRestriction", nillable = true)
    protected List<PrescriptionRestriction> prescriptionRestriction;

    /**
     * Gets the value of the prescriptionRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prescriptionRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrescriptionRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrescriptionRestriction }
     * 
     * 
     */
    public List<PrescriptionRestriction> getPrescriptionRestriction() {
        if (prescriptionRestriction == null) {
            prescriptionRestriction = new ArrayList<PrescriptionRestriction>();
        }
        return this.prescriptionRestriction;
    }

}
