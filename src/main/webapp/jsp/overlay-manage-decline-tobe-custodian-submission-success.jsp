<%@ include file="global.jsp"%>
<head>
<meta charset="utf-8">
</head>
<div class="custodian accept-being-custodian" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.decline.custodianship.successoverlay.title" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<form class="form-details uniform mysuccess"
			action="${contextPath}/${locale}/managedaccount/details">
			<div class="err-msg"
				data-default-msg="The required fields below in red were not completed:"
				tabIndex="0">
				<ul>
				</ul>
			</div>
			<p>
				<spring:message
					code="my.managed.account.decline.custodianship.successoverlay.description" />
			</p>
			<button class="button-erefill green" type="submit">
				<spring:message code="continue.label" />
			</button>
			<csrf:csrfToken />
		</form>
	</div>
</div>