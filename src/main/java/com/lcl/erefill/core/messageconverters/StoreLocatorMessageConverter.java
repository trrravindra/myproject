package com.lcl.erefill.core.messageconverters;

import java.io.IOException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.lcl.erefill.core.vo.StoreLocatorJSONResponse;

public class StoreLocatorMessageConverter extends AbstractHttpMessageConverter<StoreLocatorJSONResponse>{

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreLocatorMessageConverter.class);
	
	public StoreLocatorMessageConverter( MediaType mediaType) {
		super(mediaType);
		LOGGER.debug("StoreLocator message converter initialized with media type");		
	}
	
	public StoreLocatorMessageConverter( MediaType... mediaTypes) {
		super(mediaTypes);
		LOGGER.debug("StoreLocator message converter initialized with media types");
	}
	
	public StoreLocatorMessageConverter() {
		LOGGER.debug("StoreLocator message converter initialized with media types");
	}
	
	
	
	@Override
	protected boolean supports(Class<?> clazz) {

		LOGGER.debug("StoreLocator message converter supports "+clazz+" : "+ clazz.getName().equalsIgnoreCase(StoreLocatorJSONResponse.class.getName()) );		
		if( clazz.getName().equalsIgnoreCase(StoreLocatorJSONResponse.class.getName())) {
			return true;
		}
		return false;
	}

	@Override
	protected StoreLocatorJSONResponse readInternal(
			Class<? extends StoreLocatorJSONResponse> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void writeInternal(StoreLocatorJSONResponse response,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {

		String jsonResponse = URLEncoder.encode( response.getResponse(), "UTF-8").replaceAll("\\+", "%20");
		outputMessage.getBody().write( jsonResponse.getBytes());
		
	}

}
