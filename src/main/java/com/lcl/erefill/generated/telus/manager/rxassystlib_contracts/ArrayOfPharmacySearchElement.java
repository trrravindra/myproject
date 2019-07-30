
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPharmacySearchElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPharmacySearchElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PharmacySearchElement" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PharmacySearchElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPharmacySearchElement", propOrder = {
    "pharmacySearchElement"
})
public class ArrayOfPharmacySearchElement {

    @XmlElement(name = "PharmacySearchElement", nillable = true)
    protected List<PharmacySearchElement> pharmacySearchElement;

    /**
     * Gets the value of the pharmacySearchElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pharmacySearchElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPharmacySearchElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PharmacySearchElement }
     * 
     * 
     */
    public List<PharmacySearchElement> getPharmacySearchElement() {
        if (pharmacySearchElement == null) {
            pharmacySearchElement = new ArrayList<PharmacySearchElement>();
        }
        return this.pharmacySearchElement;
    }

}
