
package com.lcl.erefill.generated.telus.consent.rxassystlib;

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

    private final static QName _ConsentType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ConsentType");
    private final static QName _EUnsubscribeReason_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eUnsubscribeReason");
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");
    private final static QName _EProfileReplicationOperation_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProfileReplicationOperation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ConsentType")
    public JAXBElement<ConsentType> createConsentType(ConsentType value) {
        return new JAXBElement<ConsentType>(_ConsentType_QNAME, ConsentType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ErrorCodes")
    public JAXBElement<List<String>> createErrorCodes(List<String> value) {
        return new JAXBElement<List<String>>(_ErrorCodes_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EProfileReplicationOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eProfileReplicationOperation")
    public JAXBElement<EProfileReplicationOperation> createEProfileReplicationOperation(EProfileReplicationOperation value) {
        return new JAXBElement<EProfileReplicationOperation>(_EProfileReplicationOperation_QNAME, EProfileReplicationOperation.class, null, value);
    }

}
