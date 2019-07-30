package com.lcl.erefill.core.dao;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;
import com.lcl.erefill.core.vo.UserSession;

/**
 * @author vsha51
 */
public class InMemorySessionDAO extends AbstractSessionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(InMemorySessionDAO.class);

	private static ISessionDAO sessionDAO = new InMemorySessionDAO();  

	/**
	 * Private constructor
	 */
	private InMemorySessionDAO(){}
	
	/**
	 * getInstance
	 * @return sessionDAO
	 */
	public static ISessionDAO getInstance() {
	    return sessionDAO;
    }
	
	/**
	 * createSession - Creates the current user's session info in http session
	 * 
	 * @param session
	 * @return 
	 */
	public void createSession(ISession session) {
		ERefillSession eRefillSession = (ERefillSession) session;
		try {
			UserSession userSession = (UserSession) eRefillSession
					.getAttribute(ERefillConstants.MAP_KEY_USER);
			HttpSession httpSession = (HttpSession) eRefillSession
					.getAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION);
			httpSession
					.setAttribute(ERefillConstants.MAP_KEY_USER, userSession);
		} catch (Exception e) {
			logger.error("Error occured while creating session: ", e);
		}
	}

	/**
	 * readSession
	 * 
	 * @param session
	 * @return eRefillSession
	 */
	public ISession readSession(ISession session) {
		ERefillSession eRefillSession = (ERefillSession) session;
		UserSession userSession = null;

		try {
			HttpSession httpSession = (HttpSession) eRefillSession
					.getAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION);
			if(httpSession!=null){
				userSession = (UserSession) httpSession.getAttribute(ERefillConstants.MAP_KEY_USER);
				if( userSession != null){	
					eRefillSession.addAttribute(ERefillConstants.MAP_KEY_USER, userSession);
				}
			}
		} catch (IllegalStateException ise){
			return null;
		} catch (Exception e) {
			logger.error("Error occured while reading session: ", e);
			return null;
		}
		return eRefillSession;
	}

	/**
	 * updateSession - Updates the current user's session details in http session
	 * 
	 * @param session
	 * @return 
	 */
	public void updateSession(ISession session) {
		this.createSession(session);
	}

	/**
	 * deleteSession - Invalidates the http session
	 * 
	 * @param session
	 * @return 
	 */
	public void deleteSession(ISession session) {
		ERefillSession eRefillSession = (ERefillSession) session;
		try {
			HttpSession httpSession = (HttpSession) eRefillSession
					.getAttribute(ERefillConstants.MAP_KEY_HTTP_SESSION);
			httpSession.invalidate();
		} catch (IllegalStateException ise){
			logger.error("IllegalStateException. Do nothing ");
		} catch (Exception e) {
			logger.error("Error occured while deleting session: ", e);
		}
	}
}
