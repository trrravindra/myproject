
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="String"/>
 *     &lt;enumeration value="Int"/>
 *     &lt;enumeration value="Bool"/>
 *     &lt;enumeration value="IntPercent"/>
 *     &lt;enumeration value="IntMinute"/>
 *     &lt;enumeration value="IntMonth"/>
 *     &lt;enumeration value="StringHtml"/>
 *     &lt;enumeration value="IntDay"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eParameterType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EParameterType {

    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Int")
    INT("Int"),
    @XmlEnumValue("Bool")
    BOOL("Bool"),
    @XmlEnumValue("IntPercent")
    INT_PERCENT("IntPercent"),
    @XmlEnumValue("IntMinute")
    INT_MINUTE("IntMinute"),
    @XmlEnumValue("IntMonth")
    INT_MONTH("IntMonth"),
    @XmlEnumValue("StringHtml")
    STRING_HTML("StringHtml"),
    @XmlEnumValue("IntDay")
    INT_DAY("IntDay");
    private final String value;

    EParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EParameterType fromValue(String v) {
        for (EParameterType c: EParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
