
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatientContacts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientContacts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientContact" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PatientContact" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientContacts", propOrder = {
    "patientContact"
})
public class PatientContacts {

    @XmlElement(name = "PatientContact", nillable = true)
    protected List<PatientContact> patientContact;

    /**
     * Gets the value of the patientContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the patientContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPatientContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PatientContact }
     * 
     * 
     */
    public List<PatientContact> getPatientContact() {
        if (patientContact == null) {
            patientContact = new ArrayList<PatientContact>();
        }
        return this.patientContact;
    }

}
