
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eHierarchicalLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eHierarchicalLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Pharmacy"/>
 *     &lt;enumeration value="Province"/>
 *     &lt;enumeration value="Tenant"/>
 *     &lt;enumeration value="AllPharmacies"/>
 *     &lt;enumeration value="Region"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eHierarchicalLevel", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EHierarchicalLevel {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Pharmacy")
    PHARMACY("Pharmacy"),
    @XmlEnumValue("Province")
    PROVINCE("Province"),
    @XmlEnumValue("Tenant")
    TENANT("Tenant"),
    @XmlEnumValue("AllPharmacies")
    ALL_PHARMACIES("AllPharmacies"),
    @XmlEnumValue("Region")
    REGION("Region");
    private final String value;

    EHierarchicalLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EHierarchicalLevel fromValue(String v) {
        for (EHierarchicalLevel c: EHierarchicalLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
