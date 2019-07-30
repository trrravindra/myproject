
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="User"/>
 *     &lt;enumeration value="Agent"/>
 *     &lt;enumeration value="BannerAdmin"/>
 *     &lt;enumeration value="PharmacyAdmin"/>
 *     &lt;enumeration value="SuperAdmin"/>
 *     &lt;enumeration value="Caregivers"/>
 *     &lt;enumeration value="FamilyManager"/>
 *     &lt;enumeration value="ExternalAgent"/>
 *     &lt;enumeration value="CustomerServiceRepresentative"/>
 *     &lt;enumeration value="ReportViewer"/>
 *     &lt;enumeration value="ClinicAgent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAccountType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAccountType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("User")
    USER("User"),
    @XmlEnumValue("Agent")
    AGENT("Agent"),
    @XmlEnumValue("BannerAdmin")
    BANNER_ADMIN("BannerAdmin"),
    @XmlEnumValue("PharmacyAdmin")
    PHARMACY_ADMIN("PharmacyAdmin"),
    @XmlEnumValue("SuperAdmin")
    SUPER_ADMIN("SuperAdmin"),
    @XmlEnumValue("Caregivers")
    CAREGIVERS("Caregivers"),
    @XmlEnumValue("FamilyManager")
    FAMILY_MANAGER("FamilyManager"),
    @XmlEnumValue("ExternalAgent")
    EXTERNAL_AGENT("ExternalAgent"),
    @XmlEnumValue("CustomerServiceRepresentative")
    CUSTOMER_SERVICE_REPRESENTATIVE("CustomerServiceRepresentative"),
    @XmlEnumValue("ReportViewer")
    REPORT_VIEWER("ReportViewer"),
    @XmlEnumValue("ClinicAgent")
    CLINIC_AGENT("ClinicAgent");
    private final String value;

    EAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAccountType fromValue(String v) {
        for (EAccountType c: EAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
