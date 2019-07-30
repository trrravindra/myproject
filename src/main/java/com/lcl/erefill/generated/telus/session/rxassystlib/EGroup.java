
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eGroup.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eGroup">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Users"/>
 *     &lt;enumeration value="Agents"/>
 *     &lt;enumeration value="Caregivers"/>
 *     &lt;enumeration value="PharmacyManagers"/>
 *     &lt;enumeration value="Administrators"/>
 *     &lt;enumeration value="SuperAdministrators"/>
 *     &lt;enumeration value="Patients"/>
 *     &lt;enumeration value="FamilyManager"/>
 *     &lt;enumeration value="ExternalAgents"/>
 *     &lt;enumeration value="CustomerServiceRepresentative"/>
 *     &lt;enumeration value="ReportViewer"/>
 *     &lt;enumeration value="ClinicAgents"/>
 *     &lt;enumeration value="ClinicManagers"/>
 *     &lt;enumeration value="Implementors"/>
 *     &lt;enumeration value="CustomerServiceSupervisors"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eGroup", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EGroup {

    @XmlEnumValue("Users")
    USERS("Users"),
    @XmlEnumValue("Agents")
    AGENTS("Agents"),
    @XmlEnumValue("Caregivers")
    CAREGIVERS("Caregivers"),
    @XmlEnumValue("PharmacyManagers")
    PHARMACY_MANAGERS("PharmacyManagers"),
    @XmlEnumValue("Administrators")
    ADMINISTRATORS("Administrators"),
    @XmlEnumValue("SuperAdministrators")
    SUPER_ADMINISTRATORS("SuperAdministrators"),
    @XmlEnumValue("Patients")
    PATIENTS("Patients"),
    @XmlEnumValue("FamilyManager")
    FAMILY_MANAGER("FamilyManager"),
    @XmlEnumValue("ExternalAgents")
    EXTERNAL_AGENTS("ExternalAgents"),
    @XmlEnumValue("CustomerServiceRepresentative")
    CUSTOMER_SERVICE_REPRESENTATIVE("CustomerServiceRepresentative"),
    @XmlEnumValue("ReportViewer")
    REPORT_VIEWER("ReportViewer"),
    @XmlEnumValue("ClinicAgents")
    CLINIC_AGENTS("ClinicAgents"),
    @XmlEnumValue("ClinicManagers")
    CLINIC_MANAGERS("ClinicManagers"),
    @XmlEnumValue("Implementors")
    IMPLEMENTORS("Implementors"),
    @XmlEnumValue("CustomerServiceSupervisors")
    CUSTOMER_SERVICE_SUPERVISORS("CustomerServiceSupervisors");
    private final String value;

    EGroup(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EGroup fromValue(String v) {
        for (EGroup c: EGroup.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
