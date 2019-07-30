
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.consent.rxassystlib.EUnsubscribeReason;


/**
 * <p>Java class for ReasonCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReasonCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReasonForUnsubscribe" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eUnsubscribeReason"/>
 *         &lt;element name="ReasonText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReasonCode", propOrder = {
    "reasonForUnsubscribe",
    "reasonText"
})
public class ReasonCode {

    @XmlElement(name = "ReasonForUnsubscribe", required = true)
    protected EUnsubscribeReason reasonForUnsubscribe;
    @XmlElementRef(name = "ReasonText", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> reasonText;

    /**
     * Gets the value of the reasonForUnsubscribe property.
     * 
     * @return
     *     possible object is
     *     {@link EUnsubscribeReason }
     *     
     */
    public EUnsubscribeReason getReasonForUnsubscribe() {
        return reasonForUnsubscribe;
    }

    /**
     * Sets the value of the reasonForUnsubscribe property.
     * 
     * @param value
     *     allowed object is
     *     {@link EUnsubscribeReason }
     *     
     */
    public void setReasonForUnsubscribe(EUnsubscribeReason value) {
        this.reasonForUnsubscribe = value;
    }

    /**
     * Gets the value of the reasonText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonText() {
        return reasonText;
    }

    /**
     * Sets the value of the reasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonText(JAXBElement<String> value) {
        this.reasonText = value;
    }

}
