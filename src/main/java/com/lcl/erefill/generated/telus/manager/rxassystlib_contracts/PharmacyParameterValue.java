
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EParameterType;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ESettingType;


/**
 * <p>Java class for PharmacyParameterValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacyParameterValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eParameterProperty"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eParameterType" minOccurs="0"/>
 *         &lt;element name="SettingType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eSettingType" minOccurs="0"/>
 *         &lt;element name="Culture" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}CultureValues" minOccurs="0"/>
 *         &lt;element name="FromDefault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Permissions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eParameterAccess" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyParameterValue", propOrder = {
    "name",
    "value",
    "type",
    "settingType",
    "culture",
    "fromDefault",
    "permissions"
})
public class PharmacyParameterValue {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Value", required = true, nillable = true)
    protected String value;
    @XmlElement(name = "Type")
    protected EParameterType type;
    @XmlElement(name = "SettingType")
    protected ESettingType settingType;
    @XmlElementRef(name = "Culture", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<CultureValues> culture;
    @XmlElement(name = "FromDefault")
    protected Boolean fromDefault;
    @XmlElementRef(name = "Permissions", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected List<JAXBElement<List<String>>> permissions;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EParameterType }
     *     
     */
    public EParameterType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EParameterType }
     *     
     */
    public void setType(EParameterType value) {
        this.type = value;
    }

    /**
     * Gets the value of the settingType property.
     * 
     * @return
     *     possible object is
     *     {@link ESettingType }
     *     
     */
    public ESettingType getSettingType() {
        return settingType;
    }

    /**
     * Sets the value of the settingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ESettingType }
     *     
     */
    public void setSettingType(ESettingType value) {
        this.settingType = value;
    }

    /**
     * Gets the value of the culture property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CultureValues }{@code >}
     *     
     */
    public JAXBElement<CultureValues> getCulture() {
        return culture;
    }

    /**
     * Sets the value of the culture property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CultureValues }{@code >}
     *     
     */
    public void setCulture(JAXBElement<CultureValues> value) {
        this.culture = value;
    }

    /**
     * Gets the value of the fromDefault property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFromDefault() {
        return fromDefault;
    }

    /**
     * Sets the value of the fromDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFromDefault(Boolean value) {
        this.fromDefault = value;
    }

    /**
     * Gets the value of the permissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * 
     */
    public List<JAXBElement<List<String>>> getPermissions() {
        if (permissions == null) {
            permissions = new ArrayList<JAXBElement<List<String>>>();
        }
        return this.permissions;
    }

}
