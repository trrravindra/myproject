package com.lcl.erefill.core.dao;

import com.lcl.erefill.core.vo.ISession;


/**
 * @author vsha51
 */
public class DBSessionDAO extends AbstractSessionDAO {

	private static ISessionDAO sessionDAO = new DBSessionDAO();   

	/**
	 * Private constructor
	 */
	private DBSessionDAO(){}
	
	/**
	 * getInstance
	 * @return sessionDAO
	 */
	public static ISessionDAO getInstance() {
	    return sessionDAO;
    }
	
	/**
	 * createSession
	 * 
	 * @param session
	 * @return 
	 */
	public void createSession(ISession session) {
		
	}

	/**
	 * readSession
	 * 
	 * @param session
	 * @return session
	 */
	public ISession readSession(ISession session) {
		return null;
	}

	/**
	 * updateSession
	 * 
	 * @param session
	 * @return 
	 */
	public void updateSession(ISession session) {
		
	}

	/**
	 * deleteSession
	 * 
	 * @param session
	 * @return 
	 */
	public void deleteSession(ISession session) {
		
	}	
}
