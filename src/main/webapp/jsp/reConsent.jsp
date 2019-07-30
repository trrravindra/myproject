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

<div class="page sidebar-left-layout page-refill-request page-reconsent">
	<div class="content display">

		<form class="form-details uniform form-validate form-terms"
			action="${contextPath}/${locale}/registration/termsofuse/subscribe"
			method="post">
			<h1 class="title title-reconsent">
				<spring:message code="reconsent.title.label" />
			</h1>

			<p class="descrp">
				<spring:message code="reconsent.description.label" />
			</p>

			<h4 class="subhead-four">
				<spring:message code="reconsent.terms.of.use.label" />
			</h4>

			<div class="scroll"
				bind-html-translate-compile="reconsent.agree.terms.of.user.paragraph">
				<div class="para">${agreeClause}</div>
			</div>
			<div class="checkbox-item">
				<input type="checkbox" name="agree" class="agree"> <span>
					<spring:message code="reconsent.read.and.agree.label" />
				</span>

			</div>

			<button type="submit"
				class="button-erefill reconsent green refill-submit" disabled="">
				<spring:message code="reconsent.continue.to.my.prescriptions" />
			</button>
			<input type="hidden" name="consentId" value="${consentId}" />
			<csrf:csrfToken />
		</form>

		<p class="cancel">
			<a href="${contextPath}/${locale}/reconsent/confirmReconsentCancel"><spring:message
					code="cancel.label" /></a>
		</p>

	</div>
</div>