<%@ include file="global.jsp"%>

<%@ page import="java.util.Locale,org.springframework.web.util.UriUtils"%>

<%
String tandcDesc = UriUtils.decode(reloadableResourceBundleMessageSource.getMessage("my.managed.account.minor.custodianship.overlay.termsconditions.description", null, localeObj),"UTF-8");
%>

<div class="terms-of-use">
	<div class="header">
		<h1 class="title">
			<spring:message code="my.account.terms.of.use.overlay.title.label" />
		</h1>
	</div>
	<div class="inner-content">
		<textarea class="terms" readonly="readonly">
		 <%=tandcDesc%>
		</textarea>
		<a class="button-erefill green cancel" href="#" role="button"> <spring:message
				code="my.account.terms.of.use.overlay.close.button" />
		</a> <a class="button-erefill green modal" href="#"
			data-modal="${contextPath}/${locale}/myaccount/consent/revoke/view" role="button">
			<spring:message code="my.account.terms.of.use.overlay.link" />
		</a>
	</div>
</div>
