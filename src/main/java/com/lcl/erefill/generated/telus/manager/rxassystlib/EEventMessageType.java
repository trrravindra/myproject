
package com.lcl.erefill.generated.telus.manager.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eEventMessageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eEventMessageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="RefillAcceptRequest"/>
 *     &lt;enumeration value="RefillDeclineRequest"/>
 *     &lt;enumeration value="FamilyManagerAssignRequest"/>
 *     &lt;enumeration value="FamilyManagerAcceptAssignRequest"/>
 *     &lt;enumeration value="FamilyManagerDeclineAssignRequest"/>
 *     &lt;enumeration value="FamilyManagerPatientDeleteAssociation"/>
 *     &lt;enumeration value="PatientRevoke"/>
 *     &lt;enumeration value="PatientAdminRevoke"/>
 *     &lt;enumeration value="SendPassword"/>
 *     &lt;enumeration value="AutomatedRefillAlreadyRefilled"/>
 *     &lt;enumeration value="AutomatedRefillInAdvance"/>
 *     &lt;enumeration value="AutomatedRefillExpired"/>
 *     &lt;enumeration value="AutomatedRefillLastRefill"/>
 *     &lt;enumeration value="AutomatedRefillSent"/>
 *     &lt;enumeration value="AutomatedRefillPrescriptionInvalid"/>
 *     &lt;enumeration value="RefillReminderAlreadyRefilled"/>
 *     &lt;enumeration value="RefillReminderInAdvance"/>
 *     &lt;enumeration value="RefillReminderExpired"/>
 *     &lt;enumeration value="RefillReminderLastRefill"/>
 *     &lt;enumeration value="RefillReminderSent"/>
 *     &lt;enumeration value="RefillReminderPrescriptionInvalid"/>
 *     &lt;enumeration value="EmailConfirmation"/>
 *     &lt;enumeration value="FamilyManagerExpireAssignRequest"/>
 *     &lt;enumeration value="ManagerExpiredMajority"/>
 *     &lt;enumeration value="RefillOverdue"/>
 *     &lt;enumeration value="RenewalAuthorizationRequestConsent"/>
 *     &lt;enumeration value="ReadyToPickUp"/>
 *     &lt;enumeration value="PickUpReminder"/>
 *     &lt;enumeration value="EnrollmentCompleted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eEventMessageType", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EEventMessageType {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("RefillAcceptRequest")
    REFILL_ACCEPT_REQUEST("RefillAcceptRequest"),
    @XmlEnumValue("RefillDeclineRequest")
    REFILL_DECLINE_REQUEST("RefillDeclineRequest"),
    @XmlEnumValue("FamilyManagerAssignRequest")
    FAMILY_MANAGER_ASSIGN_REQUEST("FamilyManagerAssignRequest"),
    @XmlEnumValue("FamilyManagerAcceptAssignRequest")
    FAMILY_MANAGER_ACCEPT_ASSIGN_REQUEST("FamilyManagerAcceptAssignRequest"),
    @XmlEnumValue("FamilyManagerDeclineAssignRequest")
    FAMILY_MANAGER_DECLINE_ASSIGN_REQUEST("FamilyManagerDeclineAssignRequest"),
    @XmlEnumValue("FamilyManagerPatientDeleteAssociation")
    FAMILY_MANAGER_PATIENT_DELETE_ASSOCIATION("FamilyManagerPatientDeleteAssociation"),
    @XmlEnumValue("PatientRevoke")
    PATIENT_REVOKE("PatientRevoke"),
    @XmlEnumValue("PatientAdminRevoke")
    PATIENT_ADMIN_REVOKE("PatientAdminRevoke"),
    @XmlEnumValue("SendPassword")
    SEND_PASSWORD("SendPassword"),
    @XmlEnumValue("AutomatedRefillAlreadyRefilled")
    AUTOMATED_REFILL_ALREADY_REFILLED("AutomatedRefillAlreadyRefilled"),
    @XmlEnumValue("AutomatedRefillInAdvance")
    AUTOMATED_REFILL_IN_ADVANCE("AutomatedRefillInAdvance"),
    @XmlEnumValue("AutomatedRefillExpired")
    AUTOMATED_REFILL_EXPIRED("AutomatedRefillExpired"),
    @XmlEnumValue("AutomatedRefillLastRefill")
    AUTOMATED_REFILL_LAST_REFILL("AutomatedRefillLastRefill"),
    @XmlEnumValue("AutomatedRefillSent")
    AUTOMATED_REFILL_SENT("AutomatedRefillSent"),
    @XmlEnumValue("AutomatedRefillPrescriptionInvalid")
    AUTOMATED_REFILL_PRESCRIPTION_INVALID("AutomatedRefillPrescriptionInvalid"),
    @XmlEnumValue("RefillReminderAlreadyRefilled")
    REFILL_REMINDER_ALREADY_REFILLED("RefillReminderAlreadyRefilled"),
    @XmlEnumValue("RefillReminderInAdvance")
    REFILL_REMINDER_IN_ADVANCE("RefillReminderInAdvance"),
    @XmlEnumValue("RefillReminderExpired")
    REFILL_REMINDER_EXPIRED("RefillReminderExpired"),
    @XmlEnumValue("RefillReminderLastRefill")
    REFILL_REMINDER_LAST_REFILL("RefillReminderLastRefill"),
    @XmlEnumValue("RefillReminderSent")
    REFILL_REMINDER_SENT("RefillReminderSent"),
    @XmlEnumValue("RefillReminderPrescriptionInvalid")
    REFILL_REMINDER_PRESCRIPTION_INVALID("RefillReminderPrescriptionInvalid"),
    @XmlEnumValue("EmailConfirmation")
    EMAIL_CONFIRMATION("EmailConfirmation"),
    @XmlEnumValue("FamilyManagerExpireAssignRequest")
    FAMILY_MANAGER_EXPIRE_ASSIGN_REQUEST("FamilyManagerExpireAssignRequest"),
    @XmlEnumValue("ManagerExpiredMajority")
    MANAGER_EXPIRED_MAJORITY("ManagerExpiredMajority"),
    @XmlEnumValue("RefillOverdue")
    REFILL_OVERDUE("RefillOverdue"),
    @XmlEnumValue("RenewalAuthorizationRequestConsent")
    RENEWAL_AUTHORIZATION_REQUEST_CONSENT("RenewalAuthorizationRequestConsent"),
    @XmlEnumValue("ReadyToPickUp")
    READY_TO_PICK_UP("ReadyToPickUp"),
    @XmlEnumValue("PickUpReminder")
    PICK_UP_REMINDER("PickUpReminder"),
    @XmlEnumValue("EnrollmentCompleted")
    ENROLLMENT_COMPLETED("EnrollmentCompleted");
    private final String value;

    EEventMessageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EEventMessageType fromValue(String v) {
        for (EEventMessageType c: EEventMessageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
