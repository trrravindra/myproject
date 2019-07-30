
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Patient;


/**
 * <p>Java class for PatientInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Patient" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Patient"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientModule" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}PatientModule"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientInfo", propOrder = {
    "patient",
    "emailAddress",
    "patientModule"
})
public class PatientInfo {

    @XmlElement(name = "Patient", required = true, nillable = true)
    protected Patient patient;
    @XmlElement(name = "EmailAddress", required = true, nillable = true)
    protected String emailAddress;
    @XmlElement(name = "PatientModule", required = true, nillable = true)
    protected PatientModule patientModule;

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patient }
     *     
     */
    public void setPatient(Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the patientModule property.
     * 
     * @return
     *     possible object is
     *     {@link PatientModule }
     *     
     */
    public PatientModule getPatientModule() {
        return patientModule;
    }

    /**
     * Sets the value of the patientModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientModule }
     *     
     */
    public void setPatientModule(PatientModule value) {
        this.patientModule = value;
    }

}
