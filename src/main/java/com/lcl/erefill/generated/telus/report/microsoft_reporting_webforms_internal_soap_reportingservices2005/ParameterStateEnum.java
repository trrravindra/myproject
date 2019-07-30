
package com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterStateEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterStateEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HasValidValue"/>
 *     &lt;enumeration value="MissingValidValue"/>
 *     &lt;enumeration value="HasOutstandingDependencies"/>
 *     &lt;enumeration value="DynamicValuesUnavailable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParameterStateEnum")
@XmlEnum
public enum ParameterStateEnum {

    @XmlEnumValue("HasValidValue")
    HAS_VALID_VALUE("HasValidValue"),
    @XmlEnumValue("MissingValidValue")
    MISSING_VALID_VALUE("MissingValidValue"),
    @XmlEnumValue("HasOutstandingDependencies")
    HAS_OUTSTANDING_DEPENDENCIES("HasOutstandingDependencies"),
    @XmlEnumValue("DynamicValuesUnavailable")
    DYNAMIC_VALUES_UNAVAILABLE("DynamicValuesUnavailable");
    private final String value;

    ParameterStateEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParameterStateEnum fromValue(String v) {
        for (ParameterStateEnum c: ParameterStateEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
