
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eUnsubscribeReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eUnsubscribeReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AccountNeverActivated"/>
 *     &lt;enumeration value="InactiveAccount"/>
 *     &lt;enumeration value="ConsentExpired"/>
 *     &lt;enumeration value="MoveToAnotherLocation"/>
 *     &lt;enumeration value="MoveToAnotherPharmacy"/>
 *     &lt;enumeration value="FindWebsiteDifficultToUse"/>
 *     &lt;enumeration value="FindTheServiceUnreliable"/>
 *     &lt;enumeration value="FindTheWebsiteToBeInflexible"/>
 *     &lt;enumeration value="DoNotLikeThisService"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eUnsubscribeReason", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EUnsubscribeReason {

    @XmlEnumValue("AccountNeverActivated")
    ACCOUNT_NEVER_ACTIVATED("AccountNeverActivated"),
    @XmlEnumValue("InactiveAccount")
    INACTIVE_ACCOUNT("InactiveAccount"),
    @XmlEnumValue("ConsentExpired")
    CONSENT_EXPIRED("ConsentExpired"),
    @XmlEnumValue("MoveToAnotherLocation")
    MOVE_TO_ANOTHER_LOCATION("MoveToAnotherLocation"),
    @XmlEnumValue("MoveToAnotherPharmacy")
    MOVE_TO_ANOTHER_PHARMACY("MoveToAnotherPharmacy"),
    @XmlEnumValue("FindWebsiteDifficultToUse")
    FIND_WEBSITE_DIFFICULT_TO_USE("FindWebsiteDifficultToUse"),
    @XmlEnumValue("FindTheServiceUnreliable")
    FIND_THE_SERVICE_UNRELIABLE("FindTheServiceUnreliable"),
    @XmlEnumValue("FindTheWebsiteToBeInflexible")
    FIND_THE_WEBSITE_TO_BE_INFLEXIBLE("FindTheWebsiteToBeInflexible"),
    @XmlEnumValue("DoNotLikeThisService")
    DO_NOT_LIKE_THIS_SERVICE("DoNotLikeThisService"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    EUnsubscribeReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EUnsubscribeReason fromValue(String v) {
        for (EUnsubscribeReason c: EUnsubscribeReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
