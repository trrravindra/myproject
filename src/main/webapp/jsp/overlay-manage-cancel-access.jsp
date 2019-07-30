<%@ include file="global.jsp"%>
<head>
<meta charset="utf-8">
</head>
<div class="custodian cancel-access" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">

	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.cancel.custodianship.overlay.title" />
		</h1>
	</div>

	<div class="inner-content" id="overlayDesc">

		<p>
			<spring:message
				code="my.managed.account.cancel.custodianship.overlay.description" />
		</p>

		<p>
			<spring:message code="my.managed.account.name.label" />
			:&nbsp;<strong>${name}</strong><br />
		</p>

		<p>
			<spring:message code="my.managed.account.relationship.label" />
			:&nbsp;<strong><spring:message code="${relationship}"
					text="${relationship}" /></strong><br />
		</p>

		<form class="form-details revoke-access uniform"
			action="${contextPath}/${locale}/managedaccount/revokeAccess"
			data-success-overlay="${contextPath}/${locale}/managedaccount/revokeAccess/success"
			data-error-overlay="${contextPath}/${locale}/managedaccount/revokeAccess/failure"
			method="post">
			<div class="err-msg"
				data-default-msg="<spring:message code='my.managed.account.custodianship.required.error.msg' />"
				tabIndex="0">
				<ul>
				</ul>
			</div>
			<input type="hidden" name="managedUserName"
				value="${managerUserName}" /> <input type="hidden"
				name="managerUserName" value="${username}" /> <input type="hidden"
				name="requestType" value="cancel" /> <input type="hidden"
				value="on" name="notify-custodian" />

			<button class="button-erefill green" type="submit">
				<spring:message
					code="my.managed.account.revoke.custodianship.overlay.button.label" />
			</button>

			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="cancel.label" /></a>
			<csrf:csrfToken />
		</form>
	</div>
</div>