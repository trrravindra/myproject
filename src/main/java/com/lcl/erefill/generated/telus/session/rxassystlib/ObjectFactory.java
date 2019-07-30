
package com.lcl.erefill.generated.telus.session.rxassystlib;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Establishment;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserAccountsGroup;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.session.RxAssystLib package. 
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

    private final static QName _LogOnDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "LogOnDetail");
    private final static QName _PatientModule_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "PatientModule");
    private final static QName _Account_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "Account");
    private final static QName _LogOnDetailConsentExpired_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "ConsentExpired");
    private final static QName _LogOnDetailEstablishment_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "Establishment");
    private final static QName _LogOnDetailGroupId_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "GroupId");
    private final static QName _LogOnDetailPatientOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "PatientOID");
	private final static QName _ELanguage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eLanguage");
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _EProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProvince");
    private final static QName _EAccountReceivable_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountReceivable");
    private final static QName _EEmailReturnCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eEmailReturnCode");
    private final static QName _EPHNType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePHNType");
    private final static QName _EVerifyIdentityReason_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eVerifyIdentityReason");
    private final static QName _EGender_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eGender");
    private final static QName _EAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountType");
    private final static QName _EAccountState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountState");
    private final static QName _EConfirmEmailReturnCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eConfirmEmailReturnCode");
    private final static QName _EPatientVerification_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePatientVerification");
    private final static QName _EGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eGroup");
    private final static QName _EContactType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eContactType");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");
	
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.session.RxAssystLib
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link LogOnDetail }
     * 
     */
    public LogOnDetail createLogOnDetail() {
        return new LogOnDetail();
    }

    /**
     * Create an instance of {@link PatientModule }
     * 
     */
    public PatientModule createPatientModule() {
        return new PatientModule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOnDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "LogOnDetail")
    public JAXBElement<LogOnDetail> createLogOnDetail(LogOnDetail value) {
        return new JAXBElement<LogOnDetail>(_LogOnDetail_QNAME, LogOnDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "PatientModule")
    public JAXBElement<PatientModule> createPatientModule(PatientModule value) {
        return new JAXBElement<PatientModule>(_PatientModule_QNAME, PatientModule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "Account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "ConsentExpired", scope = LogOnDetail.class)
    public JAXBElement<Boolean> createLogOnDetailConsentExpired(Boolean value) {
        return new JAXBElement<Boolean>(_LogOnDetailConsentExpired_QNAME, Boolean.class, LogOnDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Establishment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "Establishment", scope = LogOnDetail.class)
    public JAXBElement<Establishment> createLogOnDetailEstablishment(Establishment value) {
        return new JAXBElement<Establishment>(_LogOnDetailEstablishment_QNAME, Establishment.class, LogOnDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "GroupId", scope = LogOnDetail.class)
    public JAXBElement<UserAccountsGroup> createLogOnDetailGroupId(UserAccountsGroup value) {
        return new JAXBElement<UserAccountsGroup>(_LogOnDetailGroupId_QNAME, UserAccountsGroup.class, LogOnDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "Account", scope = LogOnDetail.class)
    public JAXBElement<Account> createLogOnDetailAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, LogOnDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "PatientOID", scope = LogOnDetail.class)
    public JAXBElement<String> createLogOnDetailPatientOID(String value) {
        return new JAXBElement<String>(_LogOnDetailPatientOID_QNAME, String.class, LogOnDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "PatientModule", scope = LogOnDetail.class)
    public JAXBElement<PatientModule> createLogOnDetailPatientModule(PatientModule value) {
        return new JAXBElement<PatientModule>(_PatientModule_QNAME, PatientModule.class, LogOnDetail.class, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ELanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eLanguage")
    public JAXBElement<ELanguage> createELanguage(ELanguage value) {
        return new JAXBElement<ELanguage>(_ELanguage_QNAME, ELanguage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eTokenStatus")
    public JAXBElement<List<String>> createETokenStatus(List<String> value) {
        return new JAXBElement<List<String>>(_ETokenStatus_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EProvince }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eProvince")
    public JAXBElement<EProvince> createEProvince(EProvince value) {
        return new JAXBElement<EProvince>(_EProvince_QNAME, EProvince.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAccountReceivable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eAccountReceivable")
    public JAXBElement<EAccountReceivable> createEAccountReceivable(EAccountReceivable value) {
        return new JAXBElement<EAccountReceivable>(_EAccountReceivable_QNAME, EAccountReceivable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EEmailReturnCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eEmailReturnCode")
    public JAXBElement<EEmailReturnCode> createEEmailReturnCode(EEmailReturnCode value) {
        return new JAXBElement<EEmailReturnCode>(_EEmailReturnCode_QNAME, EEmailReturnCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPHNType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePHNType")
    public JAXBElement<EPHNType> createEPHNType(EPHNType value) {
        return new JAXBElement<EPHNType>(_EPHNType_QNAME, EPHNType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EVerifyIdentityReason }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eVerifyIdentityReason")
    public JAXBElement<EVerifyIdentityReason> createEVerifyIdentityReason(EVerifyIdentityReason value) {
        return new JAXBElement<EVerifyIdentityReason>(_EVerifyIdentityReason_QNAME, EVerifyIdentityReason.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eGender")
    public JAXBElement<EGender> createEGender(EGender value) {
        return new JAXBElement<EGender>(_EGender_QNAME, EGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eAccountType")
    public JAXBElement<EAccountType> createEAccountType(EAccountType value) {
        return new JAXBElement<EAccountType>(_EAccountType_QNAME, EAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAccountState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eAccountState")
    public JAXBElement<EAccountState> createEAccountState(EAccountState value) {
        return new JAXBElement<EAccountState>(_EAccountState_QNAME, EAccountState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EConfirmEmailReturnCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eConfirmEmailReturnCode")
    public JAXBElement<EConfirmEmailReturnCode> createEConfirmEmailReturnCode(EConfirmEmailReturnCode value) {
        return new JAXBElement<EConfirmEmailReturnCode>(_EConfirmEmailReturnCode_QNAME, EConfirmEmailReturnCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPatientVerification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePatientVerification")
    public JAXBElement<EPatientVerification> createEPatientVerification(EPatientVerification value) {
        return new JAXBElement<EPatientVerification>(_EPatientVerification_QNAME, EPatientVerification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eGroup")
    public JAXBElement<EGroup> createEGroup(EGroup value) {
        return new JAXBElement<EGroup>(_EGroup_QNAME, EGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EContactType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eContactType")
    public JAXBElement<EContactType> createEContactType(EContactType value) {
        return new JAXBElement<EContactType>(_EContactType_QNAME, EContactType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ErrorCodes")
    public JAXBElement<List<String>> createErrorCodes(List<String> value) {
        return new JAXBElement<List<String>>(_ErrorCodes_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }
}
