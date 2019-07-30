
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eContactType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eContactType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Cellular"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="School"/>
 *     &lt;enumeration value="Relatives"/>
 *     &lt;enumeration value="DayNursery"/>
 *     &lt;enumeration value="Pager"/>
 *     &lt;enumeration value="Home"/>
 *     &lt;enumeration value="Work"/>
 *     &lt;enumeration value="ParentOrGuardian"/>
 *     &lt;enumeration value="Comments"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eContactType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EContactType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Cellular")
    CELLULAR("Cellular"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("School")
    SCHOOL("School"),
    @XmlEnumValue("Relatives")
    RELATIVES("Relatives"),
    @XmlEnumValue("DayNursery")
    DAY_NURSERY("DayNursery"),
    @XmlEnumValue("Pager")
    PAGER("Pager"),
    @XmlEnumValue("Home")
    HOME("Home"),
    @XmlEnumValue("Work")
    WORK("Work"),
    @XmlEnumValue("ParentOrGuardian")
    PARENT_OR_GUARDIAN("ParentOrGuardian"),
    @XmlEnumValue("Comments")
    COMMENTS("Comments"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    EContactType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EContactType fromValue(String v) {
        for (EContactType c: EContactType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
