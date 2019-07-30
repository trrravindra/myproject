
package com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts;

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
    private final static QName _UserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserToken");
    private final static QName _CounsellingSheetLanguage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "CounsellingSheetLanguage");
    private final static QName _UserTokenToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Token");
    private final static QName _ErrorUserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "UserToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserToken }
     * 
     */
    public UserToken createUserToken() {
        return new UserToken();
    }

    /**
     * Create an instance of {@link CounsellingSheetLanguage }
     * 
     */
    public CounsellingSheetLanguage createCounsellingSheetLanguage() {
        return new CounsellingSheetLanguage();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CounsellingSheetLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "CounsellingSheetLanguage")
    public JAXBElement<CounsellingSheetLanguage> createCounsellingSheetLanguage(CounsellingSheetLanguage value) {
        return new JAXBElement<CounsellingSheetLanguage>(_CounsellingSheetLanguage_QNAME, CounsellingSheetLanguage.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "UserToken", scope = Error.class)
    public JAXBElement<UserToken> createErrorUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_ErrorUserToken_QNAME, UserToken.class, Error.class, value);
    }

}
