
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.operation.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Java class for AutomatedRefill complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutomatedRefill">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationalEvent" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}OperationalEvent"/>
 *         &lt;element name="OriginalPrescriptionsOID" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring"/>
 *         &lt;element name="Request" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Request"/>
 *         &lt;element name="RxPrescriptions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPrescriptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutomatedRefill", propOrder = {
    "operationalEvent",
    "originalPrescriptionsOID",
    "request",
    "rxPrescriptions"
})
public class AutomatedRefill {

    @XmlElement(name = "OperationalEvent", required = true, nillable = true)
    protected OperationalEvent operationalEvent;
    @XmlElement(name = "OriginalPrescriptionsOID", required = true, nillable = true)
    protected ArrayOfstring originalPrescriptionsOID;
    @XmlElement(name = "Request", required = true, nillable = true)
    protected Request request;
    @XmlElementRef(name = "RxPrescriptions", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<RxPrescriptions> rxPrescriptions;

    /**
     * Gets the value of the operationalEvent property.
     * 
     * @return
     *     possible object is
     *     {@link OperationalEvent }
     *     
     */
    public OperationalEvent getOperationalEvent() {
        return operationalEvent;
    }

    /**
     * Sets the value of the operationalEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalEvent }
     *     
     */
    public void setOperationalEvent(OperationalEvent value) {
        this.operationalEvent = value;
    }

    /**
     * Gets the value of the originalPrescriptionsOID property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getOriginalPrescriptionsOID() {
        return originalPrescriptionsOID;
    }

    /**
     * Sets the value of the originalPrescriptionsOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setOriginalPrescriptionsOID(ArrayOfstring value) {
        this.originalPrescriptionsOID = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link Request }
     *     
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link Request }
     *     
     */
    public void setRequest(Request value) {
        this.request = value;
    }

    /**
     * Gets the value of the rxPrescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RxPrescriptions }{@code >}
     *     
     */
    public JAXBElement<RxPrescriptions> getRxPrescriptions() {
        return rxPrescriptions;
    }

    /**
     * Sets the value of the rxPrescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RxPrescriptions }{@code >}
     *     
     */
    public void setRxPrescriptions(JAXBElement<RxPrescriptions> value) {
        this.rxPrescriptions = value;
    }

}
