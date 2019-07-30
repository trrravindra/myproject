
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eSettingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eSettingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="TimeManagement"/>
 *     &lt;enumeration value="PrescriptionManagement"/>
 *     &lt;enumeration value="MessageManagement"/>
 *     &lt;enumeration value="ServiceManagement"/>
 *     &lt;enumeration value="RestrictionManagement"/>
 *     &lt;enumeration value="ConsentManagement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eSettingType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ESettingType {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("TimeManagement")
    TIME_MANAGEMENT("TimeManagement"),
    @XmlEnumValue("PrescriptionManagement")
    PRESCRIPTION_MANAGEMENT("PrescriptionManagement"),
    @XmlEnumValue("MessageManagement")
    MESSAGE_MANAGEMENT("MessageManagement"),
    @XmlEnumValue("ServiceManagement")
    SERVICE_MANAGEMENT("ServiceManagement"),
    @XmlEnumValue("RestrictionManagement")
    RESTRICTION_MANAGEMENT("RestrictionManagement"),
    @XmlEnumValue("ConsentManagement")
    CONSENT_MANAGEMENT("ConsentManagement");
    private final String value;

    ESettingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ESettingType fromValue(String v) {
        for (ESettingType c: ESettingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
