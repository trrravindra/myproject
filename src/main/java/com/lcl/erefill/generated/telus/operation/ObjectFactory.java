
package com.lcl.erefill.generated.telus.operation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefill;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefillCalendars;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.AutomatedRefills;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.MedReleaseMode;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.OperationalEvent;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RefillReminder;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RefillReminderCalendars;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RefillReminders;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.RxNewRequest;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.operation package. 
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

    private final static QName _UserToken_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "UserToken");
    private final static QName _OperationalEvent_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "OperationalEvent");
    private final static QName _RxNewRequest_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "RxNewRequest");
    private final static QName _AutomatedRefills_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "AutomatedRefills");
    private final static QName _RefillReminders_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "RefillReminders");
    private final static QName _Email_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "Email");
    private final static QName _PatientOID_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "PatientOID");
    private final static QName _RequestOid_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "RequestOid");
    private final static QName _AutomatedRefill_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "AutomatedRefill");
    private final static QName _RefillReminderCalendars_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "RefillReminderCalendars");
    private final static QName _BufferTimeHours_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "BufferTimeHours");
    private final static QName _PharmacyContractNumber_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "PharmacyContractNumber");
    private final static QName _OID_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "OID");
    private final static QName _RefillReminder_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "RefillReminder");
    private final static QName _OriginalPrescriptionOID_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "OriginalPrescriptionOID");
    private final static QName _PatientOid_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "PatientOid");
    private final static QName _MobilePhoneNumber_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "MobilePhoneNumber");
    private final static QName _AutomatedRefillCalendars_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "AutomatedRefillCalendars");
    private final static QName _MedReleaseMode_QNAME = new QName("http://www.RxAssyst.com/Operation/2012/08", "MedReleaseMode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.operation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationalEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "OperationalEvent")
    public JAXBElement<OperationalEvent> createOperationalEvent(OperationalEvent value) {
        return new JAXBElement<OperationalEvent>(_OperationalEvent_QNAME, OperationalEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxNewRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "RxNewRequest")
    public JAXBElement<RxNewRequest> createRxNewRequest(RxNewRequest value) {
        return new JAXBElement<RxNewRequest>(_RxNewRequest_QNAME, RxNewRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutomatedRefills }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "AutomatedRefills")
    public JAXBElement<AutomatedRefills> createAutomatedRefills(AutomatedRefills value) {
        return new JAXBElement<AutomatedRefills>(_AutomatedRefills_QNAME, AutomatedRefills.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefillReminders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "RefillReminders")
    public JAXBElement<RefillReminders> createRefillReminders(RefillReminders value) {
        return new JAXBElement<RefillReminders>(_RefillReminders_QNAME, RefillReminders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "PatientOID")
    public JAXBElement<String> createPatientOID(String value) {
        return new JAXBElement<String>(_PatientOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "RequestOid")
    public JAXBElement<String> createRequestOid(String value) {
        return new JAXBElement<String>(_RequestOid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutomatedRefill }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "AutomatedRefill")
    public JAXBElement<AutomatedRefill> createAutomatedRefill(AutomatedRefill value) {
        return new JAXBElement<AutomatedRefill>(_AutomatedRefill_QNAME, AutomatedRefill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefillReminderCalendars }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "RefillReminderCalendars")
    public JAXBElement<RefillReminderCalendars> createRefillReminderCalendars(RefillReminderCalendars value) {
        return new JAXBElement<RefillReminderCalendars>(_RefillReminderCalendars_QNAME, RefillReminderCalendars.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "BufferTimeHours")
    public JAXBElement<Integer> createBufferTimeHours(Integer value) {
        return new JAXBElement<Integer>(_BufferTimeHours_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "PharmacyContractNumber")
    public JAXBElement<String> createPharmacyContractNumber(String value) {
        return new JAXBElement<String>(_PharmacyContractNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "OID")
    public JAXBElement<String> createOID(String value) {
        return new JAXBElement<String>(_OID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefillReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "RefillReminder")
    public JAXBElement<RefillReminder> createRefillReminder(RefillReminder value) {
        return new JAXBElement<RefillReminder>(_RefillReminder_QNAME, RefillReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "OriginalPrescriptionOID")
    public JAXBElement<String> createOriginalPrescriptionOID(String value) {
        return new JAXBElement<String>(_OriginalPrescriptionOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "PatientOid")
    public JAXBElement<String> createPatientOid(String value) {
        return new JAXBElement<String>(_PatientOid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "MobilePhoneNumber")
    public JAXBElement<String> createMobilePhoneNumber(String value) {
        return new JAXBElement<String>(_MobilePhoneNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutomatedRefillCalendars }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "AutomatedRefillCalendars")
    public JAXBElement<AutomatedRefillCalendars> createAutomatedRefillCalendars(AutomatedRefillCalendars value) {
        return new JAXBElement<AutomatedRefillCalendars>(_AutomatedRefillCalendars_QNAME, AutomatedRefillCalendars.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedReleaseMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.RxAssyst.com/Operation/2012/08", name = "MedReleaseMode")
    public JAXBElement<MedReleaseMode> createMedReleaseMode(MedReleaseMode value) {
        return new JAXBElement<MedReleaseMode>(_MedReleaseMode_QNAME, MedReleaseMode.class, null, value);
    }

}
