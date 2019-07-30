
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillReminders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefillReminders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefillReminder" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RefillReminder" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefillReminders", propOrder = {
    "refillReminder"
})
public class RefillReminders {

    @XmlElement(name = "RefillReminder", nillable = true)
    protected List<RefillReminder> refillReminder;

    /**
     * Gets the value of the refillReminder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refillReminder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefillReminder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefillReminder }
     * 
     * 
     */
    public List<RefillReminder> getRefillReminder() {
        if (refillReminder == null) {
            refillReminder = new ArrayList<RefillReminder>();
        }
        return this.refillReminder;
    }

}
