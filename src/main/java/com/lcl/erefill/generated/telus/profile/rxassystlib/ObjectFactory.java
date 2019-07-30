
package com.lcl.erefill.generated.telus.profile.rxassystlib;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.profile.rxassystlib package. 
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
    private final static QName _ETokenStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eTokenStatus");
    private final static QName _EProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eProvince");
    private final static QName _EAccountReceivable_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAccountReceivable");
    private final static QName _PatientInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "PatientInfo");
    private final static QName _EPatientExtendedInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePatientExtendedInfo");
    private final static QName _EGenderTargeted_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eGenderTargeted");
    private final static QName _ERenewType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRenewType");
    private final static QName _ECalendarType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eCalendarType");
    private final static QName _ERestriction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRestriction");
    private final static QName _EPHNType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePHNType");
    private final static QName _ERxType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eRxType");
    private final static QName _EGender_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eGender");
    private final static QName _PatientModule_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib", "PatientModule");
    private final static QName _EDeliveryStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eDeliveryStatus");
    private final static QName _EAttributeType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAttributeType");
    private final static QName _EServiceType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eServiceType");
    private final static QName _EAbortedReason_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eAbortedReason");
    private final static QName _EPackagingType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePackagingType");
    private final static QName _EPrescriptionExtentedInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ePrescriptionExtentedInfo");
    private final static QName _EContactType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eContactType");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "ErrorCodes");
    private final static QName _ELegalStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", "eLegalStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.profile.rxassystlib
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientInfo }
     * 
     */
    public PatientInfo createPatientInfo() {
        return new PatientInfo();
    }

    /**
     * Create an instance of {@link PatientModule }
     * 
     */
    public PatientModule createPatientModule() {
        return new PatientModule();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "PatientInfo")
    public JAXBElement<PatientInfo> createPatientInfo(PatientInfo value) {
        return new JAXBElement<PatientInfo>(_PatientInfo_QNAME, PatientInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePatientExtendedInfo")
    public JAXBElement<List<String>> createEPatientExtendedInfo(List<String> value) {
        return new JAXBElement<List<String>>(_EPatientExtendedInfo_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EGenderTargeted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eGenderTargeted")
    public JAXBElement<EGenderTargeted> createEGenderTargeted(EGenderTargeted value) {
        return new JAXBElement<EGenderTargeted>(_EGenderTargeted_QNAME, EGenderTargeted.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ERenewType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRenewType")
    public JAXBElement<ERenewType> createERenewType(ERenewType value) {
        return new JAXBElement<ERenewType>(_ERenewType_QNAME, ERenewType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ECalendarType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eCalendarType")
    public JAXBElement<ECalendarType> createECalendarType(ECalendarType value) {
        return new JAXBElement<ECalendarType>(_ECalendarType_QNAME, ECalendarType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EPHNType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePHNType")
    public JAXBElement<EPHNType> createEPHNType(EPHNType value) {
        return new JAXBElement<EPHNType>(_EPHNType_QNAME, EPHNType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ERxType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eRxType")
    public JAXBElement<ERxType> createERxType(ERxType value) {
        return new JAXBElement<ERxType>(_ERxType_QNAME, ERxType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib", name = "PatientModule")
    public JAXBElement<PatientModule> createPatientModule(PatientModule value) {
        return new JAXBElement<PatientModule>(_PatientModule_QNAME, PatientModule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EDeliveryStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eDeliveryStatus")
    public JAXBElement<EDeliveryStatus> createEDeliveryStatus(EDeliveryStatus value) {
        return new JAXBElement<EDeliveryStatus>(_EDeliveryStatus_QNAME, EDeliveryStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAttributeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eAttributeType")
    public JAXBElement<EAttributeType> createEAttributeType(EAttributeType value) {
        return new JAXBElement<EAttributeType>(_EAttributeType_QNAME, EAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EServiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eServiceType")
    public JAXBElement<EServiceType> createEServiceType(EServiceType value) {
        return new JAXBElement<EServiceType>(_EServiceType_QNAME, EServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAbortedReason }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eAbortedReason")
    public JAXBElement<EAbortedReason> createEAbortedReason(EAbortedReason value) {
        return new JAXBElement<EAbortedReason>(_EAbortedReason_QNAME, EAbortedReason.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPackagingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePackagingType")
    public JAXBElement<EPackagingType> createEPackagingType(EPackagingType value) {
        return new JAXBElement<EPackagingType>(_EPackagingType_QNAME, EPackagingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "ePrescriptionExtentedInfo")
    public JAXBElement<List<String>> createEPrescriptionExtentedInfo(List<String> value) {
        return new JAXBElement<List<String>>(_EPrescriptionExtentedInfo_QNAME, ((Class) List.class), null, ((List<String> ) value));
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ELegalStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes", name = "eLegalStatus")
    public JAXBElement<ELegalStatus> createELegalStatus(ELegalStatus value) {
        return new JAXBElement<ELegalStatus>(_ELegalStatus_QNAME, ELegalStatus.class, null, value);
    }

}
