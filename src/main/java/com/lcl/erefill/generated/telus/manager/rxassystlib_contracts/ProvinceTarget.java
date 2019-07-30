
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EProvince;


/**
 * <p>Java class for ProvinceTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProvinceTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}HierarchicalTarget">
 *       &lt;sequence>
 *         &lt;element name="Province" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eProvince"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProvinceTarget", propOrder = {
    "province"
})
public class ProvinceTarget
    extends HierarchicalTarget
{

    @XmlElement(name = "Province", required = true)
    protected EProvince province;

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link EProvince }
     *     
     */
    public EProvince getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link EProvince }
     *     
     */
    public void setProvince(EProvince value) {
        this.province = value;
    }

}
