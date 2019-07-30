package com.lcl.erefill.core.connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

import net.tanesha.recaptcha.http.HttpLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;

@Component
public class ErefillRecaptchaLoader implements HttpLoader{

	private String httpProxyHost;
	private String httpProxyPort;
	private String HTTP_SERVER="http://www.google.com/recaptcha/api/challenge";
	private String HTTPS_SERVER="https://www.google.com/recaptcha/api/challenge";
	private String VERIFY_SERVER="http://api-verify.recaptcha.net/verify";
	private String googleCaptchaApiServer = "http://www.google.com/recaptcha/api/challenge";
	private boolean isProxyEnabled;
	private boolean isCaptchaSecureMode;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ErefillRecaptchaLoader.class);
	
	@Autowired
	private PropertyUtil propertyUtil;
	
	
	public ErefillRecaptchaLoader() {
		
		LOGGER.debug("Initializing ErefillRecaptchaLoader...");
		init();
	}
	
	public String getGoogleCaptchaApiServer() {
		return googleCaptchaApiServer;
	}

	
/*
	public static ErefillRecaptchaLoader getInstance() {		
		return httpLoader;
	}
*/	
	private void init() {
		
		LOGGER.debug("Init Method ");
		LOGGER.debug(" ErefillRecaptchaLoader classloader "+ErefillRecaptchaLoader.class.getClassLoader());
		String httpServer = PropertyUtil.getCaptchaHttpServer();
		String httpsServer = PropertyUtil.getCaptchaHttpsServer();
		LOGGER.debug(" Http Server "+ httpServer);
		LOGGER.debug(" Https Server "+ httpsServer);
		this.isProxyEnabled = PropertyUtil.getIsProxyEnabled();
		this.httpProxyHost = PropertyUtil.getProxyHost();
		this.httpProxyPort = PropertyUtil.getProxyPort();
		this.isCaptchaSecureMode = PropertyUtil.getCaptchaSecureMode();
		LOGGER.debug(" Secure mode "+ isCaptchaSecureMode);
		if( isCaptchaSecureMode ) {
			if( !CommonUtils.isNullOrBlank(httpsServer) ) {
				this.googleCaptchaApiServer = httpsServer;	
			}
			
		} else {
			
			if( !CommonUtils.isNullOrBlank(httpServer)) {
				this.googleCaptchaApiServer = httpServer;
			}
			
		}
		LOGGER.debug(" googleCaptchaApiServer "+ googleCaptchaApiServer);
		String verificationServer = PropertyUtil.getCaptchaVerificationServer();
		if( !CommonUtils.isNullOrBlank(verificationServer) ) {
			this.VERIFY_SERVER = verificationServer;
		}
		
	}
	
	
	public String httpPost(String url, String postdata) {
		
		URLConnection connection = getConnection( url );
		InputStream in = null;
		OutputStream out;
		ByteArrayOutputStream bout = null;
		try {
			out = connection.getOutputStream();
			out.write(postdata.getBytes());
			out.flush();
			in = connection.getInputStream();
			bout = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			while (true) {
				int rc = in.read(buf);
				if (rc <= 0)
					break;
				else
					bout.write(buf, 0, rc);
			}

			out.close();
			in.close();
			return bout.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
				// swallow.
			}
		}
		
		return null;
	}


	/**
	 * 
	 * @param url
	 * @return
	 */
	private URLConnection getConnection(String url) {

		URLConnection connection = null;
		try {
			URL connectionUrl = new URL(url);
			if( isProxyEnabled ) {				
				SocketAddress sa = new InetSocketAddress( httpProxyHost, Integer.parseInt(httpProxyPort) );
				Proxy proxy = new Proxy(Proxy.Type.HTTP, sa );
				connection = connectionUrl.openConnection(proxy);				
			} else {
				connection = connectionUrl.openConnection();
			}
			connection.setDoOutput(true);
			connection.setDoInput(true);
			setJdk15Timeouts(connection);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	/**
	 * 
	 */
	public String httpGet(String url) {
		
		return null;
	}
	
	/**
	 * Timeouts are new from JDK1.5, handle it generic for JDK1.4 compatibility.
	 * 
	 * @param connection
	 */
	private void setJdk15Timeouts(URLConnection connection) {
		try {
			Method readTimeoutMethod = connection.getClass().getMethod(
					"setReadTimeout", new Class[] { Integer.class });
			Method connectTimeoutMethod = connection.getClass().getMethod(
					"setConnectTimeout", new Class[] { Integer.class });
			if (readTimeoutMethod != null) {
				readTimeoutMethod.invoke(connection,
						new Object[] { new Integer(10000) });
				
			}
			if (connectTimeoutMethod != null) {
				connectTimeoutMethod.invoke(connection,
						new Object[] { new Integer(10000) });
				
			}
		} catch (Exception e) {
			// swallow silently
		}
	}
	
}
