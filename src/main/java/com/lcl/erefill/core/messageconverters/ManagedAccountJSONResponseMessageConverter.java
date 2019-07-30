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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcl.erefill.core.vo.ManagedAccountJSONResponse;

public class ManagedAccountJSONResponseMessageConverter extends AbstractHttpMessageConverter<ManagedAccountJSONResponse>{

	private static final Logger logger = LoggerFactory
			.getLogger(MyAccountJSONResponseMessageConverter.class);

	public ManagedAccountJSONResponseMessageConverter() {
		logger.debug("[ManagedAccountJSONResponseMessageConverter] [ManagedAccountJSONResponseMessageConverter()] initialized");
	}

	public ManagedAccountJSONResponseMessageConverter(MediaType supportedMediaType) {

		super(supportedMediaType);
		logger.debug("[ManagedAccountJSONResponseMessageConverter] "
				+ supportedMediaType);
	}

	public ManagedAccountJSONResponseMessageConverter(
			MediaType... supportedMediaTypes) {
		super(supportedMediaTypes);
		logger.debug("[ManagedAccountJSONResponseMessageConverter]  "
				+ supportedMediaTypes);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		logger.debug("[ManagedAccountJSONResponseMessageConverter] [supports()] "
				+ clazz);
		if( clazz.getName().equalsIgnoreCase(ManagedAccountJSONResponseMessageConverter.class.getName())) {
			return true;
		}
		return false;
		
	}

	@Override
	protected ManagedAccountJSONResponse readInternal(Class<? extends ManagedAccountJSONResponse> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		logger.debug("[ManagedAccountJSONResponseMessageConverter] [readInternal] We dont want to use this.. This must be an error!!!");
		return null;
	}

	@Override
	protected void writeInternal(ManagedAccountJSONResponse response,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		logger.debug("[ManagedAccountJSONResponseMessageConverter] [writeInternal] ");

		if (!ModelAndView.class.getSimpleName().equals(
				response.getClass().getSimpleName())) {
			ObjectMapper mapper = new ObjectMapper();
			String returnString = null;
			try {
				returnString = URLEncoder.encode(
						mapper.writeValueAsString(response), "UTF-8")
						.replaceAll("\\+", "%20");
			} catch (Exception e) {
				logger.error("[ManagedAccountJSONResponseMessageConverter] [writeInternal] Error while converting object to JSON response.");
			}
			outputMessage.getBody().write(returnString.getBytes());
		}
	}
}
