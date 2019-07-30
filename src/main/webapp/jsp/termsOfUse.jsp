<%@ include file="global.jsp"%>

<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details.js'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>

<div class="content">
	<div class="registration">
		<h1 class="title">
			<spring:message code="registration.title.label" />
		</h1>
		<spring:message code="registration.description.label" />
		<label class="registration-note"><span><spring:message
					code="registration.note.label" /></span>
		<spring:message code="registration.message.label" /></label>
		<%@include file="progressTracker.jsp"%>
	</div>

	<form class="form-details uniform form-validate form-terms"
		action="${contextPath}/${locale}/registration/termsofuse/subscribe"
		method="post">

		<h2 class="title">
			<spring:message code="registration.terms.of.use.title.label" />
		</h2>

		<div class="columns width75">
			<div class="row">
				<textarea class="terms" readonly="readonly">
	                                 ${agreeClause}
	            </textarea>
				<div class="terms-note">
					<spring:message code="registration.terms.of.use.scroll.label" />
				</div>
			</div>

			<!-- terms agree -->
			<div class="row">
				<label class="erefill-radio small alt"> <input
					type="checkbox" class="radio-agree" name="radio1" value="option1" />
					<spring:message code="registration.terms.of.use.agree.label" />
				</label>
			</div>
		</div>

		<hr class="invisible" />

		<!-- privacy -->
		<h2 class="title">
			<spring:message
				code="registration.terms.of.use.statement.title.label" />
		</h2>

		<div class="columns width75">
			<div class="row">
				<label class="erefill-check small alt"> <input
					type="checkbox" class="check-consent" /> <spring:message
						code="registration.terms.of.use.checkbox.label"
						arguments="${contextPath}" />
				</label>
			</div>
		</div>

		<div class="navbottom">
			<button class="button-erefill green" type="submit" disabled>
				<spring:message code="registration.continue.button.label" />
			</button>
			<label class="button-hint"> </label>
		</div>
		<input type="hidden" name="consentId" value="${consentId}" />
		<csrf:csrfToken />
	</form>



</div>