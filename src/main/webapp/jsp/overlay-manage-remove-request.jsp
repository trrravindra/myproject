<%@ include file="global.jsp"%>
<!--<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">-->
<head>
<meta charset="utf-8">
</head>
<div class="custodian remove-request">

	<div class="header">
		<h1 class="title">
			<spring:message
				code="my.managed.account.removerequest.custodianship.overlay.title" />
		</h1>
	</div>

	<div class="inner-content">

		<p>
			<spring:message code="my.managed.account.name.label" />
			:&nbsp;<strong>${name}</strong><br />
			<spring:message code="my.managed.account.relationship.label" />
			:&nbsp;<strong><spring:message code="${relationship}"
					text="${relationship}" /></strong>
		</p>

		<form class="form-details remove-request uniform"
			action="${contextPath}/${locale}/managedaccount/revokeAccess"
			data-success-overlay="${contextPath}/${locale}/managedaccount/revokeAccess/success"
			data-error-overlay="${contextPath}/${locale}/managedaccount/revokeAccess/failure"
			method="post">
			<div class="err-msg"
				data-default-msg="<spring:message code='my.managed.account.custodianship.required.error.msg' />">
				<ul>
				</ul>
			</div>

			<div class="row">
				<label class="erefill-check small"> <input type="checkbox"
					name="notify-custodian" class="notify-custodian" /> <spring:message
						code="my.managed.account.removerequest.custodianship.overlay.notifyemail" />

				</label>
			</div>

			<input type="hidden" name="managedUserName" value="${username}" /> <input
				type="hidden" name="managerUserName" value="${managerUserName}" />
			<input type="hidden" name="requestType" value="remove" />
			<button class="button-erefill green" type="submit">
				<spring:message
					code="my.managed.account.removerequest.custodianship.overlay.button.label" />
			</button>

			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="cancel.label" /></a>
			<csrf:csrfToken />

		</form>

	</div>

</div>
<!--
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>-->