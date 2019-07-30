
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eDeliveryStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eDeliveryStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Released"/>
 *     &lt;enumeration value="WillPickUp"/>
 *     &lt;enumeration value="ReleasePending"/>
 *     &lt;enumeration value="ForDelivery"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eDeliveryStatus", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EDeliveryStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Released")
    RELEASED("Released"),
    @XmlEnumValue("WillPickUp")
    WILL_PICK_UP("WillPickUp"),
    @XmlEnumValue("ReleasePending")
    RELEASE_PENDING("ReleasePending"),
    @XmlEnumValue("ForDelivery")
    FOR_DELIVERY("ForDelivery");
    private final String value;

    EDeliveryStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EDeliveryStatus fromValue(String v) {
        for (EDeliveryStatus c: EDeliveryStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
