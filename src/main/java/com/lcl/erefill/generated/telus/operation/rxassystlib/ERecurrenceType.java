
package com.lcl.erefill.generated.telus.operation.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRecurrenceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRecurrenceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eDayBased"/>
 *     &lt;enumeration value="eMonthBased"/>
 *     &lt;enumeration value="eExpectedRefillDate"/>
 *     &lt;enumeration value="eOnce"/>
 *     &lt;enumeration value="eNbAttempt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRecurrenceType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERecurrenceType {

    @XmlEnumValue("eDayBased")
    E_DAY_BASED("eDayBased"),
    @XmlEnumValue("eMonthBased")
    E_MONTH_BASED("eMonthBased"),
    @XmlEnumValue("eExpectedRefillDate")
    E_EXPECTED_REFILL_DATE("eExpectedRefillDate"),
    @XmlEnumValue("eOnce")
    E_ONCE("eOnce"),
    @XmlEnumValue("eNbAttempt")
    E_NB_ATTEMPT("eNbAttempt");
    private final String value;

    ERecurrenceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERecurrenceType fromValue(String v) {
        for (ERecurrenceType c: ERecurrenceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
