
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eAbortedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eAbortedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="ByPhysician"/>
 *     &lt;enumeration value="ByPharmacist"/>
 *     &lt;enumeration value="ByPatient"/>
 *     &lt;enumeration value="DosageChange"/>
 *     &lt;enumeration value="NewPrescriptionInFile"/>
 *     &lt;enumeration value="OtherReason"/>
 *     &lt;enumeration value="StrengthChange"/>
 *     &lt;enumeration value="MonitoringThePatient"/>
 *     &lt;enumeration value="TherapyNotHaveDesiredBenefit"/>
 *     &lt;enumeration value="DifferentTreatmentRequired"/>
 *     &lt;enumeration value="DrugNotAvalaible"/>
 *     &lt;enumeration value="NotAbleToUseDrug"/>
 *     &lt;enumeration value="DrugNotCoverage"/>
 *     &lt;enumeration value="ClinicalIssue"/>
 *     &lt;enumeration value="SuspendPrescription"/>
 *     &lt;enumeration value="ProductRecall"/>
 *     &lt;enumeration value="OtherReasonQuebec"/>
 *     &lt;enumeration value="SigChange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eAbortedReason", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EAbortedReason {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("ByPhysician")
    BY_PHYSICIAN("ByPhysician"),
    @XmlEnumValue("ByPharmacist")
    BY_PHARMACIST("ByPharmacist"),
    @XmlEnumValue("ByPatient")
    BY_PATIENT("ByPatient"),
    @XmlEnumValue("DosageChange")
    DOSAGE_CHANGE("DosageChange"),
    @XmlEnumValue("NewPrescriptionInFile")
    NEW_PRESCRIPTION_IN_FILE("NewPrescriptionInFile"),
    @XmlEnumValue("OtherReason")
    OTHER_REASON("OtherReason"),
    @XmlEnumValue("StrengthChange")
    STRENGTH_CHANGE("StrengthChange"),
    @XmlEnumValue("MonitoringThePatient")
    MONITORING_THE_PATIENT("MonitoringThePatient"),
    @XmlEnumValue("TherapyNotHaveDesiredBenefit")
    THERAPY_NOT_HAVE_DESIRED_BENEFIT("TherapyNotHaveDesiredBenefit"),
    @XmlEnumValue("DifferentTreatmentRequired")
    DIFFERENT_TREATMENT_REQUIRED("DifferentTreatmentRequired"),
    @XmlEnumValue("DrugNotAvalaible")
    DRUG_NOT_AVALAIBLE("DrugNotAvalaible"),
    @XmlEnumValue("NotAbleToUseDrug")
    NOT_ABLE_TO_USE_DRUG("NotAbleToUseDrug"),
    @XmlEnumValue("DrugNotCoverage")
    DRUG_NOT_COVERAGE("DrugNotCoverage"),
    @XmlEnumValue("ClinicalIssue")
    CLINICAL_ISSUE("ClinicalIssue"),
    @XmlEnumValue("SuspendPrescription")
    SUSPEND_PRESCRIPTION("SuspendPrescription"),
    @XmlEnumValue("ProductRecall")
    PRODUCT_RECALL("ProductRecall"),
    @XmlEnumValue("OtherReasonQuebec")
    OTHER_REASON_QUEBEC("OtherReasonQuebec"),
    @XmlEnumValue("SigChange")
    SIG_CHANGE("SigChange");
    private final String value;

    EAbortedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EAbortedReason fromValue(String v) {
        for (EAbortedReason c: EAbortedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
