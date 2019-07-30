package com.lcl.erefill.core.dao;

import com.lcl.erefill.core.vo.ISession;

/**
 * @author vsha51
 */
public interface ISessionDAO {
	
	/**
	 * createSession
	 * 
	 * @param session
	 * @return 
	 */
	public void createSession (ISession session);
	
	/**
	 * readSession
	 * 
	 * @param session
	 * @return session
	 */
	public ISession readSession (ISession session);
	
	/**
	 * updateSession
	 * 
	 * @param session
	 * @return 
	 */
	public void updateSession (ISession session);
	
	/**
	 * deleteSession
	 * 
	 * @param session
	 * @return 
	 */
	public void deleteSession (ISession session);
}
