
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRequestState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRequestState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRequestState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERequestState {

    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    ERequestState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERequestState fromValue(String v) {
        for (ERequestState c: ERequestState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
