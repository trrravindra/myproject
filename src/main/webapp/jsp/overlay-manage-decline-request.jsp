<%@ include file="global.jsp"%>
<head>
<meta charset="utf-8">
</head>
<div class="custodian decline-being-custodian" role="dialog"
	tabIndex="0" aria-labelledby="overlayTitle"
	aria-describedby="overlayDesc">
	<div class="header" id="overlayTitle">
		<h1 class="title">
			<spring:message
				code="my.managed.account.decline.custodianship.overlay.title" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<p>
			<spring:message
				code="my.managed.account.decline.custodianship.overlay.description" />
		</p>
		<p>
			<spring:message code="my.managed.account.name.label" />
			:&nbsp;<strong>${name}</strong><br />
			<spring:message code="my.managed.account.relationship.label" />
			:&nbsp;<strong><spring:message code="${relationship}"
					text="${relationship}" /></strong>
		</p>
		<form class="form-details decline-request uniform"
			action="${contextPath}/${locale}/managedaccount/declineRequest"
			data-success-overlay="${contextPath}/${locale}/managedaccount/declineRequest/success"
			data-error-overlay="${contextPath}/${locale}/managedaccount/declineRequest/failure">
			<div class="err-msg"
				data-default-msg="The required fields below in red were not completed:"
				tabIndex="0">
				<ul>
				</ul>
			</div>
			<input type="hidden" name="requestorUserName" value="${username}" />
			<button class="button-erefill green" type="submit">
				<spring:message code="my.managed.account.decline.request.label" />
			</button>
			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="cancel.label" /></a>

			<csrf:csrfToken />
		</form>
	</div>
</div>