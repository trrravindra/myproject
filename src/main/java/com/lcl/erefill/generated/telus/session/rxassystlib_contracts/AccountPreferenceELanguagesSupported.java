
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountPreference.eLanguagesSupported.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountPreference.eLanguagesSupported">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Francais"/>
 *     &lt;enumeration value="English"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountPreference.eLanguagesSupported")
@XmlEnum
public enum AccountPreferenceELanguagesSupported {

    @XmlEnumValue("Francais")
    FRANCAIS("Francais"),
    @XmlEnumValue("English")
    ENGLISH("English");
    private final String value;

    AccountPreferenceELanguagesSupported(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountPreferenceELanguagesSupported fromValue(String v) {
        for (AccountPreferenceELanguagesSupported c: AccountPreferenceELanguagesSupported.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
