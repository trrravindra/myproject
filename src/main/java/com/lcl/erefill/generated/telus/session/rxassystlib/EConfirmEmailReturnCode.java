
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eConfirmEmailReturnCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eConfirmEmailReturnCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="AlreadyConfirmed"/>
 *     &lt;enumeration value="Invalidkey"/>
 *     &lt;enumeration value="Cancelled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eConfirmEmailReturnCode", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EConfirmEmailReturnCode {

    OK("OK"),
    @XmlEnumValue("AlreadyConfirmed")
    ALREADY_CONFIRMED("AlreadyConfirmed"),
    @XmlEnumValue("Invalidkey")
    INVALIDKEY("Invalidkey"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled");
    private final String value;

    EConfirmEmailReturnCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EConfirmEmailReturnCode fromValue(String v) {
        for (EConfirmEmailReturnCode c: EConfirmEmailReturnCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
