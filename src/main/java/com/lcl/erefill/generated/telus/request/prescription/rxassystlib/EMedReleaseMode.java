
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eMedReleaseMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eMedReleaseMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pickup"/>
 *     &lt;enumeration value="Delivery"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eMedReleaseMode", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EMedReleaseMode {

    @XmlEnumValue("Pickup")
    PICKUP("Pickup"),
    @XmlEnumValue("Delivery")
    DELIVERY("Delivery");
    private final String value;

    EMedReleaseMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EMedReleaseMode fromValue(String v) {
        for (EMedReleaseMode c: EMedReleaseMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
