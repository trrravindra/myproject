
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eUnsubscribeRequestState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eUnsubscribeRequestState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Accept"/>
 *     &lt;enumeration value="Decline"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eUnsubscribeRequestState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EUnsubscribeRequestState {

    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Accept")
    ACCEPT("Accept"),
    @XmlEnumValue("Decline")
    DECLINE("Decline");
    private final String value;

    EUnsubscribeRequestState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EUnsubscribeRequestState fromValue(String v) {
        for (EUnsubscribeRequestState c: EUnsubscribeRequestState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
