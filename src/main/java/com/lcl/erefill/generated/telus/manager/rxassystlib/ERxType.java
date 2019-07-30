
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRxType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRxType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="StandardMedication"/>
 *     &lt;enumeration value="Treatment"/>
 *     &lt;enumeration value="Vaccine"/>
 *     &lt;enumeration value="Diet"/>
 *     &lt;enumeration value="SpecialCare"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRxType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERxType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("StandardMedication")
    STANDARD_MEDICATION("StandardMedication"),
    @XmlEnumValue("Treatment")
    TREATMENT("Treatment"),
    @XmlEnumValue("Vaccine")
    VACCINE("Vaccine"),
    @XmlEnumValue("Diet")
    DIET("Diet"),
    @XmlEnumValue("SpecialCare")
    SPECIAL_CARE("SpecialCare"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    ERxType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERxType fromValue(String v) {
        for (ERxType c: ERxType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
