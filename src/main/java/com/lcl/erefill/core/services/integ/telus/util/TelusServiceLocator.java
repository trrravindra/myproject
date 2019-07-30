package com.lcl.erefill.core.services.integ.telus.util;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.cache.CacheLoader;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.AdvisorSheets;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.IAdvisorSheetsSvc;
import com.lcl.erefill.generated.telus.consent.IConsentSvc;
import com.lcl.erefill.generated.telus.manager.IManagerSvc;
import com.lcl.erefill.generated.telus.operation.IOperationSvc;
import com.lcl.erefill.generated.telus.operation.OperationService;
import com.lcl.erefill.generated.telus.profile.IProfileSvc;
import com.lcl.erefill.generated.telus.profile.ProfileService;
import com.lcl.erefill.generated.telus.report.IReportSvc;
import com.lcl.erefill.generated.telus.request.prescription.IRequestRxSvc;
import com.lcl.erefill.generated.telus.request.prescription.PrescriptionService;
import com.lcl.erefill.generated.telus.session.ISessionSvc;
import com.lcl.erefill.generated.telus.session.RxAssyst;

public class TelusServiceLocator {

	private static final Logger log = LoggerFactory
			.getLogger(TelusServiceLocator.class);

	private static final String HTTP_PROXY_HOST = "http.proxyHost";
	private static final String HTTP_PROXY_PORT = "http.proxyPort";
	private static final String APACHE_CXF_EXCEPTIONS = "org.apache.cxf.http.no_io_exceptions";

	private static final String SESSION_SVC_WSDL = "META-INF/wsdl/session/SessionSvc.wsdl";
	private static final String CONSENT_SVC_WSDL = "META-INF/wsdl/consent/ConsentSvc.wsdl";
	private static final String PROFILE_SVC_WSDL = "META-INF/wsdl/profile/ProfileSvc.wsdl";
	private static final String MANAGER_SVC_WSDL = "META-INF/wsdl/manager/ManagerSvc.wsdl";
	private static final String REPORT_SVC_WSDL = "META-INF/wsdl/report/ReportSvc.wsdl";	
	private static final String ADVISORSHEET_SVC_WSDL = "META-INF/wsdl/advisorSheet/AdvisorSheetSvc.wsdl";
	private static final String REQUESTPRESCRIPTION_SVC_WSDL = "META-INF/wsdl/requestPrescription/RequestPrescriptonSvc.wsdl";
	private static final String OPERATION_SVC_WSDL = "META-INF/wsdl/operation/OperationSvc.wsdl";

	private static Map<String, Object> cxfClients;

	private static volatile TelusServiceLocator instance;

	private TelusServiceLocator() {
		// Do Nothing
	}

	public static int SESSION = 1;
	public static int ADVISOR_ADVISROSHEETS = 2;
	public static int CONSENT = 3;
	public static int PROFILE = 4;
	public static int REQUEST_PRESCRIPTION = 5;
	public static int MANAGER = 6;
	public static int REPORT = 7;
	public static int OPERATION = 8;
	
	/**
	 * Singleton intance
	 * 
	 * @return
	 */
	public static TelusServiceLocator getInstance() {
		if (null == instance) {
			synchronized (CacheLoader.class) {
				if (null == instance) {
					instance = new TelusServiceLocator();
					cxfClients = new HashMap<String, Object>();
					log.debug("TelusServiceLocator instance created");
				} else {
					log.debug("Using the existing TelusServiceLocator instance");
				}
			}
		}
		/**
		 * WONT HANDLE PROXY FOR TELUS services
		 */
		/*String proxyServer = ERefillConfigService.TELUS_PROXY_SERVER;
		String proxyServerPort = ERefillConfigService.TELUS_PROXY_SERVER_PORT;

		if (!CommonUtils.isNullOrBlank(proxyServer)
				&& !CommonUtils.isNullOrBlank(proxyServerPort)) {
			log.debug("Setting proxy for endpoint");
			System.setProperty(HTTP_PROXY_HOST, proxyServer);
			System.setProperty(HTTP_PROXY_PORT, proxyServerPort);
		}*/
		return instance;
	}

	/**
	 * 
	 * @param clz
	 * @param wsdlDocumentLocation
	 * @param serviceQ
	 * @param endPoint
	 * @return
	 * @throws MalformedURLException
	 */
	private <T> T getService(Class<T> clz, String wsdlDocumentLocation) {
		ClassLoader oldClassLoader = Thread.currentThread()
				.getContextClassLoader();
		try {
			log.debug("Creating CXF endpoint client of {} from {}", clz,
					wsdlDocumentLocation);
			Thread.currentThread().setContextClassLoader(
					BusFactory.class.getClassLoader());

			Object serviceProxy = null;
			if (clz == ISessionSvc.class) {
				RxAssyst service = new RxAssyst(TelusServiceLocator.class
						.getClassLoader().getResource(SESSION_SVC_WSDL));
				serviceProxy = service.getRxAssystSessionEndPoint();
			} else if (clz == IAdvisorSheetsSvc.class) {
				AdvisorSheets service = new AdvisorSheets(
						TelusServiceLocator.class.getClassLoader().getResource(
								ADVISORSHEET_SVC_WSDL));
				serviceProxy = service.getBasicHttpBindingIAdvisorSheetsSvc();
			} else if (clz == IConsentSvc.class) {
				com.lcl.erefill.generated.telus.consent.RxAssyst service = new com.lcl.erefill.generated.telus.consent.RxAssyst(
						TelusServiceLocator.class.getClassLoader().getResource(
								CONSENT_SVC_WSDL));
				serviceProxy = service.getRxAssystConsentEndPoint();
			} else if (clz == IProfileSvc.class) {
				ProfileService service = new ProfileService(
						TelusServiceLocator.class.getClassLoader().getResource(
								PROFILE_SVC_WSDL));
				serviceProxy = service.getRxAssystProfileEndPoint();
			} else if (clz == IRequestRxSvc.class) {
				PrescriptionService service = new PrescriptionService(
						TelusServiceLocator.class.getClassLoader().getResource(
								REQUESTPRESCRIPTION_SVC_WSDL));
				serviceProxy = service.getRxAssystRxRequestEndPoint();
			}else if (clz == IManagerSvc.class) {
				com.lcl.erefill.generated.telus.manager.RxAssyst service = new  com.lcl.erefill.generated.telus.manager.RxAssyst(
						TelusServiceLocator.class.getClassLoader().getResource(
								MANAGER_SVC_WSDL));
				serviceProxy = service.getRxAssystManagerEndPoint();
			}else if (clz == IReportSvc.class) {
				com.lcl.erefill.generated.telus.report.RxAssyst service = new  com.lcl.erefill.generated.telus.report.RxAssyst(
						TelusServiceLocator.class.getClassLoader().getResource(
								REPORT_SVC_WSDL));
				serviceProxy = service.getRxAssystReportEndPoint();
			}else if (clz == IOperationSvc.class) {
				OperationService service = new  OperationService(
						TelusServiceLocator.class.getClassLoader().getResource(
								OPERATION_SVC_WSDL));				
				serviceProxy = service.getRxAssystOperationEndPoint();
			}
			
			((BindingProvider) serviceProxy).getRequestContext().put("set-jaxb-validation-event-handler",Boolean.FALSE);
			((BindingProvider) serviceProxy).getRequestContext().put(
					BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					wsdlDocumentLocation);
			((BindingProvider) serviceProxy).getRequestContext().put(
					APACHE_CXF_EXCEPTIONS, "true");
			((BindingProvider) serviceProxy).getRequestContext().put(
					Message.CONNECTION_TIMEOUT, PropertyUtil.TELUS_PHARMASPACE_CONNECTION_TIMEOUT);
			((BindingProvider) serviceProxy).getRequestContext().put(
					Message.RECEIVE_TIMEOUT, PropertyUtil.TELUS_PHARMASPACE_RECIEVE_TIMEOUT);
			Client client = ClientProxy.getClient(serviceProxy);
			
			client.getInInterceptors().add(new LoggingInInterceptor());
			String enableSecureLogger = PropertyUtil.getSecureLoggerEnabled();
			if(enableSecureLogger!=null && Boolean.parseBoolean(enableSecureLogger)){
				log.info("Secure Logger Enabled: " + enableSecureLogger);
				client.getOutInterceptors().add(new SecureLoggerOutInterceptor());
			}else{
				log.info("Secure Logger Disabled: " + enableSecureLogger);
				client.getOutInterceptors().add(new LoggingOutInterceptor());
			}			
			client.getInInterceptors().add(new TelusFaultInterceptor());
			return (T) serviceProxy;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ERefillApplicationException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			throw new ERefillApplicationException(e);
		} finally {
			Thread.currentThread().setContextClassLoader(oldClassLoader);
		}
	}

	/**
	 * 
	 * @param service
	 * @return
	 */
	private String getServiceEndPointLocation(final int service) {
		StringBuffer serviceEndPointLocation = new StringBuffer();
		switch (service) {
		case 1:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_SESSION_API_URL);
			break;
		case 2:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_ADVISOR_API_URL);
			break;
		case 3:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_CONSENT_API_URL);
			break;
		case 4:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_PROFILE_API_URL);
			break;
		case 5:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_REQUEST_API_URL);
			break;
		case 6:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_MANAGER_API_URL);
			break;
		case 7:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_REPORT_API_URL);
			break;	
		case 8:
			serviceEndPointLocation
					.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT);
			serviceEndPointLocation
					.append(ERefillConfigService.TELUS_OPERATION_API_URL);
			break;	
		default:
			break;
		}
		return serviceEndPointLocation.toString();
	}

	/**
	 * 
	 * @param service
	 * @return
	 * @throws MalformedURLException
	 */
	public <T> T getService(final int service) {
		Class clz = null;

		switch (service) {
		case 1:
			clz = ISessionSvc.class;
			break;
		case 2:
			clz = IAdvisorSheetsSvc.class;
			break;
		case 3:
			clz = IConsentSvc.class;
			break;
		case 4:
			clz = IProfileSvc.class;
			break;
		case 5:
			clz = IRequestRxSvc.class;
			break;
		case 6:
			clz = IManagerSvc.class;
			break;
		case 7:
			clz = IReportSvc.class;
			break;	
		case 8:
			clz = IOperationSvc.class;
			break;		
		default:
			break;
		}
		StringBuilder key = new StringBuilder().append(clz.getName())
				.append("-")
				.append(PropertyUtil.TELUS_PHARMASPACE_ENDPOINT)
				.append("-").append(ERefillConfigService.TELUS_PROXY_SERVER)
				.append("-")
				.append(ERefillConfigService.TELUS_PROXY_SERVER_PORT);
		Object serviceProxy = cxfClients.get(key.toString());
		log.debug("{} from static cache - ", key, serviceProxy);
		if (null != serviceProxy)
			return (T) serviceProxy;
		switch (service) {
		case 1:
			serviceProxy = (T) getService(ISessionSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 2:
			serviceProxy = (T) getService(IAdvisorSheetsSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 3:
			serviceProxy = (T) getService(IConsentSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 4:
			serviceProxy = (T) getService(IProfileSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 5:
			serviceProxy = (T) getService(IRequestRxSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 6:
			serviceProxy = (T) getService(IManagerSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 7:
			serviceProxy = (T) getService(IReportSvc.class,
					getServiceEndPointLocation(service));
			break;
		case 8:
			serviceProxy = (T) getService(IOperationSvc.class,
					getServiceEndPointLocation(service));
			break;	
		default:
			break;
		}
		cxfClients.put(key.toString(), serviceProxy);
		return (T) serviceProxy;
	}

	public void destroy() {
		cxfClients = null;
		instance = null;
	}

}
