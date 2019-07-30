
package com.lcl.erefill.generated.telus.operation.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eOperationalEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eOperationalEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eRefillReminder"/>
 *     &lt;enumeration value="eAutomatedRefill"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eOperationalEventType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EOperationalEventType {

    @XmlEnumValue("eRefillReminder")
    E_REFILL_REMINDER("eRefillReminder"),
    @XmlEnumValue("eAutomatedRefill")
    E_AUTOMATED_REFILL("eAutomatedRefill");
    private final String value;

    EOperationalEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EOperationalEventType fromValue(String v) {
        for (EOperationalEventType c: EOperationalEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
