<%@ include file="global.jsp"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="overlay-refill-request-success">

				<div class="header">
					<h1 class="title">
						<spring:message code="request.not.submitted.label" />
					</h1>
				</div>

				<div class="inner-content">

					<p>${error}</p>

					<a class="button-erefill green no-click"
						href="${contextPath}/${locale}/managedaccount/details" role="button"><spring:message
							code="continue.label" /></a>

				</div>

			</div>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>

