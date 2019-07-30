<%@ include file="global.jsp"%>

<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details.js'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>

<div class="content">
	<div class="registration">
		<h1 class="title">
			<spring:message code="registration.title.label" />
		</h1>
		<%@include file="progressTracker.jsp"%>
	</div>

	<div class="width50">
		<div class="row subhead">
			<spring:message code="registration.success.text.label" />
		</div>
		${successEmailText}
	</div>

	<form action="${contextPath}/${locale}/user/login/success"
		method="post">
		<div class="navbottom">
			<button class="button-erefill green" type="submit">
				<spring:message code="registration.success.button.label" />
			</button>
		</div>
		<csrf:csrfToken />
	</form>
</div>