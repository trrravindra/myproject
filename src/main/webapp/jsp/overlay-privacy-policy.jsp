<%@ include file="global.jsp"%>
<%@ page
	import=" org.springframework.context.support.ReloadableResourceBundleMessageSource, 
				 java.util.Locale,org.springframework.web.util.UriUtils"%>

<%
	String requestUri = (String) request
			.getAttribute("javax.servlet.forward.request_uri");
	String locale = "";
	if (null != requestUri) {
		if (requestUri.contains("en_CA")) {
			locale = "en_CA";
		} else if (requestUri.contains("fr_CA")) {
			locale = "fr_CA";
		}
	}

	Locale localeObj = new Locale("en", "CA");
	if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
		localeObj = new Locale("fr", "CA");
	}
	ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
	reloadableResourceBundleMessageSource
			.setBasename("classpath:/i18n/messages");
	String tandcDesc = UriUtils.decode(
			reloadableResourceBundleMessageSource.getMessage(
					"registration.overlay.privacypolicy.description",
					null, localeObj), "UTF-8");
%>
<div class="overlay-wrap">
	<div class="inner disableinner">
		<div class="overlay">

			<h1 class="header">
				<div lang="en-ca" class="title">
					<spring:message code="registration.overlay.privacypolicy.title" />
				</div>
			</h1>
			<div class="content">
				<div class="width85">
					<%=tandcDesc%>
				</div>
				<!-- Your content goes here -->
				<a href="#" class="button-erefill green acceptclose"><spring:message
						code="close.label" /></a>
			</div>
			<a href="#" class="close">close</a>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>
