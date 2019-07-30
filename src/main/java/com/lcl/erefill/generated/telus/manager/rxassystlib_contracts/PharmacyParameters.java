
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PharmacyParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacyParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthorizeAutomatedRefill" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AuthorizeFamilyManager" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AuthorizeRefillReminder" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AutomatedRefillHomedropBufferTimeMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AutomatedRefillPickupBufferTimeMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillAlreadyRefilled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillInAdvance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillLastRefill" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillPrescriptionInvalid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendAutomatedRefillSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendFamilyManagerAcceptAssignRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendFamilyManagerAssignRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendFamilyManagerDeclineAssignRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendFamilyManagerPatientDeleteAssociation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendPatientAdminRevoke" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendPatientRevoke" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillAcceptRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillDeclineRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderAlreadyRefilled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderInAdvance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderLastRefill" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderPrescriptionInvalid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventMessageSendRefillReminderSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GetPrescriptionFilterAbortedPrescription" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MobileAppAndroid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MobileAppBB" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MobileAppiOS" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="WebSiteHomedropBufferTimeMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WebSiteHomedropThresholdMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WebSitePickupBufferTimeMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WebSitePickupThresholdMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AuthorizeTaxReceipt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TaxReceiptMessageEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxReceiptMessageFr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxReceiptMessageMultiPharmacyEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxReceiptMessageMultiPharmacyFr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyParameters", propOrder = {
    "authorizeAutomatedRefill",
    "authorizeFamilyManager",
    "authorizeRefillReminder",
    "automatedRefillHomedropBufferTimeMinutes",
    "automatedRefillPickupBufferTimeMinutes",
    "eventMessageSendAutomatedRefillAlreadyRefilled",
    "eventMessageSendAutomatedRefillExpired",
    "eventMessageSendAutomatedRefillInAdvance",
    "eventMessageSendAutomatedRefillLastRefill",
    "eventMessageSendAutomatedRefillPrescriptionInvalid",
    "eventMessageSendAutomatedRefillSent",
    "eventMessageSendFamilyManagerAcceptAssignRequest",
    "eventMessageSendFamilyManagerAssignRequest",
    "eventMessageSendFamilyManagerDeclineAssignRequest",
    "eventMessageSendFamilyManagerPatientDeleteAssociation",
    "eventMessageSendPatientAdminRevoke",
    "eventMessageSendPatientRevoke",
    "eventMessageSendRefillAcceptRequest",
    "eventMessageSendRefillDeclineRequest",
    "eventMessageSendRefillReminderAlreadyRefilled",
    "eventMessageSendRefillReminderExpired",
    "eventMessageSendRefillReminderInAdvance",
    "eventMessageSendRefillReminderLastRefill",
    "eventMessageSendRefillReminderPrescriptionInvalid",
    "eventMessageSendRefillReminderSent",
    "getPrescriptionFilterAbortedPrescription",
    "mobileAppAndroid",
    "mobileAppBB",
    "mobileAppiOS",
    "webSiteHomedropBufferTimeMinutes",
    "webSiteHomedropThresholdMinutes",
    "webSitePickupBufferTimeMinutes",
    "webSitePickupThresholdMinutes",
    "authorizeTaxReceipt",
    "taxReceiptMessageEn",
    "taxReceiptMessageFr",
    "taxReceiptMessageMultiPharmacyEn",
    "taxReceiptMessageMultiPharmacyFr"
})
public class PharmacyParameters {

    @XmlElement(name = "AuthorizeAutomatedRefill")
    protected Boolean authorizeAutomatedRefill;
    @XmlElement(name = "AuthorizeFamilyManager")
    protected Boolean authorizeFamilyManager;
    @XmlElement(name = "AuthorizeRefillReminder")
    protected Boolean authorizeRefillReminder;
    @XmlElement(name = "AutomatedRefillHomedropBufferTimeMinutes")
    protected Integer automatedRefillHomedropBufferTimeMinutes;
    @XmlElement(name = "AutomatedRefillPickupBufferTimeMinutes")
    protected Integer automatedRefillPickupBufferTimeMinutes;
    @XmlElement(name = "EventMessageSendAutomatedRefillAlreadyRefilled")
    protected Boolean eventMessageSendAutomatedRefillAlreadyRefilled;
    @XmlElement(name = "EventMessageSendAutomatedRefillExpired")
    protected Boolean eventMessageSendAutomatedRefillExpired;
    @XmlElement(name = "EventMessageSendAutomatedRefillInAdvance")
    protected Boolean eventMessageSendAutomatedRefillInAdvance;
    @XmlElement(name = "EventMessageSendAutomatedRefillLastRefill")
    protected Boolean eventMessageSendAutomatedRefillLastRefill;
    @XmlElement(name = "EventMessageSendAutomatedRefillPrescriptionInvalid")
    protected Boolean eventMessageSendAutomatedRefillPrescriptionInvalid;
    @XmlElement(name = "EventMessageSendAutomatedRefillSent")
    protected Boolean eventMessageSendAutomatedRefillSent;
    @XmlElement(name = "EventMessageSendFamilyManagerAcceptAssignRequest")
    protected Boolean eventMessageSendFamilyManagerAcceptAssignRequest;
    @XmlElement(name = "EventMessageSendFamilyManagerAssignRequest")
    protected Boolean eventMessageSendFamilyManagerAssignRequest;
    @XmlElement(name = "EventMessageSendFamilyManagerDeclineAssignRequest")
    protected Boolean eventMessageSendFamilyManagerDeclineAssignRequest;
    @XmlElement(name = "EventMessageSendFamilyManagerPatientDeleteAssociation")
    protected Boolean eventMessageSendFamilyManagerPatientDeleteAssociation;
    @XmlElement(name = "EventMessageSendPatientAdminRevoke")
    protected Boolean eventMessageSendPatientAdminRevoke;
    @XmlElement(name = "EventMessageSendPatientRevoke")
    protected Boolean eventMessageSendPatientRevoke;
    @XmlElement(name = "EventMessageSendRefillAcceptRequest")
    protected Boolean eventMessageSendRefillAcceptRequest;
    @XmlElement(name = "EventMessageSendRefillDeclineRequest")
    protected Boolean eventMessageSendRefillDeclineRequest;
    @XmlElement(name = "EventMessageSendRefillReminderAlreadyRefilled")
    protected Boolean eventMessageSendRefillReminderAlreadyRefilled;
    @XmlElement(name = "EventMessageSendRefillReminderExpired")
    protected Boolean eventMessageSendRefillReminderExpired;
    @XmlElement(name = "EventMessageSendRefillReminderInAdvance")
    protected Boolean eventMessageSendRefillReminderInAdvance;
    @XmlElement(name = "EventMessageSendRefillReminderLastRefill")
    protected Boolean eventMessageSendRefillReminderLastRefill;
    @XmlElement(name = "EventMessageSendRefillReminderPrescriptionInvalid")
    protected Boolean eventMessageSendRefillReminderPrescriptionInvalid;
    @XmlElement(name = "EventMessageSendRefillReminderSent")
    protected Boolean eventMessageSendRefillReminderSent;
    @XmlElement(name = "GetPrescriptionFilterAbortedPrescription")
    protected Boolean getPrescriptionFilterAbortedPrescription;
    @XmlElement(name = "MobileAppAndroid")
    protected Boolean mobileAppAndroid;
    @XmlElement(name = "MobileAppBB")
    protected Boolean mobileAppBB;
    @XmlElement(name = "MobileAppiOS")
    protected Boolean mobileAppiOS;
    @XmlElement(name = "WebSiteHomedropBufferTimeMinutes")
    protected Integer webSiteHomedropBufferTimeMinutes;
    @XmlElement(name = "WebSiteHomedropThresholdMinutes")
    protected Integer webSiteHomedropThresholdMinutes;
    @XmlElement(name = "WebSitePickupBufferTimeMinutes")
    protected Integer webSitePickupBufferTimeMinutes;
    @XmlElement(name = "WebSitePickupThresholdMinutes")
    protected Integer webSitePickupThresholdMinutes;
    @XmlElement(name = "AuthorizeTaxReceipt")
    protected Boolean authorizeTaxReceipt;
    @XmlElementRef(name = "TaxReceiptMessageEn", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> taxReceiptMessageEn;
    @XmlElementRef(name = "TaxReceiptMessageFr", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> taxReceiptMessageFr;
    @XmlElementRef(name = "TaxReceiptMessageMultiPharmacyEn", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> taxReceiptMessageMultiPharmacyEn;
    @XmlElementRef(name = "TaxReceiptMessageMultiPharmacyFr", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> taxReceiptMessageMultiPharmacyFr;

    /**
     * Gets the value of the authorizeAutomatedRefill property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthorizeAutomatedRefill() {
        return authorizeAutomatedRefill;
    }

    /**
     * Sets the value of the authorizeAutomatedRefill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthorizeAutomatedRefill(Boolean value) {
        this.authorizeAutomatedRefill = value;
    }

    /**
     * Gets the value of the authorizeFamilyManager property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthorizeFamilyManager() {
        return authorizeFamilyManager;
    }

    /**
     * Sets the value of the authorizeFamilyManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthorizeFamilyManager(Boolean value) {
        this.authorizeFamilyManager = value;
    }

    /**
     * Gets the value of the authorizeRefillReminder property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthorizeRefillReminder() {
        return authorizeRefillReminder;
    }

    /**
     * Sets the value of the authorizeRefillReminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthorizeRefillReminder(Boolean value) {
        this.authorizeRefillReminder = value;
    }

    /**
     * Gets the value of the automatedRefillHomedropBufferTimeMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutomatedRefillHomedropBufferTimeMinutes() {
        return automatedRefillHomedropBufferTimeMinutes;
    }

    /**
     * Sets the value of the automatedRefillHomedropBufferTimeMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutomatedRefillHomedropBufferTimeMinutes(Integer value) {
        this.automatedRefillHomedropBufferTimeMinutes = value;
    }

    /**
     * Gets the value of the automatedRefillPickupBufferTimeMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutomatedRefillPickupBufferTimeMinutes() {
        return automatedRefillPickupBufferTimeMinutes;
    }

    /**
     * Sets the value of the automatedRefillPickupBufferTimeMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutomatedRefillPickupBufferTimeMinutes(Integer value) {
        this.automatedRefillPickupBufferTimeMinutes = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillAlreadyRefilled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillAlreadyRefilled() {
        return eventMessageSendAutomatedRefillAlreadyRefilled;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillAlreadyRefilled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillAlreadyRefilled(Boolean value) {
        this.eventMessageSendAutomatedRefillAlreadyRefilled = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillExpired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillExpired() {
        return eventMessageSendAutomatedRefillExpired;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillExpired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillExpired(Boolean value) {
        this.eventMessageSendAutomatedRefillExpired = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillInAdvance property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillInAdvance() {
        return eventMessageSendAutomatedRefillInAdvance;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillInAdvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillInAdvance(Boolean value) {
        this.eventMessageSendAutomatedRefillInAdvance = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillLastRefill property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillLastRefill() {
        return eventMessageSendAutomatedRefillLastRefill;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillLastRefill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillLastRefill(Boolean value) {
        this.eventMessageSendAutomatedRefillLastRefill = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillPrescriptionInvalid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillPrescriptionInvalid() {
        return eventMessageSendAutomatedRefillPrescriptionInvalid;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillPrescriptionInvalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillPrescriptionInvalid(Boolean value) {
        this.eventMessageSendAutomatedRefillPrescriptionInvalid = value;
    }

    /**
     * Gets the value of the eventMessageSendAutomatedRefillSent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendAutomatedRefillSent() {
        return eventMessageSendAutomatedRefillSent;
    }

    /**
     * Sets the value of the eventMessageSendAutomatedRefillSent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendAutomatedRefillSent(Boolean value) {
        this.eventMessageSendAutomatedRefillSent = value;
    }

    /**
     * Gets the value of the eventMessageSendFamilyManagerAcceptAssignRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendFamilyManagerAcceptAssignRequest() {
        return eventMessageSendFamilyManagerAcceptAssignRequest;
    }

    /**
     * Sets the value of the eventMessageSendFamilyManagerAcceptAssignRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendFamilyManagerAcceptAssignRequest(Boolean value) {
        this.eventMessageSendFamilyManagerAcceptAssignRequest = value;
    }

    /**
     * Gets the value of the eventMessageSendFamilyManagerAssignRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendFamilyManagerAssignRequest() {
        return eventMessageSendFamilyManagerAssignRequest;
    }

    /**
     * Sets the value of the eventMessageSendFamilyManagerAssignRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendFamilyManagerAssignRequest(Boolean value) {
        this.eventMessageSendFamilyManagerAssignRequest = value;
    }

    /**
     * Gets the value of the eventMessageSendFamilyManagerDeclineAssignRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendFamilyManagerDeclineAssignRequest() {
        return eventMessageSendFamilyManagerDeclineAssignRequest;
    }

    /**
     * Sets the value of the eventMessageSendFamilyManagerDeclineAssignRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendFamilyManagerDeclineAssignRequest(Boolean value) {
        this.eventMessageSendFamilyManagerDeclineAssignRequest = value;
    }

    /**
     * Gets the value of the eventMessageSendFamilyManagerPatientDeleteAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendFamilyManagerPatientDeleteAssociation() {
        return eventMessageSendFamilyManagerPatientDeleteAssociation;
    }

    /**
     * Sets the value of the eventMessageSendFamilyManagerPatientDeleteAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendFamilyManagerPatientDeleteAssociation(Boolean value) {
        this.eventMessageSendFamilyManagerPatientDeleteAssociation = value;
    }

    /**
     * Gets the value of the eventMessageSendPatientAdminRevoke property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendPatientAdminRevoke() {
        return eventMessageSendPatientAdminRevoke;
    }

    /**
     * Sets the value of the eventMessageSendPatientAdminRevoke property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendPatientAdminRevoke(Boolean value) {
        this.eventMessageSendPatientAdminRevoke = value;
    }

    /**
     * Gets the value of the eventMessageSendPatientRevoke property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendPatientRevoke() {
        return eventMessageSendPatientRevoke;
    }

    /**
     * Sets the value of the eventMessageSendPatientRevoke property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendPatientRevoke(Boolean value) {
        this.eventMessageSendPatientRevoke = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillAcceptRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillAcceptRequest() {
        return eventMessageSendRefillAcceptRequest;
    }

    /**
     * Sets the value of the eventMessageSendRefillAcceptRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillAcceptRequest(Boolean value) {
        this.eventMessageSendRefillAcceptRequest = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillDeclineRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillDeclineRequest() {
        return eventMessageSendRefillDeclineRequest;
    }

    /**
     * Sets the value of the eventMessageSendRefillDeclineRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillDeclineRequest(Boolean value) {
        this.eventMessageSendRefillDeclineRequest = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderAlreadyRefilled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderAlreadyRefilled() {
        return eventMessageSendRefillReminderAlreadyRefilled;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderAlreadyRefilled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderAlreadyRefilled(Boolean value) {
        this.eventMessageSendRefillReminderAlreadyRefilled = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderExpired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderExpired() {
        return eventMessageSendRefillReminderExpired;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderExpired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderExpired(Boolean value) {
        this.eventMessageSendRefillReminderExpired = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderInAdvance property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderInAdvance() {
        return eventMessageSendRefillReminderInAdvance;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderInAdvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderInAdvance(Boolean value) {
        this.eventMessageSendRefillReminderInAdvance = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderLastRefill property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderLastRefill() {
        return eventMessageSendRefillReminderLastRefill;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderLastRefill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderLastRefill(Boolean value) {
        this.eventMessageSendRefillReminderLastRefill = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderPrescriptionInvalid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderPrescriptionInvalid() {
        return eventMessageSendRefillReminderPrescriptionInvalid;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderPrescriptionInvalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderPrescriptionInvalid(Boolean value) {
        this.eventMessageSendRefillReminderPrescriptionInvalid = value;
    }

    /**
     * Gets the value of the eventMessageSendRefillReminderSent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEventMessageSendRefillReminderSent() {
        return eventMessageSendRefillReminderSent;
    }

    /**
     * Sets the value of the eventMessageSendRefillReminderSent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEventMessageSendRefillReminderSent(Boolean value) {
        this.eventMessageSendRefillReminderSent = value;
    }

    /**
     * Gets the value of the getPrescriptionFilterAbortedPrescription property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGetPrescriptionFilterAbortedPrescription() {
        return getPrescriptionFilterAbortedPrescription;
    }

    /**
     * Sets the value of the getPrescriptionFilterAbortedPrescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGetPrescriptionFilterAbortedPrescription(Boolean value) {
        this.getPrescriptionFilterAbortedPrescription = value;
    }

    /**
     * Gets the value of the mobileAppAndroid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMobileAppAndroid() {
        return mobileAppAndroid;
    }

    /**
     * Sets the value of the mobileAppAndroid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMobileAppAndroid(Boolean value) {
        this.mobileAppAndroid = value;
    }

    /**
     * Gets the value of the mobileAppBB property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMobileAppBB() {
        return mobileAppBB;
    }

    /**
     * Sets the value of the mobileAppBB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMobileAppBB(Boolean value) {
        this.mobileAppBB = value;
    }

    /**
     * Gets the value of the mobileAppiOS property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMobileAppiOS() {
        return mobileAppiOS;
    }

    /**
     * Sets the value of the mobileAppiOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMobileAppiOS(Boolean value) {
        this.mobileAppiOS = value;
    }

    /**
     * Gets the value of the webSiteHomedropBufferTimeMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebSiteHomedropBufferTimeMinutes() {
        return webSiteHomedropBufferTimeMinutes;
    }

    /**
     * Sets the value of the webSiteHomedropBufferTimeMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebSiteHomedropBufferTimeMinutes(Integer value) {
        this.webSiteHomedropBufferTimeMinutes = value;
    }

    /**
     * Gets the value of the webSiteHomedropThresholdMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebSiteHomedropThresholdMinutes() {
        return webSiteHomedropThresholdMinutes;
    }

    /**
     * Sets the value of the webSiteHomedropThresholdMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebSiteHomedropThresholdMinutes(Integer value) {
        this.webSiteHomedropThresholdMinutes = value;
    }

    /**
     * Gets the value of the webSitePickupBufferTimeMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebSitePickupBufferTimeMinutes() {
        return webSitePickupBufferTimeMinutes;
    }

    /**
     * Sets the value of the webSitePickupBufferTimeMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebSitePickupBufferTimeMinutes(Integer value) {
        this.webSitePickupBufferTimeMinutes = value;
    }

    /**
     * Gets the value of the webSitePickupThresholdMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebSitePickupThresholdMinutes() {
        return webSitePickupThresholdMinutes;
    }

    /**
     * Sets the value of the webSitePickupThresholdMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebSitePickupThresholdMinutes(Integer value) {
        this.webSitePickupThresholdMinutes = value;
    }

    /**
     * Gets the value of the authorizeTaxReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthorizeTaxReceipt() {
        return authorizeTaxReceipt;
    }

    /**
     * Sets the value of the authorizeTaxReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthorizeTaxReceipt(Boolean value) {
        this.authorizeTaxReceipt = value;
    }

    /**
     * Gets the value of the taxReceiptMessageEn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxReceiptMessageEn() {
        return taxReceiptMessageEn;
    }

    /**
     * Sets the value of the taxReceiptMessageEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxReceiptMessageEn(JAXBElement<String> value) {
        this.taxReceiptMessageEn = value;
    }

    /**
     * Gets the value of the taxReceiptMessageFr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxReceiptMessageFr() {
        return taxReceiptMessageFr;
    }

    /**
     * Sets the value of the taxReceiptMessageFr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxReceiptMessageFr(JAXBElement<String> value) {
        this.taxReceiptMessageFr = value;
    }

    /**
     * Gets the value of the taxReceiptMessageMultiPharmacyEn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxReceiptMessageMultiPharmacyEn() {
        return taxReceiptMessageMultiPharmacyEn;
    }

    /**
     * Sets the value of the taxReceiptMessageMultiPharmacyEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxReceiptMessageMultiPharmacyEn(JAXBElement<String> value) {
        this.taxReceiptMessageMultiPharmacyEn = value;
    }

    /**
     * Gets the value of the taxReceiptMessageMultiPharmacyFr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxReceiptMessageMultiPharmacyFr() {
        return taxReceiptMessageMultiPharmacyFr;
    }

    /**
     * Sets the value of the taxReceiptMessageMultiPharmacyFr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxReceiptMessageMultiPharmacyFr(JAXBElement<String> value) {
        this.taxReceiptMessageMultiPharmacyFr = value;
    }

}
