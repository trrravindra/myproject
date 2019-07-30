
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eEmailReturnCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eEmailReturnCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Invalidkey"/>
 *     &lt;enumeration value="PharmacyValue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eEmailReturnCode", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EEmailReturnCode {

    OK("OK"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Invalidkey")
    INVALIDKEY("Invalidkey"),
    @XmlEnumValue("PharmacyValue")
    PHARMACY_VALUE("PharmacyValue");
    private final String value;

    EEmailReturnCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EEmailReturnCode fromValue(String v) {
        for (EEmailReturnCode c: EEmailReturnCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
