
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportMonthlyData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportMonthlyData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}StatisticResult">
 *       &lt;sequence>
 *         &lt;element name="Nb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportMonthlyData", propOrder = {
    "nb",
    "year",
    "month",
    "operation",
    "pms"
})
public class ReportMonthlyData
    extends StatisticResult
{

    @XmlElement(name = "Nb")
    protected int nb;
    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "Month")
    protected int month;
    @XmlElement(name = "Operation")
    protected int operation;
    @XmlElement(name = "Pms")
    protected int pms;

    /**
     * Gets the value of the nb property.
     * 
     */
    public int getNb() {
        return nb;
    }

    /**
     * Sets the value of the nb property.
     * 
     */
    public void setNb(int value) {
        this.nb = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the month property.
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     */
    public int getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     */
    public void setOperation(int value) {
        this.operation = value;
    }

    /**
     * Gets the value of the pms property.
     * 
     */
    public int getPms() {
        return pms;
    }

    /**
     * Sets the value of the pms property.
     * 
     */
    public void setPms(int value) {
        this.pms = value;
    }

}
