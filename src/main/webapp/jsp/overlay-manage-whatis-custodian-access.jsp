<%@ include file="global.jsp"%>

<head>
<meta charset="utf-8">
</head>
<div class="custodian grant-access" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">

	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message code="what.is.custodianship.label" />
		</h1>
	</div>

	<div class="inner-content" id="overlayDesc">
		<spring:message code="custodianship.desc.label" />

		<br />
		<br /> <a class="button-erefill green cancel-custodian" href="#" role="button"><spring:message
				code="close.button.label" /></a>


	</div>

</div>



