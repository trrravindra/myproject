
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.Account;


/**
 * <p>Java class for RxListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxListRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Request">
 *       &lt;sequence>
 *         &lt;element name="Prescriptions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPrescriptions"/>
 *         &lt;element name="AcccountCreator" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}Account"/>
 *         &lt;element name="Patient" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPatient" minOccurs="0"/>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxListRequest", propOrder = {
    "prescriptions",
    "acccountCreator",
    "patient",
    "requestId"
})
public class RxListRequest
    extends Request
{

    @XmlElement(name = "Prescriptions", required = true, nillable = true)
    protected RxPrescriptions prescriptions;
    @XmlElement(name = "AcccountCreator", required = true, nillable = true)
    protected Account acccountCreator;
    @XmlElementRef(name = "Patient", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<RxPatient> patient;
    @XmlElement(name = "RequestId")
    protected Long requestId;

    /**
     * Gets the value of the prescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link RxPrescriptions }
     *     
     */
    public RxPrescriptions getPrescriptions() {
        return prescriptions;
    }

    /**
     * Sets the value of the prescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RxPrescriptions }
     *     
     */
    public void setPrescriptions(RxPrescriptions value) {
        this.prescriptions = value;
    }

    /**
     * Gets the value of the acccountCreator property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAcccountCreator() {
        return acccountCreator;
    }

    /**
     * Sets the value of the acccountCreator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAcccountCreator(Account value) {
        this.acccountCreator = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RxPatient }{@code >}
     *     
     */
    public JAXBElement<RxPatient> getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RxPatient }{@code >}
     *     
     */
    public void setPatient(JAXBElement<RxPatient> value) {
        this.patient = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRequestId(Long value) {
        this.requestId = value;
    }

}
