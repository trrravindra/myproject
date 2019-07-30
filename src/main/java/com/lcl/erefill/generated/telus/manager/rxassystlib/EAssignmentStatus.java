
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAssignmentStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAssignmentStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Assigned"/>
 *     &lt;enumeration value="Unassigned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAssignmentStatus", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAssignmentStatus {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Assigned")
    ASSIGNED("Assigned"),
    @XmlEnumValue("Unassigned")
    UNASSIGNED("Unassigned");
    private final String value;

    EAssignmentStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAssignmentStatus fromValue(String v) {
        for (EAssignmentStatus c: EAssignmentStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
