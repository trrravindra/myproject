
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ePHNType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ePHNType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Alberta"/>
 *     &lt;enumeration value="BritishColumbia"/>
 *     &lt;enumeration value="Manitoba"/>
 *     &lt;enumeration value="NewBrunswick"/>
 *     &lt;enumeration value="Newfoundland"/>
 *     &lt;enumeration value="NovaScotia"/>
 *     &lt;enumeration value="Nunavut"/>
 *     &lt;enumeration value="NWT"/>
 *     &lt;enumeration value="Ontario"/>
 *     &lt;enumeration value="PEI"/>
 *     &lt;enumeration value="Quebec"/>
 *     &lt;enumeration value="Saskatchewan"/>
 *     &lt;enumeration value="Yukon"/>
 *     &lt;enumeration value="CanadianForces"/>
 *     &lt;enumeration value="RCMP"/>
 *     &lt;enumeration value="NSG"/>
 *     &lt;enumeration value="NSOU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ePHNType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EPHNType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Alberta")
    ALBERTA("Alberta"),
    @XmlEnumValue("BritishColumbia")
    BRITISH_COLUMBIA("BritishColumbia"),
    @XmlEnumValue("Manitoba")
    MANITOBA("Manitoba"),
    @XmlEnumValue("NewBrunswick")
    NEW_BRUNSWICK("NewBrunswick"),
    @XmlEnumValue("Newfoundland")
    NEWFOUNDLAND("Newfoundland"),
    @XmlEnumValue("NovaScotia")
    NOVA_SCOTIA("NovaScotia"),
    @XmlEnumValue("Nunavut")
    NUNAVUT("Nunavut"),
    NWT("NWT"),
    @XmlEnumValue("Ontario")
    ONTARIO("Ontario"),
    PEI("PEI"),
    @XmlEnumValue("Quebec")
    QUEBEC("Quebec"),
    @XmlEnumValue("Saskatchewan")
    SASKATCHEWAN("Saskatchewan"),
    @XmlEnumValue("Yukon")
    YUKON("Yukon"),
    @XmlEnumValue("CanadianForces")
    CANADIAN_FORCES("CanadianForces"),
    RCMP("RCMP"),
    NSG("NSG"),
    NSOU("NSOU");
    private final String value;

    EPHNType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EPHNType fromValue(String v) {
        for (EPHNType c: EPHNType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
