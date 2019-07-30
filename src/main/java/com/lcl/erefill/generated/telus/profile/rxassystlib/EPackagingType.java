
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ePackagingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ePackagingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Multidose"/>
 *     &lt;enumeration value="Unidose"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ePackagingType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EPackagingType {

    @XmlEnumValue("Multidose")
    MULTIDOSE("Multidose"),
    @XmlEnumValue("Unidose")
    UNIDOSE("Unidose");
    private final String value;

    EPackagingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EPackagingType fromValue(String v) {
        for (EPackagingType c: EPackagingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
