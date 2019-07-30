
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

import com.lcl.erefill.generated.telus.manager.system.DayOfWeek;


/**
 * <p>Java class for PharmacyOpeningHour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacyOpeningHour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HourFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HourTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WeekDay" type="{http://schemas.datacontract.org/2004/07/System}DayOfWeek"/>
 *         &lt;element name="HourFromV2" type="{http://schemas.microsoft.com/2003/10/Serialization/}duration" minOccurs="0"/>
 *         &lt;element name="HourToV2" type="{http://schemas.microsoft.com/2003/10/Serialization/}duration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyOpeningHour", propOrder = {
    "hourFrom",
    "hourTo",
    "weekDay",
    "hourFromV2",
    "hourToV2"
})
public class PharmacyOpeningHour {

    @XmlElement(name = "HourFrom")
    protected Integer hourFrom;
    @XmlElement(name = "HourTo")
    protected Integer hourTo;
    @XmlElement(name = "WeekDay", required = true)
    protected DayOfWeek weekDay;
    @XmlElement(name = "HourFromV2")
    protected Duration hourFromV2;
    @XmlElement(name = "HourToV2")
    protected Duration hourToV2;

    /**
     * Gets the value of the hourFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHourFrom() {
        return hourFrom;
    }

    /**
     * Sets the value of the hourFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHourFrom(Integer value) {
        this.hourFrom = value;
    }

    /**
     * Gets the value of the hourTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHourTo() {
        return hourTo;
    }

    /**
     * Sets the value of the hourTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHourTo(Integer value) {
        this.hourTo = value;
    }

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
     * Gets the value of the hourFromV2 property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getHourFromV2() {
        return hourFromV2;
    }

    /**
     * Sets the value of the hourFromV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setHourFromV2(Duration value) {
        this.hourFromV2 = value;
    }

    /**
     * Gets the value of the hourToV2 property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getHourToV2() {
        return hourToV2;
    }

    /**
     * Sets the value of the hourToV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setHourToV2(Duration value) {
        this.hourToV2 = value;
    }

}
