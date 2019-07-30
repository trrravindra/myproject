
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RxRenewPrescriptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxRenewPrescriptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RxRenewPrescription" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxRenewPrescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxRenewPrescriptions", propOrder = {
    "rxRenewPrescription"
})
public class RxRenewPrescriptions {

    @XmlElement(name = "RxRenewPrescription", nillable = true)
    protected List<RxRenewPrescription> rxRenewPrescription;

    /**
     * Gets the value of the rxRenewPrescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rxRenewPrescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRxRenewPrescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RxRenewPrescription }
     * 
     * 
     */
    public List<RxRenewPrescription> getRxRenewPrescription() {
        if (rxRenewPrescription == null) {
            rxRenewPrescription = new ArrayList<RxRenewPrescription>();
        }
        return this.rxRenewPrescription;
    }

}
