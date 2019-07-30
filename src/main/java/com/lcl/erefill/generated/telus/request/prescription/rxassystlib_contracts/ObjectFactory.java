
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.Account;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts package. 
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

    private final static QName _RequestStateWrapper_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RequestStateWrapper");
    private final static QName _Error_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "Error");
    private final static QName _RequestUnsubscribe_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RequestUnsubscribe");
    private final static QName _RxRenewPrescriptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxRenewPrescriptions");
    private final static QName _RxPrescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxPrescription");
    private final static QName _UserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserToken");
    private final static QName _RxListRequests_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxListRequests");
    private final static QName _Payment_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Payment");
    private final static QName _RxNewRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxNewRequest");
    private final static QName _RequestDelivery_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RequestDelivery");
    private final static QName _RxRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxRequest");
    private final static QName _Paging_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Paging");
    private final static QName _RxRenewPrescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxRenewPrescription");
    private final static QName _RxPatient_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxPatient");
    private final static QName _PrescriptionRestrictions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PrescriptionRestrictions");
    private final static QName _Request_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Request");
    private final static QName _RxListRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxListRequest");
    private final static QName _PrescriptionRestriction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PrescriptionRestriction");
    private final static QName _RxPrescriptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RxPrescriptions");
    private final static QName _RequestPhone_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Phone");
    private final static QName _RequestMobilePhoneNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "MobilePhoneNumber");
    private final static QName _RequestOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "OID");
    private final static QName _ErrorUserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "UserToken");
    private final static QName _RxPrescriptionProductForm_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ProductForm");
    private final static QName _RxPrescriptionProductStrength_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ProductStrength");
    private final static QName _RxPrescriptionRestrictions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Restrictions");
    private final static QName _RxPrescriptionSigDecoded_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "SigDecoded");
    private final static QName _RxPrescriptionExpirationDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ExpirationDateV2");
    private final static QName _UserTokenToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Token");
    private final static QName _PaymentAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Account");
    private final static QName _PaymentReferenceNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReferenceNumber");
    private final static QName _RxPatientBirthDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "BirthDateV2");
    private final static QName _RxListRequestPatient_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Patient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link RequestUnsubscribe }
     * 
     */
    public RequestUnsubscribe createRequestUnsubscribe() {
        return new RequestUnsubscribe();
    }

    /**
     * Create an instance of {@link RxNewRequest }
     * 
     */
    public RxNewRequest createRxNewRequest() {
        return new RxNewRequest();
    }

    /**
     * Create an instance of {@link RxListRequests }
     * 
     */
    public RxListRequests createRxListRequests() {
        return new RxListRequests();
    }

    /**
     * Create an instance of {@link RxPrescription }
     * 
     */
    public RxPrescription createRxPrescription() {
        return new RxPrescription();
    }

    /**
     * Create an instance of {@link UserToken }
     * 
     */
    public UserToken createUserToken() {
        return new UserToken();
    }

    /**
     * Create an instance of {@link RxRequest }
     * 
     */
    public RxRequest createRxRequest() {
        return new RxRequest();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link RequestStateWrapper }
     * 
     */
    public RequestStateWrapper createRequestStateWrapper() {
        return new RequestStateWrapper();
    }

    /**
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link PrescriptionRestriction }
     * 
     */
    public PrescriptionRestriction createPrescriptionRestriction() {
        return new PrescriptionRestriction();
    }

    /**
     * Create an instance of {@link RxPatient }
     * 
     */
    public RxPatient createRxPatient() {
        return new RxPatient();
    }

    /**
     * Create an instance of {@link RxPrescriptions }
     * 
     */
    public RxPrescriptions createRxPrescriptions() {
        return new RxPrescriptions();
    }

    /**
     * Create an instance of {@link RxListRequest }
     * 
     */
    public RxListRequest createRxListRequest() {
        return new RxListRequest();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link RxRenewPrescription }
     * 
     */
    public RxRenewPrescription createRxRenewPrescription() {
        return new RxRenewPrescription();
    }

    /**
     * Create an instance of {@link PrescriptionRestrictions }
     * 
     */
    public PrescriptionRestrictions createPrescriptionRestrictions() {
        return new PrescriptionRestrictions();
    }

    /**
     * Create an instance of {@link RequestDelivery }
     * 
     */
    public RequestDelivery createRequestDelivery() {
        return new RequestDelivery();
    }

    /**
     * Create an instance of {@link RxRenewPrescriptions }
     * 
     */
    public RxRenewPrescriptions createRxRenewPrescriptions() {
        return new RxRenewPrescriptions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStateWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RequestStateWrapper")
    public JAXBElement<RequestStateWrapper> createRequestStateWrapper(RequestStateWrapper value) {
        return new JAXBElement<RequestStateWrapper>(_RequestStateWrapper_QNAME, RequestStateWrapper.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestUnsubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RequestUnsubscribe")
    public JAXBElement<RequestUnsubscribe> createRequestUnsubscribe(RequestUnsubscribe value) {
        return new JAXBElement<RequestUnsubscribe>(_RequestUnsubscribe_QNAME, RequestUnsubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxRenewPrescriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxRenewPrescriptions")
    public JAXBElement<RxRenewPrescriptions> createRxRenewPrescriptions(RxRenewPrescriptions value) {
        return new JAXBElement<RxRenewPrescriptions>(_RxRenewPrescriptions_QNAME, RxRenewPrescriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxPrescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxPrescription")
    public JAXBElement<RxPrescription> createRxPrescription(RxPrescription value) {
        return new JAXBElement<RxPrescription>(_RxPrescription_QNAME, RxPrescription.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RxListRequests }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxListRequests")
    public JAXBElement<RxListRequests> createRxListRequests(RxListRequests value) {
        return new JAXBElement<RxListRequests>(_RxListRequests_QNAME, RxListRequests.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxNewRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxNewRequest")
    public JAXBElement<RxNewRequest> createRxNewRequest(RxNewRequest value) {
        return new JAXBElement<RxNewRequest>(_RxNewRequest_QNAME, RxNewRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestDelivery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RequestDelivery")
    public JAXBElement<RequestDelivery> createRequestDelivery(RequestDelivery value) {
        return new JAXBElement<RequestDelivery>(_RequestDelivery_QNAME, RequestDelivery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxRequest")
    public JAXBElement<RxRequest> createRxRequest(RxRequest value) {
        return new JAXBElement<RxRequest>(_RxRequest_QNAME, RxRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Paging }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Paging")
    public JAXBElement<Paging> createPaging(Paging value) {
        return new JAXBElement<Paging>(_Paging_QNAME, Paging.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxRenewPrescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxRenewPrescription")
    public JAXBElement<RxRenewPrescription> createRxRenewPrescription(RxRenewPrescription value) {
        return new JAXBElement<RxRenewPrescription>(_RxRenewPrescription_QNAME, RxRenewPrescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxPatient")
    public JAXBElement<RxPatient> createRxPatient(RxPatient value) {
        return new JAXBElement<RxPatient>(_RxPatient_QNAME, RxPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PrescriptionRestrictions")
    public JAXBElement<PrescriptionRestrictions> createPrescriptionRestrictions(PrescriptionRestrictions value) {
        return new JAXBElement<PrescriptionRestrictions>(_PrescriptionRestrictions_QNAME, PrescriptionRestrictions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Request")
    public JAXBElement<Request> createRequest(Request value) {
        return new JAXBElement<Request>(_Request_QNAME, Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxListRequest")
    public JAXBElement<RxListRequest> createRxListRequest(RxListRequest value) {
        return new JAXBElement<RxListRequest>(_RxListRequest_QNAME, RxListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescriptionRestriction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PrescriptionRestriction")
    public JAXBElement<PrescriptionRestriction> createPrescriptionRestriction(PrescriptionRestriction value) {
        return new JAXBElement<PrescriptionRestriction>(_PrescriptionRestriction_QNAME, PrescriptionRestriction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxPrescriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RxPrescriptions")
    public JAXBElement<RxPrescriptions> createRxPrescriptions(RxPrescriptions value) {
        return new JAXBElement<RxPrescriptions>(_RxPrescriptions_QNAME, RxPrescriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Phone", scope = Request.class)
    public JAXBElement<String> createRequestPhone(String value) {
        return new JAXBElement<String>(_RequestPhone_QNAME, String.class, Request.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "MobilePhoneNumber", scope = Request.class)
    public JAXBElement<String> createRequestMobilePhoneNumber(String value) {
        return new JAXBElement<String>(_RequestMobilePhoneNumber_QNAME, String.class, Request.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "OID", scope = Request.class)
    public JAXBElement<String> createRequestOID(String value) {
        return new JAXBElement<String>(_RequestOID_QNAME, String.class, Request.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "UserToken", scope = Error.class)
    public JAXBElement<UserToken> createErrorUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_ErrorUserToken_QNAME, UserToken.class, Error.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ProductForm", scope = RxPrescription.class)
    public JAXBElement<String> createRxPrescriptionProductForm(String value) {
        return new JAXBElement<String>(_RxPrescriptionProductForm_QNAME, String.class, RxPrescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ProductStrength", scope = RxPrescription.class)
    public JAXBElement<String> createRxPrescriptionProductStrength(String value) {
        return new JAXBElement<String>(_RxPrescriptionProductStrength_QNAME, String.class, RxPrescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Restrictions", scope = RxPrescription.class)
    public JAXBElement<PrescriptionRestrictions> createRxPrescriptionRestrictions(PrescriptionRestrictions value) {
        return new JAXBElement<PrescriptionRestrictions>(_RxPrescriptionRestrictions_QNAME, PrescriptionRestrictions.class, RxPrescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "SigDecoded", scope = RxPrescription.class)
    public JAXBElement<String> createRxPrescriptionSigDecoded(String value) {
        return new JAXBElement<String>(_RxPrescriptionSigDecoded_QNAME, String.class, RxPrescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ExpirationDateV2", scope = RxPrescription.class)
    public JAXBElement<XMLGregorianCalendar> createRxPrescriptionExpirationDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RxPrescriptionExpirationDateV2_QNAME, XMLGregorianCalendar.class, RxPrescription.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Account", scope = Payment.class)
    public JAXBElement<Account> createPaymentAccount(Account value) {
        return new JAXBElement<Account>(_PaymentAccount_QNAME, Account.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReferenceNumber", scope = Payment.class)
    public JAXBElement<String> createPaymentReferenceNumber(String value) {
        return new JAXBElement<String>(_PaymentReferenceNumber_QNAME, String.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "BirthDateV2", scope = RxPatient.class)
    public JAXBElement<XMLGregorianCalendar> createRxPatientBirthDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RxPatientBirthDateV2_QNAME, XMLGregorianCalendar.class, RxPatient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RxPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Patient", scope = RxListRequest.class)
    public JAXBElement<RxPatient> createRxListRequestPatient(RxPatient value) {
        return new JAXBElement<RxPatient>(_RxListRequestPatient_QNAME, RxPatient.class, RxListRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Phone", scope = RequestDelivery.class)
    public JAXBElement<String> createRequestDeliveryPhone(String value) {
        return new JAXBElement<String>(_RequestPhone_QNAME, String.class, RequestDelivery.class, value);
    }

}
