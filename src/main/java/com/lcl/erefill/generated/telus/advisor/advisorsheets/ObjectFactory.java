
package com.lcl.erefill.generated.telus.advisor.advisorsheets;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.CounsellingSheetLanguage;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken;


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

    private final static QName _ImageCheckSum_QNAME = new QName("http://tempuri.org/", "ImageCheckSum");
    private final static QName _URL_QNAME = new QName("http://tempuri.org/", "URL");
    private final static QName _ImageURL_QNAME = new QName("http://tempuri.org/", "ImageURL");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _CheckSum_QNAME = new QName("http://tempuri.org/", "CheckSum");
    private final static QName _Language_QNAME = new QName("http://tempuri.org/", "Language");
    private final static QName _DIN_QNAME = new QName("http://tempuri.org/", "DIN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ImageCheckSum")
    public JAXBElement<String> createImageCheckSum(String value) {
        return new JAXBElement<String>(_ImageCheckSum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "URL")
    public JAXBElement<String> createURL(String value) {
        return new JAXBElement<String>(_URL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ImageURL")
    public JAXBElement<String> createImageURL(String value) {
        return new JAXBElement<String>(_ImageURL_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckSum")
    public JAXBElement<String> createCheckSum(String value) {
        return new JAXBElement<String>(_CheckSum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CounsellingSheetLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Language")
    public JAXBElement<CounsellingSheetLanguage> createLanguage(CounsellingSheetLanguage value) {
        return new JAXBElement<CounsellingSheetLanguage>(_Language_QNAME, CounsellingSheetLanguage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "DIN")
    public JAXBElement<String> createDIN(String value) {
        return new JAXBElement<String>(_DIN_QNAME, String.class, null, value);
    }

}
