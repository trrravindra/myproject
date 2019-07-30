
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eFamilyManagerAssignRequestState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eFamilyManagerAssignRequestState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Accepted"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Revoked"/>
 *     &lt;enumeration value="Expired"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eFamilyManagerAssignRequestState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EFamilyManagerAssignRequestState {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Revoked")
    REVOKED("Revoked"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired");
    private final String value;

    EFamilyManagerAssignRequestState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EFamilyManagerAssignRequestState fromValue(String v) {
        for (EFamilyManagerAssignRequestState c: EFamilyManagerAssignRequestState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
