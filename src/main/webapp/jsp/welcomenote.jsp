

<h3 class="title">

	<c:set var="firstName" value="${firstName}" />
	<spring:message code="welcome.label" />
	<span> ${firstName}! </span> <a
		href="${contextPath}/${locale}/user/logout"><spring:message
			code="signout.label" /></a>
</h3>