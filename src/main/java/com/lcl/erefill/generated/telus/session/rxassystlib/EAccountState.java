
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAccountState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAccountState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Deactived"/>
 *     &lt;enumeration value="Consent"/>
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="ExpiredMajority"/>
 *     &lt;enumeration value="Unconfirmed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAccountState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAccountState {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Deactived")
    DEACTIVED("Deactived"),
    @XmlEnumValue("Consent")
    CONSENT("Consent"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("ExpiredMajority")
    EXPIRED_MAJORITY("ExpiredMajority"),
    @XmlEnumValue("Unconfirmed")
    UNCONFIRMED("Unconfirmed");
    private final String value;

    EAccountState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAccountState fromValue(String v) {
        for (EAccountState c: EAccountState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
