
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.operation.rxassystlib.EOperationalEventState;
import com.lcl.erefill.generated.telus.operation.rxassystlib.ERecurrenceType;


/**
 * <p>Java class for OperationalEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationalEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EventStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastOperation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NextOperation" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationalEventState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eOperationalEventState" minOccurs="0"/>
 *         &lt;element name="Recurrence" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RecurrenceType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRecurrenceType"/>
 *         &lt;element name="CommunicationLanguage" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}AccountPreference.eLanguagesSupported" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationalEvent", propOrder = {
    "createdDate",
    "eventStart",
    "lastOperation",
    "message",
    "nextOperation",
    "oid",
    "operationalEventState",
    "recurrence",
    "recurrenceType",
    "communicationLanguage"
})
public class OperationalEvent {

    @XmlElement(name = "CreatedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "EventStart")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventStart;
    @XmlElementRef(name = "LastOperation", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> lastOperation;
    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElement(name = "NextOperation", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextOperation;
    @XmlElementRef(name = "OID", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> oid;
    @XmlElement(name = "OperationalEventState")
    protected EOperationalEventState operationalEventState;
    @XmlElement(name = "Recurrence")
    protected long recurrence;
    @XmlElement(name = "RecurrenceType", required = true)
    protected ERecurrenceType recurrenceType;
    @XmlElementRef(name = "CommunicationLanguage", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<AccountPreferenceELanguagesSupported> communicationLanguage;

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the eventStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventStart() {
        return eventStart;
    }

    /**
     * Sets the value of the eventStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventStart(XMLGregorianCalendar value) {
        this.eventStart = value;
    }

    /**
     * Gets the value of the lastOperation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastOperation() {
        return lastOperation;
    }

    /**
     * Sets the value of the lastOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastOperation(JAXBElement<XMLGregorianCalendar> value) {
        this.lastOperation = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = value;
    }

    /**
     * Gets the value of the nextOperation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextOperation() {
        return nextOperation;
    }

    /**
     * Sets the value of the nextOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextOperation(XMLGregorianCalendar value) {
        this.nextOperation = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOID() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOID(JAXBElement<String> value) {
        this.oid = value;
    }

    /**
     * Gets the value of the operationalEventState property.
     * 
     * @return
     *     possible object is
     *     {@link EOperationalEventState }
     *     
     */
    public EOperationalEventState getOperationalEventState() {
        return operationalEventState;
    }

    /**
     * Sets the value of the operationalEventState property.
     * 
     * @param value
     *     allowed object is
     *     {@link EOperationalEventState }
     *     
     */
    public void setOperationalEventState(EOperationalEventState value) {
        this.operationalEventState = value;
    }

    /**
     * Gets the value of the recurrence property.
     * 
     */
    public long getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the value of the recurrence property.
     * 
     */
    public void setRecurrence(long value) {
        this.recurrence = value;
    }

    /**
     * Gets the value of the recurrenceType property.
     * 
     * @return
     *     possible object is
     *     {@link ERecurrenceType }
     *     
     */
    public ERecurrenceType getRecurrenceType() {
        return recurrenceType;
    }

    /**
     * Sets the value of the recurrenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERecurrenceType }
     *     
     */
    public void setRecurrenceType(ERecurrenceType value) {
        this.recurrenceType = value;
    }

    /**
     * Gets the value of the communicationLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AccountPreferenceELanguagesSupported }{@code >}
     *     
     */
    public JAXBElement<AccountPreferenceELanguagesSupported> getCommunicationLanguage() {
        return communicationLanguage;
    }

    /**
     * Sets the value of the communicationLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AccountPreferenceELanguagesSupported }{@code >}
     *     
     */
    public void setCommunicationLanguage(JAXBElement<AccountPreferenceELanguagesSupported> value) {
        this.communicationLanguage = value;
    }

}
