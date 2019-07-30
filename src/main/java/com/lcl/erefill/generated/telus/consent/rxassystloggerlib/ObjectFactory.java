
package com.lcl.erefill.generated.telus.consent.rxassystloggerlib;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.rxassystloggerlib package. 
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

    private final static QName _SimpleError_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", "SimpleError");
    private final static QName _SimpleErrorDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", "Description");
    private final static QName _SimpleErrorInternalDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", "InternalDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystloggerlib
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleError }
     * 
     */
    public SimpleError createSimpleError() {
        return new SimpleError();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", name = "SimpleError")
    public JAXBElement<SimpleError> createSimpleError(SimpleError value) {
        return new JAXBElement<SimpleError>(_SimpleError_QNAME, SimpleError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", name = "Description", scope = SimpleError.class)
    public JAXBElement<String> createSimpleErrorDescription(String value) {
        return new JAXBElement<String>(_SimpleErrorDescription_QNAME, String.class, SimpleError.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts", name = "InternalDescription", scope = SimpleError.class)
    public JAXBElement<String> createSimpleErrorInternalDescription(String value) {
        return new JAXBElement<String>(_SimpleErrorInternalDescription_QNAME, String.class, SimpleError.class, value);
    }

}
