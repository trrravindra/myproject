
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eLegalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eLegalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="GeneralPublic"/>
 *     &lt;enumeration value="PrescriptionRequired"/>
 *     &lt;enumeration value="Narcotic"/>
 *     &lt;enumeration value="ReportableNarcotic"/>
 *     &lt;enumeration value="Controlled"/>
 *     &lt;enumeration value="ReportableControlled"/>
 *     &lt;enumeration value="TargetSubstances"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eLegalStatus", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ELegalStatus {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("GeneralPublic")
    GENERAL_PUBLIC("GeneralPublic"),
    @XmlEnumValue("PrescriptionRequired")
    PRESCRIPTION_REQUIRED("PrescriptionRequired"),
    @XmlEnumValue("Narcotic")
    NARCOTIC("Narcotic"),
    @XmlEnumValue("ReportableNarcotic")
    REPORTABLE_NARCOTIC("ReportableNarcotic"),
    @XmlEnumValue("Controlled")
    CONTROLLED("Controlled"),
    @XmlEnumValue("ReportableControlled")
    REPORTABLE_CONTROLLED("ReportableControlled"),
    @XmlEnumValue("TargetSubstances")
    TARGET_SUBSTANCES("TargetSubstances");
    private final String value;

    ELegalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ELegalStatus fromValue(String v) {
        for (ELegalStatus c: ELegalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
