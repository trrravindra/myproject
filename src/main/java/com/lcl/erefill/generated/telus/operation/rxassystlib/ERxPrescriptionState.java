
package com.lcl.erefill.generated.telus.operation.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eRxPrescriptionState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eRxPrescriptionState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Accepted"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="AcceptedWithoutInfo"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="ReceivedETARequired"/>
 *     &lt;enumeration value="ConditionalAccepted"/>
 *     &lt;enumeration value="ReadyToPickUp"/>
 *     &lt;enumeration value="Released"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eRxPrescriptionState", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ERxPrescriptionState {

    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("AcceptedWithoutInfo")
    ACCEPTED_WITHOUT_INFO("AcceptedWithoutInfo"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("ReceivedETARequired")
    RECEIVED_ETA_REQUIRED("ReceivedETARequired"),
    @XmlEnumValue("ConditionalAccepted")
    CONDITIONAL_ACCEPTED("ConditionalAccepted"),
    @XmlEnumValue("ReadyToPickUp")
    READY_TO_PICK_UP("ReadyToPickUp"),
    @XmlEnumValue("Released")
    RELEASED("Released");
    private final String value;

    ERxPrescriptionState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERxPrescriptionState fromValue(String v) {
        for (ERxPrescriptionState c: ERxPrescriptionState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
