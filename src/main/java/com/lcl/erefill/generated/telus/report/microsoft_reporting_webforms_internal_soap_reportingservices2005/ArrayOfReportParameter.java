
package com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReportParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReportParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReportParameter" type="{http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution}ReportParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReportParameter", propOrder = {
    "reportParameter"
})
public class ArrayOfReportParameter {

    @XmlElement(name = "ReportParameter", nillable = true)
    protected List<ReportParameter> reportParameter;

    /**
     * Gets the value of the reportParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportParameter }
     * 
     * 
     */
    public List<ReportParameter> getReportParameter() {
        if (reportParameter == null) {
            reportParameter = new ArrayList<ReportParameter>();
        }
        return this.reportParameter;
    }

}
