
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RxNewRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxNewRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Request">
 *       &lt;sequence>
 *         &lt;element name="PatientDefaultPharmacy" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Prescriptions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxRenewPrescriptions"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxNewRequest", propOrder = {
    "patientDefaultPharmacy",
    "prescriptions"
})
public class RxNewRequest
    extends Request
{

    @XmlElement(name = "PatientDefaultPharmacy")
    protected short patientDefaultPharmacy;
    @XmlElement(name = "Prescriptions", required = true, nillable = true)
    protected RxRenewPrescriptions prescriptions;

    /**
     * Gets the value of the patientDefaultPharmacy property.
     * 
     */
    public short getPatientDefaultPharmacy() {
        return patientDefaultPharmacy;
    }

    /**
     * Sets the value of the patientDefaultPharmacy property.
     * 
     */
    public void setPatientDefaultPharmacy(short value) {
        this.patientDefaultPharmacy = value;
    }

    /**
     * Gets the value of the prescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link RxRenewPrescriptions }
     *     
     */
    public RxRenewPrescriptions getPrescriptions() {
        return prescriptions;
    }

    /**
     * Sets the value of the prescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RxRenewPrescriptions }
     *     
     */
    public void setPrescriptions(RxRenewPrescriptions value) {
        this.prescriptions = value;
    }

}
