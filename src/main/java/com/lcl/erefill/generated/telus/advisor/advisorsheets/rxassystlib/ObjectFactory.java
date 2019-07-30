
package com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib;

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

    private final static QName _ELanguage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eLanguage");
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ErrorCodes")
    public JAXBElement<List<String>> createErrorCodes(List<String> value) {
        return new JAXBElement<List<String>>(_ErrorCodes_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

}
