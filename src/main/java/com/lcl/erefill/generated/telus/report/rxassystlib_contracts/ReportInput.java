
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005.ArrayOfParameterValue;
import com.lcl.erefill.generated.telus.report.rxassystlib.ECulture;
import com.lcl.erefill.generated.telus.report.rxassystlib.EReportName;
import com.lcl.erefill.generated.telus.report.rxassystlib.EReportOutputFormat;


/**
 * <p>Java class for ReportInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReportName" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eReportName"/>
 *         &lt;element name="OutputFormat" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eReportOutputFormat"/>
 *         &lt;element name="ParametersValue" type="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ArrayOfParameterValue"/>
 *         &lt;element name="Culture" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eCulture"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportInput", propOrder = {
    "reportName",
    "outputFormat",
    "parametersValue",
    "culture"
})
public class ReportInput {

    @XmlElement(name = "ReportName", required = true)
    protected EReportName reportName;
    @XmlElement(name = "OutputFormat", required = true)
    protected EReportOutputFormat outputFormat;
    @XmlElement(name = "ParametersValue", required = true, nillable = true)
    protected ArrayOfParameterValue parametersValue;
    @XmlElement(name = "Culture", required = true)
    protected ECulture culture;

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link EReportName }
     *     
     */
    public EReportName getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EReportName }
     *     
     */
    public void setReportName(EReportName value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link EReportOutputFormat }
     *     
     */
    public EReportOutputFormat getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link EReportOutputFormat }
     *     
     */
    public void setOutputFormat(EReportOutputFormat value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the parametersValue property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfParameterValue }
     *     
     */
    public ArrayOfParameterValue getParametersValue() {
        return parametersValue;
    }

    /**
     * Sets the value of the parametersValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfParameterValue }
     *     
     */
    public void setParametersValue(ArrayOfParameterValue value) {
        this.parametersValue = value;
    }

    /**
     * Gets the value of the culture property.
     * 
     * @return
     *     possible object is
     *     {@link ECulture }
     *     
     */
    public ECulture getCulture() {
        return culture;
    }

    /**
     * Sets the value of the culture property.
     * 
     * @param value
     *     allowed object is
     *     {@link ECulture }
     *     
     */
    public void setCulture(ECulture value) {
        this.culture = value;
    }

}
