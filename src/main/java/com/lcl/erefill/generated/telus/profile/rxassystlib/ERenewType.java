
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRenewType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRenewType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotIndicated"/>
 *     &lt;enumeration value="Repeatable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRenewType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERenewType {

    @XmlEnumValue("NotIndicated")
    NOT_INDICATED("NotIndicated"),
    @XmlEnumValue("Repeatable")
    REPEATABLE("Repeatable");
    private final String value;

    ERenewType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERenewType fromValue(String v) {
        for (ERenewType c: ERenewType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
