<%@ include file="global.jsp"%>
<head>
<meta charset="utf-8">
</head>

<div class="custodian accept-being-custodian" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.grant.custodianship.successoverlay.title" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<form class="form-details uniform mysuccess"
			action="${contextPath}/${locale}/managedaccount/details">
			<p>
				<spring:message
					code="my.managed.account.grant.custodianship.successoverlay.description" />
			</p>
			<button class="button-erefill green" type="submit">
				<spring:message code="continue.label" />
			</button>
			<csrf:csrfToken />
		</form>
	</div>
</div>