
package com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ParameterValueOrFieldReference">
 *       &lt;sequence>
 *         &lt;element name="labelField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valueField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterValue", propOrder = {
    "labelField",
    "nameField",
    "valueField"
})
public class ParameterValue
    extends ParameterValueOrFieldReference
{

    @XmlElement(required = true, nillable = true)
    protected String labelField;
    @XmlElement(required = true, nillable = true)
    protected String nameField;
    @XmlElement(required = true, nillable = true)
    protected String valueField;

    /**
     * Gets the value of the labelField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelField() {
        return labelField;
    }

    /**
     * Sets the value of the labelField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelField(String value) {
        this.labelField = value;
    }

    /**
     * Gets the value of the nameField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameField() {
        return nameField;
    }

    /**
     * Sets the value of the nameField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameField(String value) {
        this.nameField = value;
    }

    /**
     * Gets the value of the valueField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueField() {
        return valueField;
    }

    /**
     * Sets the value of the valueField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueField(String value) {
        this.valueField = value;
    }

}
