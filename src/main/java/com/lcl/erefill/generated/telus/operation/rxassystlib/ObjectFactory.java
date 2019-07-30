
package com.lcl.erefill.generated.telus.operation.rxassystlib;

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
    private final static QName _EOperationalEventType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eOperationalEventType");
    private final static QName _EMedReleaseMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eMedReleaseMode");
    private final static QName _EOperationalEventState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eOperationalEventState");
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _EProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProvince");
    private final static QName _ERequestState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRequestState");
    private final static QName _ERestriction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRestriction");
    private final static QName _ERecurrenceType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRecurrenceType");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EOperationalEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eOperationalEventType")
    public JAXBElement<EOperationalEventType> createEOperationalEventType(EOperationalEventType value) {
        return new JAXBElement<EOperationalEventType>(_EOperationalEventType_QNAME, EOperationalEventType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EOperationalEventState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eOperationalEventState")
    public JAXBElement<EOperationalEventState> createEOperationalEventState(EOperationalEventState value) {
        return new JAXBElement<EOperationalEventState>(_EOperationalEventState_QNAME, EOperationalEventState.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ERequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRequestState")
    public JAXBElement<ERequestState> createERequestState(ERequestState value) {
        return new JAXBElement<ERequestState>(_ERequestState_QNAME, ERequestState.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ERecurrenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRecurrenceType")
    public JAXBElement<ERecurrenceType> createERecurrenceType(ERecurrenceType value) {
        return new JAXBElement<ERecurrenceType>(_ERecurrenceType_QNAME, ERecurrenceType.class, null, value);
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
