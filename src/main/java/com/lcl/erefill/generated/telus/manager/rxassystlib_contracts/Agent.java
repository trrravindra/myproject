
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.Account;


/**
 * <p>Java class for Agent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Agent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}Account"/>
 *         &lt;element name="MainContractNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pharmacy" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Pharmacy"/>
 *         &lt;element name="ActivationModule" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ActivationModule"/>
 *         &lt;element name="PharmacyTimeZone" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PharmacyTimeZone"/>
 *         &lt;element name="PharmacyPMS" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PharmacyPMS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent", propOrder = {
    "account",
    "mainContractNumber",
    "pharmacy",
    "activationModule",
    "pharmacyTimeZone",
    "pharmacyPMS"
})
public class Agent {

    @XmlElement(name = "Account", required = true, nillable = true)
    protected Account account;
    @XmlElement(name = "MainContractNumber", required = true, nillable = true)
    protected String mainContractNumber;
    @XmlElement(name = "Pharmacy", required = true, nillable = true)
    protected Pharmacy pharmacy;
    @XmlElement(name = "ActivationModule", required = true, nillable = true)
    protected ActivationModule activationModule;
    @XmlElement(name = "PharmacyTimeZone", required = true, nillable = true)
    protected PharmacyTimeZone pharmacyTimeZone;
    @XmlElementRef(name = "PharmacyPMS", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<PharmacyPMS> pharmacyPMS;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAccount(Account value) {
        this.account = value;
    }

    /**
     * Gets the value of the mainContractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainContractNumber() {
        return mainContractNumber;
    }

    /**
     * Sets the value of the mainContractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainContractNumber(String value) {
        this.mainContractNumber = value;
    }

    /**
     * Gets the value of the pharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link Pharmacy }
     *     
     */
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets the value of the pharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pharmacy }
     *     
     */
    public void setPharmacy(Pharmacy value) {
        this.pharmacy = value;
    }

    /**
     * Gets the value of the activationModule property.
     * 
     * @return
     *     possible object is
     *     {@link ActivationModule }
     *     
     */
    public ActivationModule getActivationModule() {
        return activationModule;
    }

    /**
     * Sets the value of the activationModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationModule }
     *     
     */
    public void setActivationModule(ActivationModule value) {
        this.activationModule = value;
    }

    /**
     * Gets the value of the pharmacyTimeZone property.
     * 
     * @return
     *     possible object is
     *     {@link PharmacyTimeZone }
     *     
     */
    public PharmacyTimeZone getPharmacyTimeZone() {
        return pharmacyTimeZone;
    }

    /**
     * Sets the value of the pharmacyTimeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link PharmacyTimeZone }
     *     
     */
    public void setPharmacyTimeZone(PharmacyTimeZone value) {
        this.pharmacyTimeZone = value;
    }

    /**
     * Gets the value of the pharmacyPMS property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PharmacyPMS }{@code >}
     *     
     */
    public JAXBElement<PharmacyPMS> getPharmacyPMS() {
        return pharmacyPMS;
    }

    /**
     * Sets the value of the pharmacyPMS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PharmacyPMS }{@code >}
     *     
     */
    public void setPharmacyPMS(JAXBElement<PharmacyPMS> value) {
        this.pharmacyPMS = value;
    }

}
