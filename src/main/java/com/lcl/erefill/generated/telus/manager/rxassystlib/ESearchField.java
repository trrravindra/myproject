
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eSearchField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eSearchField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AccountLastName"/>
 *     &lt;enumeration value="AccountFirstName"/>
 *     &lt;enumeration value="AccountUsername"/>
 *     &lt;enumeration value="AccountAlias"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eSearchField", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ESearchField {

    @XmlEnumValue("AccountLastName")
    ACCOUNT_LAST_NAME("AccountLastName"),
    @XmlEnumValue("AccountFirstName")
    ACCOUNT_FIRST_NAME("AccountFirstName"),
    @XmlEnumValue("AccountUsername")
    ACCOUNT_USERNAME("AccountUsername"),
    @XmlEnumValue("AccountAlias")
    ACCOUNT_ALIAS("AccountAlias");
    private final String value;

    ESearchField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ESearchField fromValue(String v) {
        for (ESearchField c: ESearchField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
