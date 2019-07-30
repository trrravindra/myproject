
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EHierarchicalLevel;


/**
 * <p>Java class for HierarchicalTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HierarchicalTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Level" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eHierarchicalLevel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchicalTarget", propOrder = {
    "level"
})
@XmlSeeAlso({
    PharmacyTarget.class,
    ProvinceTarget.class,
    TenantTarget.class,
    RegionTarget.class
})
public class HierarchicalTarget {

    @XmlElement(name = "Level", required = true)
    protected EHierarchicalLevel level;

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link EHierarchicalLevel }
     *     
     */
    public EHierarchicalLevel getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link EHierarchicalLevel }
     *     
     */
    public void setLevel(EHierarchicalLevel value) {
        this.level = value;
    }

}
