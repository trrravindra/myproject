
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Establishment;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserAccountsGroup;


/**
 * <p>Java class for LogOnDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogOnDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}Account" minOccurs="0"/>
 *         &lt;element name="GroupId" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}UserAccountsGroup" minOccurs="0"/>
 *         &lt;element name="Establishment" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Establishment" minOccurs="0"/>
 *         &lt;element name="PatientModule" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}PatientModule" minOccurs="0"/>
 *         &lt;element name="PatientOID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsentExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogOnDetail", propOrder = {
    "account",
    "groupId",
    "establishment",
    "patientModule",
    "patientOID",
    "consentExpired"
})
public class LogOnDetail {

    @XmlElementRef(name = "Account", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<Account> account;
    @XmlElementRef(name = "GroupId", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<UserAccountsGroup> groupId;
    @XmlElementRef(name = "Establishment", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<Establishment> establishment;
    @XmlElementRef(name = "PatientModule", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<PatientModule> patientModule;
    @XmlElementRef(name = "PatientOID", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<String> patientOID;
    @XmlElementRef(name = "ConsentExpired", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> consentExpired;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Account }{@code >}
     *     
     */
    public JAXBElement<Account> getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Account }{@code >}
     *     
     */
    public void setAccount(JAXBElement<Account> value) {
        this.account = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}
     *     
     */
    public JAXBElement<UserAccountsGroup> getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}
     *     
     */
    public void setGroupId(JAXBElement<UserAccountsGroup> value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the establishment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Establishment }{@code >}
     *     
     */
    public JAXBElement<Establishment> getEstablishment() {
        return establishment;
    }

    /**
     * Sets the value of the establishment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Establishment }{@code >}
     *     
     */
    public void setEstablishment(JAXBElement<Establishment> value) {
        this.establishment = value;
    }

    /**
     * Gets the value of the patientModule property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PatientModule }{@code >}
     *     
     */
    public JAXBElement<PatientModule> getPatientModule() {
        return patientModule;
    }

    /**
     * Sets the value of the patientModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PatientModule }{@code >}
     *     
     */
    public void setPatientModule(JAXBElement<PatientModule> value) {
        this.patientModule = value;
    }

    /**
     * Gets the value of the patientOID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPatientOID() {
        return patientOID;
    }

    /**
     * Sets the value of the patientOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPatientOID(JAXBElement<String> value) {
        this.patientOID = value;
    }

    /**
     * Gets the value of the consentExpired property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getConsentExpired() {
        return consentExpired;
    }

    /**
     * Sets the value of the consentExpired property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setConsentExpired(JAXBElement<Boolean> value) {
        this.consentExpired = value;
    }

}
