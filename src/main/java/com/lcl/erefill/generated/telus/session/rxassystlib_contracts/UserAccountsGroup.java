
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.session.rxassystlib.EGroup;


/**
 * <p>Java class for UserAccountsGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccountsGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Group" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountsGroup", propOrder = {
    "group"
})
public class UserAccountsGroup {

    @XmlElement(name = "Group")
    protected EGroup group;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link EGroup }
     *     
     */
    public EGroup getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGroup }
     *     
     */
    public void setGroup(EGroup value) {
        this.group = value;
    }

}
