
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Physicians complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Physicians">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Physician" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Physician" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Physicians", propOrder = {
    "physician"
})
public class Physicians {

    @XmlElement(name = "Physician", nillable = true)
    protected List<Physician> physician;

    /**
     * Gets the value of the physician property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physician property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysician().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Physician }
     * 
     * 
     */
    public List<Physician> getPhysician() {
        if (physician == null) {
            physician = new ArrayList<Physician>();
        }
        return this.physician;
    }

}
