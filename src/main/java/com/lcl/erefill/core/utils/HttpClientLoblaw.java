package com.lcl.erefill.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

//import org.owasp.esapi.Logger;
import org.slf4j.LoggerFactory;


import net.tanesha.recaptcha.ReCaptchaException;
import net.tanesha.recaptcha.http.SimpleHttpLoader;

	public class HttpClientLoblaw extends SimpleHttpLoader {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HttpClientLoblaw.class);
	
	private boolean isLclProxyEnabled;
	private String proxyHost;
	private int proxyPort;
	private String lclProxyUser;
	private String proxyPass;
	

    
	public HttpClientLoblaw(boolean isLclProxyEnabled, String proxyHost, int proxyPort, String lclProxyUser, String proxyPass){
		LOGGER.info("Entering Test Class after adding params11");
		
		
		
	this.isLclProxyEnabled = isLclProxyEnabled;		
    	this.proxyHost = proxyHost;
    	this.proxyPort = proxyPort;
    	this.lclProxyUser = lclProxyUser;
    	this.proxyPass = proxyPass;
		
    	LOGGER.info("In SimpleProxyHttpLoader contructor " + "isLclProxyEnabled :: " + isLclProxyEnabled + " proxyHost :: " + proxyHost + " proxyPort :: " + proxyPort
				+" lclProxyUser :: " + lclProxyUser + " proxyPass :: " + proxyPass);
	}
	
	public String httpPost(String urlS, String postdata) {
		InputStream in = null;
		URLConnection connection = null;
		try {
			URL url = new URL(urlS);
			
			LOGGER.info("Opening the port for the url :: " + url);
			if (this.isLclProxyEnabled) {
				LOGGER.info("Proxy is enabled");
				SocketAddress addr = new InetSocketAddress(this.proxyHost, this.proxyPort);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
				LOGGER.info("Host and port :: " + this.proxyHost + " " + this.proxyPort);
				connection = url.openConnection(proxy);
				LOGGER.info("Opened the connection using proxy");
			} else {
				LOGGER.info("Proxy is disabled");
				connection = url.openConnection();
				LOGGER.info("Opened the connection without using proxy");
			}
			LOGGER.info("Opened the port for the url");

			connection.setDoOutput(true);
			LOGGER.info("Connection DoOutput set to ture");
			connection.setDoInput(true);
			LOGGER.info("Connection DoInput set to ture");

			setJdk15Timeouts(connection);

			OutputStream out = connection.getOutputStream();
			out.write(postdata.getBytes());
			out.flush();

			in = connection.getInputStream();

			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			while (true) {
				int rc = in.read(buf);
				if (rc <= 0) {
					break;
				}
				else {
					bout.write(buf, 0, rc);
				}
			}

			out.close();
			in.close();

			// return the generated javascript.
			return bout.toString();
		} catch (IOException e) {
			throw new ReCaptchaException("Cannot load URL: " + e.getMessage(),
					e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
				// swallow.
			}
		}
	}
	
	/**
	 * This method triggers a call to the Recaptcha siteVerify API and returns the boolean value of the "success" key from the json response.
	 * 
	 * @param reCaptchaURL
	 * @param postdata
	 * @return boolean 
	 */
	public boolean httpPostRequest(String reCaptchaURL, String postdata) {
		
		LOGGER.info("Entering httpPostRequest()");
		boolean captchaServiceResponse = false;
		URLConnection connection = null;		
		LOGGER.info("{}{}url-->"+reCaptchaURL+"{}{}postdata-->"+postdata);
		
		try {
			URL url = new URL(reCaptchaURL);
						
			if (this.isLclProxyEnabled) {
				LOGGER.info("Proxy is enabled");
				SocketAddress addr = new InetSocketAddress(this.proxyHost, this.proxyPort);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
				LOGGER.info("Host and port :: " + this.proxyHost + " " + this.proxyPort);
				connection = url.openConnection(proxy);
				LOGGER.info("Opening the connection using proxy");
			} else {
				LOGGER.info("Proxy is diabled");
				connection = url.openConnection();
				LOGGER.info("Opening the connection without using proxy");
			}
			
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setDoOutput(true);
			LOGGER.info("Connection set to true for DoOutput");
			setJdk15Timeouts(connection);
			// Get the output stream of Connection
			// Write data in this stream, which means to send data to Server.
			OutputStream outStream = connection.getOutputStream();
			outStream.write(postdata.getBytes());
			outStream.flush();
			outStream.close();
			
			// Get the InputStream from Connection to read data sent from the server.
			InputStream is = connection.getInputStream();
			StringBuilder sbuffer = new StringBuilder();
			int charsInput;
			while((charsInput = is.read()) != -1){
				sbuffer.append((char)charsInput);
			}
			String gCaptchaResponse = sbuffer.toString();
			LOGGER.info("GoogleCaptcha Response : "+gCaptchaResponse);
			
			try {
				JSONObject jsonObj = null; 
				jsonObj = new JSONObject(gCaptchaResponse);
				if(jsonObj!=null){
					LOGGER.info("Parsing JSON Response from Google"+ jsonObj.toString());
					captchaServiceResponse = jsonObj.get("success")!= null ?  (Boolean)jsonObj.get("success"): false;
					LOGGER.info("Captcha validation ? "+ captchaServiceResponse);
				}
			} catch (JSONException jsonExp) {
				LOGGER.error("Json exception : "+jsonExp.getStackTrace());
			}
		} catch (Exception e) {
			LOGGER.error("Exception in httpPostRequest"+e.getStackTrace());
		} 
		return captchaServiceResponse;
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
				LOGGER.info("Set timeout.");
			}
			if (connectTimeoutMethod != null) {
				connectTimeoutMethod.invoke(connection,
						new Object[] { new Integer(10000) });
				LOGGER.info("Set timeout.");
			}
		} catch (Exception e) {
			// swallow silently
		}
	} 
}