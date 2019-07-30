
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

import com.lcl.erefill.generated.telus.session.system.DayOfWeek;


/**
 * <p>Java class for EstablishmentOpeningHour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstablishmentOpeningHour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WeekDay" type="{http://schemas.datacontract.org/2004/07/System}DayOfWeek"/>
 *         &lt;element name="HourFrom" type="{http://schemas.microsoft.com/2003/10/Serialization/}duration"/>
 *         &lt;element name="HourTo" type="{http://schemas.microsoft.com/2003/10/Serialization/}duration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstablishmentOpeningHour", propOrder = {
    "weekDay",
    "hourFrom",
    "hourTo"
})
public class EstablishmentOpeningHour {

    @XmlElement(name = "WeekDay", required = true)
    protected DayOfWeek weekDay;
    @XmlElement(name = "HourFrom", required = true)
    protected Duration hourFrom;
    @XmlElement(name = "HourTo", required = true)
    protected Duration hourTo;

    /**
     * Gets the value of the weekDay property.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeek }
     *     
     */
    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    /**
     * Sets the value of the weekDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeek }
     *     
     */
    public void setWeekDay(DayOfWeek value) {
        this.weekDay = value;
    }

    /**
     * Gets the value of the hourFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getHourFrom() {
        return hourFrom;
    }

    /**
     * Sets the value of the hourFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setHourFrom(Duration value) {
        this.hourFrom = value;
    }

    /**
     * Gets the value of the hourTo property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getHourTo() {
        return hourTo;
    }

    /**
     * Sets the value of the hourTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setHourTo(Duration value) {
        this.hourTo = value;
    }

}
