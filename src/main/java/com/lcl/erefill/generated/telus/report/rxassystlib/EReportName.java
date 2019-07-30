
package com.lcl.erefill.generated.telus.report.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eReportName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eReportName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Log"/>
 *     &lt;enumeration value="TaxReceipt"/>
 *     &lt;enumeration value="RefillRequest"/>
 *     &lt;enumeration value="RefillRequestIVR"/>
 *     &lt;enumeration value="PatientSubscriptions"/>
 *     &lt;enumeration value="PatientUnsubscribe"/>
 *     &lt;enumeration value="PatientToBeDeleted"/>
 *     &lt;enumeration value="PatientActivities"/>
 *     &lt;enumeration value="Statistics"/>
 *     &lt;enumeration value="StatisticsFamily"/>
 *     &lt;enumeration value="StatisticsByDIN"/>
 *     &lt;enumeration value="StatisticsCounsellingSheets"/>
 *     &lt;enumeration value="StatisticsCommunication"/>
 *     &lt;enumeration value="ActivePharmacies"/>
 *     &lt;enumeration value="AutomatedRefill"/>
 *     &lt;enumeration value="RefillReminder"/>
 *     &lt;enumeration value="Status"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eReportName", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EReportName {

    @XmlEnumValue("Log")
    LOG("Log"),
    @XmlEnumValue("TaxReceipt")
    TAX_RECEIPT("TaxReceipt"),
    @XmlEnumValue("RefillRequest")
    REFILL_REQUEST("RefillRequest"),
    @XmlEnumValue("RefillRequestIVR")
    REFILL_REQUEST_IVR("RefillRequestIVR"),
    @XmlEnumValue("PatientSubscriptions")
    PATIENT_SUBSCRIPTIONS("PatientSubscriptions"),
    @XmlEnumValue("PatientUnsubscribe")
    PATIENT_UNSUBSCRIBE("PatientUnsubscribe"),
    @XmlEnumValue("PatientToBeDeleted")
    PATIENT_TO_BE_DELETED("PatientToBeDeleted"),
    @XmlEnumValue("PatientActivities")
    PATIENT_ACTIVITIES("PatientActivities"),
    @XmlEnumValue("Statistics")
    STATISTICS("Statistics"),
    @XmlEnumValue("StatisticsFamily")
    STATISTICS_FAMILY("StatisticsFamily"),
    @XmlEnumValue("StatisticsByDIN")
    STATISTICS_BY_DIN("StatisticsByDIN"),
    @XmlEnumValue("StatisticsCounsellingSheets")
    STATISTICS_COUNSELLING_SHEETS("StatisticsCounsellingSheets"),
    @XmlEnumValue("StatisticsCommunication")
    STATISTICS_COMMUNICATION("StatisticsCommunication"),
    @XmlEnumValue("ActivePharmacies")
    ACTIVE_PHARMACIES("ActivePharmacies"),
    @XmlEnumValue("AutomatedRefill")
    AUTOMATED_REFILL("AutomatedRefill"),
    @XmlEnumValue("RefillReminder")
    REFILL_REMINDER("RefillReminder"),
    @XmlEnumValue("Status")
    STATUS("Status");
    private final String value;

    EReportName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EReportName fromValue(String v) {
        for (EReportName c: EReportName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
