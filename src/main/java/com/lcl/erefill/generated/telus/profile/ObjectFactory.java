
package com.lcl.erefill.generated.telus.profile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.profile.rxassystlib.PatientInfo;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Actions;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.CustomFilters;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Paging;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Patient;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PatientExtendedInfo;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Pharmacies;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.PrescriptionExtendedInfo;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.Prescriptions;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.ProfilePrescriptions;
import com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.profile package. 
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

    private final static QName _CustomFilters_QNAME = new QName("http://tempuri.org/", "CustomFilters");
    private final static QName _ProfilePrescriptions_QNAME = new QName("http://tempuri.org/", "ProfilePrescriptions");
    private final static QName _Count_QNAME = new QName("http://tempuri.org/", "Count");
    private final static QName _PrescriptionOID_QNAME = new QName("http://tempuri.org/", "PrescriptionOID");
    private final static QName _PostalCode_QNAME = new QName("http://tempuri.org/", "PostalCode");
    private final static QName _Patient_QNAME = new QName("http://tempuri.org/", "Patient");
    private final static QName _PatientExtendedInfoCode_QNAME = new QName("http://tempuri.org/", "PatientExtendedInfoCode");
    private final static QName _PatientExtendedInfo_QNAME = new QName("http://tempuri.org/", "PatientExtendedInfo");
    private final static QName _Paging_QNAME = new QName("http://tempuri.org/", "Paging");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _PatientOID_QNAME = new QName("http://tempuri.org/", "PatientOID");
    private final static QName _Chain_QNAME = new QName("http://tempuri.org/", "Chain");
    private final static QName _City_QNAME = new QName("http://tempuri.org/", "City");
    private final static QName _Actions_QNAME = new QName("http://tempuri.org/", "Actions");
    private final static QName _EmailAddress_QNAME = new QName("http://tempuri.org/", "EmailAddress");
    private final static QName _Prescriptions_QNAME = new QName("http://tempuri.org/", "Prescriptions");
    private final static QName _PrescriptionExtendedInfo_QNAME = new QName("http://tempuri.org/", "PrescriptionExtendedInfo");
    private final static QName _Pharmacies_QNAME = new QName("http://tempuri.org/", "Pharmacies");
    private final static QName _PatientInfo_QNAME = new QName("http://tempuri.org/", "PatientInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.profile
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomFilters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CustomFilters")
    public JAXBElement<CustomFilters> createCustomFilters(CustomFilters value) {
        return new JAXBElement<CustomFilters>(_CustomFilters_QNAME, CustomFilters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfilePrescriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ProfilePrescriptions")
    public JAXBElement<ProfilePrescriptions> createProfilePrescriptions(ProfilePrescriptions value) {
        return new JAXBElement<ProfilePrescriptions>(_ProfilePrescriptions_QNAME, ProfilePrescriptions.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PostalCode")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Patient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Patient")
    public JAXBElement<Patient> createPatient(Patient value) {
        return new JAXBElement<Patient>(_Patient_QNAME, Patient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientExtendedInfoCode")
    public JAXBElement<Short> createPatientExtendedInfoCode(Short value) {
        return new JAXBElement<Short>(_PatientExtendedInfoCode_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientExtendedInfo")
    public JAXBElement<PatientExtendedInfo> createPatientExtendedInfo(PatientExtendedInfo value) {
        return new JAXBElement<PatientExtendedInfo>(_PatientExtendedInfo_QNAME, PatientExtendedInfo.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientOID")
    public JAXBElement<String> createPatientOID(String value) {
        return new JAXBElement<String>(_PatientOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Chain")
    public JAXBElement<String> createChain(String value) {
        return new JAXBElement<String>(_Chain_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "City")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Actions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Actions")
    public JAXBElement<Actions> createActions(Actions value) {
        return new JAXBElement<Actions>(_Actions_QNAME, Actions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EmailAddress")
    public JAXBElement<String> createEmailAddress(String value) {
        return new JAXBElement<String>(_EmailAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prescriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Prescriptions")
    public JAXBElement<Prescriptions> createPrescriptions(Prescriptions value) {
        return new JAXBElement<Prescriptions>(_Prescriptions_QNAME, Prescriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescriptionExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PrescriptionExtendedInfo")
    public JAXBElement<PrescriptionExtendedInfo> createPrescriptionExtendedInfo(PrescriptionExtendedInfo value) {
        return new JAXBElement<PrescriptionExtendedInfo>(_PrescriptionExtendedInfo_QNAME, PrescriptionExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pharmacies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Pharmacies")
    public JAXBElement<Pharmacies> createPharmacies(Pharmacies value) {
        return new JAXBElement<Pharmacies>(_Pharmacies_QNAME, Pharmacies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientInfo")
    public JAXBElement<PatientInfo> createPatientInfo(PatientInfo value) {
        return new JAXBElement<PatientInfo>(_PatientInfo_QNAME, PatientInfo.class, null, value);
    }

}
