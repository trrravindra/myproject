package com.lcl.erefill.core.web.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lcl.erefill.core.messageconverters.ManagedAccountJSONResponseMessageConverter;
import com.lcl.erefill.core.messageconverters.MyAccountJSONResponseMessageConverter;
import com.lcl.erefill.core.messageconverters.StoreLocatorMessageConverter;
import com.lcl.erefill.core.web.interceptors.CSRFInterceptor;
import com.lcl.erefill.core.web.interceptors.MetricInterceptor;
import com.lcl.erefill.core.web.interceptors.PathVariableLocaleChangeInterceptor;
import com.lcl.erefill.core.web.interceptors.XSSInterceptor;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Value("${erefill.security.enable}")
	private String isSecurityEnabled;
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> httpMessageConverters) {
		httpMessageConverters.add(new StoreLocatorMessageConverter(
				new MediaType("text", "plain")));
		httpMessageConverters
				.add(new ManagedAccountJSONResponseMessageConverter(
						new MediaType("text", "plain")));
		httpMessageConverters.add(new MyAccountJSONResponseMessageConverter(
				new MediaType("text", "plain")));

		httpMessageConverters.add(new MappingJackson2HttpMessageConverter());

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if(Boolean.valueOf(isSecurityEnabled)){
			registry.addInterceptor(new XSSInterceptor());
			registry.addInterceptor(new CSRFInterceptor());
		}
		registry.addInterceptor(new MetricInterceptor());
		registry.addInterceptor(new PathVariableLocaleChangeInterceptor());
		
	}
	
	
	@Override
	public void addResourceHandlers( ResourceHandlerRegistry resourceRegistry ) {
		
		//resourceRegistry.addResourceHandler( "/resources/**" ).addResourceLocations("/resources/webassets/");
	}
}
