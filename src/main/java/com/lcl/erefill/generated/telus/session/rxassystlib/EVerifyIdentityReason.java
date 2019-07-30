
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eVerifyIdentityReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eVerifyIdentityReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ok"/>
 *     &lt;enumeration value="PharmacyFieldUninitialized"/>
 *     &lt;enumeration value="Mismatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eVerifyIdentityReason", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EVerifyIdentityReason {

    @XmlEnumValue("Ok")
    OK("Ok"),
    @XmlEnumValue("PharmacyFieldUninitialized")
    PHARMACY_FIELD_UNINITIALIZED("PharmacyFieldUninitialized"),
    @XmlEnumValue("Mismatch")
    MISMATCH("Mismatch");
    private final String value;

    EVerifyIdentityReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EVerifyIdentityReason fromValue(String v) {
        for (EVerifyIdentityReason c: EVerifyIdentityReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
