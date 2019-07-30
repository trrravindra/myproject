<%@ include file="global.jsp"%>

<%@ page import="java.util.Locale,org.springframework.web.util.UriUtils"%>

<c:set var="locale" value="${locale}"></c:set>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-general'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
<%
String requestUri = (String)request.getAttribute("javax.servlet.forward.request_uri");	
String locale = "";
	if (null != requestUri) {	
		if(requestUri.contains("en_CA")){
			locale="en_CA";					
		}else if(requestUri.contains("fr_CA")){
			locale="fr_CA";				
		}
	}
		
Locale localeObj = new Locale("en", "CA");
if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
	localeObj = new Locale("fr", "CA");
}
ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=new ReloadableResourceBundleMessageSource(); 
reloadableResourceBundleMessageSource.setBasename("classpath:/i18n/messages");	
String tandcDesc = UriUtils.decode(reloadableResourceBundleMessageSource.getMessage("terms.of.use.content", null, localeObj),"UTF-8"); 
%>
<div class="content">
	<div class="width85">

		<h1 class="title">
			<spring:message code="terms.of.use.content.main.title" />
		</h1>

		<div class="user-generated-content">
			<%=tandcDesc%>
			<%-- <p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.main.para.1"/></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.main.para.2"/></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">&nbsp;<b><u><spring:message code="terms.of.use.content.main.para.3"/></u></b></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b>terms.of.use.content.sub.title.1</b></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.other.functionality.title"/></p>

		<ul style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">
			<li><spring:message code="terms.of.use.content.other.functionality.1"/></li>
			<li><spring:message code="terms.of.use.content.other.functionality.2"/></li>
			<li><spring:message code="terms.of.use.content.other.functionality.3"/></li>
			<li><spring:message code="terms.of.use.content.other.functionality.4"/></li>
			<li><spring:message code="terms.of.use.content.other.functionality.5"/></li>
		</ul>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.site.functionality.title"/></p>
			<ul style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">
			<li><spring:message code="terms.of.use.content.site.functionality.1"/></li>
			<li><spring:message code="terms.of.use.content.site.functionality.2"/></li>
			</ul>
	
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.site.functionality.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.site.functionality.para.2"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.2"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.2.para.1"/></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.3"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.3.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.3.para.2"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.3.para.3"/></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.4"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.4.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.4.para.2"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.5"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.5.para.1"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.6"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.6.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.6.para.2"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.6.para.3"/></p>
			<ul>
				<li><spring:message code="terms.of.use.content.sub.title.6.para.3.list.1"/></li>
				<li><spring:message code="terms.of.use.content.sub.title.6.para.3.list.2"/></li>
				<li><spring:message code="terms.of.use.content.sub.title.6.para.3.list.3"/></li>
			</ul>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.6.para.4"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.7"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.7.para.1"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.8"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.8.para.1"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.9"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.9.para.1"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.10"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.10.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.10.para.2"/></p>

		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.11"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.11.para.1"/></p>
		
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.12"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.12.para.1"/></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.12.para.2"/></p>
	
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><b><spring:message code="terms.of.use.content.sub.title.13"/></b></p>
		<p style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;"><spring:message code="terms.of.use.content.sub.title.13.para.1"/></p>
		 --%>


		</div>

	</div>

</div>
