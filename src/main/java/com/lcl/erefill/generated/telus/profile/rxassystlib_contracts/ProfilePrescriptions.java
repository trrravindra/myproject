
package com.lcl.erefill.generated.telus.profile.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfilePrescriptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfilePrescriptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfilePrescription" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ProfilePrescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilePrescriptions", propOrder = {
    "profilePrescription"
})
public class ProfilePrescriptions {

    @XmlElement(name = "ProfilePrescription", nillable = true)
    protected List<ProfilePrescription> profilePrescription;

    /**
     * Gets the value of the profilePrescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profilePrescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfilePrescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfilePrescription }
     * 
     * 
     */
    public List<ProfilePrescription> getProfilePrescription() {
        if (profilePrescription == null) {
            profilePrescription = new ArrayList<ProfilePrescription>();
        }
        return this.profilePrescription;
    }

}
