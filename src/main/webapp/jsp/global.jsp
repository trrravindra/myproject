<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="csrf" uri="csrf-tags"%>

<%@ page session="false"%>

<%@ page
	import=" java.util.regex.Pattern,
				 java.util.Enumeration, 
				 java.util.Map"%>

<%@ page
	import=" org.springframework.context.support.ReloadableResourceBundleMessageSource, 
				 java.util.Locale"%>

<%@page import="com.lcl.erefill.core.constants.ERefillConstants"%>

<c:set var="currentPath"
	value='${requestScope["javax.servlet.forward.request_uri"]}' />

<c:choose>
	<c:when test="${fn:contains(currentPath, 'fr_CA')}">
		<c:set var="locale" value="fr_CA" />
		<c:set var="urlInFrench" value="${currentPath}" />
		<c:set var="urlInEnglish"
			value="${fn:replace(currentPath, 'fr_CA', 'en_CA')}" />
	</c:when>
	<c:otherwise>
		<c:set var="locale" value="en_CA" />
		<c:set var="urlInEnglish" value="${currentPath}" />
		<c:set var="urlInFrench"
			value="${fn:replace(currentPath, 'en_CA', 'fr_CA')}" />
	</c:otherwise>
</c:choose>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:choose>
	<c:when test="${fn:contains(currentPath, 'welcome')}">
		<c:set var="headerRedirectUrl"
			value="${contextPath}/home/${locale}/welcome" />
	</c:when>
	<c:otherwise>
		<c:set var="headerRedirectUrl"
			value="${contextPath}/${locale}/user/logout" />
	</c:otherwise>
</c:choose>

<%! 
	String locale=null;
	Locale localeObj = new Locale("en", "CA");
	ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=new ReloadableResourceBundleMessageSource(); 
%>


<%
	locale=(String)pageContext.getAttribute("locale"); 
	if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
		localeObj = new Locale("fr", "CA");
	}
	
	reloadableResourceBundleMessageSource.setBasename("classpath:/i18n/messages");
	String homePage = "/home/"+locale+"/welcome";
%>