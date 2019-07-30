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
import com.lcl.erefill.core.vo.MyAccountJSONResponse;

/**
 * @author vsha51
 */
public class MyAccountJSONResponseMessageConverter extends
		AbstractHttpMessageConverter<MyAccountJSONResponse> {

	private static final Logger logger = LoggerFactory
			.getLogger(MyAccountJSONResponseMessageConverter.class);

	public MyAccountJSONResponseMessageConverter() {
		logger.debug("[MyAccountJSONResponseMessageConverter] [MyAccountJSONResponseMessageConverter()] initialized");
	}

	public MyAccountJSONResponseMessageConverter(MediaType supportedMediaType) {

		super(supportedMediaType);
		logger.debug("[MyAccountJSONResponseMessageConverter] "
				+ supportedMediaType);
	}

	public MyAccountJSONResponseMessageConverter(
			MediaType... supportedMediaTypes) {
		super(supportedMediaTypes);
		logger.debug("[MyAccountJSONResponseMessageConverter]  "
				+ supportedMediaTypes);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		logger.debug("[MyAccountJSONResponseMessageConverter] [supports()] "
				+ clazz);
		if( clazz.getName().equalsIgnoreCase(MyAccountJSONResponseMessageConverter.class.getName())) {
			return true;
		}
		return true;
	}

	@Override
	protected MyAccountJSONResponse readInternal(Class<? extends MyAccountJSONResponse> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		logger.debug("[MyAccountJSONResponseMessageConverter] [readInternal] We dont want to use this.. This must be an error!!!");
		return null;
	}

	@Override
	protected void writeInternal(MyAccountJSONResponse response,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		logger.debug("[MyAccountJSONResponseMessageConverter] [writeInternal] ");

		if (!ModelAndView.class.getSimpleName().equals(
				response.getClass().getSimpleName())) {
			ObjectMapper mapper = new ObjectMapper();
			String returnString = null;
			try {
				returnString = URLEncoder.encode(
						mapper.writeValueAsString(response), "UTF-8")
						.replaceAll("\\+", "%20");
			} catch (Exception e) {
				logger.error("[MyAccountJSONResponseMessageConverter] [writeInternal] Error while converting object to JSON response.");
			}
			outputMessage.getBody().write(returnString.getBytes());
		}
	}
}
