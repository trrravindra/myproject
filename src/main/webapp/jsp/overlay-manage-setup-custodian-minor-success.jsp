<%@ include file="global.jsp"%>

<head>
<meta charset="utf-8">
</head>
<div class="overlay-refill-request-success" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.accept.custodianship.successoverlay.title" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<p>
			<spring:message
				code="my.managed.account.accept.custodianship.successoverlay.description" />
		</p>
		<a class="button-erefill green no-click"
			href="${contextPath}/${locale}/managedaccount/details" role="button"><spring:message
				code="continue.label" /></a>
	</div>
</div>