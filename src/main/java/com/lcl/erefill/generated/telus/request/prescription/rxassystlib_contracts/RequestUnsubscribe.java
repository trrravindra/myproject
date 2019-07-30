
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EProfileReplicationOperation;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EUnsubscribeReason;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.EUnsubscribeRequestState;


/**
 * <p>Java class for RequestUnsubscribe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestUnsubscribe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Patient" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPatient"/>
 *         &lt;element name="Reason" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eUnsubscribeReason"/>
 *         &lt;element name="ReasonComment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProfileReplication" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eProfileReplicationOperation"/>
 *         &lt;element name="State" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eUnsubscribeRequestState"/>
 *         &lt;element name="LastStateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestUnsubscribe", propOrder = {
    "patient",
    "reason",
    "reasonComment",
    "profileReplication",
    "state",
    "lastStateDate",
    "oid"
})
public class RequestUnsubscribe {

    @XmlElement(name = "Patient", required = true, nillable = true)
    protected RxPatient patient;
    @XmlElement(name = "Reason", required = true)
    protected EUnsubscribeReason reason;
    @XmlElement(name = "ReasonComment", required = true, nillable = true)
    protected String reasonComment;
    @XmlElement(name = "ProfileReplication", required = true)
    protected EProfileReplicationOperation profileReplication;
    @XmlElement(name = "State", required = true)
    protected EUnsubscribeRequestState state;
    @XmlElement(name = "LastStateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastStateDate;
    @XmlElement(name = "OID", required = true, nillable = true)
    protected String oid;

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
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link EUnsubscribeReason }
     *     
     */
    public EUnsubscribeReason getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link EUnsubscribeReason }
     *     
     */
    public void setReason(EUnsubscribeReason value) {
        this.reason = value;
    }

    /**
     * Gets the value of the reasonComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonComment() {
        return reasonComment;
    }

    /**
     * Sets the value of the reasonComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonComment(String value) {
        this.reasonComment = value;
    }

    /**
     * Gets the value of the profileReplication property.
     * 
     * @return
     *     possible object is
     *     {@link EProfileReplicationOperation }
     *     
     */
    public EProfileReplicationOperation getProfileReplication() {
        return profileReplication;
    }

    /**
     * Sets the value of the profileReplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link EProfileReplicationOperation }
     *     
     */
    public void setProfileReplication(EProfileReplicationOperation value) {
        this.profileReplication = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link EUnsubscribeRequestState }
     *     
     */
    public EUnsubscribeRequestState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link EUnsubscribeRequestState }
     *     
     */
    public void setState(EUnsubscribeRequestState value) {
        this.state = value;
    }

    /**
     * Gets the value of the lastStateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastStateDate() {
        return lastStateDate;
    }

    /**
     * Sets the value of the lastStateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastStateDate(XMLGregorianCalendar value) {
        this.lastStateDate = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOID() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOID(String value) {
        this.oid = value;
    }

}
