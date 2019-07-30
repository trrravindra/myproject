
package com.lcl.erefill.generated.telus.report.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eCulture.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eCulture">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="en_CA"/>
 *     &lt;enumeration value="en_US"/>
 *     &lt;enumeration value="fr_CA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eCulture", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum ECulture {

    @XmlEnumValue("en_CA")
    EN_CA("en_CA"),
    @XmlEnumValue("en_US")
    EN_US("en_US"),
    @XmlEnumValue("fr_CA")
    FR_CA("fr_CA");
    private final String value;

    ECulture(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ECulture fromValue(String v) {
        for (ECulture c: ECulture.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
