
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.lcl.erefill.generated.telus.manager.rxassystlib.ArrayOfeParameterProperty;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EAccountType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.rxassystlib_contracts package. 
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

    private final static QName _PharmacyTargetPatientOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientOID");
    private final static QName _UserAccountsGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserAccountsGroup");
    private final static QName _GetEventMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "GetEventMessage");
    private final static QName _PatientAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientAccount");
    private final static QName _Pharmacy_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Pharmacy");
    private final static QName _FilterParameters_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FilterParameters");
    private final static QName _AssignedPharmacies_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AssignedPharmacies");
    private final static QName _PatientAccounts_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientAccounts");
    private final static QName _ListAgent_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ListAgent");
    private final static QName _PatientContacts_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientContacts");
    private final static QName _AccountPreferenceEAccountPreferenceType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AccountPreference.eAccountPreferenceType");
    private final static QName _PatientContact_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientContact");
    private final static QName _TenantTarget_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "TenantTarget");
    private final static QName _RegionTarget_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "RegionTarget");
    private final static QName _ParameterPermission_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ParameterPermission");
    private final static QName _PharmacyParametersValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyParametersValue");
    private final static QName _Facility_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Facility");
    private final static QName _Physician_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Physician");
    private final static QName _SearchElement_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "SearchElement");
    private final static QName _ParametersExtendedInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ParametersExtendedInfo");
    private final static QName _UserAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserAccountType");
    private final static QName _AssignedPharmacy_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AssignedPharmacy");
    private final static QName _PharmacyTimeZone_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyTimeZone");
    private final static QName _AssignUserAssignmentAction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AssignUserAssignmentAction");
    private final static QName _Patients_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Patients");
    private final static QName _Agent_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Agent");
    private final static QName _UserAccountsAssignmentStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserAccountsAssignmentStatus");
    private final static QName _UserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserToken");
    private final static QName _EventMessageState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "EventMessageState");
    private final static QName _HierarchicalTarget_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "HierarchicalTarget");
    private final static QName _ExtendedInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ExtendedInfo");
    private final static QName _UserAccountState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserAccountState");
    private final static QName _Paging_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Paging");
    private final static QName _UserAccounts_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserAccounts");
    private final static QName _PharmacyParameterValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyParameterValue");
    private final static QName _Patient_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Patient");
    private final static QName _PharmacyPMS_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyPMS");
    private final static QName _AssignPharmacyRegionAssignmentAction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AssignPharmacyRegionAssignmentAction");
    private final static QName _CultureValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "CultureValue");
    private final static QName _FilterAgentState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FilterAgentState");
    private final static QName _Region_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Region");
    private final static QName _AccountPreferenceELanguagesSupported_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AccountPreference.eLanguagesSupported");
    private final static QName _GetEventMessages_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "GetEventMessages");
    private final static QName _ArrayOfPharmacySearchElement_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfPharmacySearchElement");
    private final static QName _PharmacyParameters_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyParameters");
    private final static QName _PatientAssigned_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientAssigned");
    private final static QName _PharmacyTarget_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyTarget");
    private final static QName _FamilyManagerRequestState_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FamilyManagerRequestState");
    private final static QName _ProvinceTarget_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ProvinceTarget");
    private final static QName _FacilitiesAssigned_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FacilitiesAssigned");
    private final static QName _FacilityAssignmentStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FacilityAssignmentStatus");
    private final static QName _ListAgents_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ListAgents");
    private final static QName _PatientsAssigned_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PatientsAssigned");
    private final static QName _Error_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "Error");
    private final static QName _AssignmentEntity_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AssignmentEntity");
    private final static QName _ArrayOfAccountPreference_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfAccountPreference");
    private final static QName _ArrayOfSearchElement_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfSearchElement");
    private final static QName _CultureValues_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "CultureValues");
    private final static QName _PharmacyOpeningHour_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyOpeningHour");
    private final static QName _EventMessageType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "EventMessageType");
    private final static QName _ArrayOfPharmacyOpeningHour_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfPharmacyOpeningHour");
    private final static QName _PermissionExtendedInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PermissionExtendedInfo");
    private final static QName _FamilyManagerPatientRequests_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FamilyManagerPatientRequests");
    private final static QName _Agents_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Agents");
    private final static QName _Regions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Regions");
    private final static QName _FacilityAssigned_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FacilityAssigned");
    private final static QName _UpdateParameterPermission_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UpdateParameterPermission");
    private final static QName _AccountPreference_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AccountPreference");
    private final static QName _FamilyManagerPatientRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FamilyManagerPatientRequest");
    private final static QName _ActivationModule_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ActivationModule");
    private final static QName _Prescriber_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Prescriber");
    private final static QName _PharmacySearchElement_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacySearchElement");
    private final static QName _Physicians_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Physicians");
    private final static QName _ArrayOfUserAccountsGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ArrayOfUserAccountsGroup");
    private final static QName _ParametersPermission_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ParametersPermission");
    private final static QName _PhysicianOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "OID");
    private final static QName _ParameterPermissionCulture_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Culture");
    private final static QName _PharmacyParameterValuePermissions_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Permissions");
    private final static QName _PharmacyParametersTaxReceiptMessageMultiPharmacyEn_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "TaxReceiptMessageMultiPharmacyEn");
    private final static QName _PharmacyParametersTaxReceiptMessageMultiPharmacyFr_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "TaxReceiptMessageMultiPharmacyFr");
    private final static QName _PharmacyParametersTaxReceiptMessageEn_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "TaxReceiptMessageEn");
    private final static QName _PharmacyParametersTaxReceiptMessageFr_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "TaxReceiptMessageFr");
    private final static QName _GetEventMessageUserName_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserName");
    private final static QName _GetEventMessagePrescriptionOID_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PrescriptionOID");
    private final static QName _GetEventMessageAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "AccountType");
    private final static QName _GetEventMessageMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Message");
    private final static QName _FamilyManagerPatientRequestDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Description");
    private final static QName _PrescriberBirthDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "BirthDateV2");
    private final static QName _ErrorUserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "UserToken");
    private final static QName _FilterParametersParametersList_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ParametersList");
    private final static QName _PatientFacilityDepartureDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FacilityDepartureDateV2");
    private final static QName _PatientFacilityReturnDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "FacilityReturnDateV2");
    private final static QName _PatientCreationDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "CreationDateV2");
    private final static QName _PatientDefaultPharmacy_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "DefaultPharmacy");
    private final static QName _PatientHeightWeightModificationDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "HeightWeightModificationDateV2");
    private final static QName _PatientModificationDateV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ModificationDateV2");
    private final static QName _PharmacyPharmacyOpeningHours_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "PharmacyOpeningHours");
    private final static QName _PharmacyImageChecksum_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ImageChecksum");
    private final static QName _PharmacyInternalId_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "InternalId");
    private final static QName _PharmacyEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Email");
    private final static QName _UserTokenToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Token");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.rxassystlib_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListAgent }
     * 
     */
    public ListAgent createListAgent() {
        return new ListAgent();
    }

    /**
     * Create an instance of {@link ExtendedInfo }
     * 
     */
    public ExtendedInfo createExtendedInfo() {
        return new ExtendedInfo();
    }

    /**
     * Create an instance of {@link PharmacyParameters }
     * 
     */
    public PharmacyParameters createPharmacyParameters() {
        return new PharmacyParameters();
    }

    /**
     * Create an instance of {@link ArrayOfPharmacyOpeningHour }
     * 
     */
    public ArrayOfPharmacyOpeningHour createArrayOfPharmacyOpeningHour() {
        return new ArrayOfPharmacyOpeningHour();
    }

    /**
     * Create an instance of {@link UserToken }
     * 
     */
    public UserToken createUserToken() {
        return new UserToken();
    }

    /**
     * Create an instance of {@link EventMessageState }
     * 
     */
    public EventMessageState createEventMessageState() {
        return new EventMessageState();
    }

    /**
     * Create an instance of {@link PatientAccounts }
     * 
     */
    public PatientAccounts createPatientAccounts() {
        return new PatientAccounts();
    }

    /**
     * Create an instance of {@link HierarchicalTarget }
     * 
     */
    public HierarchicalTarget createHierarchicalTarget() {
        return new HierarchicalTarget();
    }

    /**
     * Create an instance of {@link ArrayOfPharmacySearchElement }
     * 
     */
    public ArrayOfPharmacySearchElement createArrayOfPharmacySearchElement() {
        return new ArrayOfPharmacySearchElement();
    }

    /**
     * Create an instance of {@link Agents }
     * 
     */
    public Agents createAgents() {
        return new Agents();
    }

    /**
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link PharmacyTarget }
     * 
     */
    public PharmacyTarget createPharmacyTarget() {
        return new PharmacyTarget();
    }

    /**
     * Create an instance of {@link PatientContacts }
     * 
     */
    public PatientContacts createPatientContacts() {
        return new PatientContacts();
    }

    /**
     * Create an instance of {@link PatientAssigned }
     * 
     */
    public PatientAssigned createPatientAssigned() {
        return new PatientAssigned();
    }

    /**
     * Create an instance of {@link UserAccountState }
     * 
     */
    public UserAccountState createUserAccountState() {
        return new UserAccountState();
    }

    /**
     * Create an instance of {@link FamilyManagerPatientRequests }
     * 
     */
    public FamilyManagerPatientRequests createFamilyManagerPatientRequests() {
        return new FamilyManagerPatientRequests();
    }

    /**
     * Create an instance of {@link PermissionExtendedInfo }
     * 
     */
    public PermissionExtendedInfo createPermissionExtendedInfo() {
        return new PermissionExtendedInfo();
    }

    /**
     * Create an instance of {@link UserAccountsAssignmentStatus }
     * 
     */
    public UserAccountsAssignmentStatus createUserAccountsAssignmentStatus() {
        return new UserAccountsAssignmentStatus();
    }

    /**
     * Create an instance of {@link PatientAccount }
     * 
     */
    public PatientAccount createPatientAccount() {
        return new PatientAccount();
    }

    /**
     * Create an instance of {@link GetEventMessage }
     * 
     */
    public GetEventMessage createGetEventMessage() {
        return new GetEventMessage();
    }

    /**
     * Create an instance of {@link Agent }
     * 
     */
    public Agent createAgent() {
        return new Agent();
    }

    /**
     * Create an instance of {@link Patients }
     * 
     */
    public Patients createPatients() {
        return new Patients();
    }

    /**
     * Create an instance of {@link UserAccountsGroup }
     * 
     */
    public UserAccountsGroup createUserAccountsGroup() {
        return new UserAccountsGroup();
    }

    /**
     * Create an instance of {@link FilterParameters }
     * 
     */
    public FilterParameters createFilterParameters() {
        return new FilterParameters();
    }

    /**
     * Create an instance of {@link EventMessageType }
     * 
     */
    public EventMessageType createEventMessageType() {
        return new EventMessageType();
    }

    /**
     * Create an instance of {@link AssignedPharmacies }
     * 
     */
    public AssignedPharmacies createAssignedPharmacies() {
        return new AssignedPharmacies();
    }

    /**
     * Create an instance of {@link AssignmentEntity }
     * 
     */
    public AssignmentEntity createAssignmentEntity() {
        return new AssignmentEntity();
    }

    /**
     * Create an instance of {@link ArrayOfAccountPreference }
     * 
     */
    public ArrayOfAccountPreference createArrayOfAccountPreference() {
        return new ArrayOfAccountPreference();
    }

    /**
     * Create an instance of {@link PharmacyOpeningHour }
     * 
     */
    public PharmacyOpeningHour createPharmacyOpeningHour() {
        return new PharmacyOpeningHour();
    }

    /**
     * Create an instance of {@link CultureValues }
     * 
     */
    public CultureValues createCultureValues() {
        return new CultureValues();
    }

    /**
     * Create an instance of {@link Pharmacy }
     * 
     */
    public Pharmacy createPharmacy() {
        return new Pharmacy();
    }

    /**
     * Create an instance of {@link ArrayOfSearchElement }
     * 
     */
    public ArrayOfSearchElement createArrayOfSearchElement() {
        return new ArrayOfSearchElement();
    }

    /**
     * Create an instance of {@link ParametersExtendedInfo }
     * 
     */
    public ParametersExtendedInfo createParametersExtendedInfo() {
        return new ParametersExtendedInfo();
    }

    /**
     * Create an instance of {@link CultureValue }
     * 
     */
    public CultureValue createCultureValue() {
        return new CultureValue();
    }

    /**
     * Create an instance of {@link FacilityAssignmentStatus }
     * 
     */
    public FacilityAssignmentStatus createFacilityAssignmentStatus() {
        return new FacilityAssignmentStatus();
    }

    /**
     * Create an instance of {@link ListAgents }
     * 
     */
    public ListAgents createListAgents() {
        return new ListAgents();
    }

    /**
     * Create an instance of {@link PharmacySearchElement }
     * 
     */
    public PharmacySearchElement createPharmacySearchElement() {
        return new PharmacySearchElement();
    }

    /**
     * Create an instance of {@link Physician }
     * 
     */
    public Physician createPhysician() {
        return new Physician();
    }

    /**
     * Create an instance of {@link ActivationModule }
     * 
     */
    public ActivationModule createActivationModule() {
        return new ActivationModule();
    }

    /**
     * Create an instance of {@link SearchElement }
     * 
     */
    public SearchElement createSearchElement() {
        return new SearchElement();
    }

    /**
     * Create an instance of {@link Prescriber }
     * 
     */
    public Prescriber createPrescriber() {
        return new Prescriber();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link PharmacyTimeZone }
     * 
     */
    public PharmacyTimeZone createPharmacyTimeZone() {
        return new PharmacyTimeZone();
    }

    /**
     * Create an instance of {@link ParametersPermission }
     * 
     */
    public ParametersPermission createParametersPermission() {
        return new ParametersPermission();
    }

    /**
     * Create an instance of {@link GetEventMessages }
     * 
     */
    public GetEventMessages createGetEventMessages() {
        return new GetEventMessages();
    }

    /**
     * Create an instance of {@link ArrayOfUserAccountsGroup }
     * 
     */
    public ArrayOfUserAccountsGroup createArrayOfUserAccountsGroup() {
        return new ArrayOfUserAccountsGroup();
    }

    /**
     * Create an instance of {@link AssignUserAssignmentAction }
     * 
     */
    public AssignUserAssignmentAction createAssignUserAssignmentAction() {
        return new AssignUserAssignmentAction();
    }

    /**
     * Create an instance of {@link Physicians }
     * 
     */
    public Physicians createPhysicians() {
        return new Physicians();
    }

    /**
     * Create an instance of {@link AssignedPharmacy }
     * 
     */
    public AssignedPharmacy createAssignedPharmacy() {
        return new AssignedPharmacy();
    }

    /**
     * Create an instance of {@link UserAccountType }
     * 
     */
    public UserAccountType createUserAccountType() {
        return new UserAccountType();
    }

    /**
     * Create an instance of {@link PatientsAssigned }
     * 
     */
    public PatientsAssigned createPatientsAssigned() {
        return new PatientsAssigned();
    }

    /**
     * Create an instance of {@link FilterAgentState }
     * 
     */
    public FilterAgentState createFilterAgentState() {
        return new FilterAgentState();
    }

    /**
     * Create an instance of {@link PharmacyParameterValue }
     * 
     */
    public PharmacyParameterValue createPharmacyParameterValue() {
        return new PharmacyParameterValue();
    }

    /**
     * Create an instance of {@link ParameterPermission }
     * 
     */
    public ParameterPermission createParameterPermission() {
        return new ParameterPermission();
    }

    /**
     * Create an instance of {@link ProvinceTarget }
     * 
     */
    public ProvinceTarget createProvinceTarget() {
        return new ProvinceTarget();
    }

    /**
     * Create an instance of {@link UpdateParameterPermission }
     * 
     */
    public UpdateParameterPermission createUpdateParameterPermission() {
        return new UpdateParameterPermission();
    }

    /**
     * Create an instance of {@link PatientContact }
     * 
     */
    public PatientContact createPatientContact() {
        return new PatientContact();
    }

    /**
     * Create an instance of {@link AccountPreference }
     * 
     */
    public AccountPreference createAccountPreference() {
        return new AccountPreference();
    }

    /**
     * Create an instance of {@link Regions }
     * 
     */
    public Regions createRegions() {
        return new Regions();
    }

    /**
     * Create an instance of {@link FacilityAssigned }
     * 
     */
    public FacilityAssigned createFacilityAssigned() {
        return new FacilityAssigned();
    }

    /**
     * Create an instance of {@link UserAccounts }
     * 
     */
    public UserAccounts createUserAccounts() {
        return new UserAccounts();
    }

    /**
     * Create an instance of {@link TenantTarget }
     * 
     */
    public TenantTarget createTenantTarget() {
        return new TenantTarget();
    }

    /**
     * Create an instance of {@link RegionTarget }
     * 
     */
    public RegionTarget createRegionTarget() {
        return new RegionTarget();
    }

    /**
     * Create an instance of {@link FamilyManagerRequestState }
     * 
     */
    public FamilyManagerRequestState createFamilyManagerRequestState() {
        return new FamilyManagerRequestState();
    }

    /**
     * Create an instance of {@link AssignPharmacyRegionAssignmentAction }
     * 
     */
    public AssignPharmacyRegionAssignmentAction createAssignPharmacyRegionAssignmentAction() {
        return new AssignPharmacyRegionAssignmentAction();
    }

    /**
     * Create an instance of {@link FacilitiesAssigned }
     * 
     */
    public FacilitiesAssigned createFacilitiesAssigned() {
        return new FacilitiesAssigned();
    }

    /**
     * Create an instance of {@link FamilyManagerPatientRequest }
     * 
     */
    public FamilyManagerPatientRequest createFamilyManagerPatientRequest() {
        return new FamilyManagerPatientRequest();
    }

    /**
     * Create an instance of {@link Facility }
     * 
     */
    public Facility createFacility() {
        return new Facility();
    }

    /**
     * Create an instance of {@link Patient }
     * 
     */
    public Patient createPatient() {
        return new Patient();
    }

    /**
     * Create an instance of {@link PharmacyParametersValue }
     * 
     */
    public PharmacyParametersValue createPharmacyParametersValue() {
        return new PharmacyParametersValue();
    }

    /**
     * Create an instance of {@link PharmacyPMS }
     * 
     */
    public PharmacyPMS createPharmacyPMS() {
        return new PharmacyPMS();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientOID", scope = PharmacyTarget.class)
    public JAXBElement<String> createPharmacyTargetPatientOID(String value) {
        return new JAXBElement<String>(_PharmacyTargetPatientOID_QNAME, String.class, PharmacyTarget.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserAccountsGroup")
    public JAXBElement<UserAccountsGroup> createUserAccountsGroup(UserAccountsGroup value) {
        return new JAXBElement<UserAccountsGroup>(_UserAccountsGroup_QNAME, UserAccountsGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "GetEventMessage")
    public JAXBElement<GetEventMessage> createGetEventMessage(GetEventMessage value) {
        return new JAXBElement<GetEventMessage>(_GetEventMessage_QNAME, GetEventMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientAccount")
    public JAXBElement<PatientAccount> createPatientAccount(PatientAccount value) {
        return new JAXBElement<PatientAccount>(_PatientAccount_QNAME, PatientAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pharmacy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Pharmacy")
    public JAXBElement<Pharmacy> createPharmacy(Pharmacy value) {
        return new JAXBElement<Pharmacy>(_Pharmacy_QNAME, Pharmacy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FilterParameters")
    public JAXBElement<FilterParameters> createFilterParameters(FilterParameters value) {
        return new JAXBElement<FilterParameters>(_FilterParameters_QNAME, FilterParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignedPharmacies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AssignedPharmacies")
    public JAXBElement<AssignedPharmacies> createAssignedPharmacies(AssignedPharmacies value) {
        return new JAXBElement<AssignedPharmacies>(_AssignedPharmacies_QNAME, AssignedPharmacies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientAccounts")
    public JAXBElement<PatientAccounts> createPatientAccounts(PatientAccounts value) {
        return new JAXBElement<PatientAccounts>(_PatientAccounts_QNAME, PatientAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAgent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ListAgent")
    public JAXBElement<ListAgent> createListAgent(ListAgent value) {
        return new JAXBElement<ListAgent>(_ListAgent_QNAME, ListAgent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientContacts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientContacts")
    public JAXBElement<PatientContacts> createPatientContacts(PatientContacts value) {
        return new JAXBElement<PatientContacts>(_PatientContacts_QNAME, PatientContacts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountPreferenceEAccountPreferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AccountPreference.eAccountPreferenceType")
    public JAXBElement<AccountPreferenceEAccountPreferenceType> createAccountPreferenceEAccountPreferenceType(AccountPreferenceEAccountPreferenceType value) {
        return new JAXBElement<AccountPreferenceEAccountPreferenceType>(_AccountPreferenceEAccountPreferenceType_QNAME, AccountPreferenceEAccountPreferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientContact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientContact")
    public JAXBElement<PatientContact> createPatientContact(PatientContact value) {
        return new JAXBElement<PatientContact>(_PatientContact_QNAME, PatientContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TenantTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "TenantTarget")
    public JAXBElement<TenantTarget> createTenantTarget(TenantTarget value) {
        return new JAXBElement<TenantTarget>(_TenantTarget_QNAME, TenantTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegionTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "RegionTarget")
    public JAXBElement<RegionTarget> createRegionTarget(RegionTarget value) {
        return new JAXBElement<RegionTarget>(_RegionTarget_QNAME, RegionTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ParameterPermission")
    public JAXBElement<ParameterPermission> createParameterPermission(ParameterPermission value) {
        return new JAXBElement<ParameterPermission>(_ParameterPermission_QNAME, ParameterPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParametersValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyParametersValue")
    public JAXBElement<PharmacyParametersValue> createPharmacyParametersValue(PharmacyParametersValue value) {
        return new JAXBElement<PharmacyParametersValue>(_PharmacyParametersValue_QNAME, PharmacyParametersValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Facility }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Facility")
    public JAXBElement<Facility> createFacility(Facility value) {
        return new JAXBElement<Facility>(_Facility_QNAME, Facility.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Physician }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Physician")
    public JAXBElement<Physician> createPhysician(Physician value) {
        return new JAXBElement<Physician>(_Physician_QNAME, Physician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "SearchElement")
    public JAXBElement<SearchElement> createSearchElement(SearchElement value) {
        return new JAXBElement<SearchElement>(_SearchElement_QNAME, SearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParametersExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ParametersExtendedInfo")
    public JAXBElement<ParametersExtendedInfo> createParametersExtendedInfo(ParametersExtendedInfo value) {
        return new JAXBElement<ParametersExtendedInfo>(_ParametersExtendedInfo_QNAME, ParametersExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserAccountType")
    public JAXBElement<UserAccountType> createUserAccountType(UserAccountType value) {
        return new JAXBElement<UserAccountType>(_UserAccountType_QNAME, UserAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignedPharmacy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AssignedPharmacy")
    public JAXBElement<AssignedPharmacy> createAssignedPharmacy(AssignedPharmacy value) {
        return new JAXBElement<AssignedPharmacy>(_AssignedPharmacy_QNAME, AssignedPharmacy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyTimeZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyTimeZone")
    public JAXBElement<PharmacyTimeZone> createPharmacyTimeZone(PharmacyTimeZone value) {
        return new JAXBElement<PharmacyTimeZone>(_PharmacyTimeZone_QNAME, PharmacyTimeZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignUserAssignmentAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AssignUserAssignmentAction")
    public JAXBElement<AssignUserAssignmentAction> createAssignUserAssignmentAction(AssignUserAssignmentAction value) {
        return new JAXBElement<AssignUserAssignmentAction>(_AssignUserAssignmentAction_QNAME, AssignUserAssignmentAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Patients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Patients")
    public JAXBElement<Patients> createPatients(Patients value) {
        return new JAXBElement<Patients>(_Patients_QNAME, Patients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Agent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Agent")
    public JAXBElement<Agent> createAgent(Agent value) {
        return new JAXBElement<Agent>(_Agent_QNAME, Agent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsAssignmentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserAccountsAssignmentStatus")
    public JAXBElement<UserAccountsAssignmentStatus> createUserAccountsAssignmentStatus(UserAccountsAssignmentStatus value) {
        return new JAXBElement<UserAccountsAssignmentStatus>(_UserAccountsAssignmentStatus_QNAME, UserAccountsAssignmentStatus.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "EventMessageState")
    public JAXBElement<EventMessageState> createEventMessageState(EventMessageState value) {
        return new JAXBElement<EventMessageState>(_EventMessageState_QNAME, EventMessageState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HierarchicalTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "HierarchicalTarget")
    public JAXBElement<HierarchicalTarget> createHierarchicalTarget(HierarchicalTarget value) {
        return new JAXBElement<HierarchicalTarget>(_HierarchicalTarget_QNAME, HierarchicalTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ExtendedInfo")
    public JAXBElement<ExtendedInfo> createExtendedInfo(ExtendedInfo value) {
        return new JAXBElement<ExtendedInfo>(_ExtendedInfo_QNAME, ExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserAccountState")
    public JAXBElement<UserAccountState> createUserAccountState(UserAccountState value) {
        return new JAXBElement<UserAccountState>(_UserAccountState_QNAME, UserAccountState.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserAccounts")
    public JAXBElement<UserAccounts> createUserAccounts(UserAccounts value) {
        return new JAXBElement<UserAccounts>(_UserAccounts_QNAME, UserAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParameterValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyParameterValue")
    public JAXBElement<PharmacyParameterValue> createPharmacyParameterValue(PharmacyParameterValue value) {
        return new JAXBElement<PharmacyParameterValue>(_PharmacyParameterValue_QNAME, PharmacyParameterValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Patient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Patient")
    public JAXBElement<Patient> createPatient(Patient value) {
        return new JAXBElement<Patient>(_Patient_QNAME, Patient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyPMS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyPMS")
    public JAXBElement<PharmacyPMS> createPharmacyPMS(PharmacyPMS value) {
        return new JAXBElement<PharmacyPMS>(_PharmacyPMS_QNAME, PharmacyPMS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignPharmacyRegionAssignmentAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AssignPharmacyRegionAssignmentAction")
    public JAXBElement<AssignPharmacyRegionAssignmentAction> createAssignPharmacyRegionAssignmentAction(AssignPharmacyRegionAssignmentAction value) {
        return new JAXBElement<AssignPharmacyRegionAssignmentAction>(_AssignPharmacyRegionAssignmentAction_QNAME, AssignPharmacyRegionAssignmentAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CultureValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "CultureValue")
    public JAXBElement<CultureValue> createCultureValue(CultureValue value) {
        return new JAXBElement<CultureValue>(_CultureValue_QNAME, CultureValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterAgentState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FilterAgentState")
    public JAXBElement<FilterAgentState> createFilterAgentState(FilterAgentState value) {
        return new JAXBElement<FilterAgentState>(_FilterAgentState_QNAME, FilterAgentState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Region")
    public JAXBElement<Region> createRegion(Region value) {
        return new JAXBElement<Region>(_Region_QNAME, Region.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountPreferenceELanguagesSupported }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AccountPreference.eLanguagesSupported")
    public JAXBElement<AccountPreferenceELanguagesSupported> createAccountPreferenceELanguagesSupported(AccountPreferenceELanguagesSupported value) {
        return new JAXBElement<AccountPreferenceELanguagesSupported>(_AccountPreferenceELanguagesSupported_QNAME, AccountPreferenceELanguagesSupported.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "GetEventMessages")
    public JAXBElement<GetEventMessages> createGetEventMessages(GetEventMessages value) {
        return new JAXBElement<GetEventMessages>(_GetEventMessages_QNAME, GetEventMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPharmacySearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfPharmacySearchElement")
    public JAXBElement<ArrayOfPharmacySearchElement> createArrayOfPharmacySearchElement(ArrayOfPharmacySearchElement value) {
        return new JAXBElement<ArrayOfPharmacySearchElement>(_ArrayOfPharmacySearchElement_QNAME, ArrayOfPharmacySearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyParameters")
    public JAXBElement<PharmacyParameters> createPharmacyParameters(PharmacyParameters value) {
        return new JAXBElement<PharmacyParameters>(_PharmacyParameters_QNAME, PharmacyParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientAssigned")
    public JAXBElement<PatientAssigned> createPatientAssigned(PatientAssigned value) {
        return new JAXBElement<PatientAssigned>(_PatientAssigned_QNAME, PatientAssigned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyTarget")
    public JAXBElement<PharmacyTarget> createPharmacyTarget(PharmacyTarget value) {
        return new JAXBElement<PharmacyTarget>(_PharmacyTarget_QNAME, PharmacyTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyManagerRequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FamilyManagerRequestState")
    public JAXBElement<FamilyManagerRequestState> createFamilyManagerRequestState(FamilyManagerRequestState value) {
        return new JAXBElement<FamilyManagerRequestState>(_FamilyManagerRequestState_QNAME, FamilyManagerRequestState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProvinceTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ProvinceTarget")
    public JAXBElement<ProvinceTarget> createProvinceTarget(ProvinceTarget value) {
        return new JAXBElement<ProvinceTarget>(_ProvinceTarget_QNAME, ProvinceTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilitiesAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FacilitiesAssigned")
    public JAXBElement<FacilitiesAssigned> createFacilitiesAssigned(FacilitiesAssigned value) {
        return new JAXBElement<FacilitiesAssigned>(_FacilitiesAssigned_QNAME, FacilitiesAssigned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityAssignmentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FacilityAssignmentStatus")
    public JAXBElement<FacilityAssignmentStatus> createFacilityAssignmentStatus(FacilityAssignmentStatus value) {
        return new JAXBElement<FacilityAssignmentStatus>(_FacilityAssignmentStatus_QNAME, FacilityAssignmentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAgents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ListAgents")
    public JAXBElement<ListAgents> createListAgents(ListAgents value) {
        return new JAXBElement<ListAgents>(_ListAgents_QNAME, ListAgents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientsAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientsAssigned")
    public JAXBElement<PatientsAssigned> createPatientsAssigned(PatientsAssigned value) {
        return new JAXBElement<PatientsAssigned>(_PatientsAssigned_QNAME, PatientsAssigned.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignmentEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AssignmentEntity")
    public JAXBElement<AssignmentEntity> createAssignmentEntity(AssignmentEntity value) {
        return new JAXBElement<AssignmentEntity>(_AssignmentEntity_QNAME, AssignmentEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAccountPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfAccountPreference")
    public JAXBElement<ArrayOfAccountPreference> createArrayOfAccountPreference(ArrayOfAccountPreference value) {
        return new JAXBElement<ArrayOfAccountPreference>(_ArrayOfAccountPreference_QNAME, ArrayOfAccountPreference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfSearchElement")
    public JAXBElement<ArrayOfSearchElement> createArrayOfSearchElement(ArrayOfSearchElement value) {
        return new JAXBElement<ArrayOfSearchElement>(_ArrayOfSearchElement_QNAME, ArrayOfSearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CultureValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "CultureValues")
    public JAXBElement<CultureValues> createCultureValues(CultureValues value) {
        return new JAXBElement<CultureValues>(_CultureValues_QNAME, CultureValues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyOpeningHour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyOpeningHour")
    public JAXBElement<PharmacyOpeningHour> createPharmacyOpeningHour(PharmacyOpeningHour value) {
        return new JAXBElement<PharmacyOpeningHour>(_PharmacyOpeningHour_QNAME, PharmacyOpeningHour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "EventMessageType")
    public JAXBElement<EventMessageType> createEventMessageType(EventMessageType value) {
        return new JAXBElement<EventMessageType>(_EventMessageType_QNAME, EventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPharmacyOpeningHour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfPharmacyOpeningHour")
    public JAXBElement<ArrayOfPharmacyOpeningHour> createArrayOfPharmacyOpeningHour(ArrayOfPharmacyOpeningHour value) {
        return new JAXBElement<ArrayOfPharmacyOpeningHour>(_ArrayOfPharmacyOpeningHour_QNAME, ArrayOfPharmacyOpeningHour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PermissionExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PermissionExtendedInfo")
    public JAXBElement<PermissionExtendedInfo> createPermissionExtendedInfo(PermissionExtendedInfo value) {
        return new JAXBElement<PermissionExtendedInfo>(_PermissionExtendedInfo_QNAME, PermissionExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyManagerPatientRequests }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FamilyManagerPatientRequests")
    public JAXBElement<FamilyManagerPatientRequests> createFamilyManagerPatientRequests(FamilyManagerPatientRequests value) {
        return new JAXBElement<FamilyManagerPatientRequests>(_FamilyManagerPatientRequests_QNAME, FamilyManagerPatientRequests.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Agents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Agents")
    public JAXBElement<Agents> createAgents(Agents value) {
        return new JAXBElement<Agents>(_Agents_QNAME, Agents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Regions")
    public JAXBElement<Regions> createRegions(Regions value) {
        return new JAXBElement<Regions>(_Regions_QNAME, Regions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FacilityAssigned")
    public JAXBElement<FacilityAssigned> createFacilityAssigned(FacilityAssigned value) {
        return new JAXBElement<FacilityAssigned>(_FacilityAssigned_QNAME, FacilityAssigned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateParameterPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UpdateParameterPermission")
    public JAXBElement<UpdateParameterPermission> createUpdateParameterPermission(UpdateParameterPermission value) {
        return new JAXBElement<UpdateParameterPermission>(_UpdateParameterPermission_QNAME, UpdateParameterPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AccountPreference")
    public JAXBElement<AccountPreference> createAccountPreference(AccountPreference value) {
        return new JAXBElement<AccountPreference>(_AccountPreference_QNAME, AccountPreference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyManagerPatientRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FamilyManagerPatientRequest")
    public JAXBElement<FamilyManagerPatientRequest> createFamilyManagerPatientRequest(FamilyManagerPatientRequest value) {
        return new JAXBElement<FamilyManagerPatientRequest>(_FamilyManagerPatientRequest_QNAME, FamilyManagerPatientRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivationModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ActivationModule")
    public JAXBElement<ActivationModule> createActivationModule(ActivationModule value) {
        return new JAXBElement<ActivationModule>(_ActivationModule_QNAME, ActivationModule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prescriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Prescriber")
    public JAXBElement<Prescriber> createPrescriber(Prescriber value) {
        return new JAXBElement<Prescriber>(_Prescriber_QNAME, Prescriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacySearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacySearchElement")
    public JAXBElement<PharmacySearchElement> createPharmacySearchElement(PharmacySearchElement value) {
        return new JAXBElement<PharmacySearchElement>(_PharmacySearchElement_QNAME, PharmacySearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Physicians }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Physicians")
    public JAXBElement<Physicians> createPhysicians(Physicians value) {
        return new JAXBElement<Physicians>(_Physicians_QNAME, Physicians.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ArrayOfUserAccountsGroup")
    public JAXBElement<ArrayOfUserAccountsGroup> createArrayOfUserAccountsGroup(ArrayOfUserAccountsGroup value) {
        return new JAXBElement<ArrayOfUserAccountsGroup>(_ArrayOfUserAccountsGroup_QNAME, ArrayOfUserAccountsGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParametersPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ParametersPermission")
    public JAXBElement<ParametersPermission> createParametersPermission(ParametersPermission value) {
        return new JAXBElement<ParametersPermission>(_ParametersPermission_QNAME, ParametersPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "OID", scope = Physician.class)
    public JAXBElement<String> createPhysicianOID(String value) {
        return new JAXBElement<String>(_PhysicianOID_QNAME, String.class, Physician.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CultureValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Culture", scope = ParameterPermission.class)
    public JAXBElement<CultureValues> createParameterPermissionCulture(CultureValues value) {
        return new JAXBElement<CultureValues>(_ParameterPermissionCulture_QNAME, CultureValues.class, ParameterPermission.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Permissions", scope = PharmacyParameterValue.class)
    public JAXBElement<List<String>> createPharmacyParameterValuePermissions(List<String> value) {
        return new JAXBElement<List<String>>(_PharmacyParameterValuePermissions_QNAME, ((Class) List.class), PharmacyParameterValue.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CultureValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Culture", scope = PharmacyParameterValue.class)
    public JAXBElement<CultureValues> createPharmacyParameterValueCulture(CultureValues value) {
        return new JAXBElement<CultureValues>(_ParameterPermissionCulture_QNAME, CultureValues.class, PharmacyParameterValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "TaxReceiptMessageMultiPharmacyEn", scope = PharmacyParameters.class)
    public JAXBElement<String> createPharmacyParametersTaxReceiptMessageMultiPharmacyEn(String value) {
        return new JAXBElement<String>(_PharmacyParametersTaxReceiptMessageMultiPharmacyEn_QNAME, String.class, PharmacyParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "TaxReceiptMessageMultiPharmacyFr", scope = PharmacyParameters.class)
    public JAXBElement<String> createPharmacyParametersTaxReceiptMessageMultiPharmacyFr(String value) {
        return new JAXBElement<String>(_PharmacyParametersTaxReceiptMessageMultiPharmacyFr_QNAME, String.class, PharmacyParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "TaxReceiptMessageEn", scope = PharmacyParameters.class)
    public JAXBElement<String> createPharmacyParametersTaxReceiptMessageEn(String value) {
        return new JAXBElement<String>(_PharmacyParametersTaxReceiptMessageEn_QNAME, String.class, PharmacyParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "TaxReceiptMessageFr", scope = PharmacyParameters.class)
    public JAXBElement<String> createPharmacyParametersTaxReceiptMessageFr(String value) {
        return new JAXBElement<String>(_PharmacyParametersTaxReceiptMessageFr_QNAME, String.class, PharmacyParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "OID", scope = Facility.class)
    public JAXBElement<String> createFacilityOID(String value) {
        return new JAXBElement<String>(_PhysicianOID_QNAME, String.class, Facility.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserName", scope = GetEventMessage.class)
    public JAXBElement<String> createGetEventMessageUserName(String value) {
        return new JAXBElement<String>(_GetEventMessageUserName_QNAME, String.class, GetEventMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PrescriptionOID", scope = GetEventMessage.class)
    public JAXBElement<String> createGetEventMessagePrescriptionOID(String value) {
        return new JAXBElement<String>(_GetEventMessagePrescriptionOID_QNAME, String.class, GetEventMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "AccountType", scope = GetEventMessage.class)
    public JAXBElement<EAccountType> createGetEventMessageAccountType(EAccountType value) {
        return new JAXBElement<EAccountType>(_GetEventMessageAccountType_QNAME, EAccountType.class, GetEventMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PatientOID", scope = GetEventMessage.class)
    public JAXBElement<String> createGetEventMessagePatientOID(String value) {
        return new JAXBElement<String>(_PharmacyTargetPatientOID_QNAME, String.class, GetEventMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Message", scope = GetEventMessage.class)
    public JAXBElement<String> createGetEventMessageMessage(String value) {
        return new JAXBElement<String>(_GetEventMessageMessage_QNAME, String.class, GetEventMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Description", scope = FamilyManagerPatientRequest.class)
    public JAXBElement<String> createFamilyManagerPatientRequestDescription(String value) {
        return new JAXBElement<String>(_FamilyManagerPatientRequestDescription_QNAME, String.class, FamilyManagerPatientRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "BirthDateV2", scope = Prescriber.class)
    public JAXBElement<XMLGregorianCalendar> createPrescriberBirthDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PrescriberBirthDateV2_QNAME, XMLGregorianCalendar.class, Prescriber.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfeParameterProperty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ParametersList", scope = FilterParameters.class)
    public JAXBElement<ArrayOfeParameterProperty> createFilterParametersParametersList(ArrayOfeParameterProperty value) {
        return new JAXBElement<ArrayOfeParameterProperty>(_FilterParametersParametersList_QNAME, ArrayOfeParameterProperty.class, FilterParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserName", scope = Patient.class)
    public JAXBElement<String> createPatientUserName(String value) {
        return new JAXBElement<String>(_GetEventMessageUserName_QNAME, String.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FacilityDepartureDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientFacilityDepartureDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PatientFacilityDepartureDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "BirthDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientBirthDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PrescriberBirthDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "FacilityReturnDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientFacilityReturnDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PatientFacilityReturnDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "CreationDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientCreationDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PatientCreationDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pharmacy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "DefaultPharmacy", scope = Patient.class)
    public JAXBElement<Pharmacy> createPatientDefaultPharmacy(Pharmacy value) {
        return new JAXBElement<Pharmacy>(_PatientDefaultPharmacy_QNAME, Pharmacy.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "HeightWeightModificationDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientHeightWeightModificationDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PatientHeightWeightModificationDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ModificationDateV2", scope = Patient.class)
    public JAXBElement<XMLGregorianCalendar> createPatientModificationDateV2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PatientModificationDateV2_QNAME, XMLGregorianCalendar.class, Patient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyPMS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyPMS", scope = Agent.class)
    public JAXBElement<PharmacyPMS> createAgentPharmacyPMS(PharmacyPMS value) {
        return new JAXBElement<PharmacyPMS>(_PharmacyPMS_QNAME, PharmacyPMS.class, Agent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "OID", scope = Region.class)
    public JAXBElement<String> createRegionOID(String value) {
        return new JAXBElement<String>(_PhysicianOID_QNAME, String.class, Region.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPharmacyOpeningHour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "PharmacyOpeningHours", scope = Pharmacy.class)
    public JAXBElement<ArrayOfPharmacyOpeningHour> createPharmacyPharmacyOpeningHours(ArrayOfPharmacyOpeningHour value) {
        return new JAXBElement<ArrayOfPharmacyOpeningHour>(_PharmacyPharmacyOpeningHours_QNAME, ArrayOfPharmacyOpeningHour.class, Pharmacy.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ImageChecksum", scope = Pharmacy.class)
    public JAXBElement<String> createPharmacyImageChecksum(String value) {
        return new JAXBElement<String>(_PharmacyImageChecksum_QNAME, String.class, Pharmacy.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "InternalId", scope = Pharmacy.class)
    public JAXBElement<String> createPharmacyInternalId(String value) {
        return new JAXBElement<String>(_PharmacyInternalId_QNAME, String.class, Pharmacy.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Email", scope = Pharmacy.class)
    public JAXBElement<String> createPharmacyEmail(String value) {
        return new JAXBElement<String>(_PharmacyEmail_QNAME, String.class, Pharmacy.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Message", scope = Pharmacy.class)
    public JAXBElement<String> createPharmacyMessage(String value) {
        return new JAXBElement<String>(_GetEventMessageMessage_QNAME, String.class, Pharmacy.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Token", scope = UserToken.class)
    public JAXBElement<byte[]> createUserTokenToken(byte[] value) {
        return new JAXBElement<byte[]>(_UserTokenToken_QNAME, byte[].class, UserToken.class, ((byte[]) value));
    }

}
