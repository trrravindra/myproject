
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.session.rxassystlib.EEmailReturnCode;


/**
 * <p>Java class for EmailReturnStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EmailReturnStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eEmailReturnCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmailReturnStatus", propOrder = {
    "code"
})
public class EmailReturnStatus {

    @XmlElement(name = "Code", required = true)
    protected EEmailReturnCode code;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link EEmailReturnCode }
     *     
     */
    public EEmailReturnCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link EEmailReturnCode }
     *     
     */
    public void setCode(EEmailReturnCode value) {
        this.code = value;
    }

}
