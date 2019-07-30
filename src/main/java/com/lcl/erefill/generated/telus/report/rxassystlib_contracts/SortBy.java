
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.report.rxassystlib.ESortBy;


/**
 * <p>Java class for SortBy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortBy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sort" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eSortBy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortBy", propOrder = {
    "sort"
})
public class SortBy {

    @XmlElement(name = "Sort")
    protected ESortBy sort;

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link ESortBy }
     *     
     */
    public ESortBy getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link ESortBy }
     *     
     */
    public void setSort(ESortBy value) {
        this.sort = value;
    }

}
