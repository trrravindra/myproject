
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EAccountState;


/**
 * <p>Java class for UserAccountState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccountState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAccountState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountState", propOrder = {
    "accountState"
})
public class UserAccountState {

    @XmlElement(name = "AccountState")
    protected EAccountState accountState;

    /**
     * Gets the value of the accountState property.
     * 
     * @return
     *     possible object is
     *     {@link EAccountState }
     *     
     */
    public EAccountState getAccountState() {
        return accountState;
    }

    /**
     * Sets the value of the accountState property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAccountState }
     *     
     */
    public void setAccountState(EAccountState value) {
        this.accountState = value;
    }

}
