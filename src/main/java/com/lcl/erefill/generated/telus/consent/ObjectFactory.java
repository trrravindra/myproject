
package com.lcl.erefill.generated.telus.consent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.lcl.erefill.generated.telus.consent.rxassystlib.EProfileReplicationOperation;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Consent;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentCode;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ConsentStatuses;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.ReasonCode;
import com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken;
import com.lcl.erefill.generated.telus.consent.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _Consents_QNAME = new QName("http://tempuri.org/", "Consents");
    private final static QName _ConsentCode_QNAME = new QName("http://tempuri.org/", "ConsentCode");
    private final static QName _ConsentIds_QNAME = new QName("http://tempuri.org/", "ConsentIds");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _ReasonCode_QNAME = new QName("http://tempuri.org/", "ReasonCode");
    private final static QName _Consent_QNAME = new QName("http://tempuri.org/", "Consent");
    private final static QName _ProfileReplication_QNAME = new QName("http://tempuri.org/", "ProfileReplication");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentStatuses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Consents")
    public JAXBElement<ConsentStatuses> createConsents(ConsentStatuses value) {
        return new JAXBElement<ConsentStatuses>(_Consents_QNAME, ConsentStatuses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsentCode")
    public JAXBElement<ConsentCode> createConsentCode(ConsentCode value) {
        return new JAXBElement<ConsentCode>(_ConsentCode_QNAME, ConsentCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsentIds")
    public JAXBElement<ArrayOfint> createConsentIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_ConsentIds_QNAME, ArrayOfint.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReasonCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReasonCode")
    public JAXBElement<ReasonCode> createReasonCode(ReasonCode value) {
        return new JAXBElement<ReasonCode>(_ReasonCode_QNAME, ReasonCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Consent")
    public JAXBElement<Consent> createConsent(Consent value) {
        return new JAXBElement<Consent>(_Consent_QNAME, Consent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EProfileReplicationOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ProfileReplication")
    public JAXBElement<EProfileReplicationOperation> createProfileReplication(EProfileReplicationOperation value) {
        return new JAXBElement<EProfileReplicationOperation>(_ProfileReplication_QNAME, EProfileReplicationOperation.class, null, value);
    }

}
