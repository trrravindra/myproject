package com.lcl.erefill.core.utils.csrf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
 

 
/**
 * Creates a hidden input field with the CSRF Token
 * @author michael.simons, 2011-09-20
 */

@Configurable
@Component
public class CSRFTokenTag extends TagSupport {
	private static final long serialVersionUID = 745177955805541350L;
 
	private boolean plainToken = false;
 
	@Autowired
	CSRFTokenService csrfTokenService;
	
	@Override
	public int doStartTag() throws JspException {
		//final CSRFTokenService csrfTokenService = HelperRegistry.getHelper(super.pageContext.getServletContext(), super.pageContext.getRequest(), CSRFTokenService.class, "csrfTokenService");
		/*String token = (String) super.pageContext.getRequest().getParameter("name");
		 * 
*/		
		CSRFTokenService csrfTokenService = new CSRFTokenServiceImpl(); 
		final String token = csrfTokenService.getTokenFromSession((HttpServletRequest) super.pageContext.getRequest());
		if(!StringUtils.isBlank(token))
			try {
				if(plainToken)
					pageContext.getOut().write(token);
				else
					pageContext.getOut().write(String.format("<input type=\"hidden\" name=\"%1$s\" id=\"%1$s\" value=\"%2$s\" />", CSRFTokenService.TOKEN_PARAMETER_NAME, token));
			} catch (IOException e) {
			}
		return SKIP_BODY;
	}
 
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
 
	public boolean isPlainToken() {
		return plainToken;
	}
 
	public void setPlainToken(boolean plainToken) {
		this.plainToken = plainToken;
	}
 
	public static String getTokenParameterName() {
		return CSRFTokenService.TOKEN_PARAMETER_NAME;
	}
}