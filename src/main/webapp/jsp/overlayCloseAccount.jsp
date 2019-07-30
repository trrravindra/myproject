<%@ include file="global.jsp"%>

<div class="close-account">
	<div class="header">
		<h1 class="title">
			<spring:message code="my.account.close.account.overlay.title.label" />
		</h1>
	</div>

	<div class="inner-content">
		<form class="form-details uniform form-validate" method="post"
			action="${contextPath}/${locale}/myaccount/account/close">
			<p>
				<spring:message code="my.account.close.account.overlay.instruction" />
			</p>
			<button class="button-erefill green" type="submit"
				name="closeaccountpopup_button">
				<spring:message code="my.account.close.account.overlay.close.button" />
			</button>
			<a class="button-erefill link cancel" href="#" role="button"> <spring:message
					code="my.account.close.account.overlay.back.link" />
			</a>
			<csrf:csrfToken />
		</form>
	</div>
</div>
