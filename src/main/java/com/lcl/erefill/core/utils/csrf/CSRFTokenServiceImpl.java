package com.lcl.erefill.core.utils.csrf;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
@Component
public class CSRFTokenServiceImpl implements CSRFTokenService {
	
	private final SecureRandom random = new SecureRandom();
 
	private static final Logger LOGGER = LoggerFactory.getLogger(CSRFTokenServiceImpl.class);
	
	//private static CSRFTokenService service = new CSRFTokenServiceImpl();
	
	/*public CSRFTokenServiceImpl() {
		System.out.println( "csrf service initialized" );
	}*/
	
		public String generateToken() {
		final byte[] bytes = new byte[32];
		random.nextBytes(bytes);
		return Base64.encodeBase64URLSafeString(bytes);
	}
 
	public String getTokenFromSession(final HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		String userRole = (String) session.getAttribute("userRole");
		
		return userRole == null ? null : this.getTokenFromSessionImpl(session);
	}
 
	private String getTokenFromSessionImpl(final HttpSession session) {
		String token = null;
 
		if(session != null) {
			token = (String) session.getAttribute(TOKEN_ATTRIBUTE_NAME);
			if(StringUtils.isBlank(token))
				session.setAttribute(TOKEN_ATTRIBUTE_NAME, (token = generateToken()));
		}
		return token;
	}
 
	public boolean acceptsTokenIn(HttpServletRequest request) {
		boolean rv = false;
 
		// Token is only verified if principal is not null
		HttpSession session = request.getSession(false);
		String userRole=null;
		if(session!=null){
			userRole = (String) session.getAttribute("userRole");
		}else{
			LOGGER.info(">>>>>> Session is null");
		}
		if( userRole == null ) {
			LOGGER.info(">>>>>> userRole is null");
			rv = true;
		} else {
			String token;
			if(request.getHeader(TOKEN_PARAMETER_NAME)!=null){
				token = request.getHeader(TOKEN_PARAMETER_NAME);
				LOGGER.info(">>>>>> getting token from request HEADER");
				
			}else{
				token = request.getParameter(TOKEN_PARAMETER_NAME);
				LOGGER.info(">>>>>> getting token from request PARAMETER");
			}
			
			LOGGER.info(">>>>>> token from request: "+token);
			LOGGER.info(">>>>>> token from session: "+this.getTokenFromSessionImpl(session));
			if(this.getTokenFromSessionImpl(session).equals(token)){
				LOGGER.info(">>>>>> tokens matched");
			}
			rv = session != null && this.getTokenFromSessionImpl(session).equals(token);
		}
		
		return rv;
	}
}
