
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.session.rxassystlib.EConfirmEmailReturnCode;


/**
 * <p>Java class for ConfirmEmailReturnCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmEmailReturnCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eConfirmEmailReturnCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmEmailReturnCode", propOrder = {
    "code"
})
public class ConfirmEmailReturnCode {

    @XmlElement(name = "Code", required = true)
    protected EConfirmEmailReturnCode code;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link EConfirmEmailReturnCode }
     *     
     */
    public EConfirmEmailReturnCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link EConfirmEmailReturnCode }
     *     
     */
    public void setCode(EConfirmEmailReturnCode value) {
        this.code = value;
    }

}
