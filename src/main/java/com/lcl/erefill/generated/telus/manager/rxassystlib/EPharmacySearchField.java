
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ePharmacySearchField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ePharmacySearchField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ContractNumber"/>
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Province"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ePharmacySearchField", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EPharmacySearchField {

    @XmlEnumValue("ContractNumber")
    CONTRACT_NUMBER("ContractNumber"),
    @XmlEnumValue("Name")
    NAME("Name"),
    @XmlEnumValue("Province")
    PROVINCE("Province");
    private final String value;

    EPharmacySearchField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EPharmacySearchField fromValue(String v) {
        for (EPharmacySearchField c: EPharmacySearchField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
