
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eCalendarType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eCalendarType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotInitialized"/>
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Cyclic"/>
 *     &lt;enumeration value="AscendingDescending"/>
 *     &lt;enumeration value="Monthly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eCalendarType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ECalendarType {

    @XmlEnumValue("NotInitialized")
    NOT_INITIALIZED("NotInitialized"),
    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("Cyclic")
    CYCLIC("Cyclic"),
    @XmlEnumValue("AscendingDescending")
    ASCENDING_DESCENDING("AscendingDescending"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly");
    private final String value;

    ECalendarType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ECalendarType fromValue(String v) {
        for (ECalendarType c: ECalendarType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
