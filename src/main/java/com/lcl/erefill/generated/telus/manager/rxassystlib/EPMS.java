
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ePMS.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ePMS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AssystRxL"/>
 *     &lt;enumeration value="Kroll"/>
 *     &lt;enumeration value="Ubik"/>
 *     &lt;enumeration value="AssystRxA"/>
 *     &lt;enumeration value="Simplicity"/>
 *     &lt;enumeration value="HealthWatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ePMS", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EPMS {

    @XmlEnumValue("AssystRxL")
    ASSYST_RX_L("AssystRxL"),
    @XmlEnumValue("Kroll")
    KROLL("Kroll"),
    @XmlEnumValue("Ubik")
    UBIK("Ubik"),
    @XmlEnumValue("AssystRxA")
    ASSYST_RX_A("AssystRxA"),
    @XmlEnumValue("Simplicity")
    SIMPLICITY("Simplicity"),
    @XmlEnumValue("HealthWatch")
    HEALTH_WATCH("HealthWatch");
    private final String value;

    EPMS(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EPMS fromValue(String v) {
        for (EPMS c: EPMS.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
