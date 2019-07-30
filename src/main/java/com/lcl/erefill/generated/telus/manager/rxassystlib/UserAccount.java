
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfAccountPreference;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfUserAccountsGroup;


/**
 * <p>Java class for UserAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib}Account">
 *       &lt;sequence>
 *         &lt;element name="AccountPreferences" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ArrayOfAccountPreference" minOccurs="0"/>
 *         &lt;element name="Assigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GroupId" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ArrayOfUserAccountsGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccount", propOrder = {
    "accountPreferences",
    "assigned",
    "groupId"
})
public class UserAccount
    extends Account
{

    @XmlElementRef(name = "AccountPreferences", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAccountPreference> accountPreferences;
    @XmlElement(name = "Assigned")
    protected Boolean assigned;
    @XmlElement(name = "GroupId", required = true, nillable = true)
    protected ArrayOfUserAccountsGroup groupId;

    /**
     * Gets the value of the accountPreferences property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAccountPreference }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAccountPreference> getAccountPreferences() {
        return accountPreferences;
    }

    /**
     * Sets the value of the accountPreferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAccountPreference }{@code >}
     *     
     */
    public void setAccountPreferences(JAXBElement<ArrayOfAccountPreference> value) {
        this.accountPreferences = value;
    }

    /**
     * Gets the value of the assigned property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssigned() {
        return assigned;
    }

    /**
     * Sets the value of the assigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssigned(Boolean value) {
        this.assigned = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserAccountsGroup }
     *     
     */
    public ArrayOfUserAccountsGroup getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserAccountsGroup }
     *     
     */
    public void setGroupId(ArrayOfUserAccountsGroup value) {
        this.groupId = value;
    }

}
