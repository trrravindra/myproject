
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.rxassystlib package. 
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

    private final static QName _ERxPrescriptionState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRxPrescriptionState");
    private final static QName _ELanguage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eLanguage");
    private final static QName _EMedReleaseMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eMedReleaseMode");
    private final static QName _EUnsubscribeReason_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eUnsubscribeReason");
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _EGender_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eGender");
    private final static QName _EProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProvince");
    private final static QName _EProfileReplicationOperation_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProfileReplicationOperation");
    private final static QName _EAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountType");
    private final static QName _EAccountState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountState");
    private final static QName _EUnsubscribeRequestState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eUnsubscribeRequestState");
    private final static QName _ERequestState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRequestState");
    private final static QName _Account_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "Account");
    private final static QName _ERestriction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRestriction");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ERxPrescriptionState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRxPrescriptionState")
    public JAXBElement<ERxPrescriptionState> createERxPrescriptionState(ERxPrescriptionState value) {
        return new JAXBElement<ERxPrescriptionState>(_ERxPrescriptionState_QNAME, ERxPrescriptionState.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EMedReleaseMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eMedReleaseMode")
    public JAXBElement<EMedReleaseMode> createEMedReleaseMode(EMedReleaseMode value) {
        return new JAXBElement<EMedReleaseMode>(_EMedReleaseMode_QNAME, EMedReleaseMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EUnsubscribeReason }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eUnsubscribeReason")
    public JAXBElement<EUnsubscribeReason> createEUnsubscribeReason(EUnsubscribeReason value) {
        return new JAXBElement<EUnsubscribeReason>(_EUnsubscribeReason_QNAME, EUnsubscribeReason.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eGender")
    public JAXBElement<EGender> createEGender(EGender value) {
        return new JAXBElement<EGender>(_EGender_QNAME, EGender.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EProfileReplicationOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eProfileReplicationOperation")
    public JAXBElement<EProfileReplicationOperation> createEProfileReplicationOperation(EProfileReplicationOperation value) {
        return new JAXBElement<EProfileReplicationOperation>(_EProfileReplicationOperation_QNAME, EProfileReplicationOperation.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EUnsubscribeRequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eUnsubscribeRequestState")
    public JAXBElement<EUnsubscribeRequestState> createEUnsubscribeRequestState(EUnsubscribeRequestState value) {
        return new JAXBElement<EUnsubscribeRequestState>(_EUnsubscribeRequestState_QNAME, EUnsubscribeRequestState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ERequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRequestState")
    public JAXBElement<ERequestState> createERequestState(ERequestState value) {
        return new JAXBElement<ERequestState>(_ERequestState_QNAME, ERequestState.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ERestriction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRestriction")
    public JAXBElement<ERestriction> createERestriction(ERestriction value) {
        return new JAXBElement<ERestriction>(_ERestriction_QNAME, ERestriction.class, null, value);
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
