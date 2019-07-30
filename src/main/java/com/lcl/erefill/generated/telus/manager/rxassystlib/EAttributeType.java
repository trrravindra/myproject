
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAttributeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAttributeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="NewSigned"/>
 *     &lt;enumeration value="NewVerbal"/>
 *     &lt;enumeration value="DeferredSigned"/>
 *     &lt;enumeration value="DeferredVerbal"/>
 *     &lt;enumeration value="RefillSigned"/>
 *     &lt;enumeration value="RefillVerbal"/>
 *     &lt;enumeration value="OverTheCounter"/>
 *     &lt;enumeration value="ReferenceMedication"/>
 *     &lt;enumeration value="TaxableProduct"/>
 *     &lt;enumeration value="FederalTaxableProduct"/>
 *     &lt;enumeration value="ProvincialTaxableProduct"/>
 *     &lt;enumeration value="NotTaxableProduct"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAttributeType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAttributeType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("NewSigned")
    NEW_SIGNED("NewSigned"),
    @XmlEnumValue("NewVerbal")
    NEW_VERBAL("NewVerbal"),
    @XmlEnumValue("DeferredSigned")
    DEFERRED_SIGNED("DeferredSigned"),
    @XmlEnumValue("DeferredVerbal")
    DEFERRED_VERBAL("DeferredVerbal"),
    @XmlEnumValue("RefillSigned")
    REFILL_SIGNED("RefillSigned"),
    @XmlEnumValue("RefillVerbal")
    REFILL_VERBAL("RefillVerbal"),
    @XmlEnumValue("OverTheCounter")
    OVER_THE_COUNTER("OverTheCounter"),
    @XmlEnumValue("ReferenceMedication")
    REFERENCE_MEDICATION("ReferenceMedication"),
    @XmlEnumValue("TaxableProduct")
    TAXABLE_PRODUCT("TaxableProduct"),
    @XmlEnumValue("FederalTaxableProduct")
    FEDERAL_TAXABLE_PRODUCT("FederalTaxableProduct"),
    @XmlEnumValue("ProvincialTaxableProduct")
    PROVINCIAL_TAXABLE_PRODUCT("ProvincialTaxableProduct"),
    @XmlEnumValue("NotTaxableProduct")
    NOT_TAXABLE_PRODUCT("NotTaxableProduct");
    private final String value;

    EAttributeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAttributeType fromValue(String v) {
        for (EAttributeType c: EAttributeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
