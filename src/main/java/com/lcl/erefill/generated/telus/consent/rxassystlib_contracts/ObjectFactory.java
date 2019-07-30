
package com.lcl.erefill.generated.telus.consent.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.rxassystlib_contracts package. 
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

    private final static QName _Error_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "Error");
    private final static QName _ConsentStatusEStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ConsentStatus.eStatus");
    private final static QName _ArrayOfConsentStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfConsentStatus");
    private final static QName _Consent_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Consent");
    private final static QName _ConsentStatuses_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ConsentStatuses");
    private final static QName _ConsentStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ConsentStatus");
    private final static QName _ArrayOfConsent_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfConsent");
    private final static QName _ReasonCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReasonCode");
    private final static QName _UserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserToken");
    private final static QName _ConsentCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ConsentCode");
    private final static QName _UserTokenToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Token");
    private final static QName _ReasonCodeReasonText_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReasonText");
    private final static QName _ErrorUserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "UserToken");
    private final static QName _ConsentOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "OID");
    private final static QName _ConsentDuration_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Duration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsentStatuses }
     * 
     */
    public ConsentStatuses createConsentStatuses() {
        return new ConsentStatuses();
    }

    /**
     * Create an instance of {@link ConsentCode }
     * 
     */
    public ConsentCode createConsentCode() {
        return new ConsentCode();
    }

    /**
     * Create an instance of {@link ReasonCode }
     * 
     */
    public ReasonCode createReasonCode() {
        return new ReasonCode();
    }

    /**
     * Create an instance of {@link UserToken }
     * 
     */
    public UserToken createUserToken() {
        return new UserToken();
    }

    /**
     * Create an instance of {@link Consent }
     * 
     */
    public Consent createConsent() {
        return new Consent();
    }

    /**
     * Create an instance of {@link ConsentStatus }
     * 
     */
    public ConsentStatus createConsentStatus() {
        return new ConsentStatus();
    }

    /**
     * Create an instance of {@link ArrayOfConsentStatus }
     * 
     */
    public ArrayOfConsentStatus createArrayOfConsentStatus() {
        return new ArrayOfConsentStatus();
    }

    /**
     * Create an instance of {@link ArrayOfConsent }
     * 
     */
    public ArrayOfConsent createArrayOfConsent() {
        return new ArrayOfConsent();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "Error")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentStatusEStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ConsentStatus.eStatus")
    public JAXBElement<ConsentStatusEStatus> createConsentStatusEStatus(ConsentStatusEStatus value) {
        return new JAXBElement<ConsentStatusEStatus>(_ConsentStatusEStatus_QNAME, ConsentStatusEStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConsentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfConsentStatus")
    public JAXBElement<ArrayOfConsentStatus> createArrayOfConsentStatus(ArrayOfConsentStatus value) {
        return new JAXBElement<ArrayOfConsentStatus>(_ArrayOfConsentStatus_QNAME, ArrayOfConsentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Consent")
    public JAXBElement<Consent> createConsent(Consent value) {
        return new JAXBElement<Consent>(_Consent_QNAME, Consent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentStatuses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ConsentStatuses")
    public JAXBElement<ConsentStatuses> createConsentStatuses(ConsentStatuses value) {
        return new JAXBElement<ConsentStatuses>(_ConsentStatuses_QNAME, ConsentStatuses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ConsentStatus")
    public JAXBElement<ConsentStatus> createConsentStatus(ConsentStatus value) {
        return new JAXBElement<ConsentStatus>(_ConsentStatus_QNAME, ConsentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConsent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfConsent")
    public JAXBElement<ArrayOfConsent> createArrayOfConsent(ArrayOfConsent value) {
        return new JAXBElement<ArrayOfConsent>(_ArrayOfConsent_QNAME, ArrayOfConsent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReasonCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReasonCode")
    public JAXBElement<ReasonCode> createReasonCode(ReasonCode value) {
        return new JAXBElement<ReasonCode>(_ReasonCode_QNAME, ReasonCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ConsentCode")
    public JAXBElement<ConsentCode> createConsentCode(ConsentCode value) {
        return new JAXBElement<ConsentCode>(_ConsentCode_QNAME, ConsentCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Token", scope = UserToken.class)
    public JAXBElement<byte[]> createUserTokenToken(byte[] value) {
        return new JAXBElement<byte[]>(_UserTokenToken_QNAME, byte[].class, UserToken.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReasonText", scope = ReasonCode.class)
    public JAXBElement<String> createReasonCodeReasonText(String value) {
        return new JAXBElement<String>(_ReasonCodeReasonText_QNAME, String.class, ReasonCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "UserToken", scope = Error.class)
    public JAXBElement<UserToken> createErrorUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_ErrorUserToken_QNAME, UserToken.class, Error.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "OID", scope = Consent.class)
    public JAXBElement<String> createConsentOID(String value) {
        return new JAXBElement<String>(_ConsentOID_QNAME, String.class, Consent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Duration", scope = Consent.class)
    public JAXBElement<Short> createConsentDuration(Short value) {
        return new JAXBElement<Short>(_ConsentDuration_QNAME, Short.class, Consent.class, value);
    }

}
