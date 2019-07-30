
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRestriction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRestriction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="NoRefill"/>
 *     &lt;enumeration value="EarlyRefill"/>
 *     &lt;enumeration value="Narcotic"/>
 *     &lt;enumeration value="Controlled"/>
 *     &lt;enumeration value="FilteredOut"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRestriction", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERestriction {

    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("NoRefill")
    NO_REFILL("NoRefill"),
    @XmlEnumValue("EarlyRefill")
    EARLY_REFILL("EarlyRefill"),
    @XmlEnumValue("Narcotic")
    NARCOTIC("Narcotic"),
    @XmlEnumValue("Controlled")
    CONTROLLED("Controlled"),
    @XmlEnumValue("FilteredOut")
    FILTERED_OUT("FilteredOut");
    private final String value;

    ERestriction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERestriction fromValue(String v) {
        for (ERestriction c: ERestriction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
