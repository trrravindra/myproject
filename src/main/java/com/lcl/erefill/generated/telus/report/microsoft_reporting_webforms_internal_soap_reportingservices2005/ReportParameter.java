
package com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.report.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Java class for ReportParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowBlankField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowBlankFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultValuesField" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring"/>
 *         &lt;element name="defaultValuesQueryBasedField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultValuesQueryBasedFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dependenciesField" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring"/>
 *         &lt;element name="errorMessageField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="multiValueField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multiValueFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nameField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nullableField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nullableFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="promptField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="promptUserField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="promptUserFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="queryParameterField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="queryParameterFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="stateField" type="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ParameterStateEnum"/>
 *         &lt;element name="stateFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="typeField" type="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ParameterTypeEnum"/>
 *         &lt;element name="typeFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="validValuesField" type="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ArrayOfValidValue"/>
 *         &lt;element name="validValuesQueryBasedField" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="validValuesQueryBasedFieldSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportParameter", propOrder = {
    "allowBlankField",
    "allowBlankFieldSpecified",
    "defaultValuesField",
    "defaultValuesQueryBasedField",
    "defaultValuesQueryBasedFieldSpecified",
    "dependenciesField",
    "errorMessageField",
    "multiValueField",
    "multiValueFieldSpecified",
    "nameField",
    "nullableField",
    "nullableFieldSpecified",
    "promptField",
    "promptUserField",
    "promptUserFieldSpecified",
    "queryParameterField",
    "queryParameterFieldSpecified",
    "stateField",
    "stateFieldSpecified",
    "typeField",
    "typeFieldSpecified",
    "validValuesField",
    "validValuesQueryBasedField",
    "validValuesQueryBasedFieldSpecified"
})
public class ReportParameter {

    protected boolean allowBlankField;
    protected boolean allowBlankFieldSpecified;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfstring defaultValuesField;
    protected boolean defaultValuesQueryBasedField;
    protected boolean defaultValuesQueryBasedFieldSpecified;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfstring dependenciesField;
    @XmlElement(required = true, nillable = true)
    protected String errorMessageField;
    protected boolean multiValueField;
    protected boolean multiValueFieldSpecified;
    @XmlElement(required = true, nillable = true)
    protected String nameField;
    protected boolean nullableField;
    protected boolean nullableFieldSpecified;
    @XmlElement(required = true, nillable = true)
    protected String promptField;
    protected boolean promptUserField;
    protected boolean promptUserFieldSpecified;
    protected boolean queryParameterField;
    protected boolean queryParameterFieldSpecified;
    @XmlElement(required = true)
    protected ParameterStateEnum stateField;
    protected boolean stateFieldSpecified;
    @XmlElement(required = true)
    protected ParameterTypeEnum typeField;
    protected boolean typeFieldSpecified;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfValidValue validValuesField;
    protected boolean validValuesQueryBasedField;
    protected boolean validValuesQueryBasedFieldSpecified;

    /**
     * Gets the value of the allowBlankField property.
     * 
     */
    public boolean isAllowBlankField() {
        return allowBlankField;
    }

    /**
     * Sets the value of the allowBlankField property.
     * 
     */
    public void setAllowBlankField(boolean value) {
        this.allowBlankField = value;
    }

    /**
     * Gets the value of the allowBlankFieldSpecified property.
     * 
     */
    public boolean isAllowBlankFieldSpecified() {
        return allowBlankFieldSpecified;
    }

    /**
     * Sets the value of the allowBlankFieldSpecified property.
     * 
     */
    public void setAllowBlankFieldSpecified(boolean value) {
        this.allowBlankFieldSpecified = value;
    }

    /**
     * Gets the value of the defaultValuesField property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getDefaultValuesField() {
        return defaultValuesField;
    }

    /**
     * Sets the value of the defaultValuesField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setDefaultValuesField(ArrayOfstring value) {
        this.defaultValuesField = value;
    }

    /**
     * Gets the value of the defaultValuesQueryBasedField property.
     * 
     */
    public boolean isDefaultValuesQueryBasedField() {
        return defaultValuesQueryBasedField;
    }

    /**
     * Sets the value of the defaultValuesQueryBasedField property.
     * 
     */
    public void setDefaultValuesQueryBasedField(boolean value) {
        this.defaultValuesQueryBasedField = value;
    }

    /**
     * Gets the value of the defaultValuesQueryBasedFieldSpecified property.
     * 
     */
    public boolean isDefaultValuesQueryBasedFieldSpecified() {
        return defaultValuesQueryBasedFieldSpecified;
    }

    /**
     * Sets the value of the defaultValuesQueryBasedFieldSpecified property.
     * 
     */
    public void setDefaultValuesQueryBasedFieldSpecified(boolean value) {
        this.defaultValuesQueryBasedFieldSpecified = value;
    }

    /**
     * Gets the value of the dependenciesField property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getDependenciesField() {
        return dependenciesField;
    }

    /**
     * Sets the value of the dependenciesField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setDependenciesField(ArrayOfstring value) {
        this.dependenciesField = value;
    }

    /**
     * Gets the value of the errorMessageField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessageField() {
        return errorMessageField;
    }

    /**
     * Sets the value of the errorMessageField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessageField(String value) {
        this.errorMessageField = value;
    }

    /**
     * Gets the value of the multiValueField property.
     * 
     */
    public boolean isMultiValueField() {
        return multiValueField;
    }

    /**
     * Sets the value of the multiValueField property.
     * 
     */
    public void setMultiValueField(boolean value) {
        this.multiValueField = value;
    }

    /**
     * Gets the value of the multiValueFieldSpecified property.
     * 
     */
    public boolean isMultiValueFieldSpecified() {
        return multiValueFieldSpecified;
    }

    /**
     * Sets the value of the multiValueFieldSpecified property.
     * 
     */
    public void setMultiValueFieldSpecified(boolean value) {
        this.multiValueFieldSpecified = value;
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
     * Gets the value of the nullableField property.
     * 
     */
    public boolean isNullableField() {
        return nullableField;
    }

    /**
     * Sets the value of the nullableField property.
     * 
     */
    public void setNullableField(boolean value) {
        this.nullableField = value;
    }

    /**
     * Gets the value of the nullableFieldSpecified property.
     * 
     */
    public boolean isNullableFieldSpecified() {
        return nullableFieldSpecified;
    }

    /**
     * Sets the value of the nullableFieldSpecified property.
     * 
     */
    public void setNullableFieldSpecified(boolean value) {
        this.nullableFieldSpecified = value;
    }

    /**
     * Gets the value of the promptField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromptField() {
        return promptField;
    }

    /**
     * Sets the value of the promptField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromptField(String value) {
        this.promptField = value;
    }

    /**
     * Gets the value of the promptUserField property.
     * 
     */
    public boolean isPromptUserField() {
        return promptUserField;
    }

    /**
     * Sets the value of the promptUserField property.
     * 
     */
    public void setPromptUserField(boolean value) {
        this.promptUserField = value;
    }

    /**
     * Gets the value of the promptUserFieldSpecified property.
     * 
     */
    public boolean isPromptUserFieldSpecified() {
        return promptUserFieldSpecified;
    }

    /**
     * Sets the value of the promptUserFieldSpecified property.
     * 
     */
    public void setPromptUserFieldSpecified(boolean value) {
        this.promptUserFieldSpecified = value;
    }

    /**
     * Gets the value of the queryParameterField property.
     * 
     */
    public boolean isQueryParameterField() {
        return queryParameterField;
    }

    /**
     * Sets the value of the queryParameterField property.
     * 
     */
    public void setQueryParameterField(boolean value) {
        this.queryParameterField = value;
    }

    /**
     * Gets the value of the queryParameterFieldSpecified property.
     * 
     */
    public boolean isQueryParameterFieldSpecified() {
        return queryParameterFieldSpecified;
    }

    /**
     * Sets the value of the queryParameterFieldSpecified property.
     * 
     */
    public void setQueryParameterFieldSpecified(boolean value) {
        this.queryParameterFieldSpecified = value;
    }

    /**
     * Gets the value of the stateField property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterStateEnum }
     *     
     */
    public ParameterStateEnum getStateField() {
        return stateField;
    }

    /**
     * Sets the value of the stateField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterStateEnum }
     *     
     */
    public void setStateField(ParameterStateEnum value) {
        this.stateField = value;
    }

    /**
     * Gets the value of the stateFieldSpecified property.
     * 
     */
    public boolean isStateFieldSpecified() {
        return stateFieldSpecified;
    }

    /**
     * Sets the value of the stateFieldSpecified property.
     * 
     */
    public void setStateFieldSpecified(boolean value) {
        this.stateFieldSpecified = value;
    }

    /**
     * Gets the value of the typeField property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterTypeEnum }
     *     
     */
    public ParameterTypeEnum getTypeField() {
        return typeField;
    }

    /**
     * Sets the value of the typeField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterTypeEnum }
     *     
     */
    public void setTypeField(ParameterTypeEnum value) {
        this.typeField = value;
    }

    /**
     * Gets the value of the typeFieldSpecified property.
     * 
     */
    public boolean isTypeFieldSpecified() {
        return typeFieldSpecified;
    }

    /**
     * Sets the value of the typeFieldSpecified property.
     * 
     */
    public void setTypeFieldSpecified(boolean value) {
        this.typeFieldSpecified = value;
    }

    /**
     * Gets the value of the validValuesField property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfValidValue }
     *     
     */
    public ArrayOfValidValue getValidValuesField() {
        return validValuesField;
    }

    /**
     * Sets the value of the validValuesField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfValidValue }
     *     
     */
    public void setValidValuesField(ArrayOfValidValue value) {
        this.validValuesField = value;
    }

    /**
     * Gets the value of the validValuesQueryBasedField property.
     * 
     */
    public boolean isValidValuesQueryBasedField() {
        return validValuesQueryBasedField;
    }

    /**
     * Sets the value of the validValuesQueryBasedField property.
     * 
     */
    public void setValidValuesQueryBasedField(boolean value) {
        this.validValuesQueryBasedField = value;
    }

    /**
     * Gets the value of the validValuesQueryBasedFieldSpecified property.
     * 
     */
    public boolean isValidValuesQueryBasedFieldSpecified() {
        return validValuesQueryBasedFieldSpecified;
    }

    /**
     * Sets the value of the validValuesQueryBasedFieldSpecified property.
     * 
     */
    public void setValidValuesQueryBasedFieldSpecified(boolean value) {
        this.validValuesQueryBasedFieldSpecified = value;
    }

}
