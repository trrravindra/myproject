
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.lcl.erefill.generated.telus.manager.rxassystlib.ERxPrescriptionState;


/**
 * <p>Java class for ProfilePrescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfilePrescription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Prescription">
 *       &lt;sequence>
 *         &lt;element name="LastState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRxPrescriptionState"/>
 *         &lt;element name="LastStateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Restrictions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PrescriptionRestrictions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilePrescription", propOrder = {
    "lastState",
    "lastStateDate",
    "restrictions"
})
public class ProfilePrescription
    extends Prescription
{

    @XmlElement(name = "LastState", required = true)
    protected ERxPrescriptionState lastState;
    @XmlElement(name = "LastStateDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastStateDate;
    @XmlElementRef(name = "Restrictions", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<PrescriptionRestrictions> restrictions;

    /**
     * Gets the value of the lastState property.
     * 
     * @return
     *     possible object is
     *     {@link ERxPrescriptionState }
     *     
     */
    public ERxPrescriptionState getLastState() {
        return lastState;
    }

    /**
     * Sets the value of the lastState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERxPrescriptionState }
     *     
     */
    public void setLastState(ERxPrescriptionState value) {
        this.lastState = value;
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
     * Gets the value of the restrictions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}
     *     
     */
    public JAXBElement<PrescriptionRestrictions> getRestrictions() {
        return restrictions;
    }

    /**
     * Sets the value of the restrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}
     *     
     */
    public void setRestrictions(JAXBElement<PrescriptionRestrictions> value) {
        this.restrictions = value;
    }

}
