
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.report.rxassystlib.EReportName;


/**
 * <p>Java class for ReportName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eReportName"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportName", propOrder = {
    "name"
})
public class ReportName {

    @XmlElement(name = "Name", required = true)
    protected EReportName name;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link EReportName }
     *     
     */
    public EReportName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link EReportName }
     *     
     */
    public void setName(EReportName value) {
        this.name = value;
    }

}
