
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.ArrayOfeParameterProperty;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ESettingType;


/**
 * <p>Java class for FilterParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParametersList" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ArrayOfeParameterProperty" minOccurs="0"/>
 *         &lt;element name="SettingType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eSettingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterParameters", propOrder = {
    "parametersList",
    "settingType"
})
public class FilterParameters {

    @XmlElementRef(name = "ParametersList", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfeParameterProperty> parametersList;
    @XmlElement(name = "SettingType")
    protected ESettingType settingType;

    /**
     * Gets the value of the parametersList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfeParameterProperty }{@code >}
     *     
     */
    public JAXBElement<ArrayOfeParameterProperty> getParametersList() {
        return parametersList;
    }

    /**
     * Sets the value of the parametersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfeParameterProperty }{@code >}
     *     
     */
    public void setParametersList(JAXBElement<ArrayOfeParameterProperty> value) {
        this.parametersList = value;
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

}
