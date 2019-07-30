
package com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eLanguage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eLanguage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="French"/>
 *     &lt;enumeration value="English"/>
 *     &lt;enumeration value="Italian"/>
 *     &lt;enumeration value="Spanish"/>
 *     &lt;enumeration value="Vietnamese"/>
 *     &lt;enumeration value="Chinese"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eLanguage", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ELanguage {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("French")
    FRENCH("French"),
    @XmlEnumValue("English")
    ENGLISH("English"),
    @XmlEnumValue("Italian")
    ITALIAN("Italian"),
    @XmlEnumValue("Spanish")
    SPANISH("Spanish"),
    @XmlEnumValue("Vietnamese")
    VIETNAMESE("Vietnamese"),
    @XmlEnumValue("Chinese")
    CHINESE("Chinese");
    private final String value;

    ELanguage(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ELanguage fromValue(String v) {
        for (ELanguage c: ELanguage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
