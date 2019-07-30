
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillReminderCalendars complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefillReminderCalendars">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefillReminderCalendar" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RefillReminderCalendar" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefillReminderCalendars", propOrder = {
    "refillReminderCalendar"
})
public class RefillReminderCalendars {

    @XmlElement(name = "RefillReminderCalendar", nillable = true)
    protected List<RefillReminderCalendar> refillReminderCalendar;

    /**
     * Gets the value of the refillReminderCalendar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refillReminderCalendar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefillReminderCalendar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefillReminderCalendar }
     * 
     * 
     */
    public List<RefillReminderCalendar> getRefillReminderCalendar() {
        if (refillReminderCalendar == null) {
            refillReminderCalendar = new ArrayList<RefillReminderCalendar>();
        }
        return this.refillReminderCalendar;
    }

}
