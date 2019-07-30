
package com.lcl.erefill.generated.telus.operation.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eOperationalEventState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eOperationalEventState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eActive"/>
 *     &lt;enumeration value="eInactive"/>
 *     &lt;enumeration value="eExpired"/>
 *     &lt;enumeration value="eError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eOperationalEventState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EOperationalEventState {

    @XmlEnumValue("eActive")
    E_ACTIVE("eActive"),
    @XmlEnumValue("eInactive")
    E_INACTIVE("eInactive"),
    @XmlEnumValue("eExpired")
    E_EXPIRED("eExpired"),
    @XmlEnumValue("eError")
    E_ERROR("eError");
    private final String value;

    EOperationalEventState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EOperationalEventState fromValue(String v) {
        for (EOperationalEventState c: EOperationalEventState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
