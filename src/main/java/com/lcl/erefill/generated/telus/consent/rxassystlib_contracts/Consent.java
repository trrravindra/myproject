
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.consent.rxassystlib.ConsentType;


/**
 * <p>Java class for Consent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Consent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AgreementEnglish" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AgreementFrench" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NameEnglish" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameFrench" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OwnerId" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ConsentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Consent", propOrder = {
    "active",
    "agreementEnglish",
    "agreementFrench",
    "id",
    "mandatory",
    "nameEnglish",
    "nameFrench",
    "ownerId",
    "version",
    "duration",
    "oid",
    "type"
})
public class Consent {

    @XmlElement(name = "Active")
    protected boolean active;
    @XmlElement(name = "AgreementEnglish", required = true, nillable = true)
    protected String agreementEnglish;
    @XmlElement(name = "AgreementFrench", required = true, nillable = true)
    protected String agreementFrench;
    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Mandatory")
    protected boolean mandatory;
    @XmlElement(name = "NameEnglish", required = true, nillable = true)
    protected String nameEnglish;
    @XmlElement(name = "NameFrench", required = true, nillable = true)
    protected String nameFrench;
    @XmlElement(name = "OwnerId")
    protected short ownerId;
    @XmlElement(name = "Version")
    protected int version;
    @XmlElementRef(name = "Duration", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<Short> duration;
    @XmlElementRef(name = "OID", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> oid;
    @XmlElement(name = "Type")
    protected ConsentType type;

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the agreementEnglish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementEnglish() {
        return agreementEnglish;
    }

    /**
     * Sets the value of the agreementEnglish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementEnglish(String value) {
        this.agreementEnglish = value;
    }

    /**
     * Gets the value of the agreementFrench property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementFrench() {
        return agreementFrench;
    }

    /**
     * Sets the value of the agreementFrench property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementFrench(String value) {
        this.agreementFrench = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     */
    public void setMandatory(boolean value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the nameEnglish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEnglish() {
        return nameEnglish;
    }

    /**
     * Sets the value of the nameEnglish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEnglish(String value) {
        this.nameEnglish = value;
    }

    /**
     * Gets the value of the nameFrench property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFrench() {
        return nameFrench;
    }

    /**
     * Sets the value of the nameFrench property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFrench(String value) {
        this.nameFrench = value;
    }

    /**
     * Gets the value of the ownerId property.
     * 
     */
    public short getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     */
    public void setOwnerId(short value) {
        this.ownerId = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setDuration(JAXBElement<Short> value) {
        this.duration = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentType }
     *     
     */
    public ConsentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentType }
     *     
     */
    public void setType(ConsentType value) {
        this.type = value;
    }

}
