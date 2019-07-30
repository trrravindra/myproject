
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RxRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Request">
 *       &lt;sequence>
 *         &lt;element name="Patient" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPatient"/>
 *         &lt;element name="Prescriptions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPrescriptions"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxRequest", propOrder = {
    "patient",
    "prescriptions"
})
public class RxRequest
    extends Request
{

    @XmlElement(name = "Patient", required = true, nillable = true)
    protected RxPatient patient;
    @XmlElement(name = "Prescriptions", required = true, nillable = true)
    protected RxPrescriptions prescriptions;

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link RxPatient }
     *     
     */
    public RxPatient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link RxPatient }
     *     
     */
    public void setPatient(RxPatient value) {
        this.patient = value;
    }

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

}
