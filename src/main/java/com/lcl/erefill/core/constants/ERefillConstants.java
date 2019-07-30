package com.lcl.erefill.core.constants;

public class ERefillConstants {
	
	public static final String PRODUCT_NAME 						= "erefill";
	public static final String SERVICVENDOR 						= "lcl-erefill";
	
	public static final String WCMMODE_EDIT 						= "edit";
	public static final String WCMMODE_PREVIEW 						= "preview";
	
	public static final String COOKIE_JSESSIONID 					= "JSESSIONID";
	public static final String COOKIE_CLICKED 					    = "clicked";
	public static final String COOKIE_AUTHENTICATED					= "true";
	public static final String COOKIE_LOGIN_STATUS					= "erefill-session";
	public static final String COOKIE_UNIQUIE_NAME					= "erefill-id";
	public static final String EREFILL_USERNAME 					= "erefillusername";
	public static final String EREFILL_FIRSTNAME 					= "erefillfirstname";
	public static final String COOKIE_USERNAME 						= "erefill-user-username";
	public static final String COOKIE_FIRSTNAME 					= "erefill-user-firstname";
	public static final String COOKIE_USER_PROVINCE					= "erefill-user-province";
	public static final String COOKIE_USER_LANG_PREF				= "erefill-user-language";
	public static final String COOKIE_USER_CITY						= "erefill_user_city";
	public static final String COOKIE_STORE_ID                      = "storeId";
	
	public static final String DELIMITER_DATEFORMAT                 = "-";
	public static final String ERROR_PAGE_URL                       = "/error.html";
	public static final String COOKIE_GLOBAL_NOTIFICATION			="erefill-global-notification";
	
	public static final String METHOD_START							= "Start of method";
	public static final String METHOD_END							= "End of method";
	
	public static final String MSG_RESPONSTIME						= "Integration Point Response Time";
	
	public static final String STATUS_SUCCESS						= "Ok";
	public static final String STATUS_INVALID_USER_PASSWORD			="eInvalidUserPassword";
	public static final String STATUS_ACCESS_DENIED					="eAccessDenied";
	public static final String STATUS_INVALID_ARGUMENTS				="eInvalidArguments";
	public static final String STATUS_SESSION_EXPIRED				="eSessionExpired";
	public static final String STATUS_MAX_SESSIONS_REACHED			="eMaxSessionsReached";
	public static final String STATUS_ACCOUNT_LOCKED				="eAccountLocked";
	public static final String STATUS_UNKNOWN						="eUnknown";
	public static final String STATUS_TOKEN_EXPIRED					="eTokenExpired";
	public static final String STATUS_ACCOUNT_DEACTIVATED			="eAccountDeactivated";
	public static final String STATUS_NO_COUNSELLING_SHEET_FOR_DIN	="eNoCounsellingSheetForDin";
	public static final String STATUS_INVALID_OPERATION				="eInvalidOperation";
	public static final String STATUS_CANNOT_UNASSIGN				="eCannotUnassign";
	public static final String STATUS_EMUST_CONSENT					="eMustConsent";
	public static final String STATUS_EMUST_GIVE_PASSWORD_REMINDER  ="eMustGivePasswordReminder";
	public static final String STATUS_EMUST_CHANGE_PASSWORD         ="eMustChangePassword";
	public static final String STATUS_UNSUBSRCIBE                   ="eUnsubscribingState";
	public static final String STATUS_SERVICE_ERROR					="eProcessingError";
	public static final String STATUS_MINOR_USER					="eMinorUser";
	public static final String STATUS_TEMP_PASSWORD_EXPIRED         ="eTemporaryPasswordExpired";
	public static final String STATUS_RESTRICT_CAREGIVER        	="eCaregiverNotAllowed";
	
	
	
	public static final String REQ_PARAM_MONTH						= "month";
	public static final String REQ_PARAM_DAY						= "day";
	public static final String REQ_PARAM_YEAR						= "year";
	public static final String REQ_PARAM_NEWPASSWORD				= "newpassword";
	public static final String REQ_PARAM_CONFIRMPASSWORD			= "confirmpassword";
	public static final String REQ_PARAM_USERNAME					= "username";
	public static final String REQ_PARAM_EMAILID					= "email";
	public static final String REQ_PARAM_PHONE1						= "phone1";
	public static final String REQ_PARAM_PHONE2						= "phone2";
	public static final String REQ_PARAM_PHONE3						= "phone3";
	public static final String REQ_PARAM_QUESTION1					= "question1";
	public static final String REQ_PARAM_QUESTION2					= "question2";
	public static final String REQ_PARAM_QUESTION3					= "question3";
	public static final String REQ_PARAM_ANSWER						= "answer";
	public static final String REQ_PARAM_ANSWER1					= "answer1";
	public static final String REQ_PARAM_ANSWER2					= "answer2";
	public static final String REQ_PARAM_ANSWER3					= "answer3";
	public static final String REQ_PARAM_CLOSE_AC_FLAG				= "noreasons";
	public static final String REQ_PARAM_CONSENTID 					= "consentId";
	public static final String REQ_PARAM_BTN_REVOKE_CLOSE			= "revokeconsentspopup_button";
	public static final String REQ_PARAM_BTN_CLOSE_ACC				= "closeaccountpopup_button";
	public static final String REQ_PARAM_CONF_EMAIL					= "status";
	public static final String REQ_PARAM_CONSENT 					= "consent";
	public static final String REQ_PARAM_REASON_KEY					= "reasonkey";
	public static final String REQ_PARAM_TAX_DATES					= "tax-dates";
	public static final String REQ_PARAM_FROM_DATE					= "from";
	public static final String REQ_PARAM_TO_DATE					= "to";
	public static final String REQ_PARAM_EXCLUDE_MEDICATION			= "exclude-medication";
	
	public static final String CACHE_KEY_PRESCRIPTIONS 				= "prescriptionListCache";
	public static final String CACHE_KEY_PRESC_HISTORY 				= "prescriptionHistoryCache";
	
	public static final String DRUG_INFO_SPLIT_STRING				= ",splt";	
	
	public static final String QNAME_RXASSYSTLIB_CONTRACTS_DATA 	= "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data";
	public static final String PRESCRIPTION_EXTENDED_INFO_ALL 		= "All";
	
	public static final String NOCOUNSELLINGSHEET_EXCEPTION		    = "eNoCounsellingSheetForDin";
	
	
	public static final String EXTERNAL_SRVC_LOGON					= "LogOn";
	public static final String EXTERNAL_SRVC_LISTPREFERENCES		= "ListPreferences";
	public static final String EXTERNAL_SRVC_UPDATEPREFERENCES		= "UpdatePreferences";
	public static final String EXTERNAL_SRVC_GET_ACCOUNT_ALIASES	= "getAccountAliases";
	public static final String EXTERNAL_SRVC_UPDATE_ACCOUNT_ALIASES	= "updateAccountAlias";
	public static final String EXTERNAL_SRVC_CONFIRM_EMAIL			= "confirmEmail";
	public static final String EXTERNAL_SRVC_ADD_ACCOUNT_ALIASES	= "addAccountAlias";
	public static final String EXTERNAL_SRVC_VERIFY_IDENTITY		= "verifyIdentity";
	public static final String EXTERNAL_SRVC_LOGOFF					= "logoff";
	public static final String EXTERNAL_SRVC_GET_CURRENT_ACCOUNT	= "getCurrentAccount";
	public static final String EXTERNAL_SRVC_UPDATE_PWD_REMINDER	= "updatePasswordReminder";
	public static final String EXTERNAL_SRVC_GET_PWD_REMINDER		= "getPasswordReminder";
	public static final String EXTERNAL_SRVC_CHANGE_PWD				= "changePassword";
	public static final String EXTERNAL_SRVC_SEND_PWD				= "sendPassword";
	public static final String EXTERNAL_SRVC_EMAIL_VALID			= "emaiValid";	
	public static final String EXTERNAL_SRVC_GET_TAX_RECEIPT_REPORT	= "getTaxReceiptReport";
	
	public static final String EXTERNAL_SRVC_GETMEDCOUNSELLINGSHEET	= "getMedCounsellingSheet";
	public static final String EXTERNAL_SRVC_UNSUBSCRIBE			= "unsubscribe";
	public static final String EXTERNAL_SRVC_SUBSCRIBE				= "subscribe";
	public static final String EXTERNAL_SRVC_GETRXASSYST			= "getRxAssyst";
	
	public static final String BASE_URL 							= "/content/erefill/";
	public static final String CA 									= "_CA";
	public static final String RESET_PASSWORD						= "/resetpassword";
	public static final String REGISTRATION_URL						= "/registration";
	public static final String STORELOCATOR_URL						= "/storelocator";
	
	public static final String ENCODING_UTF8						= "UTF-8";
	
	public static final String TOKEN 								= "token";
	public static final String NEWPASSWORD 							= "newPassword";
	public static final String QUESTION 							= "question";
	public static final String ANSWER 								= "answer";
	public static final String INDEX 								= "index";
	public static final String USERNAME 							= "username";
	public static final String PASSWORD 							= "password";
	public static final String OID 									= "oid";
	public static final String prescriptionOID 						= "prescriptionOID";
	public static final String PAGE_SIZE 							= "pageSize";
	public static final String PAGE_START 							= "pageStart";
	public static final String LANGUAGE 							= "language";
	public static final String DIN 									= "DIN";
	public static final String DATEFORMAT 							= "EEE MMM dd HH:mm:ss z yyyy";
	public static final String PHARMACYDETAILS 						= "pharmacyDetails";
	public static final String STOREID 								= "storeId";
	public static final String ADDRESS 								= "address";
	public static final String CITY 								= "city";
	public static final String FAX 									= "fax";
	public static final String PHONE 								= "phone";
	public static final String PINCODE 								= "pincode";
	public static final String PRESCRIPTION1 						= "prescription1";
	public static final String COMMENTS 							= "comments";
	public static final String EMAIL 								= "email";
	public static final String LASTRELEASEDATE 						= "lastReleaseDate";
	public static final String RELEASEDATE 							= "releaseDate";
	public static final String PHARMACYCONTACTNUMBER 				= "pharmacyContactNumber";
	public static final String DEFAULTPHARMACY 						= "defaultPharmacy";
	public static final String STATE 								= "state";
	public static final String JERSEY_RESOURCE_TYPE 				= "application/json";
	public static final String PASSWORD_REMINDER 					= "password_reminder";
	public static final String DATE_FORMAT_IP_FIELDS 				= "yyyy-MM-dd";
	public static final String DATE_FORMAT_CUSTOM 					= "yyyyMMdd";
	public static final String DATE_FORMAT_PRESCRIPTION 			= "MMM dd yyyy";
	public static final String DATE_FORMAT_REFILL_HIST 				= "MMM dd yyyy";
	public static final String DATE_FORMAT_ORDER_HIST 				= "MMM dd yyyy";
	public static final String DATE_FORMAT_PRESCRIPTION_FR 			= "dd MMM yyyy";
	public static final String DATE_FORMAT_REFILL_HIST_FR 			= "dd MMM yyyy";
	public static final String DATE_FORMAT_ORDER_HIST_FR 			= "dd MMM yyyy";
	public static final String ALL_DAYS 							= "all";
	public static final String LAST_730_DAYS                        = "730";
	public static final String LAST_30_DAYS 						= "30";
	public static final String LAST_90_DAYS 						= "90";
	public static final String LAST_180_DAYS 						= "180";
	public static final String LAST_FILLED_DATE 					= "last-filled";
	public static final String NEXT_FILL_DATE 						= "next-filled";
	public static final String MEDICATION_NAME 						= "name";
	public static final boolean ORDER_ASCENDING 					= true;
	public static final boolean ORDER_DESCENDING 					= false;
	
	public static final String STORE 								= "store";
	public static final String BANNER 								= "banner";
	public static final String MANAGER 								= "manager";
	public static final String OPERATINGHOURS 						= "operatingHours";
	public static final String DEPARTMENTS 							= "departments";
	public static final String STORENAME 							= "storeName";
	public static final String STORENAMEFR 							= "storeNameFr";
	public static final String PHONENUMBER 							= "phoneNumber";
	public static final String FAXNUMBER 							= "faxNumber";
	public static final String COUNTRY 								= "country";
	public static final String POSTALCODE 							= "postalCode";
	public static final String PROVINCE 							= "province";
	public static final String ADDRESSLINE1 						= "addressLine1";
	public static final String PHARMACYTITLE 						= "Loblaw pharmacy at<br>Loblaws -";
	public static final String LOGOURL 								= "logoUrl";
	public static final String LOGOURLFR 							= "logoUrlFr";
	public static final String CONTACTNAME 							= "contactName";
	public static final String MANAGER_NAME							= "managerName";
	public static final String DESCRIPTION						    = "description";
	public static final String DESCRIPTIONFR 						= "descriptionFr";
	public static final String DATE 								= "date";
	public static final String HOURS 								= "hours";
	public static final String DAY 									= "day";
	public static final String DAYFR 								= "dayFr";
	public static final String HOURSFR 								= "hoursFr";
	public static final String HOLIDAY 								= "holiday";
	public static final String DEPARTMENTNAME 						= "departmentName";
	public static final String PHARMACY 							= "pharmacy";
	public static final String DEPARTMENTID 						= "departmentId";
	public static final String PHARMACYNAME 						= "pharmacy";
	public static final String DEPARTMENT 							= "department";
	public static final String COLLEGESTREET 						= "collegeStreet";
	public static final String COLLEGECITY 							= "collegeCity";
	public static final String COLLEGEPROVINCE 						= "collegeProvince";
	public static final String COLLEGEPOSTALCODE 					= "collegePostalCode";
	public static final String COLLEGEFAX 							= "collegeFaxNumber";
	public static final String COLLEGEPHONE 						= "collegePhoneNumber";
	public static final String COLLEGELOGO	 						= "collegeLogo";
	public static final String COLLEGELICENSE	 					= "collegeLicense";
	public static final String QUBEC_PROVINCE 						= "QC";
	public static final String ACCREDITION_NO 						= "accreditationNumber";
	public static final String PHARMACY_NAME 						= "name";
	public static final String LEGALNAME 							= "legalName";
	public static final String BUSINESSOWNER 						= "businessOwner";
	public static final String FRENCHNAME 							= "frenchName";
	public static final String LEGALFRENCHNAME 						= "legalFrenchName";
	
	public static final String CACHE_KEY_SEC_QNS                    = "qnsCacheKey";
	
	public static final String SELECTEDMEDICINES 					= "selectedmedication";

	public static final String CACHE_KEY_CHECKED_PRESCS 			= "checkedPrescListCache";
	public static final String CACHE_KEY_REGISTRATION 				= "registrationCache";
	public static final String CACHE_KEY_PATIENTDATA 				= "patientDataCache";
	public static final String CACHE_KEY_PHARMA 					= "pharmaDetailsCache";
	public static final String CACHE_KEY_DEPTT 						= "depttDetailsCache";
	public static final String CACHE_KEY_DRUG_INFO 					= "drugInfoCacheKey";
	public static final String CACHE_KEY_ORD_HIST 					= "orderHistCacheKey";
	
	public static final String RX_NUMBER_PLACEHOLDER 				= "{RX_NUMBER_PLACEHOLDER}";
	public static final String MY_PRESCRIPTION_VIEW_KEY 			= "MY_PRESC_VIEW";
	public static final String REFILL_REQUEST_VIEW_KEY 				= "REFILL_REQ_VIEW";
	public static final String SPLIT_CHAR 							= "&&&";
	public static final String COMMA_CHAR 							= ",";
	public static final String COLLEGEURL 							= "collegeUrl";
	
	public static final String CHKD_PRESC_QUERY_STR 				= "chkdPresc";
	public static final String DATE_FILTER_QUERY_STR 				= "dateFilter";
	public static final String SORT_FILTER_QUERY_STR 				= "sortFilter";
	public static final String FROM_DT_QUERY_STR 					= "fromDate";
	public static final String TO_DT_QUERY_STR 						= "toDate";
	public static final String PAGE_NUM_QUERY_STR 					= "pageNomber";
	public static final String REFILL_REQ_QUERY_STR 				= "refillQStr";
	
	public static final String EMAIL_PLACEHOLDER 					= "{EMAIL_PLACEHOLDER}";
	
	public static final String DESIGN_JCR_CONTENT_PATH 				= "/etc/designs/erefill/jcr:content";
	public static final String GLOBAL_TEXT_PATH 					= "/globalText";
	
	public static final String QUESTION1 							= "question1";
	public static final String QUESTION2 							= "question2";
	public static final String QUESTION3 							= "question3";
	
	public static final String ANSWER1 								= "answer1";
	public static final String ANSWER2 								= "answer2";
	public static final String ANSWER3 								= "answer3";
	
	public static final String STR_NULL 							= "null";
	
	public static final String SECURITY_QUESTIONS_ENGLISH_ARRAY 	 = "SECURITY_QUESTIONS_ENGLISH_ARRAY";
	public static final String SECURITY_QUESTIONS_FRENCH_ARRAY 		= "SECURITY_QUESTIONS_FRENCH_ARRAY";
	public static final String PAGE_LANGUAGE_FRENCH 		        = "fr_CA";
	public static final String PAGE_LANGUAGE_ENGLISH 		        = "en_CA";
	
	public static final String ACCOUNT_PREFERENCE_ENCODE 			= "account-pref";
	public static final String REQUEST_USER_TOKEN		 			= "REQUEST_USER_TOKEN";
	public static final String STR_FRENCH_LOCALE		 			= "fr_CA";
	public static final String EREFILL_DEFAULT_LOCALE		 		= "en_CA";
	
	public static final String LOGIN_USER							= "login_user";
	public static final String LOGIN_REMEMBER						= "remember_me";
	public static final String LOGIN_MODEL							= "model";
	public static final String LOGIN_NEXT_PAGE						= "next_page";
	public static final String LOGIN_RESPONSE						= "login_service_response";
	
	public static final String REQUEST_PHARMACY						= "pharmaStores";
	public static final String MAP_KEY_AUTOMATED_REFILL_RESPONSE	= "automatedRefillResponse";
	public static final String MAP_KEY_REFILL_REMINDER_RESPONSE		= "refillReminderResponse";
	
	public static final String MAP_KEY_ACCOUNT 						= "account";
	public static final String MAP_KEY_USERNAME 					= "userName";
	public static final String MAP_KEY_FIRSTNAME 					= "firstName";
	public static final String MAP_KEY_USER_FULLNAME 				= "userFullName";
	public static final String MAP_KEY_LOCALE	 					= "locale";
	public static final String MAP_KEY_ACCOUNT_PREFERENCE			= "accountPreferenceVO";
	public static final String MAP_KEY_MAIL_ID						= "mailId";
	public static final String MAP_KEY_MAIL_STATUS					= "mailStatus";
	public static final String MAP_KEY_SECURITY_QUESTIONS			= "securityQuestions";
	public static final String MAP_KEY_QUESTIONS_MAP				= "questionsMap";
	public static final String MAP_KEY_TERMS_OF_USE_TEXT			= "termsofUseText";
	public static final String MAP_KEY_USER							= "MAP_KEY_USER";
	public static final String MAP_KEY_HTTP_SESSION					= "httpSession";
	public static final String MAP_KEY_EREFILL_SESSION				= "eRefillSession";
	public static final String MAP_KEY_PHONE_NUM1					= "phoneNum1";
	public static final String MAP_KEY_PHONE_NUM2					= "phoneNum2";
	public static final String MAP_KEY_PHONE_NUM3					= "phoneNum3";
	public static final String MAP_KEY_PHONE_STATUS					= "phnStatus";
	public static final String MAP_KEY_PAGE_NAME					= "pageName";
	
	public static final String GUEST_USER_NAME						= "guestUserName";
	public static final String CONSENT_OID							= "consentOid";
	public static final String MANAGER_USERNAME						= "managerUserName";
	public static final String MANAGED_USERNAME						= "manageDUserName";
	public static final String SEND_NOTIFICATION					= "sendNotification";
	public static final String PATIENT_LIST 						= "patientList";
	public static final String REQUESTOR_USERNAME 					= "requestorUserName";
	public static final String CONSENT_TYPE							= "consentType";
	
	public static final String REFILL_REQUEST_CHKDPRESC 			= "lstChkdPresc";
	public static final String REQUEST_LOCALE 						= "strlocale";
	public static final String REFILL_REQUEST_PRESC 				= "prescDetails";
	public static final String REFILL_REQUEST_PHARMACY 				= "pharmaDetails";
	public static final String REFILL_REQUEST_PATIENT 				= "entityPatient";
	public static final String REFILL_REQUEST_ACCOUNTMAP 			= "accountMap";
	
	public static final Object FREEDELIVERYPHARMACYNAME 			= "pharmacy free delivery";
	public static final String REFILL_REQUEST_PATIENTOID            = "patientOID";
	public static final String REFILL_REQUEST_RX 					= "rxNewRequest";
	public static final String REFILL_REQUEST_JSON 					= "refilljsonResponse";
	public static final String DEL_OPERATING_HOURS 					= "delOperatingHours";
	public static final String DELDEPARTMENTID 						= "freeDelDeptId";
	public static final String EREFILL_SESSION 						= "eRefillSession";
	
	public static final String PAGE_HEADER_TITLE 					= "title";
	public static final String MY_PRESCRIPTION_PAGE_TITLE 			= "my.prescriptions.page.header.title";
	public static final String MY_MEDICATION_RECORD_PAGE_TITLE 		= "my.medication.record.page.header.title";
	public static final String MY_ORDER_HISTORY_PAGE_TITLE 			= "my.order.history.page.header.title";
	public static final String MY_ACCOUNT_PAGE_TITLE				= "my.account.page.header.title";
	public static final String MY_MANAGED_ACCOUNT_PAGE_TITLE		= "my.managed.account.page.header.title";
	public static final String HELP_PAGE_TITLE						= "help.page.header.title";
	public static final String TERMS_AND_CONDITIONS_PAGE_TITLE		= "terms.and.conditions.page.header.title";
	public static final String CONTACT_US_PAGE_TITLE				= "contact.us.page.header.title";
	public static final String HOME_PAGE_TITLE						= "home.page.header.title";
	public static final String PRIVACY_PAGE_TITLE					= "privacy.policy.header.title";
	public static final String CONSENT_PAGE_TITLE					= "consent.page.title";
	
	public static final String DRUG_INFO_DIN 						= "drugInfoDin";
	public static final String DRUG_INFO 							= "drugInfo";
	public static final String DRUG_INFO_HEADER 					= "drugHeader";
	public static final String DRUG_INFO_HEADER_NAME 				= "drugHeadName";
	public static final String DRUG_INFO_HEADER_STRENGTH 			= "drugHeadStrength";
	
	public static final String START_DATE		 					= "StartDate";
	public static final String END_DATE					 			= "EndDate";
	public static final String DISPLAY_DRUG_NAME			 		= "DisplayDrugName";
	public static final String PATIENT_OID				 			= "PatientOID";
	
	public static final String REFILL_HISTORY_LIST					= "refillList";
	public static final String REFILL_HISTORY_DRUG_HEADER 			= "refillDrugHeader";
	public static final String REFILL_HISTORY_DRUG_INFO 			= "refillDrugInfo";	
	public static final String ASSIGNED_PATIENTS 					= "assignedPatients";
	public static final String SELECTED_PATIENT_OID 				= "selectedPatientOID";
	
	public static final String REFILL_REQUEST_TYPE 					= "refillType";
	public static final String AUTO_REFILL_REQUEST 					= "auto";
	public static final String REFILL_REMINDER_REQUEST				= "reminder";
	public static final String NORMAL_REFILL_REQUEST				= "normalRefillRequest";
	
	public static final String AUTO_REFILL_OID 						= "autoRefillOid";
	public static final String AUTO_REFILL_UPDATE_OPT_IN 			= "optIN";
	public static final String AUTO_REFILL_UPDATE_OPT_OUT			= "optOUT";
	public static final String DELIVERY 							= "Delivery";
	public static final String PICK_UP								= "Pickup";
	public static final Object REFILL_REQUEST 						= "refill";
	public static final String TOKEN_STATUS 						= "token_status";
	public static final String TOKEN_VALUE 							= "token_value";
	public static final String REFILL_REQUEST_STATUS 				= "update_status";
	public static final String REFILL_REQUEST_EMAIL 				= "email";
	public static final String REFILL_REQUEST_PHONE 				= "phone";
	public static final String REFILL_REQUEST_DELIVERY_CHOICE       = "deliveryChoice";
	public static final String REFILL_REQUEST_OID 					= "oid";
	public static final String REFILL_REQUEST_DATE 					= "date";
	public static final String UPDATE_TYPE 							= "update_type";
	public static final String MOBILE_PHONE 						= "mobile_phone";
	public static final String CONSENT_AGREEMENT 					= "consentAgreement";
	public static final String ERROR 								= "error";
	public static final String RELATIONSHIP 						= "relationship";
	public static final String IS_LOGGED_IN_USER 					= "isLoggedInUser";
	
	public static final String PAGE_NAME_MY_PRESCRIPTIONS			= "myprescriptions";
	public static final String PAGE_NAME_MY_ORDER_HISTORY       	= "myorderhistory";
	public static final String PAGE_NAME_MY_MEDICATION_RECORD 		= "mymedicationrecord";
	public static final String PAGE_NAME_MY_ACCOUNT 				= "myaccount";
	public static final String PAGE_NAME_MY_MANAGED_ACCOUNT			= "mymanagedaccount";
	public static final String PAGE_NAME_HELP 						= "help";
	public static final String PAGE_NAME_CONTACT_US 				= "contactus";
	public static final String PAGE_NAME_PRIVACY 				    = "privacy";
	public static final String PAGE_NAME_TC				    		= "terms-and-conditions";
	public static final String PAGE_NAME_CONSENT			    	= "consent";
	public static final String PAGE_NAME_RESETPWD			    	= "resetpassword";
	public static final String MINOR_AGE_LIMIT 						= "minorAgeLimit";
	public static final String PENDING_CUSTODIANREQUESTS 			= "pendingCustodianRequests";
	public static final String PATIENT_DATA 						= "patient_data";
	public static final String ERROR_CODE 							= "errorType";
	public static final String CARE_GIVER_PAGE_NAME_MY_ACCOUNT 		= "caregiverAccount";
	public static final String CARE_GIVER_PAGE_NAME_MY_PRESCRIPTIONS= "caregiverMyPrescription";
	public static final String CARE_GIVER_PAGE_NAME_MEDICATION		= "caregiverMedicationRecord";
	public static final String CARE_GIVER_PAGE_NAME_ORDER_HISTORY	= "caregiverOrderHistory";
	public static final String CARE_GIVER_PAGE_NAME_HELP			= "caregiverHelp";
	public static final String CARE_GIVER_PAGE_NAME_CONTACT_US		= "caregiverContactUs";
	
	public static final String USER_ROLE							= "userRole";
	public static final String CARE_GIVER							= "Caregivers";
	public static final String IS_REGISTRATION_FLOW 				= "isRegistrationFlow";
	public static final String CONSENT_TYPE_ENROLLMENT 				= "Enrollment";
	
	public static final String HEADER_VIEW_TYPE 					= "View-Type";
	public static final String VIEW_TYPE_MOBILE 					= "mobile";
	public static final String HTTP_REQUEST 						= "httpRequest";
	public static final String SIGNINERROR 							= "signinerror";
	public static final String SECURITYERROR 						= "securityerror";
	public static final String PAGE_SIGNIN 							= "signin";
	
	public static final int SESSION_TIME_OUT                        = 900;
	
	
}