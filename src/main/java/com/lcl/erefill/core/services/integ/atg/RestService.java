package com.lcl.erefill.core.services.integ.atg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.utils.CommonUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@Service
public final class RestService {
	
	private static final Logger log = LoggerFactory.getLogger(RestService.class);

	@Autowired
	private static Client atgClient;
	
	public static String executeService(final String baseURL,
			final String serviceURL, final String userName,
			final String password,final String proxyServer,final String proxyServerPort) throws ERefillBusinessException{

		long startTime = System.currentTimeMillis();
		if (!CommonUtils.isNullOrBlank(proxyServer) && !CommonUtils.isNullOrBlank(proxyServerPort)) {
			log.debug("Creating the rest client with Proxy");
			/*System.setProperty("http.proxyHost", proxyServer);
	        System.setProperty("http.proxyPort", proxyServerPort);*/
		}
		
        StringBuffer url = new StringBuffer();
		if (null != baseURL)
			url.append(baseURL);
		if (null != serviceURL)
			url.append(serviceURL);
		if (null != userName && null != password) {
			HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(userName,
					password);
			atgClient.addFilter(authFilter);
			//atgClient.setConnectTimeout(Integer.parseInt("30000"));
			//atgClient.setReadTimeout(Integer.parseInt("30000"));
			
			
		}
		WebResource webResource = atgClient.resource(url.toString());
		ClientResponse response;
		try {
			response = webResource
					.accept(ERefillConstants.JERSEY_RESOURCE_TYPE).get(
							ClientResponse.class);
			long endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;
			log.debug("time taken for rest service ::: "+ timeTaken);
			if (response.getStatus() != 200) {
				throw new ERefillBusinessException("ATG response error "+response.getStatus() );
			}
		} catch (ClientHandlerException che) {
			long endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;
			log.debug("time taken for rest service ::: "+timeTaken);
			throw new ERefillBusinessException("Error while trying to get response from ATG "+che.getMessage(),che);
		}
		
		String strTemp = response.getEntity(String.class);
		String strRetVal = CommonUtils.formatStringInUTF8(strTemp);
		return strRetVal;
	}

	@Autowired
	public void setAtgServiceClient(Client atgClient) {
		RestService.atgClient = atgClient;
	}
}
