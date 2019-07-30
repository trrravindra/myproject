
package com.lcl.erefill.generated.telus.request.prescription;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.request.prescription.microsoft.schemas._2003._10.serialization.arrays.ArrayOflong;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.Paging;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.Payment;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestStateWrapper;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RequestUnsubscribe;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxListRequests;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxNewRequest;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxPrescription;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.RxRequest;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.request.prescription package. 
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

    private final static QName _IvrRequests_QNAME = new QName("http://tempuri.org/", "IvrRequests");
    private final static QName _PaymentRequests_QNAME = new QName("http://tempuri.org/", "PaymentRequests");
    private final static QName _Count_QNAME = new QName("http://tempuri.org/", "Count");
    private final static QName _PrescriptionOID_QNAME = new QName("http://tempuri.org/", "PrescriptionOID");
    private final static QName _Request_QNAME = new QName("http://tempuri.org/", "Request");
    private final static QName _ListRequests_QNAME = new QName("http://tempuri.org/", "ListRequests");
    private final static QName _Paging_QNAME = new QName("http://tempuri.org/", "Paging");
    private final static QName _RequestOID_QNAME = new QName("http://tempuri.org/", "RequestOID");
    private final static QName _RxRequest_QNAME = new QName("http://tempuri.org/", "RxRequest");
    private final static QName _Requests_QNAME = new QName("http://tempuri.org/", "Requests");
    private final static QName _RxNewRequest_QNAME = new QName("http://tempuri.org/", "RxNewRequest");
    private final static QName _DateFilter_QNAME = new QName("http://tempuri.org/", "DateFilter");
    private final static QName _TransactionDate_QNAME = new QName("http://tempuri.org/", "TransactionDate");
    private final static QName _Payment_QNAME = new QName("http://tempuri.org/", "Payment");
    private final static QName _Prescription_QNAME = new QName("http://tempuri.org/", "Prescription");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _RequestId_QNAME = new QName("http://tempuri.org/", "RequestId");
    private final static QName _PatientOID_QNAME = new QName("http://tempuri.org/", "PatientOID");
    private final static QName _RenewalAuthorizationRequests_QNAME = new QName("http://tempuri.org/", "RenewalAuthorizationRequests");
    private final static QName _UnsubscribeRequests_QNAME = new QName("http://tempuri.org/", "UnsubscribeRequests");
    private final static QName _RequestUnsubscribe_QNAME = new QName("http://tempuri.org/", "RequestUnsubscribe");
    private final static QName _Comments_QNAME = new QName("http://tempuri.org/", "Comments");
    private final static QName _RequestStateWrapper_QNAME = new QName("http://tempuri.org/", "RequestStateWrapper");
    private final static QName _RequestOid_QNAME = new QName("http://tempuri.org/", "RequestOid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.request.prescription
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "IvrRequests")
    public JAXBElement<ArrayOflong> createIvrRequests(ArrayOflong value) {
        return new JAXBElement<ArrayOflong>(_IvrRequests_QNAME, ArrayOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PaymentRequests")
    public JAXBElement<ArrayOflong> createPaymentRequests(ArrayOflong value) {
        return new JAXBElement<ArrayOflong>(_PaymentRequests_QNAME, ArrayOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Count")
    public JAXBElement<Integer> createCount(Integer value) {
        return new JAXBElement<Integer>(_Count_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PrescriptionOID")
    public JAXBElement<String> createPrescriptionOID(String value) {
        return new JAXBElement<String>(_PrescriptionOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Request")
    public JAXBElement<RxRequest> createRequest(RxRequest value) {
        return new JAXBElement<RxRequest>(_Request_QNAME, RxRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxListRequests }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ListRequests")
    public JAXBElement<RxListRequests> createListRequests(RxListRequests value) {
        return new JAXBElement<RxListRequests>(_ListRequests_QNAME, RxListRequests.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Paging }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Paging")
    public JAXBElement<Paging> createPaging(Paging value) {
        return new JAXBElement<Paging>(_Paging_QNAME, Paging.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestOID")
    public JAXBElement<String> createRequestOID(String value) {
        return new JAXBElement<String>(_RequestOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RxRequest")
    public JAXBElement<RxRequest> createRxRequest(RxRequest value) {
        return new JAXBElement<RxRequest>(_RxRequest_QNAME, RxRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Requests")
    public JAXBElement<ArrayOflong> createRequests(ArrayOflong value) {
        return new JAXBElement<ArrayOflong>(_Requests_QNAME, ArrayOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxNewRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RxNewRequest")
    public JAXBElement<RxNewRequest> createRxNewRequest(RxNewRequest value) {
        return new JAXBElement<RxNewRequest>(_RxNewRequest_QNAME, RxNewRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "DateFilter")
    public JAXBElement<XMLGregorianCalendar> createDateFilter(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateFilter_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "TransactionDate")
    public JAXBElement<XMLGregorianCalendar> createTransactionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TransactionDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxPrescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Prescription")
    public JAXBElement<RxPrescription> createPrescription(RxPrescription value) {
        return new JAXBElement<RxPrescription>(_Prescription_QNAME, RxPrescription.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestId")
    public JAXBElement<Long> createRequestId(Long value) {
        return new JAXBElement<Long>(_RequestId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientOID")
    public JAXBElement<String> createPatientOID(String value) {
        return new JAXBElement<String>(_PatientOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RenewalAuthorizationRequests")
    public JAXBElement<ArrayOflong> createRenewalAuthorizationRequests(ArrayOflong value) {
        return new JAXBElement<ArrayOflong>(_RenewalAuthorizationRequests_QNAME, ArrayOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UnsubscribeRequests")
    public JAXBElement<ArrayOflong> createUnsubscribeRequests(ArrayOflong value) {
        return new JAXBElement<ArrayOflong>(_UnsubscribeRequests_QNAME, ArrayOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestUnsubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestUnsubscribe")
    public JAXBElement<RequestUnsubscribe> createRequestUnsubscribe(RequestUnsubscribe value) {
        return new JAXBElement<RequestUnsubscribe>(_RequestUnsubscribe_QNAME, RequestUnsubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Comments")
    public JAXBElement<String> createComments(String value) {
        return new JAXBElement<String>(_Comments_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStateWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestStateWrapper")
    public JAXBElement<RequestStateWrapper> createRequestStateWrapper(RequestStateWrapper value) {
        return new JAXBElement<RequestStateWrapper>(_RequestStateWrapper_QNAME, RequestStateWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestOid")
    public JAXBElement<String> createRequestOid(String value) {
        return new JAXBElement<String>(_RequestOid_QNAME, String.class, null, value);
    }

}
