
package com.lcl.erefill.generated.telus.consent.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Enrollment"/>
 *     &lt;enumeration value="FamilyManager"/>
 *     &lt;enumeration value="FamilyMember"/>
 *     &lt;enumeration value="RenewalAuthorizationRequest"/>
 *     &lt;enumeration value="ManagerAccept"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsentType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ConsentType {

    @XmlEnumValue("Enrollment")
    ENROLLMENT("Enrollment"),
    @XmlEnumValue("FamilyManager")
    FAMILY_MANAGER("FamilyManager"),
    @XmlEnumValue("FamilyMember")
    FAMILY_MEMBER("FamilyMember"),
    @XmlEnumValue("RenewalAuthorizationRequest")
    RENEWAL_AUTHORIZATION_REQUEST("RenewalAuthorizationRequest"),
    @XmlEnumValue("ManagerAccept")
    MANAGER_ACCEPT("ManagerAccept");
    private final String value;

    ConsentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsentType fromValue(String v) {
        for (ConsentType c: ConsentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
