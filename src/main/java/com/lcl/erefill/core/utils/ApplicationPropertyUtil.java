/**
 * 
 */
package com.lcl.erefill.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurablePropertyResolver;

/**
 * @author dhirwa
 *
 */
public class ApplicationPropertyUtil extends
		PropertySourcesPlaceholderConfigurer {
	
	private static ConfigurablePropertyResolver propertyResolver;

	/* (non-Javadoc)
	 * @see org.springframework.context.support.PropertySourcesPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, org.springframework.core.env.ConfigurablePropertyResolver)
	 */
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			ConfigurablePropertyResolver propertyResolver)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, propertyResolver);
		ApplicationPropertyUtil.propertyResolver = propertyResolver;
	}
	
	public static String getProperty(String name) {
        return ApplicationPropertyUtil.propertyResolver.getProperty(name);
    }

}
