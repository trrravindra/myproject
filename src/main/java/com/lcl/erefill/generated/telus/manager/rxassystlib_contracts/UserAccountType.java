
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EAccountType;


/**
 * <p>Java class for UserAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAccountType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountType", propOrder = {
    "accountType"
})
public class UserAccountType {

    @XmlElement(name = "AccountType", required = true)
    protected EAccountType accountType;

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link EAccountType }
     *     
     */
    public EAccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAccountType }
     *     
     */
    public void setAccountType(EAccountType value) {
        this.accountType = value;
    }

}
