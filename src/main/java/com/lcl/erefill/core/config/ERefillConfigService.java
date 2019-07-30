package com.lcl.erefill.core.config;


public class ERefillConfigService {

	public static final String[] TELUS_UNCHECKED_STATUS = { "eSessionExpired",
			"eAccessDenied", "eUnknown", "eInvalidOperation",
			"eCannotUnassign", "eMaxSessionsReached",
			"eTemporaryPasswordExpired" };

	//public static final String ATG_LCLONLINE_STORELOCATOR_URL = "/rest/loyalty/v5/store/";

	//public static final String ATG_LCLONLINE_BASE_URL = "http://uat.pcplus.ca";

	public static final String ATG_AUTH_UNAME = "mobile";

	public static final String ATG_AUTH_PASSWORD = "password";

	public static final String ATG_PROXY_SERVER_PORT = "";

	public static final String ATG_PROXY_SERVER = "";

	public static final String ATG_LCLONLINE_DEPARTMENTLOCATOR_URL = "/departments/";

	/*public static final String AGENT_USERNAME = "extern";

	public static final String AGENT_PASSWORD = "PgwB75UQ";
*/
	// description = "Number of Records to appear on Refill History Page")
	public static final String REF_HIST_PG_SIZE = "5";

	public static final String PAGE_LENGTH_ORDERHISTORY = "10";

	public static final String PAGE_LENGTH_MYPRESCRIPTION = "10";

	// @Property(label = "TELUS_PROXY_SERVER", value = "", description =
	// "Proxy server for Telus environment connectivity")
	public static final String TELUS_PROXY_SERVER = "";


	// @Property(label = "TELUS_PROXY_SERVER_PORT", value = "", description =
	// "Proxy server port for Telus environment connectivity")
	public static final String TELUS_PROXY_SERVER_PORT = "";

	// @Property(label = "TELUS_PHARMASPACE_ENDPOINT", value = "", description =
	// "ATG LCL Online Base URL")
	//https://loblaw.stagingws.teluspharmaspace.com/1_1_0
	//http://dev.rxassyst.com/BlackBoxLoblaws/1_1_0

	//public static final String TELUS_PHARMASPACE_ENDPOINT = "https://loblaw.stagingws.teluspharmaspace.com/1_1_0";
	//public static final String TELUS_PHARMASPACE_ENDPOINT = "http://dev.rxassyst.com/BlackBoxLoblaws/1_1_0";

	
	// @Property(label = "TELUS_SESSION_API_URL", value = , description =
	// "TELUS_SESSION_API_URL")
	public static final String TELUS_SESSION_API_URL = "/Session/RxAssyst.svc";

	// @Property(label = "TELUS_CONSENT_API_URL", value = "", description =
	// "TELUS_CONSENT_API_URL")
	public static final String TELUS_CONSENT_API_URL = "/Consent/RxAssyst.svc";

	// @Property(label = "TELUS_PROFILE_API_URL", value = "", description =
	// "TELUS_PROFILE_API_URL")
	public static final String TELUS_PROFILE_API_URL = "/Profile/RxAssyst.svc";

	// @Property(label = "TELUS_REQUEST_API_URL", value = "", description =
	// "TELUS_REQUEST_API_URL")
	public static final String TELUS_REQUEST_API_URL = "/Request/Prescription.svc";

	// @Property(label = "TELUS_MANAGER_API_URL", value = "", description =
	// "TELUS_MANAGER_API_URL")
	public static final String TELUS_MANAGER_API_URL = "/Manager/RxAssyst.svc";

	// @Property(label = "TELUS_ADVISOR_API_URL", value = "", description =
	// "TELUS_ADVISOR_API_URL")
	public static final String TELUS_ADVISOR_API_URL = "/Advisor/AdvisorSheets.svc";

	// @Property(label = "TELUS_REPORT_API_URL", value = "", description =
	// "TELUS_REPORT_API_URL")
	public static final String TELUS_REPORT_API_URL = "/Report/RxAssyst.svc";

	public static final String TELUS_OPERATION_API_URL = "/Operation/RxAssyst.svc";
	
	public static final String REPORT_LOCATION = "d:/taxReport.pdf";
}
