
package com.lcl.erefill.generated.telus.session.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eProvince.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eProvince">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Alberta"/>
 *     &lt;enumeration value="BritishColumbia"/>
 *     &lt;enumeration value="Manitoba"/>
 *     &lt;enumeration value="NewBrunswick"/>
 *     &lt;enumeration value="Newfoundland"/>
 *     &lt;enumeration value="NovaScotia"/>
 *     &lt;enumeration value="Nunavut"/>
 *     &lt;enumeration value="NorthWestTerritories"/>
 *     &lt;enumeration value="Ontario"/>
 *     &lt;enumeration value="PrinceEdwardIsland"/>
 *     &lt;enumeration value="Quebec"/>
 *     &lt;enumeration value="Saskatchewan"/>
 *     &lt;enumeration value="Yukon"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eProvince", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EProvince {

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
    @XmlEnumValue("NorthWestTerritories")
    NORTH_WEST_TERRITORIES("NorthWestTerritories"),
    @XmlEnumValue("Ontario")
    ONTARIO("Ontario"),
    @XmlEnumValue("PrinceEdwardIsland")
    PRINCE_EDWARD_ISLAND("PrinceEdwardIsland"),
    @XmlEnumValue("Quebec")
    QUEBEC("Quebec"),
    @XmlEnumValue("Saskatchewan")
    SASKATCHEWAN("Saskatchewan"),
    @XmlEnumValue("Yukon")
    YUKON("Yukon");
    private final String value;

    EProvince(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EProvince fromValue(String v) {
        for (EProvince c: EProvince.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
