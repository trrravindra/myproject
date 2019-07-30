
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatientOIDIdentification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientOIDIdentification">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Identification">
 *       &lt;sequence>
 *         &lt;element name="PatientOID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientOIDIdentification", propOrder = {
    "patientOID"
})
public class PatientOIDIdentification
    extends Identification
{

    @XmlElement(name = "PatientOID", required = true, nillable = true)
    protected String patientOID;

    /**
     * Gets the value of the patientOID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientOID() {
        return patientOID;
    }

    /**
     * Sets the value of the patientOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientOID(String value) {
        this.patientOID = value;
    }

}
