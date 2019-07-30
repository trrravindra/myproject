
package com.lcl.erefill.generated.telus.manager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.AccountPreferenceELanguagesSupported;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ActivationModule;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Agents;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfPharmacySearchElement;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfSearchElement;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ArrayOfUserAccountsGroup;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.AssignPharmacyRegionAssignmentAction;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.AssignUserAssignmentAction;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.AssignedPharmacies;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.EventMessageState;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.EventMessageType;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ExtendedInfo;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FacilitiesAssigned;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FacilityAssignmentStatus;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FamilyManagerPatientRequests;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FamilyManagerRequestState;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FilterAgentState;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.FilterParameters;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.GetEventMessages;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.HierarchicalTarget;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ListAgents;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Paging;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ParametersExtendedInfo;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.ParametersPermission;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Patients;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PatientsAssigned;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PermissionExtendedInfo;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Pharmacy;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyPMS;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyParameterValue;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyParameters;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyParametersValue;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.PharmacyTimeZone;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Physician;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Physicians;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Region;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Regions;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UpdateParameterPermission;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccountState;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccountType;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccounts;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccountsAssignmentStatus;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserAccountsGroup;
import com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _GetEventMessages_QNAME = new QName("http://tempuri.org/", "GetEventMessages");
    private final static QName _Region_QNAME = new QName("http://tempuri.org/", "Region");
    private final static QName _ActiveListPhysicians_QNAME = new QName("http://tempuri.org/", "ActiveListPhysicians");
    private final static QName _OID_QNAME = new QName("http://tempuri.org/", "OID");
    private final static QName _UserName_QNAME = new QName("http://tempuri.org/", "UserName");
    private final static QName _Username_QNAME = new QName("http://tempuri.org/", "Username");
    private final static QName _State_QNAME = new QName("http://tempuri.org/", "State");
    private final static QName _LinkedPharmacies_QNAME = new QName("http://tempuri.org/", "LinkedPharmacies");
    private final static QName _PharmacyPMS_QNAME = new QName("http://tempuri.org/", "PharmacyPMS");
    private final static QName _MainPharmacyContractNumber_QNAME = new QName("http://tempuri.org/", "MainPharmacyContractNumber");
    private final static QName _Description_QNAME = new QName("http://tempuri.org/", "Description");
    private final static QName _PharmacyRegionAssignmentAction_QNAME = new QName("http://tempuri.org/", "PharmacyRegionAssignmentAction");
    private final static QName _Paging_QNAME = new QName("http://tempuri.org/", "Paging");
    private final static QName _UpdatePharmacyParameter_QNAME = new QName("http://tempuri.org/", "UpdatePharmacyParameter");
    private final static QName _ManagerUsername_QNAME = new QName("http://tempuri.org/", "ManagerUsername");
    private final static QName _UserAccountState_QNAME = new QName("http://tempuri.org/", "UserAccountState");
    private final static QName _ExtendedInfo_QNAME = new QName("http://tempuri.org/", "ExtendedInfo");
    private final static QName _DateTo_QNAME = new QName("http://tempuri.org/", "DateTo");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _RegionOID_QNAME = new QName("http://tempuri.org/", "RegionOID");
    private final static QName _MessageState_QNAME = new QName("http://tempuri.org/", "MessageState");
    private final static QName _AssignmentAction_QNAME = new QName("http://tempuri.org/", "AssignmentAction");
    private final static QName _DateFrom_QNAME = new QName("http://tempuri.org/", "DateFrom");
    private final static QName _Comments_QNAME = new QName("http://tempuri.org/", "Comments");
    private final static QName _SearchCriteria_QNAME = new QName("http://tempuri.org/", "SearchCriteria");
    private final static QName _Patients_QNAME = new QName("http://tempuri.org/", "Patients");
    private final static QName _PermissionGroup_QNAME = new QName("http://tempuri.org/", "PermissionGroup");
    private final static QName _PharmacyTimeZone_QNAME = new QName("http://tempuri.org/", "PharmacyTimeZone");
    private final static QName _ActivationKey_QNAME = new QName("http://tempuri.org/", "ActivationKey");
    private final static QName _Password_QNAME = new QName("http://tempuri.org/", "Password");
    private final static QName _ParametersExtendedInfo_QNAME = new QName("http://tempuri.org/", "ParametersExtendedInfo");
    private final static QName _Physician_QNAME = new QName("http://tempuri.org/", "Physician");
    private final static QName _GuestUserName_QNAME = new QName("http://tempuri.org/", "GuestUserName");
    private final static QName _RequestsState_QNAME = new QName("http://tempuri.org/", "RequestsState");
    private final static QName _PharmacyParametersValue_QNAME = new QName("http://tempuri.org/", "PharmacyParametersValue");
    private final static QName _Language_QNAME = new QName("http://tempuri.org/", "Language");
    private final static QName _PatientUserName_QNAME = new QName("http://tempuri.org/", "PatientUserName");
    private final static QName _Email_QNAME = new QName("http://tempuri.org/", "Email");
    private final static QName _FilterParameters_QNAME = new QName("http://tempuri.org/", "FilterParameters");
    private final static QName _Pharmacy_QNAME = new QName("http://tempuri.org/", "Pharmacy");
    private final static QName _MessageType_QNAME = new QName("http://tempuri.org/", "MessageType");
    private final static QName _ManagedUsername_QNAME = new QName("http://tempuri.org/", "ManagedUsername");
    private final static QName _ParametersPermission_QNAME = new QName("http://tempuri.org/", "ParametersPermission");
    private final static QName _Count_QNAME = new QName("http://tempuri.org/", "Count");
    private final static QName _ContractNumber_QNAME = new QName("http://tempuri.org/", "ContractNumber");
    private final static QName _PharmacyContractNumber_QNAME = new QName("http://tempuri.org/", "PharmacyContractNumber");
    private final static QName _ActivationModule_QNAME = new QName("http://tempuri.org/", "ActivationModule");
    private final static QName _AssignedPharmacies_QNAME = new QName("http://tempuri.org/", "assignedPharmacies");
    private final static QName _AssignmentStatus_QNAME = new QName("http://tempuri.org/", "AssignmentStatus");
    private final static QName _RequestorUserName_QNAME = new QName("http://tempuri.org/", "RequestorUserName");
    private final static QName _Accounts_QNAME = new QName("http://tempuri.org/", "Accounts");
    private final static QName _Agents_QNAME = new QName("http://tempuri.org/", "Agents");
    private final static QName _PermissionExtendedInfo_QNAME = new QName("http://tempuri.org/", "PermissionExtendedInfo");
    private final static QName _AccountType_QNAME = new QName("http://tempuri.org/", "AccountType");
    private final static QName _ParentUserName_QNAME = new QName("http://tempuri.org/", "ParentUserName");
    private final static QName _FamilyManagerPatientRequests_QNAME = new QName("http://tempuri.org/", "FamilyManagerPatientRequests");
    private final static QName _UpdateValue_QNAME = new QName("http://tempuri.org/", "UpdateValue");
    private final static QName _SendPasswordByEmail_QNAME = new QName("http://tempuri.org/", "SendPasswordByEmail");
    private final static QName _EventMessageType_QNAME = new QName("http://tempuri.org/", "EventMessageType");
    private final static QName _PatientOID_QNAME = new QName("http://tempuri.org/", "PatientOID");
    private final static QName _ParentUsername_QNAME = new QName("http://tempuri.org/", "ParentUsername");
    private final static QName _FacilityOID_QNAME = new QName("http://tempuri.org/", "FacilityOID");
    private final static QName _GuestPassword_QNAME = new QName("http://tempuri.org/", "GuestPassword");
    private final static QName _PharmacySearchCriteria_QNAME = new QName("http://tempuri.org/", "PharmacySearchCriteria");
    private final static QName _Target_QNAME = new QName("http://tempuri.org/", "Target");
    private final static QName _LicenseAgreementDate_QNAME = new QName("http://tempuri.org/", "LicenseAgreementDate");
    private final static QName _PatientsAssigned_QNAME = new QName("http://tempuri.org/", "PatientsAssigned");
    private final static QName _ListRegions_QNAME = new QName("http://tempuri.org/", "ListRegions");
    private final static QName _FirstName_QNAME = new QName("http://tempuri.org/", "FirstName");
    private final static QName _ListAgents_QNAME = new QName("http://tempuri.org/", "ListAgents");
    private final static QName _FacilityAssignmentStatus_QNAME = new QName("http://tempuri.org/", "FacilityAssignmentStatus");
    private final static QName _CaregiverUserName_QNAME = new QName("http://tempuri.org/", "CaregiverUserName");
    private final static QName _GroupId_QNAME = new QName("http://tempuri.org/", "GroupId");
    private final static QName _SendNotification_QNAME = new QName("http://tempuri.org/", "SendNotification");
    private final static QName _FacilitiesAssigned_QNAME = new QName("http://tempuri.org/", "FacilitiesAssigned");
    private final static QName _ConsentOID_QNAME = new QName("http://tempuri.org/", "ConsentOID");
    private final static QName _ApplyParameters_QNAME = new QName("http://tempuri.org/", "ApplyParameters");
    private final static QName _LastName_QNAME = new QName("http://tempuri.org/", "LastName");
    private final static QName _GetPharmacyParameters_QNAME = new QName("http://tempuri.org/", "GetPharmacyParameters");
    private final static QName _ConsentForGuest_QNAME = new QName("http://tempuri.org/", "ConsentForGuest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetEventMessages")
    public JAXBElement<GetEventMessages> createGetEventMessages(GetEventMessages value) {
        return new JAXBElement<GetEventMessages>(_GetEventMessages_QNAME, GetEventMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Region")
    public JAXBElement<Region> createRegion(Region value) {
        return new JAXBElement<Region>(_Region_QNAME, Region.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Physicians }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ActiveListPhysicians")
    public JAXBElement<Physicians> createActiveListPhysicians(Physicians value) {
        return new JAXBElement<Physicians>(_ActiveListPhysicians_QNAME, Physicians.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "OID")
    public JAXBElement<String> createOID(String value) {
        return new JAXBElement<String>(_OID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserName")
    public JAXBElement<String> createUserName(String value) {
        return new JAXBElement<String>(_UserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterAgentState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "State")
    public JAXBElement<FilterAgentState> createState(FilterAgentState value) {
        return new JAXBElement<FilterAgentState>(_State_QNAME, FilterAgentState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "LinkedPharmacies")
    public JAXBElement<Boolean> createLinkedPharmacies(Boolean value) {
        return new JAXBElement<Boolean>(_LinkedPharmacies_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyPMS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyPMS")
    public JAXBElement<PharmacyPMS> createPharmacyPMS(PharmacyPMS value) {
        return new JAXBElement<PharmacyPMS>(_PharmacyPMS_QNAME, PharmacyPMS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MainPharmacyContractNumber")
    public JAXBElement<String> createMainPharmacyContractNumber(String value) {
        return new JAXBElement<String>(_MainPharmacyContractNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignPharmacyRegionAssignmentAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyRegionAssignmentAction")
    public JAXBElement<AssignPharmacyRegionAssignmentAction> createPharmacyRegionAssignmentAction(AssignPharmacyRegionAssignmentAction value) {
        return new JAXBElement<AssignPharmacyRegionAssignmentAction>(_PharmacyRegionAssignmentAction_QNAME, AssignPharmacyRegionAssignmentAction.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParameterValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdatePharmacyParameter")
    public JAXBElement<PharmacyParameterValue> createUpdatePharmacyParameter(PharmacyParameterValue value) {
        return new JAXBElement<PharmacyParameterValue>(_UpdatePharmacyParameter_QNAME, PharmacyParameterValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ManagerUsername")
    public JAXBElement<String> createManagerUsername(String value) {
        return new JAXBElement<String>(_ManagerUsername_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserAccountState")
    public JAXBElement<UserAccountState> createUserAccountState(UserAccountState value) {
        return new JAXBElement<UserAccountState>(_UserAccountState_QNAME, UserAccountState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ExtendedInfo")
    public JAXBElement<ExtendedInfo> createExtendedInfo(ExtendedInfo value) {
        return new JAXBElement<ExtendedInfo>(_ExtendedInfo_QNAME, ExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "DateTo")
    public JAXBElement<XMLGregorianCalendar> createDateTo(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTo_QNAME, XMLGregorianCalendar.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RegionOID")
    public JAXBElement<String> createRegionOID(String value) {
        return new JAXBElement<String>(_RegionOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MessageState")
    public JAXBElement<EventMessageState> createMessageState(EventMessageState value) {
        return new JAXBElement<EventMessageState>(_MessageState_QNAME, EventMessageState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignUserAssignmentAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AssignmentAction")
    public JAXBElement<AssignUserAssignmentAction> createAssignmentAction(AssignUserAssignmentAction value) {
        return new JAXBElement<AssignUserAssignmentAction>(_AssignmentAction_QNAME, AssignUserAssignmentAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "DateFrom")
    public JAXBElement<XMLGregorianCalendar> createDateFrom(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateFrom_QNAME, XMLGregorianCalendar.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchCriteria")
    public JAXBElement<ArrayOfSearchElement> createSearchCriteria(ArrayOfSearchElement value) {
        return new JAXBElement<ArrayOfSearchElement>(_SearchCriteria_QNAME, ArrayOfSearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Patients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Patients")
    public JAXBElement<Patients> createPatients(Patients value) {
        return new JAXBElement<Patients>(_Patients_QNAME, Patients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PermissionGroup")
    public JAXBElement<UserAccountsGroup> createPermissionGroup(UserAccountsGroup value) {
        return new JAXBElement<UserAccountsGroup>(_PermissionGroup_QNAME, UserAccountsGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyTimeZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyTimeZone")
    public JAXBElement<PharmacyTimeZone> createPharmacyTimeZone(PharmacyTimeZone value) {
        return new JAXBElement<PharmacyTimeZone>(_PharmacyTimeZone_QNAME, PharmacyTimeZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ActivationKey")
    public JAXBElement<String> createActivationKey(String value) {
        return new JAXBElement<String>(_ActivationKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParametersExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ParametersExtendedInfo")
    public JAXBElement<ParametersExtendedInfo> createParametersExtendedInfo(ParametersExtendedInfo value) {
        return new JAXBElement<ParametersExtendedInfo>(_ParametersExtendedInfo_QNAME, ParametersExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Physician }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Physician")
    public JAXBElement<Physician> createPhysician(Physician value) {
        return new JAXBElement<Physician>(_Physician_QNAME, Physician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GuestUserName")
    public JAXBElement<String> createGuestUserName(String value) {
        return new JAXBElement<String>(_GuestUserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyManagerRequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestsState")
    public JAXBElement<FamilyManagerRequestState> createRequestsState(FamilyManagerRequestState value) {
        return new JAXBElement<FamilyManagerRequestState>(_RequestsState_QNAME, FamilyManagerRequestState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParametersValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyParametersValue")
    public JAXBElement<PharmacyParametersValue> createPharmacyParametersValue(PharmacyParametersValue value) {
        return new JAXBElement<PharmacyParametersValue>(_PharmacyParametersValue_QNAME, PharmacyParametersValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountPreferenceELanguagesSupported }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Language")
    public JAXBElement<AccountPreferenceELanguagesSupported> createLanguage(AccountPreferenceELanguagesSupported value) {
        return new JAXBElement<AccountPreferenceELanguagesSupported>(_Language_QNAME, AccountPreferenceELanguagesSupported.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientUserName")
    public JAXBElement<String> createPatientUserName(String value) {
        return new JAXBElement<String>(_PatientUserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FilterParameters")
    public JAXBElement<FilterParameters> createFilterParameters(FilterParameters value) {
        return new JAXBElement<FilterParameters>(_FilterParameters_QNAME, FilterParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pharmacy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Pharmacy")
    public JAXBElement<Pharmacy> createPharmacy(Pharmacy value) {
        return new JAXBElement<Pharmacy>(_Pharmacy_QNAME, Pharmacy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MessageType")
    public JAXBElement<EventMessageType> createMessageType(EventMessageType value) {
        return new JAXBElement<EventMessageType>(_MessageType_QNAME, EventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ManagedUsername")
    public JAXBElement<String> createManagedUsername(String value) {
        return new JAXBElement<String>(_ManagedUsername_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParametersPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ParametersPermission")
    public JAXBElement<ParametersPermission> createParametersPermission(ParametersPermission value) {
        return new JAXBElement<ParametersPermission>(_ParametersPermission_QNAME, ParametersPermission.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ContractNumber")
    public JAXBElement<String> createContractNumber(String value) {
        return new JAXBElement<String>(_ContractNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacyContractNumber")
    public JAXBElement<String> createPharmacyContractNumber(String value) {
        return new JAXBElement<String>(_PharmacyContractNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivationModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ActivationModule")
    public JAXBElement<ActivationModule> createActivationModule(ActivationModule value) {
        return new JAXBElement<ActivationModule>(_ActivationModule_QNAME, ActivationModule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignedPharmacies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "assignedPharmacies")
    public JAXBElement<AssignedPharmacies> createAssignedPharmacies(AssignedPharmacies value) {
        return new JAXBElement<AssignedPharmacies>(_AssignedPharmacies_QNAME, AssignedPharmacies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountsAssignmentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AssignmentStatus")
    public JAXBElement<UserAccountsAssignmentStatus> createAssignmentStatus(UserAccountsAssignmentStatus value) {
        return new JAXBElement<UserAccountsAssignmentStatus>(_AssignmentStatus_QNAME, UserAccountsAssignmentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RequestorUserName")
    public JAXBElement<String> createRequestorUserName(String value) {
        return new JAXBElement<String>(_RequestorUserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Accounts")
    public JAXBElement<UserAccounts> createAccounts(UserAccounts value) {
        return new JAXBElement<UserAccounts>(_Accounts_QNAME, UserAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Agents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Agents")
    public JAXBElement<Agents> createAgents(Agents value) {
        return new JAXBElement<Agents>(_Agents_QNAME, Agents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PermissionExtendedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PermissionExtendedInfo")
    public JAXBElement<PermissionExtendedInfo> createPermissionExtendedInfo(PermissionExtendedInfo value) {
        return new JAXBElement<PermissionExtendedInfo>(_PermissionExtendedInfo_QNAME, PermissionExtendedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AccountType")
    public JAXBElement<UserAccountType> createAccountType(UserAccountType value) {
        return new JAXBElement<UserAccountType>(_AccountType_QNAME, UserAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ParentUserName")
    public JAXBElement<String> createParentUserName(String value) {
        return new JAXBElement<String>(_ParentUserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyManagerPatientRequests }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FamilyManagerPatientRequests")
    public JAXBElement<FamilyManagerPatientRequests> createFamilyManagerPatientRequests(FamilyManagerPatientRequests value) {
        return new JAXBElement<FamilyManagerPatientRequests>(_FamilyManagerPatientRequests_QNAME, FamilyManagerPatientRequests.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateParameterPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdateValue")
    public JAXBElement<UpdateParameterPermission> createUpdateValue(UpdateParameterPermission value) {
        return new JAXBElement<UpdateParameterPermission>(_UpdateValue_QNAME, UpdateParameterPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendPasswordByEmail")
    public JAXBElement<Boolean> createSendPasswordByEmail(Boolean value) {
        return new JAXBElement<Boolean>(_SendPasswordByEmail_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EventMessageType")
    public JAXBElement<EventMessageType> createEventMessageType(EventMessageType value) {
        return new JAXBElement<EventMessageType>(_EventMessageType_QNAME, EventMessageType.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ParentUsername")
    public JAXBElement<String> createParentUsername(String value) {
        return new JAXBElement<String>(_ParentUsername_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FacilityOID")
    public JAXBElement<String> createFacilityOID(String value) {
        return new JAXBElement<String>(_FacilityOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GuestPassword")
    public JAXBElement<String> createGuestPassword(String value) {
        return new JAXBElement<String>(_GuestPassword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPharmacySearchElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PharmacySearchCriteria")
    public JAXBElement<ArrayOfPharmacySearchElement> createPharmacySearchCriteria(ArrayOfPharmacySearchElement value) {
        return new JAXBElement<ArrayOfPharmacySearchElement>(_PharmacySearchCriteria_QNAME, ArrayOfPharmacySearchElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HierarchicalTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Target")
    public JAXBElement<HierarchicalTarget> createTarget(HierarchicalTarget value) {
        return new JAXBElement<HierarchicalTarget>(_Target_QNAME, HierarchicalTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "LicenseAgreementDate")
    public JAXBElement<XMLGregorianCalendar> createLicenseAgreementDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_LicenseAgreementDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientsAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PatientsAssigned")
    public JAXBElement<PatientsAssigned> createPatientsAssigned(PatientsAssigned value) {
        return new JAXBElement<PatientsAssigned>(_PatientsAssigned_QNAME, PatientsAssigned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ListRegions")
    public JAXBElement<Regions> createListRegions(Regions value) {
        return new JAXBElement<Regions>(_ListRegions_QNAME, Regions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FirstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAgents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ListAgents")
    public JAXBElement<ListAgents> createListAgents(ListAgents value) {
        return new JAXBElement<ListAgents>(_ListAgents_QNAME, ListAgents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityAssignmentStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FacilityAssignmentStatus")
    public JAXBElement<FacilityAssignmentStatus> createFacilityAssignmentStatus(FacilityAssignmentStatus value) {
        return new JAXBElement<FacilityAssignmentStatus>(_FacilityAssignmentStatus_QNAME, FacilityAssignmentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CaregiverUserName")
    public JAXBElement<String> createCaregiverUserName(String value) {
        return new JAXBElement<String>(_CaregiverUserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserAccountsGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GroupId")
    public JAXBElement<ArrayOfUserAccountsGroup> createGroupId(ArrayOfUserAccountsGroup value) {
        return new JAXBElement<ArrayOfUserAccountsGroup>(_GroupId_QNAME, ArrayOfUserAccountsGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendNotification")
    public JAXBElement<Boolean> createSendNotification(Boolean value) {
        return new JAXBElement<Boolean>(_SendNotification_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilitiesAssigned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "FacilitiesAssigned")
    public JAXBElement<FacilitiesAssigned> createFacilitiesAssigned(FacilitiesAssigned value) {
        return new JAXBElement<FacilitiesAssigned>(_FacilitiesAssigned_QNAME, FacilitiesAssigned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsentOID")
    public JAXBElement<String> createConsentOID(String value) {
        return new JAXBElement<String>(_ConsentOID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ApplyParameters")
    public JAXBElement<Boolean> createApplyParameters(Boolean value) {
        return new JAXBElement<Boolean>(_ApplyParameters_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "LastName")
    public JAXBElement<String> createLastName(String value) {
        return new JAXBElement<String>(_LastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPharmacyParameters")
    public JAXBElement<PharmacyParameters> createGetPharmacyParameters(PharmacyParameters value) {
        return new JAXBElement<PharmacyParameters>(_GetPharmacyParameters_QNAME, PharmacyParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsentForGuest")
    public JAXBElement<Boolean> createConsentForGuest(Boolean value) {
        return new JAXBElement<Boolean>(_ConsentForGuest_QNAME, Boolean.class, null, value);
    }

}
