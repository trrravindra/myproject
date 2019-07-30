
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eServiceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Regular"/>
 *     &lt;enumeration value="Syringes"/>
 *     &lt;enumeration value="Dietetics"/>
 *     &lt;enumeration value="Compound"/>
 *     &lt;enumeration value="Additive"/>
 *     &lt;enumeration value="SpecialFee"/>
 *     &lt;enumeration value="SpecialFeeParenteral"/>
 *     &lt;enumeration value="Opinion"/>
 *     &lt;enumeration value="Refusal"/>
 *     &lt;enumeration value="DesignatedPharmacist"/>
 *     &lt;enumeration value="VeteransService"/>
 *     &lt;enumeration value="RoomOfSpacing"/>
 *     &lt;enumeration value="ChamberMask"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eServiceType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EServiceType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Regular")
    REGULAR("Regular"),
    @XmlEnumValue("Syringes")
    SYRINGES("Syringes"),
    @XmlEnumValue("Dietetics")
    DIETETICS("Dietetics"),
    @XmlEnumValue("Compound")
    COMPOUND("Compound"),
    @XmlEnumValue("Additive")
    ADDITIVE("Additive"),
    @XmlEnumValue("SpecialFee")
    SPECIAL_FEE("SpecialFee"),
    @XmlEnumValue("SpecialFeeParenteral")
    SPECIAL_FEE_PARENTERAL("SpecialFeeParenteral"),
    @XmlEnumValue("Opinion")
    OPINION("Opinion"),
    @XmlEnumValue("Refusal")
    REFUSAL("Refusal"),
    @XmlEnumValue("DesignatedPharmacist")
    DESIGNATED_PHARMACIST("DesignatedPharmacist"),
    @XmlEnumValue("VeteransService")
    VETERANS_SERVICE("VeteransService"),
    @XmlEnumValue("RoomOfSpacing")
    ROOM_OF_SPACING("RoomOfSpacing"),
    @XmlEnumValue("ChamberMask")
    CHAMBER_MASK("ChamberMask");
    private final String value;

    EServiceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EServiceType fromValue(String v) {
        for (EServiceType c: EServiceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
