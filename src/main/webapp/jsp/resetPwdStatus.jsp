<%@ include file="global.jsp"%>
<head>
<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />
<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>

<div class="content">
	<c:set var="userName" value="${userName}" />
	<c:set var="status" value="${status}" />
	<h1 class="title">
		<spring:message code="reset.password.page.title.label" />
	</h1>
	<!-- Username displayed When email not sent -->
	<c:if test="${'invalidEmail' == status}">
		<div class="group reverse">
			<p>
				<spring:message code="username.label" />
			</p>
			<p>${userName}</p>
		</div>
	</c:if>
	<!-- Username displayed When email not sent -->

	<div class="columns col2">
		<div class="column">
			<p>
				<c:choose>
					<c:when test="${'invalidEmail' == status}">
						<spring:message code="reset.pwd.mail.notsent.msg.label" />
					</c:when>
					<c:when test="${'mailSent' == status}">
						<spring:message code="reset.pwd.mail.sent.msg.label" />
					</c:when>
					<c:when test="${'success' == status}">
						<spring:message code="reset.pwd.success.msg.label"
							arguments="${contextPath}" />
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</p>
		</div>
	</div>

	<div class="navbottom">
		<a class="button-erefill green no-click"
			href="${contextPath}/${locale}/user/logout" role="button"> <spring:message
				code="back.to.home.link.label" />
		</a>
	</div>
</div>