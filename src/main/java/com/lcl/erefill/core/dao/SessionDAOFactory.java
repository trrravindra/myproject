package com.lcl.erefill.core.dao;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author vsha51
 */
public class SessionDAOFactory {

	@Value("${token.persistence.mechanism}")
	private String tokenPersistenceMechanism;

	public ISessionDAO getSessionDAO() {
		ISessionDAO sessionDAO = null;

		if (StringUtils.isNotBlank(tokenPersistenceMechanism)
				&& tokenPersistenceMechanism.equalsIgnoreCase("database")) {
			sessionDAO = DBSessionDAO.getInstance();
		} else {
			sessionDAO = InMemorySessionDAO.getInstance();
		}
		return sessionDAO;
	}
}
