
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAssignmentAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAssignmentAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Assign"/>
 *     &lt;enumeration value="Unassign"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAssignmentAction", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAssignmentAction {

    @XmlEnumValue("Assign")
    ASSIGN("Assign"),
    @XmlEnumValue("Unassign")
    UNASSIGN("Unassign");
    private final String value;

    EAssignmentAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAssignmentAction fromValue(String v) {
        for (EAssignmentAction c: EAssignmentAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
