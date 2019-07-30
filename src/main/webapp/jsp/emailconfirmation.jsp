<%@ include file="global.jsp"%>

<div class="content">
	<h1 class="title">
		<spring:message code="registration.confirm.email.label" />
	</h1>
	<div class="columns col2">
		<div class="column">
			<c:choose>
				<c:when
					test="${'invalidkey' eq strStatus || 'cancelled' eq strStatus || 'AlreadyConfirmed' eq strStatus}">
					<spring:message code="registration.confirm.email.invalid.message" />
				</c:when>
				<c:otherwise>
					<spring:message code="registration.confirm.email.description.text" />
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div class="navbottom">
		<a href="${contextPath}/${locale}/user/logout"
			class="button-erefill green no-click"> <spring:message
				code="registration.confirm.email.back.button.label" />
		</a>
	</div>
</div>