
package com.lcl.erefill.generated.telus.report.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eGroupBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eGroupBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Year"/>
 *     &lt;enumeration value="Month"/>
 *     &lt;enumeration value="Day"/>
 *     &lt;enumeration value="PostalCode"/>
 *     &lt;enumeration value="PharmacyContractNumber"/>
 *     &lt;enumeration value="Device"/>
 *     &lt;enumeration value="Din"/>
 *     &lt;enumeration value="Gender"/>
 *     &lt;enumeration value="PatientOid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eGroupBy", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EGroupBy {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Year")
    YEAR("Year"),
    @XmlEnumValue("Month")
    MONTH("Month"),
    @XmlEnumValue("Day")
    DAY("Day"),
    @XmlEnumValue("PostalCode")
    POSTAL_CODE("PostalCode"),
    @XmlEnumValue("PharmacyContractNumber")
    PHARMACY_CONTRACT_NUMBER("PharmacyContractNumber"),
    @XmlEnumValue("Device")
    DEVICE("Device"),
    @XmlEnumValue("Din")
    DIN("Din"),
    @XmlEnumValue("Gender")
    GENDER("Gender"),
    @XmlEnumValue("PatientOid")
    PATIENT_OID("PatientOid");
    private final String value;

    EGroupBy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EGroupBy fromValue(String v) {
        for (EGroupBy c: EGroupBy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
