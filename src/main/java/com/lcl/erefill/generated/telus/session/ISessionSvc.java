package com.lcl.erefill.generated.telus.session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;



/**
 * This class was generated by Apache CXF 2.7.5
 * 2015-12-10T17:37:00.576+05:30
 * Generated source version: 2.7.5
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "ISessionSvc")
@XmlSeeAlso({com.lcl.erefill.generated.telus.session.system.ObjectFactory.class, com.lcl.erefill.generated.telus.session.rxassystlib.ObjectFactory.class, com.lcl.erefill.generated.telus.session.microsoft.schemas._2003._10.serialization.ObjectFactory.class, com.lcl.erefill.generated.telus.session.rxassystlib.ObjectFactory.class, com.lcl.erefill.generated.telus.session.rxassystloggerlib.ObjectFactory.class, com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ObjectFactory.class, com.lcl.erefill.generated.telus.session.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ISessionSvc {

    @Action(input = "http://tempuri.org/ISessionSvc/VerifyIdentity", output = "http://tempuri.org/ISessionSvc/VerifyIdentityResponse", fault = {@FaultAction(className = ISessionSvcVerifyIdentityErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/VerifyIdentityErrorFault")})
    @WebMethod(operationName = "VerifyIdentity", action = "http://tempuri.org/ISessionSvc/VerifyIdentity")
    public void verifyIdentity(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UserName", name = "UserName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(partName = "Verifications", name = "Verifications", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyUserInputs verifications,
        @WebParam(partName = "Valid", mode = WebParam.Mode.OUT, name = "Valid", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.Boolean> valid,
        @WebParam(partName = "VerifyIdentityReason", mode = WebParam.Mode.OUT, name = "VerifyIdentityReason", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyIdentityReason> verifyIdentityReason
    ) throws ISessionSvcVerifyIdentityErrorFaultFaultMessage;

    @WebResult(name = "PasswordReminder", targetNamespace = "http://tempuri.org/", partName = "PasswordReminder")
    @Action(input = "http://tempuri.org/ISessionSvc/GetPasswordReminder", output = "http://tempuri.org/ISessionSvc/GetPasswordReminderResponse", fault = {@FaultAction(className = ISessionSvcGetPasswordReminderErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetPasswordReminderErrorFault")})
    @WebMethod(operationName = "GetPasswordReminder", action = "http://tempuri.org/ISessionSvc/GetPasswordReminder")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder getPasswordReminder(
        @WebParam(partName = "User", name = "User", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.User user
    ) throws ISessionSvcGetPasswordReminderErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/GetConfirmMobilePhoneNumber", output = "http://tempuri.org/ISessionSvc/GetConfirmMobilePhoneNumberResponse", fault = {@FaultAction(className = ISessionSvcGetConfirmMobilePhoneNumberErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetConfirmMobilePhoneNumberErrorFault")})
    @WebMethod(operationName = "GetConfirmMobilePhoneNumber", action = "http://tempuri.org/ISessionSvc/GetConfirmMobilePhoneNumber")
    public void getConfirmMobilePhoneNumber(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UserName", name = "UserName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(partName = "MobilePhoneNumber", mode = WebParam.Mode.OUT, name = "MobilePhoneNumber", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.String> mobilePhoneNumber,
        @WebParam(partName = "MobileConfirmationStatus", mode = WebParam.Mode.OUT, name = "MobileConfirmationStatus", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.Integer> mobileConfirmationStatus
    ) throws ISessionSvcGetConfirmMobilePhoneNumberErrorFaultFaultMessage;

    @WebResult(name = "ConfirmEmailCode", targetNamespace = "http://tempuri.org/", partName = "ConfirmEmailCode")
    @Action(input = "http://tempuri.org/ISessionSvc/ConfirmEmail", output = "http://tempuri.org/ISessionSvc/ConfirmEmailResponse", fault = {@FaultAction(className = ISessionSvcConfirmEmailErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/ConfirmEmailErrorFault")})
    @WebMethod(operationName = "ConfirmEmail", action = "http://tempuri.org/ISessionSvc/ConfirmEmail")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ConfirmEmailReturnCode confirmEmail(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UniqueIdentifier", name = "UniqueIdentifier", targetNamespace = "http://tempuri.org/")
        java.lang.String uniqueIdentifier
    ) throws ISessionSvcConfirmEmailErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/AddAccountAlias", output = "http://tempuri.org/ISessionSvc/AddAccountAliasResponse", fault = {@FaultAction(className = ISessionSvcAddAccountAliasErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/AddAccountAliasErrorFault")})
    @WebMethod(operationName = "AddAccountAlias", action = "http://tempuri.org/ISessionSvc/AddAccountAlias")
    public void addAccountAlias(
        @WebParam(partName = "Alias", name = "Alias", targetNamespace = "http://tempuri.org/")
        java.lang.String alias,
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken
    ) throws ISessionSvcAddAccountAliasErrorFaultFaultMessage;

    @WebResult(name = "Aliases", targetNamespace = "http://tempuri.org/", partName = "Aliases")
    @Action(input = "http://tempuri.org/ISessionSvc/GetAccountAliases", output = "http://tempuri.org/ISessionSvc/GetAccountAliasesResponse", fault = {@FaultAction(className = ISessionSvcGetAccountAliasesErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetAccountAliasesErrorFault")})
    @WebMethod(operationName = "GetAccountAliases", action = "http://tempuri.org/ISessionSvc/GetAccountAliases")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountAliases getAccountAliases(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UserName", name = "UserName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName
    ) throws ISessionSvcGetAccountAliasesErrorFaultFaultMessage;

    @WebResult(name = "Status", targetNamespace = "http://tempuri.org/", partName = "Status")
    @Action(input = "http://tempuri.org/ISessionSvc/EmailValid", output = "http://tempuri.org/ISessionSvc/EmailValidResponse", fault = {@FaultAction(className = ISessionSvcEmailValidErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/EmailValidErrorFault")})
    @WebMethod(operationName = "EmailValid", action = "http://tempuri.org/ISessionSvc/EmailValid")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.EmailReturnStatus emailValid(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "Username", name = "Username", targetNamespace = "http://tempuri.org/")
        java.lang.String username
    ) throws ISessionSvcEmailValidErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/GetPharmacies", output = "http://tempuri.org/ISessionSvc/GetPharmaciesResponse", fault = {@FaultAction(className = ISessionSvcGetPharmaciesErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetPharmaciesErrorFault")})
    @WebMethod(operationName = "GetPharmacies", action = "http://tempuri.org/ISessionSvc/GetPharmacies")
    public void getPharmacies(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UserName", name = "UserName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(partName = "Pharmacies", mode = WebParam.Mode.OUT, name = "Pharmacies", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Pharmacies> pharmacies,
        @WebParam(partName = "Default", mode = WebParam.Mode.OUT, name = "Default", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.String> _default,
        @WebParam(partName = "Main", mode = WebParam.Mode.OUT, name = "Main", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.String> main,
        @WebParam(partName = "LastService", mode = WebParam.Mode.OUT, name = "LastService", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.String> lastService
    ) throws ISessionSvcGetPharmaciesErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/GetConfirmEmail", output = "http://tempuri.org/ISessionSvc/GetConfirmEmailResponse", fault = {@FaultAction(className = ISessionSvcGetConfirmEmailErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetConfirmEmailErrorFault")})
    @WebMethod(operationName = "GetConfirmEmail", action = "http://tempuri.org/ISessionSvc/GetConfirmEmail")
    public void getConfirmEmail(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UniqueIdentifier", name = "UniqueIdentifier", targetNamespace = "http://tempuri.org/")
        java.lang.String uniqueIdentifier,
        @WebParam(partName = "Email", mode = WebParam.Mode.OUT, name = "Email", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<java.lang.String> email,
        @WebParam(partName = "Status", mode = WebParam.Mode.OUT, name = "Status", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.EmailReturnStatus> status
    ) throws ISessionSvcGetConfirmEmailErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/UpdatePreferences", output = "http://tempuri.org/ISessionSvc/UpdatePreferencesResponse", fault = {@FaultAction(className = ISessionSvcUpdatePreferencesErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/UpdatePreferencesErrorFault")})
    @WebMethod(operationName = "UpdatePreferences", action = "http://tempuri.org/ISessionSvc/UpdatePreferences")
    public void updatePreferences(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "AccountPreferences", name = "AccountPreferences", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference accountPreferences
    ) throws ISessionSvcUpdatePreferencesErrorFaultFaultMessage;

    @WebResult(name = "AccountPreferences", targetNamespace = "http://tempuri.org/", partName = "AccountPreferences")
    @Action(input = "http://tempuri.org/ISessionSvc/ListPreferences", output = "http://tempuri.org/ISessionSvc/ListPreferencesResponse", fault = {@FaultAction(className = ISessionSvcListPreferencesErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/ListPreferencesErrorFault")})
    @WebMethod(operationName = "ListPreferences", action = "http://tempuri.org/ISessionSvc/ListPreferences")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference listPreferences(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken
    ) throws ISessionSvcListPreferencesErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/LogOnUser", output = "http://tempuri.org/ISessionSvc/LogOnUserResponse", fault = {@FaultAction(className = ISessionSvcLogOnUserErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/LogOnUserErrorFault")})
    @WebMethod(operationName = "LogOnUser", action = "http://tempuri.org/ISessionSvc/LogOnUser")
    public void logOnUser(
        @WebParam(partName = "User", name = "User", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.User user,
        @WebParam(partName = "ExtendedInfo", name = "ExtendedInfo", targetNamespace = "http://tempuri.org/")
        int extendedInfo,
        @WebParam(partName = "EncryptedKey", name = "EncryptedKey", targetNamespace = "http://tempuri.org/")
        java.lang.String encryptedKey,
        @WebParam(partName = "UserToken", mode = WebParam.Mode.OUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "Detail", mode = WebParam.Mode.OUT, name = "Detail", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib.LogOnDetail> detail
    ) throws ISessionSvcLogOnUserErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/SendPassword", output = "http://tempuri.org/ISessionSvc/SendPasswordResponse", fault = {@FaultAction(className = ISessionSvcSendPasswordErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/SendPasswordErrorFault")})
    @WebMethod(operationName = "SendPassword", action = "http://tempuri.org/ISessionSvc/SendPassword")
    public void sendPassword(
        @WebParam(partName = "Reminder", name = "Reminder", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordRecovery reminder
    ) throws ISessionSvcSendPasswordErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/UnsubscribeCommunication", output = "http://tempuri.org/ISessionSvc/UnsubscribeCommunicationResponse", fault = {@FaultAction(className = ISessionSvcUnsubscribeCommunicationErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/UnsubscribeCommunicationErrorFault")})
    @WebMethod(operationName = "UnsubscribeCommunication", action = "http://tempuri.org/ISessionSvc/UnsubscribeCommunication")
    public void unsubscribeCommunication(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "UnsubscribeEmailCommunication", name = "UnsubscribeEmailCommunication", targetNamespace = "http://tempuri.org/")
        boolean unsubscribeEmailCommunication,
        @WebParam(partName = "UnsubscribeMobilePhoneCommunication", name = "UnsubscribeMobilePhoneCommunication", targetNamespace = "http://tempuri.org/")
        boolean unsubscribeMobilePhoneCommunication
    ) throws ISessionSvcUnsubscribeCommunicationErrorFaultFaultMessage;

    @WebResult(name = "Identity", targetNamespace = "http://tempuri.org/", partName = "Identity")
    @Action(input = "http://tempuri.org/ISessionSvc/Identify", output = "http://tempuri.org/ISessionSvc/IdentifyResponse", fault = {@FaultAction(className = ISessionSvcIdentifyErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/IdentifyErrorFault")})
    @WebMethod(operationName = "Identify", action = "http://tempuri.org/ISessionSvc/Identify")
    public java.lang.String identify(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "IdentificationType", name = "IdentificationType", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.IdentificationType identificationType,
        @WebParam(partName = "Identification", name = "Identification", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Identification identification
    ) throws ISessionSvcIdentifyErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/SetLogonSource", output = "http://tempuri.org/ISessionSvc/SetLogonSourceResponse", fault = {@FaultAction(className = ISessionSvcSetLogonSourceErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/SetLogonSourceErrorFault")})
    @WebMethod(operationName = "SetLogonSource", action = "http://tempuri.org/ISessionSvc/SetLogonSource")
    public void setLogonSource(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "SourceName", name = "SourceName", targetNamespace = "http://tempuri.org/")
        java.lang.String sourceName
    ) throws ISessionSvcSetLogonSourceErrorFaultFaultMessage;

    @WebResult(name = "GroupId", targetNamespace = "http://tempuri.org/", partName = "GroupId")
    @Action(input = "http://tempuri.org/ISessionSvc/GetUserRole", output = "http://tempuri.org/ISessionSvc/GetUserRoleResponse", fault = {@FaultAction(className = ISessionSvcGetUserRoleErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetUserRoleErrorFault")})
    @WebMethod(operationName = "GetUserRole", action = "http://tempuri.org/ISessionSvc/GetUserRole")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserAccountsGroup getUserRole(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken
    ) throws ISessionSvcGetUserRoleErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/UpdateAccountAlias", output = "http://tempuri.org/ISessionSvc/UpdateAccountAliasResponse", fault = {@FaultAction(className = ISessionSvcUpdateAccountAliasErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/UpdateAccountAliasErrorFault")})
    @WebMethod(operationName = "UpdateAccountAlias", action = "http://tempuri.org/ISessionSvc/UpdateAccountAlias")
    public void updateAccountAlias(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "Alias", name = "Alias", targetNamespace = "http://tempuri.org/")
        java.lang.String alias,
        @WebParam(partName = "NewAlias", name = "NewAlias", targetNamespace = "http://tempuri.org/")
        java.lang.String newAlias
    ) throws ISessionSvcUpdateAccountAliasErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/SendAlias", output = "http://tempuri.org/ISessionSvc/SendAliasResponse", fault = {@FaultAction(className = ISessionSvcSendAliasErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/SendAliasErrorFault")})
    @WebMethod(operationName = "SendAlias", action = "http://tempuri.org/ISessionSvc/SendAlias")
    public void sendAlias(
        @WebParam(partName = "Email", name = "Email", targetNamespace = "http://tempuri.org/")
        java.lang.String email,
        @WebParam(partName = "BirthDate", name = "BirthDate", targetNamespace = "http://tempuri.org/")
        javax.xml.datatype.XMLGregorianCalendar birthDate
    ) throws ISessionSvcSendAliasErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/ChangePassword", output = "http://tempuri.org/ISessionSvc/ChangePasswordResponse", fault = {@FaultAction(className = ISessionSvcChangePasswordErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/ChangePasswordErrorFault")})
    @WebMethod(operationName = "ChangePassword", action = "http://tempuri.org/ISessionSvc/ChangePassword")
    public void changePassword(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "NewPassword", name = "NewPassword", targetNamespace = "http://tempuri.org/")
        java.lang.String newPassword,
        @WebParam(partName = "OldPassword", name = "OldPassword", targetNamespace = "http://tempuri.org/")
        java.lang.String oldPassword
    ) throws ISessionSvcChangePasswordErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/SetDefaultPharmacy", output = "http://tempuri.org/ISessionSvc/SetDefaultPharmacyResponse", fault = {@FaultAction(className = ISessionSvcSetDefaultPharmacyErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/SetDefaultPharmacyErrorFault")})
    @WebMethod(operationName = "SetDefaultPharmacy", action = "http://tempuri.org/ISessionSvc/SetDefaultPharmacy")
    public void setDefaultPharmacy(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "PharmacyContractNumber", name = "PharmacyContractNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String pharmacyContractNumber
    ) throws ISessionSvcSetDefaultPharmacyErrorFaultFaultMessage;

    @WebResult(name = "UserToken", targetNamespace = "http://tempuri.org/", partName = "UserToken")
    @Action(input = "http://tempuri.org/ISessionSvc/LogOn", output = "http://tempuri.org/ISessionSvc/LogOnResponse", fault = {@FaultAction(className = ISessionSvcLogOnErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/LogOnErrorFault")})
    @WebMethod(operationName = "LogOn", action = "http://tempuri.org/ISessionSvc/LogOn")
    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken logOn(
        @WebParam(partName = "User", name = "User", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.User user,
        @WebParam(partName = "UserInfo", name = "UserInfo", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserInfo userInfo
    ) throws ISessionSvcLogOnErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/UpdatePasswordReminder", output = "http://tempuri.org/ISessionSvc/UpdatePasswordReminderResponse", fault = {@FaultAction(className = ISessionSvcUpdatePasswordReminderErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/UpdatePasswordReminderErrorFault")})
    @WebMethod(operationName = "UpdatePasswordReminder", action = "http://tempuri.org/ISessionSvc/UpdatePasswordReminder")
    public void updatePasswordReminder(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "PasswordReminder", name = "PasswordReminder", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder passwordReminder,
        @WebParam(partName = "Email", name = "Email", targetNamespace = "http://tempuri.org/")
        java.lang.String email,
        @WebParam(partName = "Language", name = "Language", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceELanguagesSupported language
    ) throws ISessionSvcUpdatePasswordReminderErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/UnsubscribeEmailCommunication", output = "http://tempuri.org/ISessionSvc/UnsubscribeEmailCommunicationResponse", fault = {@FaultAction(className = ISessionSvcUnsubscribeEmailCommunicationErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/UnsubscribeEmailCommunicationErrorFault")})
    @WebMethod(operationName = "UnsubscribeEmailCommunication", action = "http://tempuri.org/ISessionSvc/UnsubscribeEmailCommunication")
    public void unsubscribeEmailCommunication(
        @WebParam(partName = "UnsubscribeKey", name = "UnsubscribeKey", targetNamespace = "http://tempuri.org/")
        java.lang.String unsubscribeKey
    ) throws ISessionSvcUnsubscribeEmailCommunicationErrorFaultFaultMessage;

    @WebResult(name = "Account", targetNamespace = "http://tempuri.org/", partName = "Account")
    @Action(input = "http://tempuri.org/ISessionSvc/GetCurrentAccount", output = "http://tempuri.org/ISessionSvc/GetCurrentAccountResponse", fault = {@FaultAction(className = ISessionSvcGetCurrentAccountErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/GetCurrentAccountErrorFault")})
    @WebMethod(operationName = "GetCurrentAccount", action = "http://tempuri.org/ISessionSvc/GetCurrentAccount")
    public com.lcl.erefill.generated.telus.session.rxassystlib.Account getCurrentAccount(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken
    ) throws ISessionSvcGetCurrentAccountErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/LogOff", output = "http://tempuri.org/ISessionSvc/LogOffResponse", fault = {@FaultAction(className = ISessionSvcLogOffErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/LogOffErrorFault")})
    @WebMethod(operationName = "LogOff", action = "http://tempuri.org/ISessionSvc/LogOff")
    public void logOff(
        @WebParam(partName = "UserToken", name = "UserToken", targetNamespace = "http://tempuri.org/")
        com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken userToken
    ) throws ISessionSvcLogOffErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/DeleteAccountAlias", output = "http://tempuri.org/ISessionSvc/DeleteAccountAliasResponse", fault = {@FaultAction(className = ISessionSvcDeleteAccountAliasErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/DeleteAccountAliasErrorFault")})
    @WebMethod(operationName = "DeleteAccountAlias", action = "http://tempuri.org/ISessionSvc/DeleteAccountAlias")
    public void deleteAccountAlias(
        @WebParam(partName = "Alias", name = "Alias", targetNamespace = "http://tempuri.org/")
        java.lang.String alias,
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken
    ) throws ISessionSvcDeleteAccountAliasErrorFaultFaultMessage;

    @Action(input = "http://tempuri.org/ISessionSvc/ConfirmEnrollment", output = "http://tempuri.org/ISessionSvc/ConfirmEnrollmentResponse", fault = {@FaultAction(className = ISessionSvcConfirmEnrollmentErrorFaultFaultMessage.class, value = "http://tempuri.org/ISessionSvc/ConfirmEnrollmentErrorFault")})
    @WebMethod(operationName = "ConfirmEnrollment", action = "http://tempuri.org/ISessionSvc/ConfirmEnrollment")
    public void confirmEnrollment(
        @WebParam(partName = "UserToken", mode = WebParam.Mode.INOUT, name = "UserToken", targetNamespace = "http://tempuri.org/")
        javax.xml.ws.Holder<com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken> userToken,
        @WebParam(partName = "SecondFactor", name = "SecondFactor", targetNamespace = "http://tempuri.org/")
        java.lang.String secondFactor,
        @WebParam(partName = "SecondFactorType", name = "SecondFactorType", targetNamespace = "http://tempuri.org/")
        int secondFactorType,
        @WebParam(partName = "Alias", name = "Alias", targetNamespace = "http://tempuri.org/")
        java.lang.String alias
    ) throws ISessionSvcConfirmEnrollmentErrorFaultFaultMessage;
}
