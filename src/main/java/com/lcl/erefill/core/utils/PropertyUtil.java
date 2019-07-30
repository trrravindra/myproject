package com.lcl.erefill.core.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtil {
	
	
	/**
	 * Environment specific properties
	 */
	
	
	private static String erefillEnv;
	
	/**
	 * ATG related properties
	 */
	private static String atgStoreBaseUrl;
	private static String atgStoreLocatorUri;
	private static String atgStoreLocatorUserName;
	private static String atgStoreLocatorPassword;
	private static String atgStoreLocatorDepartmentUri;
	private static boolean isAtgPharmacyStoreCacheable;
	private static boolean isAtgPharmacyStoreLocationCacheable;
	private static boolean isAtgPharmacyDepartmentsCacheable;
	
	
	
	/**
	 * Global proxy configurations
	 */
	private static String proxyHost;
	private static String proxyPort;
	private static String proxyUserName;
	private static String proxyUserPassword;
	private static boolean isProxyEnabled; 
	
		/**
	 * Captcha keys
	 */
	
	private static String recaptchaSitekey;
	private static String recaptchaSecretKey;
	
	/**
	 * Captcha v2 keys
	 */
	
	private static String recaptchav2Sitekey;
	private static String recaptchav2PrivateKey;
	private static String recaptchav2Url;
	
	/**
	 * captcha servers
	 */
	private static String captchaHttpServer;	
	private static String captchaHttpsServer;
	private static String captchaVerificationServer;
	private static boolean captchaSecureMode;
	
	/**
	 * enable/disable recaptcha
	 */
	
	private static boolean isRecaptchaEnabled;
	
	private static String ATG_URL;
	
	// caching for store locator
	private static Long ttlDuration;

	/**
	 * session Timeout for a session if ideal for 
	 */
	private static int sessionTimeout;
	
	private static String agentUser;
	private static String agentPassword;
	public String getAgentUser() {
		return agentUser;
	}

	@Value("${agent.user}")
	public void setAgentUser(String agentUser) {
		PropertyUtil.agentUser = agentUser;
	}

	
	
	public String getAgentPassword() {
		return agentPassword;
	}

	@Value("${agent.password}") 
	public void setAgentPassword(String agentPassword) {
		PropertyUtil.agentPassword = agentPassword;
	}

	public Long getTtlDuration() {
		return ttlDuration;
	}

	@Value("${storelocator.cache.ttl.duration}") 
	public void setTtlDuration(Long ttlDuration) {
		PropertyUtil.ttlDuration = ttlDuration;
	}
	
	/**
	 * global notification days
	 */
	private static String GLOBAL_NOTIFICATION_DISPLAY_DAYS;
	
	/**
	 * 
	 * CSRF token not needed while login
	 */
	private static String isCSRFTokenNeededForLogin;
	
	/**
	 * Logger intercepted if contains this element and masked while logging
	 */
	private static String secureLoggerEnabled;
	private static String multiVal_SecureInfo;
	
	/**
	 * Values to help encrypt secure data while logging in log file
	 */
	private static String encryptionKey;
	private static String encryptAlgorithm;

	/**
	 * 
	 * new login flow flag
	 */
	private  Boolean isNewLoginFlow;
	
	public  Boolean getIsNewLoginFlow() {
		return isNewLoginFlow;
	}

	@Value("${new.login.user.flow}") 
	public  void setIsNewLoginFlow(Boolean isNewLoginFlow) {
		 this.isNewLoginFlow = isNewLoginFlow;
	}
	
	
	
	public String getGLOBAL_NOTIFICATION_DISPLAY_DAYS() {
		return GLOBAL_NOTIFICATION_DISPLAY_DAYS;
	}

	@Value("${global.notification.display.days}") 
	public void setGLOBAL_NOTIFICATION_DISPLAY_DAYS(
			String gLOBAL_NOTIFICATION_DISPLAY_DAYS) {
		GLOBAL_NOTIFICATION_DISPLAY_DAYS = gLOBAL_NOTIFICATION_DISPLAY_DAYS;
	}
	

	public String getATG_URL() {
		return ATG_URL;
	}

	@Value("${atg.url}") 
	public void setATG_URL(String aTG_URL) {
		ATG_URL = aTG_URL;		
	}


	public static String getAtgStoreBaseUrl() {
		return atgStoreBaseUrl;
	}

	@Value("${atg.store.locator.base.url}") 
	public void setAtgStoreBaseUrl(String atgStoreBaseUrl) {
		PropertyUtil.atgStoreBaseUrl = atgStoreBaseUrl;		
	}


	public static String getAtgStoreLocatorUri() {
		return atgStoreLocatorUri;
	}

	@Value("${atg.store.locator.service.uri}") 
	public void setAtgStoreLocatorUri(String atgStoreLocatorUri) {
		PropertyUtil.atgStoreLocatorUri = atgStoreLocatorUri;
	}


	public static String getAtgStoreLocatorUserName() {
		return atgStoreLocatorUserName;
	}

	@Value("${atg.store.locator.username}") 
	public void setAtgStoreLocatorUserName(String atgStoreLocatorUserName) {
		PropertyUtil.atgStoreLocatorUserName = atgStoreLocatorUserName;
	}


	public static String getAtgStoreLocatorPassword() {
		return atgStoreLocatorPassword;
	}

	@Value("${atg.store.locator.password}") 
	public void setAtgStoreLocatorPassword(String atgStoreLocatorPassword) {
		PropertyUtil.atgStoreLocatorPassword = atgStoreLocatorPassword;
	}


	public static String getProxyHost() {
		return proxyHost;
	}

	@Value("${erefill.proxy.host}") 
	public void setProxyHost(String proxyHost) {
		PropertyUtil.proxyHost = proxyHost;
	}


	public static String getProxyPort() {
		return proxyPort;
	}

	@Value("${erefill.proxy.port}") 
	public void setProxyPort(String proxyPort) {
		PropertyUtil.proxyPort = proxyPort;
	}


	public static String getProxyUserName() {
		return proxyUserName;
	}

	@Value("${erefill.proxy.user}")
	public void setProxyUserName(String proxyUserName) {
		PropertyUtil.proxyUserName = proxyUserName;
	}

	public static String getProxyUserPassword() {
		return proxyUserPassword;
	}

	@Value("${erefill.proxy.pass}")
	public void setProxyUserPassword(String proxyUserPassword) {
		PropertyUtil.proxyUserPassword = proxyUserPassword;
	}
	
	public static boolean getIsProxyEnabled() {
		return isProxyEnabled;
	}

	@Value("${erefill.proxy.enabled}")
	public void setIsProxyEnabled(String isProxyEnabled) {		
		PropertyUtil.isProxyEnabled = Boolean.valueOf(isProxyEnabled);		 
	}



	public static String getAtgStoreLocatorDepartmentUri() {
		return atgStoreLocatorDepartmentUri;
	}

	@Value("${atg.store.locator.service.department.uri}") 
	public void setAtgStoreLocatorDepartmentUri(
			String atgStoreLocatorDepartmentUri) {
		PropertyUtil.atgStoreLocatorDepartmentUri = atgStoreLocatorDepartmentUri;
	}
	
	
	

	public static boolean getIsAtgPharmacyStoreCacheable() {
		return isAtgPharmacyStoreCacheable;
	}

	@Value("${atg.pharmacy.store.cache}")
	public void setIsAtgPharmacyStoreCacheable(
			String isAtgPharmacyStoreCacheable) {
		PropertyUtil.isAtgPharmacyStoreCacheable = Boolean.valueOf(isAtgPharmacyStoreCacheable);
	}

	public static boolean getIsAtgPharmacyDepartmentsCacheable() {
		return isAtgPharmacyDepartmentsCacheable;
	}

	@Value("${atg.pharmacy.store.departments.cache}")
	public void setIsAtgPharmacyDepartmentsCacheable(
			String isAtgPharmacyDepartmentsCacheable) {
		PropertyUtil.isAtgPharmacyDepartmentsCacheable = Boolean.valueOf(isAtgPharmacyDepartmentsCacheable);
	}

	
	public static boolean isAtgPharmacyStoreLocationCacheable() {
		return isAtgPharmacyStoreLocationCacheable;
	}	

	@Value("${atg.pharmacy.store.location.cache}")
	public void setAtgPharmacyStoreLocationCacheable(
			String isAtgPharmacyStoreLocationCacheable) {
		PropertyUtil.isAtgPharmacyStoreLocationCacheable = Boolean.valueOf(isAtgPharmacyStoreLocationCacheable);
	}





	/**
	 * Telus related configurations
	 */
	
	public static String TELUS_PHARMASPACE_ENDPOINT;
	public static String TELUS_PHARMASPACE_CONNECTION_TIMEOUT;
	public static String TELUS_PHARMASPACE_RECIEVE_TIMEOUT;
	
	@Value("${telus.pharmaspace.endpoint}")
	public void setTELUS_PHARMASPACE_ENDPOINT(
			String tELUS_PHARMASPACE_ENDPOINT) {
		TELUS_PHARMASPACE_ENDPOINT = tELUS_PHARMASPACE_ENDPOINT;		
	}
	
	
	public String getTELUS_PHARMASPACE_ENDPOINT() {
		return TELUS_PHARMASPACE_ENDPOINT;
	}
	
	
	
	public static String getTELUS_PHARMASPACE_CONNECTION_TIMEOUT() {
		return TELUS_PHARMASPACE_CONNECTION_TIMEOUT;
	}
	@Value("${telus.pharmaspace.connection.timeout}")
	public void setTELUS_PHARMASPACE_CONNECTION_TIMEOUT(
			String tELUS_PHARMASPACE_CONNECTION_TIMEOUT) {
		TELUS_PHARMASPACE_CONNECTION_TIMEOUT = tELUS_PHARMASPACE_CONNECTION_TIMEOUT;
	}

	public static String getTELUS_PHARMASPACE_RECIEVE_TIMEOUT() {
		return TELUS_PHARMASPACE_RECIEVE_TIMEOUT;
	}
	@Value("${telus.pharmaspace.recieve.timeout}")
	public void setTELUS_PHARMASPACE_RECIEVE_TIMEOUT(
			String tELUS_PHARMASPACE_RECIEVE_TIMEOUT) {
		TELUS_PHARMASPACE_RECIEVE_TIMEOUT = tELUS_PHARMASPACE_RECIEVE_TIMEOUT;
	}

	public static String TELUS_BASE;
	@Value("${telus.base}")
	public void setTELUS_BASE(String tELUS_BASE) {
		TELUS_BASE = tELUS_BASE;		
	}

	
	
	public static String getErefillEnv() {
		return erefillEnv;
	}

	@Value("${erefill.env}")
	public void setErefillEnv(String erefillEnv) {
		PropertyUtil.erefillEnv = erefillEnv;
	}

	public static String getRecaptchaSitekey() {
		return recaptchaSitekey;
	}

	@Value("${erefill.recaptcha.site.key}")
	public void setRecaptchaSitekey(String recaptchaSitekey) {
		PropertyUtil.recaptchaSitekey = recaptchaSitekey;
	}

	public static String getRecaptchaSecretKey() {
		return recaptchaSecretKey;
	}

	@Value("${erefill.recaptcha.secret.key}")
	public void setRecaptchaSecretKey(String recaptchaSecretKey) {
		PropertyUtil.recaptchaSecretKey = recaptchaSecretKey;
	}

	public static String getCaptchaHttpServer() {
		return captchaHttpServer;
	}

	@Value("${erefill.recaptcha.google.http.server}")
	public void setCaptchaHttpServer(String captchaHttpServer) {
		PropertyUtil.captchaHttpServer = captchaHttpServer;
	}

	public static String getCaptchaHttpsServer() {
		return captchaHttpsServer;
	}

	@Value("${erefill.recaptcha.google.https.server}")
	public void setCaptchaHttpsServer(String captchaHttpsServer) {
		PropertyUtil.captchaHttpsServer = captchaHttpsServer;
	}

	public static String getCaptchaVerificationServer() {
		return captchaVerificationServer;
	}

	@Value("${erefill.recaptcha.google.verification.server}")
	public void setCaptchaVerificationServer(String captchaVerificationServer) {
		PropertyUtil.captchaVerificationServer = captchaVerificationServer;
	}

	public static boolean getIsRecaptchaEnabled() {
		return isRecaptchaEnabled;
	}

	@Value("${erefill.recaptcha.enabled}")
	public void setIsRecaptchaEnabled(String isRecaptchaEnabled) {
		PropertyUtil.isRecaptchaEnabled = Boolean.valueOf(isRecaptchaEnabled);
	}

	
	public static boolean getCaptchaSecureMode() {
		return captchaSecureMode;
	}

	@Value("${erefill.recaptcha.secure.mode}")
	public void setCaptchaSecureMode(String captchaSecureMode) {
		PropertyUtil.captchaSecureMode = Boolean.valueOf(captchaSecureMode);
	}

	public static int getSessionTimeout() {
		return sessionTimeout;
	}

	@Value("${erefill.session.timeout}")
	public void setSessionTimeout(String sessionTimeout) {
		PropertyUtil.sessionTimeout = Integer.parseInt(sessionTimeout);
	}

	public static String getIsCSRFTokenNeededForLogin() {
		return isCSRFTokenNeededForLogin;
	} 

	@Value("${login.csrf.token.needed}")
	public void setIsCSRFTokenNeededForLogin(String isCSRFTokenNeededForLogin) {
		PropertyUtil.isCSRFTokenNeededForLogin = isCSRFTokenNeededForLogin;
	}

	public static String getMultiVal_SecureInfo() {
		return multiVal_SecureInfo;
	}

	@Value("${erefill.log.masking.values}")
	public void setMultiVal_SecureInfo(String multiVal_SecureInfo) {
		PropertyUtil.multiVal_SecureInfo = multiVal_SecureInfo;
	}

	public static String getEncryptionKey() {
		return encryptionKey;
	}

	@Value("${erefill.encrypt.key.value}")
	public void setEncryptionKey(String encryptionKey) {
		PropertyUtil.encryptionKey = encryptionKey;
	}

	public static String getEncryptAlgorithm() {
		return encryptAlgorithm;
	}

	@Value("${erefill.encrypt.algorithm}")
	public void setEncryptAlgorithm(String encryptAlgorithm) {
		PropertyUtil.encryptAlgorithm = encryptAlgorithm;
	}

	public static String getSecureLoggerEnabled() {
		return secureLoggerEnabled;
	}

	@Value("${erefill.log.masking.enabled}")
	public void setSecureLoggerEnabled(String secureLoggerEnabled) {
		PropertyUtil.secureLoggerEnabled = secureLoggerEnabled;
	}

	public static String getRecaptchav2Sitekey() {
		return recaptchav2Sitekey;
	}

	@Value("${erefill.recaptchav2.site.key}")
	public void setRecaptchav2Sitekey(String recaptchav2Sitekey) {
		PropertyUtil.recaptchav2Sitekey = recaptchav2Sitekey;
	}

	public static String getRecaptchav2PrivateKey() {
		return recaptchav2PrivateKey;
	}

	@Value("${erefill.recaptchav2.private.key}")
	public void setRecaptchav2PrivateKey(String recaptchav2PrivateKey) {
		PropertyUtil.recaptchav2PrivateKey = recaptchav2PrivateKey;
	}

	public static String getRecaptchav2Url() {
		return recaptchav2Url;
	}

	@Value("${erefill.recaptchav2.site.url}")
	public void setRecaptchav2Url(String recaptchav2Url) {
		PropertyUtil.recaptchav2Url = recaptchav2Url;
	}
	
	
	

}
