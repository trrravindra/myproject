
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTimeZone.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTimeZone">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Utc0900Alaska"/>
 *     &lt;enumeration value="Utc0800PacificTimeUsCanada"/>
 *     &lt;enumeration value="Utc0700MountainTimeUsCanada"/>
 *     &lt;enumeration value="Utc0600CentralTimeUsCanada"/>
 *     &lt;enumeration value="Utc0600Saskatchewan"/>
 *     &lt;enumeration value="Utc0500EasternTimeUsCanada"/>
 *     &lt;enumeration value="Utc0400AtlanticTimeCanada"/>
 *     &lt;enumeration value="Utc0330Newfoundland"/>
 *     &lt;enumeration value="Utc0300Greenland"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTimeZone", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ETimeZone {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Utc0900Alaska")
    UTC_0900_ALASKA("Utc0900Alaska"),
    @XmlEnumValue("Utc0800PacificTimeUsCanada")
    UTC_0800_PACIFIC_TIME_US_CANADA("Utc0800PacificTimeUsCanada"),
    @XmlEnumValue("Utc0700MountainTimeUsCanada")
    UTC_0700_MOUNTAIN_TIME_US_CANADA("Utc0700MountainTimeUsCanada"),
    @XmlEnumValue("Utc0600CentralTimeUsCanada")
    UTC_0600_CENTRAL_TIME_US_CANADA("Utc0600CentralTimeUsCanada"),
    @XmlEnumValue("Utc0600Saskatchewan")
    UTC_0600_SASKATCHEWAN("Utc0600Saskatchewan"),
    @XmlEnumValue("Utc0500EasternTimeUsCanada")
    UTC_0500_EASTERN_TIME_US_CANADA("Utc0500EasternTimeUsCanada"),
    @XmlEnumValue("Utc0400AtlanticTimeCanada")
    UTC_0400_ATLANTIC_TIME_CANADA("Utc0400AtlanticTimeCanada"),
    @XmlEnumValue("Utc0330Newfoundland")
    UTC_0330_NEWFOUNDLAND("Utc0330Newfoundland"),
    @XmlEnumValue("Utc0300Greenland")
    UTC_0300_GREENLAND("Utc0300Greenland");
    private final String value;

    ETimeZone(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ETimeZone fromValue(String v) {
        for (ETimeZone c: ETimeZone.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
