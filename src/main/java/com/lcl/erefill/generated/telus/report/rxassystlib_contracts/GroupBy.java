
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.report.rxassystlib.EGroupBy;


/**
 * <p>Java class for GroupBy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupBy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Group" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGroupBy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupBy", propOrder = {
    "group"
})
public class GroupBy {

    @XmlElement(name = "Group")
    protected EGroupBy group;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link EGroupBy }
     *     
     */
    public EGroupBy getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGroupBy }
     *     
     */
    public void setGroup(EGroupBy value) {
        this.group = value;
    }

}
