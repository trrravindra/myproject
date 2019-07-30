
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eEventMessageState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eEventMessageState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Generated"/>
 *     &lt;enumeration value="Sent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eEventMessageState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EEventMessageState {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Generated")
    GENERATED("Generated"),
    @XmlEnumValue("Sent")
    SENT("Sent");
    private final String value;

    EEventMessageState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EEventMessageState fromValue(String v) {
        for (EEventMessageState c: EEventMessageState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
