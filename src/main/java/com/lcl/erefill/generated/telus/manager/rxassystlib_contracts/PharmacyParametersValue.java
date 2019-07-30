
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PharmacyParametersValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacyParametersValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PharmacyParameterValue" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PharmacyParameterValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyParametersValue", propOrder = {
    "pharmacyParameterValue"
})
public class PharmacyParametersValue {

    @XmlElement(name = "PharmacyParameterValue", nillable = true)
    protected List<PharmacyParameterValue> pharmacyParameterValue;

    /**
     * Gets the value of the pharmacyParameterValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pharmacyParameterValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPharmacyParameterValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PharmacyParameterValue }
     * 
     * 
     */
    public List<PharmacyParameterValue> getPharmacyParameterValue() {
        if (pharmacyParameterValue == null) {
            pharmacyParameterValue = new ArrayList<PharmacyParameterValue>();
        }
        return this.pharmacyParameterValue;
    }

}
