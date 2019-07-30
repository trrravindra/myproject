
package com.lcl.erefill.generated.telus.session;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.lcl.erefill.generated.telus.session.rxassystlib.Account;
import com.lcl.erefill.generated.telus.session.rxassystlib.LogOnDetail;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountAliases;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceELanguagesSupported;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ConfirmEmailReturnCode;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.EmailReturnStatus;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Identification;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.IdentificationType;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordRecovery;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Pharmacies;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.User;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserAccountsGroup;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserInfo;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyIdentityReason;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyUserInputs;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.session package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SecondFactorType_QNAME = new QName("http://tempuri.org/", "SecondFactorType");
    private final static QName _Detail_QNAME = new QName("http://tempuri.org/", "Detail");
    private final static QName _Main_QNAME = new QName("http://tempuri.org/", "Main");
    private final static QName _AccountPreferences_QNAME = new QName("http://tempuri.org/", "AccountPreferences");
    private final static QName _MobileConfirmationStatus_QNAME = new QName("http://tempuri.org/", "MobileConfirmationStatus");
    private final static QName _PharmacyContractNumber_QNAME = new QName("http://tempuri.org/", "PharmacyContractNumber");
    private final static QName _UserName_QNAME = new QName("http://tempuri.org/", "UserName");
    private final static QName _ConfirmEmailCode_QNAME = new QName("http://tempuri.org/", "ConfirmEmailCode");
    private final static QName _Account_QNAME = new QName("http://tempuri.org/", "Account");
    private final static QName _Username_QNAME = new QName("http://tempuri.org/", "Username");
    private final static QName _Identity_QNAME = new QName("http://tempuri.org/", "Identity");
    private final static QName _Alias_QNAME = new QName("http://tempuri.org/", "Alias");
    private final static QName _Status_QNAME = new QName("http://tempuri.org/", "Status");
    private final static QName _UnsubscribeEmailCommunication_QNAME = new QName("http://tempuri.org/", "UnsubscribeEmailCommunication");
    private final static QName _Aliases_QNAME = new QName("http://tempuri.org/", "Aliases");
    private final static QName _SecondFactor_QNAME = new QName("http://tempuri.org/", "SecondFactor");
    private final static QName _UnsubscribeMobilePhoneCommunication_QNAME = new QName("http://tempuri.org/", "UnsubscribeMobilePhoneCommunication");
    private final static QName _VerifyIdentityReason_QNAME = new QName("http://tempuri.org/", "VerifyIdentityReason");
    private final static QName _PasswordReminder_QNAME = new QName("http://tempuri.org/", "PasswordReminder");
    private final static QName _EncryptedKey_QNAME = new QName("http://tempuri.org/", "EncryptedKey");
    private final static QName _ExtendedInfo_QNAME = new QName("http://tempuri.org/", "ExtendedInfo");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _LastService_QNAME = new QName("http://tempuri.org/", "LastService");
    private final static QName _Valid_QNAME = new QName("http://tempuri.org/", "Valid");
    private final static QName _UniqueIdentifier_QNAME = new QName("http://tempuri.org/", "UniqueIdentifier");
    private final static QName _NewPassword_QNAME = new QName("http://tempuri.org/", "NewPassword");
    private final static QName _BirthDate_QNAME = new QName("http://tempuri.org/", "BirthDate");
    private final static QName _Reminder_QNAME = new QName("http://tempuri.org/", "Reminder");
    private final static QName _OldPassword_QNAME = new QName("http://tempuri.org/", "OldPassword");
    private final static QName _GroupId_QNAME = new QName("http://tempuri.org/", "GroupId");
    private final static QName _UserInfo_QNAME = new QName("http://tempuri.org/", "UserInfo");
    private final static QName _SourceName_QNAME = new QName("http://tempuri.org/", "SourceName");
    private final static QName _MobilePhoneNumber_QNAME = new QName("http://tempuri.org/", "MobilePhoneNumber");
    private final static QName _Language_QNAME = new QName("http://tempuri.org/", "Language");
    private final static QName _NewAlias_QNAME = new QName("http://tempuri.org/", "NewAlias");
    private final static QName _Identification_QNAME = new QName("http://tempuri.org/", "Identification");
    private final static QName _UnsubscribeKey_QNAME = new QName("http://tempuri.org/", "UnsubscribeKey");
    private final static QName _User_QNAME = new QName("http://tempuri.org/", "User");
    private final static QName _Verifications_QNAME = new QName("http://tempuri.org/", "Verifications");
    private final static QName _Email_QNAME = new QName("http://tempuri.org/", "Email");
    private final static QName _Pharmacies_QNAME = new QName("http://tempuri.org/", "Pharmacies");
    private final static QName _Default_QNAME = new QName("http://tempuri.org/", "Default");
    private final static QName _IdentificationType_QNAME = new QName("http://tempuri.org/", "IdentificationType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.session
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecondFactorType")
    public JAXBElement<Integer> createSecondFactorType(Integer value) {
        return new JAXBElement<Integer>(_SecondFactorType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOnDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Detail")
    public JAXBElement<LogOnDetail> createDetail(LogOnDetail value) {
        return new JAXBElement<LogOnDetail>(_Detail_QNAME, LogOnDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Main")
    public JAXBElement<String> createMain(String value) {
        return new JAXBElement<String>(_Main_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAccountPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AccountPreferences")
    public JAXBElement<ArrayOfAccountPreference> createAccountPreferences(ArrayOfAccountPreference value) {
        return new JAXBElement<ArrayOfAccountPreference>(_AccountPreferences_QNAME, ArrayOfAccountPreference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MobileConfirmationStatus")
    public JAXBElement<Integer> createMobileConfirmationStatus(Integer value) {
        return new JAXBElement<Integer>(_MobileConfirmationStatus_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyContractNumber")
    public JAXBElement<String> createPharmacyContractNumber(String value) {
        return new JAXBElement<String>(_PharmacyContractNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserName")
    public JAXBElement<String> createUserName(String value) {
        return new JAXBElement<String>(_UserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmEmailReturnCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConfirmEmailCode")
    public JAXBElement<ConfirmEmailReturnCode> createConfirmEmailCode(ConfirmEmailReturnCode value) {
        return new JAXBElement<ConfirmEmailReturnCode>(_ConfirmEmailCode_QNAME, ConfirmEmailReturnCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Identity")
    public JAXBElement<String> createIdentity(String value) {
        return new JAXBElement<String>(_Identity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Alias")
    public JAXBElement<String> createAlias(String value) {
        return new JAXBElement<String>(_Alias_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailReturnStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Status")
    public JAXBElement<EmailReturnStatus> createStatus(EmailReturnStatus value) {
        return new JAXBElement<EmailReturnStatus>(_Status_QNAME, EmailReturnStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UnsubscribeEmailCommunication")
    public JAXBElement<Boolean> createUnsubscribeEmailCommunication(Boolean value) {
        return new JAXBElement<Boolean>(_UnsubscribeEmailCommunication_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountAliases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Aliases")
    public JAXBElement<AccountAliases> createAliases(AccountAliases value) {
        return new JAXBElement<AccountAliases>(_Aliases_QNAME, AccountAliases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SecondFactor")
    public JAXBElement<String> createSecondFactor(String value) {
        return new JAXBElement<String>(_SecondFactor_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UnsubscribeMobilePhoneCommunication")
    public JAXBElement<Boolean> createUnsubscribeMobilePhoneCommunication(Boolean value) {
        return new JAXBElement<Boolean>(_UnsubscribeMobilePhoneCommunication_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyIdentityReason }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "VerifyIdentityReason")
    public JAXBElement<VerifyIdentityReason> createVerifyIdentityReason(VerifyIdentityReason value) {
        return new JAXBElement<VerifyIdentityReason>(_VerifyIdentityReason_QNAME, VerifyIdentityReason.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PasswordReminder")
    public JAXBElement<PasswordReminder> createPasswordReminder(PasswordReminder value) {
        return new JAXBElement<PasswordReminder>(_PasswordReminder_QNAME, PasswordReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EncryptedKey")
    public JAXBElement<String> createEncryptedKey(String value) {
        return new JAXBElement<String>(_EncryptedKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ExtendedInfo")
    public JAXBElement<Integer> createExtendedInfo(Integer value) {
        return new JAXBElement<Integer>(_ExtendedInfo_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "LastService")
    public JAXBElement<String> createLastService(String value) {
        return new JAXBElement<String>(_LastService_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Valid")
    public JAXBElement<Boolean> createValid(Boolean value) {
        return new JAXBElement<Boolean>(_Valid_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UniqueIdentifier")
    public JAXBElement<String> createUniqueIdentifier(String value) {
        return new JAXBElement<String>(_UniqueIdentifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NewPassword")
    public JAXBElement<String> createNewPassword(String value) {
        return new JAXBElement<String>(_NewPassword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BirthDate")
    public JAXBElement<XMLGregorianCalendar> createBirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_BirthDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordRecovery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Reminder")
    public JAXBElement<PasswordRecovery> createReminder(PasswordRecovery value) {
        return new JAXBElement<PasswordRecovery>(_Reminder_QNAME, PasswordRecovery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "OldPassword")
    public JAXBElement<String> createOldPassword(String value) {
        return new JAXBElement<String>(_OldPassword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GroupId")
    public JAXBElement<UserAccountsGroup> createGroupId(UserAccountsGroup value) {
        return new JAXBElement<UserAccountsGroup>(_GroupId_QNAME, UserAccountsGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserInfo")
    public JAXBElement<UserInfo> createUserInfo(UserInfo value) {
        return new JAXBElement<UserInfo>(_UserInfo_QNAME, UserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SourceName")
    public JAXBElement<String> createSourceName(String value) {
        return new JAXBElement<String>(_SourceName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MobilePhoneNumber")
    public JAXBElement<String> createMobilePhoneNumber(String value) {
        return new JAXBElement<String>(_MobilePhoneNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountPreferenceELanguagesSupported }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Language")
    public JAXBElement<AccountPreferenceELanguagesSupported> createLanguage(AccountPreferenceELanguagesSupported value) {
        return new JAXBElement<AccountPreferenceELanguagesSupported>(_Language_QNAME, AccountPreferenceELanguagesSupported.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NewAlias")
    public JAXBElement<String> createNewAlias(String value) {
        return new JAXBElement<String>(_NewAlias_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Identification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Identification")
    public JAXBElement<Identification> createIdentification(Identification value) {
        return new JAXBElement<Identification>(_Identification_QNAME, Identification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UnsubscribeKey")
    public JAXBElement<String> createUnsubscribeKey(String value) {
        return new JAXBElement<String>(_UnsubscribeKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserInputs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Verifications")
    public JAXBElement<VerifyUserInputs> createVerifications(VerifyUserInputs value) {
        return new JAXBElement<VerifyUserInputs>(_Verifications_QNAME, VerifyUserInputs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pharmacies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Pharmacies")
    public JAXBElement<Pharmacies> createPharmacies(Pharmacies value) {
        return new JAXBElement<Pharmacies>(_Pharmacies_QNAME, Pharmacies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Default")
    public JAXBElement<String> createDefault(String value) {
        return new JAXBElement<String>(_Default_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "IdentificationType")
    public JAXBElement<IdentificationType> createIdentificationType(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_IdentificationType_QNAME, IdentificationType.class, null, value);
    }

}
