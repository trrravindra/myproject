package com.lcl.erefill.core.listeners;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is used only to verify session activations in cluster.
 * @author deaswa
 *
 */
public class ErefillSessionActivationListener implements HttpSessionActivationListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(ErefillSessionActivationListener.class);
	
	/**
	 *  Method that will indicate a replication event and which will invalidate a session
	 */
	public void sessionWillPassivate(HttpSessionEvent se) {
		
		String sessionId = se.getSession().getId();
		//if( LOGGER.isDebugEnabled() ){
			
		LOGGER.info("##################################################");
		LOGGER.info("###########Session replication event starts##############");
		LOGGER.info("###########Session "+sessionId+" invalidated##############");
		LOGGER.info("###########Session replication event ends##############");
		//}
		
	}

	/**
	 * Method that will indicate a replication event
	 */
	public void sessionDidActivate(HttpSessionEvent se) {

		String sessionId = se.getSession().getId();
		//if( LOGGER.isDebugEnabled() ){
			
		LOGGER.info("##################################################");
		LOGGER.info("###########Session replication event starts##############");
		LOGGER.info("###########Session "+sessionId+" replicated##############");
		LOGGER.info("###########Session replication event ends##############");
		//}
		
	}

}
