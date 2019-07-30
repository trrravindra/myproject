
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAccountReceivable.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAccountReceivable">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Personnal"/>
 *     &lt;enumeration value="Family"/>
 *     &lt;enumeration value="Facility"/>
 *     &lt;enumeration value="POS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAccountReceivable", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAccountReceivable {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Personnal")
    PERSONNAL("Personnal"),
    @XmlEnumValue("Family")
    FAMILY("Family"),
    @XmlEnumValue("Facility")
    FACILITY("Facility"),
    POS("POS");
    private final String value;

    EAccountReceivable(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAccountReceivable fromValue(String v) {
        for (EAccountReceivable c: EAccountReceivable.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
