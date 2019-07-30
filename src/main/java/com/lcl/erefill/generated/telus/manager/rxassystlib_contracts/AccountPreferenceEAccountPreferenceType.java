
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountPreference.eAccountPreferenceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountPreference.eAccountPreferenceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Language"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Notification"/>
 *     &lt;enumeration value="PaswordRecoveryQuestion1"/>
 *     &lt;enumeration value="PaswordRecoveryQuestion2"/>
 *     &lt;enumeration value="PaswordRecoveryQuestion3"/>
 *     &lt;enumeration value="PaswordRecoveryQuestionAnswer1"/>
 *     &lt;enumeration value="PaswordRecoveryQuestionAnswer2"/>
 *     &lt;enumeration value="PaswordRecoveryQuestionAnswer3"/>
 *     &lt;enumeration value="EmailType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountPreference.eAccountPreferenceType")
@XmlEnum
public enum AccountPreferenceEAccountPreferenceType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Language")
    LANGUAGE("Language"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("Notification")
    NOTIFICATION("Notification"),
    @XmlEnumValue("PaswordRecoveryQuestion1")
    PASWORD_RECOVERY_QUESTION_1("PaswordRecoveryQuestion1"),
    @XmlEnumValue("PaswordRecoveryQuestion2")
    PASWORD_RECOVERY_QUESTION_2("PaswordRecoveryQuestion2"),
    @XmlEnumValue("PaswordRecoveryQuestion3")
    PASWORD_RECOVERY_QUESTION_3("PaswordRecoveryQuestion3"),
    @XmlEnumValue("PaswordRecoveryQuestionAnswer1")
    PASWORD_RECOVERY_QUESTION_ANSWER_1("PaswordRecoveryQuestionAnswer1"),
    @XmlEnumValue("PaswordRecoveryQuestionAnswer2")
    PASWORD_RECOVERY_QUESTION_ANSWER_2("PaswordRecoveryQuestionAnswer2"),
    @XmlEnumValue("PaswordRecoveryQuestionAnswer3")
    PASWORD_RECOVERY_QUESTION_ANSWER_3("PaswordRecoveryQuestionAnswer3"),
    @XmlEnumValue("EmailType")
    EMAIL_TYPE("EmailType");
    private final String value;

    AccountPreferenceEAccountPreferenceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountPreferenceEAccountPreferenceType fromValue(String v) {
        for (AccountPreferenceEAccountPreferenceType c: AccountPreferenceEAccountPreferenceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
